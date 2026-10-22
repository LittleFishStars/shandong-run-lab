package com.byazt.aas;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 145})
public class my {
    public static volatile String c;
    public static volatile long tt;

    public static String c() {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getNewIpAddrs(false)[0];
    }

    public static String tt() {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getNewIpAddrs(false)[1];
    }

    public static String ve() {
        Map<String, String> ipInfoMap = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getIpInfoMap(false);
        String str = ipInfoMap != null ? ipInfoMap.get("zaid_ipv6") : null;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static JSONArray c(com.byazt.dna.c cVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> ipInfoMap = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getIpInfoMap(false);
            if (ipInfoMap == null) {
                return jSONArray;
            }
            String str = ipInfoMap.get("register_ipv6");
            return !TextUtils.isEmpty(str) ? new JSONArray(str) : jSONArray;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return jSONArray;
        }
    }

    public static String tt(String str) {
        if (!TextUtils.isEmpty(c) && !DeviceUtils.c(tt, 1800000L)) {
            return c;
        }
        String strVe = com.byazt.by.uj.c().ve("dev14", 1800000L);
        if (TextUtils.isEmpty(strVe)) {
            if (str == null) {
                str = c();
            }
            c = str;
        } else {
            c = com.byazt.nr.c.ve(strVe);
        }
        tt = System.currentTimeMillis();
        return c;
    }

    public static String[] c(boolean z, com.byazt.dna.c cVar) {
        String[] strArr = {"", ""};
        try {
            Map<String, String> ipInfoMap = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getIpInfoMap(z);
            if (ipInfoMap != null) {
                strArr[0] = ipInfoMap.get("enc_ipv4");
                strArr[1] = ipInfoMap.get("enc_ipv6");
                return strArr;
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        return strArr;
    }

    public static String[] tt(com.byazt.dna.c cVar) {
        String[] strArr = {"", ""};
        Map<String, String> ipInfoMap = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getIpInfoMap(false);
        if (ipInfoMap != null) {
            strArr[0] = ipInfoMap.get("local_ipv4");
            strArr[1] = ipInfoMap.get("local_ipv6");
        }
        return strArr;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.by.uj.c().ve("dev14", com.byazt.nr.c.tt(str));
        c = str;
        tt = System.currentTimeMillis();
    }
}
