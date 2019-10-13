package com.example.android.ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.camerakit.CameraKitView;

import java.io.File;
import java.io.FileOutputStream;

public class CameraCaptureActivity extends AppCompatActivity {
    private CameraKitView cameraKitView;
    private Button photoButton;
    public static String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);
        cameraKitView = findViewById(R.id.camera);
        photoButton = findViewById(R.id.photoButton);

        photoButton.setOnClickListener(photoOnClickListener);





//        cameraKitView.setCameraListener(new CameraKitView.CameraListener() {
//            @Override
//            public void onOpened() {
//
//            }
//
//            @Override
//            public void onClosed() {
//
//            }
//
//            @Override
//            public void onPictureTaken(byte[] picture) {
//                super.onPictureTaken(picture);
//
//                // Create a bitmap
//                Bitmap result = BitmapFactory.decodeByteArray(picture, 0, picture.length);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraKitView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cameraKitView.onStop();
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private View.OnClickListener photoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cameraKitView.captureImage(new CameraKitView.ImageCallback() {
                @Override
                public void onImage(CameraKitView cameraKitView, final byte[] capturedImage) {
                    File savedPhoto = new File(Environment.getExternalStorageDirectory(), "photo.jpg");
                    try {
                        FileOutputStream outputStream = new FileOutputStream(savedPhoto.getPath());
                        outputStream.write(capturedImage);
                        outputStream.close();
                        filePath = savedPhoto.getAbsolutePath();
                        Log.v("Noor","File: "+filePath);
//                        Intent loadImage = new Intent(CameraCaptureActivity.this,ImageSendActivity.class);
//                        startActivity(loadImage);
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };

//    private CameraKitView.CameraListener cameraListener = new CameraKitView.CameraListener() {
//        @Override
//        public void onPictureTaken(byte[] picture) {
//            // Create a bitmap
//            Bitmap result = BitmapFactory.decodeByteArray(picture, 0, picture.length);
//        }
//    };

}
