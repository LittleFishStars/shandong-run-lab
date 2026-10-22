package com.byazt.qh;

import android.text.TextUtils;
import com.byazt.gj.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 15})
public class uj {
    public String c;
    public n.c tt;

    public uj(n.c cVar) {
        this.tt = cVar;
        if (cVar == null || TextUtils.isEmpty(cVar.c) || TextUtils.equals("00000000-0000-0000-0000-000000000000", cVar.c)) {
            this.c = "error";
        }
    }

    public n.c c() {
        return this.tt;
    }

    public String getType() {
        return this.c;
    }

    public uj(String str) {
        this.c = str;
    }
}
