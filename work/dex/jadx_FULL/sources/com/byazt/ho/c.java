package com.byazt.ho;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.vb.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2240, 20})
public class c {
    public static volatile c uj = null;
    public static int ve = 3000;
    public volatile HandlerThread c;
    public Looper n;
    public volatile Handler tt = null;

    private c(n nVar) {
        this.c = null;
        this.n = null;
        if (nVar != null && nVar.uj() != null && nVar.uj().z() != null) {
            this.n = nVar.uj().z();
        } else {
            this.c = new HandlerThread("csj_ad_log", 10);
            this.c.start();
        }
    }

    public static c c(n nVar) {
        if (uj == null) {
            synchronized (c.class) {
                if (uj == null) {
                    uj = new c(nVar);
                }
            }
        }
        return uj;
    }

    public int tt() {
        if (ve <= 0) {
            ve = 3000;
        }
        return ve;
    }

    public Handler c() {
        if (this.n != null) {
            if (this.tt == null) {
                synchronized (c.class) {
                    if (this.tt == null) {
                        this.tt = new Handler(this.n);
                    }
                }
            }
        } else if (this.c != null && this.c.isAlive()) {
            if (this.tt == null) {
                synchronized (c.class) {
                    if (this.tt == null) {
                        this.tt = new Handler(this.c.getLooper());
                    }
                }
            }
        } else {
            synchronized (c.class) {
                if (this.c == null || !this.c.isAlive()) {
                    this.c = new HandlerThread("csj_init_handle", -1);
                    this.c.start();
                    this.tt = new Handler(this.c.getLooper());
                }
            }
        }
        return this.tt;
    }
}
