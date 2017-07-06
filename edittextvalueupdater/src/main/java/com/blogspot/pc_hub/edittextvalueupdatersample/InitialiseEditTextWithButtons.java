package com.blogspot.pc_hub.edittextvalueupdatersample;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by pchub on 06-07-2017.
 */

public class InitialiseEditTextWithButtons implements View.OnClickListener {

    private EditText etMainValue;
    private ImageView ivIncrease, ivDecrease;

    // Min length of the EditText
    private int minValue = 0;

    // Max length of the EditText
    private int maxValue = 0;

    private static final String TAG = "EditTextValueUpdater";

    public InitialiseEditTextWithButtons(EditText etMainValue, ImageView ivIncrease, ImageView ivDecrease){
        this.etMainValue = etMainValue;
        this.ivIncrease = ivIncrease;
        this.ivDecrease = ivDecrease;


        ivIncrease.setOnClickListener(this);

        ivDecrease.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if(view.equals(ivDecrease)){
            Log.d(TAG, "onClick: IV DECREASE");
        }else if(view.equals(ivIncrease)){
            Log.d(TAG, "onClick: IV INCREASE");
        }

    }
}
