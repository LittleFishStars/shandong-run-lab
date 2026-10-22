package com.byazt.yws;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 866, 20})
public class c extends tt {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile c c;

    private c(Context context) {
        super(context, "ttopensdk2.db");
    }

    public static c c(Context context) {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c(context);
                }
            }
        }
        return c;
    }
}
