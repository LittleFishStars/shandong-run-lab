package com.byazt.a;

import android.content.Context;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 20})
public abstract class c implements n {
    public final Context c;
    public final com.byazt.k.c tt;
    public final String ve;

    public c(Context context, com.byazt.k.c cVar, String str) {
        this.c = context;
        this.tt = cVar;
        this.ve = str;
    }

    public boolean c() {
        if (this.c == null) {
            return false;
        }
        try {
            return tt().resolveActivity(this.c.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.byazt.x.c.c()) {
                m.ve("AbsDevicePlan", "check is valid failed!", th);
            }
        }
    }
}
