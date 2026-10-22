package com.byazt.jy;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.dna.qp;
import com.byazt.dna.z;
import com.byazt.fk.sp;
import com.byazt.fk.u;
import com.byazt.jzl.ve;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.ut.uj;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2021, 13})
public class tt implements sp, qp.c {
    public static volatile boolean c = false;
    public boolean d;
    public long da;
    public volatile Handler gr;
    public int gt;
    public int my;
    public SurfaceHolder qy;
    public SurfaceTexture rl;
    public TTVideoEngine tt;
    public boolean ve = false;
    public boolean uj = false;
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28710a = false;
    public boolean sp = false;
    public boolean x = false;
    public boolean i = false;
    public long sl = 0;
    public long t = 0;
    public long u = 0;
    public int yp = 0;
    public int z = 0;
    public boolean m = false;
    public AtomicBoolean nu = new AtomicBoolean(false);
    public AtomicBoolean rh = new AtomicBoolean(false);
    public final List<WeakReference<sp.c>> gu = Collections.synchronizedList(new ArrayList());
    public volatile boolean zm = false;
    public volatile int yv = 200;
    public long p = 0;
    public Runnable md = new Runnable() { // from class: com.byazt.jy.tt.1
        @Override // java.lang.Runnable
        public void run() {
            long currentPosition = tt.this.getCurrentPosition();
            if (tt.this.getVideoDuration() > 0) {
                if (tt.this.p != currentPosition) {
                    if (com.byazt.oy.tt.uj()) {
                        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(tt.this.p), "  curPosition=", Long.valueOf(currentPosition));
                    }
                    tt ttVar = tt.this;
                    ttVar.c(currentPosition, ttVar.getVideoDuration());
                }
                tt.this.p = currentPosition;
            }
            if (tt.this.f28710a) {
                tt ttVar2 = tt.this;
                ttVar2.c(ttVar2.getVideoDuration(), tt.this.getVideoDuration());
            } else if (tt.this.gr != null) {
                tt.this.gr.postDelayed(this, tt.this.yv);
            }
        }
    };
    public final ArrayList<Runnable> h = new ArrayList<>();

    public tt(Context context, String str) {
        c(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        for (WeakReference<sp.c> weakReference : this.gu) {
            if (weakReference != null && weakReference.get() == cVar) {
                return;
            }
        }
        this.gu.add(new WeakReference<>(cVar));
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        return this.z;
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        return "";
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        try {
            return this.tt.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.byazt.lt.tt.tt(th.getMessage());
            return 0L;
        }
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        return this.qy;
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        return this.rl;
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        if (this.z == 0) {
            return 0L;
        }
        if (this.t == 0 && this.u != 0) {
            this.t = System.currentTimeMillis() - this.u;
        }
        return this.t;
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        return this.yv;
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        return this.tt.getDuration();
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.gt;
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.my;
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        sp.c cVar;
        sp.c cVar2;
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.tt;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                TTVideoEngine tTVideoEngine2 = this.tt;
                if (tTVideoEngine2 != null) {
                    tTVideoEngine2.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.rh.set(true);
                    if (this.nu.get()) {
                        uj();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 111) {
                if (this.tt != null) {
                    SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                    com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                    this.tt.setSurface(new Surface(surfaceTexture));
                    this.rh.set(true);
                    if (this.nu.get()) {
                        uj();
                        return;
                    }
                    return;
                }
                return;
            }
            switch (i) {
                case 100:
                    TTVideoEngine tTVideoEngine3 = this.tt;
                    if (tTVideoEngine3 != null) {
                        tTVideoEngine3.play();
                    }
                    break;
                case 101:
                    if (this.tt != null && this.gr != null) {
                        this.tt.pause();
                        for (WeakReference<sp.c> weakReference : this.gu) {
                            if (weakReference != null && (cVar = weakReference.get()) != null) {
                                cVar.onPause(this);
                            }
                        }
                        this.gr.removeCallbacks(this.md);
                    }
                    break;
                case 102:
                    sp();
                    break;
                case 103:
                    TTVideoEngine tTVideoEngine4 = this.tt;
                    if (tTVideoEngine4 != null) {
                        tTVideoEngine4.release();
                    }
                    this.n = true;
                    for (WeakReference<sp.c> weakReference2 : this.gu) {
                        if (weakReference2 != null && (cVar2 = weakReference2.get()) != null) {
                            cVar2.onRelease(this);
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        return this.f28710a;
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        return this.m;
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        return this.tt.isLooping();
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        return this.tt.getPlaybackState() == 2;
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        return this.tt.getPlaybackState() == 1;
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        return this.sp;
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        return this.n;
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        return this.x;
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "pause: ");
        Handler handler = this.gr;
        if (handler != null) {
            handler.removeMessages(100);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.fk.sp
    public void play() {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "play: ");
        Handler handler = this.gr;
        if (handler != null) {
            handler.postDelayed(this.md, this.yv);
            handler.post(new Runnable() { // from class: com.byazt.jy.tt.8
                @Override // java.lang.Runnable
                public void run() {
                    sp.c cVar;
                    try {
                        if (tt.this.tt != null) {
                            tt.this.tt.play();
                            for (WeakReference weakReference : tt.this.gu) {
                                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                                    cVar.onResume(tt.this);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "play: catch exception:", th);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void release() {
        n();
        Handler handler = this.gr;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.sendEmptyMessage(103);
            if (handler.getLooper() != null) {
                handler.post(new Runnable() { // from class: com.byazt.jy.tt.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!tt.this.zm) {
                                ((qp) uj.getService("thread_service")).recycleHandler(tt.this.gr);
                            }
                            tt.this.gr = null;
                        } catch (Throwable th) {
                            com.byazt.lt.tt.tt("CSJ_VIDEO_TTVideo", "release error:", th);
                        }
                    }
                });
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator<WeakReference<sp.c>> it = this.gu.iterator();
        while (it.hasNext()) {
            WeakReference<sp.c> next = it.next();
            if (next != null && next.get() == cVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void reset() {
        tt(new Runnable() { // from class: com.byazt.jy.tt.9
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.gr != null) {
                    tt.this.gr.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        TTVideoEngine tTVideoEngine = this.tt;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.z = 0;
        this.t = 0L;
        this.u = 0L;
        this.f28710a = false;
        start(true, 0L, zIsMute);
    }

    @Override // com.byazt.fk.sp
    public void seekTo(long j) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (this.uj) {
            this.tt.seekTo((int) j, new SeekCompletionListener() { // from class: com.byazt.jy.tt.10
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    sp.c cVar;
                    for (WeakReference weakReference : tt.this.gu) {
                        if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                            cVar.onSeekCompletion(tt.this, z);
                        }
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(u uVar) {
        this.tt.setDirectUrlUseDataLoader(uVar.getUrl(), uVar.getFileNameKey(), (String) null, uVar.getCacheParentDir());
        this.ve = true;
        this.z = 0;
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", uVar.getUrl(), " isH265=", Boolean.valueOf(uVar.isH265()), " presize=", Integer.valueOf(uVar.getPreloadSize()), " path=", uVar.getCacheParentDir(), " fileName =", uVar.getFileNameKey());
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(final SurfaceHolder surfaceHolder) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        setSurfaceValid(true);
        this.qy = surfaceHolder;
        tt(new Runnable() { // from class: com.byazt.jy.tt.4
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.gr != null) {
                    tt.this.gr.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        this.tt.setLooping(z);
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(boolean z) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.tt.setIsMute(z);
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
    }

    @Override // com.byazt.fk.sp
    public void setSurface(final SurfaceTexture surfaceTexture) {
        setSurfaceValid(true);
        this.rl = surfaceTexture;
        tt(new Runnable() { // from class: com.byazt.jy.tt.5
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.gr != null) {
                    tt.this.gr.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(boolean z) {
        this.i = z;
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        this.yv = i;
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, long j, boolean z2) {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j + " first:" + z + " quiet:" + z2);
        if (this.gr != null) {
            this.gr.postDelayed(this.md, this.yv);
        }
        this.da = System.currentTimeMillis();
        this.tt.setStartTime((int) j);
        this.tt.setIsMute(z2);
        if (this.rh.get() && this.ve) {
            tt();
        } else {
            com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            c(new Runnable() { // from class: com.byazt.jy.tt.6
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.tt();
                }
            });
        }
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "start:end");
        this.nu.set(true);
        if (!this.rh.get() || this.gr == null) {
            return;
        }
        this.gr.post(new Runnable() { // from class: com.byazt.jy.tt.7
            @Override // java.lang.Runnable
            public void run() {
                tt.this.uj();
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.gr != null) {
            this.gr.sendEmptyMessage(105);
        }
    }

    private void a() {
        this.tt.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.byazt.jy.tt.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                sp.c cVar;
                if (tt.this.yp == i) {
                    tt.this.t += System.currentTimeMillis() - tt.this.u;
                }
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i));
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onBufferEnd(tt.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                sp.c cVar;
                tt.this.yp = i;
                tt.this.z++;
                tt.this.u = System.currentTimeMillis();
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3));
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onBufferStart(tt.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i));
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onBufferingUpdate(tt.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onCompletion: ");
                tt.this.f28710a = true;
                if (tt.this.gr != null) {
                    tt.this.gr.removeCallbacks(tt.this.md);
                }
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onCompletion(tt.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onError: ");
                ve veVar = new ve(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onError(tt.this, veVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onPrepared: ");
                tt.this.sp = true;
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onPrepared(tt.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                tt.this.sl = System.currentTimeMillis() - tt.this.da;
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        tt ttVar = tt.this;
                        cVar.onRenderStart(ttVar, ttVar.sl);
                    }
                }
                tt.this.m = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                sp.c cVar;
                com.byazt.lt.tt.c("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2));
                tt.this.my = i;
                tt.this.gt = i2;
                for (WeakReference weakReference : tt.this.gu) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onVideoSizeChanged(tt.this, i, i2);
                    }
                }
            }
        });
    }

    private void n() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.h.clear();
    }

    private void sp() {
        this.ve = false;
        this.uj = false;
        this.f28710a = false;
        this.sp = false;
        this.x = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        sp.c cVar;
        this.x = true;
        this.uj = true;
        for (WeakReference<sp.c> weakReference : this.gu) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onStart(this);
            }
        }
        if (this.gr != null) {
            this.gr.sendEmptyMessage(100);
        }
    }

    private void ve() {
        if (this.d) {
            return;
        }
        this.d = true;
        Iterator it = new ArrayList(this.h).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.h.clear();
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, long j2) {
        sp.c cVar;
        for (WeakReference<sp.c> weakReference : this.gu) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onPlayPositionUpdate(this, j, j2);
            }
        }
    }

    private void c(Context context, String str, Looper looper) {
        this.tt = c.c(context);
        if (looper != null) {
            this.gr = new d(looper, this);
            this.zm = true;
        } else if (this.gr == null) {
            this.gr = ((qp) uj.getService("thread_service")).obtainHandler(this, "csj_".concat(String.valueOf(str)));
        }
        a();
    }

    private void tt(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.n) {
            runnable.run();
        } else {
            c(runnable);
        }
    }

    private synchronized void c(Runnable runnable) {
        this.h.add(runnable);
    }

    public static boolean c() {
        return c;
    }

    public static void c(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), com.byazt.oy.tt.getContext()).release();
            c.c(context, str, i, strArr, jArr, new VideoEventEngineUploader() { // from class: com.byazt.jy.tt.3
                @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                public void onEvent(String str2, JSONObject jSONObject) {
                    ((z) uj.getService("event")).onAppLogMiscEvent(str2, jSONObject);
                }
            });
            c.c(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        c = z2;
    }
}
