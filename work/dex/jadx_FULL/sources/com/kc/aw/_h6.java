package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _h6 extends FrameLayout implements View.OnTouchListener {
    public Timer _a;
    public _a _b;
    public _es _c;
    public float _d;
    public float _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public long _i;
    public float _j;
    public long _k;

    @Keep
    public final class _a extends TimerTask {
        public final _h6 _a;

        /* JADX INFO: renamed from: com.kc.aw._h6$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class RunnableC0944_a implements Runnable {
            public final _a _a;

            public RunnableC0944_a(_a _aVar) {
                this._a = _aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this._a._a._e();
            }
        }

        public _a(_h6 _h6Var) {
            this._a = _h6Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            _fz._a.post(new RunnableC0944_a(this));
        }
    }

    public _h6(Context context) {
        super(context);
        this._f = false;
        this._g = false;
        this._h = false;
        setOnTouchListener(this);
    }

    public final void _a() {
        Timer timer = this._a;
        if (timer != null) {
            timer.cancel();
            this._a = null;
        }
        _a _aVar = this._b;
        if (_aVar != null) {
            _aVar.cancel();
            this._b = null;
        }
    }

    public abstract void _a(int i);

    public abstract void _b();

    public abstract void _c();

    public final void _d() {
        _a();
        if (this._a == null) {
            this._a = new Timer();
        }
        if (this._b == null) {
            this._b = new _a(this);
        }
        this._a.schedule(this._b, 0L, 1000L);
    }

    public abstract void _e();

    public abstract ImageView getImageView();

    /* JADX WARN: Code duplicated, block: B:65:0x0116  */
    /* JADX WARN: Code duplicated, block: B:67:0x011a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0124  */
    /* JADX WARN: Code duplicated, block: B:72:0x012c  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        long j;
        MediaPlayer mediaPlayer;
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._c;
        if (!(niceVideoPlayer._i == 11)) {
            return false;
        }
        int i = niceVideoPlayer._h;
        if (!(i == 0)) {
            if (!(i == -1)) {
                if (!(i == 1)) {
                    if (!(i == 2)) {
                        if (!(i == 7)) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this._d = x;
                                this._e = y;
                                this._f = false;
                                this._h = false;
                                this._g = false;
                            } else if (action == 1) {
                                if (this._f) {
                                    _es _esVar = this._c;
                                    j = this._k;
                                    mediaPlayer = ((NiceVideoPlayer) _esVar)._d;
                                    if (mediaPlayer != null) {
                                        mediaPlayer.seekTo((int) j);
                                    }
                                    _d();
                                    return true;
                                }
                                if (!this._g || this._h) {
                                    return true;
                                }
                            } else if (action == 2) {
                                float f = x - this._d;
                                float f2 = y - this._e;
                                float fAbs = Math.abs(f);
                                float fAbs2 = Math.abs(f2);
                                if (!this._f && !this._g && !this._h) {
                                    if (fAbs >= 80.0f) {
                                        _a();
                                        this._f = true;
                                        this._i = this._c.getCurrentPosition();
                                    } else if (fAbs2 >= 80.0f) {
                                        if (this._d < getWidth() * 0.5f) {
                                            this._h = true;
                                            if (_h5._b(getContext()) != null) {
                                                this._j = _h5._b(getContext()).getWindow().getAttributes().screenBrightness;
                                            }
                                        } else {
                                            this._g = true;
                                            this._c.getVolume();
                                        }
                                    }
                                }
                                if (this._f) {
                                    long duration = this._c.getDuration();
                                    this._k = Math.max(0L, Math.min(duration, (long) (((duration * f) / getWidth()) + this._i)));
                                }
                                if (this._h) {
                                    float fMax = Math.max(0.0f, Math.min(this._j + (((-f2) * 3.0f) / getHeight()), 1.0f));
                                    Activity activity_b = _h5._b(getContext());
                                    if (activity_b != null) {
                                        WindowManager.LayoutParams attributes = activity_b.getWindow().getAttributes();
                                        attributes.screenBrightness = fMax;
                                        activity_b.getWindow().setAttributes(attributes);
                                    }
                                }
                            } else if (action == 3) {
                                if (this._f) {
                                    _es _esVar2 = this._c;
                                    j = this._k;
                                    mediaPlayer = ((NiceVideoPlayer) _esVar2)._d;
                                    if (mediaPlayer != null) {
                                        mediaPlayer.seekTo((int) j);
                                    }
                                    _d();
                                    return true;
                                }
                                if (!this._g) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public abstract void setImage(int i);

    public void setNiceVideoPlayer(_es _esVar) {
        this._c = _esVar;
    }
}
