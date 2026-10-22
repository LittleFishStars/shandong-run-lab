package com.fl.saas;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static S0 f30086a;
    private static SharedPreferences b;
    private static SharedPreferences.Editor c;
    private static Context f;
    private static final Set d = new HashSet(0);
    private static String e = "FL_SP";
    public static String g = "APP_DATE";
    public static String h = "app_list_cache";

    private S0() {
        this("FL_SP");
    }

    public Object a(String str, Object obj) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null) {
            return obj;
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public long b(String str) {
        return a(str, 0L);
    }

    public String c(String str) {
        return a(str, "");
    }

    private S0(String str) {
        e = str;
        Log.i("SPUtil", "SPUtil: " + e);
    }

    public static S0 a() {
        if (f30086a == null || !e.equals("FL_SP")) {
            synchronized (S0.class) {
                f30086a = new S0();
            }
        }
        return f30086a;
    }

    public S0 b(String str, Object obj) {
        String string;
        SharedPreferences.Editor editor = c;
        if (editor == null) {
            return f30086a;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else {
                string = obj.toString();
            }
            c.apply();
            return f30086a;
        }
        string = (String) obj;
        editor.putString(str, string);
        c.apply();
        return f30086a;
    }

    public int a(String str) {
        return a(str, 0);
    }

    public S0 b(String str, int i) {
        SharedPreferences.Editor editor = c;
        if (editor == null) {
            return this;
        }
        editor.putInt(str, i).apply();
        return this;
    }

    public int a(String str, int i) {
        SharedPreferences sharedPreferences = b;
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public S0 b(String str, long j) {
        SharedPreferences.Editor editor = c;
        if (editor == null) {
            return f30086a;
        }
        editor.putLong(str, j).apply();
        return f30086a;
    }

    public long a(String str, long j) {
        SharedPreferences sharedPreferences = b;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public S0 b(String str, String str2) {
        SharedPreferences.Editor editor = c;
        if (editor != null) {
            editor.putString(str, str2).apply();
        }
        return f30086a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = b;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    public void a(Context context) {
        a(context, "FL_SP");
    }

    public void a(Context context, String str) {
        f = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(e, 0);
        b = sharedPreferences;
        c = sharedPreferences.edit();
        if (f30086a != null && str.equals(e)) {
            return;
        }
        S0 s0 = new S0(str);
        f30086a = s0;
    }
}
