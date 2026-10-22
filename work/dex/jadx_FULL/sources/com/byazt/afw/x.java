package com.byazt.afw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 71})
public class x implements uj {
    public long c;
    public long tt;
    public Map<String, Object> uj;
    public int ve;

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.uj;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.c);
            jSONObject.put("total_duration", this.tt);
            jSONObject.put("vbtt_skip_type", this.ve);
        } catch (Throwable th2) {
            com.byazt.nr.m.c(th2);
        }
    }

    public void c(int i) {
        this.ve = i;
    }

    public void tt(long j) {
        this.tt = j;
    }

    public void c(long j) {
        this.c = j;
    }

    public void c(Map<String, Object> map) {
        this.uj = map;
    }
}
