package com.byazt.ogz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 91})
public class sp {
    public boolean c = false;
    public boolean tt = false;
    public boolean ve = false;
    public boolean uj = false;
    public boolean n = false;

    public static sp c(String str) {
        sp spVar = new sp();
        if (TextUtils.isEmpty(str)) {
            com.byazt.bzd.sp.c().delete();
            return spVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            spVar.c = jSONObject.optBoolean("use_csj_main", false);
            spVar.tt = jSONObject.optBoolean("use_layze_layout", false);
            spVar.ve = jSONObject.optBoolean("create_ad_in_io", false);
            spVar.uj = jSONObject.optBoolean("opt_panel_view", false);
            boolean zOptBoolean = jSONObject.optBoolean("so_lock", false);
            spVar.n = zOptBoolean;
            if (zOptBoolean) {
                com.byazt.bzd.sp.c().mkdirs();
            } else {
                com.byazt.bzd.sp.c().delete();
            }
        } catch (Throwable unused) {
        }
        return spVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.c);
            jSONObject.put("use_layze_layout", this.tt);
            jSONObject.put("create_ad_in_io", this.ve);
            jSONObject.put("opt_panel_view", this.uj);
            jSONObject.put("so_lock", this.n);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
