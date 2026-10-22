package com.byazt.ete;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 953})
public class f {
    public static int c = 0;
    public static int tt = 0;
    public static int ve = 1;

    public static void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        c = jSONObjectOptJSONObject.optInt("api", 0);
        tt = jSONObjectOptJSONObject.optInt("size_limit", 0);
        ve = jSONObjectOptJSONObject.optInt("zip_level", 1);
    }

    public static int c(int i, int i2) {
        if (c <= 0 || Build.VERSION.SDK_INT > c || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = tt;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, ve);
        }
        return 1;
    }
}
