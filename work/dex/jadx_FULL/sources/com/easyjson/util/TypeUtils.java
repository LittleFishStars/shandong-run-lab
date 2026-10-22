package com.easyjson.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.sdk.m.y.l;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.easyjson.JSON;
import com.easyjson.JSONException;
import com.easyjson.JSONObject;
import com.easyjson.annotation.JSONField;
import com.easyjson.annotation.JSONType;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.JavaBeanDeserializer;
import com.easyjson.parser.ParserConfig;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.serializer.SerializerFeature;
import com.zj.adlib.c25;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
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
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = null;
    private static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
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
            return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Array.set(t, i, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                    i++;
                }
                return t;
            }
            if (cls == byte[].class) {
                return (T) castToBytes(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) castToByte(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) castToShort(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) castToInt(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) castToLong(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) castToFloat(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) castToDouble(obj);
        }
        if (cls == String.class) {
            return (T) castToString(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (cls == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (cls == Date.class) {
            return (T) castToDate(obj);
        }
        if (cls.isEnum()) {
            return (T) castToEnum(obj, cls, parserConfig);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date dateCastToDate = castToDate(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e) {
                    throw new JSONException("can not cast to : " + cls.getName(), e);
                }
            }
            ((Calendar) obj2).setTime(dateCastToDate);
            return (T) obj2;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
        }
        throw new JSONException("can not cast to : " + cls.getName());
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t).add(cast(it.next(), type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r8;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
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
        throw new JSONException("can not cast to : " + type);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
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

    public static final BigInteger castToBigInteger(Object obj) {
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

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Byte castToByte(Object obj) {
        byte bByteValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            bByteValue = ((Number) obj).byteValue();
        } else {
            if (!(obj instanceof String)) {
                throw new JSONException("can not cast to byte, value : " + obj);
            }
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            bByteValue = Byte.parseByte(str);
        }
        return Byte.valueOf(bByteValue);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return JSONLexer.decodeFast((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
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
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : -1L;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else {
                    str = str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : c25.o;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str2);
                }
            }
            if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            }
            jLongValue = Long.parseLong(str2);
        }
        if (jLongValue >= 0) {
            return new Date(jLongValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        double dDoubleValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            dDoubleValue = ((Number) obj).doubleValue();
        } else {
            if (!(obj instanceof String)) {
                throw new JSONException("can not cast to double, value : " + obj);
            }
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string)) {
                return null;
            }
            dDoubleValue = Double.parseDouble(string);
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static final Float castToFloat(Object obj) {
        float fFloatValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            fFloatValue = ((Number) obj).floatValue();
        } else {
            if (!(obj instanceof String)) {
                throw new JSONException("can not cast to float, value : " + obj);
            }
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string)) {
                return null;
            }
            fFloatValue = Float.parseFloat(string);
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Integer castToInt(Object obj) {
        int iIntValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            iIntValue = ((Number) obj).intValue();
        } else {
            if (!(obj instanceof String)) {
                throw new JSONException("can not cast to int, value : " + obj);
            }
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            iIntValue = Integer.parseInt(str);
        }
        return Integer.valueOf(iIntValue);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.global);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        int iIntValue = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValue = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValue);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> clsLoadClass = loadClass(str4, null);
                if (clsLoadClass == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsLoadClass.equals(cls)) {
                    return (T) castToJavaBean(map, clsLoadClass, parserConfig);
                }
            }
            if (cls.isInterface()) {
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, map instanceof JSONObject ? (JSONObject) map : new JSONObject(map));
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer");
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static final Long castToLong(Object obj) {
        long timeInMillis;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Number)) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException unused) {
                    JSONLexer jSONLexer = new JSONLexer(str);
                    Calendar calendar = jSONLexer.scanISO8601DateIfMatch(false) ? jSONLexer.getCalendar() : null;
                    jSONLexer.close();
                    if (calendar != null) {
                        timeInMillis = calendar.getTimeInMillis();
                    }
                }
            }
            throw new JSONException("can not cast to long, value : " + obj);
        }
        timeInMillis = ((Number) obj).longValue();
        return Long.valueOf(timeInMillis);
    }

    public static final Short castToShort(Object obj) {
        short sShortValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            sShortValue = ((Number) obj).shortValue();
        } else {
            if (!(obj instanceof String)) {
                throw new JSONException("can not cast to short, value : " + obj);
            }
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            sShortValue = Short.parseShort(str);
        }
        return Short.valueOf(sShortValue);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Code duplicated, block: B:138:0x02ef A[PHI: r0
      0x02ef: PHI (r0v38 java.lang.String) = (r0v37 java.lang.String), (r0v41 java.lang.String) binds: [B:134:0x02e4, B:136:0x02ec] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x0311  */
    /* JADX WARN: Code duplicated, block: B:206:0x0442  */
    /* JADX WARN: Code duplicated, block: B:208:0x0447 A[LOOP:6: B:207:0x0445->B:208:0x0447, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:209:0x0455  */
    /* JADX WARN: Code duplicated, block: B:212:0x0463 A[LOOP:7: B:210:0x045d->B:212:0x0463, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:214:0x046f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0172  */
    /* JADX WARN: Code duplicated, block: B:67:0x0182  */
    /* JADX WARN: Code duplicated, block: B:69:0x018a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x018c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0193  */
    /* JADX WARN: Code duplicated, block: B:73:0x0197  */
    /* JADX WARN: Code duplicated, block: B:76:0x019e  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:85:0x01d1  */
    /* JADX WARN: Instruction removed from duplicated block: B:206:0x0442, please report this as an issue */
    public static List<FieldInfo> computeGetters(Class<?> cls, int i, boolean z, JSONType jSONType, Map<String, String> map, boolean z2, boolean z3, boolean z4) {
        String[] strArrOrders;
        boolean z5;
        Iterator it;
        int i2;
        int i3;
        int i4;
        Class<JSONField> cls2;
        Field[] fieldArr;
        int iOrdinal;
        int iOf;
        Method method;
        Field[] fieldArr2;
        Class<JSONField> cls3;
        String strSubstring;
        JSONField jSONField;
        int i5;
        int i6;
        String strSubstring2;
        Field field;
        Class<JSONField> cls4;
        int i7;
        int i8;
        JSONField jSONField2;
        JSONField jSONField3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Class<? super Object> cls5 = Object.class;
        Class<JSONField> cls6 = JSONField.class;
        if (!z) {
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i9 = 0;
            while (i9 < length) {
                Method method2 = methods[i9];
                String name = method2.getName();
                if ((method2.getModifiers() & 8) != 0 || method2.getReturnType().equals(Void.TYPE) || method2.getParameterTypes().length != 0 || method2.getReturnType() == ClassLoader.class || method2.getDeclaringClass() == cls5 || (name.equals("getMetaClass") && method2.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                    i9 = i9;
                    length = length;
                    methods = methods;
                    cls2 = cls6;
                    cls5 = cls5;
                    fieldArr = declaredFields;
                } else {
                    JSONField supperMethodAnnotation = z3 ? (JSONField) method2.getAnnotation(cls6) : null;
                    if (supperMethodAnnotation == null && z3) {
                        supperMethodAnnotation = getSupperMethodAnnotation(cls, method2);
                    }
                    JSONField jSONField4 = supperMethodAnnotation;
                    if (jSONField4 != null) {
                        if (jSONField4.serialize()) {
                            iOrdinal = jSONField4.ordinal();
                            iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                            if (jSONField4.name().length() != 0) {
                                String strName = jSONField4.name();
                                if (map == 0 || (strName = map.get(strName)) != null) {
                                    String str = strName;
                                    setAccessible(cls, method2, i);
                                    i9 = i9;
                                    length = length;
                                    methods = methods;
                                    cls6 = cls6;
                                    cls5 = cls5;
                                    declaredFields = declaredFields;
                                    linkedHashMap.put(str, new FieldInfo(str, method2, null, cls, null, iOrdinal, iOf, jSONField4, null, true));
                                }
                            }
                            fieldArr = declaredFields;
                            cls2 = cls6;
                        }
                        i9 = i9;
                        length = length;
                        methods = methods;
                        cls2 = cls6;
                        cls5 = cls5;
                        fieldArr = declaredFields;
                    } else {
                        iOrdinal = 0;
                        iOf = 0;
                    }
                    if (!name.startsWith(p3.f)) {
                        method = method2;
                        fieldArr2 = declaredFields;
                        cls3 = cls6;
                    } else if (name.length() < 4 || name.equals("getClass")) {
                        fieldArr = declaredFields;
                        cls2 = cls6;
                    } else {
                        char cCharAt = name.charAt(3);
                        if (Character.isUpperCase(cCharAt)) {
                            if (compatibleWithJavaBean) {
                                strSubstring2 = decapitalize(name.substring(3));
                            } else {
                                strSubstring2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                            }
                            if (isJSONTypeIgnore(cls, jSONType, strSubstring2)) {
                                field = getField(cls, strSubstring2, declaredFields);
                                cls4 = cls6;
                                if (field != null) {
                                    if (z3) {
                                        jSONField3 = (JSONField) field.getAnnotation(cls4);
                                    } else {
                                        jSONField3 = null;
                                    }
                                    if (jSONField3 != null) {
                                        if (jSONField3.serialize()) {
                                            int iOrdinal2 = jSONField3.ordinal();
                                            int iOf2 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                            if (jSONField3.name().length() != 0) {
                                                strSubstring2 = jSONField3.name();
                                                if (map != 0 || (strSubstring2 = map.get(strSubstring2)) != null) {
                                                }
                                            }
                                            jSONField2 = jSONField3;
                                            i8 = iOrdinal2;
                                            i7 = iOf2;
                                        }
                                        fieldArr = declaredFields;
                                        cls2 = cls4;
                                    } else {
                                        i7 = iOf;
                                        i8 = iOrdinal;
                                        jSONField2 = jSONField3;
                                    }
                                } else {
                                    i7 = iOf;
                                    i8 = iOrdinal;
                                    jSONField2 = null;
                                }
                                if (map == 0 && (strSubstring2 = map.get(strSubstring2)) == null) {
                                    fieldArr = declaredFields;
                                    cls2 = cls4;
                                } else {
                                    String str2 = strSubstring2;
                                    setAccessible(cls, method2, i);
                                    method = method2;
                                    cls3 = cls4;
                                    fieldArr2 = declaredFields;
                                    linkedHashMap.put(str2, new FieldInfo(str2, method2, field, cls, null, i8, i7, jSONField4, jSONField2, z4));
                                    iOrdinal = i8;
                                    iOf = i7;
                                }
                            }
                        } else {
                            if (cCharAt == '_') {
                                strSubstring2 = name.substring(4);
                            } else if (cCharAt == 'f') {
                                strSubstring2 = name.substring(3);
                            } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                strSubstring2 = decapitalize(name.substring(3));
                            }
                            if (isJSONTypeIgnore(cls, jSONType, strSubstring2)) {
                                field = getField(cls, strSubstring2, declaredFields);
                                cls4 = cls6;
                                if (field != null) {
                                    if (z3) {
                                        jSONField3 = (JSONField) field.getAnnotation(cls4);
                                    } else {
                                        jSONField3 = null;
                                    }
                                    if (jSONField3 != null) {
                                        if (jSONField3.serialize()) {
                                            int iOrdinal3 = jSONField3.ordinal();
                                            int iOf3 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                            if (jSONField3.name().length() != 0) {
                                                strSubstring2 = jSONField3.name();
                                                if (map != 0) {
                                                }
                                            }
                                            jSONField2 = jSONField3;
                                            i8 = iOrdinal3;
                                            i7 = iOf3;
                                        }
                                        fieldArr = declaredFields;
                                        cls2 = cls4;
                                    } else {
                                        i7 = iOf;
                                        i8 = iOrdinal;
                                        jSONField2 = jSONField3;
                                    }
                                } else {
                                    i7 = iOf;
                                    i8 = iOrdinal;
                                    jSONField2 = null;
                                }
                                if (map == 0) {
                                }
                                String str3 = strSubstring2;
                                setAccessible(cls, method2, i);
                                method = method2;
                                cls3 = cls4;
                                fieldArr2 = declaredFields;
                                linkedHashMap.put(str3, new FieldInfo(str3, method2, field, cls, null, i8, i7, jSONField4, jSONField2, z4));
                                iOrdinal = i8;
                                iOf = i7;
                            }
                        }
                        fieldArr = declaredFields;
                        cls2 = cls6;
                    }
                    if (!name.startsWith(p3.g) || name.length() < 3) {
                        fieldArr = fieldArr2;
                        cls2 = cls3;
                    } else {
                        char cCharAt2 = name.charAt(2);
                        if (Character.isUpperCase(cCharAt2)) {
                            strSubstring = compatibleWithJavaBean ? decapitalize(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(3);
                        } else if (cCharAt2 == '_') {
                            strSubstring = name.substring(3);
                        } else if (cCharAt2 == 'f') {
                            strSubstring = name.substring(2);
                        } else {
                            fieldArr = fieldArr2;
                            cls2 = cls3;
                        }
                        fieldArr = fieldArr2;
                        Field field2 = getField(cls, strSubstring, fieldArr);
                        if (field2 == null) {
                            field2 = getField(cls, name, fieldArr);
                        }
                        if (field2 != null) {
                            cls2 = cls3;
                            JSONField jSONField5 = z3 ? (JSONField) field2.getAnnotation(cls2) : null;
                            if (jSONField5 == null) {
                                jSONField = jSONField5;
                            } else if (jSONField5.serialize()) {
                                int iOrdinal4 = jSONField5.ordinal();
                                int iOf4 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                if (jSONField5.name().length() != 0) {
                                    strSubstring = jSONField5.name();
                                    map = map;
                                    fieldArr = fieldArr;
                                    if (map == null || (strSubstring = map.get(strSubstring)) != null) {
                                    }
                                } else {
                                    map = map;
                                    fieldArr = fieldArr;
                                }
                                jSONField = jSONField5;
                                i5 = iOrdinal4;
                                i6 = iOf4;
                                if (map != null || (strSubstring = map.get(strSubstring)) != null) {
                                    String str4 = strSubstring;
                                    setAccessible(cls, field2, i);
                                    Method method3 = method;
                                    setAccessible(cls, method3, i);
                                    linkedHashMap.put(str4, new FieldInfo(str4, method3, field2, cls, null, i5, i6, jSONField4, jSONField, z4));
                                }
                            } else {
                                fieldArr = fieldArr;
                            }
                        } else {
                            cls2 = cls3;
                            jSONField = null;
                        }
                        i5 = iOrdinal;
                        i6 = iOf;
                        if (map != null) {
                            String str5 = strSubstring;
                            setAccessible(cls, field2, i);
                            Method method4 = method;
                            setAccessible(cls, method4, i);
                            linkedHashMap.put(str5, new FieldInfo(str5, method4, field2, cls, null, i5, i6, jSONField4, jSONField, z4));
                        } else {
                            String str6 = strSubstring;
                            setAccessible(cls, field2, i);
                            Method method5 = method;
                            setAccessible(cls, method5, i);
                            linkedHashMap.put(str6, new FieldInfo(str6, method5, field2, cls, null, i5, i6, jSONField4, jSONField, z4));
                        }
                    }
                }
                i9++;
                cls6 = cls2;
                declaredFields = fieldArr;
                length = length;
                methods = methods;
                cls5 = cls5;
            }
        }
        Class<JSONField> cls7 = cls6;
        Class<? super Object> cls8 = cls5;
        Field[] fieldArr3 = declaredFields;
        ArrayList<Field> arrayList = new ArrayList(fieldArr3.length);
        for (Field field3 : fieldArr3) {
            if ((field3.getModifiers() & 8) == 0 && (field3.getModifiers() & 1) != 0) {
                arrayList.add(field3);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls9 = cls8;
            if (superclass == cls9) {
                break;
            }
            for (Field field4 : superclass.getDeclaredFields()) {
                if ((field4.getModifiers() & 8) == 0 && (field4.getModifiers() & 1) != 0) {
                    arrayList.add(field4);
                }
            }
            superclass = superclass.getSuperclass();
            cls8 = cls9;
        }
        for (Field field5 : arrayList) {
            JSONField jSONField6 = z3 ? (JSONField) field5.getAnnotation(cls7) : null;
            String name2 = field5.getName();
            if (jSONField6 == null) {
                i3 = 0;
                i4 = 0;
            } else if (jSONField6.serialize()) {
                int iOrdinal5 = jSONField6.ordinal();
                int iOf5 = SerializerFeature.of(jSONField6.serialzeFeatures());
                if (jSONField6.name().length() != 0) {
                    name2 = jSONField6.name();
                }
                i3 = iOrdinal5;
                i4 = iOf5;
            }
            if (map == 0 || (name2 = map.get(name2)) != null) {
                String str7 = name2;
                if (!linkedHashMap.containsKey(str7)) {
                    setAccessible(cls, field5, i);
                    linkedHashMap.put(str7, new FieldInfo(str7, null, field5, cls, null, i3, i4, null, jSONField6, z4));
                    cls7 = cls7;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (jSONType != null) {
            strArrOrders = jSONType.orders();
            if (strArrOrders != null && strArrOrders.length == linkedHashMap.size()) {
                int length2 = strArrOrders.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        z5 = true;
                        break;
                    }
                    if (linkedHashMap.containsKey(strArrOrders[i10])) {
                        i10++;
                    }
                }
            }
            if (z5) {
                for (String str8 : strArrOrders) {
                    arrayList2.add((FieldInfo) linkedHashMap.get(str8));
                }
            } else {
                it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    arrayList2.add((FieldInfo) it.next());
                }
                if (z2) {
                    Collections.sort(arrayList2);
                }
            }
            return arrayList2;
        }
        strArrOrders = null;
        z5 = false;
        if (z5) {
            while (i2 < r2) {
                arrayList2.add((FieldInfo) linkedHashMap.get(str8));
            }
        } else {
            it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList2.add((FieldInfo) it.next());
            }
            if (z2) {
                Collections.sort(arrayList2);
            }
        }
        return arrayList2;
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        return type instanceof TypeVariable ? (Class) ((TypeVariable) type).getBounds()[0] : Object.class;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        Field field0 = getField0(cls, str, fieldArr);
        if (field0 == null) {
            field0 = getField0(cls, LoginConstants.UNDER_LINE + str, fieldArr);
        }
        if (field0 == null) {
            field0 = getField0(cls, "m_" + str, fieldArr);
        }
        if (field0 != null) {
            return field0;
        }
        return getField0(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr);
    }

    private static Field getField0(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
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
                                z = true;
                                break;
                            }
                            if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z = false;
                                break;
                            }
                            i++;
                        }
                        if (z && (jSONField = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && isGenericParamType(genericSuperclass);
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (jSONType != null && jSONType.ignores() != null) {
            for (String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        Exception e;
        Class<?> clsLoadClass;
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls = mappings.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(l.b)) {
            return loadClass(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                mappings.put(str, cls);
                return cls;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                clsLoadClass = contextClassLoader.loadClass(str);
                try {
                    mappings.put(str, clsLoadClass);
                    return clsLoadClass;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    cls = clsLoadClass;
                    cls = Class.forName(str);
                    mappings.put(str, cls);
                    return cls;
                }
            }
        } catch (Exception e4) {
            Class<?> cls2 = cls;
            e = e4;
            clsLoadClass = cls2;
        }
        try {
            cls = Class.forName(str);
            mappings.put(str, cls);
            return cls;
        } catch (Exception e5) {
            e5.printStackTrace();
            return cls;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setAccessible(Class<?> cls, Member member, int i) {
        if (member != 0 && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }
}
