package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID})
public class kk {
    public nu c;
    public yp n;
    public q tt;
    public String uj;
    public sv ve;

    public static kk c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        kk kkVar = new kk();
        nu nuVar = new nu();
        kkVar.c = nuVar;
        nuVar.tt(jSONObject.optString("deeplink_url", ""));
        kkVar.tt = q.c(jSONObject.optJSONObject("saas_info"));
        kkVar.ve = sv.c(jSONObject.optJSONObject("live_info"));
        kkVar.uj = jSONObject.optString("ecom_live_params");
        kkVar.n = yp.c(jSONObject.optJSONObject("coupon"));
        if (TextUtils.isEmpty(kkVar.c.tt())) {
            return null;
        }
        return kkVar;
    }

    public sv a() {
        return this.ve;
    }

    public String n() {
        return this.uj;
    }

    public yp tt() {
        return this.n;
    }

    public q uj() {
        return this.tt;
    }

    public nu ve() {
        return this.c;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            nu nuVar = this.c;
            if (nuVar != null) {
                jSONObject.put("deeplink_url", nuVar.tt());
            }
            q qVar = this.tt;
            if (qVar != null) {
                jSONObject.put("saas_info", qVar.c());
            }
            sv svVar = this.ve;
            if (svVar != null) {
                jSONObject.put("live_info", svVar.c());
            }
            String str = this.uj;
            if (str != null) {
                jSONObject.put("ecom_live_params", str);
            }
            yp ypVar = this.n;
            if (ypVar != null) {
                jSONObject.put("coupon", ypVar.c());
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }
}
