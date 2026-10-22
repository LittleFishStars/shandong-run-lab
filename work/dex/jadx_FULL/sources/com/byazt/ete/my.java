package com.byazt.ete;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 145})
public class my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28502a;
    public String c;
    public int da;
    public String i;
    public int n;
    public boolean sp;
    public int tt;
    public int uj;
    public int ve;
    public String x;

    public my(JSONObject jSONObject) {
        this.tt = 0;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("reward_browse_type", 0);
        this.tt = iOptInt;
        if (iOptInt < 0 || iOptInt > 3) {
            this.tt = 0;
        }
        if (this.tt == 2) {
            this.tt = 3;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (jSONObjectOptJSONObject != null) {
            this.c = jSONObjectOptJSONObject.optString("direct_landing_url");
            this.ve = jSONObjectOptJSONObject.optInt("display_duration", 0);
            this.uj = jSONObjectOptJSONObject.optInt("close_time", 0);
            this.n = jSONObjectOptJSONObject.optInt("page_type");
            this.f28502a = jSONObjectOptJSONObject.optInt("show_type");
            this.sp = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
            if (jSONObjectOptJSONObject2 != null) {
                this.x = jSONObjectOptJSONObject2.optString("ugen_url");
                this.i = jSONObjectOptJSONObject2.optString("ugen_md5");
            }
            this.da = jSONObjectOptJSONObject.optInt("close_btn_position");
        }
    }

    public static boolean a(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && myVarRh.n == 3;
    }

    public static int da(ic icVar) {
        my myVarRh = rh(icVar);
        if (myVarRh == null) {
            return 0;
        }
        return myVarRh.tt;
    }

    public static boolean i(ic icVar) {
        my myVarRh = rh(icVar);
        if (myVarRh == null) {
            return false;
        }
        return myVarRh.sp;
    }

    public static boolean m(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && myVarRh.da == 2;
    }

    public static boolean n(ic icVar) {
        my myVarRh = rh(icVar);
        if (myVarRh == null || myVarRh.n != 4) {
            return false;
        }
        int iSl = com.byazt.aas.nb.sl(icVar);
        return iSl == 3 || iSl == 4 || iSl == 5 || iSl == 9;
    }

    public static int nu(ic icVar) {
        my myVarRh = rh(icVar);
        if (myVarRh == null) {
            return 0;
        }
        return myVarRh.da;
    }

    private static my rh(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.pn();
    }

    public static int sl(ic icVar) {
        int i;
        my myVarRh = rh(icVar);
        if (myVarRh != null && (i = myVarRh.ve) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean sp(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && myVarRh.f28502a == 3;
    }

    public static int t(ic icVar) {
        int i;
        my myVarRh = rh(icVar);
        if (myVarRh != null && (i = myVarRh.uj) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean tt(ic icVar) {
        if (c(icVar)) {
            return i(icVar);
        }
        return false;
    }

    public static boolean u(ic icVar) {
        return rh(icVar) != null && da(icVar) == 3 && c(icVar);
    }

    public static boolean uj(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && c(icVar) && myVarRh.tt == 1 && myVarRh.n == 2;
    }

    public static boolean ve(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && myVarRh.tt == 1 && myVarRh.n == 1;
    }

    public static String x(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh == null ? "" : myVarRh.c;
    }

    public static com.byazt.seg.c yp(ic icVar) {
        my myVarRh = rh(icVar);
        if (myVarRh == null || TextUtils.isEmpty(myVarRh.x)) {
            return null;
        }
        com.byazt.seg.c cVar = new com.byazt.seg.c();
        cVar.ve(myVarRh.x);
        cVar.tt(myVarRh.i);
        cVar.c(myVarRh.x);
        return cVar;
    }

    public static boolean z(ic icVar) {
        my myVarRh = rh(icVar);
        return myVarRh != null && myVarRh.da == 1;
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.tt);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.c);
            jSONObject2.put("display_duration", this.ve);
            jSONObject2.put("close_time", this.uj);
            jSONObject2.put("page_type", this.n);
            jSONObject2.put("show_type", this.f28502a);
            jSONObject2.put("close_btn_position", this.da);
            jSONObject2.put("is_landing_with_sound", this.sp);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.x);
            jSONObject3.put("ugen_md5", this.i);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e2) {
            com.byazt.nr.m.c(e2);
        }
    }

    public static boolean c(ic icVar) {
        my myVarRh = rh(icVar);
        return (myVarRh == null || da(icVar) == 0 || TextUtils.isEmpty(myVarRh.c)) ? false : true;
    }
}
