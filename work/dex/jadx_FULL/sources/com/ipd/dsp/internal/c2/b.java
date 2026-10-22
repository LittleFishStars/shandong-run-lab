package com.ipd.dsp.internal.c2;

import android.util.Base64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    public static byte[] a(String str) {
        return Base64.decode(str, 2);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 2));
    }

    public static byte[] c(String str) {
        return Base64.decode(str, 11);
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }
}
