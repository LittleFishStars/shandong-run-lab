package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f38347a = new b();
    public final h<a, Bitmap> b = new h<>();

    @VisibleForTesting
    public static class b extends d<a> {
        @Override // com.ipd.dsp.internal.j.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a a(int i, int i2, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i, i2, config);
            return aVarB;
        }
    }

    public static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.ipd.dsp.internal.j.l
    public void a(Bitmap bitmap) {
        this.b.a(this.f38347a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.ipd.dsp.internal.j.l
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    @Override // com.ipd.dsp.internal.j.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.ipd.dsp.internal.j.l
    public Bitmap removeLast() {
        return this.b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    public static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.ipd.dsp.internal.j.l
    public int b(Bitmap bitmap) {
        return com.ipd.dsp.internal.d0.o.a(bitmap);
    }

    @VisibleForTesting
    public static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f38348a;
        public int b;
        public int c;
        public Bitmap.Config d;

        public a(b bVar) {
            this.f38348a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.b, this.c, this.d);
        }

        @Override // com.ipd.dsp.internal.j.m
        public void a() {
            this.f38348a.a(this);
        }
    }

    @Override // com.ipd.dsp.internal.j.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.b.a(this.f38347a.a(i, i2, config));
    }
}
