package com.example.android.ds;


import android.util.Log;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static com.example.android.ds.ChangeIpActivity.IpAddr;
import static com.example.android.ds.ChangeIpActivity.port2;
import static com.example.android.ds.ImageCaptureActivity.imagePath;

public class SendingThread extends Thread implements Runnable {

    @Override
    public void run() {
        super.run();
        send();
    }

    private void send() {
        try {
            Socket imageSocket = new Socket(IpAddr, port2);
            DataOutputStream dos = new DataOutputStream(imageSocket.getOutputStream());


//            FileInputStream fis = new FileInputStream(imagePath);
//            byte[] buffer = new byte[4096];
//
//            while (fis.read(buffer) > 0) {
//                dos.write(buffer);
//            }
//
//            fis.close();
//            dos.close();
//
//            imageSocket.close();


//            File transferFile = new File(imagePath);
//            Log.v("Noor", String.valueOf(transferFile.length()));
//            byte [] bytearray = new byte[(int)transferFile.length()];
//            FileInputStream fileInputStream = new FileInputStream(transferFile);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//            bufferedInputStream.read(bytearray,0,bytearray.length);
//            OutputStream outputStream = imageSocket.getOutputStream();
//            outputStream.write(bytearray,0,bytearray.length);
//            outputStream.flush();
//            imageSocket.close();


            File imageFile = new File(imagePath);
            FileInputStream fis = new FileInputStream(imageFile);
            OutputStream os = imageSocket.getOutputStream();
            int filesize = (int) imageFile.length();

            byte [] buffer  = new byte [filesize];
            int bytesRead =0;
            while ((bytesRead = fis.read(buffer)) > 0) {
                os.write(buffer, 0, bytesRead);
                System.out.println("SO sendFile" + bytesRead);
            }
            os.flush();
            os.close();
            fis.close();
            Log.d("Client", "Client sent message");
            imageSocket.close();


        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}
