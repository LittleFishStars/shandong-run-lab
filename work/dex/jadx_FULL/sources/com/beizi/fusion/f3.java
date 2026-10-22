package com.beizi.fusion;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f3 implements ma {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f3 f27262a = new f3();
    }

    private f3() {
        if (a.f27262a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static byte[] a(String str) {
        try {
            return Base64.decode(str, 2);
        } catch (Exception e) {
            om.a(e);
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 2));
        } catch (Exception e) {
            om.a(e);
            return "";
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(Base64.decode(bArr, 2));
        } catch (Exception e) {
            om.a(e);
            return "";
        }
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e) {
            om.a(e);
            return "";
        }
    }

    public static f3 a() {
        return a.f27262a;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e) {
            om.a(e);
            return "";
        }
    }

    @Override // com.beizi.fusion.ma
    public byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 2);
        } catch (Exception e) {
            om.a(e);
            return null;
        }
    }

    @Override // com.beizi.fusion.ma
    public byte[] b(byte[] bArr) {
        try {
            return Base64.encode(bArr, 2);
        } catch (Exception e) {
            om.a(e);
            return null;
        }
    }
}
