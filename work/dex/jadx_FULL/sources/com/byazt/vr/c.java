package com.byazt.vr;

import android.os.Handler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1683, 20})
public abstract class c implements Runnable {
    public Handler c;
    public final long tt;
    public final long ve;

    public c(Handler handler, long j, long j2) {
        this.c = handler;
        this.tt = j;
        this.ve = j2;
    }

    public void c() {
        if (tt() > 0) {
            this.c.postDelayed(this, tt());
        } else {
            this.c.post(this);
        }
    }

    public long tt() {
        return this.tt;
    }

    public long ve() {
        return this.ve;
    }

    public void c(long j) {
        if (j > 0) {
            this.c.postDelayed(this, j);
        } else {
            this.c.post(this);
        }
    }
}
