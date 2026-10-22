package com.kc.aw;

import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ke implements Runnable {
    public final PtgVideoView _a;

    public _ke(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgCoreVideo ptgCoreVideo;
        PtgVideoView ptgVideoView = this._a;
        if ((!_id._a(ptgVideoView._b) || (ptgCoreVideo = ptgVideoView._j) == null || ptgCoreVideo.getCurrStatus() == 7 || ptgVideoView._j.getCurrStatus() == 3) ? false : true) {
            PtgVideoView ptgVideoView2 = this._a;
            if (ptgVideoView2._j == null || ptgVideoView2.getWindowVisibility() != 0) {
                return;
            }
            if (this._a._j.getCurrStatus() == 4) {
                this._a._j._c();
            } else {
                this._a.getClass();
                this._a._j._d();
            }
        }
    }
}
