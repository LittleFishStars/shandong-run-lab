package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS})
public class ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28501a;
    public String c;
    public JSONObject n;
    public String sp;
    public String tt;
    public String uj;
    public String ve;
    public String x;

    public String a() {
        return this.sp;
    }

    public String c() {
        return this.c;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.c);
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.tt);
            jSONObject.put("url", this.ve);
            jSONObject.put("data", this.uj);
            jSONObject.put("material_type", this.f28501a);
            jSONObject.put("custom_components", this.n);
            jSONObject.put("express_gesture_priority", this.sp);
            jSONObject.put("rule_id", this.x);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    public JSONObject n() {
        return this.n;
    }

    public int sp() {
        return this.f28501a;
    }

    public String tt() {
        return this.tt;
    }

    public String uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public String x() {
        return this.x;
    }

    public static ma c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ma maVar = new ma();
        maVar.c = jSONObject.optString("id");
        maVar.uj = jSONObject.optString("data");
        maVar.ve = jSONObject.optString("url");
        maVar.tt = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        maVar.sp = jSONObject.optString("express_gesture_priority");
        maVar.f28501a = jSONObject.optInt("material_type");
        maVar.n = jSONObject.optJSONObject("custom_components");
        maVar.x = jSONObject.optString("rule_id");
        return maVar;
    }
}
