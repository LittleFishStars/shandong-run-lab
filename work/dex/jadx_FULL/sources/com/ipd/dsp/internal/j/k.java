package com.ipd.dsp.internal.j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k implements e {
    public static final String k = "LruBitmapPool";
    public static final Bitmap.Config l = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f38355a;
    public final Set<Bitmap.Config> b;
    public final long c;
    public final a d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;

    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public static final class b implements a {
        @Override // com.ipd.dsp.internal.j.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.ipd.dsp.internal.j.k.a
        public void b(Bitmap bitmap) {
        }
    }

    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Bitmap> f38356a = Collections.synchronizedSet(new HashSet());

        @Override // com.ipd.dsp.internal.j.k.a
        public void a(Bitmap bitmap) {
            if (!this.f38356a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f38356a.remove(bitmap);
        }

        @Override // com.ipd.dsp.internal.j.k.a
        public void b(Bitmap bitmap) {
            if (!this.f38356a.contains(bitmap)) {
                this.f38356a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    public k(long j, l lVar, Set<Bitmap.Config> set) {
        this.c = j;
        this.e = j;
        this.f38355a = lVar;
        this.b = set;
        this.d = new b();
    }

    @NonNull
    public static Bitmap c(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = l;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> h() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    public static l i() {
        return new o();
    }

    @Override // com.ipd.dsp.internal.j.e
    public synchronized void a(float f) {
        this.e = Math.round(this.c * f);
        e();
    }

    @Override // com.ipd.dsp.internal.j.e
    public long b() {
        return this.e;
    }

    @Nullable
    public final synchronized Bitmap d(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap bitmapA;
        a(config);
        bitmapA = this.f38355a.a(i, i2, config != null ? config : l);
        if (bitmapA == null) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(k, "Missing bitmap=" + this.f38355a.b(i, i2, config));
            }
            this.h++;
        } else {
            this.g++;
            this.f -= (long) this.f38355a.b(bitmapA);
            this.d.a(bitmapA);
            c(bitmapA);
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(k, "Get bitmap=" + this.f38355a.b(i, i2, config));
        }
        c();
        return bitmapA;
    }

    public final void e() {
        a(this.e);
    }

    public long f() {
        return this.j;
    }

    public long g() {
        return this.f;
    }

    public long j() {
        return this.g;
    }

    public long k() {
        return this.h;
    }

    @Override // com.ipd.dsp.internal.j.e
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(k, "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    public static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @Override // com.ipd.dsp.internal.j.e
    @NonNull
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapD = d(i, i2, config);
        return bitmapD == null ? c(i, i2, config) : bitmapD;
    }

    @Override // com.ipd.dsp.internal.j.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f38355a.b(bitmap) <= this.e && this.b.contains(bitmap.getConfig())) {
                        int iB = this.f38355a.b(bitmap);
                        this.f38355a.a(bitmap);
                        this.d.b(bitmap);
                        this.i++;
                        this.f += (long) iB;
                        if (Dsp.isDebugLogEnable()) {
                            com.ipd.dsp.internal.c2.k.e(k, "Put bitmap in pool=" + this.f38355a.c(bitmap));
                        }
                        c();
                        e();
                        return;
                    }
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.e(k, "Reject bitmap from pool, bitmap: " + this.f38355a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void b(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    public final void c() {
        if (Dsp.isDebugLogEnable()) {
            d();
        }
    }

    public k(long j) {
        this(j, i(), h());
    }

    public k(long j, Set<Bitmap.Config> set) {
        this(j, i(), set);
    }

    public final void d() {
        com.ipd.dsp.internal.c2.k.e(k, "Hits=" + this.g + ", misses=" + this.h + ", puts=" + this.i + ", evictions=" + this.j + ", currentSize=" + this.f + ", maxSize=" + this.e + "\nStrategy=" + this.f38355a);
    }

    @Override // com.ipd.dsp.internal.j.e
    @NonNull
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapD = d(i, i2, config);
        if (bitmapD != null) {
            bitmapD.eraseColor(0);
            return bitmapD;
        }
        return c(i, i2, config);
    }

    @TargetApi(26)
    public static void a(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @Override // com.ipd.dsp.internal.j.e
    public void a() {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(k, "clearMemory");
        }
        a(0L);
    }

    public final synchronized void a(long j) {
        while (this.f > j) {
            Bitmap bitmapRemoveLast = this.f38355a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(k, "Size mismatch, resetting");
                    d();
                }
                this.f = 0L;
                return;
            }
            this.d.a(bitmapRemoveLast);
            this.f -= (long) this.f38355a.b(bitmapRemoveLast);
            this.j++;
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(k, "Evicting bitmap=" + this.f38355a.c(bitmapRemoveLast));
            }
            c();
            bitmapRemoveLast.recycle();
        }
    }
}
