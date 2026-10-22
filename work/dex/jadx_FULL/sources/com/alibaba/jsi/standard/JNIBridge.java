package com.alibaba.jsi.standard;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
class JNIBridge {
    public static native long nativeCommand(long j, long j2, Object[] objArr);

    public static native long nativeCreateContext(long j, String str, HashSet<Object> hashSet);

    public static native void nativeDisposeContext(long j, long j2);

    public static native void nativeDisposeInstance(long j);

    public static native Object nativeExecuteJS(long j, long j2, String str, String str2);

    public static native String nativeGetVersion(String str);

    public static native long nativeInitInstance(String str, String str2, String str3);

    public static native void nativeOnLoop(long j);

    public static native void nativeOnLowMemory(long j);

    public static native void nativeResetContext(long j, long j2);

    public static native boolean nativeSetInfo(long j, String str, String str2, long j2);

    public static native boolean nativeStartTrace(long j, String str, String str2);

    public static native void nativeStopTrace(long j);

    @Keep
    public static long onNativeEvent(long j, int i, long j2, Object[] objArr) {
        c cVarA;
        b bVarB;
        a aVar;
        switch (i) {
            case 1:
                if (j2 >= 0 && (cVarA = c.a(j)) != null) {
                    cVarA.c(j2);
                }
                return 0L;
            case 2:
                if (objArr != null && objArr.length == 2) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        Object obj2 = objArr[1];
                        if (obj2 instanceof String) {
                            c.a(null, (String) obj, (String) obj2, "", "", j, null);
                        }
                    }
                }
                return 0L;
            case 3:
                c.a(j).a(true);
                return 0L;
            case 4:
                if (objArr != null && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof String) {
                        return c.a(j).b((String) obj3).e();
                    }
                }
                return 0L;
            case 5:
                if (objArr != null && objArr.length == 1) {
                    Object obj4 = objArr[0];
                    if (obj4 instanceof Boolean) {
                        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                        c cVarA2 = c.a(j);
                        b bVarB2 = cVarA2.b(j2);
                        if (bVarB2 != null) {
                            bVarB2.a();
                            if (zBooleanValue) {
                                cVarA2.a(bVarB2);
                            }
                        }
                    }
                }
                return 0L;
            case 6:
                b bVarB3 = c.a(j).b(j2);
                if (bVarB3 != null) {
                    bVarB3.c();
                }
                return 0L;
            case 7:
                c cVarA3 = c.a(j);
                if (cVarA3 != null && (bVarB = cVarA3.b(j2)) != null && (aVar = bVarB.f24572a) != null) {
                    aVar.a(bVarB);
                }
                return 0L;
            default:
                Log.e("jsi", "Unknown JSI native event: " + i);
                return 0L;
        }
    }
}
