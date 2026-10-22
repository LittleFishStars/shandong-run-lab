package com.zj.adlib;

import com.ipd.dsp.internal.i.q;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class r51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[][] f19236a;
    public final int b;

    public r51(int i, int i2) {
        this.f19236a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.f44373a = i;
        this.b = i2;
    }

    public void a(byte b) {
        for (byte[] bArr : this.f19236a) {
            Arrays.fill(bArr, b);
        }
    }

    public byte b(int i, int i2) {
        return this.f19236a[i2][i];
    }

    public byte[][] c() {
        return this.f19236a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.f44373a;
    }

    public void f(int i, int i2, byte b) {
        this.f19236a[i2][i] = b;
    }

    public void g(int i, int i2, int i3) {
        this.f19236a[i2][i] = (byte) i3;
    }

    public void h(int i, int i2, boolean z) {
        this.f19236a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f44373a * 2 * this.b) + 2);
        for (int i = 0; i < this.b; i++) {
            byte[] bArr = this.f19236a[i];
            for (int i2 = 0; i2 < this.f44373a; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append(q.a.i);
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
