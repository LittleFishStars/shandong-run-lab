package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rmc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ric f44487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ByteBuffer f19383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f19385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Charset f19384a = Charset.forName("US-ASCII");
    public static final Charset b = Charset.forName("UTF-8");
    public static final Charset c = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        f19385a = bArr;
        f19383a = ByteBuffer.wrap(bArr);
        int i = ric.b;
        lic licVar = new lic(bArr, 0, 0, false, null);
        try {
            licVar.c(0);
            f44487a = licVar;
        } catch (zzeo e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String d(byte[] bArr) {
        return new String(bArr, b);
    }
}
