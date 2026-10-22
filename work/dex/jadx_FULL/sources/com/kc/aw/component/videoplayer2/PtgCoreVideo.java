package com.kc.aw.component.videoplayer2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.kc.aw._hu;
import com.kc.aw._ih;
import com.kc.aw._ik;
import com.kc.aw._il;
import com.kc.aw._j8;
import com.kc.aw._jf;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils._d;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgCoreVideo extends FrameLayout implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {
    public int _a;
    public int _b;
    public _il _c;
    public FrameLayout _d;
    public _ih _e;
    public MediaPlayer _f;
    public Surface _g;
    public SurfaceTexture _h;
    public FrameLayout _i;
    public float _j;
    public float _k;
    public boolean _l;
    public boolean _m;
    public final _a _n;
    public Bitmap _o;
    public NiceVideoPlayer._b _p;
    public _j8 _q;
    public boolean _r;

    @Keep
    public final class _a implements MediaPlayer.OnSeekCompleteListener {
        public final PtgCoreVideo _a;

        public _a(PtgCoreVideo ptgCoreVideo) {
            this._a = ptgCoreVideo;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            this._a._c._a();
        }
    }

    public PtgCoreVideo(Context context) {
        this(context, null, 0);
    }

    public PtgCoreVideo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtgCoreVideo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._a = 0;
        this._b = 8;
        this._j = 0.0f;
        this._k = 0.0f;
        this._n = new _a(this);
        _a();
    }

    public final void _a() {
        this._d = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this._d, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this._i = frameLayout;
        this._d.addView(frameLayout, layoutParams);
    }

    public final void _a(int i) {
        _il _ilVar = this._c;
        if (_ilVar != null) {
            _ilVar._a(i);
        }
    }

    public final void _a(SurfaceTexture surfaceTexture) {
        try {
            this._f.setDataSource(this._c.getInfo()._a);
            Surface surface = new Surface(surfaceTexture);
            this._g = surface;
            this._f.setSurface(surface);
            this._f.prepareAsync();
            this._a = 1;
            _a(1);
        } catch (Exception e) {
            Logger.e("openMediaPlayer", e.getMessage());
        }
    }

    public final void _a(boolean z) {
        FrameLayout frameLayout;
        _ih _ihVar;
        _c _cVar;
        _il _ilVar = this._c;
        if (_ilVar != null && _ilVar.getInfo()._c) {
            String str = this._c.getInfo()._a;
            long currentPosition = getCurrentPosition();
            StringBuilder sb_a = _jf._a(str);
            sb_a.append(hashCode());
            getContext().getSharedPreferences("progress", 0).edit().putLong(com.kc.aw.lib.utils._a._c(sb_a.toString()), currentPosition).apply();
        }
        if (!z) {
            if (_ik._b == null) {
                _ik._b = new _ik();
            }
            _ik _ikVar = _ik._b;
            synchronized (_ikVar._a) {
                _ikVar._a.remove(this);
            }
        } else if (this._c != null) {
            int currentPosition2 = getCurrentPosition();
            String str_a = _hu._a(getContext())._a(this._c.getInfo()._b, false);
            synchronized (_c.class) {
                try {
                    if (_c._a == null) {
                        _c._a = new _c();
                    }
                    _cVar = _c._a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            long j = currentPosition2;
            com.kc.aw.component.videoplayer2._a _aVar = new com.kc.aw.component.videoplayer2._a(this);
            _cVar.getClass();
            _d._b(new _b(str_a, j, _aVar));
        }
        this._l = false;
        MediaPlayer mediaPlayer = this._f;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this._f = null;
        }
        if ((this._r || z) && (frameLayout = this._i) != null && (_ihVar = this._e) != null) {
            frameLayout.removeView(_ihVar);
        }
        Surface surface = this._g;
        if (surface != null) {
            surface.release();
            this._g = null;
        }
        SurfaceTexture surfaceTexture = this._h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this._h = null;
        }
        if (!z || this._a != 7) {
            this._a = 0;
        }
        this._b = 8;
        _il _ilVar2 = this._c;
        if (_ilVar2 != null) {
            _ilVar2._b();
        }
        try {
            Bitmap bitmap = this._o;
            if (bitmap != null) {
                bitmap.recycle();
                this._o = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void _b() {
        int i = this._a;
        if (i == 3 || i == 2) {
            this._f.pause();
            this._a = 4;
            _a(4);
        }
        if (this._a == 5) {
            this._f.pause();
            this._a = 6;
            _a(6);
        }
        if (this._l || this._a != 1) {
            return;
        }
        this._m = true;
        this._a = 4;
        _a(4);
    }

    public final void _c() {
        int i;
        if (this._f == null) {
            return;
        }
        StringBuilder sb_a = _jf._a("mMediaPlayer restart: setVolume(");
        sb_a.append(this._j);
        sb_a.append(", ");
        sb_a.append(this._k);
        sb_a.append(")");
        Logger.d("PtgCoreVideo", sb_a.toString());
        this._f.setVolume(this._j, this._k);
        int i2 = this._a;
        if (i2 == 4) {
            this._f.start();
            this._f.setLooping(false);
            i = 3;
        } else if (i2 == 6) {
            this._f.start();
            this._f.setLooping(false);
            i = 5;
        } else if (i2 == 7 || i2 == -1) {
            this._f.reset();
            _a(this._h);
            i = 10;
        } else {
            this._f.reset();
            _a(this._h);
            i = 11;
        }
        this._a = i;
        _a(i);
    }

    public final void _d() {
        if (this._a == 0) {
            if (_ik._b == null) {
                _ik._b = new _ik();
            }
            _ik _ikVar = _ik._b;
            synchronized (_ikVar._a) {
                if (!_ikVar._a.isEmpty() && _ikVar._a.size() > 8) {
                    PtgCoreVideo ptgCoreVideo = _ikVar._a.get(0);
                    ptgCoreVideo._b();
                    ptgCoreVideo._a(true);
                    _ikVar._a.remove(ptgCoreVideo);
                }
            }
            if (_ik._b == null) {
                _ik._b = new _ik();
            }
            _ik _ikVar2 = _ik._b;
            synchronized (_ikVar2._a) {
                _ikVar2._a.remove(this);
                _ikVar2._a.add(this);
            }
            if (this._f == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this._f = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
                this._f.setScreenOnWhilePlaying(true);
                this._f.setOnPreparedListener(this);
                this._f.setOnVideoSizeChangedListener(this);
                this._f.setOnCompletionListener(this);
                this._f.setOnErrorListener(this);
                this._f.setOnInfoListener(this);
                this._f.setOnBufferingUpdateListener(this);
                this._f.setOnSeekCompleteListener(this._n);
                this._f.setVolume(this._j, this._k);
                Logger.d("PtgCoreVideo", "mMediaPlayer initMediaPlayer: setVolume(" + this._j + ", " + this._k + ")");
            }
            if (this._e == null) {
                _ih _ihVar = new _ih(getContext());
                this._e = _ihVar;
                _ihVar.setSurfaceTextureListener(this);
            }
            this._i.removeView(this._e);
            this._i.addView(this._e, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    public int getCurrModeStatus() {
        return this._b;
    }

    public int getCurrStatus() {
        return this._a;
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this._f;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this._f;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int getVolume() {
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this._a = 7;
        _a(7);
        this._d.setKeepScreenOn(false);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this._a != 11) {
            this._a = -1;
            _a(-1);
        }
        NiceVideoPlayer._b _bVar = this._p;
        if (_bVar == null) {
            return true;
        }
        _bVar.onError(mediaPlayer, i, i2);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = 3;
        if (i == 3) {
            if (this._a == 3) {
                return true;
            }
            this._a = 3;
        } else {
            if (i != 701) {
                if (i != 702) {
                    return true;
                }
                if (this._a == 5) {
                    this._a = 3;
                    _a(3);
                }
                if (this._a != 6) {
                    return true;
                }
                this._a = 4;
                _a(4);
                return true;
            }
            int i4 = this._a;
            if (i4 == 4 || i4 == 6) {
                this._a = 6;
            } else {
                this._a = 5;
            }
            i3 = this._a;
        }
        _a(i3);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        if (r5 < r6) goto L28;
     */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onPrepared(MediaPlayer mediaPlayer) {
        float f;
        float f2;
        float f3;
        float f4;
        if (mediaPlayer != null) {
            MediaPlayer mediaPlayer2 = this._f;
            if (mediaPlayer2 != null && this._e != null) {
                int videoWidth = mediaPlayer2.getVideoWidth();
                int videoHeight = this._f.getVideoHeight();
                int width = this._e.getWidth();
                int height = this._e.getHeight();
                float f5 = 1.0f;
                if (videoWidth > width && videoHeight > height) {
                    f = videoWidth / width;
                    f2 = videoHeight / height;
                } else if (videoWidth < width && videoHeight < height) {
                    f2 = width / videoWidth;
                    f = height / videoHeight;
                } else if (width > videoWidth) {
                    f2 = (width / videoWidth) / (height / videoHeight);
                    f = 1.0f;
                } else if (height > videoHeight) {
                    f = (height / videoHeight) / (width / videoWidth);
                    f2 = 1.0f;
                } else {
                    f = 1.0f;
                    f2 = 1.0f;
                }
                if (videoHeight > videoWidth) {
                    if (f > f2) {
                        f3 = height;
                        f4 = f3 * f2;
                    } else {
                        f3 = width;
                        f4 = f3 * f;
                    }
                    f5 = f3 / f4;
                } else if (f > f2) {
                    f3 = height;
                    f4 = f3 * f2;
                    f5 = f3 / f4;
                }
                Matrix matrix = new Matrix();
                matrix.setScale(f * f5, f5 * f2, width / 2.0f, height / 2.0f);
                this._e.setTransform(matrix);
            }
            this._l = true;
            if (this._m) {
                this._m = false;
                return;
            }
            this._a = 2;
            _a(2);
            mediaPlayer.start();
            if (this._c.getInfo()._c) {
                StringBuilder sb_a = _jf._a(this._c.getInfo()._a);
                sb_a.append(hashCode());
                int i = (int) getContext().getSharedPreferences("progress", 0).getLong(com.kc.aw.lib.utils._a._c(sb_a.toString()), 0L);
                if (this._f != null) {
                    this._c._a();
                    this._f.seekTo(i, 3);
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this._h;
        if (surfaceTexture2 != null) {
            this._e.setSurfaceTexture(surfaceTexture2);
        } else {
            this._h = surfaceTexture;
            _a(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    public void setFrameListener(_j8 _j8Var) {
        this._q = _j8Var;
    }

    public void setHeartVideoContent(_il _ilVar) {
        this._d.removeView(this._c);
        this._c = _ilVar;
        _ilVar._b();
        _ilVar.setVideoPlayer(this);
        this._d.addView(this._c, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setInScrollView(boolean z) {
        this._r = z;
    }

    public void setOnErrorListener(NiceVideoPlayer._b _bVar) {
        this._p = _bVar;
    }

    public void setVolume(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 10) {
            i = 7;
        }
        float f = i / 10.0f;
        this._j = f;
        this._k = f;
        StringBuilder sb_a = _jf._a("mMediaPlayer setVolume: ");
        sb_a.append(this._f != null);
        sb_a.append(" volume:");
        sb_a.append(i);
        sb_a.append(" leftVolume:");
        sb_a.append(this._j);
        sb_a.append(" rightVolume:");
        sb_a.append(this._k);
        Logger.d("PtgCoreVideo", sb_a.toString());
        MediaPlayer mediaPlayer = this._f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(this._j, this._k);
        }
    }
}
