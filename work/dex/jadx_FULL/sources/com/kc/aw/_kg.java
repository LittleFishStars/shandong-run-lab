package com.kc.aw;

import android.view.View;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kg implements View.OnClickListener {
    public final PtgVideoView _a;

    public _kg(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgCoreVideo ptgCoreVideo = this._a._j;
        if (ptgCoreVideo == null) {
            return;
        }
        if (ptgCoreVideo.getCurrStatus() == 4) {
            this._a._j._c();
        } else {
            this._a._j._d();
        }
    }
}
