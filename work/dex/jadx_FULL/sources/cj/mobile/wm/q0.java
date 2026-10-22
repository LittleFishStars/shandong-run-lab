package cj.mobile.wm;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.fastjson.util.TypeUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.easyjson.JSON;
import com.zj.adlib.c25;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q0 {
    public static boolean dexa = false;
    public static boolean dexb = true;
    public static volatile Class dexc;
    public static volatile boolean dexd;
    public static volatile boolean dexe;
    public static volatile Constructor dexf;
    public static volatile Method dexg;
    public static volatile Method dexh;
    public static volatile Method dexi;
    public static volatile boolean dexj;
    public static volatile Map<Class, String[]> dexk;
    public static volatile boolean dexl;
    public static final ConcurrentMap<String, Class<?>> dexm;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        dexm = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put("int", Integer.TYPE);
        concurrentHashMap.put("long", Long.TYPE);
        concurrentHashMap.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        concurrentHashMap.put("double", Double.TYPE);
        concurrentHashMap.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        concurrentHashMap.put("[byte", byte[].class);
        concurrentHashMap.put("[short", short[].class);
        concurrentHashMap.put("[int", int[].class);
        concurrentHashMap.put("[long", long[].class);
        concurrentHashMap.put("[float", float[].class);
        concurrentHashMap.put("[double", double[].class);
        concurrentHashMap.put("[boolean", boolean[].class);
        concurrentHashMap.put("[char", char[].class);
        concurrentHashMap.put("[B", byte[].class);
        concurrentHashMap.put("[S", short[].class);
        concurrentHashMap.put("[I", int[].class);
        concurrentHashMap.put("[J", long[].class);
        concurrentHashMap.put("[F", float[].class);
        concurrentHashMap.put("[D", double[].class);
        concurrentHashMap.put("[C", char[].class);
        concurrentHashMap.put("[Z", boolean[].class);
        concurrentHashMap.put("java.util.HashMap", HashMap.class);
        concurrentHashMap.put("java.util.TreeMap", TreeMap.class);
        concurrentHashMap.put("java.util.Date", Date.class);
        concurrentHashMap.put("com.wangmai.insightvision.openadsdk.fastjson.JSONObject", com.wangmai.insightvision.openadsdk.d.e.class);
        concurrentHashMap.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        concurrentHashMap.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        concurrentHashMap.put("java.lang.StackTraceElement", StackTraceElement.class);
        concurrentHashMap.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static dex08 dexa(Class<?> cls, Method method) {
        boolean z;
        dex08 dex08Var;
        boolean z2;
        dex08 dex08Var2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            }
                            if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        if (z2 && (dex08Var2 = (dex08) method2.getAnnotation(dex08.class)) != null) {
                            return dex08Var2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        }
                        if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        }
                        i2++;
                    }
                    if (z && (dex08Var = (dex08) method3.getAnnotation(dex08.class)) != null) {
                        return dex08Var;
                    }
                }
            }
        }
        return null;
    }

    public static Class<?> dexa(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() >= 256) {
            throw new com.wangmai.insightvision.openadsdk.d.d("className too long. " + str);
        }
        ConcurrentMap<String, Class<?>> concurrentMap = dexm;
        Class<?> cls = concurrentMap.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            Class<?> clsDexa = dexa(str.substring(1), classLoader, false);
            if (clsDexa == null) {
                return null;
            }
            return Array.newInstance(clsDexa, 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(com.alipay.sdk.m.y.l.b)) {
            return dexa(str.substring(1, str.length() - 1), classLoader, false);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                if (z) {
                    concurrentMap.put(str, cls);
                }
                return cls;
            } catch (Exception unused) {
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                Class<?> clsLoadClass = contextClassLoader.loadClass(str);
                if (z) {
                    try {
                        dexm.put(str, clsLoadClass);
                    } catch (Exception unused2) {
                        cls = clsLoadClass;
                    }
                }
                return clsLoadClass;
            }
        } catch (Exception unused3) {
        }
        try {
            cls = Class.forName(str);
            dexm.put(str, cls);
            return cls;
        } catch (Exception unused4) {
            return cls;
        }
    }

    public static Class<?> dexa(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return dexa(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? dexa(upperBounds[0]) : Object.class;
    }

    public static Object dexa(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        return cls == Character.TYPE ? '0' : null;
    }

    public static <T> T dexa(Object obj, Class<T> cls, a aVar) {
        return (T) dexa(obj, cls, aVar, 0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T dexa(Object obj, Class<T> cls, a aVar, int i) throws com.wangmai.insightvision.openadsdk.d.d {
        Object obj2;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) dexa((Map<String, Object>) map, (Class) cls, aVar, i) : obj;
        }
        int i2 = 0;
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(t, i2, dexa(it.next(), (Class) cls.getComponentType(), aVar));
                    i2++;
                }
                return t;
            }
            if (cls == byte[].class) {
                return (T) dexe(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) dexc(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) dexd(obj);
        }
        if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
            String str = (String) obj;
            if (str.length() == 1) {
                return (T) Character.valueOf(str.charAt(0));
            }
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) dexl(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) dexj(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) dexk(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) dexi(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) dexh(obj);
        }
        if (cls == String.class) {
            return (T) dexm(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) dexa(obj);
        }
        if (cls == BigInteger.class) {
            return (T) dexb(obj);
        }
        if (cls == Date.class) {
            return (T) dexg(obj);
        }
        if (cls.isEnum()) {
            return (T) dexb(obj, cls, aVar);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date dateDexg = dexg(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(dex04.f22670a, dex04.b);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + cls.getName(), e);
                }
            }
            ((Calendar) obj2).setTime(dateDexg);
            return (T) obj2;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str2);
            }
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + cls.getName());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T dexa(Object obj, ParameterizedType parameterizedType, a aVar) {
        if (obj == null) {
            return null;
        }
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ?? r0 = (T) new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    r0.add(type instanceof Class ? (obj2 == null || obj2.getClass() != com.wangmai.insightvision.openadsdk.d.e.class) ? dexa(obj2, (Class) type, aVar, 0) : ((com.wangmai.insightvision.openadsdk.d.e) obj2).a((Class) type, aVar, 0) : dexa(obj2, type, aVar));
                }
                return r0;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    T next = it.next();
                    ((Collection) t).add(type2 instanceof Class ? (next == null || next.getClass() != com.wangmai.insightvision.openadsdk.d.e.class) ? dexa(next, (Class) type2, aVar, 0) : ((com.wangmai.insightvision.openadsdk.d.e) next).a((Class) type2, aVar, 0) : dexa(next, type2, aVar));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r10 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r10.put(dexa(entry.getKey(), type3, aVar), dexa(entry.getValue(), type4, aVar));
                }
                return r10;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) dexa(obj, rawType, aVar);
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T dexa(Object obj, Type type, a aVar) {
        if (obj == 0) {
            if (type == Integer.TYPE) {
                return (T) 0;
            }
            if (type == Long.TYPE) {
                return (T) 0L;
            }
            if (type == Short.TYPE) {
                return (T) (short) 0;
            }
            if (type == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (type == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (type == Double.TYPE) {
                return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            if (type == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (type instanceof Class) {
            return (T) dexa(obj, (Class) type, aVar, 0);
        }
        if (type instanceof ParameterizedType) {
            return (T) dexa(obj, (ParameterizedType) type, aVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + type);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final <T> T dexa(Map<String, Object> map, Class<T> cls, a aVar, int i) throws com.wangmai.insightvision.openadsdk.d.d {
        int iIntValueExact = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValueExact = number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValueExact);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (aVar == null) {
                    aVar = a.dexg;
                }
                Class<?> clsDexa = aVar.dexa(str4, (Class<?>) null, i);
                if (clsDexa == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsDexa.equals(cls)) {
                    return (T) dexa(map, (Class) clsDexa, aVar, i);
                }
            }
            if (cls.isInterface()) {
                com.wangmai.insightvision.openadsdk.d.e eVar = map instanceof com.wangmai.insightvision.openadsdk.d.e ? (com.wangmai.insightvision.openadsdk.d.e) map : new com.wangmai.insightvision.openadsdk.d.e(map);
                if (aVar == null) {
                    aVar = a.dexa();
                }
                return aVar.dexa(cls) != null ? (T) dex04.a(dex04.b(eVar), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, eVar);
            }
            if (cls == String.class && (map instanceof com.wangmai.insightvision.openadsdk.d.e)) {
                return (T) map.toString();
            }
            if (aVar == null) {
                aVar = a.dexg;
            }
            j jVarDexa = aVar.dexa(cls);
            dex15 dex15Var = jVarDexa instanceof dex15 ? (dex15) jVarDexa : null;
            if (dex15Var != null) {
                return (T) dex15Var.dexa(map, aVar);
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("can not get javaBeanDeserializer");
        } catch (Exception e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage(), e);
        }
    }

    public static String dexa(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Field dexa(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field fieldDexb = dexb(cls, str, fieldArr, map);
        if (fieldDexb == null) {
            fieldDexb = dexb(cls, LoginConstants.UNDER_LINE + str, fieldArr, map);
        }
        if (fieldDexb == null) {
            fieldDexb = dexb(cls, "m_" + str, fieldArr, map);
        }
        if (fieldDexb != null) {
            return fieldDexb;
        }
        return dexb(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
    }

    public static final BigDecimal dexa(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigDecimal(string);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:159:0x0379  */
    /* JADX WARN: Code duplicated, block: B:160:0x037d A[PHI: r11 r12 r14 r15 r34 r35 r36
      0x037d: PHI (r11v19 java.lang.Class<?>) = (r11v17 java.lang.Class<?>), (r11v9 java.lang.Class<?>), (r11v9 java.lang.Class<?>), (r11v9 java.lang.Class<?>) binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r12v14 java.util.LinkedHashMap) = 
      (r22v0 java.util.LinkedHashMap)
      (r22v0 java.util.LinkedHashMap)
      (r22v0 java.util.LinkedHashMap)
      (r12v17 java.util.LinkedHashMap)
     binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r14v16 java.util.Map<java.lang.String, java.lang.String>) = 
      (r14v14 java.util.Map<java.lang.String, java.lang.String>)
      (r14v2 java.util.Map<java.lang.String, java.lang.String>)
      (r14v2 java.util.Map<java.lang.String, java.lang.String>)
      (r14v2 java.util.Map<java.lang.String, java.lang.String>)
     binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r15v18 java.lang.reflect.Field[]) = 
      (r8v4 java.lang.reflect.Field[])
      (r8v4 java.lang.reflect.Field[])
      (r8v4 java.lang.reflect.Field[])
      (r15v22 java.lang.reflect.Field[])
     binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r34v2 java.lang.Class<cj.mobile.wm.dex08>) = 
      (r27v1 java.lang.Class<cj.mobile.wm.dex08>)
      (r27v1 java.lang.Class<cj.mobile.wm.dex08>)
      (r27v1 java.lang.Class<cj.mobile.wm.dex08>)
      (r34v4 java.lang.Class<cj.mobile.wm.dex08>)
     binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r35v5 java.lang.Class<? super ?>) = 
      (r7v9 java.lang.Class<? super ?>)
      (r7v9 java.lang.Class<? super ?>)
      (r7v9 java.lang.Class<? super ?>)
      (r35v8 java.lang.Class<? super ?>)
     binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r36v9 java.util.HashMap) = (r9v4 java.util.HashMap), (r9v4 java.util.HashMap), (r9v4 java.util.HashMap), (r36v12 java.util.HashMap) binds: [B:159:0x0379, B:111:0x0259, B:129:0x02b4, B:103:0x01e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:215:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:288:0x0603  */
    /* JADX WARN: Code duplicated, block: B:290:0x0608 A[LOOP:11: B:289:0x0606->B:290:0x0608, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:291:0x0616  */
    /* JADX WARN: Code duplicated, block: B:294:0x0624 A[LOOP:12: B:292:0x061e->B:294:0x0624, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:296:0x0630  */
    /* JADX WARN: Code duplicated, block: B:89:0x0191  */
    /* JADX WARN: Instruction removed from duplicated block: B:288:0x0603, please report this as an issue */
    public static List<n0> dexa(Class<?> cls, int i, boolean z, dex09 dex09Var, Map<String, String> map, boolean z2, boolean z3, boolean z4, com.wangmai.insightvision.openadsdk.d.g gVar) {
        String[] strArrOrders;
        boolean z5;
        Iterator it;
        int i2;
        int i3;
        int i4;
        short[] sArr;
        Constructor<?>[] constructorArr;
        Annotation[][] annotationArr;
        short[] sArr2;
        String[] strArr;
        boolean z6;
        boolean z7;
        int iOrdinal;
        int iA;
        Field[] fieldArr;
        Class<dex08> cls2;
        HashMap map2;
        int i5;
        Class<dex08> cls3;
        String strSubstring;
        LinkedHashMap linkedHashMap;
        Class<dex08> cls4;
        int i6;
        dex08 dex08Var;
        String strSubstring2;
        int i7;
        dex08 dex08Var2;
        int i8;
        boolean z8;
        String[] strArr2;
        String[] strArr3;
        Annotation[][] parameterAnnotations;
        Constructor<?>[] constructorArr2;
        Annotation[] annotationArr2;
        int i9;
        Class<?> cls5 = cls;
        int i10 = i;
        dex09 dex09Var2 = dex09Var;
        Map<String, String> map3 = map;
        com.wangmai.insightvision.openadsdk.d.g gVar2 = gVar;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        HashMap map4 = new HashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Class<? super Object> cls6 = Object.class;
        Class<dex08> cls7 = dex08.class;
        if (!z) {
            boolean zDexc = dexc((Class) cls);
            ArrayList<Method> arrayList = new ArrayList();
            for (Class<?> superclass = cls5; superclass != null && superclass != cls6; superclass = superclass.getSuperclass()) {
                Method[] declaredMethods = superclass.getDeclaredMethods();
                int length = declaredMethods.length;
                int i11 = 0;
                while (i11 < length) {
                    Method method = declaredMethods[i11];
                    Method[] methodArr = declaredMethods;
                    int modifiers = method.getModifiers();
                    if ((modifiers & 8) == 0 && (modifiers & 2) == 0) {
                        i9 = length;
                        if ((modifiers & 256) == 0 && (modifiers & 4) == 0 && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && method.getReturnType() != ClassLoader.class && method.getDeclaringClass() != cls6) {
                            arrayList.add(method);
                        }
                    } else {
                        i9 = length;
                    }
                    i11++;
                    declaredMethods = methodArr;
                    length = i9;
                }
            }
            Constructor<?>[] declaredConstructors = null;
            String[] strArr4 = null;
            short[] sArr3 = null;
            Annotation[][] annotationArr3 = null;
            for (Method method2 : arrayList) {
                String name = method2.getName();
                String[] strArr5 = strArr4;
                if (name.equals("getMetaClass")) {
                    sArr = sArr3;
                    if (method2.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                    }
                    strArr4 = strArr5;
                    sArr3 = sArr;
                } else {
                    sArr = sArr3;
                }
                dex08 dex08VarDexa = z3 ? (dex08) method2.getAnnotation(cls7) : null;
                if (dex08VarDexa == null && z3) {
                    dex08VarDexa = dexa(cls5, method2);
                }
                if (zDexc && dexa(cls5, name)) {
                    strArr4 = strArr5;
                    sArr3 = sArr;
                } else {
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    if (dex08VarDexa == null && zDexc) {
                        if (declaredConstructors == null) {
                            declaredConstructors = cls.getDeclaredConstructors();
                            Annotation[][] annotationArr4 = annotationArr3;
                            if (declaredConstructors.length == 1) {
                                parameterAnnotations = declaredConstructors[0].getParameterAnnotations();
                                String[] strArrDexb = dexb((Class) cls);
                                if (strArrDexb != null) {
                                    strArr3 = new String[strArrDexb.length];
                                    cls7 = cls7;
                                    System.arraycopy(strArrDexb, 0, strArr3, 0, strArrDexb.length);
                                    Arrays.sort(strArr3);
                                    short[] sArr4 = new short[strArrDexb.length];
                                    dex08VarDexa = dex08VarDexa;
                                    for (short s = 0; s < strArrDexb.length; s = (short) (s + 1)) {
                                        sArr4[Arrays.binarySearch(strArr3, strArrDexb[s])] = s;
                                    }
                                    sArr = sArr4;
                                    declaredConstructors = declaredConstructors;
                                } else {
                                    strArr2 = strArrDexb;
                                    annotationArr3 = parameterAnnotations;
                                }
                                if (strArr3 == null && sArr != null && name.startsWith(com.acse.ottn.p3.f)) {
                                    String strDexa = dexa(name.substring(3));
                                    int iBinarySearch = Arrays.binarySearch(strArr3, strDexa);
                                    constructorArr2 = declaredConstructors;
                                    if (iBinarySearch < 0) {
                                        for (int i12 = 0; i12 < strArr3.length; i12++) {
                                            if (strDexa.equalsIgnoreCase(strArr3[i12])) {
                                                iBinarySearch = i12;
                                                break;
                                            }
                                        }
                                    }
                                    if (iBinarySearch >= 0 && (annotationArr2 = parameterAnnotations[sArr[iBinarySearch]]) != null) {
                                        int length2 = annotationArr2.length;
                                        int i13 = 0;
                                        while (i13 < length2) {
                                            Annotation annotation = annotationArr2[i13];
                                            Annotation[] annotationArr5 = annotationArr2;
                                            if (annotation instanceof dex08) {
                                                dex08VarDexa = (dex08) annotation;
                                                break;
                                            }
                                            i13++;
                                            annotationArr2 = annotationArr5;
                                        }
                                    }
                                } else {
                                    constructorArr2 = declaredConstructors;
                                }
                                annotationArr = parameterAnnotations;
                                sArr2 = sArr;
                                constructorArr = constructorArr2;
                                strArr = strArr3;
                            } else {
                                strArr2 = strArr5;
                                annotationArr3 = annotationArr4;
                            }
                        } else {
                            strArr2 = strArr5;
                        }
                        strArr3 = strArr2;
                        parameterAnnotations = annotationArr3;
                        if (strArr3 == null) {
                            constructorArr2 = declaredConstructors;
                        } else {
                            constructorArr2 = declaredConstructors;
                        }
                        annotationArr = parameterAnnotations;
                        sArr2 = sArr;
                        constructorArr = constructorArr2;
                        strArr = strArr3;
                    } else {
                        dex08VarDexa = dex08VarDexa;
                        cls7 = cls7;
                        constructorArr = declaredConstructors;
                        annotationArr = annotationArr3;
                        sArr2 = sArr;
                        strArr = strArr5;
                    }
                    if (dex08VarDexa != null) {
                        if (dex08VarDexa.serialize()) {
                            iOrdinal = dex08VarDexa.ordinal();
                            iA = com.wangmai.insightvision.openadsdk.d.j.a0.a(dex08VarDexa.serialzeFeatures());
                            if (dex08VarDexa.name().length() != 0) {
                                String strName = dex08VarDexa.name();
                                if (map3 == null || (strName = map3.get(strName)) != null) {
                                    String str = strName;
                                    dexa(cls5, method2, i10);
                                    cls7 = cls7;
                                    cls6 = cls6;
                                    map4 = map4;
                                    declaredFields = declaredFields;
                                    linkedHashMap3 = linkedHashMap3;
                                    linkedHashMap3.put(str, new n0(str, method2, null, cls, null, iOrdinal, iA, dex08VarDexa, null, true));
                                }
                                i10 = i;
                                declaredFields = declaredFields;
                                declaredConstructors = constructorArr;
                                strArr4 = strArr;
                                sArr3 = sArr2;
                                annotationArr3 = annotationArr;
                                cls6 = cls6;
                                map4 = map4;
                                cls7 = cls3;
                                gVar2 = gVar;
                                dex09Var2 = dex09Var;
                            } else {
                                z6 = true;
                                z7 = false;
                            }
                            gVar = gVar;
                            linkedHashMap2 = linkedHashMap3;
                            cls3 = cls7;
                            i10 = i;
                            declaredFields = declaredFields;
                            declaredConstructors = constructorArr;
                            strArr4 = strArr;
                            sArr3 = sArr2;
                            annotationArr3 = annotationArr;
                            cls6 = cls6;
                            map4 = map4;
                            cls7 = cls3;
                            gVar2 = gVar;
                            dex09Var2 = dex09Var;
                        }
                        cls6 = cls6;
                        map4 = map4;
                        gVar = gVar2;
                        linkedHashMap2 = linkedHashMap3;
                        cls3 = cls7;
                        declaredFields = declaredFields;
                        i10 = i;
                        declaredFields = declaredFields;
                        declaredConstructors = constructorArr;
                        strArr4 = strArr;
                        sArr3 = sArr2;
                        annotationArr3 = annotationArr;
                        cls6 = cls6;
                        map4 = map4;
                        cls7 = cls3;
                        gVar2 = gVar;
                        dex09Var2 = dex09Var;
                    } else {
                        z6 = true;
                        z7 = false;
                        iOrdinal = 0;
                        iA = 0;
                    }
                    if (name.startsWith(com.acse.ottn.p3.f)) {
                        if (name.length() < 4) {
                            cls5 = cls;
                            map3 = map;
                            gVar = gVar;
                            linkedHashMap2 = linkedHashMap3;
                            cls3 = cls7;
                        } else if (name.equals("getClass")) {
                            gVar = gVar;
                            linkedHashMap2 = linkedHashMap3;
                            cls3 = cls7;
                        } else {
                            char cCharAt = name.charAt(3);
                            if (Character.isUpperCase(cCharAt)) {
                                if (dexa) {
                                    strSubstring2 = dexa(name.substring(3));
                                } else {
                                    strSubstring2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                                }
                            } else if (cCharAt == '_') {
                                strSubstring2 = name.substring(4);
                            } else if (cCharAt == 'f') {
                                strSubstring2 = name.substring(3);
                            } else {
                                if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                                    cls5 = cls;
                                    map3 = map;
                                } else {
                                    strSubstring2 = dexa(name.substring(3));
                                }
                                gVar = gVar;
                                linkedHashMap2 = linkedHashMap3;
                                cls3 = cls7;
                            }
                            if (dexa(cls5, dex09Var2, strSubstring2)) {
                                gVar = gVar;
                                linkedHashMap2 = linkedHashMap3;
                                cls3 = cls7;
                            } else {
                                HashMap map5 = map4;
                                Field fieldDexa = dexa(cls5, strSubstring2, declaredFields, map5);
                                Class<dex08> cls8 = cls7;
                                if (fieldDexa != null) {
                                    dex08Var2 = z3 ? (dex08) fieldDexa.getAnnotation(cls8) : null;
                                    if (dex08Var2 != null) {
                                        if (dex08Var2.serialize()) {
                                            iOrdinal = dex08Var2.ordinal();
                                            iA = com.wangmai.insightvision.openadsdk.d.j.a0.a(dex08Var2.serialzeFeatures());
                                            if (dex08Var2.name().length() != 0) {
                                                strSubstring2 = dex08Var2.name();
                                                if (map3 == null || (strSubstring2 = map3.get(strSubstring2)) != null) {
                                                    i7 = iA;
                                                    linkedHashMap3 = linkedHashMap3;
                                                    declaredFields = declaredFields;
                                                    i8 = iOrdinal;
                                                    z8 = z6;
                                                }
                                            }
                                            if (gVar != 0 && !z8) {
                                                strSubstring2 = gVar.a(strSubstring2);
                                            }
                                            if (map3 == null && (strSubstring2 = map3.get(strSubstring2)) == null) {
                                                cls3 = cls8;
                                                map4 = map5;
                                                gVar = gVar;
                                                declaredFields = declaredFields;
                                                linkedHashMap2 = linkedHashMap3;
                                            } else {
                                                String str2 = strSubstring2;
                                                linkedHashMap2 = linkedHashMap3;
                                                dexa(cls5, method2, i);
                                                fieldArr = declaredFields;
                                                cls2 = cls8;
                                                map2 = map5;
                                                int i14 = i8;
                                                i5 = 3;
                                                linkedHashMap2.put(str2, new n0(str2, method2, fieldDexa, cls, null, i8, i7, dex08VarDexa, dex08Var2, z4));
                                                iOrdinal = i14;
                                                iA = i7;
                                            }
                                        }
                                        gVar = gVar;
                                        cls3 = cls8;
                                        map4 = map5;
                                        linkedHashMap2 = linkedHashMap3;
                                    }
                                    i7 = iA;
                                } else {
                                    i7 = iA;
                                    dex08Var2 = null;
                                }
                                i8 = iOrdinal;
                                z8 = z7;
                                if (gVar != 0) {
                                    strSubstring2 = gVar.a(strSubstring2);
                                }
                                if (map3 == null) {
                                }
                                String str3 = strSubstring2;
                                linkedHashMap2 = linkedHashMap3;
                                dexa(cls5, method2, i);
                                fieldArr = declaredFields;
                                cls2 = cls8;
                                map2 = map5;
                                int i15 = i8;
                                i5 = 3;
                                linkedHashMap2.put(str3, new n0(str3, method2, fieldDexa, cls, null, i8, i7, dex08VarDexa, dex08Var2, z4));
                                iOrdinal = i15;
                                iA = i7;
                            }
                        }
                        i10 = i;
                        declaredFields = declaredFields;
                        declaredConstructors = constructorArr;
                        strArr4 = strArr;
                        sArr3 = sArr2;
                        annotationArr3 = annotationArr;
                        cls6 = cls6;
                        map4 = map4;
                        cls7 = cls3;
                        gVar2 = gVar;
                        dex09Var2 = dex09Var;
                    } else {
                        linkedHashMap2 = linkedHashMap3;
                        fieldArr = declaredFields;
                        cls2 = cls7;
                        map2 = map4;
                        i5 = 3;
                    }
                    if (!name.startsWith(com.acse.ottn.p3.g) || name.length() < i5) {
                        cls5 = cls;
                        declaredFields = fieldArr;
                        cls3 = cls2;
                        map4 = map2;
                        map3 = map;
                    } else {
                        char cCharAt2 = name.charAt(2);
                        if (Character.isUpperCase(cCharAt2)) {
                            strSubstring = dexa ? dexa(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(i5);
                        } else if (cCharAt2 == '_') {
                            strSubstring = name.substring(i5);
                        } else {
                            if (cCharAt2 == 'f') {
                                strSubstring = name.substring(2);
                            } else {
                                cls5 = cls;
                            }
                            declaredFields = fieldArr;
                            cls3 = cls2;
                            map4 = map2;
                            map3 = map;
                        }
                        cls5 = cls;
                        if (dexa(cls5, dex09Var2, strSubstring)) {
                            declaredFields = fieldArr;
                            cls3 = cls2;
                            map4 = map2;
                        } else {
                            declaredFields = fieldArr;
                            HashMap map6 = map2;
                            Field fieldDexa2 = dexa(cls5, strSubstring, declaredFields, map6);
                            Field fieldDexa3 = fieldDexa2 == null ? dexa(cls5, name, declaredFields, map6) : fieldDexa2;
                            if (fieldDexa3 != null) {
                                cls4 = cls2;
                                dex08 dex08Var3 = z3 ? (dex08) fieldDexa3.getAnnotation(cls4) : null;
                                if (dex08Var3 == null) {
                                    linkedHashMap = linkedHashMap2;
                                    map3 = map;
                                    i6 = iA;
                                    dex08Var = dex08Var3;
                                } else if (dex08Var3.serialize()) {
                                    int iOrdinal2 = dex08Var3.ordinal();
                                    int iA2 = com.wangmai.insightvision.openadsdk.d.j.a0.a(dex08Var3.serialzeFeatures());
                                    if (dex08Var3.name().length() != 0) {
                                        strSubstring = dex08Var3.name();
                                        linkedHashMap = linkedHashMap2;
                                        map3 = map;
                                        if (map3 == null || (strSubstring = map3.get(strSubstring)) != null) {
                                        }
                                        linkedHashMap2 = linkedHashMap;
                                        cls3 = cls4;
                                        map4 = map6;
                                    } else {
                                        linkedHashMap = linkedHashMap2;
                                        map3 = map;
                                    }
                                    dex08Var = dex08Var3;
                                    iOrdinal = iOrdinal2;
                                    i6 = iA2;
                                } else {
                                    cls3 = cls4;
                                    map4 = map6;
                                }
                            } else {
                                linkedHashMap = linkedHashMap2;
                                cls4 = cls2;
                                map3 = map;
                                i6 = iA;
                                dex08Var = null;
                            }
                            if (gVar != 0) {
                                strSubstring = gVar.a(strSubstring);
                            }
                            if (map3 == null || (strSubstring = map3.get(strSubstring)) != null) {
                                String str4 = strSubstring;
                                dexa(cls5, fieldDexa3, i);
                                dexa(cls5, method2, i);
                                map4 = map6;
                                gVar = gVar;
                                cls3 = cls4;
                                n0 n0Var = new n0(str4, method2, fieldDexa3, cls, null, iOrdinal, i6, dex08VarDexa, dex08Var, z4);
                                linkedHashMap2 = linkedHashMap;
                                linkedHashMap2.put(str4, n0Var);
                            } else {
                                linkedHashMap2 = linkedHashMap;
                                cls3 = cls4;
                                map4 = map6;
                            }
                        }
                        map3 = map;
                    }
                    i10 = i;
                    declaredFields = declaredFields;
                    declaredConstructors = constructorArr;
                    strArr4 = strArr;
                    sArr3 = sArr2;
                    annotationArr3 = annotationArr;
                    cls6 = cls6;
                    map4 = map4;
                    cls7 = cls3;
                    gVar2 = gVar;
                    dex09Var2 = dex09Var;
                }
            }
        }
        Class<dex08> cls9 = cls7;
        Class<? super Object> cls10 = cls6;
        com.wangmai.insightvision.openadsdk.d.g gVar3 = gVar2;
        Field[] fieldArr2 = declaredFields;
        ArrayList<Field> arrayList2 = new ArrayList(fieldArr2.length);
        for (Field field : fieldArr2) {
            if ((field.getModifiers() & 8) == 0 && !field.getName().equals("this$0") && (field.getModifiers() & 1) != 0) {
                arrayList2.add(field);
            }
        }
        Class<? super Object> superclass2 = cls.getSuperclass();
        while (superclass2 != null) {
            Class<? super Object> cls11 = cls10;
            if (superclass2 == cls11) {
                break;
            }
            for (Field field2 : superclass2.getDeclaredFields()) {
                if ((field2.getModifiers() & 8) == 0 && (field2.getModifiers() & 1) != 0) {
                    arrayList2.add(field2);
                }
            }
            superclass2 = superclass2.getSuperclass();
            cls10 = cls11;
        }
        for (Field field3 : arrayList2) {
            cls9 = cls9;
            dex08 dex08Var4 = z3 ? (dex08) field3.getAnnotation(cls9) : null;
            String name2 = field3.getName();
            if (dex08Var4 == null) {
                i3 = 0;
                i4 = 0;
            } else if (dex08Var4.serialize()) {
                int iOrdinal3 = dex08Var4.ordinal();
                int iA3 = com.wangmai.insightvision.openadsdk.d.j.a0.a(dex08Var4.serialzeFeatures());
                if (dex08Var4.name().length() != 0) {
                    name2 = dex08Var4.name();
                }
                i3 = iOrdinal3;
                i4 = iA3;
            }
            if (map3 == null || (name2 = map3.get(name2)) != null) {
                if (gVar3 != null) {
                    name2 = gVar3.a(name2);
                }
                String str5 = name2;
                if (linkedHashMap2.containsKey(str5)) {
                    cls5 = cls;
                } else {
                    dexa(cls5, field3, i);
                    LinkedHashMap linkedHashMap4 = linkedHashMap2;
                    linkedHashMap4.put(str5, new n0(str5, null, field3, cls, null, i3, i4, null, dex08Var4, z4));
                    linkedHashMap2 = linkedHashMap4;
                    cls5 = cls;
                }
            }
        }
        LinkedHashMap linkedHashMap5 = linkedHashMap2;
        ArrayList arrayList3 = new ArrayList();
        if (dex09Var != null) {
            strArrOrders = dex09Var.orders();
            if (strArrOrders != null && strArrOrders.length == linkedHashMap5.size()) {
                int length3 = strArrOrders.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length3) {
                        z5 = true;
                        break;
                    }
                    if (linkedHashMap5.containsKey(strArrOrders[i16])) {
                        i16++;
                    }
                }
            }
            if (z5) {
                for (String str6 : strArrOrders) {
                    arrayList3.add((n0) linkedHashMap5.get(str6));
                }
            } else {
                it = linkedHashMap5.values().iterator();
                while (it.hasNext()) {
                    arrayList3.add((n0) it.next());
                }
                if (z2) {
                    Collections.sort(arrayList3);
                }
            }
            return arrayList3;
        }
        strArrOrders = null;
        z5 = false;
        if (z5) {
            while (i2 < r2) {
                arrayList3.add((n0) linkedHashMap5.get(str6));
            }
        } else {
            it = linkedHashMap5.values().iterator();
            while (it.hasNext()) {
                arrayList3.add((n0) it.next());
            }
            if (z2) {
                Collections.sort(arrayList3);
            }
        }
        return arrayList3;
    }

    public static void dexa(String str, Class<?> cls) {
        dexm.put(str, cls);
    }

    public static boolean dexa(Class<?> cls, dex09 dex09Var, String str) {
        if (dex09Var != null && dex09Var.ignores() != null) {
            for (String str2 : dex09Var.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !dexa(superclass, (dex09) superclass.getAnnotation(dex09.class), str)) ? false : true;
    }

    public static boolean dexa(Class cls, String str) {
        String[] strArr;
        if (dexk == null && !dexl) {
            try {
                HashMap map = new HashMap();
                map.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                dexk = map;
            } catch (Throwable unused) {
                dexl = true;
            }
        }
        return (dexk == null || (strArr = dexk.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dexa(Class<?> cls, Member member, int i) {
        if (member != 0 && dexb) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                dexb = false;
            }
        }
        return false;
    }

    public static boolean dexa(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (dexa(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new p0(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static long dexb(String str) {
        if (str == null) {
            return 0L;
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j = (j ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            }
        }
        return j;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final <T> T dexb(Object obj, Class<T> cls, a aVar) throws com.wangmai.insightvision.openadsdk.d.d {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to : " + cls.getName(), e);
        }
    }

    public static Field dexb(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        Field[] declaredFields = map != null ? map.get(superclass) : null;
        if (declaredFields == null) {
            declaredFields = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, declaredFields);
            }
        }
        return dexa(superclass, str, declaredFields, map);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public static Type dexb(Type type) {
        Type typeDexb;
        if (type instanceof ParameterizedType) {
            typeDexb = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (typeDexb instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) typeDexb).getUpperBounds();
                if (upperBounds.length == 1) {
                    typeDexb = upperBounds[0];
                }
            }
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getName().startsWith("java.")) {
                typeDexb = null;
            } else {
                typeDexb = dexb(cls.getGenericSuperclass());
            }
        } else {
            typeDexb = null;
        }
        return typeDexb == null ? Object.class : typeDexb;
    }

    public static final BigInteger dexb(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigInteger(string);
    }

    public static String[] dexb(Class cls) {
        if (dexf == null && !dexe) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                dexf = cls2.getConstructor(Class.class);
                dexg = cls2.getMethod("getConstructors", new Class[0]);
                dexh = KFunction.class.getMethod("getParameters", new Class[0]);
                dexi = KParameter.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused) {
                dexe = true;
            }
        }
        if (dexf == null || dexj) {
            return null;
        }
        try {
            Iterator it = ((Iterable) dexg.invoke(dexf.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) dexh.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) dexh.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) dexi.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable unused2) {
            dexj = true;
            return null;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static Boolean dexc(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(((BigDecimal) obj).intValueExact() == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty() || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to int, value : " + obj);
    }

    public static Class<?> dexc(String str) {
        return dexm.get(str);
    }

    public static Type dexc(Type type) {
        return type instanceof Class ? dexc(((Class) type).getGenericSuperclass()) : type;
    }

    public static boolean dexc(Class cls) {
        if (dexc == null && !dexd) {
            try {
                dexc = Metadata.class;
            } catch (Throwable unused) {
                dexd = true;
            }
        }
        if (dexc == null) {
            return false;
        }
        return cls.isAnnotationPresent(dexc);
    }

    public static double dexd(String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '-' && i2 == 0) {
                z = true;
            } else if (cCharAt == '.') {
                if (i != 0) {
                    return Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Double.parseDouble(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                d = j;
                d2 = 10.0d;
                break;
            case 2:
                d = j;
                d2 = 100.0d;
                break;
            case 3:
                d = j;
                d2 = 1000.0d;
                break;
            case 4:
                d = j;
                d2 = 10000.0d;
                break;
            case 5:
                d = j;
                d2 = 100000.0d;
                break;
            case 6:
                d = j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = j;
                d2 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d / d2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Byte dexd(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        byte bBooleanValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            bBooleanValue = ((Number) obj).byteValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            bBooleanValue = Byte.parseByte(str);
        } else {
            if (!(obj instanceof Boolean)) {
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to byte, value : " + obj);
            }
            bBooleanValue = ((Boolean) obj).booleanValue();
        }
        return Byte.valueOf(bBooleanValue);
    }

    public static boolean dexd(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && dexd(genericSuperclass);
    }

    public static float dexe(String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '-' && i2 == 0) {
                z = true;
            } else if (cCharAt == '.') {
                if (i != 0) {
                    return Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Float.parseFloat(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                f = j;
                f2 = 10.0f;
                break;
            case 2:
                f = j;
                f2 = 100.0f;
                break;
            case 3:
                f = j;
                f2 = 1000.0f;
                break;
            case 4:
                f = j;
                f2 = 10000.0f;
                break;
            case 5:
                f = j;
                f2 = 100000.0f;
                break;
            case 6:
                f = j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = j;
                f2 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f / f2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static byte[] dexe(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return dex13.dexa(str, 0, str.length());
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to int, value : " + obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final Character dexf(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to byte, value : " + obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final Date dexg(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        long jLongValue;
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int iScale = bigDecimal.scale();
            jLongValue = (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
        } else if (obj instanceof Number) {
            jLongValue = ((Number) obj).longValue();
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == dex04.d.length()) {
                    str = dex04.d;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else if (str2.length() == 19) {
                    str = "yyyy-MM-dd HH:mm:ss";
                } else {
                    str = (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : c25.o;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, dex04.b);
                simpleDateFormat.setTimeZone(dex04.f22670a);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to Date, value : " + str2);
                }
            }
            if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            }
            jLongValue = Long.parseLong(str2);
        } else {
            jLongValue = -1;
        }
        if (jLongValue >= 0) {
            return new Date(jLongValue);
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to Date, value : " + obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final Double dexh(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        double dDoubleValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            dDoubleValue = ((Number) obj).doubleValue();
        } else {
            if (!(obj instanceof String)) {
                if (obj instanceof Boolean) {
                    return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : AudioStats.AUDIO_AMPLITUDE_NONE);
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to double, value : " + obj);
            }
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
                return null;
            }
            dDoubleValue = Double.parseDouble(string);
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final Float dexi(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        float fFloatValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            fFloatValue = ((Number) obj).floatValue();
        } else {
            if (!(obj instanceof String)) {
                if (obj instanceof Boolean) {
                    return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to float, value : " + obj);
            }
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string)) {
                return null;
            }
            fFloatValue = Float.parseFloat(string);
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Integer dexj(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        int iBooleanValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int iScale = bigDecimal.scale();
            iBooleanValue = (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
        } else if (obj instanceof Number) {
            iBooleanValue = ((Number) obj).intValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty() || "null".equals(str)) {
                return null;
            }
            iBooleanValue = Integer.parseInt(str);
        } else {
            if (!(obj instanceof Boolean)) {
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to int, value : " + obj);
            }
            iBooleanValue = ((Boolean) obj).booleanValue();
        }
        return Integer.valueOf(iBooleanValue);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public static final Long dexk(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        long timeInMillis;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int iScale = bigDecimal.scale();
            timeInMillis = (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
        } else {
            if (!(obj instanceof Number)) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str)) {
                        return null;
                    }
                    try {
                        return Long.valueOf(Long.parseLong(str));
                    } catch (NumberFormatException unused) {
                        dex13 dex13Var = new dex13(str);
                        Calendar calendar = dex13Var.dexb(false) ? dex13Var.dexo : null;
                        dex13Var.dexb();
                        if (calendar != null) {
                            timeInMillis = calendar.getTimeInMillis();
                        }
                    }
                }
                if (obj instanceof Boolean) {
                    return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to long, value : " + obj);
            }
            timeInMillis = ((Number) obj).longValue();
        }
        return Long.valueOf(timeInMillis);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Short dexl(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        short sBooleanValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            sBooleanValue = ((Number) obj).shortValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            sBooleanValue = Short.parseShort(str);
        } else {
            if (!(obj instanceof Boolean)) {
                throw new com.wangmai.insightvision.openadsdk.d.d("can not cast to short, value : " + obj);
            }
            sBooleanValue = ((Boolean) obj).booleanValue();
        }
        return Short.valueOf(sBooleanValue);
    }

    public static final String dexm(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
