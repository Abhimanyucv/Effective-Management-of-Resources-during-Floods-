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
import com.aumento.floodrescuresystem.Adapter.VehicleCampListAdapter;
import com.aumento.floodrescuresystem.Adapter.VehicleStockListAdapter;
import com.aumento.floodrescuresystem.ModelClass.VehicleCampListModelClass;
import com.aumento.floodrescuresystem.ModelClass.VehicleStockListModelClass;
import com.aumento.floodrescuresystem.Utils.GlobalPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleStockActivity extends AppCompatActivity {

    private static final String TAG = "VehicleStockActivity";
    private RecyclerView vehicleStockRV;
    private List<VehicleStockListModelClass> stockList;
    private VehicleStockListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_stock);


        GlobalPreference globalPreference = new GlobalPreference(this);
        String ip = globalPreference.RetriveIP();
        String vid = globalPreference.RetriveVID();
        String url = "http://"+ ip + "/flood/vehicleStock.php";

        vehicleStockRV = (RecyclerView) findViewById(R.id.vehicleStockRecyclerView);
        vehicleStockRV.setLayoutManager(new LinearLayoutManager(this));
        vehicleStockRV.setItemAnimator(new DefaultItemAnimator());
        vehicleStockRV.setNestedScrollingEnabled(true);

        loadList(url, vid);
    }

    private void loadList(String url, final String vid) {

        stockList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "onResponse: "+response);

                if(response.contains("Failed")){
                    Toast.makeText(VehicleStockActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else {

                    try {

                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String item_name = object.getString("item_name");
                            String item_qty = object.getString("item_qty");
                            stockList.add(new VehicleStockListModelClass(item_name,item_qty));
                        }

                        adapter = new VehicleStockListAdapter(VehicleStockActivity.this, stockList);
                        vehicleStockRV.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
                Toast.makeText(VehicleStockActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("vid",vid);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(VehicleStockActivity.this);
        requestQueue.add(stringRequest);

    }

}
