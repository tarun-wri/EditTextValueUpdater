package com.blogspot.pc_hub.edittextvalueupdatermaster;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by pchub on 06-07-2017.
 */

public class InitialiseEditTextWithButtons implements View.OnClickListener, View.OnLongClickListener {

    /**
     * Public Interface ValueUpdater
     * Call this interface to get regular value updates from your View clicks
     */
    public interface ValueUpdater {
        void onValueChanged(int value);
    }

    private EditText etMainValue;
    private View vIncrease, vDecrease;

    // Min length of the EditText
    private int minValue = 0;

    // Max length of the EditText
    private int maxValue = 999;

    // Updated Value
    private int updatedValue = minValue;

    // Value Updater interface object
    ValueUpdater valueUpdater;

    // Speed of the value updates
    private int updateSpeed = 700;

    private static final String TAG = "EditTextValueUpdater";

    public InitialiseEditTextWithButtons(@NonNull ValueUpdater valueUpdater, View vIncrease, View vDecrease) {
        this.valueUpdater = valueUpdater;
        this.vIncrease = vIncrease;
        this.vDecrease = vDecrease;
    }

    public InitialiseEditTextWithButtons(@NonNull EditText etMainValue, View vIncrease, View vDecrease) {
        this.etMainValue = etMainValue;
        this.vIncrease = vIncrease;
        this.vDecrease = vDecrease;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setInitialValue(int initialValue) {
        if (initialValue < minValue)
            updateValue(minValue);
        else
            updateValue(initialValue);
    }


    /**
     * Sets the initial speed of the value updater for long clicks.
     *
     * @param initialSpeedInMills Should be greater than 200
     */
    public void setInitialSpeedInMills(int initialSpeedInMills) {

        if (initialSpeedInMills < 200)
            updateSpeed = 200;
        else
            updateSpeed = initialSpeedInMills;
    }

    public void startShow() {

        Log.d(TAG, "startShow: Setting click listeners");
        vIncrease.setOnClickListener(this);
        vDecrease.setOnClickListener(this);

        vIncrease.setOnLongClickListener(this);
        vDecrease.setOnLongClickListener(this);

        etMainValue.addTextChangedListener(mTextWatcher);
    }

    @Override
    public void onClick(View view) {

        if (view.equals(vDecrease)) {

            Log.d(TAG, "onClick: IV DECREASE");

        } else if (view.equals(vIncrease)) {
            Log.d(TAG, "onClick: IV INCREASE");
        }

    }

    @Override
    public boolean onLongClick(View view) {
        Log.d(TAG, "onLongClick: VIEW CLICKED");

        return true;
    }


    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // We don't need to use this in our case
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Hmm..this seems interesting..let's play with this
            // We will get every single change that will happen in the EditText in this method


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    /**
     * This will update the data to the provided medium
     * @param value Updated Value obtained from the clicks on Views
     * */
    private void updateValue(int value){
        if(valueUpdater != null){
            valueUpdater.onValueChanged(value);
        }

        if(etMainValue != null){
            etMainValue.setText(String.valueOf(value));
        }
    }
}
