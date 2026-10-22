package com.ipd.dsp.internal.s1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.VideoView;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.v0.q;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class e extends VideoView {
    public static final String s = "FSVV";
    public b f;
    public int g;
    public boolean h;
    public MediaPlayer i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public Handler o;
    public final Runnable p;
    public String q;
    public String r;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.f != null) {
                    if (!e.this.isPlaying()) {
                        if (e.b(e.this) < 5) {
                            e.this.o.postDelayed(this, 1000L);
                            return;
                        } else {
                            e.this.l = 0;
                            e.this.o.removeCallbacksAndMessages(null);
                            return;
                        }
                    }
                    e.this.l = 0;
                    int duration = e.this.getDuration() - e.this.getCurrentPosition();
                    e.this.f.a(duration / 1000);
                    if (duration >= 0) {
                        e.this.o.postDelayed(this, 900L);
                    } else {
                        e.this.o.removeCallbacksAndMessages(null);
                    }
                }
            } catch (Throwable th) {
                if (Dsp.isDebugLogEnable()) {
                    k.b(e.s, "video runnable error", th);
                }
            }
        }
    }

    public interface b {
        void a();

        void a(int i);

        void a(int i, String str);

        void b(int i);
    }

    public e(Context context) {
        super(context);
        this.f = null;
        this.k = false;
        this.o = new Handler(Looper.getMainLooper());
        this.p = new a();
        e();
    }

    public static /* synthetic */ int b(e eVar) {
        int i = eVar.l;
        eVar.l = i + 1;
        return i;
    }

    public void d() throws Throwable {
        try {
            this.o.removeCallbacksAndMessages(null);
            this.o = null;
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                this.i = null;
            } catch (Throwable th2) {
                if (Dsp.isDebugLogEnable()) {
                    k.e(s, "VideoView.release", th2);
                }
            }
        }
        try {
            stopPlayback();
            setOnCompletionListener(null);
            setOnPreparedListener(null);
            this.f = null;
            suspend();
        } catch (Throwable th3) {
            th = th3;
        }
        if (th != null) {
            throw th;
        }
    }

    public final void e() {
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.zj.adlib.qya
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                this.f44328a.a(mediaPlayer);
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.zj.adlib.wya
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.f45716a.b(mediaPlayer);
            }
        });
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.zj.adlib.eza
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return this.f41557a.a(mediaPlayer, i, i2);
            }
        });
        setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.zj.adlib.jza
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return this.f42709a.b(mediaPlayer, i, i2);
            }
        });
    }

    public Bitmap getCurrentFrame() {
        Bitmap frameAtTime = null;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                if (this.r.startsWith("file:///")) {
                    mediaMetadataRetriever.setDataSource(getContext(), Uri.parse(this.r));
                } else {
                    mediaMetadataRetriever.setDataSource(this.r, new HashMap());
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(32);
                    if (strExtractMetadata != null) {
                        frameAtTime = mediaMetadataRetriever.getFrameAtIndex(Integer.parseInt(strExtractMetadata) - 1, new MediaMetadataRetriever.BitmapParams());
                    }
                } else {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(((long) getVideoDuration()) * 1000000, 3);
                    if (frameAtTime != null) {
                        Bitmap.Config config = frameAtTime.getConfig();
                        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                        if (config != config2) {
                            frameAtTime = frameAtTime.copy(config2, true);
                        }
                    }
                }
                mediaMetadataRetriever.close();
                return frameAtTime;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            k.a("VV", th3);
            return null;
        }
    }

    public int getPlayDuration() {
        return getCurrentPosition();
    }

    public int getVideoDuration() {
        return this.g;
    }

    public void setListener(b bVar) {
        this.f = bVar;
    }

    public void setVideo(String str) {
        this.q = str;
        q qVarB = q.b();
        if (qVarB != null) {
            str = qVarB.d(str);
        }
        this.r = str;
        setVideoPath(str);
    }

    public final /* synthetic */ void b(MediaPlayer mediaPlayer) {
        this.i = null;
        b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
    }

    public int c() {
        int currentPosition = getCurrentPosition();
        stopPlayback();
        this.i = null;
        return currentPosition;
    }

    public final /* synthetic */ void a(MediaPlayer mediaPlayer) {
        this.h = true;
        this.m = mediaPlayer.getVideoWidth();
        this.n = mediaPlayer.getVideoHeight();
        mediaPlayer.setLooping(false);
        mediaPlayer.setVideoScalingMode(2);
        this.i = mediaPlayer;
        a(this.k);
        int duration = mediaPlayer.getDuration() / 1000;
        this.g = duration;
        if (this.j) {
            return;
        }
        this.j = true;
        b bVar = this.f;
        if (bVar != null) {
            bVar.b(duration);
        }
    }

    public final /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i, int i2) {
        setBackgroundColor(0);
        return false;
    }

    public void b() {
        if (this.h) {
            return;
        }
        requestFocus();
    }

    public final /* synthetic */ boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        b bVar;
        this.i = null;
        if (Dsp.isDebugLogEnable()) {
            k.b(s, "VideoView.onVideoError.what = " + i + " & extra = " + i2);
        }
        if (this.h || (bVar = this.f) == null) {
            return true;
        }
        bVar.a(i, String.valueOf(i2));
        return true;
    }

    public boolean a() {
        return this.m <= this.n;
    }

    public void a(int i) {
        if (this.h) {
            if (this.i == null) {
                try {
                    setVideo(this.q);
                } catch (Throwable th) {
                    r.a(th);
                }
            }
            setVisibility(0);
            seekTo(i);
            start();
            this.l = 0;
            this.o.removeCallbacksAndMessages(null);
            this.o.postDelayed(this.p, 100L);
        }
    }

    public void a(boolean z) {
        this.k = z;
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer == null || !this.h) {
            return;
        }
        try {
            if (z) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            } else {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }
}
