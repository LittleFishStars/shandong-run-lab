package com.byazt.ti;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.dna.nu;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2161, 54})
public class ve {
    public static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> c;

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void c(String str, String str2, T t) {
        SharedPreferences sharedPreferencesVe = ve(str);
        if (sharedPreferencesVe == null) {
            return;
        }
        if (t.equals(ve(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesVe.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        tt(str, str2, t);
    }

    private static void n(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = c;
        if (softReference == null || softReference.get() == null || (map = c.get().get(uj(str))) == null) {
            return;
        }
        map.clear();
    }

    private static void tt(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = c;
        if (softReference == null || softReference.get() == null) {
            c = new SoftReference<>(new ConcurrentHashMap());
        }
        String strUj = uj(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = c.get();
        if (concurrentHashMap.get(strUj) == null) {
            concurrentHashMap.put(strUj, new HashMap());
        }
        concurrentHashMap.get(strUj).put(str2, obj);
    }

    private static String uj(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static SharedPreferences ve(String str) {
        return ((nu) com.byazt.ut.uj.getService("kv_store_factory")).get(uj(str));
    }

    private static Object ve(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = c;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(uj(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String ve(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe == null ? str3 : sharedPreferencesVe.getString(str2, str3);
    }

    private static Object tt(String str, String str2, String str3) {
        String strUj = uj(str);
        if (!c(strUj, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
            return ve(strUj, str2, null);
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(c(strUj, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(c(strUj, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(c(strUj, str2, 0L));
        }
        if (str3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(c(strUj, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return ve(strUj, str2, null);
        }
        return null;
    }

    public static String c(String str, String str2, String str3) {
        Object objVe = ve(str, str2);
        if (objVe != null) {
            return String.valueOf(objVe);
        }
        Object objTt = tt(str, str2, str3);
        tt(str, str2, objTt);
        return String.valueOf(objTt);
    }

    public static void tt(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesVe = ve(str);
            if (sharedPreferencesVe == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesVe.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = c;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strUj = uj(str);
            if (!TextUtils.isEmpty(strUj) && (map = c.get().get(strUj)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = c;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                c.get().put(strUj, map);
            }
        } catch (Throwable unused) {
        }
    }

    private static int c(String str, String str2, int i) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe == null ? i : sharedPreferencesVe.getInt(str2, i);
    }

    private static float c(String str, String str2, float f) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe == null ? f : sharedPreferencesVe.getFloat(str2, f);
    }

    private static boolean c(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe == null ? z : sharedPreferencesVe.getBoolean(str2, z);
    }

    private static long c(String str, String str2, long j) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe == null ? j : sharedPreferencesVe.getLong(str2, j);
    }

    public static boolean c(String str, String str2) {
        SharedPreferences sharedPreferencesVe = ve(str);
        return sharedPreferencesVe != null && sharedPreferencesVe.contains(str2);
    }

    public static void c(String str) {
        SharedPreferences.Editor editorEdit = ve(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        n(str);
    }

    public static Map<String, ?> tt(String str) {
        return ve(str).getAll();
    }
}
