package com.byazt.nys;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.byazt.nys.a;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.sg5;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 34})
public final class a {
    public static SharedPreferences tt;
    public static final List<Pair<String, JSONObject>> ve = new CopyOnWriteArrayList();
    public static final Map<String, String> c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a(String str, JSONObject jSONObject) {
        String str2 = "7.6.1.1";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.byazt.zyp.ve.ve());
            jSONObject2.put("ad_sdk_version", "7.6.1.1");
            i.c(TTAppContextHolder.getContext());
            String strC = i.c("com.byted.pangle");
            if (!TextUtils.isEmpty(strC)) {
                str2 = strC;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = c;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ze1.k, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put(DeviceIdType.IMEI, map.get(DeviceIdType.IMEI));
            jSONObject3.put(DeviceIdType.OAID, map.get(DeviceIdType.OAID));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private static void n(final String str, final JSONObject jSONObject) {
        com.byazt.qy.c.c().uj().execute(new Runnable() { // from class: com.byazt.nys.a.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.a(str, jSONObject));
                a.tt(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(int i, String str, boolean z, sp spVar, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (spVar != null) {
            try {
                spVar.c(jSONObject);
            } catch (Throwable th2) {
                c("report_failed", null, th2);
                return;
            }
        }
        jSONObject.putOpt("code", Integer.valueOf(i));
        jSONObject.putOpt("message", str);
        jSONObject.putOpt("is_plugin", Boolean.valueOf(z));
        jSONObject.putOpt("api", Boolean.TRUE);
        i.c(TTAppContextHolder.getContext());
        Plugin plugin = Zeus.getPlugin("com.byted.pangle");
        if (plugin != null) {
            jSONObject.putOpt("install_version", Integer.valueOf(plugin.getVersion()));
            jSONObject.putOpt("life_cycle", Integer.valueOf(plugin.getLifeCycle()));
        }
        jSONObject.putOpt("load_record", n.tt());
        c("init_failed", jSONObject, th);
    }

    private static void uj(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            n(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString(sg5.c, str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    public static void c(String str, JSONObject jSONObject) {
        if (com.byazt.gvs.tt.sl.equals(str)) {
            c(str, jSONObject, null);
        } else {
            uj("zeus_".concat(String.valueOf(str)), jSONObject);
        }
    }

    public static void c() {
        List<Pair<String, JSONObject>> list = ve;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    uj((String) pair.first, (JSONObject) pair.second);
                }
            }
            ve.clear();
        } catch (Exception unused) {
        }
    }

    public static void c(final int i, final String str, final boolean z, final sp spVar, final Throwable th) {
        if (com.byazt.bog.n.c()) {
            return;
        }
        com.byazt.qy.c.c().uj().execute(new Runnable() { // from class: com.zj.adlib.xba
            @Override // java.lang.Runnable
            public final void run() {
                a.tt(i, str, z, spVar, th);
            }
        });
    }

    public static void c(String str, JSONObject jSONObject, Throwable th) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            jSONObject2.putOpt(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, Log.getStackTraceString(th));
            n(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void tt(String str, JSONObject jSONObject) {
        ve.add(new Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(List<JSONObject> list) throws Throwable {
        if (list == null) {
            return;
        }
        if (tt == null) {
            tt = tt.tt(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String str = String.format("https://%s%s", tt.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = ve;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(a((String) pair.first, (JSONObject) pair.second));
                }
                ve.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.byazt.uc.ve.c().c(true, str, com.byazt.zyp.tt.c(jSONObject).toString().getBytes());
    }

    public static void c(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = c;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put(DeviceIdType.OAID, customController.getDevOaid());
                map.put(DeviceIdType.IMEI, customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    public static Map<String, String> tt() {
        return c;
    }
}
