package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.wrapper.annotation.Properties;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ParamsUtils {
    private static Class<?> getGenericType(Class<?> cls) {
        try {
            Type type = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return (Class) type;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getJsonValue(Object obj, boolean z) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        return isBasicType(obj.getClass()) ? getValue(obj, z) : makeJsonString(new Object[]{obj}, z);
    }

    public static Map<String, Object> getParamsMap(Object[] objArr) throws IllegalAccessException {
        HashMap map = new HashMap();
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj instanceof BaseParams) {
                    for (Field field : obj.getClass().getFields()) {
                        Properties properties = (Properties) field.getAnnotation(Properties.class);
                        if (properties != null) {
                            String strName = properties.name();
                            if (strName == null || strName.isEmpty()) {
                                map.put(field.getName(), field.get(obj));
                            } else {
                                map.put(strName, field.get(obj));
                            }
                        } else {
                            map.put(field.getName(), field.get(obj));
                        }
                    }
                    for (Field field2 : obj.getClass().getDeclaredFields()) {
                        field2.setAccessible(true);
                        Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                        if (properties2 != null) {
                            String strName2 = properties2.name();
                            if (strName2 == null || strName2.isEmpty()) {
                                map.put(field2.getName(), field2.get(obj));
                            } else {
                                map.put(strName2, field2.get(obj));
                            }
                        } else {
                            map.put(field2.getName(), field2.get(obj));
                        }
                        field2.setAccessible(false);
                    }
                } else if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        map.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                }
            }
        }
        return map;
    }

    public static String getValue(Object obj, boolean z) {
        return z ? AppMD5.encodeUrlParamsValue(String.valueOf(obj)) : String.valueOf(obj);
    }

    private static boolean isBasicType(Class<?> cls) {
        return cls == String.class || cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == Boolean.class || cls == Boolean.TYPE;
    }

    public static String makeFormString(Object[] objArr) throws IllegalAccessException {
        return makeFormString(objArr, true);
    }

    public static String makeJsonString(Object[] objArr) throws IllegalAccessException {
        return makeJsonString(objArr, true);
    }

    public static String makeQueryString(Object[] objArr) throws IllegalAccessException {
        return makeQueryString(objArr, true);
    }

    private static void setValue(Object obj, Field field, Object obj2) throws IllegalAccessException {
        try {
            if (isBasicType(field.getType())) {
                field.set(obj, toBasicValue(obj2, field.getType()));
            } else {
                field.set(obj, toMultiValue(obj2.toString(), field.getGenericType()));
            }
        } catch (Exception unused) {
        }
    }

    private static Object toBasicValue(Object obj, Class<?> cls) {
        if (cls == String.class) {
            return obj.toString();
        }
        if (cls == Byte.class || cls == Byte.TYPE) {
            return Byte.valueOf(obj.toString());
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return Short.valueOf(obj.toString());
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return Integer.valueOf(obj.toString());
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return Long.valueOf(obj.toString());
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return Float.valueOf(obj.toString());
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return Double.valueOf(obj.toString());
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return Boolean.valueOf(obj.toString());
        }
        return null;
    }

    public static String toJsonString(Object obj, boolean z) throws IllegalAccessException {
        if (obj == null) {
            return "";
        }
        JsonBuilder jsonBuilder = new JsonBuilder();
        toJsonStringInner(obj, z, jsonBuilder);
        return jsonBuilder.getJson();
    }

    private static void toJsonStringInner(Object obj, boolean z, JsonBuilder jsonBuilder) throws IllegalAccessException {
        if (obj == null) {
            jsonBuilder.value("");
            return;
        }
        if (obj instanceof Map) {
            jsonBuilder.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jsonBuilder.key(String.valueOf(entry.getKey()));
                toJsonStringInner(entry.getValue(), z, jsonBuilder);
            }
            jsonBuilder.endObject();
            return;
        }
        boolean z2 = obj instanceof List;
        int i = 0;
        if (!z2 && !(obj instanceof Set) && !obj.getClass().isArray()) {
            if (!isBasicType(obj.getClass())) {
                toJsonStringInner(getParamsMap(new Object[]{obj}), z, jsonBuilder);
                return;
            }
            Object basicValue = toBasicValue(obj, obj.getClass());
            if (basicValue instanceof String) {
                jsonBuilder.valueDirect(String.format("\"%s\"", getValue(basicValue, z)));
                return;
            } else {
                jsonBuilder.valueDirect(String.valueOf(basicValue));
                return;
            }
        }
        jsonBuilder.arrayValue();
        if (z2) {
            List list = (List) obj;
            while (i < list.size()) {
                toJsonStringInner(list.get(i), z, jsonBuilder);
                i++;
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                toJsonStringInner(it.next(), z, jsonBuilder);
            }
        } else {
            int length = Array.getLength(obj);
            while (i < length) {
                toJsonStringInner(Array.get(obj, i), z, jsonBuilder);
                i++;
            }
        }
        jsonBuilder.endArrayValue();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    private static Object toMultiValue(String str, Type type) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type instanceof ParameterizedType) {
            cls = (Class) ((ParameterizedType) type).getRawType();
        }
        if (cls == null) {
            return null;
        }
        if (!Set.class.isAssignableFrom(cls) && !List.class.isAssignableFrom(cls) && !cls.isArray()) {
            return toObject(str, cls);
        }
        JSONArray jSONArray = new JSONArray(str);
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        for (int i = 0; i < length; i++) {
            if (type2 instanceof Class) {
                Class cls2 = (Class) type2;
                if (isBasicType(cls2)) {
                    objArr[i] = toBasicValue(jSONArray.get(i).toString(), cls2);
                } else {
                    objArr[i] = toMultiValue(jSONArray.get(i).toString(), parameterizedType.getActualTypeArguments()[0]);
                }
            } else {
                objArr[i] = toMultiValue(jSONArray.get(i).toString(), parameterizedType.getActualTypeArguments()[0]);
            }
        }
        if (TreeSet.class.isAssignableFrom(cls)) {
            return new TreeSet(Arrays.asList(objArr));
        }
        if (LinkedList.class.isAssignableFrom(cls)) {
            return new LinkedList(Arrays.asList(objArr));
        }
        if (Set.class.isAssignableFrom(cls)) {
            return new HashSet(Arrays.asList(objArr));
        }
        return List.class.isAssignableFrom(cls) ? new ArrayList(Arrays.asList(objArr)) : objArr;
    }

    public static Object toObject(String str, Class<?> cls) throws IllegalAccessException, JSONException, InstantiationException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (isBasicType(cls)) {
            return toBasicValue(str, cls);
        }
        if (BaseParams.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = new JSONObject(str);
            Object objNewInstance = cls.newInstance();
            for (Field field : cls.getFields()) {
                Properties properties = (Properties) field.getAnnotation(Properties.class);
                if (properties != null && jSONObject.has(properties.name())) {
                    setValue(objNewInstance, field, jSONObject.get(properties.name()));
                } else if (properties == null && jSONObject.has(field.getName())) {
                    setValue(objNewInstance, field, jSONObject.get(field.getName()));
                }
            }
            for (Field field2 : cls.getDeclaredFields()) {
                field2.setAccessible(true);
                Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                if (properties2 != null && jSONObject.has(properties2.name())) {
                    setValue(objNewInstance, field2, jSONObject.get(properties2.name()));
                } else if (properties2 == null && jSONObject.has(field2.getName())) {
                    setValue(objNewInstance, field2, jSONObject.get(field2.getName()));
                }
                field2.setAccessible(false);
            }
            return objNewInstance;
        }
        if (Map.class.isAssignableFrom(cls)) {
            JSONObject jSONObject2 = new JSONObject(str);
            Map map = new HashMap();
            if (TreeMap.class.isAssignableFrom(cls)) {
                map = new TreeMap();
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next));
            }
            return map;
        }
        if (!Set.class.isAssignableFrom(cls) && !List.class.isAssignableFrom(cls) && !cls.isArray()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        Class<?> componentType = cls.isArray() ? cls.getComponentType() : getGenericType(cls);
        for (int i = 0; i < length; i++) {
            if (isBasicType(componentType)) {
                objArr[i] = toBasicValue(jSONArray.get(i).toString(), componentType);
            } else {
                objArr[i] = toObject(jSONArray.get(i).toString(), componentType);
            }
        }
        if (TreeSet.class.isAssignableFrom(cls)) {
            return new TreeSet(Arrays.asList(objArr));
        }
        if (LinkedList.class.isAssignableFrom(cls)) {
            return new LinkedList(Arrays.asList(objArr));
        }
        if (Set.class.isAssignableFrom(cls)) {
            return new HashSet(Arrays.asList(objArr));
        }
        if (List.class.isAssignableFrom(cls)) {
            return new ArrayList(Arrays.asList(objArr));
        }
        if (!cls.isArray()) {
            return objArr;
        }
        Object objNewInstance2 = Array.newInstance(cls.getComponentType(), length);
        for (int i2 = 0; i2 < length; i2++) {
            Array.set(objNewInstance2, i2, objArr[i2]);
        }
        return objNewInstance2;
    }

    public static boolean verify(BaseParams baseParams) {
        try {
            Class<?> cls = baseParams.getClass();
            for (Field field : cls.getFields()) {
                Object obj = field.get(baseParams);
                Properties properties = (Properties) field.getAnnotation(Properties.class);
                if (properties != null && properties.require()) {
                    if (obj == null) {
                        return false;
                    }
                    if ((obj instanceof String) && TextUtils.isEmpty(String.valueOf(obj))) {
                        return false;
                    }
                }
            }
            for (Field field2 : cls.getDeclaredFields()) {
                field2.setAccessible(true);
                Object obj2 = field2.get(baseParams);
                Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                field2.setAccessible(false);
                if (properties2 != null && properties2.require()) {
                    if (obj2 == null) {
                        return false;
                    }
                    if ((obj2 instanceof String) && TextUtils.isEmpty(String.valueOf(obj2))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String makeFormString(Object[] objArr, boolean z) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : getParamsMap(objArr).entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(String.valueOf(entry.getValue()))) {
                sb.append("--bd_map_sdk_cc");
                sb.append("\r\n");
                sb.append(String.format(HttpClient.PARAM_TEMPLATE, entry.getKey()));
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append(getValue(entry.getValue(), z));
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String makeJsonString(Object[] objArr, boolean z) throws IllegalAccessException {
        return toJsonString(getParamsMap(objArr), z);
    }

    public static String makeQueryString(Object[] objArr, boolean z) throws IllegalAccessException {
        Map<String, Object> paramsMap = getParamsMap(objArr);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (entry.getKey() != null && entry.getValue() != null && !TextUtils.isEmpty(key) && !TextUtils.isEmpty(String.valueOf(entry.getValue()))) {
                sb.append(key);
                sb.append("=");
                int i = 0;
                if (value.getClass().isArray()) {
                    Object[] objArr2 = (Object[]) value;
                    if (objArr2.length > 0) {
                        int length = objArr2.length;
                        while (i < length) {
                            sb.append(getValue(objArr2[i], z));
                            sb.append(",");
                            i++;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else if (value instanceof List) {
                    List list = (List) value;
                    if (!list.isEmpty()) {
                        while (i < list.size()) {
                            sb.append(getValue(Integer.valueOf(i), z));
                            sb.append(",");
                            i++;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            sb.append(getValue(it.next(), z));
                            sb.append(",");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    sb.append(getValue(value, z));
                }
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
