package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.NavigableMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p implements l {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f38360a = new b();
    public final h<a, Bitmap> b = new h<>();
    public final NavigableMap<Integer, Integer> c = new n();

    @VisibleForTesting
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f38361a;
        public int b;

        public a(b bVar) {
            this.f38361a = bVar;
        }

        public void a(int i) {
            this.b = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }

        public String toString() {
            return p.a(this.b);
        }

        @Override // com.ipd.dsp.internal.j.m
        public void a() {
            this.f38361a.a(this);
        }
    }

    @VisibleForTesting
    public static class b extends d<a> {
        @Override // com.ipd.dsp.internal.j.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a a(int i) {
            a aVar = (a) super.b();
            aVar.a(i);
            return aVar;
        }
    }

    private static String d(Bitmap bitmap) {
        return a(com.ipd.dsp.internal.d0.o.a(bitmap));
    }

    @Override // com.ipd.dsp.internal.j.l
    public void a(Bitmap bitmap) {
        a aVarA = this.f38360a.a(com.ipd.dsp.internal.d0.o.a(bitmap));
        this.b.a(aVarA, bitmap);
        Integer num = this.c.get(Integer.valueOf(aVarA.b));
        this.c.put(Integer.valueOf(aVarA.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.ipd.dsp.internal.j.l
    public String b(int i, int i2, Bitmap.Config config) {
        return a(com.ipd.dsp.internal.d0.o.a(i, i2, config));
    }

    @Override // com.ipd.dsp.internal.j.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.ipd.dsp.internal.j.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapA = this.b.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.ipd.dsp.internal.d0.o.a(bitmapA)));
        }
        return bitmapA;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.b + "\n  SortedSizes" + this.c;
    }

    @Override // com.ipd.dsp.internal.j.l
    public int b(Bitmap bitmap) {
        return com.ipd.dsp.internal.d0.o.a(bitmap);
    }

    @Override // com.ipd.dsp.internal.j.l
    @Nullable
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int iA = com.ipd.dsp.internal.d0.o.a(i, i2, config);
        a aVarA = this.f38360a.a(iA);
        Integer numCeilingKey = this.c.ceilingKey(Integer.valueOf(iA));
        if (numCeilingKey != null && numCeilingKey.intValue() != iA && numCeilingKey.intValue() <= iA * 8) {
            this.f38360a.a(aVarA);
            aVarA = this.f38360a.a(numCeilingKey.intValue());
        }
        Bitmap bitmapA = this.b.a(aVarA);
        if (bitmapA != null) {
            bitmapA.reconfigure(i, i2, config);
            a(numCeilingKey);
        }
        return bitmapA;
    }

    public final void a(Integer num) {
        Integer num2 = this.c.get(num);
        if (num2.intValue() == 1) {
            this.c.remove(num);
        } else {
            this.c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public static String a(int i) {
        return "[" + i + "]";
    }
}
