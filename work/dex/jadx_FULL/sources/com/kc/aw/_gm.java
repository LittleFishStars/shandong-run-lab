package com.kc.aw;

import android.media.MediaPlayer;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gm implements MediaPlayer.OnCompletionListener {
    public final _gp _a;

    public _gm(_gp _gpVar) {
        this._a = _gpVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoComplete();
        }
    }
}
