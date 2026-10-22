package com.byazt.vx;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 17})
public class gu {
    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str2);
        }
    }

    private static void c(String str) {
        throw new IllegalArgumentException(str);
    }
}
