package com.byazt.ukr;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.q;
import com.byazt.nr.m;
import com.byazt.omf.eo;
import com.byazt.omf.gt;
import com.byazt.omf.qy;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 215})
public class yp {
    public static volatile yp c = null;
    public static String tt = "";

    private yp() {
    }

    private boolean tt(com.byazt.qal.tt ttVar) {
        return ttVar == null;
    }

    private static String ve() {
        return new String(Base64.decode("L3NkY2FyZC9Eb3dubG9hZC8uY3NqLw==", 2), StandardCharsets.UTF_8);
    }

    public void a(com.byazt.ee.c cVar) {
        uj(cVar, "show_backup_endcard");
    }

    public void da(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.49
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("type_realtime_feature_cost");
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "type_realtime_feature_cost", true);
    }

    public void i(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.47
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("landingpage_check_info");
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "landingpage_check_info", true);
    }

    public void n(com.byazt.ee.c cVar) {
        uj(cVar, "express_ad_render");
    }

    public void sp(com.byazt.ee.c cVar) {
        ve(cVar, "splash_creative_check");
    }

    public void tt(final String str, String str2) {
        String str3;
        final String str4;
        final String str5;
        final JSONObject jSONObject;
        File[] fileArrListFiles;
        String strOptString = "";
        final String strConcat = (TextUtils.isEmpty(str) || str.startsWith("zeus") || TextUtils.equals("plugin_load_failed", str)) ? str : "zeus_".concat(str);
        JSONObject jSONObject2 = null;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                JSONObject jSONObject3 = new JSONObject(str2);
                try {
                    String strOptString2 = jSONObject3.optString("version_code");
                    try {
                        strOptString = jSONObject3.optString("plugin_package_name");
                        if ("zeus_install_finish".equals(strConcat) && "com.byted.pangle".equals(strOptString)) {
                            tt = tt.c + "," + strOptString2;
                            com.byazt.omf.tt.c().put("plugin_install_msg", tt);
                            boolean zC = com.byazt.xgx.n.c().c(gt.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            jSONObject3.putOpt("sd_per", Boolean.valueOf(zC));
                            File file = new File(ve() + "ins/" + com.byazt.omf.x.m().rl(), strOptString2);
                            boolean zExists = file.exists();
                            jSONObject3.putOpt("is_installed", Boolean.valueOf(zExists));
                            if (zExists && zC) {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null && !strOptString2.isEmpty()) {
                                    for (File file2 : fileArrListFiles) {
                                        if (file2 != null && !TextUtils.equals(file2.getName(), strOptString2)) {
                                            file2.delete();
                                        }
                                    }
                                }
                                str5 = strOptString2;
                                str4 = strOptString;
                                jSONObject = jSONObject3;
                            } else {
                                jSONObject3.putOpt("mkdirs", Boolean.valueOf(file.mkdirs()));
                            }
                            com.byazt.bwm.n.ve(new com.byazt.bwm.sp("plugin_report") { // from class: com.byazt.ukr.yp.53
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a.equals(str)) {
                                        yp.tt(strConcat, jSONObject, str5, str4);
                                        return;
                                    }
                                    JSONObject jSONObject4 = jSONObject;
                                    if (jSONObject4 != null) {
                                        yp.this.c(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                                    }
                                }
                            });
                        }
                    } catch (JSONException unused) {
                    }
                    jSONObject2 = jSONObject3;
                    String str6 = strOptString;
                    strOptString = strOptString2;
                    str3 = str6;
                } catch (JSONException unused2) {
                    str3 = "";
                    jSONObject2 = jSONObject3;
                }
            }
        } catch (JSONException unused3) {
        }
        str4 = str3;
        str5 = strOptString;
        jSONObject = jSONObject2;
        com.byazt.bwm.n.ve(new com.byazt.bwm.sp("plugin_report") { // from class: com.byazt.ukr.yp.53
            @Override // java.lang.Runnable
            public void run() {
                if (!com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a.equals(str)) {
                    yp.tt(strConcat, jSONObject, str5, str4);
                    return;
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    yp.this.c(jSONObject4.optString("scene"), jSONObject, (Throwable) null);
                }
            }
        });
    }

    public void uj(final String str, final String str2) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("lp_monitor").a(str2).tt(str);
            }
        }, "lp_monitor", true);
    }

    public void x(final com.byazt.ee.c cVar) {
        if (cVar == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.14
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return ((com.byazt.qal.tt) cVar.c()).c("app_env").c(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public static yp c() {
        if (c == null) {
            synchronized (yp.class) {
                if (c == null) {
                    c = new yp();
                }
            }
        }
        return c;
    }

    private void uj(final com.byazt.ee.c cVar, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.8
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVar = (com.byazt.qal.tt) cVar.c();
                ttVar.c(str);
                ttVar.c(jCurrentTimeMillis);
                return ttVar;
            }
        }, str, true);
    }

    public static void ve(String str, String str2) {
        String strVe = ve();
        File file = new File(strVe + com.byazt.omf.x.m().rl(), str2);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(strVe + "ins/" + com.byazt.omf.x.m().rl(), str2);
        if (file2.exists()) {
            file2.delete();
        }
        File file3 = new File(com.byazt.nr.sp.c(gt.getContext(), false, null), str);
        if (TextUtils.equals(com.byazt.bzd.n.c(file3), str2)) {
            com.byazt.bzd.n.tt(file3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("version_code", str2);
                jSONObject.putOpt("package_name", str);
            } catch (Exception e) {
                m.tt("StatsLogManager", e);
            }
            c().c("d_d", jSONObject, (Throwable) null);
        }
    }

    public void a(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.44
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("device_qty_compare");
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "device_qty_compare", true);
    }

    public void n(JSONObject jSONObject) {
        c("live_init_start", jSONObject);
    }

    public void sp(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.45
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("device_bytebench");
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "device_bytebench", true);
    }

    public void x(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.46
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("render_timeout_opt");
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "render_timeout_opt", true);
    }

    public void uj(com.byazt.ee.c cVar) {
        ve(cVar, "load_timeout");
    }

    public void uj(JSONObject jSONObject) {
        c("live_init_success", jSONObject);
    }

    public void uj(ic icVar, String str) {
        c(icVar, str, (JSONObject) null);
    }

    public void c(com.byazt.ee.c cVar, String str) {
        tt.ve().c(cVar, str, true);
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("render_backup").tt(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public static void c(SparseArray<Object> sparseArray, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObjectC;
        long j;
        com.byazt.yxi.tt ttVar = new com.byazt.yxi.tt(sparseArray);
        PluginValueSet pluginValueSetUj = ttVar.uj();
        boolean zC = ttVar.c();
        int iTt = ttVar.tt();
        String strVe = ttVar.ve();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("success", zC);
            jSONObject3.put("code", iTt);
            jSONObject3.put("message", strVe);
        } catch (JSONException e) {
            m.c(e);
        }
        long jCurrentTimeMillis = -1;
        if (pluginValueSetUj != null) {
            JSONObject jSONObjectC2 = com.byazt.whk.da.c(pluginValueSetUj, 10);
            String strStringValue = pluginValueSetUj.stringValue(5);
            if (jSONObjectC2 != null) {
                jCurrentTimeMillis = System.currentTimeMillis() - jSONObjectC2.optLong("run_package_start", 0L);
            }
            JSONObject jSONObjectC3 = com.byazt.whk.da.c(pluginValueSetUj, 3);
            jSONObjectC = com.byazt.whk.da.c(pluginValueSetUj, 4);
            j = jCurrentTimeMillis;
            jSONObject2 = jSONObjectC3;
            str = strStringValue;
        } else {
            str = null;
            jSONObject2 = null;
            jSONObjectC = null;
            j = -1;
        }
        c().c(str, jSONObject != null ? jSONObject.optString("business_type") : "", zC, j, jSONObject2, jSONObjectC, jSONObject3);
    }

    private void ve(com.byazt.ee.c cVar, String str) {
        c(cVar, str, true);
    }

    public void ve(com.byazt.ee.c cVar) {
        ve(cVar, "outer_call_no_rsp");
    }

    public void ve(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.32
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("saas_playable_end_card").tt(jSONObject.toString());
            }
        }, "saas_playable_end_card");
    }

    public void ve(final ic icVar, final String str) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.41
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("uttie_close");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "uttie_close");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final String str, JSONObject jSONObject, final String str2, final String str3) {
        if (jSONObject != null) {
            try {
                jSONObject.put("current_version", "7.6.1.1");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
                jSONObject.put("max_retry_count", com.byazt.ogz.da.tt(str3));
                jSONObject.put("uuid", com.byazt.by.c.ve());
                jSONObject.put("host_abi", com.byazt.qya.tt.c());
            } catch (Throwable unused) {
                return;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        final JSONObject jSONObject2 = jSONObject;
        jSONObject2.put("boost", true);
        final int iOptInt = jSONObject2.has("status_code") ? jSONObject2.optInt("status_code") : jSONObject2.optInt("code");
        final String strOptString = jSONObject2.optString("message");
        final String strOptString2 = jSONObject2.optString("duration");
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.54
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                if (!"zeus_load_finish".equals(str)) {
                    return com.byazt.qal.tt.tt().c(str).tt(jSONObject2.toString()).tt(iOptInt).n(strOptString2).sp(strOptString);
                }
                boolean zC = yp.c(str2, str3, jSONObject2);
                jSONObject2.putOpt("first_load", Integer.valueOf(zC ? 1 : 0));
                return com.byazt.qal.tt.tt().c(str).tt(jSONObject2.toString()).tt(iOptInt).sp(strOptString).n(strOptString2).c(zC ? 1 : 0);
            }
        }, str, true);
    }

    public void c(final long j, final long j2, final int i) {
        final long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.12
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("general_label");
                StringBuilder sb = new StringBuilder();
                sb.append(j3);
                return ttVarC.n(sb.toString()).tt(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void c(final String str, final String str2) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.23
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("sdk_retention").n(str).tt(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void c(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.33
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("obm_result").tt(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    public void c(final ic icVar, final int i, final String str) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.43
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                String strUj;
                String strQy;
                ic icVar2 = icVar;
                String strC = "";
                if (icVar2 != null) {
                    strC = nb.c(icVar2, "");
                    strUj = icVar.uj();
                    strQy = icVar.qy();
                } else {
                    strUj = "";
                    strQy = strUj;
                }
                return com.byazt.qal.tt.tt().c("use_player").ve(strC).uj(strUj).a(strQy).tt(i).sp(str);
            }
        }, "use_player", true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c(String str, int i, int i2, String str2, final int i3, final String str3, final long j, boolean z, boolean z2, boolean z3, boolean z4, int i4) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            try {
                jSONObject.put("message", str3);
                jSONObject.put("version", i2);
                jSONObject.put("current_version", i);
                jSONObject.put("package_name", str);
                jSONObject.put("url", str2);
                try {
                    jSONObject.put("duration", j);
                    jSONObject.put("max_retry_count", com.byazt.ogz.da.tt(str));
                    jSONObject.put("uuid", com.byazt.by.c.ve());
                    jSONObject.put("isRetry", z);
                    jSONObject.put("is_old_plugin", z2);
                    jSONObject.put("is_resume_download", z3);
                    jSONObject.put("is_downloader", z4);
                    jSONObject.put("downloader_try_count", i4);
                    jSONObject.put("host_abi", com.byazt.qya.tt.c());
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.52
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarSp = com.byazt.qal.tt.tt().c("plugin_download").tt(i3).sp(str3);
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                return ttVarSp.n(sb.toString()).tt(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public void tt() {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.3
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.dj.uj ujVarMy = com.byazt.omf.x.m().my();
                boolean zAlist = ujVarMy.alist();
                boolean zIsCanUseLocation = ujVarMy.isCanUseLocation();
                boolean zIsCanUseWriteExternal = ujVarMy.isCanUseWriteExternal();
                boolean zIsCanUseWifiState = ujVarMy.isCanUseWifiState();
                boolean zIsCanUsePhoneState = ujVarMy.isCanUsePhoneState();
                boolean zIsCanUseAndroidId = ujVarMy.isCanUseAndroidId();
                String devOaid = ujVarMy.getDevOaid();
                JSONObject jSONObject = new JSONObject();
                int i = 1;
                try {
                    jSONObject.put("access_fine_location", zIsCanUseLocation ? 1 : 0);
                    jSONObject.put("applist", zAlist ? 1 : 0);
                    jSONObject.put("external_storage", zIsCanUseWriteExternal ? 1 : 0);
                    jSONObject.put("wifi_state", zIsCanUseWifiState ? 1 : 0);
                    jSONObject.put("phone_state", zIsCanUsePhoneState ? 1 : 0);
                    jSONObject.put("can_use_androidId", zIsCanUseAndroidId ? 1 : 0);
                    jSONObject.put("dev_oaid", devOaid);
                    if (!com.byazt.omf.x.m().u()) {
                        i = 0;
                    }
                    jSONObject.put("uip", i);
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("sdk_permission").tt(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void tt(com.byazt.ee.c cVar) {
        ve(cVar, "outer_call_send");
    }

    public void tt(final int i) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.24
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("get_ad_cache_failed").tt(i);
            }
        }, "get_ad_cache_failed", true);
    }

    public void tt(com.byazt.ee.c cVar, String str) {
        tt.ve().c(cVar, str, true);
    }

    public void tt(final String str, final JSONObject jSONObject) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.30
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                return com.byazt.qal.tt.tt().c("soverify_result").tt(jSONObject2.toString());
            }
        }, "soverify_result");
    }

    public void tt(final JSONObject jSONObject) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.31
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("saas_schema").tt(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public void tt(final ic icVar, final int i, final String str) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.38
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("upie_img_play_fail");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                ttVarC.tt(i);
                ttVarC.sp(str);
                JSONObject jSONObject = new JSONObject();
                com.byazt.ic.c.c(jSONObject, icVar);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "upie_img_play_fail");
    }

    public void tt(final ic icVar, final String str) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.39
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("uttie_start");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "uttie_start");
    }

    public static void c(final ic icVar) {
        if (icVar == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.55
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    int iVe = com.byazt.apd.tt.c().ve();
                    int iN = com.byazt.apd.tt.c().n();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
                    jSONObject.put(LoginConstants.EXT, icVar.w_());
                    jSONObject.put("live_sdk_status", iVe);
                    jSONObject.put("live_auth_status", iN);
                    jSONObject.put("app_start_time", jElapsedRealtime);
                    jSONObject.put("is_web", icVar.s_());
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("saas_show_miss").tt(jSONObject.toString());
            }
        }, "saas_show_miss", true);
    }

    public static boolean c(String str, String str2, JSONObject jSONObject) {
        File[] fileArrListFiles;
        Context context = gt.getContext();
        File file = new File(com.byazt.nr.sp.c(context, false, null), str2);
        String strC = com.byazt.bzd.n.c(file);
        try {
            jSONObject.putOpt("last_plugin_version", strC);
            jSONObject.putOpt("version_file", file.getAbsoluteFile());
            boolean zC = com.byazt.xgx.n.c().c(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            jSONObject.putOpt("sd_per", Boolean.valueOf(zC));
            String strVe = ve();
            File file2 = new File(strVe + com.byazt.omf.x.m().rl(), str);
            boolean zExists = file2.exists();
            jSONObject.putOpt("is_loaded", Boolean.valueOf(zExists));
            jSONObject.putOpt("is_installed", Boolean.valueOf(new File(strVe + "ins/" + com.byazt.omf.x.m().rl(), str).exists()));
            if (zExists && zC) {
                File parentFile = file2.getParentFile();
                if (parentFile != null && (fileArrListFiles = parentFile.listFiles()) != null && !str.isEmpty()) {
                    for (File file3 : fileArrListFiles) {
                        if (file3 != null && !TextUtils.equals(file3.getName(), str)) {
                            file3.delete();
                        }
                    }
                }
            } else {
                jSONObject.putOpt("mkdirs", Boolean.valueOf(file2.mkdirs()));
            }
            com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
            String str3 = veVarC.get("plugin_first_load", "");
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.putOpt("plugin_first_load", str3);
            }
            veVarC.put("plugin_first_load", str);
            if (!TextUtils.equals(str, strC)) {
                jSONObject.putOpt("write_suc", Boolean.valueOf(com.byazt.bzd.n.c(str, file)));
                String str4 = tt;
                if (TextUtils.isEmpty(str4)) {
                    str4 = veVarC.get("plugin_install_msg", "");
                }
                jSONObject.putOpt("install_msg", str4);
                return true;
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public void c(final ic icVar, final JSONObject jSONObject) {
        if (icVar == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.4
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarA = com.byazt.qal.tt.tt().c("jsb_video_action").a(icVar.qy());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    ttVarA.tt(jSONObject2.toString());
                }
                ttVarA.ve(nb.c(icVar, ""));
                return ttVarA;
            }
        }, "jsb_video_action", true);
    }

    public static void c(final String str, final long j, final boolean z) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.5
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z);
                jSONObject.put("timestamp", j);
                return com.byazt.qal.tt.tt().c("over_freq").ve(str).tt(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    public static void c(final int i, final int i2) {
        m.uj("xgc_report", "volume:" + i + " bright:" + i2);
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.6
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                int i3 = i;
                if (i3 != -1) {
                    jSONObject.put("user_volume_change", i3);
                }
                int i4 = i2;
                if (i4 != -1) {
                    jSONObject.put("user_bright_change", i4);
                }
                return com.byazt.qal.tt.tt().c("system_change").tt(jSONObject.toString());
            }
        }, "system_change", true);
    }

    private void c(final com.byazt.ee.c cVar, final String str, boolean z) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.7
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVar = (com.byazt.qal.tt) cVar.c();
                ttVar.c(str);
                ttVar.c(jCurrentTimeMillis);
                return ttVar;
            }
        }, str, true);
    }

    public void c(com.byazt.ee.c cVar) {
        ve(cVar, "outer_call");
    }

    public void c(final long j, final String str, final com.byazt.ee.c cVar) {
        if (cVar == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.9
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVar = (com.byazt.qal.tt) cVar.c();
                ttVar.c(str);
                ttVar.c(j);
                return ttVar;
            }
        }, str, true);
    }

    private boolean c(String str, int i) {
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        int i2 = veVarC.get(str, 0);
        boolean z = (i2 & 2) == 0 || (i2 & 1) != i;
        if (z) {
            veVarC.put(str, i + 2);
        }
        return z;
    }

    public void c(final int i, ic icVar, final boolean z) {
        final String strValueOf = String.valueOf(nb.t(icVar));
        if (c(strValueOf, z ? 1 : 0)) {
            tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.10
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    com.byazt.qal.tt ttVarVe = com.byazt.qal.tt.tt().c(i).ve(strValueOf);
                    if (z) {
                        ttVarVe.c("reg_creative");
                    } else {
                        ttVarVe.c("no_reg_creative");
                    }
                    return ttVarVe;
                }
            }, z ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void c(final com.byazt.qal.tt ttVar) {
        if (tt(ttVar)) {
            return;
        }
        ttVar.c("load_icon_error");
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.11
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return ttVar;
            }
        }, "load_icon_error", true);
    }

    public void c(final boolean z, final String[] strArr) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.13
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append(",");
                            }
                        }
                        jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("download_permission").c(System.currentTimeMillis() / 1000).tt(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void c(final String str, final String str2, final String str3, final boolean z) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.15
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("get_bidding_token");
                boolean zTt = gt.tt().tt(str);
                JSONObject jSONObject = new JSONObject();
                if (zTt) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z) {
                    jSONObject.put("opt_sample", 1);
                }
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "get_bidding_token", z);
    }

    public void c(final long j, final com.byazt.whk.n nVar) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.16
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                jSONObject.put("ext_plugin_code", eo.tt());
                com.byazt.whk.n nVar2 = nVar;
                if (nVar2 != null) {
                    jSONObject.put("success", nVar2.c() ? 1 : 0);
                    com.byazt.whk.sp spVarTt = nVar.tt();
                    if (spVarTt != null) {
                        jSONObject.put("msg", spVarTt.toString());
                        jSONObject.put("code", spVarTt.c());
                    }
                }
                return com.byazt.qal.tt.tt().c("pitaya_init").tt(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void c(final String str, final String str2, final boolean z, final long j, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.17
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", eo.tt());
                return com.byazt.qal.tt.tt().c("pitaya_run_task").tt(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void c(final int i, qy qyVar) {
        if (qyVar == null) {
            return;
        }
        final JSONObject jSONObjectC = qyVar.c(-1L);
        final long jTt = qyVar.tt();
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.18
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("bid_token_time");
                try {
                    jSONObjectC.put("total", jTt);
                    jSONObjectC.put("opt_sample", 1);
                    jSONObjectC.put("slot_type", i);
                    ttVarC.tt(jSONObjectC.toString());
                } catch (Throwable unused) {
                }
                return ttVarC;
            }
        }, "get_bidding_token", true);
    }

    public void c(final int i, final long j, final String str, final int i2) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.19
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put(HiAnalyticsConstant.BI_KEY_COST_TIME, j2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("event_res", i3);
                    }
                    int i4 = i2;
                    if (i4 != -1 && i == 3) {
                        jSONObject.put("armor_load_status", i4);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    ttVarC.tt(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return ttVarC;
            }
        }, "encrypt_track", true);
    }

    public void c(final int i, final long j, final Boolean bool, final String str) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.20
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put(HiAnalyticsConstant.BI_KEY_COST_TIME, j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    ttVarC.tt(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return ttVarC;
            }
        }, "encrypt_track", true);
    }

    public void c(final int i) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.21
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("has_pre_req").tt(i);
            }
        }, "has_pre_req", true);
    }

    public void c(final int i, final String str, final String str2, final String str3, final String str4) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.22
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject.put("code", i);
                jSONObject.put("msg", str);
                jSONObject.put("material_keys", str4);
                return com.byazt.qal.tt.tt().c("fetch_adm_status").tt(i).ve(str3).a(str2).tt(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void c(final String str) {
        if (str == null) {
            return;
        }
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.25
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("error_ad_info").c(System.currentTimeMillis() / 1000).i(str);
            }
        }, "error_ad_info", true);
    }

    public void c(final String str, final JSONObject jSONObject, final JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.26
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c(str);
                JSONObject jSONObject3 = jSONObject2;
                if (jSONObject3 != null) {
                    ttVarC.tt(jSONObject3.toString());
                }
                JSONObject jSONObject4 = jSONObject;
                if (jSONObject4 != null) {
                    String strOptString = jSONObject4.optString("rit");
                    String strOptString2 = jSONObject.optString("cid");
                    int iOptInt = jSONObject.optInt("adtype");
                    String strOptString3 = jSONObject.optString("req_id");
                    String strOptString4 = jSONObject.optString("duration");
                    ttVarC.ve(strOptString);
                    ttVarC.c(iOptInt);
                    ttVarC.uj(strOptString2);
                    ttVarC.a(strOptString3);
                    ttVarC.n(strOptString4);
                }
                return ttVarC;
            }
        }, str);
    }

    public void c(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.27
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    ttVarC.tt(jSONObject2.toString());
                }
                return ttVarC;
            }
        }, str);
    }

    public void c(ic icVar, String str) {
        if (icVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", str);
            jSONObject.putOpt("req_id", icVar.qy());
            jSONObject.putOpt("aid", icVar.gu());
            jSONObject.putOpt("cid", icVar.uj());
        } catch (JSONException unused) {
        }
        c("showTime", jSONObject, (Throwable) null);
    }

    public void c(String str, Throwable th) {
        c(str, (JSONObject) null, th);
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.28
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("request", jSONObject);
                jSONObject3.put(ConnectionLog.CONN_LOG_STATE_RESPONSE, jSONObject2);
                return com.byazt.qal.tt.tt().c("device_register").tt(jSONObject3.toString());
            }
        }, "device_register");
    }

    public void c(final String str, final JSONObject jSONObject, final Throwable th) {
        if (n.c(str, 1.0d)) {
            tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.29
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("scene", str);
                    jSONObject2.putOpt("object", jSONObject);
                    Throwable th2 = th;
                    if (th2 != null) {
                        jSONObject2.putOpt(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, Log.getStackTraceString(th2));
                    }
                    return com.byazt.qal.tt.tt().c(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a).tt(jSONObject2.toString());
                }
            }, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
        }
    }

    public void c(final ic icVar, final long j, final boolean z, final boolean z2) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.34
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", icVar.qy());
                jSONObject.put("auth", z);
                jSONObject.put("duration", j);
                jSONObject.put("time_out", z2);
                q qVarC_ = icVar.C_();
                if (qVarC_ != null) {
                    jSONObject.put("saas_info", qVarC_.c());
                }
                jSONObject.put(LoginConstants.EXT, icVar.w_());
                return com.byazt.qal.tt.tt().c("auth_time").tt(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void c(final String str, final String str2, final int i, final JSONObject jSONObject) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.35
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("event_type", str2);
                jSONObject2.putOpt("event", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("state", Integer.valueOf(i));
                return com.byazt.qal.tt.tt().c("convert_event").tt(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void c(final ic icVar, final int i, final int i2, final View view) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.36
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().ve(String.valueOf(nb.t(icVar))).c(i).c("register_info");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i2);
                jSONObject.put("targetIsNull", view == null ? 1 : 0);
                com.byazt.ic.c.c(jSONObject, icVar);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "register_info");
    }

    public void c(final ic icVar, final Object obj) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.37
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("upie_img_play_success");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", obj);
                com.byazt.ic.c.c(jSONObject, icVar);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "upie_img_play_success");
    }

    public void c(final ic icVar, final String str, final long j) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.40
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("uttie_played");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put("duration", j);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "uttie_played");
    }

    public void c(final ic icVar, final String str, final JSONObject jSONObject) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.42
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c(str);
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy()).x(icVar.w_());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    ttVarC.tt(jSONObject2.toString());
                }
                return ttVarC;
            }
        }, str);
    }

    public static void c(final com.byazt.dj.tt ttVar, final long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        c().sp(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.48
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                int i4 = i3 > 0 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i4));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject.putOpt("total_duration", Long.valueOf(j3));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i));
                jSONObject.putOpt("check_count", Integer.valueOf(i2));
                jSONObject.putOpt("success_count", Integer.valueOf(i3));
                return com.byazt.qal.tt.tt().c(i).ve(ttVar.uj()).tt((int) j).tt(jSONObject.toString());
            }
        });
    }

    public void c(final ic icVar, final float f, final float f2, final float f3, final float f4, final View view) {
        tt(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.50
            /* JADX WARN: Code duplicated, block: B:22:0x0081  */
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                float fAbs;
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("video_size_gap");
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ttVarC.a(icVar2.qy());
                }
                JSONObject jSONObject = new JSONObject();
                com.byazt.ic.c.c(jSONObject, icVar);
                ic icVar3 = icVar;
                jSONObject.put("image_mode", icVar3 != null ? icVar3.id() : 0);
                ic icVar4 = icVar;
                jSONObject.put("slot_type", icVar4 != null ? nb.sl(icVar4) : 0);
                jSONObject.put("resolution_w", f3);
                jSONObject.put("resolution_h", f4);
                jSONObject.put("container_w", f);
                jSONObject.put("container_h", f2);
                float f5 = f3;
                float fAbs2 = -1.0f;
                if (f5 != 0.0f) {
                    float f6 = f4;
                    if (f6 != 0.0f) {
                        float f7 = f;
                        if (f7 != 0.0f) {
                            float f8 = f2;
                            if (f8 != 0.0f) {
                                fAbs = Math.abs((f7 / f8) - (f5 / f6));
                            } else {
                                fAbs = -1.0f;
                            }
                        } else {
                            fAbs = -1.0f;
                        }
                    } else {
                        fAbs = -1.0f;
                    }
                } else {
                    fAbs = -1.0f;
                }
                jSONObject.put("size_gap_value", fAbs);
                View view2 = view;
                float width = view2 != null ? view2.getWidth() : 0.0f;
                View view3 = view;
                float height = view3 != null ? view3.getHeight() : 0.0f;
                jSONObject.put("dev_container_w", width);
                jSONObject.put("dev_container_h", height);
                float f9 = f3;
                if (f9 != 0.0f) {
                    float f10 = f4;
                    if (f10 != 0.0f && width != 0.0f && height != 0.0f) {
                        fAbs2 = Math.abs((width / height) - (f9 / f10));
                    }
                }
                jSONObject.put("dev_size_gap_value", fAbs2);
                jSONObject.put("gap_gaosi_fill", 0);
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "video_size_gap");
    }

    public void c(final long j, final long j2, final int i, final int i2) {
        tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ukr.yp.51
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j3 = j;
                    if (j3 >= 0) {
                        jSONObject.put("initZeusCostTime", j3);
                    }
                    long j4 = j2;
                    if (j4 > 0) {
                        jSONObject.put("loadCostTime", j4);
                    }
                    jSONObject.put("eventRes", i);
                    jSONObject.put("eventType", i2);
                    ttVarC.tt(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return ttVarC;
            }
        }, "dex_adapter_track", true);
    }
}
