package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 20})
public abstract class c implements uj {
    public com.byazt.jzl.a c;

    public void c(com.byazt.jzl.a aVar) {
        this.c = aVar;
    }

    public com.byazt.jzl.a c() {
        return this.c;
    }

    public void c(JSONObject jSONObject) {
        try {
            com.byazt.jzl.a aVar = this.c;
            if (aVar == null || jSONObject == null) {
                return;
            }
            JSONObject passThroughJson = aVar.getPassThroughJson();
            jSONObject.put("pitaya_cache_size", this.c.getPitayaCacheSize());
            jSONObject.put("pitaya_code", this.c.getPitayaCode());
            jSONObject.put("pitaya_msg", this.c.getPitayaErrorMsg());
            jSONObject.put("ext_plugin_code", passThroughJson.optInt("ext_plugin_code"));
            jSONObject.put("package", passThroughJson.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
