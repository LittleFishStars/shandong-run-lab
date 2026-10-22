package com.igexin.assist.control.meizu;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Method> f37785a = new HashMap<>();
    private final A b;
    private final String c;
    private Class<?>[] d;

    public class a {
        private a() {
        }
    }

    public c(A a2, String str, Class<?>... clsArr) {
        this.b = a2;
        this.c = str;
        this.d = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private Method a() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clsA = this.b.a();
        int i = 0;
        for (Method method : clsA.getMethods()) {
            if (a(method, this.c, this.d)) {
                return method;
            }
        }
        Method[] declaredMethods = clsA.getDeclaredMethods();
        int length = declaredMethods.length;
        while (i < length) {
            if (!a(declaredMethods[i], this.c, this.d)) {
                i++;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.c + " with params " + Arrays.toString(this.d) + " could be found on type " + clsA);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private String b() throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder(this.b.a().getName());
        sb.append(this.c);
        for (Class<?> cls : this.d) {
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.b.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }

    public <T> d<T> aa(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String strB = b();
            Method methodA = f37785a.get(strB);
            if (methodA == null) {
                if (this.d.length == objArr.length) {
                    methodA = this.b.a().getMethod(this.c, this.d);
                } else {
                    if (objArr.length > 0) {
                        this.d = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.d[i] = objArr[i].getClass();
                        }
                    }
                    methodA = a();
                }
                f37785a.put(strB, methodA);
            }
            methodA.setAccessible(true);
            dVar.b = objArr.length == 0 ? (T) methodA.invoke(this, obj) : (T) methodA.invoke(this, obj, objArr);
            dVar.f37786a = true;
        } catch (Exception e) {
            DebugLogger.e("ReflectMethod", BridgeDSL.INVOKE, e);
        }
        return dVar;
    }
}
