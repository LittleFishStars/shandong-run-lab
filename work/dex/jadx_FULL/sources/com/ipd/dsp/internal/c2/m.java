package com.ipd.dsp.internal.c2;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m {
    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public static String b(SharedPreferences sharedPreferences, String str, boolean z) {
        try {
            String strB = o.b(str, z);
            if (sharedPreferences.contains(strB)) {
                String string = sharedPreferences.getString(strB, null);
                if (o.c(string)) {
                    return o.a(string, z);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(String str, String str2, String str3, boolean z) {
        return a(a(str), str2, str3, z);
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2, boolean z) {
        if (sharedPreferences != null) {
            String strB = b(sharedPreferences, str, z);
            if (strB != null) {
                return strB;
            }
            try {
                if (sharedPreferences.contains(str)) {
                    String string = sharedPreferences.getString(str, str2);
                    a(sharedPreferences, str, string);
                    return string;
                }
            } catch (Throwable unused) {
            }
        }
        return str2;
    }

    public static int a(SharedPreferences sharedPreferences, String str, int i) {
        if (sharedPreferences != null) {
            String strA = a(sharedPreferences, str);
            if (strA != null) {
                try {
                    return Integer.parseInt(strA);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            try {
                if (sharedPreferences.contains(str)) {
                    int i2 = sharedPreferences.getInt(str, i);
                    a(sharedPreferences, str, Integer.valueOf(i2));
                    return i2;
                }
            } catch (Throwable unused2) {
            }
        }
        return i;
    }

    public static long a(SharedPreferences sharedPreferences, String str, long j) {
        if (sharedPreferences != null) {
            String strA = a(sharedPreferences, str);
            if (strA != null) {
                try {
                    return Long.parseLong(strA);
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
            try {
                if (sharedPreferences.contains(str)) {
                    long j2 = sharedPreferences.getLong(str, j);
                    a(sharedPreferences, str, Long.valueOf(j2));
                    return j2;
                }
            } catch (Throwable unused2) {
            }
        }
        return j;
    }

    public static boolean a(SharedPreferences sharedPreferences, String str, boolean z) {
        if (sharedPreferences != null) {
            String strA = a(sharedPreferences, str);
            if (strA != null) {
                try {
                    return Boolean.parseBoolean(strA);
                } catch (NumberFormatException unused) {
                    return z;
                }
            }
            try {
                if (sharedPreferences.contains(str)) {
                    boolean z2 = sharedPreferences.getBoolean(str, z);
                    a(sharedPreferences, str, Boolean.valueOf(z2));
                    return z2;
                }
            } catch (Throwable unused2) {
            }
        }
        return z;
    }

    public static String a(SharedPreferences sharedPreferences, String str) {
        return b(sharedPreferences, str, true);
    }

    public static void a(String str, HashMap<String, Object> map) {
        a(a(str), map);
    }

    public static void a(SharedPreferences sharedPreferences, HashMap<String, Object> map) {
        if (sharedPreferences == null || map == null || map.isEmpty()) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    a(editorEdit, key, entry.getValue());
                }
            }
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(SharedPreferences sharedPreferences, String str, Object obj) {
        if (sharedPreferences == null || str == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            a(editorEdit, str, obj);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, Object obj) {
        editor.putString(o.d(str), o.d(obj != null ? String.valueOf(obj) : ""));
        editor.remove(str);
    }

    public static SharedPreferences a(String str) {
        try {
            Context context = com.ipd.dsp.internal.l1.a.a().getContext();
            if (context != null) {
                return context.getSharedPreferences(str, 0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
