package com.example.fmy.framestudyapplication;

/**
 * Created by FMY on 2017/7/26 0026.
 */
public class ContributorPresenter {
    ContributorView contributorView;

    public void start(){
        //在这里进行网络请求等逻辑操作
        //再次调用jni
        contributorView.onLoadContributorStart("hellow for mvp");
    }

    public void b(){
        contributorView.onChangeContributorName();
    }

    public void c(){
        contributorView.onLoadContributorComplete();
    }

    public ContributorView getContributorView() {
        return contributorView;
    }

    public void setContributorView(ContributorView contributorView) {
        this.contributorView = contributorView;
    }
}
