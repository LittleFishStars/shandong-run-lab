package com.byazt.hc;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.qq.da;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1504, 54})
public class ve extends c {
    public ve(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        return (TextUtils.isEmpty(this.sl) || TextUtils.isEmpty(this.t)) ? false : true;
    }

    @Override // com.byazt.hc.c, com.byazt.qq.tt
    public com.byazt.qq.tt.c c(da daVar) {
        return ve(daVar);
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 1;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reward_name", this.sl);
            jSONObject.put("reward_amount", this.t);
            jSONObject.put("extra_info", this.c);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }
}
