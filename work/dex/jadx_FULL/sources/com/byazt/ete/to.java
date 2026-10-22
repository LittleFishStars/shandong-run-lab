package com.byazt.ete;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 607})
public class to {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28512a;
    public int c;
    public int n;
    public int tt;
    public int uj;
    public String ve;

    public to(JSONObject jSONObject) {
        this.f28512a = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.f28512a = true;
            tt(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            ve(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            c(jSONObjectOptJSONObject.optString("reward_live_text"));
            c(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            uj(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    public static String a(ic icVar) {
        to toVarI = i(icVar);
        return toVarI == null ? "去抖音观看直播\n可提前5s获得奖励哦" : toVarI.ve;
    }

    private static to i(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.jc();
    }

    public static int n(ic icVar) {
        to toVarI = i(icVar);
        if (toVarI == null) {
            return 1;
        }
        return toVarI.tt;
    }

    public static int sp(ic icVar) {
        to toVarI = i(icVar);
        if (toVarI == null) {
            return 5;
        }
        return Math.max(toVarI.uj, 0);
    }

    public static int tt(ic icVar) {
        to toVarI = i(icVar);
        if (toVarI == null) {
            return 1;
        }
        return toVarI.c;
    }

    public static boolean uj(ic icVar) {
        int i;
        to toVarI = i(icVar);
        return toVarI != null && toVarI.f28512a && com.byazt.apd.tt.c().c(icVar) && ((i = toVarI.c) == 3 || i == 4);
    }

    public static boolean ve(ic icVar) {
        to toVarI = i(icVar);
        return toVarI == null || !toVarI.f28512a || toVarI.c == 1;
    }

    public static int x(ic icVar) {
        to toVarI = i(icVar);
        if (toVarI == null) {
            return 10;
        }
        return Math.max(toVarI.n, 3);
    }

    public void c(JSONObject jSONObject) {
        if (this.f28512a) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.c);
                jSONObject2.put("reward_live_style", this.tt);
                jSONObject2.put("reward_live_text", this.ve);
                jSONObject2.put("reward_start_time", this.uj);
                jSONObject2.put("reward_close_time", this.n);
                jSONObject2.put("isValid", this.f28512a);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
        }
    }

    private void tt(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.c = i;
    }

    private void uj(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.n = i;
    }

    private void ve(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.tt = i;
    }

    public static boolean c(ic icVar) {
        to toVarI = i(icVar);
        if (toVarI == null) {
            return false;
        }
        return toVarI.f28512a;
    }

    public boolean c() {
        return this.f28512a;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.tt == 3 ? "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦" : "去抖音观看直播\n可提前5s获得奖励哦";
        }
        this.ve = str;
    }

    public void c(int i) {
        this.uj = i;
    }
}
