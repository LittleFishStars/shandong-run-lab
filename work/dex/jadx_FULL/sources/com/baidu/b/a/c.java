package com.baidu.b.a;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class c {
    public static void a(byte[] bArr, byte[] bArr2, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("start should be more than zero!");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("dst array should not be null or empty");
        }
        if (bArr2 == null || bArr2.length == 0) {
            throw new IllegalArgumentException("src array should not be null or empty");
        }
        if (bArr.length < bArr2.length) {
            throw new IllegalArgumentException("dst array length should be longer than:" + bArr2.length);
        }
        if (bArr.length >= bArr2.length + i) {
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            return;
        }
        throw new IllegalArgumentException("start should be less than:" + (bArr.length - bArr2.length));
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("original array should not be null or empty");
        }
        if (i >= 0) {
            return Arrays.copyOf(bArr, i);
        }
        throw new IllegalArgumentException("length should be more than zero!");
    }
}
