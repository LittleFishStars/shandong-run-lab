package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends com.kc.dw.core.safe.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdVideoTextureView f39191a;

    public f(SsdVideoTextureView ssdVideoTextureView) {
        this.f39191a = ssdVideoTextureView;
    }

    @Override // com.kc.dw.core.safe.f
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        a aVar = this.f39191a.f;
        if (aVar != null) {
            LogUtil.w("NotifyCacheStateHelper", "onError: what:" + i + "  extra:" + i2);
            SdkHandler.runOnMainThread(new c(aVar, i, i2));
        }
        MediaPlayer.OnErrorListener onErrorListener = this.f39191a.d;
        if (onErrorListener != null) {
            return onErrorListener.onError(mediaPlayer, i, i2);
        }
        return false;
    }
}
