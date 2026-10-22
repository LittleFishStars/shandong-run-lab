package com.alibaba.jsi.standard.js;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n extends o {
    public n(com.alibaba.jsi.standard.b bVar, double d) {
        super(bVar, Bridge.createNative(bVar, 16, 0L, d));
    }

    public double c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 300, this.u);
        return (objCmd == null || !(objCmd instanceof m)) ? AudioStats.AUDIO_AMPLITUDE_NONE : ((m) objCmd).c_();
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean d_() {
        return true;
    }

    public n(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
