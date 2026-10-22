package com.kc.openset.util;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OAIDHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OAIDLoadListener f39946a;
    private long b;
    private boolean c = false;
    public boolean d = false;

    @Keep
    public interface OAIDLoadListener {
        void OnError(int i, String str);

        void onSuccess(String str);
    }

    public static native /* synthetic */ Object $r8$lambda$86qrA0a4w0pnqQBVqsJSHJxcv1M(OAIDHelper oAIDHelper, Object obj, Method method, Object[] objArr);

    static {
        OSETSDKProtected.interface11(4946);
    }

    public OAIDHelper(OAIDLoadListener oAIDLoadListener) {
        this.f39946a = oAIDLoadListener;
    }

    private static native int a(Class<?> cls, String str, int i);

    private static native Class<?> a(ClassLoader classLoader, String str);

    private native Object a(ClassLoader classLoader, Class<?> cls);

    private native /* synthetic */ Object a(Object obj, Method method, Object[] objArr);

    private native String a(Context context, String str);

    private native void a(int i, String str);

    private native void a(Context context);

    private native void a(Context context, Class<?> cls);

    private native void a(Context context, ClassLoader classLoader, Class<?> cls, Class<?> cls2, Object obj);

    private native void a(Context context, ClassLoader classLoader, Class<?> cls, Class<?> cls2, Object obj, boolean z);

    private native void a(Class<?> cls, long j);

    private native void a(ClassLoader classLoader, int i, boolean z);

    private native void a(Object obj);

    private native void a(String str);

    public static native boolean a();

    private static native boolean a(Class<?> cls, String str);

    public native void b(Context context);
}
