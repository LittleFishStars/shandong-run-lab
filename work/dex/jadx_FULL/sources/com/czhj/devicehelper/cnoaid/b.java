package com.czhj.devicehelper.cnoaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f29329a = false;
    private static volatile String b;
    private static volatile String c;
    private static volatile String d;
    private static volatile String e;
    private static volatile String f;
    private static volatile String g;
    private static volatile String h;

    private b() {
    }

    public static String a() {
        return a(false);
    }

    public static String a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = a.b(context);
                }
            }
        }
        if (c == null) {
            c = "";
        }
        return c;
    }

    public static String a(boolean z) {
        if (TextUtils.isEmpty(b)) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(b)) {
                    b = z ? a.a() : a.b();
                }
            }
        }
        if (b == null) {
            b = "";
        }
        return b;
    }

    public static void a(Application application) {
        a(application, (e) null);
    }

    public static void a(Application application, e eVar) {
        a(application, false, eVar);
    }

    public static void a(Application application, boolean z) {
        a(application, z, null);
    }

    public static void a(Application application, boolean z, e eVar) {
        if (f29329a || application == null) {
            return;
        }
        synchronized (b.class) {
            if (!f29329a) {
                a.a(application, z, eVar);
                f29329a = true;
            }
        }
    }

    @Deprecated
    public static String b() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = a.e();
                }
            }
        }
        if (f == null) {
            f = "";
        }
        return f;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(d)) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(d)) {
                    d = a.d();
                    if (d == null || d.length() == 0) {
                        a.a(context, new c() { // from class: com.czhj.devicehelper.cnoaid.b.1
                            @Override // com.czhj.devicehelper.cnoaid.c
                            public void a(Exception exc) {
                                String unused = b.d = "";
                            }

                            @Override // com.czhj.devicehelper.cnoaid.c
                            public void a(String str) {
                                String unused = b.d = str;
                            }
                        });
                    }
                }
            }
        }
        if (d == null) {
            d = "";
        }
        return d;
    }

    public static String c() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = a.f();
                }
            }
        }
        if (g == null) {
            g = "";
        }
        return g;
    }

    public static String c(Context context) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = a.c(context);
                }
            }
        }
        if (e == null) {
            e = "";
        }
        return e;
    }

    public static String d(Context context) {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = a.d(context);
                }
            }
        }
        if (h == null) {
            h = "";
        }
        return h;
    }
}
