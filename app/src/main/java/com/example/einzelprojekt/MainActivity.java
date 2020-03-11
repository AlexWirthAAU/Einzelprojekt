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
    TextView textView, textViewMatrikel, textViewSorted;
    String number;
    NetworkTask nwt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        inputNumber = findViewById(R.id.inputField);
        textView = findViewById(R.id.textView);
        textViewMatrikel=findViewById(R.id.textView2);
        textViewSorted=findViewById(R.id.sortedNumber);

        sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nwt=new NetworkTask();
                    number=inputNumber.getText().toString();
                    textViewMatrikel.setText(number);
                    inputNumber.getText().clear();

                    if (number.length()==8) {
                        try {
                            String[] results = nwt.execute(number).get();
                            String result = results[0];
                            String sorted = results[1];
                            textView.setText(result);
                            textViewSorted.setText(sorted);
                            nwt=null;
                        }catch (Exception e){
                            Log.d("ERROR", e.getMessage());
                        }
                    } else {
                        textViewMatrikel.setText("");
                        textView.setText("Eine österreichische Matrikelnummer hat 8 Ziffern!");
                        textViewSorted.setText("");

                    }
                }
            });
        }
}
