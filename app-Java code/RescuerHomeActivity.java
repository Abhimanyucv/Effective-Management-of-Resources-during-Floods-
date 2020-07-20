package com.aumento.floodrescuresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RescuerHomeActivity extends AppCompatActivity {

    private Intent intent;
    private Button searchVictimBT, viewRescueRequestBT, viewMyRequestBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescuer_home);

        viewRescueRequestBT = (Button) findViewById(R.id.viewRescueRequestButton);
        viewRescueRequestBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RescuerHomeActivity.this,RescueRequestListActivity.class);
                startActivity(intent);
            }
        });

        viewMyRequestBT = (Button) findViewById(R.id.viewMyRequestButton);
        viewMyRequestBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RescuerHomeActivity.this,MyRequestListActivity.class);
                startActivity(intent);
            }
        });

        searchVictimBT = (Button) findViewById(R.id.searchVictimButton);
        searchVictimBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RescuerHomeActivity.this,SearchVictimActivity.class);
                startActivity(intent);
            }
        });
    }
}
