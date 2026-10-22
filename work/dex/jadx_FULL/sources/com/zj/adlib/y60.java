package com.zj.adlib;

import android.view.View;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class y60 {
    public static void a(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setDuration(350L);
        view.setAnimation(translateAnimation);
        view.setVisibility(0);
    }
}
