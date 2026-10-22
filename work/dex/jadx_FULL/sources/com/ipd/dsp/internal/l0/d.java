package com.ipd.dsp.internal.l0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.m0.h;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38398a;
    public final com.ipd.dsp.internal.n0.d b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile IOException i;

    public static class a extends d {
        public a(IOException iOException) {
            super(null);
            e(iOException);
        }
    }

    public d(@NonNull com.ipd.dsp.internal.n0.d dVar) {
        this.b = dVar;
    }

    @NonNull
    public com.ipd.dsp.internal.n0.d a() {
        com.ipd.dsp.internal.n0.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public IOException b() {
        return this.i;
    }

    public String c() {
        return this.f38398a;
    }

    public com.ipd.dsp.internal.i0.b d() {
        return ((com.ipd.dsp.internal.m0.f) this.i).a();
    }

    public boolean e() {
        return this.g;
    }

    public boolean f() {
        return this.c || this.d || this.e || this.f || this.g || this.h;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.c;
    }

    public boolean i() {
        return this.e;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.d;
    }

    public void l() {
        this.g = true;
    }

    public void m() {
        this.d = true;
    }

    public void a(String str) {
        this.f38398a = str;
    }

    public void b(IOException iOException) {
        this.h = true;
        this.i = iOException;
    }

    public void c(IOException iOException) {
        this.c = true;
        this.i = iOException;
    }

    public void d(IOException iOException) {
        this.e = true;
        this.i = iOException;
    }

    public void e(IOException iOException) {
        this.f = true;
        this.i = iOException;
    }

    public d() {
        this.b = null;
    }

    public void a(IOException iOException) {
        if (k()) {
            return;
        }
        if (iOException instanceof com.ipd.dsp.internal.m0.f) {
            c(iOException);
            return;
        }
        if (iOException instanceof h) {
            d(iOException);
            return;
        }
        if (iOException == com.ipd.dsp.internal.m0.b.f) {
            l();
            return;
        }
        if (iOException instanceof com.ipd.dsp.internal.m0.e) {
            b(iOException);
            return;
        }
        if (iOException != com.ipd.dsp.internal.m0.c.f) {
            e(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            com.ipd.dsp.internal.g0.c.a("DownloadCache", "catch unknown error " + iOException);
        }
    }
}
