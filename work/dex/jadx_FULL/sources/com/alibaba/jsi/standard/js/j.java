package com.alibaba.jsi.standard.js;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24583a;

    public j(com.alibaba.jsi.standard.b bVar, h hVar, String str) {
        super(bVar, Bridge.createNative(bVar, 12, new Object[]{hVar, str}));
        this.f24583a = null;
    }

    public w a(com.alibaba.jsi.standard.b bVar, w wVar, w[] wVarArr) {
        t();
        int i = 1;
        Object[] objArr = new Object[wVarArr != null ? wVarArr.length + 1 : 1];
        int i2 = 0;
        objArr[0] = wVar;
        if (wVarArr != null) {
            int length = wVarArr.length;
            while (i2 < length) {
                objArr[i] = wVarArr[i2];
                i2++;
                i++;
            }
        }
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, this.u, objArr);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public String c(com.alibaba.jsi.standard.b bVar) {
        Object objCmd;
        t();
        if (this.f24583a == null && (objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, this.u)) != null && (objCmd instanceof String)) {
            this.f24583a = (String) objCmd;
        }
        return this.f24583a;
    }

    public boolean d(com.alibaba.jsi.standard.b bVar) {
        t();
        return Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS, this.u) != null;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean f() {
        return true;
    }

    public j(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
        this.f24583a = null;
    }

    public o a(com.alibaba.jsi.standard.b bVar, w[] wVarArr) {
        t();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE, this.u, wVarArr);
        if (objCmd == null || !(objCmd instanceof o)) {
            return null;
        }
        return (o) objCmd;
    }
}
