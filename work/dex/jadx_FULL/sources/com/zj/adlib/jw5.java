package com.zj.adlib;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f17516a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17517b;

    public jw5(int i, int i2) {
        this.f42688a = i;
        byte[] bArr = new byte[i2 + 3];
        this.f17516a = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f17515a) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f17516a;
            int length = bArr2.length;
            int i4 = this.b;
            if (length < i4 + i3) {
                this.f17516a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f17516a, this.b, i3);
            this.b += i3;
        }
    }

    public boolean b(int i) {
        if (!this.f17515a) {
            return false;
        }
        this.b -= i;
        this.f17515a = false;
        this.f17517b = true;
        return true;
    }

    public boolean c() {
        return this.f17517b;
    }

    public void d() {
        this.f17515a = false;
        this.f17517b = false;
    }

    public void e(int i) {
        sb0.i(!this.f17515a);
        boolean z = i == this.f42688a;
        this.f17515a = z;
        if (z) {
            this.b = 3;
            this.f17517b = false;
        }
    }
}
