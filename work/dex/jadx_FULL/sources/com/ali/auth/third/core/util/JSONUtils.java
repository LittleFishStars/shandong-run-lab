package com.ali.auth.third.core.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JSONUtils {
    public static Boolean optBoolean(JSONObject jSONObject, String str) {
        return Boolean.valueOf(jSONObject.has(str) ? jSONObject.optBoolean(str) : false);
    }

    public static Integer optInteger(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    public static Long optLong(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }

    public static String optString(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Byte[]] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Character[]] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Byte[]] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Character[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v35, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v36, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v37, types: [char[]] */
    /* JADX WARN: Type inference failed for: r7v38, types: [java.lang.String[]] */
    public static <T> T parseStringValue(String str, Class<T> cls) {
        ?? r0 = (T) null;
        if (str == 0 || cls == null) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (Short.TYPE.equals(cls) || Short.class.equals(cls)) {
            return (T) Short.valueOf((String) str);
        }
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls)) {
            return (T) Integer.valueOf((String) str);
        }
        if (Long.TYPE.equals(cls) || Long.class.equals(cls)) {
            return (T) Long.valueOf((String) str);
        }
        if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
            return (T) Boolean.valueOf((String) str);
        }
        if (Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return (T) Float.valueOf((String) str);
        }
        if (Double.TYPE.equals(cls) || Double.class.equals(cls)) {
            return (T) Double.valueOf((String) str);
        }
        if (Byte.TYPE.equals(cls) || Byte.class.equals(cls)) {
            return (T) Byte.valueOf((String) str);
        }
        int i = 0;
        if (Character.TYPE.equals(cls) || Character.class.equals(cls)) {
            return (T) Character.valueOf(str.charAt(0));
        }
        if (Date.class.isAssignableFrom(cls)) {
            try {
                return (T) new SimpleDateFormat("yyyyMMddHHmmssSSSZ", Locale.US).parse(str);
            } catch (ParseException e) {
                throw new RuntimeException("Parse Date error", e);
            }
        }
        char cCharAt = str.charAt(0);
        if (!cls.isArray()) {
            if (cCharAt != '{') {
                if (cls.isAssignableFrom(String.class)) {
                    return str;
                }
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject((String) str);
                return Map.class.isAssignableFrom(cls) ? (T) toMap(jSONObject) : (T) toPOJO(jSONObject, cls);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        Class<?> componentType = cls.getComponentType();
        if (cCharAt == '[') {
            try {
                return (T) toPOJOArray(new JSONArray((String) str), componentType);
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
        if (String.class.equals(componentType)) {
            return (T) str.split(",");
        }
        if (Character.TYPE.equals(componentType)) {
            return (T) str.toCharArray();
        }
        if (Character.class.equals(componentType)) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            ?? r1 = (T) new Character[length];
            while (i < length) {
                r1[i] = Character.valueOf(charArray[i]);
                i++;
            }
            return r1;
        }
        if (Byte.TYPE.equals(componentType)) {
            return (T) android.util.Base64.decode((String) str, 0);
        }
        if (Byte.class.equals(componentType)) {
            byte[] bArrDecode = android.util.Base64.decode((String) str, 0);
            int length2 = bArrDecode.length;
            r0 = (T) new Byte[length2];
            while (i < length2) {
                r0[i] = Byte.valueOf(bArrDecode[i]);
                i++;
            }
        }
        return (T) r0;
    }

    public static JSONArray toJsonArray(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object jsonObject : list) {
            if (jsonObject instanceof Map) {
                jsonObject = toJsonObject((Map) jsonObject);
            }
            jSONArray.put(jsonObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonArray(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object jsonObject : objArr) {
            if (jsonObject instanceof Map) {
                jsonObject = toJsonObject((Map) jsonObject);
            }
            jSONArray.put(jsonObject);
        }
        return jSONArray;
    }

    public static JSONObject toJsonObject(Map<String, ? extends Object> map) {
        String key;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        key = entry.getKey();
                        value = toJsonObject((Map) value);
                    } else if (value instanceof List) {
                        key = entry.getKey();
                        value = toJsonArray((List<Object>) value);
                    } else if (value.getClass().isArray()) {
                        key = entry.getKey();
                        value = toJsonArray((Object[]) value);
                    } else {
                        key = entry.getKey();
                    }
                    jSONObject.put(key, value);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            arrayList.add(obj instanceof JSONObject ? toMap((JSONObject) obj) : obj instanceof JSONArray ? toList((JSONArray) obj) : jSONArray.get(i));
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        if (map == null) {
            map = new HashMap<>();
        }
        if (jSONObject == null) {
            return map;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONObject) {
                objOpt = toMap((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = toList((JSONArray) objOpt);
            }
            map.put(next, objOpt);
        }
        return map;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        return toMap(null, jSONObject);
    }

    public static <T> T toPOJO(JSONObject jSONObject, Class<T> cls) {
        Object map;
        if (jSONObject == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        try {
            T tNewInstance = cls.newInstance();
            for (Field field : cls.getFields()) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (jSONObject.has(name)) {
                    if (!type.isPrimitive()) {
                        if (type == String.class) {
                            map = jSONObject.getString(name);
                        } else if (type == Boolean.class || type == Integer.class || type == Short.class || type == Long.class || type == Double.class) {
                            map = jSONObject.get(name);
                        } else if (type.isArray()) {
                            map = toPOJOArray(jSONObject.getJSONArray(name), type.getComponentType());
                        } else {
                            map = Map.class.isAssignableFrom(type) ? toMap(jSONObject.getJSONObject(name)) : toPOJO(jSONObject.getJSONObject(name), type);
                        }
                        field.set(tNewInstance, map);
                    } else if (type == Boolean.TYPE) {
                        field.setBoolean(tNewInstance, jSONObject.getBoolean(name));
                    } else if (type == Byte.TYPE) {
                        field.setByte(tNewInstance, (byte) jSONObject.getInt(name));
                    } else if (type == Character.TYPE) {
                        String string = jSONObject.getString(name);
                        field.setChar(tNewInstance, (string == null || string.length() == 0) ? (char) 0 : string.charAt(0));
                    } else if (type == Short.TYPE) {
                        field.setShort(tNewInstance, (short) jSONObject.getInt(name));
                    } else if (type == Integer.TYPE) {
                        field.setInt(tNewInstance, jSONObject.getInt(name));
                    } else if (type == Long.TYPE) {
                        field.setLong(tNewInstance, jSONObject.getLong(name));
                    } else if (type == Float.TYPE) {
                        field.setFloat(tNewInstance, (float) jSONObject.getDouble(name));
                    } else if (type == Double.TYPE) {
                        field.setDouble(tNewInstance, jSONObject.getDouble(name));
                    }
                }
            }
            return tNewInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T[] toPOJOArray(JSONArray jSONArray, Class<T> cls) {
        Object map;
        if (jSONArray == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!cls.isPrimitive()) {
                    if (cls == String.class) {
                        map = jSONArray.getString(i);
                    } else if (cls == Boolean.class || cls == Integer.class || cls == Short.class || cls == Long.class || cls == Double.class) {
                        map = jSONArray.get(i);
                    } else if (cls.isArray()) {
                        map = toPOJOArray(jSONArray.getJSONArray(i), cls.getComponentType());
                    } else {
                        map = Map.class.isAssignableFrom(cls) ? toMap(jSONArray.getJSONObject(i)) : toPOJO(jSONArray.getJSONObject(i), cls);
                    }
                    Array.set(objNewInstance, i, map);
                } else if (cls == Boolean.TYPE) {
                    Array.setBoolean(objNewInstance, i, jSONArray.getBoolean(i));
                } else if (cls == Byte.TYPE) {
                    Array.setByte(objNewInstance, i, (byte) jSONArray.getInt(i));
                } else if (cls == Character.TYPE) {
                    String string = jSONArray.getString(i);
                    Array.setChar(objNewInstance, i, (string == null || string.length() == 0) ? (char) 0 : string.charAt(0));
                } else if (cls == Short.TYPE) {
                    Array.setShort(objNewInstance, i, (short) jSONArray.getInt(i));
                } else if (cls == Integer.TYPE) {
                    Array.setInt(objNewInstance, i, jSONArray.getInt(i));
                } else if (cls == Long.TYPE) {
                    Array.setLong(objNewInstance, i, jSONArray.getLong(i));
                } else if (cls == Float.TYPE) {
                    Array.setFloat(objNewInstance, i, (float) jSONArray.getDouble(i));
                } else if (cls == Double.TYPE) {
                    Array.setDouble(objNewInstance, i, jSONArray.getDouble(i));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return (T[]) ((Object[]) objNewInstance);
    }
}
