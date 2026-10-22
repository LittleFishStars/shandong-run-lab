package com.kc.aw;

import android.widget.ImageView;
import com.kc.aw.component.video.PtgVideoView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kd implements Runnable {
    public final PtgVideoView _a;

    public _kd(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgVideoView ptgVideoView = this._a;
        int i = PtgVideoView._w;
        ptgVideoView.getClass();
        ImageView imageView = this._a._g;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
