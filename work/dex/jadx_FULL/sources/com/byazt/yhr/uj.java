package com.byazt.yhr;

import com.byazt.lz.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 15})
public class uj implements da {
    public final com.byazt.je.tt c;

    public uj(com.byazt.je.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.lz.da
    public List<String> getCustomAppList() {
        return this.c.c();
    }

    @Override // com.byazt.lz.da
    public List<String> getCustomDevImeis() {
        return this.c.tt();
    }

    @Override // com.byazt.lz.da
    public boolean isCanUseOaid() {
        return this.c.ve();
    }

    @Override // com.byazt.lz.da
    public boolean isLimitPersonalAds() {
        return this.c.uj();
    }

    @Override // com.byazt.lz.da
    public boolean isProgrammaticRecommend() {
        return this.c.n();
    }
}
