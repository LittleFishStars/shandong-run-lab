package com.baidu.sec.privacy.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.sec.privacy.f.c;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f26807a = false;
    public static String b = "";
    public static String c = "";

    public static boolean a() {
        try {
            SharedPreferences sharedPreferencesC = c();
            if (sharedPreferencesC == null) {
                sharedPreferencesC = com.baidu.sec.privacy.b.b.a().getSharedPreferences("leroadcfg", 0);
            }
            return sharedPreferencesC.getBoolean("s_a_pl", false);
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        Method method;
        try {
            if (f26807a) {
                return true;
            }
            if (com.baidu.sec.privacy.b.b.d()) {
                com.baidu.sec.privacy.c cVarC = com.baidu.sec.privacy.b.b.c();
                if (cVarC != null) {
                    f26807a = cVarC.a();
                }
                return f26807a;
            }
            com.baidu.sec.privacy.a aVarB = com.baidu.sec.privacy.b.b.b();
            if (aVarB != null) {
                boolean zA = aVarB.a();
                f26807a = zA;
                return zA;
            }
            try {
                Class<?> cls = Class.forName("com.baidu." + str + ".ac.F");
                Object objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
                Method[] declaredMethods = Class.forName("com.baidu." + str + ".ac.FI").getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i];
                    if (com.alipay.sdk.m.m.b.m.equals(method.getName())) {
                        break;
                    }
                    i++;
                }
                if (method == null) {
                    f26807a = a();
                } else {
                    f26807a = ((Boolean) method.invoke(objInvoke, com.baidu.sec.privacy.b.b.a())).booleanValue();
                }
            } catch (Throwable unused) {
                f26807a = a();
            }
        } catch (Throwable th) {
            c.a(th);
        }
        return f26807a;
    }

    public static SharedPreferences c() {
        return a("getPlatformSharedSharedPreferences");
    }

    public static String a(String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                sharedPreferencesB = com.baidu.sec.privacy.b.b.a().getSharedPreferences(c, 0);
            }
            sharedPreferencesB.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            return sharedPreferencesB.getString(b, "");
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    public static void a(String str, boolean z, com.baidu.sec.privacy.c cVar) {
        try {
            if (!z) {
                if ("sofire".equals(str)) {
                    str = "";
                }
                c = "leroad" + str + "cfg";
                b = "p_s_p_c";
            } else {
                if (cVar == null) {
                    return;
                }
                c = cVar.b();
                b = cVar.c();
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static SharedPreferences a(String str) {
        try {
            return (SharedPreferences) F.class.getDeclaredMethod(str, Context.class).invoke(F.class.getDeclaredMethod("getInstance", new Class[0]).invoke(F.class, new Object[0]), com.baidu.sec.privacy.b.b.a());
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static SharedPreferences b() {
        return a("getPlatformPrivateSharedPreferences");
    }
}
