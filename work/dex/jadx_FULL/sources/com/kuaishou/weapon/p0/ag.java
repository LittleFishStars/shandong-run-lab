package com.kuaishou.weapon.p0;

import android.content.Context;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ag {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (new File(context.getDataDir(), "xreplace").exists()) {
                jSONObject.put("xreplace", 1);
            }
            if (new File("/storage/emulated/0/xxsq").exists()) {
                jSONObject.put("xxsq", 1);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
