package com.example.fmy.framestudyapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest implements ContributorView{

    ContributorPresenter contributorPresenter;

    @Test
    public void addition_isCorrect() throws Exception{
        contributorPresenter = new ContributorPresenter();
        contributorPresenter.setContributorView(this);
        contributorPresenter.start();
        contributorPresenter.b();
        contributorPresenter.c();
        assertEquals(4, 2 + 2);
    }

    @Override
    public void onLoadContributorStart(String string) {
        System.out.println(string);
    }

    @Override
    public void onLoadContributorComplete() {
        System.out.println("onLoadContributorComplete");
    }

    @Override
    public void onChangeContributorName() {
        System.out.println("onChangeContributorName");
    }
}