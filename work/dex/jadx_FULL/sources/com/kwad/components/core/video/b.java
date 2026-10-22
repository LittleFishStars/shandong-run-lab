package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private static boolean amw = false;
    private static final AtomicInteger amx = new AtomicInteger(0);
    private final String TAG;
    private final int Uy;
    private volatile int Vl;
    private long amA;
    private Runnable amB;
    private com.kwad.sdk.contentalliance.a.a.b amC;
    private int amD;
    private List<com.kwad.sdk.core.video.a.c.d> amE;
    private final AtomicBoolean amF;
    private boolean amG;
    private boolean amH;
    private boolean amI;
    private volatile List<l> amJ;
    private volatile List<com.kwad.components.core.video.a.c> amK;
    private volatile List<com.kwad.sdk.core.video.a.c.e> amL;
    private final com.kwad.sdk.core.video.a.c.f amM;
    private com.kwad.sdk.core.video.a.c.e amN;
    private com.kwad.sdk.core.video.a.c.i amO;
    private com.kwad.sdk.core.video.a.c.b amP;
    private com.kwad.sdk.core.video.a.c.InterfaceC1289c amQ;
    private com.kwad.sdk.core.video.a.c.d amR;
    private com.kwad.sdk.core.video.a.c.a amS;
    private int ame;
    private int amf;
    private com.kwad.sdk.core.video.a.c amy;
    private int amz;
    private Handler jk;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private float mSpeed;
    private long mStartTime;

    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private void bZ(int i) {
        for (com.kwad.components.core.video.a.c cVar : this.amK) {
            if (i == 0) {
                cVar.onStart();
            } else if (i == 1) {
                cVar.onReset();
            } else if (i == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            }
        }
    }

    private void bf(final boolean z) {
        if (this.amy == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "start prepareAsync");
        if (this.amG) {
            if (this.amF.compareAndSet(false, true)) {
                com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.core.video.b.10
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.Vl));
                        if (b.this.amy == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.amy) {
                                try {
                                    b.this.bg(z);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            try {
                                com.kwad.sdk.core.d.c.e(b.this.TAG, "prepareAsync Exception:" + b.getStateString(b.this.Vl), th2);
                            } catch (Throwable th3) {
                                b.this.amF.set(false);
                                throw th3;
                            }
                        }
                        b.this.amF.set(false);
                        try {
                            synchronized (b.this.amF) {
                                b.this.amF.notifyAll();
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            bg(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.amD;
                this.amD = i + 1;
                if (i <= 4) {
                    xp();
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.Vl));
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        b(this.amC);
        boolean zXJ = z ? this.amy.xJ() : this.amy.prepareAsync();
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync forcePrepare: " + z + ", result: " + zXJ);
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    private void reset() {
        com.kwad.sdk.core.d.c.i(this.TAG, "reset:" + getStateString(this.Vl) + "->STATE_IDLE");
        bZ(1);
        this.amy.reset();
        this.Vl = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.amC;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.amJ != null) {
            Iterator<l> it = this.amJ.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void xn() {
        this.amy.a(this.amM);
        this.amy.b(this.amN);
        this.amy.a(this.amO);
        this.amy.a(this.amP);
        this.amy.a(this.amQ);
        this.amy.c(this.amR);
        this.amy.a(this.amS);
    }

    private void xo() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar == null) {
            return;
        }
        cVar.a((com.kwad.sdk.core.video.a.c.InterfaceC1289c) null);
        this.amy.a((com.kwad.sdk.core.video.a.c.b) null);
        this.amy.b((com.kwad.sdk.core.video.a.c.e) null);
        this.amy.a((com.kwad.sdk.core.video.a.c.i) null);
        this.amy.c(null);
        this.amy.a((com.kwad.sdk.core.video.a.c.g) null);
        this.amy.a((com.kwad.sdk.core.video.a.c.a) null);
    }

    private void xq() {
        xr();
        if (this.amB == null) {
            this.amB = new bi() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    b.this.xk();
                    if (b.this.amB != null) {
                        b.this.jk.postDelayed(b.this.amB, (long) (500.0f / b.this.mSpeed));
                    }
                }
            };
        }
        this.jk.post(this.amB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        Runnable runnable = this.amB;
        if (runnable != null) {
            this.jk.removeCallbacks(runnable);
            this.amB = null;
        }
    }

    private boolean xs() {
        if (this.amH && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue()) {
            return true;
        }
        return ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue();
    }

    public final void clear() {
        this.amJ.clear();
        this.amK.clear();
    }

    public final void complete() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            cVar.pause();
            this.amy.seekTo(0L);
        }
        if (this.Vl != 9) {
            this.Vl = 9;
            onPlayStateChanged(this.Vl);
            com.kwad.sdk.core.video.a.a.a.fs("videoFinishPlay");
        }
    }

    public final boolean getAlphaVideoValid() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar instanceof g;
        }
        return false;
    }

    public final int getBufferPercentage() {
        return this.amz;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.Vl == 2 || this.Vl == 3 || this.Vl == 5 || this.Vl == 8 || this.Vl == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.Vl == 1;
    }

    public final void onPlayStateChanged(final int i) {
        if (this.amJ == null) {
            return;
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                for (l lVar : b.this.amJ) {
                    switch (i) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.xr();
                            lVar.onMediaPlayError(b.this.ame, b.this.amf);
                            break;
                        case 1:
                            lVar.onMediaPreparing();
                            break;
                        case 2:
                            lVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            lVar.onMediaPlayPaused();
                            break;
                        case 6:
                            lVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            lVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.amy != null && !b.this.amy.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.xr();
                            }
                            lVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.d.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.Vl));
        if (this.Vl == 4) {
            this.amy.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.Vl = 5;
            onPlayStateChanged(this.Vl);
            com.kwad.sdk.core.video.a.a.a.fs("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.Vl == 6) {
            this.amy.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.Vl = 7;
            onPlayStateChanged(this.Vl);
            z = true;
        }
        if (this.Vl == 3) {
            this.amy.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.Vl = 5;
            onPlayStateChanged(this.Vl);
            com.kwad.sdk.core.video.a.a.a.fs("videoPausePlay");
            z = true;
        }
        if (this.Vl != 9 || !this.amy.isLooping()) {
            return z;
        }
        this.amy.pause();
        com.kwad.sdk.core.d.c.i(this.TAG, "pause " + getStateString(this.Vl) + "->STATE_PAUSED");
        this.Vl = 5;
        onPlayStateChanged(this.Vl);
        return true;
    }

    public final void prepareAsync() {
        bf(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void restart() {
        if (this.amy != null && this.Vl == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.amy == null) {
                com.kwad.sdk.core.d.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume state: " + getStateString(this.Vl));
            if (this.Vl != 2 && this.Vl != 3 && this.Vl != 0) {
                if (this.Vl == 5) {
                    this.amy.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Vl) + "->STATE_PLAYING");
                    this.Vl = 4;
                    onPlayStateChanged(this.Vl);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.fs("videoResumePlay");
                    return;
                }
                if (this.Vl == 7) {
                    this.amy.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Vl) + "->STATE_BUFFERING_PLAYING");
                    this.Vl = 6;
                    onPlayStateChanged(this.Vl);
                    return;
                }
                if (this.Vl == 9) {
                    start();
                    return;
                }
                if (this.Vl != 1) {
                    com.kwad.sdk.core.d.c.w(this.TAG, "resume: " + getStateString(this.Vl) + " 此时不能调用resume()方法.");
                    return;
                }
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.Vl) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setClickCoordForOpaque(float f, float f2) {
        try {
            com.kwad.sdk.core.video.a.c cVar = this.amy;
            if (cVar == null || !(cVar instanceof g)) {
                return;
            }
            ((g) cVar).setClickCoordForOpaque(f, f2);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void setIsAlphaVideoPlayer(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setIsAlphaVideoView(z);
        }
        this.amH = z;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar == null) {
            return;
        }
        if (f > 0.0f) {
            this.mSpeed = f;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setTKPlayer() {
        this.amI = true;
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void start() {
        try {
            if (this.amy == null) {
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start state: " + getStateString(this.Vl));
            bZ(0);
            if (this.Vl == 0) {
                com.kwad.sdk.core.d.c.i(this.TAG, "start still not prepared well forcePrepare");
                bf(true);
                return;
            }
            if (this.Vl != 2 && this.Vl != 9) {
                if (this.Vl == 3) {
                    this.amy.start();
                    return;
                } else {
                    if (this.Vl == 5) {
                        resume();
                        return;
                    }
                    return;
                }
            }
            this.mStartTime = System.currentTimeMillis();
            long j = this.amA;
            if (j != 0) {
                this.amy.seekTo((int) j);
            }
            this.amy.start();
            com.kwad.sdk.core.video.a.a.a.fs("videoStartPlay");
            com.kwad.sdk.core.d.c.i(this.TAG, "start:" + getStateString(this.Vl) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.amC;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.Vl == 2) {
                    if (this.amC.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.Vl == 9) {
                    setPlayType(3);
                }
            }
            this.Vl = 3;
            onPlayStateChanged(this.Vl);
            xq();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.Vl));
        if (this.Vl == 1 || this.Vl == 2) {
            return;
        }
        if (this.Vl == 3 || this.Vl == 4 || this.Vl == 5 || this.Vl == 6 || this.Vl == 7 || this.Vl == 8 || this.Vl == 9) {
            try {
                this.amy.stop();
                this.Vl = 8;
                onPlayStateChanged(this.Vl);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    public final com.kwad.sdk.core.video.a.c xm() {
        return this.amy;
    }

    public final void xp() {
        if (this.amy == null) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.Vl == 2 || this.Vl == 3 || this.Vl == 4 || this.Vl == 5) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "can not resetAndPlay in state:");
            return;
        }
        reset();
        xo();
        xn();
        prepareAsync();
    }

    private b(@Nullable DetailVideoView detailVideoView, int i) {
        this.Vl = 0;
        this.jk = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.amD = 0;
        this.amE = new CopyOnWriteArrayList();
        this.amF = new AtomicBoolean(false);
        this.amG = false;
        this.amH = false;
        this.amI = false;
        this.mSpeed = 1.0f;
        this.amJ = new CopyOnWriteArrayList();
        this.amK = new CopyOnWriteArrayList();
        this.amL = new CopyOnWriteArrayList();
        this.amM = new com.kwad.sdk.core.video.a.c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void xt() {
                b.this.Vl = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Vl);
            }
        };
        this.amN = new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.Vl) + "->STATE_PREPARED");
                    b.this.Vl = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Vl);
                    Iterator it = b.this.amL.iterator();
                    while (it.hasNext()) {
                        ((com.kwad.sdk.core.video.a.c.e) it.next()).a(b.this.amy);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.amO = new com.kwad.sdk.core.video.a.c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void n(int i2, int i3) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.amP = new com.kwad.sdk.core.video.a.c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void tK() {
                b.this.Vl = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Vl);
                com.kwad.sdk.core.video.a.a.a.fs("videoFinishPlay");
            }
        };
        this.amQ = new com.kwad.sdk.core.video.a.c.InterfaceC1289c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC1289c
            public final boolean o(int i2, int i3) {
                if (i2 == -38) {
                    return true;
                }
                b.this.Vl = -1;
                b.this.ame = i2;
                b.this.amf = i3;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Vl);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
        };
        this.amR = new com.kwad.sdk.core.video.a.c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i2, int i3) {
                if (i2 == 3) {
                    b.this.Vl = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Vl);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.Vl) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i2 == 701) {
                    if (b.this.Vl == 5 || b.this.Vl == 7) {
                        b.this.Vl = 7;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.Vl = 6;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.Vl);
                } else if (i2 == 702) {
                    if (b.this.Vl == 6) {
                        b.this.Vl = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.Vl);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.Vl == 7) {
                        b.this.Vl = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.Vl);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i2);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.amy, i2, i3);
                return true;
            }
        };
        this.amS = new com.kwad.sdk.core.video.a.c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void br(int i2) {
                b.this.amz = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.Uy = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.d.c.i(str, "create DetailMediaPlayerImpl");
    }

    public final void c(l lVar) {
        this.amJ.add(lVar);
    }

    public final void d(l lVar) {
        this.amJ.remove(lVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, true, detailVideoView);
    }

    public final void b(com.kwad.sdk.core.video.a.c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.amE.remove(dVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        Throwable th;
        g gVar;
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.config.e.Fs();
        com.kwad.sdk.core.video.a.c cVarA = null;
        if (xs()) {
            try {
                gVar = new g(bVar, this.mAdTemplate);
                if (g.isWaynePlayerReady()) {
                    try {
                        com.kwad.sdk.core.d.c.i(this.TAG, "constructPlayer KwaiWaynePlayer");
                    } catch (Throwable th2) {
                        th = th2;
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                    cVarA = gVar;
                }
            } catch (Throwable th3) {
                th = th3;
                gVar = null;
            }
        }
        if (cVarA == null) {
            cVarA = com.kwad.sdk.core.video.a.e.a(this.mContext, z, com.kwad.sdk.core.config.e.Fs(), com.kwad.sdk.core.config.e.Ft(), this.Uy);
        }
        if (cVarA != null) {
            try {
                DetailVideoView detailVideoView2 = this.mDetailVideoView;
                if (detailVideoView2 != null) {
                    detailVideoView2.ca(cVarA.getMediaPlayerType());
                }
                com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + cVarA.getClass().getName());
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
            }
        }
        cVarA.setLooping(false);
        a(bVar, z2, detailVideoView, cVarA);
    }

    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.amy.b(bVar);
                return;
            }
            com.kwad.sdk.core.d.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + this.amy);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.amG = z;
        this.amC = bVar;
        com.kwad.components.core.video.a.a aVarA = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl, cVar.getMediaPlayerType(), this.amI);
        c(aVarA);
        a(aVarA);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.amy != cVar) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.amy;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                xo();
                this.amy.release();
            }
            this.amy = cVar;
            reset();
            xn();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            xo();
            xn();
        }
        this.amy.setSurface(detailVideoView.anc);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j) {
        this.amA = j;
        start();
    }

    public final void a(com.kwad.sdk.core.video.a.c.e eVar) {
        this.amL.add(eVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.amE.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<com.kwad.sdk.core.video.a.c.d> it = this.amE.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.video.a.c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.m(i, i2);
            }
        }
    }

    public final void a(final a aVar, boolean z) {
        if (this.amy == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "release:" + getStateString(this.Vl) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.jk.removeCallbacksAndMessages(null);
        xr();
        xo();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.amy = null;
        }
        this.Vl = 0;
        this.amD = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.Vl) + "->STATE_IDLE");
        try {
            bZ(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.amK.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.amy;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}
