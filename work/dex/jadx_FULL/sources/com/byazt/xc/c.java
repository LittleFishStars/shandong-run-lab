package com.byazt.xc;

import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 674, 20})
public class c {
    public static AnimationSet c() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation2.setDuration(2000L);
        translateAnimation2.setStartOffset(1000L);
        translateAnimation2.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        return animationSet;
    }

    public static AnimationSet tt() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(1000L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    public static AnimationSet ve() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation.setDuration(1000L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }
}
