package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStdVolumeAfterFullscreen extends TBMiniAppVideoStd {
    public TBMiniAppVideoStdVolumeAfterFullscreen(Context context) {
        super(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void P() {
        super.P();
        c.a().i.a(0.0f, 0.0f);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void p() {
        super.p();
        c.a().i.a(1.0f, 1.0f);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void y() {
        super.y();
        if (this.M == 2) {
            c.a().i.a(1.0f, 1.0f);
        } else {
            c.a().i.a(0.0f, 0.0f);
        }
    }

    public TBMiniAppVideoStdVolumeAfterFullscreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
