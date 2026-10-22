package com.zj.adlib;

import android.annotation.TargetApi;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class qq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44274a = 16;

    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    public static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
