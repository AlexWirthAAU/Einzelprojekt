package com.example.einzelprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button sendButton;
    EditText inputNumber;
    TextView textView;
    int number;
    NetworkTask nwt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        inputNumber = findViewById(R.id.inputField);
        textView = findViewById(R.id.textView);


        sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nwt=new NetworkTask();
                    number = Integer.valueOf(inputNumber.getText().toString());
                    if (isValid(number)) {
                        //nwt.execute(number);
                        try {
                            String result = nwt.execute(number).get();
                            Log.d("DEBUG","Result: "+result);
                            textView.setText(result);
                            nwt=null;
                        }catch (Exception e){
                            Log.d("DEBUG", e.getMessage());
                        }
                    } else {
                        textView.setText("Illegal Argument!");
                    }
                }
            });
        }


    private boolean isValid(int number){
        boolean isvalid = true;
        int num=number;
        int count=0;

        while (num!=0){
            num=num/10;
            ++count;
        }

        if(count!=8){
            return isvalid=false;
        }

        return isvalid;
    }
}
