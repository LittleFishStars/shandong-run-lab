package com.kc.aw;

import android.content.Context;
import android.widget.FrameLayout;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _il extends FrameLayout {
    public _il(Context context) {
        super(context, null, 0);
    }

    public abstract void _a();

    public abstract void _a(int i);

    public abstract void _b();

    public abstract _ij getInfo();

    public abstract PtgCoreVideo getVideoPlayer();

    public abstract void setInfo(_ij _ijVar);

    public abstract void setVideoPlayer(PtgCoreVideo ptgCoreVideo);
}
