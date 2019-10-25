package com.hadi.network;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.hadi.network.uils.HttpConnector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: " + HttpConnector.searchMovie("joker"));
    }
}
