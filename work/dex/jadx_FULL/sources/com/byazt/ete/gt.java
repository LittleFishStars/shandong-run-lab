package com.byazt.ete;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28491a;
    public int c;
    public int da;
    public int gr;
    public int gt;
    public String gu;
    public int i;
    public int m;
    public int my;
    public int n;
    public int nu;
    public String qy;
    public int rh;
    public int rl;
    public int sl;
    public int sp;
    public int t;
    public int tt;
    public int u;
    public int uj;
    public int ve;
    public int x;
    public int yp;
    public int z;

    public gt(JSONObject jSONObject) {
        this.c = 0;
        this.tt = 1;
        this.ve = 1;
        this.uj = 1;
        this.n = 1;
        this.f28491a = 0;
        this.sp = 1;
        this.x = 0;
        this.i = 0;
        this.da = 0;
        this.sl = 300;
        this.t = -1;
        this.u = 1;
        this.yp = 1;
        this.z = 31457280;
        this.m = 0;
        this.nu = 0;
        this.rh = 0;
        this.my = 0;
        this.gt = 0;
        this.rl = 0;
        this.gr = 0;
        if (jSONObject == null) {
            return;
        }
        this.sp = jSONObject.optInt("auto_open", 1);
        this.x = jSONObject.optInt("download_mode", 0);
        this.i = jSONObject.optInt("auto_control", 0);
        this.da = jSONObject.optInt("auto_control_choose", 0);
        this.sl = jSONObject.optInt("auto_control_time", 300);
        this.t = jSONObject.optInt("download_type", -1);
        this.u = jSONObject.optInt("if_suspend_download", 1);
        this.c = jSONObject.optInt("if_send_click", 0);
        this.tt = jSONObject.optInt("dl_popup", 1);
        this.ve = jSONObject.optInt("market_popup", 1);
        this.uj = jSONObject.optInt("if_pop_lp", 1);
        this.n = jSONObject.optInt("pop_up_style_id", 1);
        this.yp = jSONObject.optInt("dl_network", 1);
        this.z = jSONObject.optInt("dl_size", 31457280);
        this.m = jSONObject.optInt("if_toast_market", 0);
        this.nu = jSONObject.optInt("enable_download_opt", 0);
        this.rl = jSONObject.optInt("show_7factors_card", 0);
        if (com.byazt.ue.tt.c()) {
            this.rh = 0;
        } else {
            this.rh = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.my = jSONObject.optInt("is_use_obm_convert", 0);
        this.gt = jSONObject.optInt("enable_notification", 0);
        this.f28491a = jSONObject.optInt("open_market_in_app", 0);
        this.gr = jSONObject.optInt("resume_task", 0);
        this.qy = jSONObject.optString("ugen_url");
        String strOptString = jSONObject.optString("ugen_md5");
        this.gu = strOptString;
        com.byazt.xs.da.c(this.qy, strOptString, (com.byazt.xs.ve) null);
    }

    public static int a(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return -1;
        }
        return gtVarGt.t;
    }

    public static boolean c(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt != null && gtVarGt.nu == 1;
    }

    public static boolean da(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt != null && gtVarGt.u == 1;
    }

    private static gt gt(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.u_();
    }

    public static int i(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 300;
        }
        return gtVarGt.sl;
    }

    public static int m(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 0;
        }
        return gtVarGt.rh;
    }

    public static boolean my(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt != null && gtVarGt.f28491a == 1;
    }

    public static int n(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 0;
        }
        return gtVarGt.x;
    }

    public static String nu(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt == null ? "" : gtVarGt.qy;
    }

    public static String rh(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt == null ? "" : gtVarGt.gu;
    }

    public static int sl(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 0;
        }
        return gtVarGt.c;
    }

    public static boolean sp(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt != null && gtVarGt.i == 1;
    }

    public static int t(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 1;
        }
        return gtVarGt.tt;
    }

    public static int tt(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 0;
        }
        return gtVarGt.a();
    }

    public static int u(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 1;
        }
        return gtVarGt.ve;
    }

    public static int uj(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 1;
        }
        return gtVarGt.sp;
    }

    public static String ve(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return "close_obm";
        }
        int iA = gtVarGt.a();
        String strGr = icVar.gr();
        if (iA == 1 && !TextUtils.isEmpty(strGr)) {
            return "open";
        }
        return "close_" + iA + LoginConstants.UNDER_LINE + strGr;
    }

    public static boolean x(ic icVar) {
        gt gtVarGt = gt(icVar);
        return gtVarGt != null && gtVarGt.da == 1;
    }

    public static int yp(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 0;
        }
        return gtVarGt.gr;
    }

    public static int z(ic icVar) {
        gt gtVarGt = gt(icVar);
        if (gtVarGt == null) {
            return 1;
        }
        return gtVarGt.n;
    }

    public static boolean a(gt gtVar) {
        return gtVar != null && gtVar.m == 1;
    }

    public static int c(gt gtVar) {
        if (gtVar == null) {
            return 1;
        }
        return gtVar.tt;
    }

    public static int n(gt gtVar) {
        if (gtVar == null) {
            return 31457280;
        }
        return gtVar.z * 1048576;
    }

    public static int tt(gt gtVar) {
        if (gtVar == null) {
            return 1;
        }
        return gtVar.ve;
    }

    public static int uj(gt gtVar) {
        if (gtVar == null) {
            return 1;
        }
        return gtVar.yp;
    }

    public int sp() {
        return this.rh;
    }

    public int a() {
        return this.my;
    }

    public int c() {
        return this.tt;
    }

    public boolean n() {
        return this.u == 1;
    }

    public int tt() {
        return this.x;
    }

    public int uj() {
        return this.t;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.sp);
            jSONObject2.put("download_mode", this.x);
            jSONObject2.put("download_type", this.t);
            jSONObject2.put("auto_control", this.i);
            jSONObject2.put("auto_control_choose", this.da);
            jSONObject2.put("auto_control_time", this.sl);
            jSONObject2.put("if_suspend_download", this.u);
            jSONObject2.put("if_send_click", this.c);
            jSONObject2.put("dl_popup", this.tt);
            jSONObject2.put("market_popup", this.ve);
            jSONObject2.put("if_pop_lp", this.uj);
            jSONObject2.put("pop_up_style_id", this.n);
            jSONObject2.put("dl_network", this.yp);
            jSONObject2.put("dl_size", this.z);
            jSONObject2.put("if_toast_market", this.m);
            jSONObject2.put("enable_download_opt", this.nu);
            jSONObject2.put("dl_suspend_popup", this.rh);
            jSONObject2.put("is_use_obm_convert", this.my);
            jSONObject2.put("ugen_url", this.qy);
            jSONObject2.put("ugen_md5", this.gu);
            jSONObject2.put("enable_notification", this.gt);
            jSONObject2.put("show_7factors_card", this.rl);
            jSONObject2.put("open_market_in_app", this.f28491a);
            jSONObject2.put("resume_task", this.gr);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static int ve(gt gtVar) {
        if (gtVar == null) {
            return 1;
        }
        return gtVar.uj;
    }

    public boolean ve() {
        return this.rl == 1;
    }
}
