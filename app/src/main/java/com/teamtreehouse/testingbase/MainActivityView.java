package com.teamtreehouse.testingbase;

/**
 * Created by chrisgaona on 12/12/17.
 */

public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}
