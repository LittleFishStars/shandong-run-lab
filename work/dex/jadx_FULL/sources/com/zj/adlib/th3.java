package com.zj.adlib;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class th3 {
    public static final int b = 15;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public static final long f19817b = 1000000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19820a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19822b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f19819a = new a();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public a f19821b = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f19818a = -9223372036854775807L;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44923a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f19823a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f19824a = new boolean[15];
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;

        public static int c(long j) {
            return (int) (j % 15);
        }

        public long a() {
            long j = this.e;
            if (j == 0) {
                return 0L;
            }
            return this.f / j;
        }

        public long b() {
            return this.f;
        }

        public boolean d() {
            long j = this.d;
            if (j == 0) {
                return false;
            }
            return this.f19824a[c(j - 1)];
        }

        public boolean e() {
            return this.d > 15 && this.f44923a == 0;
        }

        public void f(long j) {
            long j2 = this.d;
            if (j2 == 0) {
                this.f19823a = j;
            } else if (j2 == 1) {
                long j3 = j - this.f19823a;
                this.b = j3;
                this.f = j3;
                this.e = 1L;
            } else {
                long j4 = j - this.c;
                int iC = c(j2);
                if (Math.abs(j4 - this.b) <= 1000000) {
                    this.e++;
                    this.f += j4;
                    boolean[] zArr = this.f19824a;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f44923a--;
                    }
                } else {
                    boolean[] zArr2 = this.f19824a;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f44923a++;
                    }
                }
            }
            this.d++;
            this.c = j;
        }

        public void g() {
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.f44923a = 0;
            Arrays.fill(this.f19824a, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f19819a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f19819a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f44922a;
    }

    public long d() {
        if (e()) {
            return this.f19819a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f19819a.e();
    }

    public void f(long j) {
        this.f19819a.f(j);
        if (this.f19819a.e() && !this.f19822b) {
            this.f19820a = false;
        } else if (this.f19818a != -9223372036854775807L) {
            if (!this.f19820a || this.f19821b.d()) {
                this.f19821b.g();
                this.f19821b.f(this.f19818a);
            }
            this.f19820a = true;
            this.f19821b.f(j);
        }
        if (this.f19820a && this.f19821b.e()) {
            a aVar = this.f19819a;
            this.f19819a = this.f19821b;
            this.f19821b = aVar;
            this.f19820a = false;
            this.f19822b = false;
        }
        this.f19818a = j;
        this.f44922a = this.f19819a.e() ? 0 : this.f44922a + 1;
    }

    public void g() {
        this.f19819a.g();
        this.f19821b.g();
        this.f19820a = false;
        this.f19818a = -9223372036854775807L;
        this.f44922a = 0;
    }
}
