package com.kc.openset.pine.utils;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class ReflectionHelper {
    private static Field override;

    static {
        OSETSDKProtected.interface11(4675);
    }

    private ReflectionHelper() {
    }

    public static native <T> Constructor<T> findConstructor(Class<T> cls, Class<?>... clsArr);

    public static native Field findField(Class<?> cls, String str);

    public static native Method findMethod(Class<?> cls, String str, Class<?>... clsArr);

    public static native void forceAccessible(AccessibleObject accessibleObject);

    public static native <T> Constructor<T> getConstructor(Class<T> cls, Class<?>... clsArr);

    public static native Field getField(Class<?> cls, String str);

    public static native Method getMethod(Class<?> cls, String str, Class<?>... clsArr);
}
