package com.byazt.kg;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 34})
public class a {
    public static volatile a c;
    public final ve tt;

    private a(@NonNull Context context) {
        this.tt = new ve(context);
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

    public void c() {
        this.tt.c();
    }
}
