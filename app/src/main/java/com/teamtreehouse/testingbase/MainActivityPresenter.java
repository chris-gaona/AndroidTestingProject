package com.teamtreehouse.testingbase;

import android.graphics.Color;

/**
 * Created by chrisgaona on 12/12/17.
 */

// this class is used to give access to MainActivityView methods to MainActivity
public class MainActivityPresenter {
    MainActivityView mView;

    public MainActivityPresenter(MainActivityView view) {
        mView = view;
    }

    public void editTextUpdated(String text) {
        mView.changeTextViewText(text);
    }

    public void colorSelected(int index) {
        switch (index) {
            case 0:
                mView.changeBackgroundColor(Color.WHITE);
                break;
            case 1:
                mView.changeBackgroundColor(Color.MAGENTA);
                break;
            case 2:
                mView.changeBackgroundColor(Color.GREEN);
                break;
            case 3:
                mView.changeBackgroundColor(Color.CYAN);
                break;
        }
    }

    public void launchOtherActivityButtonClicked(Class activity) {
        mView.launchOtherActivity(activity);
    }
}
