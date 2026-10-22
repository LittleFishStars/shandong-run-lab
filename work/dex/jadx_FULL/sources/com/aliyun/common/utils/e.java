package com.aliyun.common.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    public static int a(byte[] bArr, int i, boolean z) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        int i5 = bArr[i + 3] & 255;
        return z ? i5 | (i2 << 24) | (i3 << 16) | (i4 << 8) : (i5 << 24) | (i4 << 16) | (i3 << 8) | i2;
    }
}
