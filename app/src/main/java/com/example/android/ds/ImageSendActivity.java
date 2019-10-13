package com.example.android.ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import static com.example.android.ds.ChangeIpActivity.IpAddr;
import static com.example.android.ds.ChangeIpActivity.port;
import static com.example.android.ds.ChangeIpActivity.port2;
import static com.example.android.ds.ImageCaptureActivity.imagePath;

public class ImageSendActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_send);
        imageView = findViewById(R.id.imageView);
        Glide.with(this).load(imagePath).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_send, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sendImage:
                sendImage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sendImage() {
        SendingThread sendingThread = new SendingThread();
        sendingThread.start();
        try {
            sendingThread.join();
            Toast.makeText(ImageSendActivity.this, "File Sent", Toast.LENGTH_SHORT).show();
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
}
