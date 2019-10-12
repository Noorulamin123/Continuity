package com.example.android.ds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static boolean index = false;
    public Button mStartButton = null;
    public Button mStopButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = findViewById(R.id.start);
        mStopButton = findViewById(R.id.stop);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = true;
                startService(new Intent(v.getContext(), SocketService.class));
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(v.getContext(), SocketService.class));
                index = false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ip:
                changeIp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void changeIp() {
        Intent changeIpIntent = new Intent(MainActivity.this, ChangeIpActivity.class);
        startActivity(changeIpIntent);
    }
}
