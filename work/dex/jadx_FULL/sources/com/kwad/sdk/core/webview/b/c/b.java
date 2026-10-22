package com.kwad.sdk.core.webview.b.c;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static final Map<String, JSONObject> bcU = new HashMap();
    public static boolean bcV = true;

    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i) {
        com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.bgG).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Re())));
    }

    public static void ah(String str, String str2) {
        ac.putValue(fR(str), "c_" + str2, System.currentTimeMillis());
    }

    private static void ai(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void aj(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains(WVNativeCallbackUtil.SEPERATER)) {
            str3 = str3.substring(str3.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
        }
        ac.putValue(fR(str), "c_responseStart_" + str2 + LoginConstants.UNDER_LINE + str3, System.currentTimeMillis());
    }

    public static void e(String str, String str2, String str3) {
        if (str3.contains(WVNativeCallbackUtil.SEPERATER)) {
            str3 = str3.substring(str3.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
        }
        ac.putValue(fR(str), "c_responseEnd_" + str2 + LoginConstants.UNDER_LINE + str3, System.currentTimeMillis());
    }

    private static JSONObject fR(String str) {
        Map<String, JSONObject> map = bcU;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void fS(String str) {
        bcU.remove(str);
    }

    public static void fT(String str) {
        JSONObject jSONObjectFR = fR(str);
        long jWN = com.kwad.sdk.core.webview.b.a.PH().wN();
        long jCurrentTimeMillis = jWN <= 0 ? -1L : System.currentTimeMillis() - jWN;
        ac.putValue(jSONObjectFR, "c_loadUrl", System.currentTimeMillis());
        ac.putValue(jSONObjectFR, "c_init_interval", jCurrentTimeMillis);
        ac.putValue(jSONObjectFR, "c_init_state", bcV ? 1 : 2);
        bcV = false;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i, int i2, String str) {
        com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.bgG).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Re())).setFailReason(str));
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        String str4 = i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG;
        if (j > 60000 || j < 0) {
            j = -1;
        }
        com.kwad.sdk.commercial.c.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf(j)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject jSONObjectFR = fR(str2);
        ac.putValue(jSONObjectFR, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int iOptInt = jSONObject.optInt("status");
                String strOptString = jSONObject.optString("errorMsg", "");
                String strOptString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectFR.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (iOptInt == 1) {
                        ai(str, str2);
                    } else {
                        aj(str, strOptString);
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            } finally {
                fS(str2);
            }
        }
    }

    private static void a(String str, String str2, int i, String str3) {
        long jCurrentTimeMillis;
        JSONObject jSONObject = bcU.get(str2);
        if (jSONObject == null) {
            jCurrentTimeMillis = -3;
        } else {
            long jOptLong = jSONObject.optLong("c_loadUrl");
            if (jOptLong <= 0) {
                jCurrentTimeMillis = -2;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis() - jOptLong;
                if (jCurrentTimeMillis > 100000 || jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = -1;
                }
            }
        }
        com.kwad.sdk.commercial.c.a(i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(jCurrentTimeMillis)).setFailReason(str3));
        fS(str2);
    }
}
