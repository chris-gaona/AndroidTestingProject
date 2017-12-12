package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chrisgaona on 12/12/17.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter mPresenter;
    MainActivityView mView;

    class MockedView implements MainActivityView {

        String textViewText;

        @Override
        public void changeTextViewText(String text) {
            textViewText = text;
        }

        @Override
        public void changeBackgroundColor(int color) {

        }

        @Override
        public void launchOtherActivity(Class activity) {

        }
    }

    @Before
    public void setUp() throws Exception {
        mView = new MockedView();
        mPresenter = new MainActivityPresenter(mView);
    }

    @Test
    public void editTextUpdated() throws Exception {
        // arrange
        String givenString = "test123";

        // act
        mPresenter.editTextUpdated(givenString);

        // assert
        assertEquals(givenString, ((MockedView)mView).textViewText);
    }

    @Test
    public void colorSelected() throws Exception {
    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {
    }

}