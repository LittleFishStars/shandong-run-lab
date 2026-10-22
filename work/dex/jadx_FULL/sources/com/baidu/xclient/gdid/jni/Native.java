package com.baidu.xclient.gdid.jni;

import com.alipay.sdk.m.y.l;
import com.baidu.xclient.gdid.j.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Native {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26838a = "";

    static {
        try {
            System.loadLibrary("tiny_magic");
        } catch (Throwable th) {
            f26838a = f.b(th).replaceAll("\t", l.b).replaceAll("\n", l.b);
            throw th;
        }
    }

    public String a() {
        return f26838a;
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] acn(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native byte[] dcn(byte[] bArr, byte[] bArr2);

    public native Object jnictl(int i, Object obj, Object obj2, Object obj3);
}
