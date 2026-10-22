package com.byazt.lu;

import android.text.TextUtils;
import com.byazt.ds.i;
import com.byazt.nr.m;
import com.byazt.yv.da;
import com.byazt.yv.u;
import com.huachenjie.shandong_school.splash.SplashActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 46})
public class n extends tt {
    public boolean n;
    public static final long[] tt = {920000};
    public static final long[] ve = {920000};
    public static final long[] uj = {10000, 10000, 20000, 20000, 60000, SplashActivity.f36053a, 180000, 180000, 540000, 540000};

    public n(uj ujVar) {
        super(ujVar);
        this.n = true;
    }

    @Override // com.byazt.lu.tt
    public long c() {
        return this.c.uj().u() + ((long) (this.c.a().ve() ? 21600000 : 43200000));
    }

    @Override // com.byazt.lu.tt
    public long[] tt() {
        int iT = this.c.uj().t();
        if (iT == 0) {
            return uj;
        }
        if (iT == 1) {
            return ve;
        }
        if (iT == 2) {
            return tt;
        }
        da.tt((Throwable) null);
        return ve;
    }

    @Override // com.byazt.lu.tt
    public String uj() {
        return "r";
    }

    @Override // com.byazt.lu.tt
    public boolean ve() throws JSONException {
        JSONObject jSONObjectC;
        JSONObject jSONObject = new JSONObject();
        i iVarUj = this.c.uj();
        JSONObject jSONObjectC2 = iVarUj.c();
        JSONObject jSONObject2 = null;
        if (jSONObjectC2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (iVarUj) {
                jSONObjectC = u.c(jSONObjectC2);
            }
            jSONObject.put("header", jSONObjectC);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectC.optString("device_id")) && u.ve() && this.n) {
                this.n = false;
                return false;
            }
            JSONObject jSONObjectC3 = this.c.uj().c();
            com.byazt.mp.ve veVarC = com.byazt.mp.c.c(com.byazt.mp.tt.c(this.c.getContext(), jSONObjectC3, this.c.sp().c(), true, com.byazt.gj.c.uj()), jSONObject);
            if (veVarC != null && veVarC.c() != null) {
                try {
                    jSONObject2 = new JSONObject(veVarC.c());
                } catch (JSONException e) {
                    m.c(e);
                }
            }
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("device_id", "");
                boolean zC = this.c.uj().c(jSONObject2, strOptString, jSONObject2.optString("install_id", ""), jSONObject2.optString("ssid", ""));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                jSONObject3.put("headers", veVarC.tt());
                u.tt(jSONObject, jSONObject3);
                com.byazt.tf.c.tt("__kite", "start:" + u.n());
                try {
                    if (u.n()) {
                        new com.byazt.az.tt(this.c.getContext()).c(jSONObjectC3, strOptString);
                    }
                } catch (Throwable th) {
                    com.byazt.tf.c.c("__kite", "error:" + u.n(), th);
                }
                return zC;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("headers", veVarC.tt());
            u.tt(jSONObject, jSONObject4);
        } else {
            da.tt((Throwable) null);
        }
        return false;
    }
}
