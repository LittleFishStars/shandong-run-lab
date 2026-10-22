package com.alibaba.alibclinkpartner.linkpartner.a;

import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!g.a(entry.getKey()) && !g.a(entry.getValue())) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (Throwable th) {
                        ALSLLogUtil.e("ALPUrlHelper", "extraParams2Json", "urlencode error " + th.toString());
                    }
                }
            }
        }
        return jSONObject.toString();
    }

    public static String b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!g.a(entry.getKey()) && !g.a(entry.getValue())) {
                    try {
                        jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                    } catch (Throwable th) {
                        ALSLLogUtil.e("ALPUrlHelper", "extraParams2Json", "urlencode error " + th.toString());
                    }
                }
            }
        }
        return jSONObject.toString();
    }
}
