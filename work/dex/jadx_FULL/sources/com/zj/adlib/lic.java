package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lic extends ric {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f43077a;
    public int c;
    public int d;
    public int e;

    public /* synthetic */ lic(byte[] bArr, int i, int i2, boolean z, iic iicVar) {
        super(null);
        this.e = Integer.MAX_VALUE;
        this.f43077a = bArr;
        this.c = 0;
    }

    public final int c(int i) throws zzeo {
        int i2 = this.e;
        this.e = 0;
        int i3 = this.c + this.d;
        this.c = i3;
        if (i3 > 0) {
            this.d = i3;
            this.c = i3 - i3;
        } else {
            this.d = 0;
        }
        return i2;
    }
}
