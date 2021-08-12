package com.example.JustMessages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class secondActivity extends AppCompatActivity {



    public void send(View view)
    {
        Intent intent = new Intent(getApplicationContext(),sendActivity.class);
        startActivity(intent);
    }
    public void receive(View view)
    {
        Intent intent = new Intent(getApplicationContext(),receiveActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}