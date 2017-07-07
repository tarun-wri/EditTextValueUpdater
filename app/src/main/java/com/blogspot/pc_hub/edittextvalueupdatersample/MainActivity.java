package com.blogspot.pc_hub.edittextvalueupdatersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.blogspot.pc_hub.edittextvalueupdatermaster.InitialiseEditTextWithButtons;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etValue = (EditText) findViewById(R.id.etValue);
        ImageView ivDecrease = (ImageView) findViewById(R.id.ivDecrease);
        ImageView ivIncrease = (ImageView) findViewById(R.id.ivIncrease);

        Log.d("log", "onCreate: Initialising Edit Text With Buttons");
        InitialiseEditTextWithButtons initializer = new InitialiseEditTextWithButtons(etValue,ivIncrease,ivDecrease);
        initializer.setMinValue(0);
        initializer.setMaxValue(999);
        initializer.startShow();
    }
}
