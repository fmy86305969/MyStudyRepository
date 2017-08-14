package com.example.fmy.framestudyapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity implements ContributorView {
    //F:\Android\sdk\extras\android\m2repository\com\android\support\appcompat-v7\25.3
    // .1\appcompat-v7-25.3.1-sources.jar!\android\support\v7\app\AppCompatActivity.java
    ContributorPresenter contributorPresenter = new ContributorPresenter();
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
//        textView.setText("计算的结果为：" + HellowJni.getAdd(1, 1));
        setContentView(textView);
        rxjavaText();
    }

    public native String getStrFromJNI();

    public void get(View view) {
        contributorPresenter.start();
    }

    public void change(View view) {
        contributorPresenter.b();
    }

    @Override
    public void onLoadContributorStart(String string) {
        Log.e("哈哈", "onLoadContributorStart");
    }

    @Override
    public void onLoadContributorComplete() {
        Log.e("哈哈", "onLoadContributorComplete");
    }

    @Override
    public void onChangeContributorName() {
        Log.e("哈哈", "onChangeContributorName");
    }

    File[] folders;
    final String tag = "rxjava";

    //Button -> 被观察者、OnClickListener -> 观察者、setOnClickListener() -> 订阅，onClick() -> 事件
    //Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
    //Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
    public void rxjavaText() {
        observable.subscribe(observer);
    }
    //Observer 即观察者，它决定事件触发的时候将有怎样的行为。
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            Log.e(tag, "Completed!");
        }

        @Override
        public void onError(Throwable e) {
            Log.e(tag, "Error!");
        }

        @Override
        public void onNext(String s) {
            Log.e(tag, "Item: " + s);
        }
    };

    //Observable 即被观察者，它决定什么时候触发事件以及触发怎样的事件。
    // RxJava 使用 create() 方法来创建一个 Observable ，并为它定义事件触发规则：
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });


    //除了 Observer 接口之外，RxJava 还内置了一个实现了 Observer 的抽象类：Subscriber。
    // Subscriber 对 Observer 接口进行了一些扩展，但他们的基本使用方式是完全一样的：
    Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            Log.d(tag, "Item: " + s);
        }

        @Override
        public void onCompleted() {
            Log.d(tag, "Completed!");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "Error!");
        }
    };
}
