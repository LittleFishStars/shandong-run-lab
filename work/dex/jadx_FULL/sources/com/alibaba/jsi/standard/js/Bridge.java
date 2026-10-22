package com.alibaba.jsi.standard.js;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class Bridge {
    public static final int kContextGetException = 12;
    public static final int kContextGetGlobalObject = 10;
    public static final int kContextHasException = 11;
    public static final int kContextThrowException = 13;
    public static final int kJSEngineGetCurrent = 3;
    public static final int kJSEngineGetType = 4;
    public static final int kJSEngineSetStatObjects = 5;

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i) {
        return nativeCmd(contextNativePtr(bVar), i, 0L, 0L, null);
    }

    private static long contextNativePtr(com.alibaba.jsi.standard.b bVar) {
        if (bVar == null) {
            return 0L;
        }
        return bVar.j();
    }

    @Keep
    public static Object createJava(int i, long j, long j2) {
        if (19 == i) {
            return new a(j2);
        }
        com.alibaba.jsi.standard.b context = toContext(j);
        switch (i) {
            case 5:
                return new u(context, j2);
            case 6:
            case 14:
            case 19:
            default:
                Log.w("jsi", "Create JSI java object with unknown type: " + i);
                return null;
            case 7:
                return new o(context, j2);
            case 8:
                return new d(context, j2);
            case 9:
                return new k(context, j2);
            case 10:
                return new r(context, j2);
            case 11:
                return new e(context, j2);
            case 12:
                return new j(context, j2);
            case 13:
                return new q(context, j2);
            case 15:
                return new g(context, j2);
            case 16:
                return new n(context, j2);
            case 17:
                return new t(context, j2);
            case 18:
                return new v(context, j2);
            case 20:
                return new aa(j2);
            case 21:
                return new i(context, j2);
        }
    }

    @Keep
    public static Object createJavaPrimitive(int i, boolean z, double d, String str) {
        if (i == 1) {
            return new f(z);
        }
        if (i == 2) {
            return new m((int) d);
        }
        if (i == 3) {
            return new m(d);
        }
        if (i == 4) {
            return new s(str);
        }
        if (i == 6) {
            return new y(z);
        }
        Log.w("jsi", "Create JSI primitive java object with unknown type: " + i);
        return null;
    }

    public static long createNative(com.alibaba.jsi.standard.b bVar, int i) {
        return nativeCreate(contextNativePtr(bVar), i, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }

    @Keep
    public static boolean detachNative(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (wVar.u != 0) {
                com.alibaba.jsi.standard.d.b(wVar.t, wVar);
                wVar.u = 0L;
            }
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            aVar.b = true;
            aVar.f24577a = 0L;
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.b != 0) {
                com.alibaba.jsi.standard.d.b(iVar.f24582a, iVar);
                iVar.b = 0L;
            }
            return true;
        }
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        if (aaVar.f24578a != 0) {
            com.alibaba.jsi.standard.d.b(aaVar);
            aaVar.f24578a = 0L;
        }
        return true;
    }

    public static Object engineCmd(com.alibaba.jsi.standard.c cVar, int i, long j) {
        return nativeCmd(cVar.a(), i, j, 0L, null);
    }

    @Keep
    public static boolean getBooleanValue(Object obj) {
        return ((f) obj).b_();
    }

    @Keep
    public static long getNativePtr(Object obj) {
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof w) {
            return ((w) obj).u;
        }
        if (obj instanceof a) {
            return ((a) obj).f24577a;
        }
        if (obj instanceof i) {
            return ((i) obj).b;
        }
        if (obj instanceof aa) {
            return ((aa) obj).f24578a;
        }
        return 0L;
    }

    @Keep
    public static double getNumberValue(Object obj) {
        return ((m) obj).c_();
    }

    @Keep
    public static int getPrimitiveType(Object obj) {
        if (!(obj instanceof w)) {
            return 0;
        }
        w wVar = (w) obj;
        if (wVar.d()) {
            return 1;
        }
        if (wVar.i()) {
            return ((m) wVar).j() ? 2 : 3;
        }
        if (wVar.p()) {
            return 4;
        }
        return wVar.u() ? 6 : 0;
    }

    @Keep
    public static String getStringValue(Object obj) {
        return ((s) obj).f_();
    }

    private static native Object nativeCmd(long j, int i, long j2, long j3, Object[] objArr);

    private static native long nativeCreate(long j, int i, long j2, double d, Object[] objArr);

    public static native void nativeDelete(long j, int i);

    @Keep
    public static Object onCallConstructor(Object obj, Object obj2) {
        return unwrap(obj).b((a) obj2);
    }

    @Keep
    public static Object onCallFunction(Object obj, Object obj2) {
        return unwrap(obj).a((a) obj2);
    }

    @Keep
    public static boolean onDeleteIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).c(toContext(j), (w) obj2, i);
    }

    @Keep
    public static boolean onDeleteNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).d(toContext(j), (w) obj2, str);
    }

    @Keep
    public static Object[] onEnumerateIndexedProperty(Object obj, long j, Object obj2) {
        return unwrap(obj).b(toContext(j), (w) obj2);
    }

    @Keep
    public static Object[] onEnumerateNamedProperty(Object obj, long j, Object obj2) {
        return unwrap(obj).a(toContext(j), (w) obj2);
    }

    @Keep
    public static Object onGetIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).a(toContext(j), (w) obj2, i);
    }

    @Keep
    public static Object onGetNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).b(toContext(j), (w) obj2, str);
    }

    @Keep
    public static Object onGetProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).a(toContext(j), (w) obj2, str);
    }

    @Keep
    public static int onQueryIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).b(toContext(j), (w) obj2, i);
    }

    @Keep
    public static int onQueryNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).c(toContext(j), (w) obj2, str);
    }

    @Keep
    public static Object onSetIndexedProperty(Object obj, long j, Object obj2, int i, Object obj3) {
        return unwrap(obj).a(toContext(j), (w) obj2, i, (w) obj3);
    }

    @Keep
    public static Object onSetNamedProperty(Object obj, long j, Object obj2, String str, Object obj3) {
        return unwrap(obj).b(toContext(j), (w) obj2, str, (w) obj3);
    }

    @Keep
    public static void onSetProperty(Object obj, long j, Object obj2, String str, Object obj3) {
        unwrap(obj).a(toContext(j), (w) obj2, str, (w) obj3);
    }

    private static com.alibaba.jsi.standard.b toContext(long j) {
        return com.alibaba.jsi.standard.b.a(j);
    }

    private static h unwrap(Object obj) {
        return (h) obj;
    }

    @Keep
    public static boolean voidIsUndefined(Object obj) {
        return ((y) obj).w();
    }

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i, long j) {
        return nativeCmd(contextNativePtr(bVar), i, j, 0L, null);
    }

    public static long createNative(com.alibaba.jsi.standard.b bVar, int i, Object[] objArr) {
        return nativeCreate(contextNativePtr(bVar), i, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, objArr);
    }

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i, Object[] objArr) {
        return nativeCmd(contextNativePtr(bVar), i, 0L, 0L, objArr);
    }

    public static long createNative(com.alibaba.jsi.standard.b bVar, int i, long j) {
        return nativeCreate(contextNativePtr(bVar), i, j, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i, long j, long j2) {
        return nativeCmd(contextNativePtr(bVar), i, j, j2, null);
    }

    public static long createNative(com.alibaba.jsi.standard.b bVar, int i, long j, double d) {
        return nativeCreate(contextNativePtr(bVar), i, j, d, null);
    }

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i, long j, Object[] objArr) {
        return nativeCmd(contextNativePtr(bVar), i, j, 0L, objArr);
    }

    public static long createNative(com.alibaba.jsi.standard.b bVar, int i, long j, double d, Object[] objArr) {
        return nativeCreate(contextNativePtr(bVar), i, j, d, objArr);
    }

    public static Object cmd(com.alibaba.jsi.standard.b bVar, int i, long j, long j2, Object[] objArr) {
        return nativeCmd(contextNativePtr(bVar), i, j, j2, objArr);
    }
}
