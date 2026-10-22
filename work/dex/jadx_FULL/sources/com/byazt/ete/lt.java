package com.byazt.ete;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 438})
public class lt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28500a;
    public boolean c;
    public int da;
    public int i;
    public boolean m;
    public int n;
    public String sl;
    public boolean sp;
    public String t;
    public int tt;
    public int u;
    public int uj;
    public boolean ve;
    public int x;
    public boolean yp;
    public int z;

    public lt(JSONObject jSONObject) {
        this.da = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.tt = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.uj = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 30);
            this.n = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.f28500a = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.sp = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.x = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.i = jSONObjectOptJSONObject.optInt("tip_time", 0);
            this.da = jSONObjectOptJSONObject.optInt("show_type", 0);
            this.ve = jSONObjectOptJSONObject.optBoolean("single_max_countdown", false);
            this.sl = jSONObjectOptJSONObject.optString("top_template_url");
            this.t = jSONObjectOptJSONObject.optString("top_template_md5");
            this.u = jSONObjectOptJSONObject.optInt("top_template_timeout");
            this.yp = jSONObjectOptJSONObject.optBoolean("can_cancel");
            this.z = jSONObjectOptJSONObject.optInt("init_status_time", 0);
            this.m = jSONObjectOptJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.tt = 10;
            this.uj = 30;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("group_info");
        if (jSONObjectOptJSONObject2 != null) {
            this.c = !TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("group_id"));
        }
    }

    public static boolean a(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return false;
        }
        return ltVarNu.sp;
    }

    public static boolean da(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return false;
        }
        return ltVarNu.ve;
    }

    public static int i(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 25;
        }
        return ltVarNu.i;
    }

    public static boolean m(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return false;
        }
        return ltVarNu.m;
    }

    public static int n(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 0;
        }
        return ltVarNu.f28500a;
    }

    private static lt nu(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.xo();
    }

    public static String sl(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return null;
        }
        return ltVarNu.sl;
    }

    public static int sp(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 10;
        }
        return ltVarNu.x == 1 ? Math.min((int) Math.max(xd.sp(icVar), ve(icVar)), 60) : ve(icVar);
    }

    public static String t(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return null;
        }
        return ltVarNu.t;
    }

    public static int tt(ic icVar) {
        int i;
        lt ltVarNu = nu(icVar);
        if (ltVarNu != null && (i = ltVarNu.tt) > 0) {
            return i;
        }
        return 10;
    }

    public static int u(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 0;
        }
        return ltVarNu.u;
    }

    public static int uj(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 0;
        }
        return ltVarNu.n;
    }

    public static int ve(ic icVar) {
        int i;
        lt ltVarNu = nu(icVar);
        if (ltVarNu != null && (i = ltVarNu.uj) > 0) {
            return i;
        }
        return 30;
    }

    public static boolean x(ic icVar) {
        lt ltVarNu = nu(icVar);
        return ltVarNu != null && c(icVar) && ltVarNu.da == 1;
    }

    public static boolean yp(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return false;
        }
        return ltVarNu.yp;
    }

    public static int z(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return 0;
        }
        return ltVarNu.z;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.tt);
            jSONObject2.put("draw_rewarded_play_time", this.uj);
            jSONObject2.put("skip_btn_left_style", this.n);
            jSONObject2.put("skip_btn_right_style", this.f28500a);
            jSONObject2.put("auto_slide", this.sp);
            jSONObject2.put("show_time_type", this.x);
            jSONObject2.put("show_type", this.da);
            jSONObject2.put("tip_time", this.i);
            jSONObject2.put("single_max_countdown", this.ve);
            jSONObject2.put("top_template_url", this.sl);
            jSONObject2.put("top_template_md5", this.t);
            jSONObject2.put("top_template_timeout", this.u);
            jSONObject2.put("can_cancel", this.yp);
            jSONObject2.put("init_status_time", this.z);
            jSONObject2.put("is_pause_tip_by_express", this.m);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static boolean c(ic icVar) {
        lt ltVarNu = nu(icVar);
        if (ltVarNu == null) {
            return false;
        }
        return ltVarNu.c;
    }
}
