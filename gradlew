package com.shuttle.dailyshuttlenew.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shuttle.dailyshuttlenew.Constants.ApplicationConstants;
import com.shuttle.dailyshuttlenew.Parser;
import com.shuttle.dailyshuttlenew.R;
import com.shuttle.dailyshuttlenew.VolleyMethods;
import com.shuttle.dailyshuttlenew.VolleyRequest;
import com.shuttle.dailyshuttlenew.WebResponseListner;
import com.shuttle.dailyshuttlenew.adapter.StoppageListAdapter;
import com.shuttle.dailyshuttlenew.common.Utility;
import com.shuttle.dailyshuttlenew.model.StopageModel;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TrackingActivity extends AppCompatActivity implements OnMapReadyCallback, WebResponseListner, LocationListener {
private static final String TAG="track";

    private static final int REQUEST_LOCATION = 111;
    private GoogleMap mGoogleMap;
    private String bus_id;
    private String gps_device_id;
    private String Bus_number;
    private String bus_shedule_id;
    private String route_id;
    private GoogleApiClient googleApiClient;
    private Marker userMarker;
    private Marker busMarker;
    private Timer timerGetLocation;
    private boolean isFirstTime = false;
    private long LOC_REQUEST_TIME = 30 * 1000;
    private VolleyMethods volleyMethods = null;
    private VolleyRequest volleyRequest = null;
    BitmapDescriptor bmp = null;
    private ImageView imgVwCodeLare = null;
    private ArrayList<Marker> markers= null;
    private static RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AppLog.enter(TAG,AppLog.getMethodName());
        setContentView(R.layout.activity_tracking);
        bus_id = getIntent().getStringExtra("bus_id");
        gps_device_id = getIntent().getStringExtra("gps_device_id");
        Bus_number = getIntent().getStringExtra("Bus_number");
        route_id = getIntent().getStringExtra("route_id");
        bus_shedule_id = getIntent().getStringExtra("bus_shedule_id");
        imgVwCodeLare = findViewById(R.id.iv_codelare);
        volleyMethods = new VolleyMethods();
        volleyRequest = VolleyRequest.getvolleyRequest();
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mGoogleMap);
        supportMapFragment.getMapAsync(this);

        checkLocPermission();
        bmp = bitmapDescriptorFromVector(thi