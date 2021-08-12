package com.example.JustMessages;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class sendActivity extends AppCompatActivity{
    String encryptedMsg ="";
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void encryptText(View view)
    {
        TextView sendView = findViewById(R.id.sendView);
        TextView encryptedTextView = findViewById(R.id.encryptedTextView);
        String msg = sendView.getText().toString();
        algo obj = new algo("QueZxswAaqER39Aa");
        try {
            encryptedMsg = obj.encrypt(msg);
            encryptedTextView.setText(encryptedMsg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        InputMethodManager mgr =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
    public void copyEncryptedText(View view)
    {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Message", encryptedMsg);
        clipboard.setPrimaryClip(clip);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);


    }
}