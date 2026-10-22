package com.byazt.ete;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 213})
public class oz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28506a;
    public boolean c;
    public String n;
    public int sp;
    public int tt;
    public String uj;
    public int ve;

    public oz(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.f28506a = true;
        this.c = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
        this.tt = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
        this.ve = jSONObjectOptJSONObject.optInt("card_click_area", 2);
        this.n = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
        int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
        this.sp = iOptInt;
        if (iOptInt == 1) {
            this.uj = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.uj = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public static int a(ic icVar) {
        int i;
        oz ozVarT = t(icVar);
        if (ozVarT != null && (i = ozVarT.tt) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    public static int da(ic icVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(u(icVar), "tt_sp");
        int i2 = veVarC.get("splash_card_show_day", -1);
        int i3 = veVarC.get("splash_card_show_count", 0);
        if (i2 == i) {
            return i3;
        }
        return 0;
    }

    public static void i(ic icVar) {
        int i = Calendar.getInstance().get(7);
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(u(icVar), "tt_sp");
        int i2 = veVarC.get("splash_card_show_day", -1) == i ? veVarC.get("splash_card_show_count", 0) : 0;
        veVarC.put("splash_card_show_day", i);
        veVarC.put("splash_card_show_count", i2 + 1);
    }

    public static int n(ic icVar) {
        oz ozVarT = t(icVar);
        if (ozVarT == null) {
            return 0;
        }
        return ozVarT.sp;
    }

    public static boolean sl(ic icVar) {
        if (icVar == null || icVar.te() == null || !icVar.te().n() || icVar.pa() == null || icVar.pa().isEmpty() || !icVar.pa().get(0).n() || TextUtils.isEmpty(icVar.v_())) {
            return false;
        }
        if (TextUtils.isEmpty(icVar.an())) {
            return (icVar.z() == null || TextUtils.isEmpty(icVar.z().ve())) ? false : true;
        }
        return true;
    }

    public static boolean sp(ic icVar) {
        oz ozVarT = t(icVar);
        return ozVarT == null || ozVarT.ve == 1;
    }

    private static oz t(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.yo();
    }

    public static void tt(ic icVar) {
        oz ozVarT = t(icVar);
        if (ozVarT == null || icVar.bw() || icVar.by() == 2 || !ozVarT.f28506a || da(icVar) >= com.byazt.omf.gt.tt().fq()) {
            return;
        }
        com.byazt.ddx.uj.ve(icVar, "splash_ad", "if_splash_card");
        if (sl(icVar)) {
            return;
        }
        com.byazt.ddx.uj.ve(icVar, "splash_ad", "card_show_fail");
    }

    private static String u(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.jl();
    }

    public static String uj(ic icVar) {
        oz ozVarT = t(icVar);
        if (ozVarT == null) {
            return "点击跳转";
        }
        if (n(icVar) == 1) {
            return TextUtils.isEmpty(ozVarT.uj) ? "摇一摇或点击了解更多" : ozVarT.uj;
        }
        return TextUtils.isEmpty(ozVarT.uj) ? "点击跳转" : ozVarT.uj;
    }

    public static String ve(ic icVar) {
        oz ozVarT = t(icVar);
        return (ozVarT == null || TextUtils.isEmpty(ozVarT.n)) ? "详情页或第三方应用" : ozVarT.n;
    }

    public static boolean x(ic icVar) {
        oz ozVarT = t(icVar);
        if (ozVarT == null) {
            return true;
        }
        return ozVarT.c;
    }

    public void c(JSONObject jSONObject) {
        try {
            if (this.f28506a) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.c);
                jSONObject2.put("card_stay_count_down", this.tt);
                jSONObject2.put("card_click_area", this.ve);
                jSONObject2.put("card_text", this.n);
                jSONObject2.put("card_top_text", this.uj);
                jSONObject2.put("splash_card_style_id", this.sp);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static boolean c(ic icVar) {
        oz ozVarT = t(icVar);
        if (ozVarT != null && !icVar.bw() && icVar.by() != 2 && ozVarT.f28506a && da(icVar) < com.byazt.omf.gt.tt().fq() && sl(icVar)) {
            return ozVarT.f28506a;
        }
        return false;
    }
}
