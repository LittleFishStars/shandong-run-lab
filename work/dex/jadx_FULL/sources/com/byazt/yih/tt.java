package com.byazt.yih;

import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 13})
public class tt implements com.byazt.aas.c.tt {

    @com.byazt.zqa.c(c = {0, 1, 730, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public static tt c = new tt();
    }

    public static tt c() {
        return c.c;
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        com.byazt.bzd.x.c(new com.byazt.bwm.sp("dl_work") { // from class: com.byazt.yih.tt.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.omf.x.m().c(i.c((ic) null, true));
            }
        });
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    private tt() {
        com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        if (cVarVe != null) {
            cVarVe.c(this);
        }
    }
}
