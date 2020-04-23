package com.example.projectmanagement;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Utility {

    public static void showToast(final AppCompatActivity activity, final String message)
    {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity.getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
