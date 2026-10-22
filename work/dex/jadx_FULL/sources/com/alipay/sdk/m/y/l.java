package com.alipay.sdk.m.y;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25539a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";

    public static void a(com.alipay.sdk.m.w.a aVar, Context context, String str) {
        try {
            String strA = a(str);
            g.b(com.alipay.sdk.m.n.a.B, "trade token: " + strA);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            m.b(aVar, context, f25539a, strA);
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.I, th);
            g.a(th);
        }
    }

    public static String a(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(b);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].startsWith(c) && strArrSplit[i].endsWith("}")) {
                String str2 = strArrSplit[i];
                String[] strArrSplit2 = str2.substring(8, str2.length() - 1).split("&");
                for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
                    if (strArrSplit2[i2].startsWith(e) && strArrSplit2[i2].endsWith("\"")) {
                        String str3 = strArrSplit2[i2];
                        strSubstring = str3.substring(13, str3.length() - 1);
                        break;
                    }
                    if (strArrSplit2[i2].startsWith(g)) {
                        strSubstring = strArrSplit2[i2].substring(12);
                        break;
                    }
                }
            }
        }
        return strSubstring;
    }

    public static String a(com.alipay.sdk.m.w.a aVar, Context context) {
        String strA = m.a(aVar, context, f25539a, "");
        g.b(com.alipay.sdk.m.n.a.B, "get trade token: " + strA);
        return strA;
    }
}
