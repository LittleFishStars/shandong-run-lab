package com.kc.aw;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ls implements MediaPlayer.OnPreparedListener {
    public final Activity _a;
    public final _lg _b;

    @Keep
    public final class _a implements Runnable {
        public final _ls _a;

        public _a(_ls _lsVar) {
            this._a = _lsVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _la._a()._e(this._a._b._a2);
        }
    }

    public _ls(_lg _lgVar, Activity activity) {
        this._b = _lgVar;
        this._a = activity;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        _h _hVar;
        _lg _lgVar = this._b;
        _lgVar._b(_lgVar._t == 0);
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._a3 = mediaPlayer.getDuration();
        _lg _lgVar2 = this._b;
        ImageView imageView = _lgVar2._H;
        if (imageView != null) {
            imageView.postDelayed(new _lh(_lgVar2), 500L);
        }
        _lg _lgVar3 = this._b;
        Activity activity = this._a;
        if (!_lgVar3._a6.get()) {
            _lgVar3._a6.set(true);
            FrameLayout frameLayout = _lgVar3._G;
            if (frameLayout != null) {
                frameLayout.post(new _lf(_lgVar3, activity));
            }
        }
        _lg _lgVar4 = this._b;
        if (_lgVar4._a5 == null && (_hVar = _lgVar4._b) != null && _hVar._x) {
            _lgVar4._a5 = new _lg._i(_lgVar4, _lgVar4._a3);
            this._b._a(true);
        }
        _fy._a.post(new _a(this));
    }
}
