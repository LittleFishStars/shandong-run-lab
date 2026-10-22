package com.kc.dw.core.safe;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements MediaPlayer.OnErrorListener {
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        throw null;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            return a(mediaPlayer, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
            return false;
        }
    }
}
