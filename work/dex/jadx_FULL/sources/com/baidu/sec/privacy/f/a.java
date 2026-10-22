package com.baidu.sec.privacy.f;

import android.util.Base64;
import com.zj.adlib.aq6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f26816a;

    public static String a(byte[] bArr) {
        byte[] bArrB;
        if (bArr != null) {
            try {
                if (bArr.length != 0 && (bArrB = b(a(), bArr)) != null && bArrB.length > 0) {
                    return Base64.encodeToString(bArrB, 0);
                }
                return null;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.a(bArr2, bArr);
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new String(a(a(), Base64.decode(str, 0)));
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.b(bArr2, bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized byte[] a() {
        byte[] bArr;
        try {
            byte[] bArr2 = f26816a;
            if (bArr2 == null || bArr2.length != 16) {
                f26816a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, aq6.f40585a, 77, 68, 74, 107, 97, 87, 78, com.alibaba.ariver.resource.parser.a.e.j, 90, 71, 108, 104, 89, 103, 61, 61}, 0);
            }
            bArr = f26816a;
        } catch (Throwable th) {
            bArr = new byte[0];
            c.a(th);
        }
        return bArr;
    }
}
