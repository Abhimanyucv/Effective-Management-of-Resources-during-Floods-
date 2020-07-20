package com.aumento.floodrescuresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button requestRescueBT, requestStatusBT;
    private Intent intent;
    private Button searchVictimBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        String name = getIntent().getStringExtra("name");

        TextView helloTV = (TextView) findViewById(R.id.helloTextView);
        helloTV.setText("hello! "+name);
        requestRescueBT = (Button) findViewById(R.id.requestRescueButton);
        requestRescueBT.setOnClickListener(this);
        requestStatusBT = (Button) findViewById(R.id.requestStatusButton);
        requestStatusBT.setOnClickListener(this);
        searchVictimBT = (Button) findViewById(R.id.searchVictimButton);
        searchVictimBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.requestRescueButton:
                intent = new Intent(UserHomeActivity.this,RescueRequestActivity.class);
                startActivity(intent);
                break;
            case R.id.requestStatusButton:
                intent = new Intent(UserHomeActivity.this,RescueRequestStatusActivity.class);
                startActivity(intent);
                break;
            case R.id.searchVictimButton:
                intent = new Intent(UserHomeActivity.this,SearchVictimActivity.class);
                startActivity(intent);
                break;
        }
    }
}
