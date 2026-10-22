package com.alibaba.triver.basic.picker.library.b;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f24734a = Resources.getSystem().getDisplayMetrics();

    public static int a() {
        return f24734a.widthPixels;
    }

    public static int b() {
        return f24734a.heightPixels;
    }

    public static float c() {
        return f24734a.density;
    }

    public static int a(int i) {
        return a(i);
    }

    public static int b(float f) {
        return (int) TypedValue.applyDimension(2, f, f24734a);
    }

    public static int a(float f) {
        return (int) TypedValue.applyDimension(1, f, f24734a);
    }

    public static int b(int i) {
        return Math.round(i / c());
    }
}
