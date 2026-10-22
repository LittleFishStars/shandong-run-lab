package com.zj.adlib;

import com.google.zxing.LuminanceSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class dh4 extends LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LuminanceSource f41182a;

    public dh4(LuminanceSource luminanceSource) {
        super(luminanceSource.e(), luminanceSource.b());
        this.f41182a = luminanceSource;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource a(int i, int i2, int i3, int i4) {
        return new dh4(this.f41182a.a(i, i2, i3, i4));
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] c() {
        byte[] bArrC = this.f41182a.c();
        int iE = e() * b();
        byte[] bArr = new byte[iE];
        for (int i = 0; i < iE; i++) {
            bArr[i] = (byte) (255 - (bArrC[i] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] d(int i, byte[] bArr) {
        byte[] bArrD = this.f41182a.d(i, bArr);
        int iE = e();
        for (int i2 = 0; i2 < iE; i2++) {
            bArrD[i2] = (byte) (255 - (bArrD[i2] & 255));
        }
        return bArrD;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource f() {
        return this.f41182a;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean g() {
        return this.f41182a.g();
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean h() {
        return this.f41182a.h();
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource i() {
        return new dh4(this.f41182a.i());
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource j() {
        return new dh4(this.f41182a.j());
    }
}
