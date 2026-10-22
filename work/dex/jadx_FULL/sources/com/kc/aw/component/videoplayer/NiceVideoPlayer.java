package com.kc.aw.component.videoplayer;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.aw._es;
import com.kc.aw._h5;
import com.kc.aw._h6;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class NiceVideoPlayer extends FrameLayout implements _es, TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener {
    public _h6 _a;
    public FrameLayout _b;
    public SurfaceTexture _c;
    public MediaPlayer _d;
    public Surface _e;
    public AudioManager _f;
    public TextureView _g;
    public int _h;
    public int _i;
    public String _j;
    public Map<String, String> _k;
    public int _l;
    public MediaPlayer.OnPreparedListener _m;
    public MediaPlayer.OnCompletionListener _n;
    public _b _o;
    public final Handler _p;
    public final _a _q;
    public boolean _r;
    public boolean _s;
    public int _t;
    public int _u;
    public int _v;
    public FrameLayout.LayoutParams _w;

    @Keep
    public final class _a implements Runnable {
        public final NiceVideoPlayer _a;

        public _a(NiceVideoPlayer niceVideoPlayer) {
            this._a = niceVideoPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a._c();
            _b _bVar = this._a._o;
            if (_bVar != null) {
                _bVar.onTimeout();
            }
        }
    }

    @Keep
    public interface _b extends MediaPlayer.OnErrorListener {
        void onTimeout();
    }

    public NiceVideoPlayer(Context context) {
        super(context);
        this._h = 0;
        this._i = 10;
        this._p = new Handler();
        this._q = new _a(this);
        _a();
    }

    public NiceVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._h = 0;
        this._i = 10;
        this._p = new Handler();
        this._q = new _a(this);
        _a();
    }

    public final void _a() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this._b = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this._b, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void _b() {
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setOnErrorListener(this);
            this._b.setKeepScreenOn(true);
            this._d.setDataSource(getContext().getApplicationContext(), Uri.parse(this._j), this._k);
            if (this._e == null) {
                this._e = new Surface(this._c);
            }
            this._d.setSurface(this._e);
            this._d.prepareAsync();
            this._h = 1;
            this._a._a(1);
            this._p.postDelayed(this._q, 5000L);
            hasWindowFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this._d.setOnPreparedListener(this);
        this._d.setOnVideoSizeChangedListener(this);
        this._d.setOnCompletionListener(this);
        this._d.setOnInfoListener(this);
        this._d.setOnBufferingUpdateListener(this);
    }

    public final void _c() {
        _a _aVar;
        Activity activity_b;
        int i = this._i;
        if ((i == 11) && i == 11) {
            _h5._c(getContext());
            Activity activity_b2 = _h5._b(getContext());
            if (activity_b2 != null) {
                activity_b2.setRequestedOrientation(1);
                ((ViewGroup) activity_b2.findViewById(R.id.content)).removeView(this._b);
                addView(this._b, new FrameLayout.LayoutParams(-1, -1));
                this._i = 10;
                this._a._b();
            }
        }
        int i2 = this._i;
        if ((i2 == 12) && i2 == 12 && (activity_b = _h5._b(getContext())) != null) {
            ((ViewGroup) activity_b.findViewById(R.id.content)).removeView(this._b);
            addView(this._b, (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(-1, -1));
            this._i = 10;
            this._a._b();
        }
        this._i = 10;
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this._f = null;
        }
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this._d = null;
        }
        Surface surface = this._e;
        if (surface != null) {
            surface.release();
            this._e = null;
        }
        SurfaceTexture surfaceTexture = this._c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this._c = null;
        }
        this._h = 0;
        _h6 _h6Var = this._a;
        if (_h6Var != null) {
            _h6Var._c();
        }
        Handler handler = this._p;
        if (handler == null || (_aVar = this._q) == null) {
            return;
        }
        handler.removeCallbacks(_aVar);
    }

    public final void _d() {
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer == null) {
            return;
        }
        if (this._h != 4) {
            if (mediaPlayer != null ? mediaPlayer.isPlaying() : false) {
                int i = this._h;
                if (i == 6) {
                    this._d.start();
                    this._h = 5;
                    this._a._a(5);
                    return;
                } else {
                    if (i == 7 || i == -1) {
                        this._d.reset();
                        _b();
                        return;
                    }
                    return;
                }
            }
        }
        this._d.start();
        this._h = 3;
        this._a._a(8);
    }

    public final void _e() {
        TextureView textureView;
        int i;
        int i2;
        hasWindowFocus();
        if (this._h == 0) {
            if (this._f == null) {
                this._f = (AudioManager) getContext().getSystemService("audio");
            }
            this._f.requestAudioFocus(null, 3, 1);
            if (this._d == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this._d = mediaPlayer;
                mediaPlayer.reset();
                this._d.setAudioStreamType(3);
            }
            if (this._g == null) {
                TextureView textureView2 = new TextureView(getContext());
                this._g = textureView2;
                textureView2.setLayerType(1, null);
                this._g.setSurfaceTextureListener(this);
            }
            FrameLayout frameLayout = this._b;
            if (frameLayout == null || (textureView = this._g) == null) {
                return;
            }
            frameLayout.removeView(textureView);
            FrameLayout.LayoutParams layoutParams = this._w;
            if (layoutParams == null) {
                Context context = getContext();
                int i3 = this._t;
                int i4 = this._u;
                int i5 = this._v;
                if (i4 <= 0 || i5 <= 0) {
                    i = -1;
                    i2 = -1;
                } else {
                    if (i3 == 1) {
                        i = context.getResources().getDisplayMetrics().heightPixels;
                        i2 = (int) (((double) i) * (((double) i4) / ((double) i5)));
                    } else {
                        i2 = context.getResources().getDisplayMetrics().widthPixels;
                        i = (int) (((double) i2) * (((double) i5) / ((double) i4)));
                    }
                }
                int[] iArr = {i2, i};
                layoutParams = new FrameLayout.LayoutParams(iArr[0], iArr[1]);
                layoutParams.gravity = 17;
            }
            this._b.addView(this._g, 0, layoutParams);
        }
    }

    public int getBufferPercentage() {
        return this._l;
    }

    @Override // com.kc.aw._es
    public long getCurrentPosition() {
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kc.aw._es
    public long getDuration() {
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0L;
    }

    public int getMaxVolume() {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    @Override // com.kc.aw._es
    public int getVolume() {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this._l = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this._h = 7;
        this._a._a(7);
        this._b.setKeepScreenOn(false);
        MediaPlayer.OnCompletionListener onCompletionListener = this._n;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == -38 || i == Integer.MIN_VALUE || i2 == -38 || i2 == Integer.MIN_VALUE) {
            return true;
        }
        this._h = -1;
        this._a._a(-1);
        this._p.removeCallbacks(this._q);
        _b _bVar = this._o;
        if (_bVar == null) {
            return true;
        }
        _bVar.onError(mediaPlayer, i, i2);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            this._h = 3;
            this._a._a(3);
            return true;
        }
        if (701 == i) {
            int i3 = this._h;
            if (i3 == 4 || i3 == 6) {
                this._h = 6;
            } else {
                this._h = 5;
            }
            this._a._a(this._h);
            return true;
        }
        if (i != 702) {
            return true;
        }
        if (this._h == 5) {
            this._h = 3;
            this._a._a(3);
        }
        if (this._h != 6) {
            return true;
        }
        this._h = 4;
        this._a._a(4);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this._r = true;
        hasWindowFocus();
        this._p.removeCallbacks(this._q);
        MediaPlayer.OnPreparedListener onPreparedListener = this._m;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(mediaPlayer);
        }
        if (this._s) {
            this._s = false;
            return;
        }
        this._h = 2;
        this._a._a(2);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this._c;
        if (surfaceTexture2 != null) {
            this._g.setSurfaceTexture(surfaceTexture2);
        } else {
            this._c = surfaceTexture;
            _b();
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

    public void setController(_h6 _h6Var) {
        this._b.removeView(this._a);
        this._a = _h6Var;
        _h6Var._c();
        this._a.setNiceVideoPlayer(this);
        this._b.addView(this._a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setMediaVolume(int i) {
        MediaPlayer mediaPlayer = this._d;
        if (mediaPlayer != null) {
            float f = i / 10.0f;
            mediaPlayer.setVolume(f, f);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._n = onCompletionListener;
    }

    public void setOnErrorListener(_b _bVar) {
        this._o = _bVar;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this._m = onPreparedListener;
    }

    public void setVideoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this._w = layoutParams;
        TextureView textureView = this._g;
        if (textureView != null) {
            textureView.setLayoutParams(layoutParams);
        }
    }

    public void setVolume(int i) {
        AudioManager audioManager = this._f;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }
}
