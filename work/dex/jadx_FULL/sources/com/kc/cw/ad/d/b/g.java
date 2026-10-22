package com.kc.cw.ad.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.internal.c.o;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {
    public static String a() {
        if (SSAd.getCustomController() == null) {
            return "";
        }
        String oaid = SSAd.getCustomController().getOaid();
        if (TextUtils.isEmpty(oaid)) {
            return "";
        }
        com.kc.cw.ad.d.a.f.b("Oaid is Outside Input: " + oaid);
        return oaid;
    }

    public static String a(Context context) {
        String strB;
        return (context == null || (strB = com.kc.cw.ad.d.a.b.b(context)) == null) ? "" : strB;
    }

    public static String b(Context context) {
        String strC;
        if (context != null) {
            return ((SSAd.getCustomController() == null || SSAd.getCustomController().isCanUseOaid()) && (strC = com.kc.cw.ad.d.a.b.c(context)) != null) ? strC : "";
        }
        return "";
    }

    public static String c(Context context) {
        String str;
        return (context == null || SSAd.isLimitPersonalAds() || (str = (String) o.c(context, "__GAID__", com.kc.cw.ad.d.a.b.d(context))) == null) ? "" : str;
    }
}
