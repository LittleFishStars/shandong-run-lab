package com.kc.aw;

import android.view.View;
import com.kc.aw.component.video.PtgVideoView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kh implements View.OnClickListener {
    public final PtgVideoView _a;

    public _kh(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgVideoView ptgVideoView = this._a;
        ptgVideoView.setSoundMute(!ptgVideoView._n);
    }
}
