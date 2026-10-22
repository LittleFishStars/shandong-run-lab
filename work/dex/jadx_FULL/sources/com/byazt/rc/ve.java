package com.byazt.rc;

import com.byazt.yj.a;
import com.byazt.yj.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 54})
public class ve implements a {
    public String c;
    public boolean tt;
    public gt uj;
    public boolean ve;

    public ve(String str, boolean z, boolean z2, gt gtVar) {
        this.c = str;
        this.tt = z;
        this.ve = z2;
        this.uj = gtVar;
    }

    @Override // com.byazt.yj.a
    public String c() {
        return this.c;
    }

    @Override // com.byazt.yj.a
    public boolean tt() {
        return this.tt;
    }

    @Override // com.byazt.yj.a
    public gt uj() {
        return this.uj;
    }

    @Override // com.byazt.yj.a
    public boolean ve() {
        return this.ve;
    }
}
