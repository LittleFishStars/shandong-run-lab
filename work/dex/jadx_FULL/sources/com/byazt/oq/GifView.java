package com.byazt.oq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.byazt.bwm.sp;
import com.byazt.nr.m;
import com.byazt.nr.x;
import com.byazt.or.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1135})
@SuppressLint({"AppCompatCustomView"})
public class GifView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28901a;
    public Movie c;
    public int da;
    public float i;
    public boolean n;
    public int sl;
    public float sp;
    public volatile boolean t;
    public long tt;
    public boolean u;
    public AnimatedImageDrawable uj;
    public int ve;
    public float x;
    public boolean yp;

    public interface c {
        void c(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.n = Build.VERSION.SDK_INT >= 28;
        this.f28901a = false;
        this.u = true;
        this.yp = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.uj = animatedImageDrawable;
            if (!this.t) {
                animatedImageDrawable.start();
            }
            if (!this.yp) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source tt(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File fileC = c(getContext(), com.byazt.mf.c.c().ve().t() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileC);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileC);
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return sourceCreateSource;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    m.ve("GifView", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        return null;
    }

    private void uj() {
        if (this.c == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.tt == 0) {
            this.tt = jUptimeMillis;
        }
        int iDuration = this.c.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.yp || Math.abs(iDuration - this.ve) >= 60) {
            this.ve = (int) ((jUptimeMillis - this.tt) % ((long) iDuration));
        } else {
            this.ve = iDuration;
            this.t = true;
        }
    }

    private void ve() {
        if (this.c == null || this.n || !this.u) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c == null || this.n) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.t) {
                c(canvas);
                return;
            }
            uj();
            c(canvas);
            ve();
        } catch (Throwable th) {
            m.ve("GifView", "onDraw->Throwable->", th);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null && !this.n) {
            this.sp = (getWidth() - this.da) / 2.0f;
            this.x = (getHeight() - this.sl) / 2.0f;
        }
        this.u = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.n || (movie = this.c) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.c.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.i = fMax;
        int i3 = (int) (iWidth * fMax);
        this.da = i3;
        int i4 = (int) (iHeight * fMax);
        this.sl = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.c != null) {
            this.u = i == 1;
            ve();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.c != null) {
            this.u = i == 0;
            ve();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.c != null) {
            this.u = i == 0;
            ve();
        }
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.yp = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.uj) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            m.ve("GifView", "setRepeatConfig error", e);
        }
    }

    public void c() {
        if (this.n) {
            return;
        }
        setLayerType(1, null);
    }

    public void c(byte[] bArr, boolean z) {
        this.t = z;
        if (bArr == null) {
            return;
        }
        if (!this.n) {
            this.c = c(bArr);
        } else {
            c(bArr, new c() { // from class: com.byazt.oq.GifView.1
                @Override // com.byazt.oq.GifView.c
                public void c(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.byazt.oq.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    private Movie c(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void c(final byte[] bArr, final c cVar) {
        if (bArr == null) {
            return;
        }
        n.c(new sp("createGifApi28WithByteArrayBySafely") { // from class: com.byazt.oq.GifView.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    GifView gifView = GifView.this;
                    cVar2.c(gifView.c(gifView.tt(bArr)));
                }
            }
        }, 5);
    }

    public void tt() {
        if (this.c == null || !this.t) {
            return;
        }
        this.t = false;
        if (!this.n) {
            this.tt = SystemClock.uptimeMillis() - ((long) this.ve);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.uj;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.uj.start();
    }

    public static File c(Context context, String str, String str2) {
        int iSl = com.byazt.mf.c.c().ve().sl();
        boolean zT = com.byazt.mf.c.c().ve().t();
        if (iSl == 1) {
            m.uj("splashLoadAd", "视频存储使用内部存储");
            return x.tt(context, zT, str, str2);
        }
        m.uj("splashLoadAd", "视频存储使用外存储");
        return x.c(context, zT, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable c(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void c(Canvas canvas) {
        Movie movie = this.c;
        if (movie == null) {
            return;
        }
        movie.setTime(this.ve);
        float f = this.i;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.c.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.c;
            float f2 = this.sp;
            float f3 = this.i;
            movie2.draw(canvas, f2 / f3, this.x / f3);
        }
        canvas.restore();
    }
}
