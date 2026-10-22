package com.byazt.ba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.jz.n;
import com.byazt.mg.da;
import com.byazt.uy.x;
import com.zj.adlib.xh9;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2074, 20})
public class c {
    public static volatile JSONObject c;

    public static void c(tt ttVar) {
        Map<String, Object> mapC = x.c().c();
        if (mapC == null && mapC.get("aid") == null) {
            return;
        }
        try {
            com.byazt.jz.tt.c(new n.c().c(com.byazt.jz.tt.tt(mapC) + "?device_platform=android&version_code=138&iid=iid&aid=" + mapC.get("aid")).c(true).c(c(mapC).toString().getBytes("UTF-8")).c());
        } catch (Throwable unused) {
        }
    }

    private static String c() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(Consts.DOT)) {
            return str;
        }
        return str + ".0";
    }

    private static JSONObject c(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (c == null) {
            Context contextUj = x.uj();
            try {
                JSONObject jSONObject2 = new JSONObject();
                c = jSONObject2;
                jSONObject2.put("os", "Android");
                c.put("platform", "Android");
                c.put("sdk_lib", "Android");
                c.put("os_version", c());
                c.put("os_api", Build.VERSION.SDK_INT);
                c.put("use_apm_sdk", "1");
                c.put("sdk_version", 138);
                c.put("sdk_version_code", 138);
                c.put("sdk_version_name", "0.0.1-alpha.18-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                c.put("device_model", str);
                c.put("device_brand", str2);
                c.put("device_manufacturer", Build.MANUFACTURER);
                if (map != null) {
                    c.put("aid", String.valueOf(map.get("aid")));
                    c.put(AlibcCommonConstant.APP_VERSION, map.get(AlibcCommonConstant.APP_VERSION));
                    c.put("version_code", map.get("version_code"));
                    c.put("update_version_code", map.get("update_version_code"));
                    c.put("manifest_version_code", map.get("version_code"));
                    c.put(xh9.WEBSITE_PARAMS_CHANNEL, map.get(xh9.WEBSITE_PARAMS_CHANNEL));
                }
                c.put("bd_did", x.ve().c());
                c.put("package", contextUj.getPackageName());
                c.put("display_name", contextUj.getApplicationInfo().name);
                c(c);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", c);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    private static void c(JSONObject jSONObject) {
        Map<String, Object> mapTt;
        Object obj;
        com.byazt.rx.c cVarC = x.c();
        if (cVarC == null || jSONObject == null || (mapTt = cVarC.tt()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapTt.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapTt.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e) {
            da.tt(e);
        }
    }
}
