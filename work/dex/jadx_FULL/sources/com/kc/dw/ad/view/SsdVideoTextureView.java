package com.kc.dw.ad.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.kc.dw.core.safe.k;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdVideoTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f39180a;
    public MediaPlayer b;
    public MediaPlayer.OnPreparedListener c;
    public MediaPlayer.OnErrorListener d;
    public d e;
    public com.kc.dw.ad.view.a f;
    public MediaPlayer.OnCompletionListener g;
    public MediaPlayer.OnInfoListener h;
    public MediaPlayer.OnVideoSizeChangedListener i;
    public boolean j;
    public Surface k;
    public int l;
    public int m;
    public boolean n;
    public Surface o;
    public int p;
    public SurfaceTexture q;
    public TextureView.SurfaceTextureListener r;

    @Keep
    public class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdVideoTextureView f39181a;

        public a(SsdVideoTextureView ssdVideoTextureView) {
            this.f39181a = ssdVideoTextureView;
        }

        @Override // com.kc.dw.core.safe.k
        public void safeOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            try {
                SsdVideoTextureView ssdVideoTextureView = this.f39181a;
                ssdVideoTextureView.q = surfaceTexture;
                if (ssdVideoTextureView.b != null) {
                    ssdVideoTextureView.k = new Surface(surfaceTexture);
                    SsdVideoTextureView ssdVideoTextureView2 = this.f39181a;
                    ssdVideoTextureView2.b.setSurface(ssdVideoTextureView2.k);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.safe.k
        public boolean safeOnSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // com.kc.dw.core.safe.k
        public void safeOnSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // com.kc.dw.core.safe.k
        public void safeOnSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdVideoTextureView f39182a;

        public b(SsdVideoTextureView ssdVideoTextureView) {
            this.f39182a = ssdVideoTextureView;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39182a.requestLayout();
        }
    }

    @Keep
    public class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39183a;

        public c(SsdVideoTextureView ssdVideoTextureView, int i) {
            this.f39183a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            try {
                outline.setRoundRect(new Rect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()), this.f39183a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public SsdVideoTextureView(Context context) {
        super(context);
        this.f39180a = getClass().getSimpleName();
        this.j = false;
        this.n = true;
        this.p = 1;
        this.r = new a(this);
        a();
    }

    public SsdVideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39180a = getClass().getSimpleName();
        this.j = false;
        this.n = true;
        this.p = 1;
        this.r = new a(this);
        a();
    }

    public SsdVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39180a = getClass().getSimpleName();
        this.j = false;
        this.n = true;
        this.p = 1;
        this.r = new a(this);
        a();
    }

    public Matrix a(float f, float f2) {
        if (f == 0.0f || f2 == 0.0f || this.l == 0 || this.m == 0) {
            return null;
        }
        LogUtil.d(this.f39180a, "adjustVideoRadio " + f + " " + f2 + " " + this.l + " " + this.m);
        float f3 = f / ((float) this.l);
        float f4 = f2 / ((float) this.m);
        Matrix matrix = new Matrix();
        matrix.preTranslate((f - ((float) this.l)) / 2.0f, (f2 - ((float) this.m)) / 2.0f);
        matrix.preScale(((float) this.l) / f, ((float) this.m) / f2);
        if (2 == this.p) {
            matrix.postScale(f3, f4, f / 2.0f, f2 / 2.0f);
        } else {
            float f5 = f / 2.0f;
            float f6 = f2 / 2.0f;
            if (f3 >= f4) {
                matrix.postScale(f4, f4, f5, f6);
            } else {
                matrix.postScale(f3, f3, f5, f6);
            }
        }
        return matrix;
    }

    public void a() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.b.setScreenOnWhilePlaying(true);
        this.b.setOnPreparedListener(new e(this));
        this.b.setOnErrorListener(new f(this));
        this.b.setOnCompletionListener(new g(this));
        this.b.setOnBufferingUpdateListener(new h(this));
        this.b.setOnInfoListener(new i(this));
        this.b.setOnVideoSizeChangedListener(new j(this));
        setSurfaceTextureListener(this.r);
    }

    public final void a(int i, int i2, Matrix matrix) {
        if (matrix == null) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        matrix.mapRect(rectF);
        LogUtil.i(this.f39180a, "changeViewSize " + matrix + " " + ((int) rectF.width()) + " " + ((int) rectF.height()));
        getLayoutParams().width = (int) rectF.width();
        getLayoutParams().height = ((int) rectF.height()) + 1;
        post(new b(this));
    }

    public void a(String str, com.kc.dw.ad.view.a aVar) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        try {
            com.kc.dw.ad.view.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.f39184a = null;
            }
            this.f = aVar;
            aVar.f39184a = this.e;
            com.kc.dw.player.utils.b.a(mediaPlayer, aVar, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean b() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void c() {
        LogUtil.d(this.f39180a, "pause");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !this.j) {
            return;
        }
        try {
            mediaPlayer.pause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        LogUtil.d(this.f39180a, "resume");
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.j) {
                return;
            }
            mediaPlayer.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        LogUtil.d(this.f39180a, "start");
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.j) {
                return;
            }
            mediaPlayer.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentPosition() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.j) {
                return 0;
            }
            return mediaPlayer.getCurrentPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getDuration() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.j) {
                return 0;
            }
            return mediaPlayer.getDuration();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.b;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (getParent() instanceof View) {
                measuredWidth = ((View) getParent()).getMeasuredWidth();
                measuredHeight = ((View) getParent()).getMeasuredHeight();
            } else {
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight();
            }
            if (this.n) {
                return;
            }
            a(measuredWidth, measuredHeight, a(measuredWidth, measuredHeight));
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setDisplayMode(int i) {
        if (i == 1 || i == 2) {
            this.p = i;
        }
    }

    public void setInitMute(boolean z) {
        MediaPlayer mediaPlayer;
        float f;
        if (z) {
            mediaPlayer = this.b;
            f = 0.0f;
        } else {
            mediaPlayer = this.b;
            f = 1.0f;
        }
        mediaPlayer.setVolume(f, f);
    }

    public void setOnCachePreparedListener(d dVar) {
        if (this.b != null) {
            this.e = dVar;
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.b != null) {
            this.g = onCompletionListener;
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.b != null) {
            this.d = onErrorListener;
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.b != null) {
            this.h = onInfoListener;
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.b != null) {
            this.c = onPreparedListener;
        }
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.i = onVideoSizeChangedListener;
    }

    public void setRadius(int i) {
        try {
            setOutlineProvider(new c(this, i));
            setClipToOutline(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setUseTransform(boolean z) {
        this.n = z;
    }

    public void setVideoPath(String str) {
        a(str, new com.kc.dw.ad.view.a(-1L, -1L));
    }
}
