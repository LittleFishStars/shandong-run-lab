package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL})
public class lo {
    public int c;

    public lo(JSONObject jSONObject) {
        this.c = 0;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optInt("playable_reward_type", 0);
    }

    public static int tt(ic icVar) {
        com.byazt.jzl.uj ujVarYp = xd.yp(icVar);
        String resolution = ujVarYp != null ? ujVarYp.getResolution() : null;
        try {
            if (TextUtils.isEmpty(resolution)) {
                return 0;
            }
            String[] strArrSplit = resolution.split("x");
            if (strArrSplit.length >= 2 && Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static lo ve(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.gx();
    }

    public void c(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.c);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static int c(ic icVar) {
        int i;
        lo loVarVe = ve(icVar);
        if (loVarVe == null || (i = loVarVe.c) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.byazt.omf.gt.tt().kp()) || my.u(icVar)) {
            return loVarVe.c;
        }
        return 1;
    }
}
