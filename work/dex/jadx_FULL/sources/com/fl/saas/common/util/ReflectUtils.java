package com.fl.saas.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.ReflectUtils;
import com.fl.saas.common.util.feature.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ReflectUtils {
    public static <T> T callMethodByName(Object obj, String str, Object... objArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Class<?>[] parameterTypes = getParameterTypes(objArr);
                Method method = null;
                for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    try {
                        for (Method method2 : superclass.getDeclaredMethods()) {
                            Class<?>[] parameterTypes2 = method2.getParameterTypes();
                            if (str.equals(method2.getName()) && objArr.length == parameterTypes2.length) {
                                if (objArr.length != 0) {
                                    for (int i = 0; i < parameterTypes.length && parameterTypes[i] == getWrapperClass(parameterTypes2[i]); i++) {
                                    }
                                }
                                method = method2;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (method != null) {
                        break;
                    }
                }
                if (method == null) {
                    return null;
                }
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return (T) method.invoke(obj, objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static <T> List<T> findAll(Class<?> cls, @NonNull Function<Class<?>, List<? extends T>> function, @Nullable Predicate<? super T> predicate) {
        ArrayList arrayList = new ArrayList();
        if (cls == null) {
            return arrayList;
        }
        while (cls != null) {
            for (T t : function.apply(cls)) {
                if (predicate == null || predicate.test(t)) {
                    arrayList.add(t);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static <T> List<T> findAll(Object obj, @NonNull Function<Class<?>, List<? extends T>> function, @Nullable Predicate<? super T> predicate) {
        return obj == null ? new ArrayList() : findAll(obj.getClass(), (Function) function, (Predicate) predicate);
    }

    public static List<Field> findAllField(Class<?> cls) {
        return findAll(cls, new Function() { // from class: com.zj.adlib.md7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ReflectUtils.lambda$findAllField$2((Class) obj);
            }
        }, new Predicate() { // from class: com.zj.adlib.nd7
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return ReflectUtils.lambda$findAllField$3((Field) obj);
            }
        });
    }

    public static List<Field> findAllField(Object obj) {
        return obj == null ? new ArrayList() : findAllField(obj.getClass());
    }

    public static List<Method> findAllMethods(Class<?> cls) {
        return findAll(cls, new Function() { // from class: com.zj.adlib.pd7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ReflectUtils.lambda$findAllMethods$4((Class) obj);
            }
        }, new Predicate() { // from class: com.zj.adlib.qd7
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return ReflectUtils.lambda$findAllMethods$5((Method) obj);
            }
        });
    }

    public static List<Method> findAllMethods(Object obj) {
        return obj == null ? new ArrayList() : findAllMethods(obj.getClass());
    }

    public static List<Method> findMethodsByPredicate(Class<?> cls, Predicate<Method> predicate) {
        ArrayList arrayList = new ArrayList();
        if (cls != null && predicate != null) {
            while (cls != null) {
                Method[] methods = cls.getMethods();
                if (methods != null) {
                    for (Method method : methods) {
                        if (predicate.test(method)) {
                            arrayList.add(method);
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
        }
        return arrayList;
    }

    public static List<Method> findMethodsByType(Class<?> cls, final Class<?> cls2) {
        return findMethodsByPredicate(cls, new Predicate() { // from class: com.zj.adlib.od7
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return ReflectUtils.lambda$findMethodsByType$6(cls2, (Method) obj);
            }
        });
    }

    public static List<Method> findMethodsByType(Object obj, Class<?> cls) {
        return (obj == null || cls == null) ? new ArrayList() : findMethodsByType(obj.getClass(), cls);
    }

    public static Field getField(Class<?> cls, String str) {
        Field declaredField = null;
        if (cls != null && !TextUtils.isEmpty(str)) {
            while (cls != null) {
                try {
                    declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    break;
                } catch (NoSuchFieldException | SecurityException e) {
                    e.printStackTrace();
                    cls = cls.getSuperclass();
                }
            }
        }
        return declaredField;
    }

    public static Field getField(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return getField(obj.getClass(), str);
    }

    public static <T> T getFieldByCondition(Object obj, Function<Field, Boolean> function) {
        if (obj != null && function != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (Boolean.TRUE.equals(function.apply(field))) {
                    try {
                        field.setAccessible(true);
                        return (T) field.get(obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static Object getFieldRecursionValue(Object obj, String... strArr) {
        if (obj == null || strArr == null || strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            if (obj == null || TextUtils.isEmpty(str)) {
                return null;
            }
            obj = getSuperFieldValue(obj, str);
        }
        return obj;
    }

    public static Object getFieldValue(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T getFieldValueByCondition(Object obj, Function<Object, Boolean> function) {
        if (obj != null && function != null) {
            for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        T t = (T) field.get(obj);
                        if (Boolean.TRUE.equals(function.apply(t))) {
                            return t;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static <T> T getFieldValueByType(Object obj, final Class<T> cls) {
        if (obj == null || cls == null) {
            return null;
        }
        return (T) getFieldByCondition(obj, new Function() { // from class: com.zj.adlib.ld7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj2) {
                return ReflectUtils.lambda$getFieldValueByType$1(cls, (Field) obj2);
            }
        });
    }

    public static <T> T getFieldValueByTypeName(Object obj, final String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) getFieldByCondition(obj, new Function() { // from class: com.zj.adlib.kd7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj2) {
                return ReflectUtils.lambda$getFieldValueByTypeName$0(str, (Field) obj2);
            }
        });
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Class<?> cls = obj.getClass();
            if (cls.isPrimitive()) {
                if (obj instanceof Integer) {
                    cls = Integer.TYPE;
                } else if (obj instanceof Long) {
                    cls = Long.TYPE;
                } else if (obj instanceof Double) {
                    cls = Double.TYPE;
                } else if (obj instanceof Float) {
                    cls = Float.TYPE;
                } else if (obj instanceof Boolean) {
                    cls = Boolean.TYPE;
                } else if (obj instanceof Short) {
                    cls = Short.TYPE;
                } else if (obj instanceof Byte) {
                    cls = Byte.TYPE;
                } else if (obj instanceof Character) {
                    cls = Character.TYPE;
                }
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static <T> List<T> getStaticFinalValues(Class<?> cls, Class<T> cls2) {
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getType() == cls2) {
                try {
                    field.setAccessible(true);
                    arrayList.add(field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static Object getSuperFieldValue(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    Field declaredField = superclass.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                }
            }
        }
        return null;
    }

    public static Class<?> getWrapperClass(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        return cls == Character.TYPE ? Character.class : cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$findAllField$2(Class cls) {
        return Arrays.asList(cls.getDeclaredFields());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllField$3(Field field) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$findAllMethods$4(Class cls) {
        return Arrays.asList(cls.getDeclaredMethods());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllMethods$5(Method method) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findMethodsByType$6(Class cls, Method method) {
        return method.getReturnType() == cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getFieldValueByType$1(Class cls, Field field) {
        return Boolean.valueOf(field.getType() == cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getFieldValueByTypeName$0(String str, Field field) {
        return Boolean.valueOf(TextUtils.equals(field.getType().getSimpleName(), str));
    }
}
