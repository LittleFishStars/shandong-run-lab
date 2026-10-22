package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i extends com.kc.dw.core.safe.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SsdVideoTextureView f39193a;

    public i(SsdVideoTextureView ssdVideoTextureView) {
        this.f39193a = ssdVideoTextureView;
    }

    @Override // com.kc.dw.core.safe.g
    public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
        LogUtil.d(this.f39193a.f39180a, "media player info: " + i + " " + i2);
        MediaPlayer.OnInfoListener onInfoListener = this.f39193a.h;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(mediaPlayer, i, i2);
        }
        return true;
    }
}
