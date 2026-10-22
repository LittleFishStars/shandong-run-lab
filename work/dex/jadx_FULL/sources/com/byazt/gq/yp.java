package com.byazt.gq;

import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.rh;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 215})
public class yp implements rh {
    @Override // com.byazt.zz.rh
    public void c(DownloadInfo downloadInfo, int i, int i2) {
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("pause_reserve_wifi", jSONObject, ttVarC);
    }
}
