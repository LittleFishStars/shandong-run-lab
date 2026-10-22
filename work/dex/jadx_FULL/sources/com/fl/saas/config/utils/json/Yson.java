package com.fl.saas.config.utils.json;

import android.text.TextUtils;
import com.acse.ottn.p3;
import com.facebook.common.internal.ImmutableList;
import com.fl.saas.config.utils.json.annotations.Expose;
import com.fl.saas.config.utils.json.annotations.FieldAlias;
import com.fl.saas.config.utils.json.annotations.MethodAlias;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Yson {
    private <T> ArrayList<T> getArrayList(JSONArray jSONArray, Class<T> cls) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object arrayValue = getArrayValue(jSONArray, i, cls);
            if (arrayValue != null) {
                immutableList.add(arrayValue);
            }
        }
        return immutableList;
    }

    private Object getArrayValue(JSONArray jSONArray, int i, Class cls) {
        if (cls.equals(Integer.TYPE) || cls.equals(Integer.class)) {
            return Integer.valueOf(jSONArray.optInt(i));
        }
        if (cls.equals(Double.TYPE) || cls.equals(Double.class)) {
            return Double.valueOf(jSONArray.optDouble(i));
        }
        if (cls.equals(String.class)) {
            return jSONArray.optString(i);
        }
        if (cls.equals(Boolean.TYPE) || cls.equals(Boolean.class)) {
            return Boolean.valueOf(jSONArray.optBoolean(i));
        }
        if (cls.equals(List.class)) {
            if (jSONArray.optJSONArray(i) != null) {
                return parseArray(jSONArray, (ParameterizedType) cls.getGenericSuperclass());
            }
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
        if (jSONObjectOptJSONObject != null) {
            return getObjectValue(jSONObjectOptJSONObject, cls);
        }
        return null;
    }

    private Field[] getFields(Field[] fieldArr, Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Field[] fieldArr2 = new Field[fieldArr.length + declaredFields.length];
        System.arraycopy(fieldArr, 0, fieldArr2, 0, fieldArr.length);
        System.arraycopy(declaredFields, 0, fieldArr2, fieldArr.length, declaredFields.length);
        Class superclass = cls.getSuperclass();
        return superclass.equals(Object.class) ? fieldArr2 : getFields(fieldArr2, superclass);
    }

    private Object getJSON(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!isPrimitive(obj)) {
            if (obj.getClass().isArray() || (obj instanceof List)) {
                return getJSONArray(obj);
            }
            return obj instanceof JSONObject ? (JSONObject) obj : getJSONObject(obj);
        }
        if (((obj instanceof Double) && Double.isNaN(((Double) obj).doubleValue())) || ((obj instanceof Float) && Float.isNaN(((Float) obj).floatValue()))) {
            return 0;
        }
        return obj;
    }

    private JSONArray getJSONArray(Object obj) {
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object json : (List) obj) {
                if (!isPrimitive(json)) {
                    json = getJSON(json);
                }
                jSONArray2.put(json);
            }
            return jSONArray2;
        }
        if (obj.getClass().isArray()) {
            jSONArray = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray.put(getJSON(Array.get(obj, i)));
            }
        }
        return jSONArray;
    }

    private JSONObject getJSONObject(Object obj) {
        if (obj == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (!isPrimitive(value)) {
                        value = getJSON(value);
                    }
                    jSONObject.put(str, value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        for (Field field : getFields(new Field[0], obj.getClass())) {
            if (((Expose) field.getAnnotation(Expose.class)) == null) {
                field.setAccessible(true);
                FieldAlias fieldAlias = (FieldAlias) field.getAnnotation(FieldAlias.class);
                String strValue = fieldAlias != null ? fieldAlias.value() : field.getName();
                Object json = getJSON(getValue(obj, field));
                if (json != null) {
                    try {
                        jSONObject.put(strValue, json);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    private Method getMethod(String str, Object obj, Field field) {
        FieldAlias fieldAlias = (FieldAlias) field.getAnnotation(FieldAlias.class);
        String strValue = fieldAlias != null ? fieldAlias.value() : field.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(strValue.substring(0, 1).toUpperCase());
        sb.append(strValue.substring(1));
        String string = sb.toString();
        Method[] methods = obj.getClass().getMethods();
        int length = methods.length;
        for (int i = 0; i < length; i++) {
            Method method = methods[i];
            MethodAlias methodAlias = (MethodAlias) method.getAnnotation(MethodAlias.class);
            if ((methodAlias != null && TextUtils.equals(methodAlias.value(), strValue)) || TextUtils.equals(string, method.getName())) {
                return method;
            }
        }
        return null;
    }

    private <T> T getObjectValue(JSONObject jSONObject, Class<T> cls) {
        try {
            T tNewInstance = cls.newInstance();
            for (Field field : getFields(new Field[0], cls)) {
                field.setAccessible(true);
                Object object = parseObject(jSONObject, field);
                if (object != null) {
                    setValue(tNewInstance, field, object);
                }
            }
            return tNewInstance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object getValue(Object obj, Field field) {
        Method method = getMethod((field.getType().equals(Boolean.TYPE) || field.getType().equals(Boolean.class)) ? p3.g : p3.f, obj, field);
        try {
            try {
                obj = method != null ? method.invoke(obj, new Object[0]) : field.get(obj);
                return obj;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return field.get(obj);
        }
    }

    private boolean isPrimitive(Object obj) {
        return obj.getClass().isPrimitive() || (obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String);
    }

    private <T> ArrayList<T> parseArray(JSONArray jSONArray, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList<T> arrayList = null;
        if (actualTypeArguments.length > 0) {
            Type type = actualTypeArguments[0];
            arrayList = type instanceof Class ? getArrayList(jSONArray, (Class) type) : null;
            if (actualTypeArguments[0] instanceof ParameterizedType) {
                arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(parseArray(jSONArray.optJSONArray(i), (ParameterizedType) actualTypeArguments[0]));
                }
            }
        }
        return arrayList;
    }

    private Object parseObject(JSONObject jSONObject, Field field) {
        FieldAlias fieldAlias = (FieldAlias) field.getAnnotation(FieldAlias.class);
        String strValue = fieldAlias != null ? fieldAlias.value() : field.getName();
        Class<?> type = field.getType();
        if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return Integer.valueOf(jSONObject.optInt(strValue));
        }
        if (type.equals(Double.TYPE) || type.equals(Double.class)) {
            return Double.valueOf(jSONObject.optDouble(strValue));
        }
        if (type.equals(Long.TYPE) || type.equals(Long.class)) {
            return Long.valueOf(jSONObject.optLong(strValue));
        }
        if (type.equals(String.class)) {
            return jSONObject.optString(strValue);
        }
        if (type.equals(JSONObject.class)) {
            return jSONObject.optJSONObject(strValue);
        }
        if (type.equals(Boolean.TYPE) || type.equals(Boolean.class)) {
            return Boolean.valueOf(jSONObject.optBoolean(strValue));
        }
        if (type.equals(List.class)) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(strValue);
            if (jSONArrayOptJSONArray != null) {
                return parseArray(jSONArrayOptJSONArray, (ParameterizedType) field.getGenericType());
            }
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strValue);
        if (jSONObjectOptJSONObject != null) {
            return getObjectValue(jSONObjectOptJSONObject, field.getType());
        }
        return null;
    }

    private void setValue(Object obj, Field field, Object obj2) {
        if (obj2 == null) {
            return;
        }
        Method method = getMethod(p3.h, obj, field);
        try {
            try {
                if (method != null) {
                    method.invoke(obj, obj2);
                } else {
                    field.set(obj, obj2);
                }
            } catch (Exception unused) {
                field.set(obj, obj2);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public <T> T fromJson(Class<T> cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return cls.equals(List.class) ? (T) parseArray(new JSONArray(str), (ParameterizedType) cls.getGenericSuperclass()) : (T) getObjectValue(new JSONObject(str), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJson(Object obj) {
        return obj == null ? "" : getJSON(obj).toString();
    }
}
