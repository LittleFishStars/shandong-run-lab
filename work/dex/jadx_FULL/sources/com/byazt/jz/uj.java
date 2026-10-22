package com.byazt.jz;

import android.content.Context;
import com.byazt.mg.da;
import com.byazt.mg.i;
import com.byazt.rx.sp;
import com.byazt.uy.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 232, 15})
public final class uj implements Runnable {
    public Context c;

    private uj(Context context) {
        this.c = context;
    }

    public static void c(Context context, int i) {
        try {
            if (!x.c().uj().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        sp.tt().postDelayed(new uj(context), i);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.byazt.rx.ve(this.c).c(i.tt(this.c));
        } catch (Throwable th) {
            try {
                da.tt(th);
            } finally {
                com.byazt.vr.ve.c(sp.tt(), this.c).c();
            }
        }
    }

    public static void c(Context context) {
        c(context, 0);
    }
}
