package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 91})
public class sp implements uj {
    public long c;
    public long tt;
    public int ve = 0;

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.c);
            jSONObject.put("buffers_time", this.tt);
            jSONObject.put("video_backup", this.ve);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public void c(long j) {
        this.c = j;
    }

    public void tt(long j) {
        this.tt = j;
    }

    public void c(int i) {
        this.ve = i;
    }
}
