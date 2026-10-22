package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ad {
    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String string = itKeys.next().toString();
            Object objOpt = jSONObject2.opt(string);
            if (objOpt != null) {
                try {
                    if (!jSONObject.has(string)) {
                        jSONObject.put(string, objOpt);
                    } else if (z) {
                        jSONObject.put(string, objOpt);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    arrayList.add(obj);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return arrayList;
    }

    public static <T> List<T> hL(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return h(new JSONArray(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return arrayList;
        }
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        a(jSONObject, jSONObject2, true);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(strOptString) || TextUtils.equals("null", strOptString)) {
                    strOptString = "";
                }
                map.put(next, strOptString);
            }
        } catch (JSONException unused) {
        }
        return map;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        try {
            jSONObject.put(str, f);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        try {
            jSONObject.put(str, (int) b);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (Throwable unused) {
        }
    }
}
