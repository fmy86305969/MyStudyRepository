package com.example.fmy.framestudyapplication;

/**
 * Created by FMY on 2017/7/28 0028.
 */
public class HellowJni {
    static {
//        System.loadLibrary("fmy");
    }

    public static native String getStrFromJNI();

    public static native String getAdd(int a,int b);

}
