package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ii extends _il implements View.OnClickListener {
    public PtgCoreVideo _a;
    public _ij _b;
    public _jp _c;
    public final Handler _d;
    public final _a _e;

    @Keep
    public final class _a implements Runnable {
        public final _ii _a;

        public _a(_ii _iiVar) {
            this._a = _iiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int currentPosition = this._a._a.getCurrentPosition();
            int duration = this._a._a.getDuration();
            _jp _jpVar = this._a._c;
            if (_jpVar != null) {
                long j = duration;
                long j2 = currentPosition;
                _k9._b _bVar = ((_kj) _jpVar)._b;
                if (_bVar != null) {
                    _bVar._a(j, j2);
                }
            }
            this._a._d.removeCallbacks(this);
            _ii _iiVar = this._a;
            _iiVar._d.postDelayed(_iiVar._e, 1000L);
        }
    }

    public _ii(Context context) {
        super(context);
        this._d = new Handler();
        this._e = new _a(this);
    }

    @Override // com.kc.aw._il
    public final void _a() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    /* JADX WARN: Code duplicated, block: B:17:0x002f  */
    @Override // com.kc.aw._il
    public final void _a(int i) {
        if (i == -1 || i == 0) {
            _d();
        } else if (i == 3) {
            _c();
        } else if (i == 4) {
            _d();
        } else if (i == 7) {
            _d();
            int duration = this._a.getDuration();
            _jp _jpVar = this._c;
            if (_jpVar != null) {
                long j = duration;
                _k9._b _bVar = ((_kj) _jpVar)._b;
                if (_bVar != null) {
                    _bVar._a(j, j);
                }
            }
        } else if (i == 10) {
            _c();
        }
        _jp _jpVar2 = this._c;
        if (_jpVar2 != null) {
            _kj _kjVar = (_kj) _jpVar2;
            _kjVar._c.getClass();
            if (4 == i) {
                _kn _knVar = _kjVar._c._k;
                if (_knVar != null) {
                    _knVar._n.set(2);
                }
                _kjVar._c._a(true);
                _kc _kcVar = _kjVar._c._s;
                if (_kcVar != null) {
                    _kcVar.onVideoPause();
                    return;
                }
                return;
            }
            if (3 == i) {
                _kn _knVar2 = _kjVar._c._k;
                if (_knVar2 != null) {
                    _knVar2._n.set(1);
                }
                _kjVar._c._a(false);
                PtgVideoView ptgVideoView = _kjVar._c;
                ImageView imageView = ptgVideoView._g;
                if (imageView != null) {
                    imageView.postDelayed(new _kd(ptgVideoView), 500L);
                }
                _kc _kcVar2 = _kjVar._c._s;
                if (_kcVar2 != null) {
                    if (!_kjVar._a) {
                        _kcVar2.onVideoResume();
                        return;
                    } else {
                        _kjVar._a = false;
                        _kcVar2.onVideoStart();
                        return;
                    }
                }
                return;
            }
            if (2 == i) {
                if (!_kjVar._c._q.get()) {
                    PtgVideoView ptgVideoView2 = _kjVar._c;
                    if (ptgVideoView2._a != null) {
                        ptgVideoView2._q.set(true);
                        _kjVar._c._a._a((Bitmap) null);
                    }
                }
                PtgVideoView ptgVideoView3 = _kjVar._c;
                ptgVideoView3.setSoundMute(ptgVideoView3._c == 0);
                return;
            }
            if (7 != i) {
                if (-1 == i) {
                    _kjVar._c._a(false);
                    return;
                }
                return;
            }
            _kjVar._c._a(false);
            PtgVideoView ptgVideoView4 = _kjVar._c;
            _h _hVar = ptgVideoView4._l;
            _kb _kbVar = ptgVideoView4._m;
            if (_kbVar != null) {
                _kbVar._a(_hVar, -1L);
            }
            MediaPlayer.OnCompletionListener onCompletionListener = _kjVar._c._t;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(null);
            }
        }
    }

    @Override // com.kc.aw._il
    public final void _b() {
        _d();
    }

    public final void _c() {
        this._d.removeCallbacks(this._e);
        this._d.post(this._e);
    }

    public final void _d() {
        this._d.removeCallbacks(this._e);
    }

    @Override // com.kc.aw._il
    public _ij getInfo() {
        return this._b;
    }

    @Override // com.kc.aw._il
    public PtgCoreVideo getVideoPlayer() {
        return this._a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        PtgCoreVideo ptgCoreVideo = this._a;
        if (ptgCoreVideo == null) {
            return;
        }
        if (i != 0) {
            ptgCoreVideo._b();
            _d();
        } else {
            if (ptgCoreVideo.getCurrentPosition() == this._a.getDuration() || this._a.getCurrStatus() != 3) {
                return;
            }
            _c();
        }
    }

    @Override // com.kc.aw._il
    public void setInfo(_ij _ijVar) {
        this._b = _ijVar;
    }

    public void setPlayerListener(_jp _jpVar) {
        this._c = _jpVar;
    }

    @Override // com.kc.aw._il
    public void setVideoPlayer(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }
}
