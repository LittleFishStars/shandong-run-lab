package com.fl.saas;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fl.saas.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1420l0 {
    public static JSONObject a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strB = AbstractC1417k.b(str);
                if (!TextUtils.isEmpty(strB) && !"null".equals(strB)) {
                    return new JSONObject(strB);
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
