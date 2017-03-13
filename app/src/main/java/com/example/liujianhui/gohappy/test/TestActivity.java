package com.example.liujianhui.gohappy.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by issuser on 2017/3/13 0013.
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(TestActivity.this,"nihaonhello   world!!!",Toast.LENGTH_SHORT).show();
        Log.d("TestActivity===","hello world...//");
    }
}
