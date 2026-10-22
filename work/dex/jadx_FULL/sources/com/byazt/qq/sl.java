package com.byazt.qq;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 158})
public class sl extends c {
    public sl(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        if (!kp.ve(this.sp)) {
            return false;
        }
        try {
            return (Integer.parseInt(this.t) == 0 || TextUtils.isEmpty(this.t) || TextUtils.isEmpty(this.sl)) ? false : true;
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.c + "s 可获得奖励");
            jSONObject.put("number", this.t);
            jSONObject.put("number_unit", this.sl);
            jSONObject.put("remain_time", this.c);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 2;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }
}
