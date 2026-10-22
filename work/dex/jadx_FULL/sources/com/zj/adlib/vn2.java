package com.zj.adlib;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class vn2 {
    public static int a(Context context, float dip) {
        return (int) TypedValue.applyDimension(1, dip, context.getResources().getDisplayMetrics());
    }

    public static int b(Context context, int dip) {
        return (int) TypedValue.applyDimension(1, dip, context.getResources().getDisplayMetrics());
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int e(Context context, float sp) {
        return (int) TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }

    public static int f(Context context, int sp) {
        return (int) TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }
}
