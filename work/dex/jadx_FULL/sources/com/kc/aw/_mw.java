package com.kc.aw;

import android.media.MediaPlayer;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mw implements NiceVideoPlayer._b {
    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // com.kc.aw.component.videoplayer.NiceVideoPlayer._b
    public final void onTimeout() {
    }
}
