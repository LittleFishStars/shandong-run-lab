package com.byazt.ogz;

import android.text.TextUtils;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 72})
public class da {
    public static boolean a() {
        return n() > 0;
    }

    public static int c() {
        JSONObject jSONObjectCs = gt.tt().cs();
        if (jSONObjectCs == null) {
            return 0;
        }
        return jSONObjectCs.optInt("live_max_count", 0);
    }

    public static int n() {
        JSONObject jSONObjectCs = gt.tt().cs();
        if (jSONObjectCs == null) {
            return 0;
        }
        return jSONObjectCs.optInt("pangle_max_count", 0);
    }

    public static boolean sp() {
        return gt.tt().la() == 1;
    }

    public static int tt() {
        JSONObject jSONObjectCs = gt.tt().cs();
        if (jSONObjectCs != null && p.uj >= 7200) {
            return jSONObjectCs.optInt("live_init_max_count", 0);
        }
        return 0;
    }

    public static boolean uj() {
        return tt() > 0;
    }

    public static boolean ve() {
        return c() > 0;
    }

    public static boolean c(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return a();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return ve();
        }
        return false;
    }

    public static int tt(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return n();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return c();
        }
        return 0;
    }
}
