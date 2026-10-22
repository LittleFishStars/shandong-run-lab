package com.beizi.fusion;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface we {

    public static class a {
        public static we a() {
            return new ln();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f27907a;
        public float b;
        public float c;
        private final float d;

        public b(float f, float f2, float f3, float f4) {
            this.f27907a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        public float a(String str) {
            if ("x".equalsIgnoreCase(str)) {
                return this.f27907a;
            }
            if ("y".equalsIgnoreCase(str)) {
                return this.b;
            }
            if (com.google.android.exoplayer2.source.rtsp.j.o.equalsIgnoreCase(str)) {
                return this.c;
            }
            if ("xyz".equalsIgnoreCase(str)) {
                return this.d;
            }
            return -1.0f;
        }
    }

    c a();

    void a(int i, float f, float f2, float f3, float f4, long j);

    long b();

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f27908a = new HashMap();
        private long b = 0;

        public void a(int i, b bVar, long j) {
            this.f27908a.put(Integer.valueOf(i), bVar);
            this.b = j;
        }

        public b a(int i) {
            return (b) this.f27908a.get(Integer.valueOf(i));
        }

        public long a() {
            return this.b;
        }
    }
}
