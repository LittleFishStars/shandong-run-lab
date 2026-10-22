package com.alibaba.ariver.commonability.core.util;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f23948a;
    private static LruCache<String, Uri> b = new LruCache<>(20);

    private static void a(Context context) {
        try {
            if (f23948a == 0.0f) {
                f23948a = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean b(Context context) {
        return a(context, 0);
    }

    public static boolean contains(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) ? false : true;
    }

    public static int dip2px(Context context, float f) {
        a(context);
        return (int) ((f * f23948a) + 0.5f);
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        return ((Float) getValue(jSONObject, str, Float.valueOf(f))).floatValue();
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, 0);
    }

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, 0L);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        T t2;
        if (bundle == null) {
            return t;
        }
        try {
            return (TextUtils.isEmpty(str) || t == null || !bundle.containsKey(str) || (t2 = (T) bundle.get(str)) == null || !t.getClass().isAssignableFrom(t2.getClass())) ? t : t2;
        } catch (Exception unused) {
            return t;
        }
    }

    public static boolean isAppPermissionOPen(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
        }
    }

    public static Uri parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = b.get(str);
        if (uri != null) {
            return uri;
        }
        try {
            uri = Uri.parse(str);
            b.put(str, uri);
            return uri;
        } catch (Exception unused) {
            return uri;
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        return ((Integer) getValue(jSONObject, str, Integer.valueOf(i))).intValue();
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        return ((Long) getValue(jSONObject, str, Long.valueOf(j))).longValue();
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(jSONObject, str, str2);
    }

    private static boolean a(Context context, int i) {
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null) {
                return false;
            }
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOp", cls2, cls2, String.class);
            return method != null && ((Integer) method.invoke(systemService, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0L);
    }

    public static long getLong(Bundle bundle, String str, long j) {
        return ((Long) getValue(bundle, str, Long.valueOf(j))).longValue();
    }

    public static <T> T getValue(JSONObject jSONObject, String str, T t) {
        T t2;
        return (jSONObject == null || jSONObject.isEmpty() || t == null || !jSONObject.containsKey(str) || (t2 = (T) jSONObject.get(str)) == null || !t.getClass().isAssignableFrom(t2.getClass())) ? t : t2;
    }
}
