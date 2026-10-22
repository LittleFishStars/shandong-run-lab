package com.aliyun.tea;

import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.tea.logging.ClientLogger;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaModel {
    private static final ClientLogger logger = new ClientLogger((Class<?>) TeaModel.class);

    public static <T extends TeaModel> T build(Map<String, ?> map, T t) {
        NameInMap nameInMap;
        for (Field field : t.getClass().getFields()) {
            Object obj = map.get(field.getName());
            if (obj != null || ((nameInMap = (NameInMap) field.getAnnotation(NameInMap.class)) != null && (obj = map.get(nameInMap.value())) != null)) {
                t = (T) setTeaModelField(t, field, obj, t.getClass().getName() + Consts.DOT + field.getName(), true);
            }
        }
        return t;
    }

    public static Map<String, Object> buildMap(TeaModel teaModel) {
        if (teaModel == null) {
            return null;
        }
        return teaModel.toMap();
    }

    private static Object buildObject(Object obj, Class cls, Type type, String str) {
        Class<?> cls2 = obj.getClass();
        if (Map.class.isAssignableFrom(cls) && Map.class.isAssignableFrom(cls2)) {
            HashMap map = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (type == null || (type instanceof WildcardType)) {
                    map.put(entry.getKey(), entry.getValue());
                } else if (type instanceof Class) {
                    map.put(entry.getKey(), buildObject(entry.getValue(), (Class) type, null, str));
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    map.put(entry.getKey(), buildObject(entry.getValue(), (Class) parameterizedType.getRawType(), actualTypeArguments[actualTypeArguments.length - 1], str));
                }
            }
            return map;
        }
        if (!List.class.isAssignableFrom(cls) || !List.class.isAssignableFrom(cls2)) {
            if (!TeaModel.class.isAssignableFrom(cls) || !Map.class.isAssignableFrom(cls2)) {
                return confirmType(cls, obj, str);
            }
            try {
                return toModel((Map) obj, (TeaModel) cls.newInstance());
            } catch (Exception e) {
                throw new TeaException(e.getMessage(), e);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            if (type == null || (type instanceof WildcardType)) {
                arrayList.add(obj2);
            } else if (type instanceof Class) {
                arrayList.add(buildObject(obj2, (Class) type, null, str));
            } else {
                ParameterizedType parameterizedType2 = (ParameterizedType) type;
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                arrayList.add(buildObject(obj2, (Class) parameterizedType2.getRawType(), actualTypeArguments2[actualTypeArguments2.length - 1], str));
            }
        }
        return arrayList;
    }

    private static Map<String, Object> changeToMap(Object obj, Boolean bool) {
        HashMap map = new HashMap();
        try {
            for (Field field : obj.getClass().getFields()) {
                NameInMap nameInMap = (NameInMap) field.getAnnotation(NameInMap.class);
                String name = nameInMap == null ? field.getName() : nameInMap.value();
                if (field.get(obj) != null && List.class.isAssignableFrom(field.get(obj).getClass())) {
                    List list = (List) field.get(obj);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        arrayList.add(parseObject(list.get(i)));
                    }
                    map.put(name, arrayList);
                } else if (field.get(obj) != null && TeaModel.class.isAssignableFrom(field.get(obj).getClass())) {
                    map.put(name, toMap(field.get(obj), bool));
                } else if (field.get(obj) != null && Map.class.isAssignableFrom(field.get(obj).getClass())) {
                    Map map2 = (Map) field.get(obj);
                    HashMap map3 = new HashMap();
                    for (Map.Entry entry : map2.entrySet()) {
                        map3.put(entry.getKey(), parseObject(entry.getValue()));
                    }
                    map.put(name, map3);
                } else if ((!bool.booleanValue() || field.get(obj) == null || !InputStream.class.isAssignableFrom(field.get(obj).getClass())) && (!bool.booleanValue() || field.get(obj) == null || !OutputStream.class.isAssignableFrom(field.get(obj).getClass()))) {
                    map.put(name, field.get(obj));
                }
            }
            return map;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static Object confirmType(Class cls, Object obj) {
        return confirmType(cls, obj, "unknown");
    }

    private void determineType(Class cls, Object obj, String str, int i, int i2, double d, double d2, String str2) {
        if (Map.class.isAssignableFrom(cls)) {
            validateMap(str, i, i2, d, d2, (Map) obj, str2);
            return;
        }
        if (TeaModel.class.isAssignableFrom(cls)) {
            ((TeaModel) obj).validate();
            return;
        }
        if (List.class.isAssignableFrom(cls)) {
            List list = (List) obj;
            for (int i3 = 0; i3 < list.size(); i3++) {
                determineType(list.get(i3).getClass(), list.get(i3), str, i, i2, d, d2, str2);
            }
            return;
        }
        if (cls.isArray()) {
            int i4 = 0;
            for (Object[] objArr = (Object[]) obj; i4 < objArr.length; objArr = objArr) {
                determineType(cls.getComponentType(), objArr[i4], str, i, i2, d, d2, str2);
                i4++;
            }
            return;
        }
        if (Number.class.isAssignableFrom(cls)) {
            double dDoubleValue = Double.valueOf(obj.toString()).doubleValue();
            if (dDoubleValue > d) {
                throw new ValidateException(getClass().getName() + Consts.DOT + str2 + " exceeds the maximum");
            }
            if (dDoubleValue >= d2) {
                return;
            }
            throw new ValidateException(getClass().getName() + Consts.DOT + str2 + " less than minimum");
        }
        String strValueOf = String.valueOf(obj);
        if (i > 0 && strValueOf.length() > i) {
            throw new ValidateException(getClass().getName() + Consts.DOT + str2 + " exceeds the maximum length");
        }
        if (i2 > 0 && strValueOf.length() < i2) {
            throw new ValidateException(getClass().getName() + Consts.DOT + str2 + " less than minimum length");
        }
        if ("".equals(str) || Pattern.matches(str, strValueOf)) {
            return;
        }
        throw new ValidateException(getClass().getName() + Consts.DOT + str2 + " regular match failed");
    }

    private static Type getType(Field field, int i) {
        return ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[i];
    }

    private static Object parseNumber(Object obj, Class cls) {
        boolean z = obj instanceof Double;
        if (z && (cls == Long.class || cls == Long.TYPE)) {
            return Long.valueOf(new BigDecimal(obj.toString()).longValue());
        }
        if (z && (cls == Integer.class || cls == Integer.TYPE)) {
            return Integer.valueOf(new BigDecimal(obj.toString()).intValue());
        }
        if (z) {
            return (cls == Float.class || cls == Float.TYPE) ? Float.valueOf(new BigDecimal(obj.toString()).floatValue()) : obj;
        }
        return obj;
    }

    public static Object parseObject(Object obj) {
        if (obj == null) {
            return obj;
        }
        Class<?> cls = obj.getClass();
        if (List.class.isAssignableFrom(cls)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(parseObject(it.next()));
            }
            return arrayList;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return TeaModel.class.isAssignableFrom(cls) ? ((TeaModel) obj).toMap(Boolean.FALSE) : obj;
        }
        HashMap map = new HashMap();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            map.put(entry.getKey(), parseObject(entry.getValue()));
        }
        return map;
    }

    private static <T extends TeaModel> T setTeaModelField(T t, Field field, Object obj, String str, boolean z) {
        try {
            Class<?> type = field.getType();
            Object number = parseNumber(obj, type);
            if (TeaModel.class.isAssignableFrom(type)) {
                Object objNewInstance = type.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (z) {
                    field.set(t, build(toMap(number, Boolean.FALSE), (TeaModel) objNewInstance));
                } else if (z || !Map.class.isAssignableFrom(number.getClass())) {
                    field.set(t, number);
                } else {
                    field.set(t, toModel((Map) number, (TeaModel) objNewInstance));
                }
            } else if (Map.class.isAssignableFrom(type)) {
                field.set(t, buildObject(number, Map.class, getType(field, 1), str));
            } else if (List.class.isAssignableFrom(type)) {
                field.set(t, buildObject(number, List.class, getType(field, 0), str));
            } else {
                field.set(t, confirmType(type, number, str));
            }
            return t;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public static <T extends TeaModel> T toModel(Map<String, ?> map, T t) {
        for (Field field : t.getClass().getFields()) {
            NameInMap nameInMap = (NameInMap) field.getAnnotation(NameInMap.class);
            Object obj = map.get(nameInMap == null ? field.getName() : nameInMap.value());
            if (obj != null) {
                t = (T) setTeaModelField(t, field, obj, t.getClass().getName() + Consts.DOT + field.getName(), false);
            }
        }
        return t;
    }

    private void validateMap(String str, int i, int i2, double d, double d2, Map<String, Object> map, String str2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                determineType(entry.getValue().getClass(), entry.getValue(), str, i, i2, d, d2, str2);
            }
        }
    }

    public static void validateParams(TeaModel teaModel, String str) {
        if (teaModel != null) {
            teaModel.validate();
            return;
        }
        throw new ValidateException("parameter " + str + " is not allowed as null");
    }

    public Map<String, Object> toMap() {
        return changeToMap(this, Boolean.TRUE);
    }

    public void validate() {
        Field[] fields = getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                Object obj = fields[i].get(this);
                Validation validation = (Validation) fields[i].getAnnotation(Validation.class);
                if ((validation != null ? validation.required() : false) && obj == null) {
                    throw new ValidateException("Field " + fields[i].getName() + " is required");
                }
                if (validation != null && obj != null) {
                    String strPattern = validation.pattern();
                    int iMaxLength = validation.maxLength();
                    int iMinLength = validation.minLength();
                    double dMaximum = validation.maximum();
                    double dMinimum = validation.minimum();
                    if (!"".equals(strPattern) || iMaxLength > 0 || iMinLength > 0 || dMaximum != Double.MAX_VALUE || dMinimum != Double.MIN_VALUE) {
                        determineType(fields[i].getType(), obj, strPattern, iMaxLength, iMinLength, dMaximum, dMinimum, fields[i].getName());
                    }
                }
            } catch (Exception e) {
                throw new ValidateException(e.getMessage(), e);
            }
        }
    }

    public static Object confirmType(Class cls, Object obj, String str) {
        if (String.class.isAssignableFrom(cls)) {
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                logger.info("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, String.class.getName(), obj.getClass().getName(), obj.toString());
                return obj.toString();
            }
            if ((obj instanceof Map) || (obj instanceof List)) {
                logger.info("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, String.class.getName(), obj.getClass().getName(), obj.toString());
                return new Gson().toJson(obj);
            }
        } else if (Boolean.class.isAssignableFrom(cls)) {
            if (obj instanceof String) {
                logger.info("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Boolean.class.getName(), obj.getClass().getName(), obj.toString());
                return Boolean.valueOf(Boolean.parseBoolean(String.valueOf(obj)));
            }
            if (obj instanceof Number) {
                if (obj.toString().equals("1")) {
                    logger.info("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Boolean.class.getName(), obj.getClass().getName(), obj.toString());
                    return Boolean.TRUE;
                }
                if (obj.toString().equals("0")) {
                    logger.info("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Boolean.class.getName(), obj.getClass().getName(), obj.toString());
                    return Boolean.FALSE;
                }
            }
        } else if (Integer.class.isAssignableFrom(cls)) {
            if (obj instanceof String) {
                try {
                    Integer.parseInt(obj.toString());
                } catch (NumberFormatException unused) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Integer.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Integer.valueOf(new BigDecimal(obj.toString()).intValue());
            }
            if (obj instanceof Boolean) {
                logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Integer.class.getName(), obj.getClass().getName(), obj.toString());
                return Integer.valueOf(obj.toString().equalsIgnoreCase("true") ? 1 : 0);
            }
            if (obj instanceof Long) {
                if (((Long) obj).longValue() > 2147483647L) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Integer.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Integer.valueOf(new BigDecimal(obj.toString()).intValue());
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                BigDecimal bigDecimal = new BigDecimal(obj.toString());
                logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Integer.class.getName(), obj.getClass().getName(), obj.toString());
                return Integer.valueOf(bigDecimal.intValue());
            }
        } else if (Long.class.isAssignableFrom(cls)) {
            if ((obj instanceof String) || (obj instanceof Integer)) {
                try {
                    Long.parseLong(obj.toString());
                } catch (NumberFormatException unused2) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Long.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Long.valueOf(new BigDecimal(obj.toString()).longValue());
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                BigDecimal bigDecimal2 = new BigDecimal(obj.toString());
                logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Long.class.getName(), obj.getClass().getName(), obj.toString());
                return Long.valueOf(bigDecimal2.longValue());
            }
        } else if (Float.class.isAssignableFrom(cls)) {
            if (obj instanceof String) {
                try {
                    Float.parseFloat(obj.toString());
                } catch (NumberFormatException unused3) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Float.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Float.valueOf(new BigDecimal(obj.toString()).floatValue());
            }
            if (obj instanceof Double) {
                if (((Double) obj).doubleValue() > 3.4028234663852886E38d) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Float.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Float.valueOf(new BigDecimal(obj.toString()).floatValue());
            }
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                BigDecimal bigDecimal3 = new BigDecimal(obj.toString());
                logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Float.class.getName(), obj.getClass().getName(), obj.toString());
                return Float.valueOf(bigDecimal3.floatValue());
            }
        } else if (Double.class.isAssignableFrom(cls)) {
            if ((obj instanceof String) || (obj instanceof Float)) {
                try {
                    Double.parseDouble(obj.toString());
                } catch (NumberFormatException unused4) {
                    logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Double.class.getName(), obj.getClass().getName(), obj.toString());
                }
                return Double.valueOf(new BigDecimal(obj.toString()).doubleValue());
            }
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                BigDecimal bigDecimal4 = new BigDecimal(obj.toString());
                logger.warning("[{}] There are some cast events happening. expect: {}, but: {}, value: {}.", str, Double.class.getName(), obj.getClass().getName(), obj.toString());
                return Double.valueOf(bigDecimal4.doubleValue());
            }
        }
        return obj;
    }

    public static Map<String, Object> toMap(Object obj) {
        return toMap(obj, Boolean.TRUE);
    }

    private static Map<String, Object> toMap(Object obj, Boolean bool) {
        HashMap map = new HashMap();
        if (obj == null || !(obj instanceof Map)) {
            return (obj == null || !TeaModel.class.isAssignableFrom(obj.getClass())) ? map : changeToMap(obj, bool);
        }
        return (Map) obj;
    }

    private Map<String, Object> toMap(Boolean bool) {
        return changeToMap(this, bool);
    }
}
