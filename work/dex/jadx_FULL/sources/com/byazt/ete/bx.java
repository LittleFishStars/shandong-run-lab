package com.byazt.ete;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 126})
public class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28482a;
    public int c;
    public int da;
    public int i;
    public String n;
    public int sl;
    public String sp;
    public int t;
    public String tt;
    public boolean u;
    public int uj;
    public int ve;
    public String x;

    public bx(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.u = true;
        c(jSONObjectOptJSONObject.optInt("live_show_time", 60));
        this.tt = jSONObjectOptJSONObject.optString("live_author_nickname");
        this.ve = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
        this.uj = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
        this.n = jSONObjectOptJSONObject.optString("live_description");
        this.f28482a = jSONObjectOptJSONObject.optString("live_feed_url");
        this.sp = jSONObjectOptJSONObject.optString("live_cover_image_url");
        this.x = jSONObjectOptJSONObject.optString("live_avatar_url");
        this.i = jSONObjectOptJSONObject.optInt("live_avatar_width");
        this.da = jSONObjectOptJSONObject.optInt("live_avatar_height");
        this.sl = jSONObjectOptJSONObject.optInt("live_cover_width");
        this.t = jSONObjectOptJSONObject.optInt("live_cover_height");
    }

    public static String a(ic icVar) {
        bx bxVarYp = yp(icVar);
        return bxVarYp == null ? "" : bxVarYp.n;
    }

    public static int da(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.i;
    }

    public static String i(ic icVar) {
        bx bxVarYp = yp(icVar);
        return bxVarYp == null ? "" : bxVarYp.x;
    }

    public static int n(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.uj;
    }

    public static int sl(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.da;
    }

    public static String sp(ic icVar) {
        bx bxVarYp = yp(icVar);
        return bxVarYp == null ? "" : bxVarYp.f28482a;
    }

    public static int t(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.sl;
    }

    public static int tt(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.c;
    }

    public static int u(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.t;
    }

    public static int uj(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return 0;
        }
        return bxVarYp.ve;
    }

    public static String ve(ic icVar) {
        bx bxVarYp = yp(icVar);
        return bxVarYp == null ? "" : bxVarYp.tt;
    }

    public static String x(ic icVar) {
        bx bxVarYp = yp(icVar);
        return bxVarYp == null ? "" : bxVarYp.sp;
    }

    private static bx yp(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.js();
    }

    public boolean c() {
        return this.u;
    }

    public void c(JSONObject jSONObject) {
        if (this.u) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.c);
                jSONObject2.put("live_author_nickname", this.tt);
                jSONObject2.put("live_author_follower_count", this.ve);
                jSONObject2.put("live_watch_count", this.uj);
                jSONObject2.put("live_description", this.n);
                jSONObject2.put("live_feed_url", this.f28482a);
                jSONObject2.put("live_cover_image_url", this.sp);
                jSONObject2.put("live_avatar_url", this.x);
                jSONObject2.put("live_cover_width", this.sl);
                jSONObject2.put("live_cover_height", this.t);
                jSONObject2.put("live_avatar_width", this.i);
                jSONObject2.put("live_avatar_height", this.da);
                jSONObject2.put("isValid", this.u);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(ic icVar) {
        bx bxVarYp = yp(icVar);
        if (bxVarYp == null) {
            return false;
        }
        return bxVarYp.u;
    }

    public void c(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.c = i;
    }
}
