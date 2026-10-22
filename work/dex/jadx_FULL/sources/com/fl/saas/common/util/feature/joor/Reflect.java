package com.fl.saas.common.util.feature.joor;

import androidx.arch.core.util.Function;
import androidx.camera.video.AudioStats;
import com.acse.ottn.p3;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.common.util.feature.Predicate;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Reflect {
    private final Object object;
    private final Class<?> type;

    public static class NULL {
        private NULL() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
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

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        try {
            return clsType.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return clsType.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsType = clsType.getSuperclass();
                }
            } while (clsType != null);
            throw new NoSuchMethodException();
        }
    }

    private Field field0(String str) {
        Class<?> clsType = type();
        try {
            return (Field) accessible(clsType.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(clsType.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    clsType = clsType.getSuperclass();
                    if (clsType == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (clsType == null);
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static <T> T initValue(Class<T> cls) {
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Double.TYPE) {
            return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        return null;
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static Reflect on(Class<?> cls) {
        return onClass(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Reflect on(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect on(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    @Deprecated
    public static Reflect on(String str) {
        return onClass(str);
    }

    @Deprecated
    public static Reflect on(String str, ClassLoader classLoader) {
        return onClass(str, classLoader);
    }

    private static Reflect on(Constructor<?> constructor, Object... objArr) {
        try {
            return on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Reflect on(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return on(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static Reflect onClass(Class<?> cls) {
        return new Reflect(cls);
    }

    public static Reflect onClass(String str) {
        return onClass(forName(str));
    }

    public static Reflect onClass(String str, ClassLoader classLoader) {
        return onClass(forName(str, classLoader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        for (Method method : clsType.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : clsType.getDeclaredMethods()) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + Consts.DOT);
    }

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private static Object unwrap(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    public static <T> Class<T> wrapper(Class<T> cls) {
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

    public <P> P as(Class<P> cls) {
        return (P) as(cls, new Class[0]);
    }

    public <P> P as(Class<P> cls, Class<?>... clsArr) {
        final boolean z = this.object instanceof Map;
        InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.fl.saas.common.util.feature.joor.Reflect.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                try {
                    return Reflect.on((Class<?>) Reflect.this.type, Reflect.this.object).call(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith(p3.f)) {
                            return map.get(Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith(p3.g)) {
                            return map.get(Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith(p3.h)) {
                            map.put(Reflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        Class[] clsArr2 = new Class[clsArr.length + 1];
        clsArr2[0] = cls;
        System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), clsArr2, invocationHandler);
    }

    public Reflect call(String str) {
        return call(str, new Object[0]);
    }

    public Reflect call(String str, Object... objArr) {
        Class<?>[] clsArrTypes = types(objArr);
        try {
            try {
                return on(exactMethod(str, clsArrTypes), this.object, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return on(similarMethod(str, clsArrTypes), this.object, objArr);
        }
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public Reflect create(Object... objArr) {
        Class<?>[] clsArrTypes = types(objArr);
        try {
            return on(type().getDeclaredConstructor(clsArrTypes), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), clsArrTypes)) {
                    return on(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public Reflect field(String str) {
        try {
            Field fieldField0 = field0(str);
            return on(fieldField0.getType(), fieldField0.get(this.object));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> clsType = type();
        do {
            for (Field field : clsType.getDeclaredFields()) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        return linkedHashMap;
    }

    public List<Reflect> filterMethod(Predicate<Method> predicate, Function<Method, Object[]> function) {
        ArrayList arrayList = new ArrayList();
        Class<?> clsType = type();
        do {
            try {
                for (Method method : clsType.getDeclaredMethods()) {
                    Method method2 = (Method) accessible(method);
                    if (predicate.test(method2)) {
                        arrayList.add(on(method2, this.object, function == null ? new Object[0] : function.apply(method2)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        return arrayList;
    }

    public Reflect findFirstField(Predicate<Field> predicate) {
        Class<?> clsType = type();
        do {
            try {
                for (Field field : clsType.getDeclaredFields()) {
                    if (predicate.test(field)) {
                        return on(((Field) accessible(field)).get(this.object));
                    }
                }
                clsType = clsType.getSuperclass();
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        } while (clsType != null);
        throw new ReflectException();
    }

    public Reflect findFirstFieldByReflect(Predicate<Reflect> predicate) {
        Class<?> clsType = type();
        do {
            try {
                for (Field field : clsType.getDeclaredFields()) {
                    Field field2 = (Field) accessible(field);
                    Object obj = field2.get(this.object);
                    Reflect reflectOn = obj == null ? on(field2.getType(), (Object) null) : on(obj);
                    if (predicate.test(reflectOn)) {
                        return reflectOn;
                    }
                }
                clsType = clsType.getSuperclass();
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        } while (clsType != null);
        throw new ReflectException();
    }

    public <T> T get() {
        return (T) this.object;
    }

    public <T> T get(String str) {
        return (T) field(str).get();
    }

    public void handleAnntion() {
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String str, Object obj) {
        try {
            Field fieldField0 = field0(str);
            if ((fieldField0.getModifiers() & 16) == 16) {
                try {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    declaredField.setAccessible(true);
                    declaredField.setInt(fieldField0, fieldField0.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            fieldField0.set(this.object, unwrap(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public String toString() {
        return String.valueOf(this.object);
    }

    public Class<?> type() {
        return this.type;
    }
}
