package com.example.hshack.healthandhappiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Button capture;
    public static Button myday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capture = (Button)findViewById(R.id.scan_button);
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchCapture = new Intent(MainActivity.this,Capture.class);
                startActivity(launchCapture);
            }
        });

        myday = (Button)findViewById(R.id.myday_button);
        myday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchMyDay = new Intent(MainActivity.this,MyDay.class);
                startActivity(launchMyDay);
            }
        });
    }
}
