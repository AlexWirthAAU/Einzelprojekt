package com.example.einzelprojekt;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Objects;

public class NetworkTask extends AsyncTask<String,Void,String[]>{

    public NetworkTask(){

    }

    @Override
    protected String[] doInBackground(String... number) {
        String num = number[0];
        String[] returnValues = new String[2];


        ServerCommunicator serverCommunicator = new ServerCommunicator();
        serverCommunicator.setMatNumber(num);
        serverCommunicator.sendData(num);

        returnValues[0]=serverCommunicator.getData();
        returnValues[1]=serverCommunicator.sortMatrikelNumber();

        Log.d("DEBUG: ", "returned output[0]: "+returnValues[0]);
        return returnValues;
    }


}
