package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.LinearLayout;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by chrisgaona on 12/13/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        onView(withId(R.id.editText)).perform(typeText(givenString));

        // Act
        onView(withId(R.id.editText)).perform(pressImeActionButton());

        // Assert
        onView(withId(R.id.textView)).check(matches(withText(givenString)));
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        final int givenColor = Color.GREEN;
        String spinnerItemText = "Green";

        // Act
        onView(withId(R.id.colorSpinner)).perform(click());
        // use onData to handle scrolling of data
        onData(allOf(is(instanceOf(String.class)), is(spinnerItemText))).perform(click());

        // Assert
        // only looks at Views & only matches on LinearLayouts
        BoundedMatcher<View, LinearLayout> backgroundColorMatcher = new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            protected boolean matchesSafely(LinearLayout linearLayout) {
                int actualColor = ((ColorDrawable) linearLayout.getBackground()).getColor();
                return givenColor == actualColor;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("background color should equal: " + givenColor);
            }
        };

        onView(withId(R.id.linearLayout)).check(matches(backgroundColorMatcher));
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange


        // Act


        // Assert

    }
}
