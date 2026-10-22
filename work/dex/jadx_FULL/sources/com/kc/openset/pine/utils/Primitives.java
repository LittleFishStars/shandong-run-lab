package com.kc.openset.pine.utils;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class Primitives {
    private static final String TAG = OSETSDKProtected.getString2(2375);
    private static int baseOffsetOfObjectArray;
    private static Field classAccessFlagsField;
    private static Method getInt;
    private static Method putObject;
    private static Field shadowKlassField;
    private static Field superClassField;
    private static boolean triedGetShadowKlassField;
    private static Object unsafe;
    private static Class<?> unsafeClass;

    static {
        OSETSDKProtected.interface11(4674);
    }

    public static native int bytes2Int(byte[] bArr);

    public static native long currentArtThread();

    private static native void ensureUnsafeReady();

    public static native int evenUp(int i);

    public static native double floats2Double(float f, float f2);

    public static native long getAddress(Object obj);

    public static native int getFieldOffset(Field field);

    private static native Object getUnsafe();

    public static native byte[] int2Bytes(int i);

    public static native double ints2Double(int i, int i2);

    public static native long ints2Long(int i, int i2);

    public static native void removeClassFinalFlag(Class<?> cls);

    public static native void setObjectClass(Object obj, Class<?> cls);

    public static native void setSuperClass(Class<?> cls, Class<?> cls2);
}
