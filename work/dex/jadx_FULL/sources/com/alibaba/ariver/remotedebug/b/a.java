package com.alibaba.ariver.remotedebug.b;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.remotedebug.core.DebugMessageType;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static void a(Page page, Map<String, String> map, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headers", (Object) map);
        jSONObject.put("method", (Object) str);
        jSONObject.put("url", (Object) str2);
        jSONObject.put("requestId", (Object) str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        jSONObject.put("postBody", (Object) str4);
        b.a(page, DebugMessageType.REMOTE_DEBUG_NETWORK_REQUEST, jSONObject.toString());
    }

    public static void a(Page page, Map<String, String> map, String str, int i, String str2, String str3, byte[] bArr) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headers", (Object) map);
        jSONObject.put("url", (Object) str);
        jSONObject.put("status", (Object) Integer.valueOf(i));
        jSONObject.put(com.alibaba.triver.open.api.b.f25039a, (Object) str2);
        jSONObject.put("requestId", (Object) str3);
        if (bArr != null) {
            jSONObject.put("body", (Object) new String(bArr, 0, Math.min(bArr.length, 1048576)));
        }
        b.a(page, DebugMessageType.REMOTE_DEBUG_NETWORK_RESPONSE, jSONObject.toString());
    }

    public static void a(Page page, String str, int i, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) str);
        jSONObject.put("errorCode", (Object) Integer.valueOf(i));
        jSONObject.put("errorMsg", (Object) str2);
        jSONObject.put("requestId", (Object) str3);
        b.a(page, DebugMessageType.REMOTE_DEBUG_NETWORK_ERROR, jSONObject.toString());
    }

    public static void a(Page page, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                jSONObject2.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        jSONObject.put("data", (Object) jSONObject2);
        b.a(page, DebugMessageType.REMOTE_DEBUG_STORAGE, jSONObject.toString());
    }
}
