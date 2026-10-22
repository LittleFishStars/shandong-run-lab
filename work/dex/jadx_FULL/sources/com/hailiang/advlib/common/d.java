package com.hailiang.advlib.common;

import com.acse.ottn.p3;
import com.alibaba.android.arouter.utils.Consts;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f32562a;
    private final boolean b = true;

    @Keep
    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f32563a;
        final d b;

        public a(d dVar, boolean z) {
            this.b = dVar;
            this.f32563a = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            try {
                return d.a(this.b.f32562a).a(name, objArr).c();
            } catch (ReflectException e) {
                if (this.f32563a) {
                    Map map = (Map) this.b.f32562a;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith(p3.f)) {
                        return map.get(d.h(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith(p3.g)) {
                        return map.get(d.h(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith(p3.h)) {
                        map.put(d.h(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e;
            }
        }
    }

    @Keep
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f32564a;

        private b(d dVar) {
            this.f32564a = dVar;
        }
    }

    private d(Class<?> cls) {
        this.f32562a = cls;
    }

    private d(Object obj) {
        this.f32562a = obj;
    }

    public static d a(Object obj) {
        return new d(obj);
    }

    private static d a(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return a(((Constructor) a(constructor)).newInstance(objArr));
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    private static d a(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            a(method);
            if (method.getReturnType() != Void.TYPE) {
                return a(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return a(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> a(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static <T extends AccessibleObject> T a(T t) {
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

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsE = e();
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

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            Class<?> cls = clsArr2[i];
            if (cls != b.class && (c(cls) == null || !c(clsArr[i]).isAssignableFrom(c(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }

    public static d b(Class<?> cls) {
        return new d(cls);
    }

    public static d b(String str, ClassLoader classLoader) throws ReflectException {
        return b(a(str, classLoader));
    }

    private static Object b(Object obj) {
        return obj instanceof d ? ((d) obj).c() : obj;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsE = e();
        for (Method method : clsE.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : clsE.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsE = clsE.getSuperclass();
        } while (clsE != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + e() + Consts.DOT);
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static Class<?> c(Class<?> cls) {
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

    private Field d(String str) throws ReflectException {
        Class<?> clsE = e();
        try {
            return clsE.getField(str);
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(clsE.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    clsE = clsE.getSuperclass();
                }
            } while (clsE != null);
            throw new ReflectException(e);
        }
    }

    private static Class<?> e(String str) throws ReflectException {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static d g(String str) throws ReflectException {
        return b(e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public d a() throws ReflectException {
        return a(new Object[0]);
    }

    public d a(String str, Object obj) throws ReflectException {
        try {
            Field fieldD = d(str);
            fieldD.setAccessible(true);
            fieldD.set(this.f32562a, b(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public d a(String str, Object... objArr) throws ReflectException {
        Class<?>[] clsArrB = b(objArr);
        try {
            try {
                return a(a(str, clsArrB), this.f32562a, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArrB), this.f32562a, objArr);
        }
    }

    public d a(Field field, Object obj) throws ReflectException {
        try {
            field.setAccessible(true);
            field.set(this.f32562a, b(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public d a(Object... objArr) throws ReflectException {
        Class<?>[] clsArrB = b(objArr);
        try {
            return a(e().getDeclaredConstructor(clsArrB), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : e().getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), clsArrB)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public <P> P a(Class<P> cls) {
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this, this.f32562a instanceof Map));
    }

    public d b(String str) throws ReflectException {
        return a(str, new Object[0]);
    }

    public Map<String, d> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> clsE = e();
        do {
            for (Field field : clsE.getDeclaredFields()) {
                if ((!this.b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, c(name));
                    }
                }
            }
            clsE = clsE.getSuperclass();
        } while (clsE != null);
        return linkedHashMap;
    }

    public d c(String str) throws ReflectException {
        try {
            return a(d(str).get(this.f32562a));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public <T> T c() {
        return (T) this.f32562a;
    }

    public Object d() {
        return this.f32562a;
    }

    public Class<?> e() {
        return this.b ? (Class) this.f32562a : this.f32562a.getClass();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f32562a.equals(((d) obj).c());
        }
        return false;
    }

    public <T> T f(String str) throws ReflectException {
        return (T) c(str).c();
    }

    public int hashCode() {
        return this.f32562a.hashCode();
    }

    public String toString() {
        return this.f32562a.toString();
    }
}
