package com.kc.cw.ad.internal.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.kc.cw.ad.utils.OctUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    private static a G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38935a = "SDK_UID_KEY";
    public static String b = "SDK_UID_KEY_NEW";
    public static String o;
    public static String p;
    public static String u;
    public static String v;
    public String A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public String F;
    public String e;
    public boolean f;
    public boolean g;
    public String s;
    public String t;
    public String w;
    public String x;
    public String y;
    public String z;
    public String c = null;
    public boolean d = false;
    public final String h = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
    public com.kc.cw.ad.a.g.b i = com.kc.cw.ad.a.g.b.DEVICE_OTHER;
    public final String j = Build.BRAND;
    public final String k = Build.MODEL;
    public final String l = Build.MANUFACTURER;
    public String m = null;
    public String n = null;
    public final String q = Locale.getDefault().getLanguage();
    public final String r = Locale.getDefault().getCountry();

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (G == null) {
                    G = new a();
                    f.a(f.f38946a, f.a(R.string.init));
                    Context context = com.kc.cw.ad.internal.q.a().s;
                    if (context != null) {
                        String strB = o.b(context, "density");
                        o = strB;
                        if (TextUtils.isEmpty(strB)) {
                            String str = context.getResources().getDisplayMetrics().density + "";
                            o = str;
                            o.a(context, "density", str);
                        }
                        String strB2 = o.b(context, "ppi");
                        p = strB2;
                        if (TextUtils.isEmpty(strB2)) {
                            String str2 = context.getResources().getDisplayMetrics().densityDpi + "";
                            p = str2;
                            o.a(context, "ppi", str2);
                        }
                        u = com.kc.cw.ad.d.b.i.i(context);
                        v = com.kc.cw.ad.d.b.i.c();
                    }
                }
                aVar = G;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private String b() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }

    private String c() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    public void a(Context context) {
        String bootMark;
        try {
            int iB = o.b(context, "SystemMarkStatus", 0);
            com.kc.cw.ad.d.b.f.c("OctopusAd", "getMarks status= " + iB);
            int i = 1;
            if (iB == 1) {
                o.a(context, "SystemMarkStatus", 3);
                o.a(context, "SystemMarkStatusExpireTime", Long.valueOf(System.currentTimeMillis()));
                iB = 3;
            }
            if (iB == 0 || iB == 2) {
                o.a(context, "SystemMarkStatus", 1);
            } else {
                i = iB;
            }
            if (i == 3) {
                Long l = (Long) o.b(context, "SystemMarkStatusExpireTime", Long.valueOf(Long.parseLong("0")));
                if (l == null || l.longValue() == 0 || System.currentTimeMillis() - l.longValue() <= 2592000000L) {
                    return;
                }
                o.a(context, "SystemMarkStatus", 0);
                o.a(context, "SystemMarkStatusExpireTime", Long.valueOf(Long.parseLong("0")));
                com.kc.cw.ad.d.b.f.a("OctopusAd", "bootMark expireTime= null and status = 0");
                return;
            }
            if (com.kc.cw.ad.internal.q.a().e && (bootMark = OctUtil.a().getBootMark()) != null) {
                this.s = bootMark.substring(0, Math.min(36, bootMark.length()));
            }
            this.t = OctUtil.a().getUpdateMark();
            o.a(context, "SystemMarkStatus", 2);
            com.kc.cw.ad.d.b.f.c("OctopusAd", "bootMark = " + this.s + ",updateMark = " + this.t);
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public void b(Context context) {
        String strC = c();
        String strB = b();
        String str = p.b(this.j + LoginConstants.UNDER_LINE + this.k + LoginConstants.UNDER_LINE + com.kc.cw.ad.d.b.i.d(context) + LoginConstants.UNDER_LINE + 1 + LoginConstants.UNDER_LINE + strC + LoginConstants.UNDER_LINE + strB) + LoginConstants.UNDER_LINE + 1 + LoginConstants.UNDER_LINE + strC + LoginConstants.UNDER_LINE + strB;
        this.c = str;
        o.a(context, b, str);
    }
}
