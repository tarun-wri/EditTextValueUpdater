package com.webreinvent.speedotracker.helper;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

/**
 * Value Updater class to get value updates on different scenarios
 *
 * <p>
 *     Set min and max values to this class and then when you
 *     call {@link #getUpdatedValue(boolean)} method it will return
 *     you the updated value in between the min or max values
 * </p>
 *
 * <p>
 *     If no value is set in min value then the default value will be zero. This class returns integer values
 *     but you are free to edit this as per your needs.
 * </p>
 *
 * <p>
 *     <b>Note*</b> <br/>
 *     Call {@link #getLongPressUpdates(boolean, View)} to get regular updates on long pressed view.
 * </p>
 */

public class ValueUpdater {

    /**
     * Interface to get updated values when a view is long pressed
     */
    public interface LongPressUpdates{
        /**
         * This interface method
         * @param updatedValue Updated value
         */
        void onUpdatedValue(int updatedValue);
    }

    public int min, max;

    private int period = 350;
    private int counter = 0;
    private int thresholdValue = 0;

    private Handler handler = new Handler();

    View longPressedView;

    public ValueUpdater(){

    }

    /**
     * This method will start a handler which will update value exponentially with every update
     * @param isIncreased boolean to indicate whether the value is increased or decreased
     * @param longPressedView {@link android.support.annotation.NonNull} View which is long pressed
     */
    public void getLongPressUpdates(boolean isIncreased,@NonNull View longPressedView){
        this.longPressedView = longPressedView;
    }

    /**
     *
     * @param isIncreased Send true if plus button is pressed and send false if minus button is pressed
     *
     * @return Returns the updated integer value
     */
    public int getUpdatedValue(boolean isIncreased){
        return 0;
    }

    /**
     * Timer to update values on long button clicks
     *
     * @param increaseThreshold Boolean increaseThreshold. Set to true if you want to increase threshold otherwise set to false to decrease it.
     */
    private void startTimer(final boolean increaseThreshold) {

        Runnable r = new Runnable() {
            @Override
            public void run() {

                Log.d("log", "TIMER IS RUNNING");
                if (longPressedView.isPressed()) {

                    if (thresholdValue != 999) {
                        if (period > 10) {
                            counter++;
                            period -= counter;
                        }
                        startTimer(increaseThreshold);
                    }
                }
            }
        };

        if (longPressedView.isPressed()) {
            handler.postDelayed(r, period);
        }

    }
}
