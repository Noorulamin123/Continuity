package com.example.android.ds;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.example.android.ds.ChangeIpActivity.IpAddr;
import static com.example.android.ds.ChangeIpActivity.port;

public class TcpThread extends Thread implements Runnable{

    public static Socket socket;
    public static int RESULT;
    public static DataInputStream dataInputStream;
    public static DataOutputStream dataOutputStream;


    @Override
    public void run() {
        super.run();

        connect();


    }

    private void connect() {
        try {
            socket = new Socket(IpAddr, port);
            Log.v("Noor","Inside TCP");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            RESULT = dataInputStream.readInt();
            if (RESULT == 1) {
                dataOutputStream.writeUTF("Camera Event Started");
            } else if (RESULT == 2) {
                dataOutputStream.writeUTF("File Import Event Started");
            } else {
                dataOutputStream.writeUTF("Not an event");
            }
            dataOutputStream.flush();
            socket.close();
            interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
