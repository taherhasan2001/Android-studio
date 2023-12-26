package edu.birzeit.fragmentsfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SecondFragment.communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void respond(String data) {
        SecondFragment secondFragment = (SecondFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        secondFragment.changeData(data);
    }
}