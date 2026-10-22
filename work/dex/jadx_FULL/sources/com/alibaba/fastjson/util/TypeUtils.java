package com.alibaba.fastjson.util;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.m.y.l;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.zj.adlib.c25;
import com.zj.adlib.ze1;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.AccessControlException;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlAccessorType;
import kotlin.Metadata;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TypeUtils {
    private static Object OPTIONAL_EMPTY = null;
    private static boolean OPTIONAL_ERROR = false;
    private static Class class_deque = null;
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    public static final long fnv1a_64_magic_hashcode = -3750763034362895579L;
    public static final long fnv1a_64_magic_prime = 1099511628211L;
    private static final Set<String> isProxyClassNames;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static Class<?> optionalClass;
    private static Method oracleDateMethod;
    private static Method oracleTimestampMethod;
    private static Class<?> pathClass;
    private static final Map primitiveTypeMap;
    private static Class<? extends Annotation> transientClass;
    private static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*$");
    private static boolean setAccessibleEnable = true;
    private static boolean oracleTimestampMethodInited = false;
    private static boolean oracleDateMethodInited = false;
    private static boolean optionalClassInited = false;
    private static boolean transientClassInited = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap(256, 0.75f, 1);
    private static boolean pathClass_error = false;
    private static Class<? extends Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static volatile Class class_Clob = null;
    private static volatile boolean class_Clob_error = false;
    private static volatile Class class_XmlAccessType = null;
    private static volatile Class class_XmlAccessorType = null;
    private static volatile boolean classXmlAccessorType_error = false;
    private static volatile Method method_XmlAccessorType_value = null;
    private static volatile Field field_XmlAccessType_FIELD = null;
    private static volatile Object field_XmlAccessType_FIELD_VALUE = null;

    public static class MethodInheritanceComparator implements Comparator<Method> {
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        class_deque = null;
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable unused) {
        }
        try {
            class_deque = Deque.class;
        } catch (Throwable unused2) {
        }
        addBaseClassMappings();
        primitiveTypeMap = new HashMap<Class, String>(8) { // from class: com.alibaba.fastjson.util.TypeUtils.1
            {
                put(Boolean.TYPE, "Z");
                put(Character.TYPE, "C");
                put(Byte.TYPE, "B");
                put(Short.TYPE, "S");
                put(Integer.TYPE, "I");
                put(Long.TYPE, "J");
                put(Float.TYPE, "F");
                put(Double.TYPE, "D");
            }
        };
        isProxyClassNames = new HashSet<String>(6) { // from class: com.alibaba.fastjson.util.TypeUtils.2
            {
                add("net.sf.cglib.proxy.Factory");
                add("org.springframework.cglib.proxy.Factory");
                add("javassist.util.proxy.ProxyObject");
                add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
                add("org.hibernate.proxy.HibernateProxy");
                add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
            }
        };
        OPTIONAL_ERROR = false;
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
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
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
        for (int i = 0; i < 72; i++) {
            Class<?> cls = clsArr[i];
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static byte byteValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Object obj2;
        int i = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
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
        if (cls == Character.TYPE || cls == Character.class) {
            return (T) castToChar(obj);
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
        if (cls == java.sql.Date.class) {
            return (T) castToSqlDate(obj);
        }
        if (cls == Time.class) {
            return (T) castToSqlTime(obj);
        }
        if (cls == Timestamp.class) {
            return (T) castToTimestamp(obj);
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
        String name = cls.getName();
        if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
            Date dateCastToDate2 = castToDate(obj);
            Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            calendar.setTime(dateCastToDate2);
            return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (cls == Locale.class) {
                return (T) toLocale(str);
            }
            if (name.startsWith("java.time.")) {
                return (T) JSON.parseObject(JSON.toJSONString(str), cls);
            }
        }
        if (parserConfig.get(cls) != null) {
            return (T) JSON.parseObject(JSON.toJSONString(obj), cls);
        }
        throw new JSONException("can not cast to : " + cls.getName());
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            if (Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            if (Double.isNaN(d.doubleValue()) || Double.isInfinite(d.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigDecimal(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static BigInteger castToBigInteger(Object obj) {
        BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            if (Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f.longValue());
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (Double.isNaN(d.doubleValue()) || Double.isInfinite(d.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (iScale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigInteger(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(intValue((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(byteValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (obj instanceof Boolean) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to byte[], value : " + obj);
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        return castToDate(obj, null);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            throw new JSONException("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                return deserializer instanceof EnumDeserializer ? (T) ((EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int iIntValue = intValue((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            if (obj instanceof Number) {
                int iIntValue2 = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue2 < enumConstants2.length) {
                    return enumConstants2[iIntValue2];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new JSONException("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(intValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToInt(it.next());
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.getGlobalInstance());
    }

    public static Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(strReplaceAll);
                Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(shortValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        long jLongValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof BigDecimal) {
            jLongValue = longValue((BigDecimal) obj);
        } else {
            jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                jLongValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
                jLongValue = jSONScanner.getCalendar().getTime().getTime();
            }
        }
        if (jLongValue > 0) {
            return new java.sql.Date(jLongValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Time castToSqlTime(Object obj) {
        long jLongValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Time) {
            return (Time) obj;
        }
        if (obj instanceof Date) {
            return new Time(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new Time(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof BigDecimal) {
            jLongValue = longValue((BigDecimal) obj);
        } else {
            jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                return null;
            }
            if (isNumber(str)) {
                jLongValue = Long.parseLong(str);
            } else {
                if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                    return Time.valueOf(str);
                }
                JSONScanner jSONScanner = new JSONScanner(str);
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
                jLongValue = jSONScanner.getCalendar().getTime().getTime();
            }
        }
        if (jLongValue > 0) {
            return new Time(jLongValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Timestamp castToTimestamp(Object obj) {
        long jLongValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        if (obj instanceof BigDecimal) {
            jLongValue = longValue((BigDecimal) obj);
        } else {
            jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                return null;
            }
            if (strSubstring.endsWith(".000000000")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
            } else if (strSubstring.endsWith(".000000")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
            }
            if (strSubstring.length() == 29 && strSubstring.charAt(4) == '-' && strSubstring.charAt(7) == '-' && strSubstring.charAt(10) == ' ' && strSubstring.charAt(13) == ':' && strSubstring.charAt(16) == ':' && strSubstring.charAt(19) == '.') {
                return new Timestamp(num(strSubstring.charAt(0), strSubstring.charAt(1), strSubstring.charAt(2), strSubstring.charAt(3)) - 1900, num(strSubstring.charAt(5), strSubstring.charAt(6)) - 1, num(strSubstring.charAt(8), strSubstring.charAt(9)), num(strSubstring.charAt(11), strSubstring.charAt(12)), num(strSubstring.charAt(14), strSubstring.charAt(15)), num(strSubstring.charAt(17), strSubstring.charAt(18)), num(strSubstring.charAt(20), strSubstring.charAt(21), strSubstring.charAt(22), strSubstring.charAt(23), strSubstring.charAt(24), strSubstring.charAt(25), strSubstring.charAt(26), strSubstring.charAt(27), strSubstring.charAt(28)));
            }
            if (isNumber(strSubstring)) {
                jLongValue = Long.parseLong(strSubstring);
            } else {
                JSONScanner jSONScanner = new JSONScanner(strSubstring);
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    throw new JSONException("can not cast to Timestamp, value : " + strSubstring);
                }
                jLongValue = jSONScanner.getCalendar().getTime().getTime();
            }
        }
        return new Timestamp(jLongValue);
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (!(genericComponentType instanceof Class)) {
            return genericArrayType;
        }
        Class cls = (Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            String str2 = (String) primitiveTypeMap.get(cls);
            if (str2 == null) {
                return genericArrayType;
            }
            return Class.forName(str + str2);
        } catch (ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String strLabel;
        int i;
        int i2;
        int i3;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) getAnnotation(field, JSONField.class);
                String name = field.getName();
                if (jSONField == null) {
                    strLabel = null;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else if (jSONField.serialize()) {
                    int iOrdinal = jSONField.ordinal();
                    int iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                    int iOf2 = Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    strLabel = jSONField.label().length() != 0 ? jSONField.label() : null;
                    i = iOrdinal;
                    i2 = iOf;
                    i3 = iOf2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new FieldInfo(str, null, field, cls, null, i, i2, i3, null, jSONField, strLabel));
                    }
                }
            }
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            computeFields(superclass, map, propertyNamingStrategy, linkedHashMap, superclass.getDeclaredFields());
        }
        return getFieldInfos(cls, z, linkedHashMap);
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            map.put(typeVariableArr[i], typeArr[i]);
        }
        return map;
    }

    public static Collection createCollection(Type type) {
        Class<?> cls;
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (rawClass.isAssignableFrom(Queue.class) || ((cls = class_deque) != null && rawClass.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) rawClass.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + rawClass.getName());
        }
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static long fnv1a_64(String str) {
        long jCharAt = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i))) * fnv1a_64_magic_prime;
        }
        return jCharAt;
    }

    public static long fnv1a_64_extract(String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
            }
        }
        return j;
    }

    public static long fnv1a_64_lower(String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
        }
        return j;
    }

    private static Type getActualType(Type type, Map<TypeVariable, Type> map) {
        if (type instanceof TypeVariable) {
            return map.get(type);
        }
        if (type instanceof ParameterizedType) {
            return makeParameterizedType(getRawClass(type), ((ParameterizedType) type).getActualTypeArguments(), map);
        }
        return type instanceof GenericArrayType ? new GenericArrayTypeImpl(getActualType(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        A a2 = (A) cls.getAnnotation(cls2);
        Type mixInAnnotations = JSON.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            A a3 = (A) cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (a3 == null && annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    a3 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a3 != null) {
                        break;
                    }
                }
            }
            if (a3 != null) {
                return a3;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (a2 == null && annotations2.length > 0) {
            for (Annotation annotation2 : annotations2) {
                a2 = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a2 != null) {
                    break;
                }
            }
        }
        return a2;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : getClass(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? getClass(upperBounds[0]) : Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new JSONException("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type getCollectionItemType(Type type) {
        if (type instanceof ParameterizedType) {
            return getCollectionItemType((ParameterizedType) type);
        }
        return type instanceof Class ? getCollectionItemType((Class<?>) type) : Object.class;
    }

    private static Type getCollectionSuperType(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> rawClass = getRawClass(type2);
            if (rawClass == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(rawClass)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
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
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    private static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String[] strArrOrders = jSONType != null ? jSONType.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            arrayList.addAll(map.values());
            if (z) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (FieldInfo fieldInfo : map.values()) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            for (String str : strArrOrders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    arrayList.add(fieldInfo2);
                    linkedHashMap.remove(str);
                }
            }
            arrayList.addAll(linkedHashMap.values());
        }
        return arrayList;
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_constructor = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_getConstructors = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = KFunction.class.getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = KParameter.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) kotlin_kparameter_getName.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr) {
        return getKotlinConstructor(constructorArr, null);
    }

    public static Annotation[][] getParameterAnnotations(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i) {
        if (!compatibleWithFieldName || map.containsKey(str2)) {
            return str2;
        }
        String strSubstring = str.substring(i);
        return map.containsKey(strSubstring) ? strSubstring : str2;
    }

    public static String getPropertyNameByMethodName(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new JSONException("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return getRawClass(upperBounds[0]);
        }
        throw new JSONException("TODO");
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
        boolean z2;
        JSONField jSONField2;
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            }
                            if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        if (z2 && (jSONField2 = (JSONField) getAnnotation(method2, JSONField.class)) != null) {
                            return jSONField2;
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
                    if (z && (jSONField = (JSONField) getAnnotation(method3, JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    private static Type getWildcardTypeUpperBounds(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Annotation getXmlAccessorType(Class cls) {
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = XmlAccessorType.class;
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null) {
            return null;
        }
        return getAnnotation((Class<?>) cls, class_XmlAccessorType);
    }

    public static int intValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static boolean isAnnotationPresentManyToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany != null) {
            return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
        }
        return false;
    }

    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        Class<? extends Annotation> cls = class_OneToMany;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isClob(Class cls) {
        if (class_Clob == null && !class_Clob_error) {
            try {
                class_Clob = Clob.class;
            } catch (Throwable unused) {
                class_Clob_error = true;
            }
        }
        if (class_Clob == null) {
            return false;
        }
        return class_Clob.isAssignableFrom(cls);
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

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] strArrIncludes = jSONType.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return isJSONTypeIgnore(cls.getSuperclass(), str);
    }

    public static boolean isJacksonCreator(Method method) {
        if (method == null) {
            return false;
        }
        if (class_JacksonCreator == null && !class_JacksonCreator_error) {
            try {
                class_JacksonCreator = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                class_JacksonCreator_error = true;
            }
        }
        Class<? extends Annotation> cls = class_JacksonCreator;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Metadata.class;
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        return kotlin_metadata != null && cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap map = new HashMap();
                map.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = map;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null) {
            return false;
        }
        String[] strArr = kotlinIgnores.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Path.class;
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (isProxyClassNames.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } finally {
                transientClassInited = true;
            }
        }
        Class<? extends Annotation> cls = transientClass;
        return (cls == null || getAnnotation(method, cls) == null) ? false : true;
    }

    public static boolean isXmlField(Class cls) {
        Annotation annotation;
        Object objInvoke;
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = XmlAccessorType.class;
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null || (annotation = getAnnotation((Class<?>) cls, (Class<Annotation>) class_XmlAccessorType)) == null) {
            return false;
        }
        if (method_XmlAccessorType_value == null && !classXmlAccessorType_error) {
            try {
                method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", new Class[0]);
            } catch (Throwable unused2) {
                classXmlAccessorType_error = true;
            }
        }
        if (method_XmlAccessorType_value == null) {
            return false;
        }
        if (classXmlAccessorType_error) {
            objInvoke = null;
        } else {
            try {
                objInvoke = method_XmlAccessorType_value.invoke(annotation, new Object[0]);
            } catch (Throwable unused3) {
                classXmlAccessorType_error = true;
                objInvoke = null;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (class_XmlAccessType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessType = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");
                field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);
            } catch (Throwable unused4) {
                classXmlAccessorType_error = true;
            }
        }
        return objInvoke == field_XmlAccessType_FIELD_VALUE;
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, null);
    }

    public static long longExtractValue(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static long longValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    private static ParameterizedType makeParameterizedType(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i = 0; i < length; i++) {
            typeArr2[i] = getActualType(typeArr[i], map);
        }
        return new ParameterizedTypeImpl(typeArr2, null, cls);
    }

    public static int num(char c, char c2) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9') {
            return -1;
        }
        return ((c - '0') * 10) + (c2 - '0');
    }

    public static int num(char c, char c2, char c3, char c4) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return -1;
        }
        return ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0');
    }

    public static int num(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9' || c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return ((c - '0') * 100000000) + ((c2 - '0') * 10000000) + ((c3 - '0') * 1000000) + ((c4 - '0') * 100000) + ((c5 - '0') * 10000) + ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0');
    }

    public static Object optionalEmpty(Type type) {
        Class<?> cls;
        if (OPTIONAL_ERROR || (cls = getClass(type)) == null) {
            return null;
        }
        String name = cls.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (OPTIONAL_EMPTY == null) {
            try {
                OPTIONAL_EMPTY = Class.forName(name).getMethod("empty", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                OPTIONAL_ERROR = true;
            }
        }
        return OPTIONAL_EMPTY;
    }

    public static double parseDouble(String str) {
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

    public static float parseFloat(String str) {
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

    public static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static short shortValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static Locale toLocale(String str) {
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        return strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } finally {
                optionalClassInited = true;
            }
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        PropertyNamingStrategy propertyNamingStrategy2;
        int i;
        String[] strArr;
        String str;
        String str2;
        List<FieldInfo> listComputeGettersWithFieldBase;
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] strArrOrders = jSONType.orders();
            String strTypeName = jSONType.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            PropertyNamingStrategy propertyNamingStrategyNaming = jSONType.naming();
            if (propertyNamingStrategyNaming == PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) {
                propertyNamingStrategyNaming = propertyNamingStrategy;
            }
            int iOf = SerializerFeature.of(jSONType.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                JSONType jSONType2 = (JSONType) getAnnotation(superclass, JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                strTypeKey = jSONType2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                JSONType jSONType3 = (JSONType) getAnnotation(cls2, JSONType.class);
                if (jSONType3 != null) {
                    strTypeKey = jSONType3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            str = strTypeName;
            propertyNamingStrategy2 = propertyNamingStrategyNaming;
            i = iOf;
            strArr = strArrOrders;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            i = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap map2 = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, map2);
        List<FieldInfo> listComputeGettersWithFieldBase2 = z ? computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy2) : computeGetters(cls, jSONType, map, map2, false, propertyNamingStrategy2);
        FieldInfo[] fieldInfoArr = new FieldInfo[listComputeGettersWithFieldBase2.size()];
        listComputeGettersWithFieldBase2.toArray(fieldInfoArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(listComputeGettersWithFieldBase2);
            Collections.sort(arrayList);
            listComputeGettersWithFieldBase = arrayList;
        } else {
            listComputeGettersWithFieldBase = z ? computeGettersWithFieldBase(cls, map, true, propertyNamingStrategy2) : computeGetters(cls, jSONType, map, map2, true, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[listComputeGettersWithFieldBase.size()];
        listComputeGettersWithFieldBase.toArray(fieldInfoArr2);
        return new SerializeBeanInfo(cls, jSONType, str, str2, i, fieldInfoArr, Arrays.equals(fieldInfoArr2, fieldInfoArr) ? fieldInfoArr : fieldInfoArr2);
    }

    public static Date castToDate(Object obj, String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new Date(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new Date(jLongValue);
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(strSubstring);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    Date time = jSONScanner.getCalendar().getTime();
                    jSONScanner.close();
                    return time;
                }
                jSONScanner.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) > 0 || strSubstring.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strSubstring.length();
                        if (length == JSON.DEFFAULT_DATE_FORMAT.length() || (length == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = JSON.DEFFAULT_DATE_FORMAT;
                        } else if (length == 10) {
                            str = "yyyy-MM-dd";
                        } else if (length == 19) {
                            str = "yyyy-MM-dd HH:mm:ss";
                        } else if (length == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                        } else {
                            str = (length == 23 && strSubstring.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : c25.o;
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j = Long.parseLong(strSubstring);
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            j = -1;
        }
        if (j != -1) {
            return new Date(j);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } finally {
                    oracleTimestampMethodInited = true;
                }
            }
            try {
                return (Date) oracleTimestampMethod.invoke(obj, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        if (oracleDateMethod == null && !oracleDateMethodInited) {
            try {
                oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
            } catch (NoSuchMethodException unused3) {
            } finally {
                oracleDateMethodInited = true;
            }
        }
        try {
            return (Date) oracleDateMethod.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            throw new JSONException("can not cast oracle.sql.DATE to Date", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
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
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> clsCheckAutoType = parserConfig.checkAutoType(str4, null);
                if (clsCheckAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsCheckAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, clsCheckAutoType, parserConfig);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get(MediaFormat.KEY_LANGUAGE);
                Object obj3 = map.get(ze1.s);
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (cls == JSON.class && (map instanceof JSONObject)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T t = (T) ((JSONObject) map).getInnerMap();
                if (t instanceof LinkedHashMap) {
                    return t;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == JSONObject.class) {
                return (T) new JSONObject(map);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        HashMap map2 = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, map2);
        return computeGetters(cls, jSONType, map, map2, z, PropertyNamingStrategy.CamelCase);
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() <= 198) {
            Class<?> clsLoadClass = mappings.get(str);
            if (clsLoadClass != null) {
                return clsLoadClass;
            }
            if (str.charAt(0) == '[') {
                return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
            }
            if (str.startsWith("L") && str.endsWith(l.b)) {
                return loadClass(str.substring(1, str.length() - 1), classLoader);
            }
            if (classLoader != null) {
                try {
                    clsLoadClass = classLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, clsLoadClass);
                    }
                    return clsLoadClass;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                Class<?> clsLoadClass2 = contextClassLoader.loadClass(str);
                if (z) {
                    try {
                        mappings.put(str, clsLoadClass2);
                    } catch (Throwable unused) {
                        clsLoadClass = clsLoadClass2;
                    }
                }
                return clsLoadClass2;
            }
            try {
                clsLoadClass = Class.forName(str);
                if (z) {
                    mappings.put(str, clsLoadClass);
                }
            } catch (Throwable unused2) {
            }
            return clsLoadClass;
        }
        throw new JSONException("illegal className : " + str);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0232 A[PHI: r15 r32 r33
      0x0232: PHI (r15v13 java.util.LinkedHashMap) = 
      (r15v3 java.util.LinkedHashMap)
      (r15v3 java.util.LinkedHashMap)
      (r15v3 java.util.LinkedHashMap)
      (r15v3 java.util.LinkedHashMap)
      (r15v3 java.util.LinkedHashMap)
      (r15v3 java.util.LinkedHashMap)
      (r15v16 java.util.LinkedHashMap)
     binds: [B:107:0x0230, B:111:0x023f, B:148:0x02c7, B:166:0x0304, B:138:0x02a7, B:116:0x024e, B:99:0x01cc] A[DONT_GENERATE, DONT_INLINE]
      0x0232: PHI (r32v3 int) = (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v1 int), (r32v6 int) binds: [B:107:0x0230, B:111:0x023f, B:148:0x02c7, B:166:0x0304, B:138:0x02a7, B:116:0x024e, B:99:0x01cc] A[DONT_GENERATE, DONT_INLINE]
      0x0232: PHI (r33v3 java.lang.reflect.Method[]) = 
      (r33v1 java.lang.reflect.Method[])
      (r33v1 java.lang.reflect.Method[])
      (r33v1 java.lang.reflect.Method[])
      (r33v1 java.lang.reflect.Method[])
      (r33v1 java.lang.reflect.Method[])
      (r33v1 java.lang.reflect.Method[])
      (r33v6 java.lang.reflect.Method[])
     binds: [B:107:0x0230, B:111:0x023f, B:148:0x02c7, B:166:0x0304, B:138:0x02a7, B:116:0x024e, B:99:0x01cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:150:0x02cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:160:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:163:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:165:0x0300  */
    /* JADX WARN: Code duplicated, block: B:168:0x0308  */
    /* JADX WARN: Code duplicated, block: B:170:0x0326  */
    /* JADX WARN: Code duplicated, block: B:172:0x0330  */
    /* JADX WARN: Code duplicated, block: B:175:0x0339  */
    /* JADX WARN: Code duplicated, block: B:178:0x0348  */
    /* JADX WARN: Code duplicated, block: B:180:0x0357  */
    /* JADX WARN: Code duplicated, block: B:182:0x0363  */
    /* JADX WARN: Code duplicated, block: B:184:0x0371  */
    /* JADX WARN: Code duplicated, block: B:189:0x0382  */
    /* JADX WARN: Code duplicated, block: B:230:0x0463 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:231:0x0465  */
    /* JADX WARN: Code duplicated, block: B:233:0x046b  */
    /* JADX WARN: Code duplicated, block: B:234:0x0471  */
    /* JADX WARN: Code duplicated, block: B:236:0x0474  */
    /* JADX WARN: Code duplicated, block: B:238:0x047e  */
    /* JADX WARN: Code duplicated, block: B:241:0x0485  */
    /* JADX WARN: Code duplicated, block: B:243:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:248:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:251:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:252:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:253:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:254:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:261:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:265:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:266:0x051c  */
    /* JADX WARN: Code duplicated, block: B:267:0x051e A[PHI: r12
      0x051e: PHI (r12v5 java.lang.Class<?>) = (r12v4 java.lang.Class<?>), (r12v8 java.lang.Class<?>), (r12v8 java.lang.Class<?>) binds: [B:266:0x051c, B:228:0x045f, B:239:0x0482] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:6:0x003a  */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0336, code lost:
    
        if (r11 == null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0378, code lost:
    
        if (r2 == null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x037a, code lost:
    
        r14 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<FieldInfo> computeGetters(Class<?> cls, JSONType jSONType, Map<String, String> map, Map<String, Field> map2, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        String[] strArr;
        int i;
        Constructor<?>[] constructorArr;
        Annotation[][] annotationArr;
        JSONField jSONField;
        short[] sArr;
        int i2;
        Method[] methodArr;
        LinkedHashMap linkedHashMap;
        int iOrdinal;
        int iOf;
        int iOf2;
        LinkedHashMap linkedHashMap2;
        int i3;
        Map<String, String> map3;
        LinkedHashMap linkedHashMap3;
        Map<String, Field> map4;
        String strSubstring;
        Field fieldFromCache;
        Field fieldFromCache2;
        int i4;
        int i5;
        JSONField jSONField2;
        int i6;
        String str;
        JSONField jSONField3;
        int iOrdinal2;
        int iOf3;
        int iOf4;
        String propertyNameByMethodName;
        String propertyNameByCompatibleFieldName;
        Field fieldFromCache3;
        int i7;
        Field field;
        Map<String, String> map5;
        String str2;
        Boolean bool;
        int i8;
        int i9;
        JSONField jSONField4;
        JSONField jSONField5;
        String strName;
        Boolean bool2;
        char cCharAt;
        Field fieldFromCache4;
        String[] koltinConstructorParameters;
        short[] sArr2;
        Field fieldFromCache5;
        Constructor kotlinConstructor;
        Class<?> cls2 = cls;
        Map<String, String> map6 = map;
        PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        boolean zIsKotlin = isKotlin(cls);
        Method[] methods = cls.getMethods();
        Arrays.sort(methods, new MethodInheritanceComparator());
        int length = methods.length;
        Constructor<?>[] declaredConstructors = null;
        String[] strArr2 = null;
        short[] sArr3 = null;
        Annotation[][] parameterAnnotations = null;
        int i10 = 0;
        while (i10 < length) {
            Method method = methods[i10];
            String name = method.getName();
            String strLabel = null;
            if (Modifier.isStatic(method.getModifiers())) {
                strArr = strArr2;
                i = i10;
                i2 = length;
                methodArr = methods;
                linkedHashMap3 = linkedHashMap4;
                map3 = map6;
            } else {
                Class<?> returnType = method.getReturnType();
                if (returnType.equals(Void.TYPE) || method.getParameterTypes().length != 0 || returnType == ClassLoader.class || returnType == InputStream.class || returnType == Reader.class) {
                    strArr = strArr2;
                } else {
                    if (name.equals("getMetaClass")) {
                        strArr = strArr2;
                        if (returnType.getName().equals("groovy.lang.MetaClass")) {
                        }
                    } else {
                        strArr = strArr2;
                    }
                    if ((!name.equals("getSuppressed") || method.getDeclaringClass() != Throwable.class) && (!zIsKotlin || !isKotlinIgnore(cls2, name))) {
                        Boolean bool3 = Boolean.FALSE;
                        JSONField superMethodAnnotation = (JSONField) getAnnotation(method, JSONField.class);
                        if (superMethodAnnotation == null) {
                            superMethodAnnotation = getSuperMethodAnnotation(cls2, method);
                        }
                        LinkedHashMap linkedHashMap5 = linkedHashMap4;
                        if (superMethodAnnotation == null && zIsKotlin) {
                            if (declaredConstructors != null || (kotlinConstructor = getKotlinConstructor((declaredConstructors = cls.getDeclaredConstructors()))) == null) {
                                koltinConstructorParameters = strArr;
                            } else {
                                parameterAnnotations = getParameterAnnotations(kotlinConstructor);
                                koltinConstructorParameters = getKoltinConstructorParameters(cls);
                                if (koltinConstructorParameters != null) {
                                    String[] strArr3 = new String[koltinConstructorParameters.length];
                                    System.arraycopy(koltinConstructorParameters, 0, strArr3, 0, koltinConstructorParameters.length);
                                    Arrays.sort(strArr3);
                                    short[] sArr4 = new short[koltinConstructorParameters.length];
                                    for (short s = 0; s < koltinConstructorParameters.length; s = (short) (s + 1)) {
                                        sArr4[Arrays.binarySearch(strArr3, koltinConstructorParameters[s])] = s;
                                    }
                                    koltinConstructorParameters = strArr3;
                                    parameterAnnotations = parameterAnnotations;
                                    sArr3 = sArr4;
                                    declaredConstructors = declaredConstructors;
                                }
                            }
                            if (koltinConstructorParameters == null || sArr3 == null || !name.startsWith(p3.f)) {
                                constructorArr = declaredConstructors;
                                sArr2 = sArr3;
                                annotationArr = parameterAnnotations;
                                i = i10;
                            } else {
                                String strDecapitalize = decapitalize(name.substring(3));
                                int iBinarySearch = Arrays.binarySearch(koltinConstructorParameters, strDecapitalize);
                                constructorArr = declaredConstructors;
                                i = i10;
                                if (iBinarySearch < 0) {
                                    for (int i11 = 0; i11 < koltinConstructorParameters.length; i11++) {
                                        if (strDecapitalize.equalsIgnoreCase(koltinConstructorParameters[i11])) {
                                            iBinarySearch = i11;
                                            break;
                                        }
                                    }
                                }
                                if (iBinarySearch >= 0) {
                                    Annotation[] annotationArr2 = parameterAnnotations[sArr3[iBinarySearch]];
                                    if (annotationArr2 != null) {
                                        int length2 = annotationArr2.length;
                                        sArr2 = sArr3;
                                        int i12 = 0;
                                        while (true) {
                                            annotationArr = parameterAnnotations;
                                            if (i12 >= length2) {
                                                break;
                                            }
                                            Annotation annotation = annotationArr2[i12];
                                            Annotation[] annotationArr3 = annotationArr2;
                                            if (annotation instanceof JSONField) {
                                                superMethodAnnotation = (JSONField) annotation;
                                                break;
                                            }
                                            i12++;
                                            parameterAnnotations = annotationArr;
                                            annotationArr2 = annotationArr3;
                                        }
                                    } else {
                                        sArr2 = sArr3;
                                        annotationArr = parameterAnnotations;
                                    }
                                    if (superMethodAnnotation == null && (fieldFromCache5 = ParserConfig.getFieldFromCache(strDecapitalize, map2)) != null) {
                                        jSONField = (JSONField) getAnnotation(fieldFromCache5, JSONField.class);
                                    }
                                    sArr = sArr2;
                                    strArr = koltinConstructorParameters;
                                } else {
                                    sArr2 = sArr3;
                                    annotationArr = parameterAnnotations;
                                }
                            }
                            jSONField = superMethodAnnotation;
                            sArr = sArr2;
                            strArr = koltinConstructorParameters;
                        } else {
                            returnType = returnType;
                            i = i10;
                            constructorArr = declaredConstructors;
                            annotationArr = parameterAnnotations;
                            jSONField = superMethodAnnotation;
                            sArr = sArr3;
                        }
                        if (jSONField != null) {
                            if (jSONField.serialize()) {
                                iOrdinal = jSONField.ordinal();
                                iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                                iOf2 = Feature.of(jSONField.parseFeatures());
                                if (jSONField.name().length() != 0) {
                                    String strName2 = jSONField.name();
                                    if (map6 == null || (strName2 = map6.get(strName2)) != null) {
                                        String str3 = strName2;
                                        i2 = length;
                                        methodArr = methods;
                                        linkedHashMap = linkedHashMap5;
                                        linkedHashMap.put(str3, new FieldInfo(str3, method, null, cls, null, iOrdinal, iOf, iOf2, jSONField, null, null));
                                    }
                                    sArr3 = sArr;
                                    declaredConstructors = constructorArr;
                                    parameterAnnotations = annotationArr;
                                } else {
                                    i2 = length;
                                    methodArr = methods;
                                    linkedHashMap = linkedHashMap5;
                                    if (jSONField.label().length() != 0) {
                                        strLabel = jSONField.label();
                                    }
                                }
                                map3 = map;
                                linkedHashMap3 = linkedHashMap;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                sArr3 = sArr;
                                declaredConstructors = constructorArr;
                                parameterAnnotations = annotationArr;
                            }
                            i2 = length;
                            methodArr = methods;
                            map3 = map6;
                            linkedHashMap3 = linkedHashMap5;
                            sArr3 = sArr;
                            declaredConstructors = constructorArr;
                            parameterAnnotations = annotationArr;
                        } else {
                            i2 = length;
                            methodArr = methods;
                            linkedHashMap = linkedHashMap5;
                            iOrdinal = 0;
                            iOf = 0;
                            iOf2 = 0;
                        }
                        if (name.startsWith(p3.f)) {
                            if (name.length() < 4 || name.equals("getClass") || (name.equals("getDeclaringClass") && cls.isEnum())) {
                                map3 = map;
                            } else {
                                char cCharAt2 = name.charAt(3);
                                if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                                    if (compatibleWithJavaBean) {
                                        propertyNameByMethodName = decapitalize(name.substring(3));
                                    } else {
                                        propertyNameByMethodName = getPropertyNameByMethodName(name);
                                    }
                                    propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map2, name, propertyNameByMethodName, 3);
                                } else {
                                    if (cCharAt2 == '_') {
                                        propertyNameByCompatibleFieldName = name.substring(3);
                                        fieldFromCache3 = map2.get(propertyNameByCompatibleFieldName);
                                        if (fieldFromCache3 == null) {
                                            String strSubstring2 = name.substring(4);
                                            fieldFromCache4 = ParserConfig.getFieldFromCache(strSubstring2, map2);
                                            if (fieldFromCache4 != null) {
                                                propertyNameByCompatibleFieldName = strSubstring2;
                                            }
                                        } else if (isJSONTypeIgnore(cls2, propertyNameByCompatibleFieldName)) {
                                            map3 = map;
                                        } else {
                                            if (fieldFromCache3 == null) {
                                                fieldFromCache3 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map2);
                                            }
                                            if (fieldFromCache3 == null || propertyNameByCompatibleFieldName.length() <= 1 || (cCharAt = propertyNameByCompatibleFieldName.charAt(1)) < 'A' || cCharAt > 'Z') {
                                                i7 = 3;
                                            } else {
                                                i7 = 3;
                                                fieldFromCache3 = ParserConfig.getFieldFromCache(decapitalize(name.substring(3)), map2);
                                            }
                                            field = fieldFromCache3;
                                            if (field != null) {
                                                jSONField5 = (JSONField) getAnnotation(field, JSONField.class);
                                                if (jSONField5 == null) {
                                                    map5 = map;
                                                    str2 = strLabel;
                                                    bool = bool3;
                                                    i8 = iOrdinal;
                                                    i9 = iOf;
                                                } else if (jSONField5.serialize()) {
                                                    int iOrdinal3 = jSONField5.ordinal();
                                                    int iOf5 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                    int iOf6 = Feature.of(jSONField5.parseFeatures());
                                                    if (jSONField5.name().length() != 0) {
                                                        bool2 = Boolean.TRUE;
                                                        strName = jSONField5.name();
                                                        map5 = map;
                                                        if (map5 != null) {
                                                            strName = map5.get(strName);
                                                        }
                                                    } else {
                                                        map5 = map;
                                                        strName = propertyNameByCompatibleFieldName;
                                                        bool2 = bool3;
                                                    }
                                                    if (jSONField5.label().length() != 0) {
                                                        strLabel = jSONField5.label();
                                                    }
                                                    i9 = iOf5;
                                                    iOf2 = iOf6;
                                                    str2 = strLabel;
                                                    i8 = iOrdinal3;
                                                    bool = bool2;
                                                    propertyNameByCompatibleFieldName = strName;
                                                } else {
                                                    map3 = map;
                                                }
                                                jSONField4 = jSONField5;
                                            } else {
                                                map5 = map;
                                                str2 = strLabel;
                                                i8 = iOrdinal;
                                                i9 = iOf;
                                                jSONField4 = null;
                                            }
                                            if (map5 != null) {
                                                bool = bool3;
                                                propertyNameByCompatibleFieldName = map5.get(propertyNameByCompatibleFieldName);
                                            }
                                            bool = bool3;
                                            LinkedHashMap linkedHashMap6 = linkedHashMap;
                                            if (propertyNamingStrategy != null && !bool.booleanValue()) {
                                                propertyNameByCompatibleFieldName = propertyNamingStrategy.translate(propertyNameByCompatibleFieldName);
                                            }
                                            String str4 = propertyNameByCompatibleFieldName;
                                            i3 = i7;
                                            linkedHashMap2 = linkedHashMap6;
                                            linkedHashMap2.put(str4, new FieldInfo(str4, method, field, cls, null, i8, i9, iOf2, jSONField, jSONField4, str2));
                                            iOrdinal = i8;
                                            iOf = i9;
                                            strLabel = str2;
                                        }
                                    } else if (cCharAt2 == 'f') {
                                        propertyNameByCompatibleFieldName = name.substring(3);
                                    } else {
                                        if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                            propertyNameByCompatibleFieldName = decapitalize(name.substring(3));
                                        } else {
                                            propertyNameByCompatibleFieldName = name.substring(3);
                                            fieldFromCache4 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map2);
                                            if (fieldFromCache4 == null) {
                                            }
                                        }
                                        map3 = map;
                                    }
                                    fieldFromCache3 = fieldFromCache4;
                                    if (isJSONTypeIgnore(cls2, propertyNameByCompatibleFieldName)) {
                                        if (fieldFromCache3 == null) {
                                            fieldFromCache3 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map2);
                                        }
                                        if (fieldFromCache3 == null) {
                                            i7 = 3;
                                        } else {
                                            i7 = 3;
                                        }
                                        field = fieldFromCache3;
                                        if (field != null) {
                                            jSONField5 = (JSONField) getAnnotation(field, JSONField.class);
                                            if (jSONField5 == null) {
                                                map5 = map;
                                                str2 = strLabel;
                                                bool = bool3;
                                                i8 = iOrdinal;
                                                i9 = iOf;
                                            } else if (jSONField5.serialize()) {
                                                map3 = map;
                                            } else {
                                                int iOrdinal4 = jSONField5.ordinal();
                                                int iOf7 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                int iOf8 = Feature.of(jSONField5.parseFeatures());
                                                if (jSONField5.name().length() != 0) {
                                                    bool2 = Boolean.TRUE;
                                                    strName = jSONField5.name();
                                                    map5 = map;
                                                    if (map5 != null) {
                                                        strName = map5.get(strName);
                                                    }
                                                } else {
                                                    map5 = map;
                                                    strName = propertyNameByCompatibleFieldName;
                                                    bool2 = bool3;
                                                }
                                                if (jSONField5.label().length() != 0) {
                                                    strLabel = jSONField5.label();
                                                }
                                                i9 = iOf7;
                                                iOf2 = iOf8;
                                                str2 = strLabel;
                                                i8 = iOrdinal4;
                                                bool = bool2;
                                                propertyNameByCompatibleFieldName = strName;
                                            }
                                            jSONField4 = jSONField5;
                                        } else {
                                            map5 = map;
                                            str2 = strLabel;
                                            i8 = iOrdinal;
                                            i9 = iOf;
                                            jSONField4 = null;
                                        }
                                        if (map5 != null) {
                                            bool = bool3;
                                            propertyNameByCompatibleFieldName = map5.get(propertyNameByCompatibleFieldName);
                                        }
                                        bool = bool3;
                                        LinkedHashMap linkedHashMap7 = linkedHashMap;
                                        if (propertyNamingStrategy != null) {
                                            propertyNameByCompatibleFieldName = propertyNamingStrategy.translate(propertyNameByCompatibleFieldName);
                                        }
                                        String str5 = propertyNameByCompatibleFieldName;
                                        i3 = i7;
                                        linkedHashMap2 = linkedHashMap7;
                                        linkedHashMap2.put(str5, new FieldInfo(str5, method, field, cls, null, i8, i9, iOf2, jSONField, jSONField4, str2));
                                        iOrdinal = i8;
                                        iOf = i9;
                                        strLabel = str2;
                                    } else {
                                        map3 = map;
                                    }
                                }
                                fieldFromCache3 = null;
                                if (isJSONTypeIgnore(cls2, propertyNameByCompatibleFieldName)) {
                                    if (fieldFromCache3 == null) {
                                        fieldFromCache3 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map2);
                                    }
                                    if (fieldFromCache3 == null) {
                                        i7 = 3;
                                    } else {
                                        i7 = 3;
                                    }
                                    field = fieldFromCache3;
                                    if (field != null) {
                                        jSONField5 = (JSONField) getAnnotation(field, JSONField.class);
                                        if (jSONField5 == null) {
                                            map5 = map;
                                            str2 = strLabel;
                                            bool = bool3;
                                            i8 = iOrdinal;
                                            i9 = iOf;
                                        } else if (jSONField5.serialize()) {
                                            map3 = map;
                                        } else {
                                            int iOrdinal5 = jSONField5.ordinal();
                                            int iOf9 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                            int iOf10 = Feature.of(jSONField5.parseFeatures());
                                            if (jSONField5.name().length() != 0) {
                                                bool2 = Boolean.TRUE;
                                                strName = jSONField5.name();
                                                map5 = map;
                                                if (map5 != null) {
                                                    strName = map5.get(strName);
                                                }
                                            } else {
                                                map5 = map;
                                                strName = propertyNameByCompatibleFieldName;
                                                bool2 = bool3;
                                            }
                                            if (jSONField5.label().length() != 0) {
                                                strLabel = jSONField5.label();
                                            }
                                            i9 = iOf9;
                                            iOf2 = iOf10;
                                            str2 = strLabel;
                                            i8 = iOrdinal5;
                                            bool = bool2;
                                            propertyNameByCompatibleFieldName = strName;
                                        }
                                        jSONField4 = jSONField5;
                                    } else {
                                        map5 = map;
                                        str2 = strLabel;
                                        i8 = iOrdinal;
                                        i9 = iOf;
                                        jSONField4 = null;
                                    }
                                    if (map5 != null) {
                                        bool = bool3;
                                        propertyNameByCompatibleFieldName = map5.get(propertyNameByCompatibleFieldName);
                                    }
                                    bool = bool3;
                                    LinkedHashMap linkedHashMap8 = linkedHashMap;
                                    if (propertyNamingStrategy != null) {
                                        propertyNameByCompatibleFieldName = propertyNamingStrategy.translate(propertyNameByCompatibleFieldName);
                                    }
                                    String str6 = propertyNameByCompatibleFieldName;
                                    i3 = i7;
                                    linkedHashMap2 = linkedHashMap8;
                                    linkedHashMap2.put(str6, new FieldInfo(str6, method, field, cls, null, i8, i9, iOf2, jSONField, jSONField4, str2));
                                    iOrdinal = i8;
                                    iOf = i9;
                                    strLabel = str2;
                                } else {
                                    map3 = map;
                                }
                            }
                            linkedHashMap3 = linkedHashMap;
                            propertyNamingStrategy2 = propertyNamingStrategy;
                            sArr3 = sArr;
                            declaredConstructors = constructorArr;
                            parameterAnnotations = annotationArr;
                        } else {
                            linkedHashMap2 = linkedHashMap;
                            i3 = 3;
                        }
                        if (name.startsWith(p3.g) && name.length() >= i3 && (returnType == Boolean.TYPE || returnType == Boolean.class)) {
                            char cCharAt3 = name.charAt(2);
                            if (Character.isUpperCase(cCharAt3)) {
                                map4 = map2;
                                strSubstring = getPropertyNameByCompatibleFieldName(map4, name, compatibleWithJavaBean ? decapitalize(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(i3), 2);
                            } else {
                                map4 = map2;
                                int i13 = i3;
                                if (cCharAt3 == '_') {
                                    String strSubstring3 = name.substring(i13);
                                    fieldFromCache = map4.get(strSubstring3);
                                    if (fieldFromCache != null || (fieldFromCache = ParserConfig.getFieldFromCache((strSubstring = name.substring(2)), map4)) == null) {
                                        strSubstring = strSubstring3;
                                    }
                                } else if (cCharAt3 == 'f') {
                                    strSubstring = name.substring(2);
                                } else {
                                    strSubstring = name.substring(2);
                                    fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map4);
                                    if (fieldFromCache == null) {
                                        cls2 = cls;
                                    }
                                    map3 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                }
                                cls2 = cls;
                                if (isJSONTypeIgnore(cls2, strSubstring)) {
                                    map3 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                } else {
                                    if (fieldFromCache == null) {
                                        fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map4);
                                    }
                                    if (fieldFromCache == null) {
                                        fieldFromCache2 = ParserConfig.getFieldFromCache(name, map4);
                                    } else {
                                        fieldFromCache2 = fieldFromCache;
                                    }
                                    if (fieldFromCache2 != null) {
                                        jSONField3 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                        if (jSONField3 != null) {
                                            if (jSONField3.serialize()) {
                                                iOrdinal2 = jSONField3.ordinal();
                                                iOf3 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                                iOf4 = Feature.of(jSONField3.parseFeatures());
                                                if (jSONField3.name().length() != 0) {
                                                    strSubstring = jSONField3.name();
                                                    map3 = map;
                                                    if (map3 != null || (strSubstring = map3.get(strSubstring)) != null) {
                                                    }
                                                    linkedHashMap3 = linkedHashMap2;
                                                } else {
                                                    map3 = map;
                                                }
                                                if (jSONField3.label().length() != 0) {
                                                    jSONField2 = jSONField3;
                                                    i5 = iOf3;
                                                    i6 = iOf4;
                                                    strLabel = jSONField3.label();
                                                    i4 = iOrdinal2;
                                                } else {
                                                    jSONField2 = jSONField3;
                                                    i4 = iOrdinal2;
                                                    i5 = iOf3;
                                                    i6 = iOf4;
                                                }
                                            } else {
                                                map3 = map;
                                            }
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            linkedHashMap3 = linkedHashMap2;
                                        } else {
                                            map3 = map;
                                            i4 = iOrdinal;
                                            i5 = iOf;
                                            i6 = iOf2;
                                            jSONField2 = jSONField3;
                                        }
                                    } else {
                                        map3 = map;
                                        i4 = iOrdinal;
                                        i5 = iOf;
                                        jSONField2 = null;
                                        i6 = iOf2;
                                    }
                                    if (map3 == null && (strSubstring = map3.get(strSubstring)) == null) {
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                    } else {
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        if (propertyNamingStrategy2 != null) {
                                            strSubstring = propertyNamingStrategy2.translate(strSubstring);
                                        }
                                        str = strSubstring;
                                        if (linkedHashMap2.containsKey(str)) {
                                            linkedHashMap3 = linkedHashMap2;
                                            linkedHashMap3.put(str, new FieldInfo(str, method, fieldFromCache2, cls, null, i4, i5, i6, jSONField, jSONField2, strLabel));
                                        }
                                    }
                                    linkedHashMap3 = linkedHashMap2;
                                }
                            }
                            fieldFromCache = null;
                            cls2 = cls;
                            if (isJSONTypeIgnore(cls2, strSubstring)) {
                                if (fieldFromCache == null) {
                                    fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map4);
                                }
                                if (fieldFromCache == null) {
                                    fieldFromCache2 = ParserConfig.getFieldFromCache(name, map4);
                                } else {
                                    fieldFromCache2 = fieldFromCache;
                                }
                                if (fieldFromCache2 != null) {
                                    jSONField3 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                    if (jSONField3 != null) {
                                        if (jSONField3.serialize()) {
                                            map3 = map;
                                        } else {
                                            iOrdinal2 = jSONField3.ordinal();
                                            iOf3 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                            iOf4 = Feature.of(jSONField3.parseFeatures());
                                            if (jSONField3.name().length() != 0) {
                                                strSubstring = jSONField3.name();
                                                map3 = map;
                                                if (map3 != null) {
                                                }
                                            } else {
                                                map3 = map;
                                            }
                                            if (jSONField3.label().length() != 0) {
                                                jSONField2 = jSONField3;
                                                i5 = iOf3;
                                                i6 = iOf4;
                                                strLabel = jSONField3.label();
                                                i4 = iOrdinal2;
                                            } else {
                                                jSONField2 = jSONField3;
                                                i4 = iOrdinal2;
                                                i5 = iOf3;
                                                i6 = iOf4;
                                            }
                                        }
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        linkedHashMap3 = linkedHashMap2;
                                    } else {
                                        map3 = map;
                                        i4 = iOrdinal;
                                        i5 = iOf;
                                        i6 = iOf2;
                                        jSONField2 = jSONField3;
                                    }
                                } else {
                                    map3 = map;
                                    i4 = iOrdinal;
                                    i5 = iOf;
                                    jSONField2 = null;
                                    i6 = iOf2;
                                }
                                if (map3 == null) {
                                }
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                if (propertyNamingStrategy2 != null) {
                                    strSubstring = propertyNamingStrategy2.translate(strSubstring);
                                }
                                str = strSubstring;
                                if (linkedHashMap2.containsKey(str)) {
                                    linkedHashMap3 = linkedHashMap2;
                                    linkedHashMap3.put(str, new FieldInfo(str, method, fieldFromCache2, cls, null, i4, i5, i6, jSONField, jSONField2, strLabel));
                                } else {
                                    linkedHashMap3 = linkedHashMap2;
                                }
                            } else {
                                map3 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                linkedHashMap3 = linkedHashMap2;
                            }
                        } else {
                            cls2 = cls;
                            map3 = map;
                            propertyNamingStrategy2 = propertyNamingStrategy;
                            linkedHashMap3 = linkedHashMap2;
                        }
                        sArr3 = sArr;
                        declaredConstructors = constructorArr;
                        parameterAnnotations = annotationArr;
                    }
                }
                i = i10;
                i2 = length;
                methodArr = methods;
                linkedHashMap3 = linkedHashMap4;
                map3 = map6;
            }
            i10 = i + 1;
            linkedHashMap4 = linkedHashMap3;
            map6 = map3;
            strArr2 = strArr;
            length = i2;
            methods = methodArr;
        }
        LinkedHashMap linkedHashMap9 = linkedHashMap4;
        computeFields(cls2, map6, propertyNamingStrategy2, linkedHashMap9, cls.getFields());
        return getFieldInfos(cls2, z, linkedHashMap9);
    }

    private static Type getCollectionItemType(Class<?> cls) {
        return cls.getName().startsWith("java.") ? Object.class : getCollectionItemType(getCollectionSuperType(cls));
    }

    private static Type getCollectionItemType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> mapCreateActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
        Type collectionSuperType = getCollectionSuperType(cls);
        if (collectionSuperType instanceof ParameterizedType) {
            Class<?> rawClass = getRawClass(collectionSuperType);
            Type[] actualTypeArguments2 = ((ParameterizedType) collectionSuperType).getActualTypeArguments();
            if (actualTypeArguments2.length > 0) {
                return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, mapCreateActualTypeMap));
            }
            return getCollectionItemType(rawClass);
        }
        return getCollectionItemType((Class<?>) collectionSuperType);
    }

    public static Annotation[][] getParameterAnnotations(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            for (Class superclass = cls; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i = size; i > 0; i--) {
                            int i2 = i - 1;
                            clsArr[i2] = (Class) arrayList.get(i2);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                    break;
                } catch (NoSuchMethodException unused) {
                    size--;
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> cls) {
        A a2;
        A a3 = (A) field.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(field.getDeclaringClass());
        Field declaredField = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = field.getName();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a2 = (A) declaredField.getAnnotation(cls)) != null) {
                return a2;
            }
        }
        return a3;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        A a2;
        A a3 = (A) method.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a2 = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a2;
            }
        }
        return a3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
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
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v14, types: [T, java.util.Map$Entry] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Object objCast;
        T t;
        Object objCast2;
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r10 = (T) new ArrayList(list.size());
                for (Object obj2 : list) {
                    if (type instanceof Class) {
                        if (obj2 != null && obj2.getClass() == JSONObject.class) {
                            objCast = ((JSONObject) obj2).toJavaObject((Class) type, parserConfig, 0);
                        } else {
                            objCast = cast(obj2, (Class<Object>) type, parserConfig);
                        }
                    } else {
                        objCast = cast(obj2, type, parserConfig);
                    }
                    r10.add(objCast);
                }
                return r10;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType != Set.class && rawType != HashSet.class) {
                    if (rawType == TreeSet.class) {
                        t = (T) new TreeSet();
                    } else {
                        t = (T) new ArrayList();
                    }
                } else {
                    t = (T) new HashSet();
                }
                for (T t2 : (Iterable) obj) {
                    if (type2 instanceof Class) {
                        if (t2 != null && t2.getClass() == JSONObject.class) {
                            objCast2 = ((JSONObject) t2).toJavaObject((Class) type2, parserConfig, 0);
                        } else {
                            objCast2 = cast((Object) t2, (Class<Object>) type2, parserConfig);
                        }
                    } else {
                        objCast2 = cast(t2, type2, parserConfig);
                    }
                    ((Collection) t).add(objCast2);
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r11 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r11.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r11;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                ?? r9 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = r9.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    r9.setValue(cast(value, actualTypeArguments[1], parserConfig));
                }
                return r9;
            }
        }
        if (rawType instanceof Class) {
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
            if (deserializer != null) {
                return (T) deserializer.deserialze(new DefaultJSONParser(JSON.toJSONString(obj), parserConfig), parameterizedType, null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}
