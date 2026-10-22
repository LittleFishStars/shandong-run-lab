package com.byazt.omf;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.hv.TTDownloadField;
import com.byazt.nys.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 15})
public class uj {
    public static String c = "AppEnvironment";
    public String n;
    public Map<String, String> tt;
    public boolean uj;
    public long ve;

    @com.byazt.zqa.c(c = {0, 1, 31, 123})
    public static class c {
        public static final uj c = new uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = gt.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", x.m().rl());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put(RequestPermission.PERMISSIONS, jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void n() {
        Runtime runtime = Runtime.getRuntime();
        float fMaxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) gt.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.byazt.nr.m.uj(c, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.byazt.nr.m.uj(c, "maxMemory: ".concat(String.valueOf(fMaxMemory)));
        com.byazt.nr.m.uj(c, "totalMemory: ".concat(String.valueOf(f)));
        com.byazt.nr.m.uj(c, "freeMemory: ".concat(String.valueOf(fFreeMemory)));
        int i = (int) ((f / fMaxMemory) * 100.0f);
        com.byazt.nr.m.uj(c, "totalMaxRate: ".concat(String.valueOf(i)));
        this.tt.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.tt.put("total_max_memory_rate", String.valueOf(i));
    }

    private String uj() {
        try {
            String strC = com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj());
            if (!TextUtils.isEmpty(strC) && !"-1".equals(strC.trim())) {
                return String.valueOf(Math.round(Double.parseDouble(strC) * 10.0d) / 10.0d);
            }
            return "-1";
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public void tt(String str) {
        this.tt.put("request_ad_info", str);
    }

    public void ve(String str) {
        this.tt.put("show_ad_info", str);
    }

    private uj() {
        this.n = "";
        HashMap map = new HashMap();
        this.tt = map;
        map.put("ad_style", "default");
        this.tt.put(MediationConstant.EXTRA_ADID, "default");
        this.tt.put("rit", "default");
        this.tt.put("request_id", "default");
        this.tt.put("ad_slot_type", "default");
        this.tt.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "default");
        this.tt.put("low_memory", "default");
        this.tt.put("total_max_memory_rate", "default");
        this.tt.put("commit_hash", "ff64f3ed4a");
        this.tt.put("branch", "");
        this.tt.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
        this.tt.put("sdk_api_version", p.n);
        this.tt.put("csj_app_id", x.m().rl());
        this.tt.put("setting_ab_version", com.byazt.by.n.c().n());
        this.tt.put("device_score", uj());
        this.ve = com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "tt_sp_app_env").get("last_app_env_time", 0L);
        this.uj = false;
    }

    public void tt(ic icVar) {
        if (icVar == null) {
            return;
        }
        this.tt.put(MediationConstant.EXTRA_ADID, icVar.uj());
        Map<String, String> map = this.tt;
        StringBuilder sb = new StringBuilder();
        sb.append(nb.t(icVar));
        map.put("rit", sb.toString());
        this.tt.put("request_id", nb.m(icVar));
        Map<String, String> map2 = this.tt;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(nb.sl(icVar));
        map2.put("ad_slot_type", sb2.toString());
        this.tt.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, com.byazt.nr.rh.sp(gt.getContext()));
        if (com.byazt.aas.rl.tt(icVar)) {
            this.tt.put("ad_style", "is_playable");
        }
        n();
    }

    public void ve() {
        if (this.uj || nb.c(this.ve, System.currentTimeMillis())) {
            return;
        }
        this.uj = true;
        com.byazt.ukr.yp.c().x(new com.byazt.ee.c() { // from class: com.byazt.omf.uj.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                uj.this.uj = false;
                com.byazt.qal.tt<com.byazt.qal.tt> ttVarTt = com.byazt.qal.tt.tt();
                JSONObject jSONObjectA = uj.this.a();
                if (jSONObjectA != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    uj.this.ve = jCurrentTimeMillis;
                    com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "tt_sp_app_env").put("last_app_env_time", jCurrentTimeMillis);
                    ttVarTt.tt(jSONObjectA.toString());
                }
                return ttVarTt;
            }
        });
    }

    public static uj c() {
        return c.c;
    }

    public void c(ic icVar) {
        if (icVar == null) {
            return;
        }
        String strMk = icVar.mk();
        Map<String, String> map = this.tt;
        if (TextUtils.isEmpty(strMk)) {
            strMk = "";
        }
        map.put("ad_info", strMk);
    }

    public void c(String str) {
        this.tt.put("dynamic_ptpl_id", str);
    }

    public Map<String, String> tt() {
        return this.tt;
    }
}
