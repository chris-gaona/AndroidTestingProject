package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by chrisgaona on 12/12/17.
 */

// lets us use Mockito instead of just jUnit
@RunWith(MockitoJUnitRunner.class)

public class MainActivityPresenterTest {

    MainActivityPresenter mPresenter;

    @Mock // only do this to mock a class
    MainActivityView mView;


    @Before
    public void setUp() throws Exception {
        mPresenter = new MainActivityPresenter(mView);
    }

    @Test
    public void editTextUpdated() throws Exception {
        // arrange
        String givenString = "test123";

        // act
        mPresenter.editTextUpdated(givenString);

        // assert
        Mockito.verify(mView).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() throws Exception {
        // arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // act
        mPresenter.colorSelected(index);

        // assert
        Mockito.verify(mView).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {
        // arrange
        Class clazz = OtherActivity.class;

        // act
        mPresenter.launchOtherActivityButtonClicked(clazz);

        // assert
        Mockito.verify(mView).launchOtherActivity(clazz);
    }

}