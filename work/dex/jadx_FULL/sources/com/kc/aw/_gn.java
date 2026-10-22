package com.kc.aw;

import android.media.MediaPlayer;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gn implements NiceVideoPlayer._b {
    public final _gp _a;

    public _gn(_gp _gpVar) {
        this._a = _gpVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener == null) {
            return false;
        }
        ptgVideoAdListener.onVideoError(i, String.valueOf(i2));
        return false;
    }

    @Override // com.kc.aw.component.videoplayer.NiceVideoPlayer._b
    public final void onTimeout() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERR, "Video Play Timeout!");
        }
    }
}
