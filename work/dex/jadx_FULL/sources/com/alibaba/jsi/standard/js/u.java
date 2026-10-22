package com.alibaba.jsi.standard.js;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u extends l {
    public u(com.alibaba.jsi.standard.b bVar, String str, boolean z) {
        super(bVar, Bridge.createNative(bVar, 5, z ? 1L : 0L, AudioStats.AUDIO_AMPLITUDE_NONE, new Object[]{str}));
    }

    public String c(com.alibaba.jsi.standard.b bVar) {
        Object objCmd;
        t();
        long j = this.u;
        if (j == 0 || (objCmd = Bridge.cmd(bVar, 80, j)) == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public z m(com.alibaba.jsi.standard.b bVar) {
        return q(bVar);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public final w n(com.alibaba.jsi.standard.b bVar) {
        return r(bVar);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public final boolean o(com.alibaba.jsi.standard.b bVar) {
        return s(bVar);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean r() {
        return true;
    }

    public u(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
