package com.byazt.lph;

import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 15})
public class uj extends HandlerThread {
    public n c;

    public uj() {
        super("csj_openlog");
    }

    public void c(n nVar) {
        this.c = nVar;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        n nVar = this.c;
        if (nVar != null) {
            nVar.ve();
        }
    }
}
