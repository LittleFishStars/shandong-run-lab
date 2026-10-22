package com.kwad.sdk.pngencrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n {
    public static Charset bld = Charset.forName("ISO-8859-1");
    public static Charset ble = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> blf = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        private static Boolean Th() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Boolean initialValue() {
            return Th();
        }
    };

    public static byte[] Tg() {
        return new byte[]{-119, 80, 78, 71, 13, 10, com.google.common.base.a.D, 10};
    }

    public static final int d(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int i5 = i4 >= i ? i4 - i : i - i4;
        int i6 = i4 >= i2 ? i4 - i2 : i2 - i4;
        int i7 = i4 >= i3 ? i4 - i3 : i3 - i4;
        if (i5 > i6 || i5 > i7) {
            return i6 <= i7 ? i2 : i3;
        }
        return i;
    }

    public static int e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException unused) {
            return -1;
        }
    }

    public static int f(InputStream inputStream) {
        try {
            int i = inputStream.read();
            int i2 = inputStream.read();
            int i3 = inputStream.read();
            int i4 = inputStream.read();
            if (i != -1 && i2 != -1 && i3 != -1 && i4 != -1) {
                return (i << 24) | (i2 << 16) | ((i3 << 8) + i4);
            }
        } catch (IOException unused) {
        }
        return -1;
    }

    public static final int g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int e(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int f(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }
}
