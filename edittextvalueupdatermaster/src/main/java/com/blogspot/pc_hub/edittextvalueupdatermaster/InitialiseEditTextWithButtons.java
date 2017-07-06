package com.blogspot.pc_hub.edittextvalueupdatermaster;

import android.support.annotation.NonNull;
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

    public InitialiseEditTextWithButtons(@NonNull EditText etMainValue, ImageView ivIncrease, ImageView ivDecrease){
        this.etMainValue = etMainValue;
        this.ivIncrease = ivIncrease;
        this.ivDecrease = ivDecrease;
    }

    public void setMinValue(int minValue){
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }

    public void setMaxLength(int maxLength){
        
    }

    public void setInitialValue(int initialValue){
        if(initialValue < minValue)
            etMainValue.setText(minValue);
        else
            etMainValue.setText(initialValue);
    }

    public void startShow(){



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
