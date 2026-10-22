package com.byazt.yhr;

import com.byazt.lz.a;
import com.byazt.lz.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 13})
public class tt implements a {
    public final com.byazt.je.c c;
    public sp tt;

    public tt(com.byazt.je.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.lz.a
    public JSONObject getCustomLocalConfig() {
        return this.c.a();
    }

    @Override // com.byazt.lz.a
    public boolean getHttps() {
        return this.c.n();
    }

    @Override // com.byazt.lz.a
    public Map<String, Object> getLocalExtra() {
        return this.c.uj();
    }

    @Override // com.byazt.lz.a
    public sp getMediationConfigUserInfoForSegment() {
        if (this.tt == null) {
            com.byazt.je.ve veVarVe = this.c.ve();
            if (veVarVe == null) {
                return null;
            }
            this.tt = new ve(veVarVe);
        }
        return this.tt;
    }

    @Override // com.byazt.lz.a
    public String getOpensdkVer() {
        return this.c.sp();
    }

    @Override // com.byazt.lz.a
    public String getPublisherDid() {
        return this.c.c();
    }

    @Override // com.byazt.lz.a
    public boolean isOpenAdnTest() {
        return this.c.tt();
    }

    @Override // com.byazt.lz.a
    public boolean isSupportH265() {
        return this.c.i();
    }

    @Override // com.byazt.lz.a
    public boolean isSupportSplashZoomout() {
        return this.c.da();
    }

    @Override // com.byazt.lz.a
    public boolean isWxInstalled() {
        return this.c.x();
    }

    @Override // com.byazt.lz.a
    public String wxAppId() {
        return this.c.sl();
    }
}
