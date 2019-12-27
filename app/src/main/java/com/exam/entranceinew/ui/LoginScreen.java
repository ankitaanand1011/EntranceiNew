package com.exam.entranceinew.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.entranceinew.MainActivity;
import com.exam.entranceinew.R;


public class LoginScreen extends AppCompatActivity {
    TextView login_tv, signup_tv, tv_forgot_password;
    String TAG = "login";
   /* GlobalClass globalClass;
    Shared_Prefrence shared_prefrence;
    CatLoadingView mView;*/
    EditText email_edt,password_edt;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);


/*
        globalClass = (GlobalClass)getApplicationContext();
        shared_prefrence = new Shared_Prefrence(this);
        shared_prefrence.loadPrefrence();

        mView = new CatLoadingView();
        mView.setText("      Loading");*/



        login_tv = findViewById(R.id.login_tv);
        signup_tv = findViewById(R.id.signup_tv);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);


      /*  if(globalClass.getLogin_status()){

            Intent intent = new Intent(LoginScreen.this, Dashboard.class);
            startActivity(intent);
            finish();
        }*/

        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(intent);
               /* Intent intent = new Intent(LoginScreen.this, Dashboard.class);
                startActivity(intent);*/


/*
                if (globalClass.isNetworkAvailable()){

                    if(!email_edt.getText().toString().trim().isEmpty()) {
                        if (!password_edt.getText().toString().trim().isEmpty()) {
                            if (email_edt.getText().toString().matches(emailPattern)) {
                                checkLogin(email_edt.getText().toString(),password_edt.getText().toString());
                            }else {

                                Toasty.error(LoginScreen.this,"Invalid email address.",Toast.LENGTH_LONG,true).show();}

                        }else {

                            Toasty.warning(LoginScreen.this,"Please enter the password.",Toast.LENGTH_LONG,true).show();}
                    }else {

                        Toasty.warning(LoginScreen.this,"Please enter the email id.",Toast.LENGTH_LONG,true).show();}

                }else {




                    Toasty.info(LoginScreen.this,"Check your internet connection.",Toast.LENGTH_LONG,true).show();

                }*/
            }
        });

        signup_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, Signup.class);
                startActivity(intent);
            }
        });


        tv_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*     Intent intent = new Intent(LoginScreen.this, Forget_Password.class);
                startActivity(intent);*/
            }
        });




    }
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.login_tv:
                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
   /* private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        final String tag_string_req = "req_login";

        mView.show(getSupportFragmentManager(), "Loading..");
        String url = ApplicationConstants.baseApi+"login";
        try{
            StringRequest strReq = new StringRequest(Request.Method.POST,
                    url, new Response.Listener<String>(){


                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Login Response: " + response);


                    Gson gson = new Gson();

                    try {

                        JsonObject jobj = gson.fromJson(response, JsonObject.class);
                        String status = jobj.get("status").getAsString().replaceAll("\"", "");
                        String message = jobj.get("message").getAsString().replaceAll("\"", "");


                        Log.d(TAG, "Message: "+message);

                        if(status.equals("1")) {
                            ///  showOptDialog(mobile);
                            String username = jobj.get("username").getAsString().replaceAll("\"", "");
                            String id = jobj.get("id").getAsString().replaceAll("\"", "");
                            String email = jobj.get("email").getAsString().replaceAll("\"", "");
                            String mobile = jobj.get("mobile").getAsString().replaceAll("\"", "");
                            String profile_pic = jobj.get("profile_pic").getAsString().replaceAll("\"", "");
                            String device_type = jobj.get("device_type").getAsString().replaceAll("\"", "");
                            String device_id = jobj.get("device_id").getAsString().replaceAll("\"", "");
                            String fcm_token = jobj.get("fcm_token").getAsString().replaceAll("\"", "");

                            globalClass.setId(id);
                            globalClass.setName(username);
                            globalClass.setEmail(email);
                            globalClass.setPhone_number(mobile);
                            globalClass.setProfle_image(profile_pic);

                            globalClass.setLogin_status(true);


                            //shared_prefrence.savePrefrence();
                            Intent intent = new Intent(LoginScreen.this, Dashboard.class);


                            startActivity(intent);
                            finish();
                            shared_prefrence.savePrefrence();
                            mView.dismiss();



                            Toasty.success(LoginScreen.this, message, Toast.LENGTH_SHORT, true).show();
                            Log.d(TAG, "onSuccess:id "+id);
                        }else if(status.equals("2") || status.equals("0")){
                            String error = jobj.get("error").getAsString().replaceAll("\"", "");

                            Log.d(TAG, "onResponse error: "+error);
                            mView.dismiss();
                            // FancyToast.makeText(LoginScreen.this,error,FancyToast.LENGTH_LONG,FancyToast.ERROR,true);
                            Toasty.error(LoginScreen.this, error, Toast.LENGTH_LONG, true).show();
                        }



                    }catch (Exception e){
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {

                @Override

                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Login Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),
                            "Connection Error", Toast.LENGTH_LONG).show();
                    //  pd.dismiss();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting parameters to login url
                    Map<String, String> params = new HashMap<>();

                    params.put("email", email);
                    params.put("password", password);
                    params.put("device_type", "android");
                    params.put("device_id", "");
                    params.put("fcm_token", "");


                    return params;
                }

            };

            // Adding request to request queue
     *//*   GlobalClass.getInstance().addToRequestQueue(strReq, tag_string_req);
        strReq.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 10, 1.0f));*//*
            strReq.setShouldCache(false);// todo added this to remove cache from request
            int TIME_OUT =5000;
            strReq.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            globalClass.addToRequestQueue(LoginScreen.this, strReq, tag_string_req);

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}