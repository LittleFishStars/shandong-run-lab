package com.ipd.dsp.internal.c2;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f38230a = {122, 104, 111, 110, 103, 106, 105, 97, 110, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.i, MaterialProgressDrawable.d};

    public static String a(long j, long j2) {
        return String.format(Locale.getDefault(), "下载中: %.2f%%", Double.valueOf((j * 100.0d) / j2));
    }

    public static String b(String str) {
        return str != null ? str : "";
    }

    public static String b(String str, boolean z) {
        if (!c(str)) {
            return "";
        }
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            byte[] bArr = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                byte[] bArr2 = f38230a;
                bArr[i] = (byte) (b ^ bArr2[i % bArr2.length]);
            }
            return z ? b.b(bArr) : b.a(bArr);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean c(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static String d(String str) {
        return b(str, true);
    }

    public static String a(String str) {
        return a(str, true);
    }

    public static String a(String str, boolean z) {
        if (!c(str)) {
            return "";
        }
        try {
            byte[] bArrC = z ? b.c(str) : b.a(str);
            byte[] bArr = new byte[bArrC.length];
            for (int i = 0; i < bArrC.length; i++) {
                byte b = bArrC[i];
                byte[] bArr2 = f38230a;
                bArr[i] = (byte) (b ^ bArr2[i % bArr2.length]);
            }
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Throwable unused) {
            return str;
        }
    }
}
