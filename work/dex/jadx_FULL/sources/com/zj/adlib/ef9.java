package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ef9 implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yt2 f41427a = new yt2();

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.f41427a.a('0' + str, BarcodeFormat.EAN_13, i, i2, map);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return a(str, barcodeFormat, i, i2, null);
    }
}
