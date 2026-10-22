package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStdAutoCompleteAfterFullscreen extends TBMiniAppVideoStd {
    public TBMiniAppVideoStdAutoCompleteAfterFullscreen(Context context) {
        super(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void B() {
        if (this.M == 2) {
            g();
        } else {
            super.B();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a() {
        if (this.M != 2) {
            super.a();
            return;
        }
        RVLogger.d("JiaoZiVideoPlayer", "startVideo [" + hashCode() + "] ");
        E();
        F();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(TBMiniAppVideo.I, 3, 2);
        g.b(getContext()).getWindow().addFlags(128);
        c.a(this.ab);
        c.a().h = this.ac;
        c();
    }

    public TBMiniAppVideoStdAutoCompleteAfterFullscreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
