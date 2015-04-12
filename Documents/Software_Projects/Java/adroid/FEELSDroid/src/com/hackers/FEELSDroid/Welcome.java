package com.hackers.FEELSDroid;

//Created by Menaka Jayawardena
import android.os.Bundle;
import org.apache.cordova.DroidGap;

public class Welcome extends DroidGap {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
}