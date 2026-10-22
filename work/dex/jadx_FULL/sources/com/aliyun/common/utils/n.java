package com.aliyun.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n {
    private static n d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25581a;
    public int b;
    public int c;

    private n() {
    }

    public static n a() {
        if (d == null) {
            d = new n();
        }
        return d;
    }

    public void a(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        this.c = displayMetrics.widthPixels;
        this.b = displayMetrics.heightPixels;
        this.f25581a = displayMetrics.scaledDensity;
    }
}
