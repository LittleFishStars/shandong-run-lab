package com.zj.adlib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f40801a = 0;
    public static final byte b = 1;
    public static final byte c = 2;
    public static final byte d = 3;
    public static final byte e = 4;
    public static final byte f = 5;
    public static final byte g = 6;

    public bp4() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T A(String str, String str2, T t, byte b2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            try {
                return (T) B(new JSONObject(str), str2, t, b2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T B(JSONObject jSONObject, String str, T t, byte b2) {
        T t2;
        if (jSONObject != null && str != null && str.length() != 0) {
            try {
                if (b2 == 0) {
                    t2 = (T) Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (b2 == 1) {
                    t2 = (T) Integer.valueOf(jSONObject.getInt(str));
                } else if (b2 == 2) {
                    t2 = (T) Long.valueOf(jSONObject.getLong(str));
                } else if (b2 == 3) {
                    t2 = (T) Double.valueOf(jSONObject.getDouble(str));
                } else if (b2 == 4) {
                    t2 = (T) jSONObject.getString(str);
                } else if (b2 == 5) {
                    t2 = (T) jSONObject.getJSONObject(str);
                } else if (b2 == 6) {
                    t2 = (T) jSONObject.getJSONArray(str);
                }
                return t2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return t;
    }

    public static String a(String str) {
        return b(str, 4);
    }

    public static String b(String str, int i) {
        try {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '{') {
                    return new JSONObject(str).toString(i);
                }
                if (cCharAt == '[') {
                    return new JSONArray(str).toString(i);
                }
                if (!Character.isWhitespace(cCharAt)) {
                    return str;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static boolean c(String str, String str2) {
        return d(str, str2, false);
    }

    public static boolean d(String str, String str2, boolean z) {
        return ((Boolean) A(str, str2, Boolean.valueOf(z), (byte) 0)).booleanValue();
    }

    public static boolean e(JSONObject jSONObject, String str) {
        return f(jSONObject, str, false);
    }

    public static boolean f(JSONObject jSONObject, String str, boolean z) {
        return ((Boolean) B(jSONObject, str, Boolean.valueOf(z), (byte) 0)).booleanValue();
    }

    public static double g(String str, String str2) {
        return h(str, str2, -1.0d);
    }

    public static double h(String str, String str2, double d2) {
        return ((Double) A(str, str2, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static double i(JSONObject jSONObject, String str) {
        return j(jSONObject, str, -1.0d);
    }

    public static double j(JSONObject jSONObject, String str, double d2) {
        return ((Double) B(jSONObject, str, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static int k(String str, String str2) {
        return l(str, str2, -1);
    }

    public static int l(String str, String str2, int i) {
        return ((Integer) A(str, str2, Integer.valueOf(i), (byte) 1)).intValue();
    }

    public static int m(JSONObject jSONObject, String str) {
        return n(jSONObject, str, -1);
    }

    public static int n(JSONObject jSONObject, String str, int i) {
        return ((Integer) B(jSONObject, str, Integer.valueOf(i), (byte) 1)).intValue();
    }

    public static JSONArray o(String str, String str2, JSONArray jSONArray) {
        return (JSONArray) A(str, str2, jSONArray, (byte) 6);
    }

    public static JSONArray p(JSONObject jSONObject, String str, JSONArray jSONArray) {
        return (JSONArray) B(jSONObject, str, jSONArray, (byte) 6);
    }

    public static JSONObject q(String str, String str2, JSONObject jSONObject) {
        return (JSONObject) A(str, str2, jSONObject, (byte) 5);
    }

    public static JSONObject r(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        return (JSONObject) B(jSONObject, str, jSONObject2, (byte) 5);
    }

    public static long s(String str, String str2) {
        return t(str, str2, -1L);
    }

    public static long t(String str, String str2, long j) {
        return ((Long) A(str, str2, Long.valueOf(j), (byte) 2)).longValue();
    }

    public static long u(JSONObject jSONObject, String str) {
        return v(jSONObject, str, -1L);
    }

    public static long v(JSONObject jSONObject, String str, long j) {
        return ((Long) B(jSONObject, str, Long.valueOf(j), (byte) 2)).longValue();
    }

    public static String w(String str, String str2) {
        return x(str, str2, "");
    }

    public static String x(String str, String str2, String str3) {
        return (String) A(str, str2, str3, (byte) 4);
    }

    public static String y(JSONObject jSONObject, String str) {
        return z(jSONObject, str, "");
    }

    public static String z(JSONObject jSONObject, String str, String str2) {
        return (String) B(jSONObject, str, str2, (byte) 4);
    }
}
