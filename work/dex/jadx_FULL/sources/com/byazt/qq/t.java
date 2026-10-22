package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 66})
public class t extends c {
    public t(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.c);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 1;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }
}
