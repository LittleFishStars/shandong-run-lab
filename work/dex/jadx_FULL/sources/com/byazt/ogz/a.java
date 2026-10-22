package com.byazt.ogz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 34})
public class a {
    public boolean c = false;
    public boolean tt = true;

    public static a c(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.c = jSONObject.optBoolean("encrypt", false);
            aVar.tt = jSONObject.optBoolean("wait_io", true);
        } catch (Throwable unused) {
        }
        return aVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.c);
            jSONObject.put("wait_io", this.tt);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
