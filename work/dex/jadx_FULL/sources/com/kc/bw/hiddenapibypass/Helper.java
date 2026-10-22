package com.kc.bw.hiddenapibypass;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.invoke.MethodType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Helper {
    public static final Set<String> signaturePrefixes = new HashSet();

    @Keep
    public static class AccessibleObject {
        public boolean override;
    }

    @Keep
    public static final class Class {
        public transient int accessFlags;
        public transient int classFlags;
        public transient ClassLoader classLoader;
        public transient int classSize;
        public transient int clinitThreadId;
        public transient java.lang.Class<?> componentType;
        public transient short copiedMethodsOffset;
        public transient Object dexCache;
        public transient int dexClassDefIndex;
        public volatile transient int dexTypeIndex;
        public transient Object extData;
        public transient long iFields;
        public transient Object[] ifTable;
        public transient long methods;
        public transient String name;
        public transient int numReferenceInstanceFields;
        public transient int numReferenceStaticFields;
        public transient int objectSize;
        public transient int objectSizeAllocFastPath;
        public transient int primitiveType;
        public transient int referenceInstanceOffsets;
        public transient long sFields;
        public transient int status;
        public transient java.lang.Class<?> superClass;
        public transient short virtualMethodsOffset;
        public transient Object vtable;
    }

    @Keep
    public static final class Executable extends AccessibleObject {
        public int accessFlags;
        public long artMethod;
        public Class declaringClass;
        public Class declaringClassOfOverriddenMethod;
        public Object[] parameters;
    }

    @Keep
    public static class InvokeStub {
        public InvokeStub(Object... objArr) {
            throw new IllegalStateException("Failed to new a instance");
        }

        public static Object invoke(Object... objArr) {
            throw new IllegalStateException("Failed to invoke the method");
        }
    }

    @Keep
    public static class MethodHandle {
        public MethodHandle cachedSpreadInvoker;
        public MethodType nominalType;
        public final MethodType type = null;
        public final int handleKind = 0;
        public final long artFieldOrMethod = 0;
    }

    @Keep
    public static class NeverCall {
        public static int s;
        public static int t;
        public int i;
        public int j;

        public static void a() {
        }

        public static void b() {
        }
    }

    public static boolean checkArgsForInvokeMethod(java.lang.Class<?>[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i].isPrimitive()) {
                java.lang.Class<?> cls = clsArr[i];
                if (cls == Integer.TYPE && !(objArr[i] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i];
                if (obj != null && !clsArr[i].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
