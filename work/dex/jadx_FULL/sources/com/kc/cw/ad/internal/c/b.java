package com.kc.cw.ad.internal.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huawei.hms.adapter.internal.CommonCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38936a = "ethernet";
    public static int b = 2;
    private static DisplayMetrics c;

    public static void a(Context context) {
        a aVarA = a.a();
        if (TextUtils.isEmpty(aVarA.c)) {
            try {
                b(context, aVarA);
                c(context, aVarA);
                a(context, aVarA);
                aVarA.a(context);
                aVarA.w = com.kc.cw.ad.d.b.i.j(context);
                aVarA.x = com.kc.cw.ad.d.b.i.k(context);
                aVarA.y = com.kc.cw.ad.d.b.i.e();
                aVarA.z = com.kc.cw.ad.d.b.i.l(context);
                aVarA.A = com.kc.cw.ad.d.b.i.m(context);
                aVarA.B = com.kc.cw.ad.d.b.i.n(context);
                aVarA.C = com.kc.cw.ad.d.b.i.o(context);
                aVarA.D = com.kc.cw.ad.d.b.i.p(context);
                aVarA.E = com.kc.cw.ad.d.b.i.d(context, "com.tencent.mm");
                aVarA.F = com.kc.cw.ad.d.b.i.b(context);
            } catch (Throwable th) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    private static void a(Context context, a aVar) {
        String str = (String) o.b(context, a.b, "");
        aVar.c = str;
        if (TextUtils.isEmpty(str)) {
            aVar.b(context);
        }
    }

    public static DisplayMetrics b(Context context) {
        if (c == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            c = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(c);
        }
        return c;
    }

    private static void b(Context context, a aVar) {
        try {
            aVar.i = ((TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getPhoneType() != 0 ? com.kc.cw.ad.a.g.b.DEVICE_PHONE : com.kc.cw.ad.a.g.b.DEVICE_FLAT;
        } catch (SecurityException unused) {
            f.e(f.f38946a, "No permission to access imei");
            int i = context.getResources().getConfiguration().screenLayout & 15;
            aVar.i = (i == 4 || i == 3) ? com.kc.cw.ad.a.g.b.DEVICE_FLAT : com.kc.cw.ad.a.g.b.DEVICE_PHONE;
        }
        aVar.e = com.kc.cw.ad.d.b.i.b();
        aVar.f = com.kc.cw.ad.d.b.i.g();
        aVar.g = com.kc.cw.ad.d.b.i.q(context);
    }

    private static void c(Context context, a aVar) {
        String strB = o.b(context, CommonCode.MapKey.HAS_RESOLUTION);
        String strB2 = o.b(context, "screenSize");
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strB2)) {
            DisplayMetrics displayMetricsB = b(context);
            String str = displayMetricsB.widthPixels + LoginConstants.UNDER_LINE + displayMetricsB.heightPixels;
            float f = displayMetricsB.heightPixels / displayMetricsB.ydpi;
            float f2 = displayMetricsB.widthPixels / displayMetricsB.xdpi;
            double dSqrt = Math.sqrt((f2 * f2) + (f * f));
            double dPow = Math.pow(10.0d, b);
            String str2 = String.format(Locale.US, "%.2f", Double.valueOf(Math.round(dSqrt * dPow) / dPow));
            o.a(context, CommonCode.MapKey.HAS_RESOLUTION, str);
            o.a(context, "screenSize", str2);
            strB2 = str2;
            strB = str;
        }
        aVar.m = strB;
        aVar.n = strB2;
    }
}
