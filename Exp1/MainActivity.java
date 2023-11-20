package com.example.mactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number1=(EditText)findViewById(R.id.editText1);
                EditText number2=(EditText)findViewById(R.id.editText2);
                TextView textView=(TextView) findViewById(R.id.textViewAnswer);
                int intAnswer = Integer.parseInt(number1.getText().toString()) + Integer.parseInt(number2.getText().toString());

                String strAnwer = String.valueOf(intAnswer);
                textView.setText(strAnwer);
            }
        });

    }
}