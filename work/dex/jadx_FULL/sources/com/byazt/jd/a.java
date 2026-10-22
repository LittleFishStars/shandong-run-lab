package com.byazt.jd;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1500, 34})
public class a extends sp {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile a c;

    private a(Context context) {
        super(context);
    }

    public static a c(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }
}
