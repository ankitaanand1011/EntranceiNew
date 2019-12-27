package com.exam.entranceinew.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.entranceinew.R;


public class Signup extends AppCompatActivity {

    EditText input_user_name,input_mobile,input_email,input_password;
    TextView tv_signup;
    String TAG = "sign_up";
 /*   GlobalClass globalClass;
    Shared_Prefrence shared_prefrence;
    CatLoadingView mView;*/
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



       /* globalClass = (GlobalClass)getApplicationContext();
        shared_prefrence = new Shared_Prefrence(this);
        shared_prefrence.loadPrefrence();

        mView = new CatLoadingView();
        mView.setText("      Loading");*/

       /* input_user_name = findViewById(R.id.input_user_name);
        input_mobile = findViewById(R.id.input_mobile);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        tv_signup = findViewById(R.id.tv_signup);
*/
       /* tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             *//*   if (globalClass.isNetworkAvailable()) {

                    if (!input_user_name.getText().toString().trim().isEmpty()) {
                        if (!input_email.getText().toString().trim().isEmpty()) {
                            if (!input_password.getText().toString().trim().isEmpty()) {
                                if (!input_mobile.getText().toString().trim().isEmpty()) {
                                    if (input_email.getText().toString().matches(emailPattern)) {
                                        checkLogin(input_email.getText().toString(), input_password.getText().toString(),input_user_name.getText().toString(),input_mobile.getText().toString());
                                    } else {
                                        Toasty.error(Signup.this, "Invalid email address.", Toast.LENGTH_LONG, true).show();
                                    }

                                } else {
                                    Toasty.warning(Signup.this, "Please enter the mobile number.", Toast.LENGTH_LONG, true).show();
                                }
                            } else {
                                Toasty.warning(Signup.this, "Please enter the password.", Toast.LENGTH_LONG, true).show();
                            }
                        } else {
                            Toasty.warning(Signup.this, "Please enter the email id.", Toast.LENGTH_LONG, true).show();
                        }
                    } else {
                        Toasty.info(Signup.this, "Please enter your name.", Toast.LENGTH_LONG, true).show();
                    }
                } else {
                    Toasty.info(Signup.this, "Check your internet connection.", Toast.LENGTH_LONG, true).show();
                }*//*

            }
        });
*/
    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tv_create_account:
                Intent intent = new Intent(Signup.this, SignUpScreen.class);
                startActivity(intent);
                break;


        }
    }

 /*   private void checkLogin(final String email, final String password, final String name, final String mobile) {
        // Tag used to cancel the request
        final String tag_string_req = "req_login";

        mView.show(getSupportFragmentManager(), "");
        String url = ApplicationConstants.baseApi+"registration";
        try{
            StringRequest strReq = new StringRequest(Request.Method.POST,
                    url, new Response.Listener<String>(){


                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "registration Response: " + response);


                    Gson gson = new Gson();

                    try {

                        JsonObject jobj = gson.fromJson(response, JsonObject.class);
                        String status = jobj.get("status").getAsString().replaceAll("\"", "");
                        String message = jobj.get("message").getAsString().replaceAll("\"", "");


                        Log.d(TAG, "Message: "+message);

                        //if(status.equals("1")) {
                        if(status.equals("active")) {
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
                           *//* globalClass.setUser_type(user_type);
                            globalClass.setDevice_type(device_type);*//*
                            globalClass.setLogin_status(true);


                            //shared_prefrence.savePrefrence();
                            Intent intent = new Intent(Signup.this, Dashboard.class);


                            startActivity(intent);
                            finish();
                            shared_prefrence.savePrefrence();
                            mView.dismiss();



                            Toasty.success(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT, true).show();
                            Log.d(TAG, "onSuccess:id "+id);
                        }else if(status.equals("2") || status.equals("0")){
                            String error = jobj.get("error").getAsString().replaceAll("\"", "");

                            Log.d(TAG, "onResponse error: "+error);
                            mView.dismiss();
                            // FancyToast.makeText(LoginScreen.this,error,FancyToast.LENGTH_LONG,FancyToast.ERROR,true);
                            Toasty.error(Signup.this, error, Toast.LENGTH_LONG, true).show();
                        }



                    }catch (Exception e){
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {

                @Override

                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "registration Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),
                            "Connection Error", Toast.LENGTH_LONG).show();
                    //  pd.dismiss();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting parameters to login url
                    Map<String, String> params = new HashMap<>();

                    params.put("user_name", name);
                    params.put("email_id", email);
                    params.put("password", password);
                    params.put("mobile", mobile);
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

            globalClass.addToRequestQueue(Signup.this, strReq, tag_string_req);

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}