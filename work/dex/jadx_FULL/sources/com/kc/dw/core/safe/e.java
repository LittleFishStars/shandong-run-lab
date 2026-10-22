package com.kc.dw.core.safe;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements MediaPlayer.OnCompletionListener {
    public void a(MediaPlayer mediaPlayer) {
        throw null;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        try {
            a(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }
}
