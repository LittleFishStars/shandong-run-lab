package com.beizi.fusion;

import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class mg {
    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return i;
    }

    public static JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static JSONObject c(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static String d(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String a(JSONArray jSONArray, int i) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return "";
        }
        try {
            return jSONArray.getString(i);
        } catch (JSONException e) {
            om.a(e);
            return "";
        }
    }

    public static Object c(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
            return null;
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static JSONArray b(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static boolean a(String str) {
        JSONObject jSONObjectC;
        if (TextUtils.isEmpty(str) || (jSONObjectC = c(str)) == null) {
            return false;
        }
        return jSONObjectC.keys().hasNext();
    }

    public static JSONObject b() {
        return new JSONObject();
    }

    private static JSONArray b(Object obj, Type type) {
        JSONArray jSONArrayA = a();
        if (obj != null && obj.getClass().isArray()) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                for (int i = 0; i < list.size(); i++) {
                    if (pl.c(cls)) {
                        jSONArrayA.put(list.get(i));
                    } else if (fd.class.isAssignableFrom(cls)) {
                        jSONArrayA.put(b(list.get(i)));
                    }
                }
            }
        }
        return jSONArrayA;
    }

    public static JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static String a(Map map) {
        JSONObject jSONObjectA = a(map, false);
        return jSONObjectA != null ? jSONObjectA.toString() : "";
    }

    public static JSONObject a(Map map, boolean z) {
        if (map == null) {
            return null;
        }
        try {
            if (map.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    String str = (String) entry.getValue();
                    if (z && !TextUtils.isEmpty(str)) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    } else {
                        String str2 = (String) entry.getKey();
                        if (str == null) {
                            str = "";
                        }
                        jSONObject.put(str2, str);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    public static JSONObject b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObjectB = b();
                List<Field> listB = pl.b(obj.getClass());
                if (!listB.isEmpty()) {
                    for (Field field : listB) {
                        kg kgVar = (kg) field.getAnnotation(kg.class);
                        if (kgVar != null) {
                            String strKey = kgVar.key();
                            if (pl.c(field.getType())) {
                                jSONObjectB.put(strKey, pl.a(obj, field));
                            } else if (fd.class.isAssignableFrom(field.getType())) {
                                jSONObjectB.put(strKey, b(pl.a(obj, field)));
                            } else if (List.class.isAssignableFrom(field.getType())) {
                                jSONObjectB.put(strKey, b(pl.a(obj, field), field.getGenericType()));
                            } else if (field.getType().isArray()) {
                                jSONObjectB.put(strKey, a(pl.a(obj, field), field.getGenericType()));
                            }
                        }
                    }
                }
                return jSONObjectB;
            } catch (JSONException unused) {
            }
        }
        return b();
    }

    public static JSONArray a() {
        return new JSONArray();
    }

    public static JSONArray a(Map map, String str, String str2) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry entry : map.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        if (entry != null) {
                            jSONObject.put(str, entry.getKey());
                            jSONObject.put(str2, entry.getValue());
                        }
                        jSONArray.put(jSONObject);
                    }
                    return jSONArray;
                }
            } catch (JSONException e) {
                om.a(e);
            }
        }
        return a();
    }

    public static String a(Object obj) {
        return a(obj, false).toString();
    }

    public static JSONObject a(Object obj, boolean z) {
        Class<?> cls = obj.getClass();
        List<Field> listB = pl.b(cls);
        JSONObject jSONObjectB = b();
        for (Field field : listB) {
            kg kgVar = (kg) field.getAnnotation(kg.class);
            if (kgVar != null && !kgVar.exclude()) {
                Object objA = a(obj, field, z);
                if (!z) {
                    jSONObjectB.put(kgVar.key(), objA);
                } else if (objA != null) {
                    try {
                        if (objA instanceof String) {
                            if (!TextUtils.isEmpty(objA.toString())) {
                                jSONObjectB.put(kgVar.key(), objA);
                            }
                        } else {
                            jSONObjectB.put(kgVar.key(), objA);
                        }
                    } catch (JSONException unused) {
                        om.b("JsonUtil", "转json异常..." + cls.getSimpleName() + " " + field.getName());
                    }
                }
            }
        }
        return jSONObjectB;
    }

    private static Object a(Object obj, Field field, boolean z) {
        Object objA = pl.a(obj, field);
        if (pl.c(field.getType())) {
            if (objA != null) {
                return objA;
            }
            if (String.class.isAssignableFrom(field.getType())) {
                return "";
            }
            return 0;
        }
        if (List.class.isAssignableFrom(field.getType())) {
            if (objA != null) {
                List list = (List) objA;
                if (!list.isEmpty()) {
                    return a(list.iterator(), z);
                }
            }
            return a();
        }
        if (field.getType().isArray()) {
            if (objA != null) {
                Object[] objArr = (Object[]) objA;
                if (objArr.length > 0) {
                    return a(Arrays.asList(objArr).iterator(), z);
                }
            }
            return a();
        }
        if (objA instanceof gb) {
            return a(objA, z);
        }
        return null;
    }

    private static JSONArray a(Iterator it, boolean z) {
        if (it == null) {
            return null;
        }
        JSONArray jSONArrayA = a();
        while (it.hasNext()) {
            Object next = it.next();
            if (pl.c(next.getClass())) {
                jSONArrayA.put(next);
            } else {
                jSONArrayA.put(a(next, z));
            }
        }
        return jSONArrayA;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    private static void a(Object obj, Field field, JSONObject jSONObject, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (pl.c(field.getType())) {
                if (jSONObject.opt(str) != null) {
                    pl.a(obj, field, jSONObject.opt(str));
                } else if (!TextUtils.isEmpty(str2)) {
                    pl.a(obj, field, str2);
                }
            }
            if (jSONObject.has(str)) {
                if (oa.class.isAssignableFrom(field.getType())) {
                    pl.a(obj, field, pl.a((Class) field.getType(), b(jSONObject, str)));
                    return;
                } else if (List.class.isAssignableFrom(field.getType())) {
                    pl.a(obj, field, a(a(jSONObject, str), field.getType(), field.getGenericType()));
                    return;
                } else {
                    if (field.getType().isArray()) {
                        pl.a(obj, field, a(a(jSONObject, str), (Class) field.getType()));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (oa.class.isAssignableFrom(field.getType())) {
            pl.a(obj, field, pl.a((Class) field.getType(), jSONObject));
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public static void a(oa oaVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            List<Field> listB = pl.b(oaVar.getClass());
            if (listB.isEmpty()) {
                return;
            }
            for (Field field : listB) {
                kg kgVar = (kg) field.getAnnotation(kg.class);
                if (kgVar != null) {
                    a(oaVar, field, jSONObject, kgVar.key(), kgVar.defValue());
                }
            }
        }
    }

    private static Object a(JSONArray jSONArray, Class cls) {
        Object objA;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            Class<?> componentType = cls.getComponentType();
            if (componentType == null) {
                return null;
            }
            int length = jSONArray.length();
            Object objNewInstance = Array.newInstance(componentType, length);
            for (int i = 0; i < length; i++) {
                if (pl.c(componentType)) {
                    objA = jSONArray.get(i);
                } else {
                    objA = pl.a((Class) componentType, jSONArray.getJSONObject(i));
                }
                Array.set(objNewInstance, i, objA);
            }
            return objNewInstance;
        } catch (JSONException e) {
            om.a(e);
            return null;
        }
    }

    private static List a(JSONArray jSONArray, Class cls, Type type) {
        List listA = null;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && (type instanceof ParameterizedType)) {
                    if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
                        cls = ArrayList.class;
                    }
                    listA = pl.a(cls);
                    if (listA != null) {
                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                        Class cls2 = (Class) actualTypeArguments[0];
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (pl.c(cls2)) {
                                listA.add(jSONArray.get(i));
                            } else {
                                listA.add(pl.a(cls2, jSONArray.getJSONObject(i)));
                            }
                        }
                    }
                    return listA;
                }
            } catch (JSONException e) {
                om.a(e);
            }
        }
        return listA;
    }

    private static JSONArray a(Object obj, Type type) {
        JSONArray jSONArrayA = a();
        if (obj != null && obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                for (Object obj2 : objArr) {
                    if (pl.c(cls)) {
                        jSONArrayA.put(obj2);
                    } else if (fd.class.isAssignableFrom(cls)) {
                        jSONArrayA.put(b(obj2));
                    }
                }
            }
        }
        return jSONArrayA;
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            om.a(e);
        }
    }
}
