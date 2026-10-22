package com.kc.cw.ad.internal.c;

import androidx.camera.video.AudioStats;
import com.facebook.common.internal.ImmutableList;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.bv9;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k {
    public static <T> T a(String str, Class<T> cls) {
        try {
            return (T) a(new JSONObject(str), cls, (Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    private static <T, V> T a(JSONObject jSONObject, Class<T> cls, V v) {
        T tNewInstance;
        Object objA;
        try {
            if (v == null) {
                tNewInstance = cls.newInstance();
            } else {
                Constructor<?> constructor = cls.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                tNewInstance = (T) constructor.newInstance(v);
            }
        } catch (Exception unused) {
            tNewInstance = null;
        }
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();
            if (jSONObject.has(name)) {
                String name2 = type.getName();
                switch (name2) {
                    case "java.lang.String":
                        try {
                            String string = jSONObject.getString(name);
                            if (string.equals("null")) {
                                string = "";
                            }
                            field.set(tNewInstance, string);
                            break;
                        } catch (Exception unused2) {
                            field.set(tNewInstance, "");
                            break;
                        }
                        break;
                    case "int":
                    case "java.lang.Integer":
                        objA = Integer.valueOf(jSONObject.getInt(name));
                        field.set(tNewInstance, objA);
                        break;
                    case "boolean":
                    case "java.lang.Boolean":
                        objA = Boolean.valueOf(jSONObject.getBoolean(name));
                        field.set(tNewInstance, objA);
                        break;
                    case "float":
                    case "java.lang.Float":
                        objA = Float.valueOf(jSONObject.getString(name));
                        field.set(tNewInstance, objA);
                        break;
                    case "double":
                    case "java.lang.Double":
                        objA = Double.valueOf(jSONObject.getDouble(name));
                        field.set(tNewInstance, objA);
                        break;
                    case "long":
                    case "java.lang.Long":
                        objA = Long.valueOf(jSONObject.getLong(name));
                        field.set(tNewInstance, objA);
                        break;
                    case "java.util.List":
                    case "java.util.ArrayList":
                        Object obj = jSONObject.get(name);
                        Class<?> cls2 = Class.forName(field.getGenericType().toString().replace("<", "").replace(type.getName(), "").replace(">", ""));
                        if (!(obj instanceof JSONArray)) {
                            break;
                        } else {
                            objA = a((JSONArray) obj, cls2, tNewInstance);
                            field.set(tNewInstance, objA);
                            break;
                        }
                        break;
                    default:
                        try {
                            Object obj2 = jSONObject.get(name);
                            Class<?> cls3 = Class.forName(name2);
                            if (obj2 instanceof JSONObject) {
                                objA = a((JSONObject) obj2, cls3, tNewInstance);
                                field.set(tNewInstance, objA);
                            }
                            break;
                        } catch (Exception unused3) {
                            break;
                        }
                        break;
                }
            }
        }
        return tNewInstance;
    }

    public static <T> String a(T t) {
        return t == null ? "{}" : b(t);
    }

    private static String a(String str) {
        Object objValueOf;
        if (str == null || str.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder((str.length() + 2) << 4);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                objValueOf = "\\\"";
            } else if (cCharAt == '\\') {
                objValueOf = "\\\\";
            } else if (cCharAt == '/') {
                objValueOf = "\\/";
            } else if (cCharAt == '\b') {
                objValueOf = "\\b";
            } else if (cCharAt == '\f') {
                objValueOf = "\\f";
            } else if (cCharAt == '\n') {
                objValueOf = "\\n";
            } else if (cCharAt == '\r') {
                objValueOf = "\\r";
            } else {
                objValueOf = cCharAt == '\t' ? "\\t" : Character.valueOf(cCharAt);
            }
            sb.append(objValueOf);
        }
        sb.append('\"');
        return sb.toString();
    }

    private static <T> String a(List<T> list) {
        String strB;
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (obj instanceof String) {
                strB = a((String) obj);
            } else {
                if ((obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double)) {
                    sb.append(obj);
                } else {
                    strB = b(obj);
                }
                sb.append(",");
            }
            sb.append(strB);
            sb.append(",");
        }
        return sb.toString();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add((String) jSONArray.get(i));
                }
                return arrayList;
            }
        } catch (ClassCastException | JSONException unused) {
        }
        return null;
    }

    private static <T, V> ArrayList<T> a(JSONArray jSONArray, Class<T> cls, V v) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                immutableList.add(jSONArray.get(i) instanceof JSONObject ? a(jSONArray.getJSONObject(i), cls, v) : jSONArray.get(i));
            } catch (Exception unused) {
            }
        }
        return immutableList;
    }

    public static HashMap<String, Object> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            HashMap<String, Object> map = new HashMap<>();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return z;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return z;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
    private static <T> String b(T t) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(declaredFields.length << 4);
        sb.append(bv9.b);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();
            if (!name.contains("this$")) {
                switch (type.getName()) {
                    case "java.lang.String":
                        sb.append("\"");
                        sb.append(name);
                        sb.append("\":");
                        sb.append(a((String) field.get(t)));
                        break;
                    case "boolean":
                    case "java.lang.Boolean":
                    case "int":
                    case "java.lang.Integer":
                    case "float":
                    case "java.lang.Float":
                    case "double":
                    case "java.lang.Double":
                    case "long":
                    case "java.lang.Long":
                        sb.append("\"");
                        sb.append(name);
                        sb.append("\":");
                        sb.append(field.get(t));
                        break;
                    case "java.util.List":
                    case "java.util.ArrayList":
                        try {
                            List list = (List) field.get(t);
                            if (list != null && !list.isEmpty()) {
                                sb.append("\"");
                                sb.append(name);
                                sb.append("\":");
                                sb.append("[");
                                sb.append(a(list));
                                sb.setCharAt(sb.length() - 1, ']');
                            }
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                        break;
                    default:
                        continue;
                        break;
                }
                sb.append(",");
            }
        }
        if (sb.length() == 1) {
            sb.append("}");
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public static JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static int d(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static double e(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static boolean f(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }
}
