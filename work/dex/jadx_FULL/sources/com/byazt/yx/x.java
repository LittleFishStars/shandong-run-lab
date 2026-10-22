package com.byazt.yx;

import com.byazt.eg.d;
import com.byazt.eg.rl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 71})
public final class x extends d {
    public final String c;
    public final long tt;
    public final com.byazt.mk.n ve;

    public x(String str, long j, com.byazt.mk.n nVar) {
        this.c = str;
        this.tt = j;
        this.ve = nVar;
    }

    @Override // com.byazt.eg.d
    public rl c() {
        String str = this.c;
        if (str != null) {
            return rl.c(str);
        }
        return null;
    }

    @Override // com.byazt.eg.d
    public long tt() {
        return this.tt;
    }

    @Override // com.byazt.eg.d
    public com.byazt.mk.n ve() {
        return this.ve;
    }
}
