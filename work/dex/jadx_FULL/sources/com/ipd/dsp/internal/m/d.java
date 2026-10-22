package com.ipd.dsp.internal.m;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.d0.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {

    @VisibleForTesting
    public static final Bitmap.Config e = Bitmap.Config.RGB_565;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38406a;
    public final int b;
    public final Bitmap.Config c;
    public final int d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38407a;
        public final int b;
        public Bitmap.Config c;
        public int d;

        public a(int i) {
            this(i, i);
        }

        public a a(@Nullable Bitmap.Config config) {
            this.c = config;
            return this;
        }

        public Bitmap.Config b() {
            return this.c;
        }

        public a(int i, int i2) {
            this.d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f38407a = i;
            this.b = i2;
        }

        public a a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.d = i;
            return this;
        }

        public d a() {
            return new d(this.f38407a, this.b, this.c, this.d);
        }
    }

    public d(int i, int i2, Bitmap.Config config, int i3) {
        this.c = (Bitmap.Config) m.a(config, "Config must not be null");
        this.f38406a = i;
        this.b = i2;
        this.d = i3;
    }

    public Bitmap.Config a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.f38406a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.b == dVar.b && this.f38406a == dVar.f38406a && this.d == dVar.d && this.c == dVar.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f38406a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f38406a + ", height=" + this.b + ", config=" + this.c + ", weight=" + this.d + '}';
    }
}
