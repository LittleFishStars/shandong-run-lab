package com.zj.adlib;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x79<V> {
    public static final int c = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f20615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public V[] f20616a;
    public int b;

    public x79() {
        this(10);
    }

    public static <V> V[] f(int i) {
        return (V[]) new Object[i];
    }

    public synchronized void a(long j, V v) {
        d(j);
        e();
        b(j, v);
    }

    public final void b(long j, V v) {
        int i = this.f45760a;
        int i2 = this.b;
        V[] vArr = this.f20616a;
        int length = (i + i2) % vArr.length;
        this.f20615a[length] = j;
        vArr[length] = v;
        this.b = i2 + 1;
    }

    public synchronized void c() {
        this.f45760a = 0;
        this.b = 0;
        Arrays.fill(this.f20616a, (Object) null);
    }

    public final void d(long j) {
        int i = this.b;
        if (i > 0) {
            if (j <= this.f20615a[((this.f45760a + i) - 1) % this.f20616a.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.f20616a.length;
        if (this.b < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) f(i);
        int i2 = this.f45760a;
        int i3 = length - i2;
        System.arraycopy(this.f20615a, i2, jArr, 0, i3);
        System.arraycopy(this.f20616a, this.f45760a, vArr, 0, i3);
        int i4 = this.f45760a;
        if (i4 > 0) {
            System.arraycopy(this.f20615a, 0, jArr, i3, i4);
            System.arraycopy(this.f20616a, 0, vArr, i3, this.f45760a);
        }
        this.f20615a = jArr;
        this.f20616a = vArr;
        this.f45760a = 0;
    }

    @Nullable
    public synchronized V g(long j) {
        return h(j, false);
    }

    @Nullable
    public final V h(long j, boolean z) {
        V vK = null;
        long j2 = Long.MAX_VALUE;
        while (this.b > 0) {
            long j3 = j - this.f20615a[this.f45760a];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            vK = k();
            j2 = j3;
        }
        return vK;
    }

    @Nullable
    public synchronized V i() {
        return this.b == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j) {
        return h(j, true);
    }

    @Nullable
    public final V k() {
        sb0.i(this.b > 0);
        V[] vArr = this.f20616a;
        int i = this.f45760a;
        V v = vArr[i];
        vArr[i] = null;
        this.f45760a = (i + 1) % vArr.length;
        this.b--;
        return v;
    }

    public synchronized int l() {
        return this.b;
    }

    public x79(int i) {
        this.f20615a = new long[i];
        this.f20616a = (V[]) f(i);
    }
}
