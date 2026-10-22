package com.byazt.qq;

import android.app.Activity;
import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 15})
public class uj extends c {
    public String gt;
    public String my;
    public int nu;
    public int rh;

    public uj(Activity activity, ic icVar, g gVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, icVar, gVar);
        JSONObject jSONObjectTt = gVar.tt();
        if (jSONObjectTt == null || (jSONObjectOptJSONObject = jSONObjectTt.optJSONObject("coupon")) == null) {
            return;
        }
        this.nu = jSONObjectOptJSONObject.optInt("amount");
        this.rh = jSONObjectOptJSONObject.optInt("threshold");
        this.my = jSONObjectOptJSONObject.optString(CropKey.RESULT_KEY_START_TIME);
        this.gt = jSONObjectOptJSONObject.optString("expire_time");
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        return (this.nu == 0 || this.rh == 0) ? false : true;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.nu);
            jSONObject.put("threshold", "满" + this.rh + "元可用");
            if (TextUtils.isEmpty(this.my)) {
                if (TextUtils.isEmpty(this.gt)) {
                    str = "领取当日起30分钟内有效";
                } else {
                    str = "有效期至" + this.gt;
                }
            } else if (TextUtils.isEmpty(this.gt)) {
                str = "有效期至" + this.my;
            } else {
                str = "有效期" + this.my + "至" + this.gt;
            }
            jSONObject.put(CropKey.RESULT_KEY_START_TIME, this.my);
            jSONObject.put("expire_text", str);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 6;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }
}
