package com.byazt.qt;

import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 13})
public class tt {
    public ic c;
    public String tt;
    public JSONObject uj;
    public String ve;

    public static tt c() {
        return new tt();
    }

    public tt tt(String str) {
        this.ve = str;
        return this;
    }

    public static tt c(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        ic icVarC = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString("tag", null);
            try {
                strOptString2 = jSONObject.optString("label", null);
                try {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        icVarC = com.byazt.omf.c.c(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObjectOptJSONObject = null;
                }
            } catch (Exception unused3) {
                strOptString2 = null;
                jSONObjectOptJSONObject = strOptString2;
            }
        } catch (Exception unused4) {
            strOptString = null;
            strOptString2 = null;
        }
        return c().c(strOptString).tt(strOptString2).tt(jSONObjectOptJSONObject).c(icVarC);
    }

    public tt tt(JSONObject jSONObject) {
        this.uj = jSONObject;
        return this;
    }

    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.tt);
            jSONObject.put("label", this.ve);
            JSONObject jSONObject2 = this.uj;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            ic icVar = this.c;
            if (icVar != null) {
                jSONObject.put("material_meta", icVar.yg());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public tt c(ic icVar) {
        this.c = icVar;
        return this;
    }

    public tt c(String str) {
        this.tt = str;
        return this;
    }
}
