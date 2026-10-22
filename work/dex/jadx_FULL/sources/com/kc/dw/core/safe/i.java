package com.kc.dw.core.safe;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i implements MediaPlayer.OnVideoSizeChangedListener {
    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            safeOnVideoSizeChanged(mediaPlayer, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }

    public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }
}
