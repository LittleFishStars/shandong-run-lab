package com.byazt.ete;

import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.kc.aw.lib.constants.PtgRewardConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 215})
public class yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28523a;
    public long c;
    public long da;
    public String i;
    public String m;
    public boolean n;
    public String nu;
    public String rh;
    public long sl;
    public int sp;
    public int t;
    public String tt;
    public long u;
    public long uj;
    public String ve;
    public long x;
    public String yp;
    public String z;

    public static yp c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        yp ypVar = new yp();
        ypVar.c = jSONObject.optLong(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        ypVar.tt = jSONObject.optString("coupon_meta_id");
        ypVar.ve = jSONObject.optString("unique_id");
        ypVar.uj = jSONObject.optLong("device_id");
        ypVar.n = jSONObject.optBoolean("has_coupon");
        ypVar.f28523a = jSONObject.optInt("coupon_scene");
        ypVar.sp = jSONObject.optInt("type");
        ypVar.x = jSONObject.optLong("threshold");
        ypVar.i = jSONObject.optString("scene_key");
        ypVar.da = jSONObject.optLong("activity_id");
        ypVar.sl = jSONObject.optLong("amount");
        ypVar.t = jSONObject.optInt("action");
        ypVar.u = jSONObject.optLong("style");
        ypVar.yp = jSONObject.optString(CropKey.RESULT_KEY_START_TIME);
        ypVar.z = jSONObject.optString("expire_time");
        ypVar.m = jSONObject.optString("button_text");
        ypVar.nu = jSONObject.optString("extra");
        ypVar.rh = jSONObject.optString("toast");
        return ypVar;
    }

    public int getType() {
        return this.sp;
    }

    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.c);
            jSONObject.put("coupon_meta_id", this.tt);
            jSONObject.put("unique_id", this.ve);
            jSONObject.put("device_id", this.uj);
            jSONObject.put("type", this.sp);
            jSONObject.put("scene_key", this.i);
            jSONObject.put("activity_id", this.da);
            jSONObject.put("value", this.sl);
            jSONObject.put("threshold", this.x);
            jSONObject.put("extra", this.nu);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    public String uj() {
        return this.rh;
    }

    public int ve() {
        return this.f28523a;
    }

    public boolean tt(boolean z) {
        int i;
        boolean z2 = this.n && this.sl > 0;
        if (z) {
            if (z2 && ((i = this.f28523a) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.f28523a == 5) {
            return true;
        }
        return false;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.c);
            jSONObject.put("coupon_meta_id", this.tt);
            jSONObject.put("unique_id", this.ve);
            jSONObject.put("device_id", this.uj);
            jSONObject.put("has_coupon", this.n);
            jSONObject.put("coupon_scene", this.f28523a);
            jSONObject.put("type", this.sp);
            jSONObject.put("threshold", this.x);
            jSONObject.put("scene_key", this.i);
            jSONObject.put("activity_id", this.da);
            jSONObject.put("amount", this.sl);
            jSONObject.put("action", this.t);
            jSONObject.put("style", this.u);
            jSONObject.put(CropKey.RESULT_KEY_START_TIME, this.yp);
            jSONObject.put("expire_time", this.z);
            jSONObject.put("button_text", this.m);
            jSONObject.put("extra", this.nu);
            jSONObject.put("toast", this.rh);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    public void c(String str) {
        this.rh = str;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void c(int i) {
        this.f28523a = i;
    }

    public void c(long j) {
        this.sl = j;
    }
}
