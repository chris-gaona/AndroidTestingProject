package com.teamtreehouse.testingbase;

import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by chrisgaona on 12/12/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
// roboelectric uses build config class to find where everything is in our app
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    MainActivity mMainActivity;

    @Before
    public void setUp() {
//        mMainActivity = new MainActivity();
//        // creates an instance of MainActivity
//        mMainActivity.onCreate(null);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
//        // Arrange objects under test
//        String givenString = "test123";
//        mMainActivity.editText.setText(givenString);
//
//        // Act on objects
//        mMainActivity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
//
//        // Assert we get expected result
//        String actualString = mMainActivity.textView.getText().toString();
//        assertEquals(givenString, actualString);
    }
}
