package com; 

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class ShowActivity extends Activity{

private ViewFlipper viewFlipper;

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.showbrand);

//初始化参数

final Animation in = AnimationUtils.loadAnimation(this, R.anim.in_alpha);

final Animation out = AnimationUtils.loadAnimation(this, R.anim.out_alpha);

viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

//开始图片自动播放，第一个时间为间隔时间，第二个时间未知

new CountDownTimer(10000,100000){

@Override

public void onFinish() {

viewFlipper.setInAnimation(in);

viewFlipper.setOutAnimation(out);

viewFlipper.showNext();

start();

}

@Override

public void onTick(long millisUntilFinished) {}

}.start();

}