package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46286a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f21086a;

    public zl0(int i) {
        this.f21086a = new byte[i];
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f46286a;
            this.f46286a = i3 + 1;
            d(i3, z);
        }
    }

    public byte[] b(int i) {
        int length = this.f21086a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f21086a[i2 / i];
        }
        return bArr;
    }

    public void c(int i, byte b) {
        this.f21086a[i] = b;
    }

    public final void d(int i, boolean z) {
        this.f21086a[i] = z ? (byte) 1 : (byte) 0;
    }
}
