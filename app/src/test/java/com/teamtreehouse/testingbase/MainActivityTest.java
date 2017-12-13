package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

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
        int expectedColor = ((ColorDrawable) mMainActivity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, expectedColor);
    }
}
