package com.alipay.sdk.m.y;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {
    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i = 0; i < 2; i++) {
                JSONObject jSONObject4 = jSONObjectArr[i];
                if (jSONObject4 != null) {
                    Iterator<String> itKeys = jSONObject4.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                }
            }
        } catch (JSONException e) {
            g.a(e);
        }
        return jSONObject3;
    }

    public static String a(String str) {
        try {
            return JSONObject.quote(str).replace("'", "\\'");
        } catch (Throwable th) {
            g.b(com.alipay.sdk.m.n.a.B, "escapeJsonStringError");
            g.a(th);
            return "";
        }
    }

    public static void a(JSONObject jSONObject, String str, Boolean bool) throws JSONException {
        if (jSONObject == null || str == null) {
            return;
        }
        if (bool == null) {
            jSONObject.remove(str);
        } else {
            jSONObject.put(str, bool);
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null || str == null) {
            return;
        }
        if (str2 == null) {
            jSONObject.remove(str);
        } else {
            jSONObject.put(str, str2);
        }
    }
}
