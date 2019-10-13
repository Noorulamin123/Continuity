package com.example.android.ds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeIpActivity extends AppCompatActivity {

    public static String IpAddr = "192.168.43.154";
    public static final int port = 3333;
    public static final int port2 = 3334;
    public static EditText changePort;
    public static EditText changeIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ip);
//        IpDetail = (TextView) findViewById(R.id.ipAddr);
        changeIP = findViewById(R.id.changeIP);
//        changePort = findViewById(R.id.changePort);
        Button saveButton = findViewById(R.id.saveIP);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                port = Integer.parseInt(changePort.getText().toString());
                IpAddr = changeIP.getText().toString();
                finish();
            }
        });

    }
}
