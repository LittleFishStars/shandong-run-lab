package com.aliyun.vod.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MySystemParams {
    public static final int SCREEN_ORIENTATION_HORIZONTAL = 2;
    public static final int SCREEN_ORIENTATION_VERTICAL = 1;
    private static MySystemParams params;
    private final String TAG = "SystemParams";
    public int densityDpi;
    public float fontScale;
    public float scale;
    public int screenHeight;
    public int screenOrientation;
    public int screenWidth;

    private MySystemParams() {
    }

    public static MySystemParams getInstance() {
        if (params == null) {
            params = new MySystemParams();
        }
        return params;
    }

    public void init(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.screenWidth = i;
        int i2 = displayMetrics.heightPixels;
        this.screenHeight = i2;
        this.densityDpi = displayMetrics.densityDpi;
        this.scale = displayMetrics.density;
        this.fontScale = displayMetrics.scaledDensity;
        if (i2 > i) {
            this.screenOrientation = 1;
        } else {
            this.screenOrientation = 2;
        }
    }
}
