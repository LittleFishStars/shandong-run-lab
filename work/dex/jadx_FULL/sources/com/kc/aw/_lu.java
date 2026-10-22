package com.kc.aw;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lu implements NiceVideoPlayer._b {
    public boolean _a;
    public final _lg _b;

    public _lu(_lg _lgVar) {
        this._b = _lgVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (!this._a) {
            this._a = true;
            _la._a()._a(this._b._a2, PtgErrorCode.SDK_RESOURCE_ERROR, "Video play error! what: " + i);
        }
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._a();
        _lg _lgVar = this._b;
        _lgVar._x = true;
        _lgVar._b(0);
        return false;
    }

    @Override // com.kc.aw.component.videoplayer.NiceVideoPlayer._b
    public final void onTimeout() {
        if (!this._a) {
            this._a = true;
            _la._a()._a(this._b._a2, PtgErrorCode.SDK_RENDER_ERROR, "Video timeout");
        }
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._a();
        _lg _lgVar = this._b;
        _lgVar._x = true;
        _lgVar._b(0);
    }
}
