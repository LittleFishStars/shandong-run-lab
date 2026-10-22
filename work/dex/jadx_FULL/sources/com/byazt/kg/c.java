package com.byazt.kg;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 20})
public class c extends FileObserver {
    public final ve c;
    public final int tt;
    public volatile boolean ve;

    /* JADX INFO: renamed from: com.byazt.kg.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 428, 44})
    public final class C0454c extends com.byazt.jtc.ve {
        public int tt;

        public C0454c(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.tt = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.tt);
            c.this.ve = true;
        }
    }

    public c(ve veVar, String str, int i) {
        super(str, i);
        this.tt = 5000;
        this.ve = true;
        if (veVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.c = veVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.ve && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.c != null) {
            this.ve = false;
            this.c.c(200, "/data/anr/".concat(str), 80);
            new C0454c(5000).start();
        }
    }
}
