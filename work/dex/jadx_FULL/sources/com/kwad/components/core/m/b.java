package com.kwad.components.core.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    public static boolean aA(Context context) {
        boolean zL;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    c.printStackTraceOnly(e);
                }
            }
            zL = aVar.l(e.JZ(), e.Ka());
            c.d("LocalAdForceActiveHelper", "addCount contains success: " + zL);
        } else {
            c.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.to();
            zL = true;
        }
        if (zL) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return zL;
    }
}
