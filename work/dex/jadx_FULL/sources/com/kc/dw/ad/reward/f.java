package com.kc.dw.ad.reward;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends com.kc.dw.core.safe.f {
    public f(FullScreenMediaView fullScreenMediaView) {
    }

    @Override // com.kc.dw.core.safe.f
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        LogUtil.e("FullScreenMediaView", "MediaPlayer onError: " + i + " " + i2);
        return false;
    }
}
