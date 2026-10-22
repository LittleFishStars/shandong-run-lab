package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY})
public class qp {
    public boolean c;
    public int tt;

    public qp(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.c = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.tt = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    public static boolean tt(ic icVar) {
        qp qpVarVe = ve(icVar);
        return qpVarVe != null && qpVarVe.tt == 1;
    }

    private static qp ve(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.fb();
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.c ? 1 : 0);
            jSONObject2.put("filter_track", this.tt);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
    }

    public static boolean c(ic icVar) {
        qp qpVarVe = ve(icVar);
        if (qpVarVe == null) {
            return false;
        }
        return qpVarVe.c;
    }
}
