package com.kc.aw;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.aw.component.video.PtgVideoView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ki implements Runnable {
    public final FrameLayout.LayoutParams _a;
    public final PtgVideoView _b;

    public _ki(PtgVideoView ptgVideoView, FrameLayout.LayoutParams layoutParams) {
        this._b = ptgVideoView;
        this._a = layoutParams;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout.LayoutParams layoutParams;
        ImageView imageView = this._b._g;
        if (imageView == null || (layoutParams = this._a) == null) {
            return;
        }
        imageView.setLayoutParams(layoutParams);
        this._b._g.setVisibility(0);
    }
}
