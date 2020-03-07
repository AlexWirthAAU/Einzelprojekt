package com.example.einzelprojekt;

;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.Socket;


public class ServerCommunicator  {


    private Socket socket = null;
    private DataOutputStream dataOutputStream=null;
    private DataInputStream dataInputStream=null;
    private InputStream is = null;
    private int matNumber;

    public ServerCommunicator() {

        try{
            Log.d("DEBUG","Try to open socket...");
            socket = new Socket("se2-isys.aau.at", 53212);
            dataOutputStream=new DataOutputStream(socket.getOutputStream());
            dataInputStream=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            is = socket.getInputStream();

            Log.d("DEBUG","Socket and Output created!");
        }catch (IOException e){
            Log.e("DEBUG","Error creating socket: "+e.getMessage());
        }
    }



    public void setMatNumber(int matNumber) {
        this.matNumber = matNumber;
    }

    public int getMatNumber() {
        return matNumber;
    }

    public void sendData(int matNumber){
        Log.d("DEBUG","Übergebene Nummer: "+matNumber);
        byte[] data = (String.valueOf(matNumber)+"\r").getBytes();

        Log.d("DEBUG","Socket offen?:" +socket.isConnected());
        try{
            dataOutputStream.write(data);
            dataOutputStream.flush();
            Log.d("DEBUG","sendData() called");
        }catch (IOException e){
            Log.e("DEBUG","Failed to send data: "+e.getLocalizedMessage());
        }
    }

    public String getData(){
        Log.d("DEBUG","getData() called");
        String output="";

        try {
            output=dataInputStream.readLine();
        }catch (IOException e){
            Log.d("DEBUG: ",e.getMessage() );
        }
        return output;
    }

    /*
    public String sortMatrikelNumber(int[] numberInArray){
        String number="";
        for (int i = 0; i < numberInArray; i++) {

        }
    }
     */

    private int[] splitNumber(){
        String number = ""+this.matNumber;
        int[]digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i]=Integer.parseInt(number.substring(i, i+1));
        }
        return digits;
    }


}
