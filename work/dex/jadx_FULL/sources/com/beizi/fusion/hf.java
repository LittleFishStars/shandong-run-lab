package com.beizi.fusion;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface hf {

    public static class a {
        public static hf a() {
            return new aq();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f27364a;
        private long b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k;
        private float l;
        private int m;
        private int n;

        public float a() {
            return this.e;
        }

        public float b() {
            return this.f;
        }

        public long c() {
            return this.f27364a;
        }

        public float d() {
            return this.c;
        }

        public float e() {
            return this.d;
        }

        public float f() {
            return this.i;
        }

        public float g() {
            return this.j;
        }

        public long h() {
            return this.b;
        }

        public float i() {
            return this.g;
        }

        public float j() {
            return this.h;
        }

        public int k() {
            return this.n;
        }

        public int l() {
            return this.m;
        }

        public float m() {
            return this.k;
        }

        public float n() {
            return this.l;
        }

        public void o() {
            this.f27364a = System.currentTimeMillis();
        }

        public void p() {
            this.b = System.currentTimeMillis();
        }

        public void a(float f, float f2) {
            this.e = f;
            this.f = f2;
        }

        public void b(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public void c(float f, float f2) {
            this.i = f;
            this.j = f2;
        }

        public void d(float f, float f2) {
            this.g = f;
            this.h = f2;
        }

        public void a(View view) {
            this.k = view.getX();
            this.l = view.getY();
            this.m = view.getMeasuredWidth();
            this.n = view.getMeasuredHeight();
        }
    }

    b a();

    void a(MotionEvent motionEvent);

    void a(View view);

    void a(View view, int i);

    void a(View view, View view2, MotionEvent motionEvent);
}
