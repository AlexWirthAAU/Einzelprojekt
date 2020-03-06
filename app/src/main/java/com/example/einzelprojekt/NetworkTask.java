package com.example.einzelprojekt;

import android.os.AsyncTask;

import java.util.Objects;

public class NetworkTask extends AsyncTask<Integer,Integer,String>{

    public NetworkTask(){

    }

    @Override
    protected String doInBackground(Integer... number) {

        //TODO Find solution for handing over number
        ServerCommunicator serverCommunicator = new ServerCommunicator();
        serverCommunicator.setMatNumber(11704244);
        serverCommunicator.sendData(11704244);
        serverCommunicator.getData();

        //serverCommunicator.leoSocketExample();
        return null;
    }


}
