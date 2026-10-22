package com.byazt.ng;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 13})
public class tt {
    public static volatile tt c;
    public List<c> tt = new CopyOnWriteArrayList();

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public uj c;
        public JSONObject tt;

        public c(uj ujVar, JSONObject jSONObject) {
            this.c = ujVar;
            this.tt = jSONObject;
        }

        public uj c() {
            return this.c;
        }

        public JSONObject tt() {
            return com.byazt.ng.c.c(this.c, this.tt);
        }
    }

    private tt() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public List<c> tt() {
        return this.tt;
    }

    public void ve() {
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- event 清空埋点辅助模块");
        List<c> list = this.tt;
        if (list != null) {
            list.clear();
        }
    }

    public void c(uj ujVar, JSONObject jSONObject) {
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- event 保存到埋点辅助模块");
        this.tt.add(new c(ujVar, jSONObject));
    }
}
