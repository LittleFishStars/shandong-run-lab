package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 67})
public class u extends c {
    public String c;
    public long tt;
    public long uj;
    public long ve;

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.c);
            jSONObject.put("preload_size", this.tt);
            jSONObject.put("load_time", this.ve);
            jSONObject.put("local_cache", this.uj);
            c(jSONObject);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(long j) {
        this.ve = j;
    }

    public void ve(long j) {
        this.uj = j;
    }

    public void c(long j) {
        this.tt = j;
    }
}
