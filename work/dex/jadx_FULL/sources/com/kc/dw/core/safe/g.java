package com.kc.dw.core.safe;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g implements MediaPlayer.OnInfoListener {
    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            return safeOnInfo(mediaPlayer, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
            return false;
        }
    }

    public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
