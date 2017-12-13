package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chrisgaona on 12/12/17.
 */

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    MainActivity mMainActivity;

    @Before
    public void setUp() {
        // sets up MainActivity class
        mMainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange objects under test
        String givenString = "test123";
        mMainActivity.editText.setText(givenString);

        // Act on objects
        mMainActivity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        // Assert we get expected result
        String actualString = mMainActivity.textView.getText().toString();
        assertEquals(givenString, actualString);
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // act
        mMainActivity.colorSpinner.setSelection(index);

        // assert
        // get background color from linearLayout
        int actualColor = ((ColorDrawable) mMainActivity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(mMainActivity, clazz);

        // act
        mMainActivity.launchActivityButton.callOnClick();

        // assert
        // check that startActivity is called with correct intent
        Intent actualIntent = Shadows.shadowOf(mMainActivity).getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }
}
