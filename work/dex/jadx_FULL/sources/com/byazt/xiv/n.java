package com.byazt.xiv;

import android.text.TextUtils;
import com.byazt.bzd.u;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1883, 46})
public class n {
    public static String c;
    public static String tt;
    public static int uj;
    public static String ve;

    public static String a() {
        if (!TextUtils.isEmpty(tt)) {
            return tt;
        }
        try {
            Object objInvoke = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                tt = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void c() {
        if (tt() && x.m().or() && uj()) {
            x.m().qp();
        }
    }

    public static int i() {
        if (uj == 0) {
            uj = u.ve("com.byted.mixed");
        }
        return uj;
    }

    public static int n() {
        try {
            JSONObject jSONObjectJc = gt.tt().jc();
            if (jSONObjectJc != null) {
                return jSONObjectJc.optInt("load_pl_conf", 0);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String sp() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        try {
            Object objInvoke = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                c = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean tt() {
        return p.uj >= 7000;
    }

    public static boolean uj() {
        JSONObject jSONObjectJc = gt.tt().jc();
        return jSONObjectJc == null || jSONObjectJc.optInt("can_req_plugin", 1) == 1;
    }

    public static boolean ve() {
        return p.uj >= 7300;
    }

    public static String x() {
        if (!TextUtils.isEmpty(ve)) {
            return ve;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                ve = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int tt(String str) {
        try {
            c cVar = (c) com.byazt.ut.uj.getService("adapter_dex");
            if (cVar == null) {
                return -1;
            }
            Map<String, Map<String, Object>> adnStatusMap = cVar.getAdnStatusMap();
            if (adnStatusMap == null) {
                return 0;
            }
            Map<String, Object> map = adnStatusMap.get("common_dex");
            int iIntValue = map != null ? ((Integer) map.get("dex_status")).intValue() : 0;
            Map<String, Object> map2 = str == null ? null : adnStatusMap.get(str);
            return iIntValue + (map2 != null ? ((Integer) map2.get("dex_status")).intValue() : 0);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int ve(String str) {
        try {
            JSONObject jSONObjectJc = gt.tt().jc();
            if (jSONObjectJc != null) {
                return jSONObjectJc.optInt(str, 0);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = ve("use_dex_load_".concat(String.valueOf(str))) == 1;
        "gdt".equals(str);
        return z;
    }

    public static void c(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c cVar = (c) com.byazt.ut.uj.getService("adapter_dex");
            if (cVar != null) {
                Map<String, Map<String, Object>> adnStatusMap = cVar.getAdnStatusMap();
                Map<String, Object> concurrentHashMap = adnStatusMap.get(str);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    adnStatusMap.put(str, concurrentHashMap);
                } else {
                    Object obj = concurrentHashMap.get(str2);
                    int iIntValue = obj == null ? 0 : ((Integer) obj).intValue();
                    if (iIntValue != 0 && iIntValue >= i) {
                        return;
                    }
                }
                concurrentHashMap.put(str2, Integer.valueOf(i));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, int i) {
        c("common_dex", str, i);
    }
}
