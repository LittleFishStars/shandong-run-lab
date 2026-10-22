package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.push.g.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f37908a;

    private b() {
    }

    public static synchronized b a() {
        if (f37908a == null) {
            f37908a = new b();
        }
        return f37908a;
    }

    public static boolean b() {
        try {
            Bundle bundle = n.b(com.igexin.push.core.e.l).metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if ("PUSH_DOMAIN".equals(str)) {
                        com.igexin.c.a.c.a.b(h.f37913a, "PUSH_DOMAIN:" + bundle.getString(str));
                        String string = bundle.getString(str);
                        SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + string + ":5224"});
                        StringBuilder sb = new StringBuilder("XFR_ADDRESS_IPS:");
                        sb.append(SDKUrlConfig.getXfrAddress()[0]);
                        com.igexin.c.a.c.a.b(h.f37913a, sb.toString());
                        SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + string + ":5224"};
                        StringBuilder sb2 = new StringBuilder("XFR_ADDRESS_IPS_BAK:");
                        sb2.append(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                        SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"https://bi." + string + "/api.php"};
                        StringBuilder sb3 = new StringBuilder("BI_ADDRESS_IPS:");
                        sb3.append(SDKUrlConfig.BI_ADDRESS_IPS[0]);
                        com.igexin.c.a.c.a.b(h.f37913a, sb3.toString());
                        SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"https://config." + string + "/api.php"};
                        StringBuilder sb4 = new StringBuilder("CONFIG_ADDRESS_IPS:");
                        sb4.append(SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
                        com.igexin.c.a.c.a.b(h.f37913a, sb4.toString());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new Object[0]);
        }
        return true;
    }

    private static String c() {
        return null;
    }

    private static int d() {
        return 0;
    }
}
