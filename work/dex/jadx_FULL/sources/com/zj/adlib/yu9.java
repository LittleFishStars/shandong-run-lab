package com.zj.adlib;

import com.facebook.common.webp.WebpBitmapFactory;
import com.google.common.base.a;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class yu9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46122a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WebpBitmapFactory f20932a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20933a = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f20935a;
    public static final int b = 21;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f20937b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f20938c;
    public static boolean d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final byte[] f20939d;
    public static final byte[] e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f20934a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final boolean f20936b = true;
    public static final boolean c = e();

    static {
        f20932a = null;
        d = false;
        try {
            f20932a = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
            d = true;
        } catch (Throwable unused) {
            d = false;
        }
        f20935a = a("RIFF");
        f20937b = a("WEBP");
        f20938c = a("VP8 ");
        f20939d = a("VP8L");
        e = a("VP8X");
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, int i) {
        return j(bArr, i + 12, e) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean c(byte[] bArr, int i, int i2) {
        return i2 >= 21 && j(bArr, i + 12, e);
    }

    public static boolean d(byte[] bArr, int i) {
        return j(bArr, i + 12, e) && ((bArr[i + 20] & a.r) == 16);
    }

    public static boolean e() {
        return true;
    }

    public static boolean f(byte[] bArr, int i) {
        return j(bArr, i + 12, f20939d);
    }

    public static boolean g(byte[] bArr, int i) {
        return j(bArr, i + 12, f20938c);
    }

    public static boolean h(byte[] bArr, int i, int i2) {
        return i2 >= 20 && j(bArr, i, f20935a) && j(bArr, i + 8, f20937b);
    }

    public static boolean i(byte[] bArr, int i, int i2) {
        if (g(bArr, i)) {
            return f20936b;
        }
        if (f(bArr, i)) {
            return c;
        }
        if (!c(bArr, i, i2) || b(bArr, i)) {
            return false;
        }
        return c;
    }

    public static boolean j(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
