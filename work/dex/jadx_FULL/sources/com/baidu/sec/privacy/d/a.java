package com.baidu.sec.privacy.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sec.privacy.f.c;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f26805a = null;
    public static boolean b = true;
    public static SharedPreferences c = null;
    public static SharedPreferences.Editor d = null;
    public static String e = "sofire";
    public static HashSet<Integer> f = new HashSet<>();
    public static HashSet<Integer> g = new HashSet<>();
    public static boolean h = true;
    public static SharedPreferences.OnSharedPreferenceChangeListener i = new SharedPreferencesOnSharedPreferenceChangeListenerC0288a();

    /* JADX INFO: renamed from: com.baidu.sec.privacy.d.a$a, reason: collision with other inner class name */
    public class SharedPreferencesOnSharedPreferenceChangeListenerC0288a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: com.baidu.sec.privacy.d.a$a$a, reason: collision with other inner class name */
        public class RunnableC0289a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SharedPreferences f26806a;
            public final /* synthetic */ String b;

            public RunnableC0289a(SharedPreferencesOnSharedPreferenceChangeListenerC0288a sharedPreferencesOnSharedPreferenceChangeListenerC0288a, SharedPreferences sharedPreferences, String str) {
                this.f26806a = sharedPreferences;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.c(this.f26806a.getString(this.b, ""));
            }
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (b.b.equals(str)) {
                new Thread(new RunnableC0289a(this, sharedPreferences, str)).start();
            }
        }
    }

    public static boolean a() {
        return b;
    }

    public static void b(String str) {
        try {
            SharedPreferences sharedPreferences = com.baidu.sec.privacy.b.b.a().getSharedPreferences("prv_config", 0);
            c = sharedPreferences;
            d = sharedPreferences.edit();
            e = str;
            c(b.a(str, i));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void c(String str) {
        try {
            f26805a = null;
            f.clear();
            g.clear();
            h = true;
            try {
                f26805a = new JSONObject(str);
            } catch (Throwable unused) {
                f26805a = new JSONObject();
            }
            c();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static boolean a(int i2) {
        try {
            return g.contains(Integer.valueOf(i2));
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String a(String str, String str2) {
        try {
            String string = c.getString(str, str2);
            if (TextUtils.isEmpty(string)) {
                return str2;
            }
            try {
                return com.baidu.sec.privacy.f.a.a(string);
            } catch (Exception unused) {
                return str2;
            }
        } catch (Throwable th) {
            c.a(th);
            return str2;
        }
    }

    public static boolean b(int i2) {
        try {
            if (b.b(e)) {
                return !f.contains(Integer.valueOf(i2));
            }
            return false;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static boolean a(String str) {
        return c.contains(str);
    }

    public static long a(String str, long j) {
        return c.getLong(str, j);
    }

    public static void c() {
        if (f26805a.optInt("0", 1) == 1) {
            b = true;
        } else {
            b = false;
        }
        JSONArray jSONArrayOptJSONArray = f26805a.optJSONArray("1");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    f.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i2)));
                } catch (JSONException unused) {
                }
            }
        }
        JSONArray jSONArrayOptJSONArray2 = f26805a.optJSONArray("3");
        if (jSONArrayOptJSONArray2 != null) {
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                    g.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i3)));
                } catch (JSONException unused2) {
                }
            }
        }
        if (f26805a.optInt("4", 1) == 1) {
            h = true;
        } else {
            h = false;
        }
    }

    public static int a(String str, int i2) {
        return c.getInt(str, i2);
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            d.putString(str, com.baidu.sec.privacy.f.a.a(str2.getBytes()));
            d.putLong(str + "la_in", System.currentTimeMillis());
            d.commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void b(String str, int i2) {
        try {
            d.putInt(str, i2);
            d.putLong(str + "la_in", System.currentTimeMillis());
            d.commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static boolean b() {
        return h;
    }
}
