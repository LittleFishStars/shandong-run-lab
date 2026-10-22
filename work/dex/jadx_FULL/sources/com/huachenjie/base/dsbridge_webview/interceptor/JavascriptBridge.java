package com.huachenjie.base.dsbridge_webview.interceptor;

import com.huachenjie.base.dsbridge_webview.CompletionHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface JavascriptBridge {
    default void a(CompletionHandler<Object> handler, Map<String, Object> params) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : params.keySet()) {
                jSONObject.put(str, params.get(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.a(jSONObject);
    }

    default void b(CompletionHandler<Object> handler, String key, Object value) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, value);
        a(handler, linkedHashMap);
    }

    void release();
}
