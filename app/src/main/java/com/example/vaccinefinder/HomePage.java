package com.example.vaccinefinder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    RecyclerView centerss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        centerss = findViewById(R.id.centerss);
        getData();
    }
   public void getData(){
        ArrayList<modal> ar= new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
       String url=getIntent().getStringExtra("Url");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject center = new JSONObject(response);
                    JSONArray centerNames = center.getJSONArray("centers");
                    for (int i = 0; i <= centerNames.length(); i++) {
                        JSONObject centerDetails=centerNames.getJSONObject(i);
                        String centerId=centerDetails.getString("center_id")+"",
                                centerName=centerDetails.get("name")+"",
                                centerAddress=centerDetails.get("address")+"",
                                centerStateName=centerDetails.get("state_name")+"",
                                centerDistrictName=centerDetails.get("district_name")+"",
                                centerBlockName=centerDetails.get("block_name")+"",
                                centerPinCOde=centerDetails.get("pincode")+"",
                                centerFrom=centerDetails.get("from")+"",
                                centerTo=centerDetails.get("to")+"",
                                centerFeetype=centerDetails.get("fee_type")+"",
                                centerSessions=centerDetails.get("sessions")+"";
                        JSONObject vaccineDetails=centerDetails.getJSONArray("sessions").getJSONObject(0);
                        String sessionId=vaccineDetails.get("session_id")+"",
                                sessionDate=vaccineDetails.get("date")+"",
                                available_capacity=vaccineDetails.get("available_capacity")+"",
                                min_age_limit=vaccineDetails.get("min_age_limit")+"",
                                vaccine=vaccineDetails.get("vaccine")+"",
                                available_capacity_dose1= vaccineDetails.get("available_capacity_dose1")+"",
                                available_capacity_dose2=vaccineDetails.get("available_capacity_dose2")+"";

                        ar.add(new modal(centerId+"",
                                centerName+"",
                                centerAddress+"",centerStateName+"",centerDistrictName+"",
                                centerBlockName+"",centerPinCOde+"",centerFrom+"",
                                centerTo+"",centerFeetype+"",centerSessions+"",sessionId+"",
                                sessionDate+"",
                                available_capacity+"",
                                min_age_limit+"",
                                vaccine+"",
                                available_capacity_dose1+""
                                ,available_capacity_dose2+""));
                    }

                }catch (Exception e) {
                }
                if(ar.size()==0){
                    Toast.makeText(HomePage.this, "No Centers Found", Toast.LENGTH_LONG).show();
                }
                else {
                centerss.setLayoutManager(new GridLayoutManager(HomePage.this,1,RecyclerView.VERTICAL,false));
                centerss.setAdapter(new recylerAdapter(HomePage.this,ar));
            }}

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomePage.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}





