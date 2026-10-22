package com.alibaba.triver.embed.video.fullscreenvideo;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends b implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final String c = "MiniAppMediaSystem";
    public MediaPlayer d;
    private float f;
    private float g;
    private long b = 0;
    private long e = 0;

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void a() {
        try {
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                if (this.e == 0) {
                    this.e = System.currentTimeMillis();
                }
                this.d.setVolume(this.f, this.g);
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void b() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.d = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.d.setLooping(this.f24864a.f);
            this.d.setOnPreparedListener(this);
            this.d.setOnCompletionListener(this);
            this.d.setOnBufferingUpdateListener(this);
            this.d.setScreenOnWhilePlaying(true);
            this.d.setOnSeekCompleteListener(this);
            this.d.setOnErrorListener(this);
            this.d.setOnInfoListener(this);
            this.d.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.d, this.f24864a.a().toString(), this.f24864a.e);
            this.d.prepareAsync();
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void c() {
        try {
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            if (this.e != 0) {
                this.b += System.currentTimeMillis() - this.e;
                this.e = 0L;
            }
            this.d.pause();
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public boolean d() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void e() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public long f() {
        int currentPosition = 0;
        try {
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer != null) {
                currentPosition = mediaPlayer.getCurrentPosition();
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return currentPosition;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public long g() {
        int duration = 0;
        try {
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer != null) {
                duration = mediaPlayer.getDuration();
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return duration;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public long h() {
        long j = this.b;
        long j2 = this.e;
        return j2 != 0 ? j + (System.currentTimeMillis() - j2) : j;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().setBufferProgress(i);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().B();
                }
            }
        });
        this.e = 0L;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().b(i, i2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    if (i != 3) {
                        h.c().a(i, i2);
                    } else if (h.c().L == 1 || h.c().L == 2) {
                        h.c().y();
                    }
                }
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.start();
            mediaPlayer.setVolume(this.f, this.g);
            this.e = System.currentTimeMillis();
            this.b = 0L;
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (h.c() != null) {
                        h.c().y();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().R();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        c.a().j = i;
        c.a().k = i2;
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().J();
                }
            }
        });
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void a(long j) {
        try {
            this.d.seekTo((int) j, 3);
        } catch (IllegalStateException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void a(Surface surface) {
        try {
            this.d.setSurface(surface);
        } catch (Exception e) {
            e.printStackTrace();
            RVLogger.e(c, e);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void a(float f, float f2) {
        try {
            this.f = f;
            this.g = f2;
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f, f2);
            }
        } catch (IllegalStateException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.b
    public void a(float f) {
        try {
            MediaPlayer mediaPlayer = this.d;
            mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f));
        } catch (IllegalArgumentException e) {
            RVLogger.w(Log.getStackTraceString(e));
        } catch (IllegalStateException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        } catch (Exception e3) {
            RVLogger.w(Log.getStackTraceString(e3));
        }
    }
}
