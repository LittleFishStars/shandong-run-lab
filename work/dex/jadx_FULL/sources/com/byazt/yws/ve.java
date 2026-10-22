package com.byazt.yws;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 866, 54})
public class ve extends tt {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile ve c;

    private ve(Context context) {
        super(context, "ttopensdk.db");
    }

    public static ve c(Context context) {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve(context);
                }
            }
        }
        return c;
    }
}
