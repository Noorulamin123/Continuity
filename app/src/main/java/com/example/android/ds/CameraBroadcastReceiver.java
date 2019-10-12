package com.example.android.ds;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;


import static android.hardware.Camera.ACTION_NEW_PICTURE;

public class CameraBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        abortBroadcast();


        if (ACTION_NEW_PICTURE.equals(intent.getAction())){
                Log.v("Noor", String.valueOf(intent.getData()));
                Toast.makeText(context, "New Photo Clicked", Toast.LENGTH_LONG).show();

            }
        Log.v("Noor","Didn't match");

//        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
//            boolean noConnectivity = intent.getBooleanExtra(
//                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
//            );
//            if (noConnectivity){
//                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
//            }
//        }
    }
}

