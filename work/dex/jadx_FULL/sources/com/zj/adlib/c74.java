package com.zj.adlib;

import com.facebook.imageformat.ImageFormat;
import com.google.common.base.a;
import com.ipd.dsp.internal.q.u;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c74 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40912a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f15748a;
    public static final int b = 21;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f15749b;
    public static final int c = 6;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f15750c;
    public static final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final byte[] f15751d;
    public static final byte[] e;

    static {
        byte[] bArr = {-1, u.m7, -1};
        f15748a = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, a.D, 10};
        f15749b = bArr2;
        f15750c = a("GIF87a");
        f15751d = a("GIF89a");
        byte[] bArrA = a("BM");
        e = bArrA;
        d = zg4.a(21, 20, bArr.length, bArr2.length, 6, bArrA.length);
    }

    public static byte[] a(String str) {
        ax6.i(str);
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static ImageFormat b(byte[] bArr, int i) {
        ax6.i(bArr);
        if (yu9.h(bArr, 0, i)) {
            return f(bArr, i);
        }
        if (i(bArr, i)) {
            return ImageFormat.JPEG;
        }
        if (j(bArr, i)) {
            return ImageFormat.PNG;
        }
        if (h(bArr, i)) {
            return ImageFormat.GIF;
        }
        return g(bArr, i) ? ImageFormat.BMP : ImageFormat.UNKNOWN;
    }

    public static ImageFormat c(InputStream inputStream) throws IOException {
        ax6.i(inputStream);
        byte[] bArr = new byte[d];
        return b(bArr, l(inputStream, bArr));
    }

    public static ImageFormat d(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    ImageFormat imageFormatC = c(fileInputStream2);
                    tm1.b(fileInputStream2);
                    return imageFormatC;
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    ImageFormat imageFormat = ImageFormat.UNKNOWN;
                    tm1.b(fileInputStream);
                    return imageFormat;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    tm1.b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }

    public static ImageFormat e(InputStream inputStream) {
        try {
            return c(inputStream);
        } catch (IOException e2) {
            throw i69.d(e2);
        }
    }

    public static ImageFormat f(byte[] bArr, int i) {
        ax6.d(yu9.h(bArr, 0, i));
        if (yu9.g(bArr, 0)) {
            return ImageFormat.WEBP_SIMPLE;
        }
        if (yu9.f(bArr, 0)) {
            return ImageFormat.WEBP_LOSSLESS;
        }
        if (!yu9.c(bArr, 0, i)) {
            return ImageFormat.UNKNOWN;
        }
        if (yu9.b(bArr, 0)) {
            return ImageFormat.WEBP_ANIMATED;
        }
        return yu9.d(bArr, 0) ? ImageFormat.WEBP_EXTENDED_WITH_ALPHA : ImageFormat.WEBP_EXTENDED;
    }

    public static boolean g(byte[] bArr, int i) {
        byte[] bArr2 = e;
        if (i < bArr2.length) {
            return false;
        }
        return k(bArr, 0, bArr2);
    }

    public static boolean h(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return k(bArr, 0, f15750c) || k(bArr, 0, f15751d);
    }

    public static boolean i(byte[] bArr, int i) {
        byte[] bArr2 = f15748a;
        return i >= bArr2.length && k(bArr, 0, bArr2);
    }

    public static boolean j(byte[] bArr, int i) {
        byte[] bArr2 = f15749b;
        return i >= bArr2.length && k(bArr, 0, bArr2);
    }

    public static boolean k(byte[] bArr, int i, byte[] bArr2) {
        ax6.i(bArr);
        ax6.i(bArr2);
        ax6.d(i >= 0);
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int l(InputStream inputStream, byte[] bArr) throws IOException {
        ax6.i(inputStream);
        ax6.i(bArr);
        int length = bArr.length;
        int i = d;
        ax6.d(length >= i);
        if (!inputStream.markSupported()) {
            return s51.b(inputStream, bArr, 0, i);
        }
        try {
            inputStream.mark(i);
            return s51.b(inputStream, bArr, 0, i);
        } finally {
            inputStream.reset();
        }
    }
}
