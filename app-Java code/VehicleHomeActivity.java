package com.aumento.floodrescuresystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aumento.floodrescuresystem.Adapter.MyRequestListAdapter;
import com.aumento.floodrescuresystem.Adapter.VehicleCampListAdapter;
import com.aumento.floodrescuresystem.ModelClass.RequestListModelClass;
import com.aumento.floodrescuresystem.ModelClass.VehicleCampListModelClass;
import com.aumento.floodrescuresystem.Utils.GlobalPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleHomeActivity extends AppCompatActivity {

    private static final String TAG = "VehicleHomeActivity";
    private RecyclerView vehicleCampRV;
    private List<VehicleCampListModelClass> campList;
    private VehicleCampListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_home);

        GlobalPreference globalPreference = new GlobalPreference(this);
        String ip = globalPreference.RetriveIP();
        String vid = globalPreference.RetriveVID();
        String url = "http://"+ ip + "/flood/vehicleCampStop.php";

        Button stockListBT = (Button) findViewById(R.id.stockListButton);
        stockListBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VehicleHomeActivity.this,VehicleStockListActivity.class);
                startActivity(intent);
            }
        });

        vehicleCampRV = (RecyclerView) findViewById(R.id.vehicleCampRecyclerView);
        vehicleCampRV.setLayoutManager(new LinearLayoutManager(this));
        vehicleCampRV.setItemAnimator(new DefaultItemAnimator());
        vehicleCampRV.setNestedScrollingEnabled(true);

        loadList(url, vid);
    }

    private void loadList(String url, final String vid) {

        campList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "onResponse: "+response);

                if(response.contains("Failed")){
                    Toast.makeText(VehicleHomeActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else {

                    try {

                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String camp_id = object.getString("camp_id");
                            String camp_name = object.getString("camp_name");
                            String latitude = object.getString("latitude");
                            String logitude = object.getString("logitude");

                            campList.add(new VehicleCampListModelClass(camp_id, camp_name, latitude, logitude));
                        }

                        adapter = new VehicleCampListAdapter(VehicleHomeActivity.this, campList);
                        vehicleCampRV.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
                Toast.makeText(VehicleHomeActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("vid",vid);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(VehicleHomeActivity.this);
        requestQueue.add(stringRequest);

    }

}
