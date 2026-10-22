package com.blankj.utilcode.util;

import com.acse.ottn.p3;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReflectUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f28172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f1340a;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    public class a implements Comparator<Constructor<?>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
            int length = parameterTypes.length;
            for (int i = 0; i < length; i++) {
                if (!parameterTypes[i].equals(parameterTypes2[i])) {
                    return ReflectUtils.this.G(parameterTypes[i]).isAssignableFrom(ReflectUtils.this.G(parameterTypes2[i])) ? 1 : -1;
                }
            }
            return 0;
        }
    }

    public class b implements Comparator<Method> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            int length = parameterTypes.length;
            for (int i = 0; i < length; i++) {
                if (!parameterTypes[i].equals(parameterTypes2[i])) {
                    return ReflectUtils.this.G(parameterTypes[i]).isAssignableFrom(ReflectUtils.this.G(parameterTypes2[i])) ? 1 : -1;
                }
            }
            return 0;
        }
    }

    public class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1341a;

        public c(boolean z) {
            this.f1341a = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            try {
                return ReflectUtils.y(ReflectUtils.this.f1340a).q(name, objArr).j();
            } catch (ReflectException e) {
                if (this.f1341a) {
                    Map map = (Map) ReflectUtils.this.f1340a;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith(p3.f)) {
                        return map.get(ReflectUtils.v(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith(p3.g)) {
                        return map.get(ReflectUtils.v(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith(p3.h)) {
                        map.put(ReflectUtils.v(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e;
            }
        }
    }

    public static class d {
    }

    public ReflectUtils(Class<?> cls) {
        this(cls, cls);
    }

    public static ReflectUtils A(String str, ClassLoader classLoader) throws ReflectException {
        return x(i(str, classLoader));
    }

    public static Class<?> h(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    public static Class<?> i(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    public static String v(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static ReflectUtils x(Class<?> cls) throws ReflectException {
        return new ReflectUtils(cls);
    }

    public static ReflectUtils y(Object obj) throws ReflectException {
        return new ReflectUtils(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static ReflectUtils z(String str) throws ReflectException {
        return x(h(str));
    }

    public final Method B(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsE = E();
        ArrayList arrayList = new ArrayList();
        for (Method method : clsE.getMethods()) {
            if (n(method, str, clsArr)) {
                arrayList.add(method);
            }
        }
        if (!arrayList.isEmpty()) {
            D(arrayList);
            return arrayList.get(0);
        }
        do {
            for (Method method2 : clsE.getDeclaredMethods()) {
                if (n(method2, str, clsArr)) {
                    arrayList.add(method2);
                }
            }
            if (!arrayList.isEmpty()) {
                D(arrayList);
                return arrayList.get(0);
            }
            clsE = clsE.getSuperclass();
        } while (clsE != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + E() + Consts.DOT);
    }

    public final void C(List<Constructor<?>> list) {
        Collections.sort(list, new a());
    }

    public final void D(List<Method> list) {
        Collections.sort(list, new b());
    }

    public final Class<?> E() {
        return this.f28172a;
    }

    public final Object F(Object obj) {
        return obj instanceof ReflectUtils ? ((ReflectUtils) obj).j() : obj;
    }

    public final Class<?> G(Class<?> cls) {
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

    public final <T extends AccessibleObject> T d(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    public final Method e(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsE = E();
        try {
            return clsE.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return clsE.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsE = clsE.getSuperclass();
                }
            } while (clsE != null);
            throw new NoSuchMethodException();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectUtils) && this.f1340a.equals(((ReflectUtils) obj).j());
    }

    public ReflectUtils f(String str) {
        try {
            Field fieldM = m(str);
            return new ReflectUtils(fieldM.getType(), fieldM.get(this.f1340a));
        } catch (IllegalAccessException e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils g(String str, Object obj) {
        try {
            m(str).set(this.f1340a, F(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public int hashCode() {
        return this.f1340a.hashCode();
    }

    public <T> T j() {
        return (T) this.f1340a;
    }

    public final Field k(String str) {
        Class<?> clsE = E();
        try {
            return (Field) d(clsE.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) d(clsE.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    clsE = clsE.getSuperclass();
                    if (clsE == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (clsE == null);
            throw new ReflectException(e);
        }
    }

    public final Class<?>[] l(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? d.class : obj.getClass();
        }
        return clsArr;
    }

    public final Field m(String str) throws IllegalAccessException {
        Field fieldK = k(str);
        if ((fieldK.getModifiers() & 16) == 16) {
            try {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(fieldK, fieldK.getModifiers() & (-17));
            } catch (NoSuchFieldException unused) {
                fieldK.setAccessible(true);
            }
        }
        return fieldK;
    }

    public final boolean n(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && o(method.getParameterTypes(), clsArr);
    }

    public final boolean o(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != d.class && !G(clsArr[i]).isAssignableFrom(G(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public ReflectUtils p(String str) throws ReflectException {
        return q(str, new Object[0]);
    }

    public ReflectUtils q(String str, Object... objArr) throws ReflectException {
        Class<?>[] clsArrL = l(objArr);
        try {
            try {
                return r(e(str, clsArrL), this.f1340a, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return r(B(str, clsArrL), this.f1340a, objArr);
        }
    }

    public final ReflectUtils r(Method method, Object obj, Object... objArr) {
        try {
            d(method);
            if (method.getReturnType() != Void.TYPE) {
                return y(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return y(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public ReflectUtils s() {
        return u(new Object[0]);
    }

    public final ReflectUtils t(Constructor<?> constructor, Object... objArr) {
        try {
            return new ReflectUtils(constructor.getDeclaringClass(), ((Constructor) d(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public String toString() {
        return this.f1340a.toString();
    }

    public ReflectUtils u(Object... objArr) {
        Class<?>[] clsArrL = l(objArr);
        try {
            return t(E().getDeclaredConstructor(clsArrL), objArr);
        } catch (NoSuchMethodException e) {
            ArrayList arrayList = new ArrayList();
            for (Constructor<?> constructor : E().getDeclaredConstructors()) {
                if (o(constructor.getParameterTypes(), clsArrL)) {
                    arrayList.add(constructor);
                }
            }
            if (arrayList.isEmpty()) {
                throw new ReflectException(e);
            }
            C(arrayList);
            return t(arrayList.get(0), objArr);
        }
    }

    public <P> P w(Class<P> cls) {
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(this.f1340a instanceof Map));
    }

    public ReflectUtils(Class<?> cls, Object obj) {
        this.f28172a = cls;
        this.f1340a = obj;
    }
}
