package com.byazt.vo;

import com.byazt.nc.a;
import com.byazt.nc.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, 20})
public class c extends uj {
    public final tt c;

    public c(tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.nc.uj
    public List<a> getFilterWords() {
        tt ttVar = this.c;
        if (ttVar == null) {
            return null;
        }
        return ttVar.c();
    }
}
