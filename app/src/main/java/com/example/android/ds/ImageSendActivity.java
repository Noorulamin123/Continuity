package com.example.android.ds;

import androidx.appcompat.app.AppCompatActivity;

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

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
//                sendImage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//
//    private void sendImage() {
//        SendTask sendTask = new SendTask();
//        sendTask.execute();
//    }
//
//    static class SendTask extends AsyncTask<Void,Void,Void> {
//        private Socket socket;
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            try {
//                socket = new Socket(IpAddr,port2);
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                File imageFile = new File(imagePath);
//                FileInputStream fileInputStream = new FileInputStream(imageFile);
//                objectOutputStream.writeUTF();
//                objectOutputStream.flush();
//                objectOutputStream.close();
//                socket.close();
//            }
//            catch (IOException e) {
//                e.getStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//        }
//    }
}
