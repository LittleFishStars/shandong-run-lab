package com.kc.aw;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ff implements NiceVideoPlayer._b {
    public final _fa _a;

    public _ff(_fa _faVar) {
        this._a = _faVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        PtgVideoAdListener ptgVideoAdListener;
        _fk _fkVar_a = _fk._a();
        String str = this._a._b;
        String str2 = "Video Play Error! what: " + i;
        _fkVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fkVar_a._e.get(str)) == null) {
            return false;
        }
        ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERR, str2);
        return false;
    }

    @Override // com.kc.aw.component.videoplayer.NiceVideoPlayer._b
    public final void onTimeout() {
        PtgVideoAdListener ptgVideoAdListener;
        _fk _fkVar_a = _fk._a();
        String str = this._a._b;
        _fkVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fkVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERR, "Video Play Timeout!");
    }
}
