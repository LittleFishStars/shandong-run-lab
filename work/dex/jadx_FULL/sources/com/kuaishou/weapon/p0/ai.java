package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.zj.adlib.y6b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ai {
    public static JSONObject a(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int i = Integer.parseInt(property2);
            if (TextUtils.isEmpty(property) || i == -1) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(y6b.g, property);
            jSONObject.put("p", i);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
