package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ml {
    public static boolean a(int i) {
        return i >= ((int) (Math.random() * 100.0d)) + 1;
    }

    public static boolean a(int i, String str) {
        return !TextUtils.isEmpty(str) && i >= nn.a(str);
    }
}
