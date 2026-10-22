package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.sdk.m.d0.a;
import com.alipay.sdk.m.g0.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UmidSdkWrapper {
    private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    private static final String UMIDTOKEN_KEY_NAME = "umidtk";
    private static volatile String cachedUmidToken = "";
    private static volatile boolean initUmidFinished = false;

    private static String compatUmidBug(Context context, String str) {
        if (!a.a(str) && !a.a(str, "000000000000000000000000")) {
            return str;
        }
        String utdid = UtdidWrapper.getUtdid(context);
        if (utdid != null && utdid.contains("?")) {
            utdid = "";
        }
        return a.a(utdid) ? "" : utdid;
    }

    public static synchronized String getSecurityToken(Context context) {
        return cachedUmidToken;
    }

    public static String startUmidTaskSync(Context context, int i) {
        return "";
    }

    private static synchronized void updateLocalUmidToken(Context context, String str) {
        if (a.b(str)) {
            d.a(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
            cachedUmidToken = str;
        }
    }
}
