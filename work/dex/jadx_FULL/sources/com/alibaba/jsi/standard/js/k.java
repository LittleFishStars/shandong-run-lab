package com.alibaba.jsi.standard.js;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k extends o {
    public k(com.alibaba.jsi.standard.b bVar) {
        super(bVar, Bridge.createNative(bVar, 9));
    }

    public w a(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 232, this.u, new Object[]{wVar});
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, 234, this.u, new Object[]{wVar}) != null;
    }

    public int c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 0;
        }
        return ((Long) objCmd).intValue();
    }

    public void d(com.alibaba.jsi.standard.b bVar) {
        t();
        Bridge.cmd(bVar, 231, this.u);
    }

    public d e(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 236, this.u);
        if (objCmd == null || !(objCmd instanceof d)) {
            return null;
        }
        return (d) objCmd;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean g() {
        return true;
    }

    public k(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }

    public boolean a(com.alibaba.jsi.standard.b bVar, w wVar, w wVar2) {
        t();
        return Bridge.cmd(bVar, 233, this.u, new Object[]{wVar, wVar2}) != null;
    }

    public boolean c(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, 235, this.u, new Object[]{wVar}) != null;
    }
}
