package com.example.JustMessages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String passEntered = "";
    public void pass(View view)
    {
        passEntered = passEntered + view.getTag();
        String password = "123456";
        if(passEntered.length()<=6)
        {
            

            if(passEntered.equals(password))
            {
                 Intent intent = new Intent(getApplicationContext(),secondActivity.class);
                 startActivity(intent);
            }


        }
        else
        {
            passEntered = "";
            Context context = getApplicationContext();
            String text = "Wrong Password!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }
//    @Override
//    public void onStop(){
//        super.onStop();
//        finish();
//        System.runFinalizersOnExit(true);
//        System.exit(0);
//        android.os.Process.killProcess(android.os.Process.myPid());
//    }
}