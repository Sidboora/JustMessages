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

public class receiveActivity extends AppCompatActivity {
    String decryptedMsg = "";
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void decryptText(View view)
    {
        TextView encryptedMsgTextView = findViewById(R.id.encryptedMsgTextView);
        TextView decryptedMsgTextView = findViewById(R.id.decryptedMsgTextView);
        String msg = encryptedMsgTextView.getText().toString();
        algo obj = new algo("QueZxswAaqER39Aa");
        try {
             decryptedMsg = obj.decrypt(msg);
            decryptedMsgTextView.setText(decryptedMsg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        InputMethodManager mgr =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
    public void copyDecryptedText(View view)
    {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Message", decryptedMsg);
        clipboard.setPrimaryClip(clip);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
    }
}