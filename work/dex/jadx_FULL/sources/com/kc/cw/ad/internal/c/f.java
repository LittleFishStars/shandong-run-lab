package com.kc.cw.ad.internal.c;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38946a = "OCTOPUS_SDK";
    public static String b = f38946a + "-MEDIATION";
    public static String c = f38946a + "-INTERFACE";
    public static String d = f38946a + "-REQUEST";
    public static String e = f38946a + "-RESPONSE";
    public static String f = f38946a + "-PB";
    public static String g = f38946a + "-XML";
    public static String h = f38946a + "-JSON";
    public static String i = f38946a + "-JS";
    public static String j = f38946a + "-MRAID";
    public static String k = f38946a + "-APPBROWSER";
    public static String l = f38946a + "-NATIVE";
    public static String m = f38946a + "-VIDEO";
    public static String n = f38946a + "-FIX";
    public static String o = f38946a + "-PINGER";
    public static String p = f38946a + "-LRUDISKUSAGE";
    public static String q = f38946a + "-CACHESERVER";
    public static String r = f38946a + "-URLSOURCE";
    public static String s = f38946a + "-PROXYCACHE";
    public static String t = f38946a + "-PROXYCACHEUTILS";
    public static String u = f38946a + "-STORAGEUTILS";
    private static SoftReference<Context> v = new SoftReference<>(null);
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static final ArrayList<g> z = new ArrayList<>();

    public static String a(int i2) {
        try {
            Context context = v.get();
            if (context == null) {
                return null;
            }
            return context.getString(i2);
        } catch (Exception e2) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
            return null;
        }
    }

    public static void a() {
        synchronized (f.class) {
            try {
                x = "";
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context) {
        v = new SoftReference<>(context);
    }

    private static void a(g.a aVar, String str, String str2) {
        synchronized (f.class) {
            try {
                a(aVar, str, str2, (Throwable) null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(g.a aVar, String str, String str2, Throwable th) {
        synchronized (f.class) {
            try {
                for (g gVar : z) {
                    if (aVar.ordinal() >= gVar.a().ordinal()) {
                        if (th != null) {
                            gVar.a(aVar, str, str2, th);
                        } else {
                            gVar.a(aVar, str, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(String str) {
        synchronized (f.class) {
            try {
                x = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2) {
        if (str2 != null) {
            a(g.a.V, str, str2);
            a(str, str2, 4, (Throwable) null);
        }
    }

    private static void a(String str, String str2, int i2, Throwable th) {
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 != null) {
            a(g.a.W, str, str2, th);
            a(str, str2, 5, th);
        }
    }

    public static void b(String str, String str2) {
        if (str2 != null) {
            a(g.a.D, str, str2);
            a(str, str2, 4, (Throwable) null);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (str2 != null) {
            a(g.a.E, str, str2, th);
            a(str, str2, 6, th);
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null) {
            a(g.a.I, str, str2);
            a(str, str2, 4, (Throwable) null);
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            a(g.a.W, str, str2);
            a(str, str2, 5, (Throwable) null);
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            a(g.a.E, str, str2);
            a(str, str2, 6, (Throwable) null);
        }
    }
}
