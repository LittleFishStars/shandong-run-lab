package com.ipd.dsp.internal.m;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.f;
import com.ipd.dsp.internal.j.e;
import com.ipd.dsp.internal.k.j;
import com.ipd.dsp.internal.q.g;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements Runnable {

    @VisibleForTesting
    public static final String n = "PreFillRunner";
    public static final long p = 32;
    public static final long q = 40;
    public static final int r = 4;
    public final e f;
    public final j g;
    public final c h;
    public final C0899a i;
    public final Set<d> j;
    public final Handler k;
    public long l;
    public boolean m;
    public static final C0899a o = new C0899a();
    public static final long s = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: com.ipd.dsp.internal.m.a$a, reason: collision with other inner class name */
    @VisibleForTesting
    public static class C0899a {
        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class b implements f {
        @Override // com.ipd.dsp.internal.f.f
        public void a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, o, new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    public boolean a() {
        Bitmap bitmapCreateBitmap;
        long jA = this.i.a();
        while (!this.h.b() && !a(jA)) {
            d dVarC = this.h.c();
            if (this.j.contains(dVarC)) {
                bitmapCreateBitmap = Bitmap.createBitmap(dVarC.d(), dVarC.b(), dVarC.a());
            } else {
                this.j.add(dVarC);
                bitmapCreateBitmap = this.f.b(dVarC.d(), dVarC.b(), dVarC.a());
            }
            int iA = o.a(bitmapCreateBitmap);
            if (c() >= iA) {
                this.g.a(new b(), g.a(bitmapCreateBitmap, this.f));
            } else {
                this.f.a(bitmapCreateBitmap);
            }
            if (Dsp.isDebugLogEnable()) {
                k.a(n, "allocated [" + dVarC.d() + "x" + dVarC.b() + "] " + dVarC.a() + " size: " + iA);
            }
        }
        return (this.m || this.h.b()) ? false : true;
    }

    public void b() {
        this.m = true;
    }

    public final long c() {
        return this.g.b() - this.g.c();
    }

    public final long d() {
        long j = this.l;
        this.l = Math.min(4 * j, s);
        return j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.k.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    public a(e eVar, j jVar, c cVar, C0899a c0899a, Handler handler) {
        this.j = new HashSet();
        this.l = 40L;
        this.f = eVar;
        this.g = jVar;
        this.h = cVar;
        this.i = c0899a;
        this.k = handler;
    }

    public final boolean a(long j) {
        return this.i.a() - j >= 32;
    }
}
