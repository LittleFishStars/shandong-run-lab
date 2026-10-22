package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ug7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f20059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BarcodeFormat f20060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<ResultMetadataType, Object> f20062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f20063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xg7[] f20064a;

    public ug7(String str, byte[] bArr, xg7[] xg7VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, xg7VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(xg7[] xg7VarArr) {
        xg7[] xg7VarArr2 = this.f20064a;
        if (xg7VarArr2 == null) {
            this.f20064a = xg7VarArr;
            return;
        }
        if (xg7VarArr == null || xg7VarArr.length <= 0) {
            return;
        }
        xg7[] xg7VarArr3 = new xg7[xg7VarArr2.length + xg7VarArr.length];
        System.arraycopy(xg7VarArr2, 0, xg7VarArr3, 0, xg7VarArr2.length);
        System.arraycopy(xg7VarArr, 0, xg7VarArr3, xg7VarArr2.length, xg7VarArr.length);
        this.f20064a = xg7VarArr3;
    }

    public BarcodeFormat b() {
        return this.f20060a;
    }

    public int c() {
        return this.f45144a;
    }

    public byte[] d() {
        return this.f20063a;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.f20062a;
    }

    public xg7[] f() {
        return this.f20064a;
    }

    public String g() {
        return this.f20061a;
    }

    public long h() {
        return this.f20059a;
    }

    public void i(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f20062a;
            if (map2 == null) {
                this.f20062a = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f20062a == null) {
            this.f20062a = new EnumMap(ResultMetadataType.class);
        }
        this.f20062a.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f20061a;
    }

    public ug7(String str, byte[] bArr, xg7[] xg7VarArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, xg7VarArr, barcodeFormat, j);
    }

    public ug7(String str, byte[] bArr, int i, xg7[] xg7VarArr, BarcodeFormat barcodeFormat, long j) {
        this.f20061a = str;
        this.f20063a = bArr;
        this.f45144a = i;
        this.f20064a = xg7VarArr;
        this.f20060a = barcodeFormat;
        this.f20062a = null;
        this.f20059a = j;
    }
}
