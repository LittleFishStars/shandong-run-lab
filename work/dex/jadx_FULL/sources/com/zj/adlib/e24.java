package com.zj.adlib;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e24 {
    public static String a(String str) {
        return Consts.DOT + str + ",." + str + " *";
    }

    public static String b(@ColorInt int i) {
        return gj9.H("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d));
    }
}
