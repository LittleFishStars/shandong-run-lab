package com.alibaba.jsi.standard.js;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r extends o {
    public r(com.alibaba.jsi.standard.b bVar) {
        super(bVar, Bridge.createNative(bVar, 10));
    }

    public boolean a(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, this.u, new Object[]{wVar}) != null;
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, this.u, new Object[]{wVar}) != null;
    }

    public int c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 0;
        }
        return ((Long) objCmd).intValue();
    }

    public void d(com.alibaba.jsi.standard.b bVar) {
        t();
        Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, this.u);
    }

    public d e(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, this.u);
        if (objCmd == null || !(objCmd instanceof d)) {
            return null;
        }
        return (d) objCmd;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean o() {
        return true;
    }

    public r(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }

    public boolean c(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, this.u, new Object[]{wVar}) != null;
    }
}
