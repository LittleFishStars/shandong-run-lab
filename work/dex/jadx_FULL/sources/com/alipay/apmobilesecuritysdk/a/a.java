package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25338a;
    private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    private int c = 4;

    public a(Context context) {
        this.f25338a = context;
    }

    public static String a(Context context) {
        try {
            String strB = i.b();
            if (!com.alipay.sdk.m.d0.a.a(strB)) {
                return strB;
            }
            c cVarC = d.c(context);
            if (cVarC != null) {
                i.a(cVarC);
                String str = cVarC.f25342a;
                if (com.alipay.sdk.m.d0.a.b(str)) {
                    return str;
                }
            }
            com.alipay.apmobilesecuritysdk.e.b bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context);
            if (bVarC == null) {
                return "";
            }
            i.a(bVarC);
            String str2 = bVarC.f25341a;
            return com.alipay.sdk.m.d0.a.b(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!com.alipay.sdk.m.d0.a.a(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !com.alipay.sdk.m.d0.a.a(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void a(String str, com.alipay.sdk.m.k0.c cVar, Map<String, String> map) {
        h.a(this.f25338a, cVar.b());
        h.d(this.f25338a, cVar.a());
        h.e(this.f25338a, cVar.g);
        h.a(this.f25338a, cVar.h);
        h.f(this.f25338a, cVar.i);
        h.g(this.f25338a, cVar.k);
        i.c(e.b(this.f25338a, map));
        i.a(str, cVar.d);
        i.b(cVar.c);
        i.d(cVar.j);
        i.e(e(map));
        i.f(d(map));
        i.a();
        d.a(this.f25338a, i.g());
        d.b(this.f25338a);
        com.alipay.apmobilesecuritysdk.e.a.a(this.f25338a, new com.alipay.apmobilesecuritysdk.e.b(i.b(), i.c(), i.f()));
        com.alipay.apmobilesecuritysdk.e.a.a(this.f25338a);
        g.a(this.f25338a, str, i.a(str));
        g.b(this.f25338a, str);
        h.a(this.f25338a, str, System.currentTimeMillis());
    }

    private boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i = 0; i < 3; i++) {
            try {
                String[] strArrSplit = strArr[i].split(" ");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean a(String str) {
        return com.alipay.sdk.m.d0.a.a(a(this.f25338a, str)) || com.alipay.sdk.m.d0.a.a(a(this.f25338a));
    }

    private boolean a(Map<String, String> map, String str) {
        if (a() || com.alipay.apmobilesecuritysdk.common.a.a(this.f25338a)) {
            return a(str);
        }
        e.a();
        if (!com.alipay.sdk.m.d0.a.a(e.b(this.f25338a, map), i.c())) {
            return true;
        }
        String strA = com.alipay.sdk.m.d0.a.a(map, "tid", "");
        String strA2 = com.alipay.sdk.m.d0.a.a(map, "utdid", "");
        if (!com.alipay.sdk.m.d0.a.b(strA) || com.alipay.sdk.m.d0.a.a(strA, i.d())) {
            return (com.alipay.sdk.m.d0.a.b(strA2) && !com.alipay.sdk.m.d0.a.a(strA2, i.e())) || !i.a(this.f25338a, str) || com.alipay.sdk.m.d0.a.a(a(this.f25338a, str)) || com.alipay.sdk.m.d0.a.a(a(this.f25338a));
        }
        return true;
    }

    private int b(Map<String, String> map) {
        String str;
        String strA = com.alipay.sdk.m.d0.a.a(map, "appName", "");
        b();
        b(strA);
        boolean zA = a(map, strA);
        Context context = this.f25338a;
        h.b(context, String.valueOf(com.alipay.sdk.m.f0.b.a(APSecuritySdk.getInstance(context)).m()));
        if (!zA) {
            return 0;
        }
        com.alipay.apmobilesecuritysdk.c.c.a(this.f25338a).b();
        UmidSdkWrapper.startUmidTaskSync(this.f25338a, com.alipay.apmobilesecuritysdk.b.a.a().b());
        com.alipay.sdk.m.k0.c cVarC = c(map);
        int iC = cVarC != null ? cVarC.c() : 2;
        if (iC == 1) {
            a(strA, cVarC, map);
            return 0;
        }
        if (iC == 3) {
            return 1;
        }
        if (cVarC != null) {
            str = "Server error, result:" + cVarC.b;
        } else {
            str = "Server error, returned null";
        }
        com.alipay.apmobilesecuritysdk.c.a.a(str);
        return com.alipay.sdk.m.d0.a.a(a(this.f25338a, strA)) ? 4 : 0;
    }

    public static String b(Context context) {
        String strA = a(context);
        return com.alipay.sdk.m.d0.a.a(strA) ? h.f(context) : strA;
    }

    private static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        a(this.f25338a);
        a(this.f25338a, str);
        i.a();
    }

    private com.alipay.sdk.m.k0.c c(Map<String, String> map) {
        try {
            return com.alipay.sdk.m.i0.d.b(this.f25338a, this.b.c()).a(b.a(this.f25338a, map));
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private String d(Map<String, String> map) {
        String strA = com.alipay.sdk.m.d0.a.a(map, "utdid", "");
        if (!com.alipay.sdk.m.d0.a.b(strA) || com.alipay.sdk.m.d0.a.a(strA, i.e())) {
            return i.e();
        }
        i.f(strA);
        return strA;
    }

    private String e(Map<String, String> map) {
        String strA = com.alipay.sdk.m.d0.a.a(map, "tid", "");
        if (!com.alipay.sdk.m.d0.a.b(strA) || com.alipay.sdk.m.d0.a.a(strA, i.d())) {
            return i.d();
        }
        i.e(strA);
        return strA;
    }

    public int a(Map<String, String> map) {
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f25338a, com.alipay.sdk.m.d0.a.a(map, "tid", ""), com.alipay.sdk.m.d0.a.a(map, "utdid", ""), b(this.f25338a));
            this.c = b(map);
            com.alipay.apmobilesecuritysdk.c.a.a(this.f25338a, com.alipay.sdk.m.i0.d.b(this.f25338a, this.b.c()));
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return this.c;
    }
}
