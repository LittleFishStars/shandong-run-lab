package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class b {
    public boolean c;
    public boolean tt;
    public int uj;
    public int ve;

    public b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("window_landing");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.c = jSONObjectOptJSONObject.optBoolean("can_jump_to_landing", false);
        this.tt = jSONObjectOptJSONObject.optBoolean("can_click_to_landing", false);
        this.ve = jSONObjectOptJSONObject.optInt("auto_to_landing_type", 0);
        this.uj = jSONObjectOptJSONObject.optInt("auto_to_landing_time", 0);
    }

    public static String n(ic icVar) {
        return icVar == null ? "" : icVar.x();
    }

    public static boolean tt(ic icVar) {
        b bVarQy = kp.qy(icVar);
        if (bVarQy == null) {
            return false;
        }
        return bVarQy.tt;
    }

    public static int uj(ic icVar) {
        b bVarQy = kp.qy(icVar);
        if (bVarQy == null) {
            return 0;
        }
        return bVarQy.uj;
    }

    public static int ve(ic icVar) {
        b bVarQy = kp.qy(icVar);
        if (bVarQy == null) {
            return 0;
        }
        return bVarQy.ve;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.c);
            jSONObject2.put("can_click_to_landing", this.tt);
            jSONObject2.put("auto_to_landing_type", this.ve);
            jSONObject2.put("auto_to_landing_time", this.uj);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.byazt.nr.m.ve("parse json:" + e.getMessage());
        }
    }

    public static boolean c(ic icVar) {
        b bVarQy = kp.qy(icVar);
        if (bVarQy == null || !bVarQy.c || pu.c(icVar) == 1) {
            return false;
        }
        if (pu.c(icVar) == 2 && pu.tt(icVar) == 3) {
            return false;
        }
        if (pu.c(icVar) == 2 && pu.tt(icVar) == 7) {
            return false;
        }
        return (icVar.id() == 5 || icVar.id() == 15) && !TextUtils.isEmpty(n(icVar));
    }
}
