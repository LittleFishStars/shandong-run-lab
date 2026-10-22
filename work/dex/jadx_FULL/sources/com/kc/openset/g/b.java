package com.kc.openset.g;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f39765a;
    private RSAPublicKey b;
    private RSAPrivateKey c;
    private RSAPublicKey d;
    private final Map<String, String> e = new HashMap();
    private final Map<String, String> f = new HashMap();

    static {
        OSETSDKProtected.interface11(4428);
    }

    private static native String a();

    private native String a(String str);

    private static native byte[] a(Cipher cipher, int i, byte[] bArr, int i2);

    private static native b b();

    private native String b(String str);

    public static native b c();

    public static native KeyFactory d();

    public static native KeyFactory e();

    public static native KeyFactory f();

    private static native void g(String str);

    public native String a(byte[] bArr);

    public native String a(byte[] bArr, RSAPublicKey rSAPublicKey);

    public native void a(String str, String str2);

    public native void b(String str, String str2);

    public native String c(String str);

    public native byte[] d(String str);

    public native String e(String str);

    public native String f(String str);
}
