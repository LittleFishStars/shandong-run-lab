package com.baidu.mshield.b.f;

import android.util.Base64;
import com.zj.adlib.aq6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f26706a;
    public static byte[] b;
    public static byte[] c;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return c(bArr2, bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return d(bArr2, bArr);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.b(bArr2, bArr);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.a(bArr2, bArr);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return null;
        }
    }

    public static synchronized byte[] a(int i) {
        byte[] bArr;
        try {
            if (i == 16) {
                byte[] bArr2 = f26706a;
                if (bArr2 == null || bArr2.length != 16) {
                    f26706a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, aq6.f40585a, 77, 68, 74, 107, 97, 87, 78, com.alibaba.ariver.resource.parser.a.e.j, 90, 71, 108, 104, 89, 103, 61, 61}, 0);
                }
                bArr = f26706a;
            } else if (i != 24) {
                bArr = new byte[0];
            } else {
                byte[] bArr3 = b;
                if (bArr3 == null || bArr3.length != 24) {
                    b = Base64.decode(new byte[]{84, 88, 112, 66, 101, 85, com.alibaba.ariver.resource.parser.a.e.j, 85, 83, 88, 104, 78, 82, 69, 112, 114, 89, 86, 100, 79, 77, 86, 112, 72, 98, 71, 104, 90, 90, 122, com.alibaba.ariver.resource.parser.a.e.i, 57, 10}, 0);
                }
                bArr = b;
            }
        } catch (Throwable th) {
            byte[] bArr4 = new byte[0];
            com.baidu.sec.privacy.f.c.a(th);
            bArr = bArr4;
        }
        return bArr;
    }

    public static synchronized byte[] a() {
        byte[] bArr;
        try {
            byte[] bArr2 = c;
            if (bArr2 == null || bArr2.length != 16) {
                c = Base64.decode(new byte[]{78, 68, 65, 121, 77, 122, 85, aq6.f40585a, 78, 122, 74, 108, 97, 71, 78, 110, 90, 109, 108, 106, 89, 81, 61, 61, 10}, 0);
            }
            bArr = c;
        } catch (Throwable th) {
            bArr = new byte[0];
            com.baidu.sec.privacy.f.c.a(th);
        }
        return bArr;
    }
}
