package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class di {
    public static JSONObject a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("0", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b() {
        try {
            String strA = bi.a();
            return (TextUtils.isEmpty(strA) || strA.contains("arm64") || strA.contains("64")) ? 0 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }
}
