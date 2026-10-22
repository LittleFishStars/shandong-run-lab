package com.byazt.lph;

import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 46})
public class n {
    public volatile uj c;
    public final com.byazt.vb.n tt;
    public final com.byazt.mv.tt ve;

    public n(com.byazt.vb.n nVar, com.byazt.mv.tt ttVar) {
        this.tt = nVar;
        this.ve = ttVar;
    }

    public void a() {
        com.byazt.vb.uj ujVarUj = this.tt.uj();
        if (ujVarUj != null && ujVarUj.z() != null) {
            ve();
            return;
        }
        uj ujVarN = n();
        ujVarN.c(this);
        ujVarN.start();
    }

    public uj n() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new uj();
                }
            }
        }
        return this.c;
    }

    public Looper sp() {
        com.byazt.vb.uj ujVarUj = this.tt.uj();
        return (ujVarUj == null || ujVarUj.z() == null) ? n().getLooper() : ujVarUj.z();
    }

    public void ve() {
    }
}
