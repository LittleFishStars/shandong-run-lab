package com.byazt.xs;

import android.text.TextUtils;
import com.byazt.aas.eo;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 91})
public final class sp {
    public static volatile sp c;
    public com.byazt.iy.n tt = eo.c("ugeno_template_file");

    private sp() {
    }

    public static sp c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    c = new sp();
                }
            }
        }
        return c;
    }

    public boolean tt(String str, String str2) {
        return c(str, str2) != null;
    }

    public void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.tt.put("ugeno_".concat(String.valueOf(str)), str3);
        this.tt.put("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject c(String str, String str2) {
        String str3 = this.tt.get("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String str4 = this.tt.get("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, str2)) {
            try {
                return new JSONObject(str3);
            } catch (JSONException e) {
                m.c(e);
            }
        }
        return null;
    }
}
