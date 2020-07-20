package com.aumento.floodrescuresystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aumento.floodrescuresystem.Adapter.SearchResultListAdapter;
import com.aumento.floodrescuresystem.ModelClass.SearchResultListModelClass;
import com.aumento.floodrescuresystem.Utils.GlobalPreference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchVictimActivity extends AppCompatActivity {

    private static final String TAG = "SearchVictimActivity";
    EditText searchET;
    LinearLayout resultLL;
    private String url;
    private TextView searchButtonTV, nameTV, campTV, dateTV, locationTV;
    private RecyclerView searchResultRV;
    private List<SearchResultListModelClass> SearchResult;
    private SearchResultListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_victim);

        init();

        GlobalPreference globalPreference = new GlobalPreference(this);
        String ip = globalPreference.RetriveIP();
        url = "http://"+ ip + "/flood/campSearch.php";

        searchResultRV = (RecyclerView) findViewById(R.id.searchResultRecyclerView);
        searchResultRV.setLayoutManager(new LinearLayoutManager(this));
        searchResultRV.setItemAnimator(new DefaultItemAnimator());
        searchResultRV.setNestedScrollingEnabled(true);

        searchButtonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = searchET.getText().toString();
                search(text);
            }
        });
    }

    private void search(final String text) {

        SearchResult = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "onResponse: "+response);

                if(response.contains("Failed"))
                {
                    Toast.makeText(SearchVictimActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else {

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String name = object.getString("name");
                            String camp_name = object.getString("camp_name");
                            String location = object.getString("location");
                            String date = object.getString("date");

                            SearchResult.add(new SearchResultListModelClass(id, name, camp_name, location, date));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    adapter = new SearchResultListAdapter(SearchVictimActivity.this, SearchResult);
                    searchResultRV.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("text",text);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(SearchVictimActivity.this);
        requestQueue.add(stringRequest);

    }

    private void init() {
        searchET = (EditText) findViewById(R.id.searchEditText);
        searchButtonTV = (TextView) findViewById(R.id.searchButtonTextView);
        nameTV = (TextView) findViewById(R.id.nameTextView);
        locationTV = (TextView) findViewById(R.id.locationTextView);
        campTV = (TextView) findViewById(R.id.campTextView);
        dateTV = (TextView) findViewById(R.id.dateTextView);

    }

}
