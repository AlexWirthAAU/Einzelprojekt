package com.example.einzelprojekt;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Objects;

public class NetworkTask extends AsyncTask<Integer,Void,String>{

    public NetworkTask(){

    }

    @Override
    protected String doInBackground(Integer... number) {
        int num = number[0];

        ServerCommunicator serverCommunicator = new ServerCommunicator();
        serverCommunicator.setMatNumber(num);
        serverCommunicator.sendData(num);

        return serverCommunicator.getData();
    }


}
