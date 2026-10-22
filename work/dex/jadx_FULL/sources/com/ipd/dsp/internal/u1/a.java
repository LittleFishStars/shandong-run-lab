package com.ipd.dsp.internal.u1;

import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends GradientDrawable {

    /* JADX INFO: renamed from: com.ipd.dsp.internal.u1.a$a, reason: collision with other inner class name */
    public static class C0921a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f38555a;
        public float b;
        public float c;
        public float d;
        public int e = 0;
        public int f;
        public int g;

        public C0921a a(float f) {
            this.d = f;
            return this;
        }

        public C0921a b(float f) {
            this.c = f;
            return this;
        }

        public C0921a c(float f) {
            this.f38555a = f;
            this.b = f;
            this.c = f;
            this.d = f;
            return this;
        }

        public C0921a d(float f) {
            this.f38555a = f;
            return this;
        }

        public C0921a e(float f) {
            this.b = f;
            return this;
        }

        public C0921a a(int i) {
            this.e = i;
            return this;
        }

        public C0921a a(int i, int i2) {
            this.f = i;
            this.g = i2;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0921a c0921a) {
        setCornerRadii(new float[]{c0921a.f38555a, c0921a.f38555a, c0921a.b, c0921a.b, c0921a.c, c0921a.c, c0921a.d, c0921a.d});
        setColor(c0921a.e);
        if (c0921a.g > 0) {
            setStroke(c0921a.g, c0921a.f);
        }
    }
}
