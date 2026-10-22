package com.kc.cw.ad.d.a;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.internal.c.o;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f38782a = false;
    private static volatile String b = null;
    private static volatile String c = null;
    private static volatile String d = null;
    private static volatile String e = null;
    private static volatile String f = "";
    private static volatile String g = null;
    private static volatile String h = null;
    private static volatile String i = null;
    private static volatile String j = null;
    private static boolean k = true;
    private static boolean l = true;
    private static boolean m = true;

    private b() {
    }

    public static String a(Context context) {
        if (SSAd.getCustomController() != null && !SSAd.getCustomController().isCanUsePhoneState()) {
            c = SSAd.getCustomController().getImei();
        } else if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = a.a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (c == null) {
            c = "";
        }
        return c;
    }

    public static void a(Application application) {
        if (f38782a) {
            return;
        }
        synchronized (b.class) {
            try {
                if (!f38782a) {
                    a.a(application);
                    f38782a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String b(Context context) {
        d = o.b(context, "newOaid");
        if (TextUtils.isEmpty(d) && l) {
            l = false;
            synchronized (b.class) {
                try {
                    if (TextUtils.isEmpty(d)) {
                        com.kc.cw.ad.c.e.a(context, new com.kc.cw.ad.c.d() { // from class: com.kc.cw.ad.d.a.b.1
                            @Override // com.kc.cw.ad.c.d
                            public void a(String str) {
                                String unused = b.d = str;
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(d)) {
                o.a(context, "newOaid", d);
            }
        }
        if (d == null) {
            d = "";
        }
        f.b("Oaid is: " + d);
        return d;
    }

    public static String c(Context context) {
        e = o.b(context, "hoaid");
        if (TextUtils.isEmpty(e) && m) {
            m = false;
            synchronized (b.class) {
                try {
                    if (TextUtils.isEmpty(e)) {
                        e = a.a();
                        if (TextUtils.isEmpty(e)) {
                            a.a(context, new c() { // from class: com.kc.cw.ad.d.a.b.2
                                @Override // com.kc.cw.ad.d.a.c
                                public void a(Exception exc) {
                                }

                                @Override // com.kc.cw.ad.d.a.c
                                public void a(String str) {
                                    String unused = b.e = str;
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(e)) {
                o.a(context, "hoaid", e);
            }
        }
        if (e == null) {
            e = "";
        }
        f.b("Hoaid is: " + e);
        return e;
    }

    public static String d(Context context) {
        j = o.b(context, DeviceIdType.GAID);
        if (TextUtils.isEmpty(j)) {
            if (j == null) {
                j = "";
            } else {
                o.a(context, DeviceIdType.GAID, j);
            }
        }
        f.b("Gaid is: " + j);
        return j;
    }

    public static String e(Context context) {
        if (k) {
            k = false;
            if (SSAd.getCustomController() == null || SSAd.getCustomController().isCanUsePhoneState()) {
                synchronized (b.class) {
                    try {
                        f = a.b(context);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return f;
    }
}
