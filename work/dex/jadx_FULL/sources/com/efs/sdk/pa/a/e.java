package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class e implements Printer {
    private long f;
    private boolean b = false;
    private String c = null;
    private long d = -1;
    private long e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Vector<d> f29927a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            this.d = SystemClock.elapsedRealtime();
            this.e = SystemClock.currentThreadTimeMillis();
            this.c = str;
            this.b = true;
            Iterator<d> it = this.f29927a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        if (this.b && str.startsWith("<")) {
            this.b = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.d;
            if (jElapsedRealtime > this.f) {
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.e;
                Iterator<d> it2 = this.f29927a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.c, jElapsedRealtime, jCurrentThreadTimeMillis);
                }
            }
        }
    }
}
