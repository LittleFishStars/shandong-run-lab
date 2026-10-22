package com.byazt.yhr;

import com.byazt.lz.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 54})
public class ve implements sp {
    public final com.byazt.je.ve c;

    public ve(com.byazt.je.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.lz.sp
    public int getAge() {
        return this.c.n();
    }

    @Override // com.byazt.lz.sp
    public String getChannel() {
        return this.c.ve();
    }

    @Override // com.byazt.lz.sp
    public Map<String, String> getCustomInfos() {
        return this.c.c();
    }

    @Override // com.byazt.lz.sp
    public String getGender() {
        return this.c.a();
    }

    @Override // com.byazt.lz.sp
    public String getSubChannel() {
        return this.c.uj();
    }

    @Override // com.byazt.lz.sp
    public String getUserId() {
        return this.c.tt();
    }

    @Override // com.byazt.lz.sp
    public String getUserValueGroup() {
        return this.c.sp();
    }
}
