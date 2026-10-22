package com.byazt.kft;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.byazt.fk.sp;
import com.byazt.fk.u;
import com.byazt.fk.ve;
import com.byazt.ga.LottieAnimationView;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 13})
public class tt implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28728a;
    public final sp i;
    public final com.byazt.jr.tt sl;
    public LottieAnimationView t;
    public final int tt;
    public boolean uj;
    public final int ve;
    public final String c = "UpieVideoPlayer";
    public int n = 0;
    public volatile boolean sp = false;
    public volatile boolean x = false;
    public final Map<sp.c, sp.c> da = new ConcurrentHashMap();

    public tt(sp spVar, com.byazt.cph.c cVar, com.byazt.jzl.tt ttVar, com.byazt.jr.tt ttVar2) {
        this.i = spVar;
        this.tt = cVar.uj();
        this.ve = cVar.n();
        this.sl = ttVar2;
        if (ttVar2 instanceof UpieVideoView) {
            LottieAnimationView lottieAnimationView = ((UpieVideoView) ttVar2).getLottieAnimationView();
            this.t = lottieAnimationView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVideoStats(ttVar);
            }
        }
        c(cVar.c());
    }

    public static /* synthetic */ int c(tt ttVar) {
        int i = ttVar.n;
        ttVar.n = i + 1;
        return i;
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(final sp.c cVar) {
        if (cVar == null) {
            return;
        }
        sp.c cVar2 = new sp.c() { // from class: com.byazt.kft.tt.5
            @Override // com.byazt.fk.sp.c
            public void onBufferEnd(sp spVar, int i) {
                cVar.onBufferEnd(tt.this, i);
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferStart(sp spVar, int i, int i2, int i3) {
                cVar.onBufferStart(tt.this, i, i2, i3);
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferingUpdate(sp spVar, int i) {
                cVar.onBufferingUpdate(tt.this, i);
            }

            @Override // com.byazt.fk.sp.c
            public void onCompletion(sp spVar) {
                cVar.onCompletion(tt.this);
            }

            @Override // com.byazt.fk.sp.c
            public void onError(sp spVar, ve veVar) {
                tt.this.c(veVar);
            }

            @Override // com.byazt.fk.sp.c
            public void onMonitorLog(sp spVar, JSONObject jSONObject, String str) {
                cVar.onMonitorLog(tt.this, jSONObject, str);
            }

            @Override // com.byazt.fk.sp.c
            public void onPause(sp spVar) {
                cVar.onPause(tt.this);
            }

            @Override // com.byazt.fk.sp.c
            public void onPlayPositionUpdate(sp spVar, long j, long j2) {
                cVar.onPlayPositionUpdate(tt.this, j, j2);
            }

            @Override // com.byazt.fk.sp.c
            public void onPrepared(sp spVar) {
                com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.tt.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.x = true;
                        if (!tt.this.sp) {
                            tt.this.i.pause();
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        cVar.onPrepared(tt.this);
                        tt.this.c();
                    }
                });
            }

            @Override // com.byazt.fk.sp.c
            public void onRelease(sp spVar) {
                cVar.onRelease(tt.this);
            }

            @Override // com.byazt.fk.sp.c
            public void onRenderStart(sp spVar, final long j) {
                com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.tt.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        cVar.onRenderStart(tt.this, j);
                    }
                });
            }

            @Override // com.byazt.fk.sp.c
            public void onResume(sp spVar) {
                cVar.onResume(tt.this);
            }

            @Override // com.byazt.fk.sp.c
            public void onSeekCompletion(sp spVar, boolean z) {
                cVar.onSeekCompletion(tt.this, z);
            }

            @Override // com.byazt.fk.sp.c
            public void onStart(sp spVar) {
                cVar.onStart(tt.this);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.byazt.fk.sp.c
            public void onVideoSizeChanged(sp spVar, int i, int i2) {
                sp.c cVar3 = cVar;
                tt ttVar = tt.this;
                cVar3.onVideoSizeChanged(ttVar, ttVar.tt, tt.this.ve);
            }
        };
        this.da.put(cVar, cVar2);
        this.i.addIVideoPlayerCallback(cVar2);
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        return this.i.getBufferCount();
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        return "";
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        return this.i.getCurrentPosition();
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        return this.i.getSurfaceHolder();
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        return this.i.getSurfaceTexture();
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        return this.i.getTotalBufferTime();
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        return this.i.getUpdateProgressInterval();
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        return this.i.getVideoDuration();
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        return this.ve;
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        return this.tt;
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        boolean z = !this.uj && this.i.isCompleted();
        m.c("UpieVideoPlayer", "--==--isCompleted: " + z + ",      errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        return this.i.isFirstFrameSuccess();
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        return this.i.isLooping();
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        boolean z = !this.uj && this.i.isPaused();
        m.c("UpieVideoPlayer", "--==--isPaused: " + z + ",      errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        boolean z = !this.uj && this.i.isPlaying();
        m.c("UpieVideoPlayer", "--==--isPlaying: " + z + ",      errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        boolean z = !this.uj && this.i.isPrepared();
        m.c("UpieVideoPlayer", "--==--isPrepared: " + z + ",     errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        boolean z = !this.uj && this.i.isReleased();
        m.c("UpieVideoPlayer", "--==--isReleased: " + z + ",      errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        boolean z = !this.uj && this.i.isStarted();
        m.c("UpieVideoPlayer", "--==--isStarted: " + z + ",      errorInvoked: " + this.uj);
        return z;
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        m.c("UpieVideoPlayer", "--==--pause");
        this.i.pause();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.sp();
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).tt();
        }
    }

    @Override // com.byazt.fk.sp
    public void play() {
        m.c("UpieVideoPlayer", "--==--play");
        this.i.play();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.tt();
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).c();
        }
    }

    @Override // com.byazt.fk.sp
    public void release() {
        m.c("UpieVideoPlayer", "--==--release");
        this.i.release();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).tt();
        }
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        sp.c cVarRemove = this.da.remove(cVar);
        if (cVarRemove != null) {
            this.i.removeIVideoPlayerCallback(cVarRemove);
        }
    }

    @Override // com.byazt.fk.sp
    public void reset() {
        m.c("UpieVideoPlayer", "--==--reset");
        this.i.reset();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.sp();
            this.t.setProgress(0.0f);
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).tt();
        }
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        m.c("UpieVideoPlayer", "--==--restart");
        this.i.restart();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.t.setProgress(0.0f);
            this.t.c();
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).c();
        }
    }

    @Override // com.byazt.fk.sp
    public void seekTo(long j) {
        m.c("UpieVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.i.seekTo(j);
        c(j);
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(u uVar) {
        m.c("UpieVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(uVar)));
        this.i.setDataSource(uVar);
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.i.setDisplay(surfaceHolder);
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        this.i.setLoop(z);
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
        this.i.setPlaySpeedRatio(f);
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(boolean z) {
        m.c("UpieVideoPlayer", "--==--isMute: ".concat(String.valueOf(z)));
        this.i.setQuietPlay(z);
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
        m.c("UpieVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
        this.i.setSeekMode(i);
    }

    @Override // com.byazt.fk.sp
    public void setSurface(SurfaceTexture surfaceTexture) {
        this.i.setSurface(surfaceTexture);
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(boolean z) {
        this.i.setSurfaceValid(z);
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        this.i.setUpdateProgressInterval(i);
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, long j, boolean z2) {
        m.c("UpieVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.i.start(z, j, z2);
        this.f28728a = j;
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).c();
        }
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        m.c("UpieVideoPlayer", "--==--stop");
        this.i.stop();
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.sp();
        }
        com.byazt.jr.tt ttVar = this.sl;
        if (ttVar instanceof UpieVideoView) {
            ((UpieVideoView) ttVar).tt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            c(new com.byazt.jzl.ve(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.qk.tt.ve(new Runnable() { // from class: com.byazt.kft.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    String strC = com.byazt.cph.tt.c().c(str);
                    if (TextUtils.isEmpty(strC)) {
                        com.byazt.cph.tt.c().c(str, new com.byazt.cph.tt.c<String>() { // from class: com.byazt.kft.tt.1.1
                            @Override // com.byazt.cph.tt.c
                            public void c(String str2) {
                                m.c("UpieVideoPlayer", "--==-- lottie load jsonStr ok");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                tt.this.c(str2, str);
                            }

                            @Override // com.byazt.cph.tt.c
                            public void c(int i, String str2) {
                                m.c("UpieVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    tt.this.c(new com.byazt.jzl.ve(60008, i, str2));
                                    return;
                                }
                                tt.c(tt.this);
                                if (tt.this.n <= 3) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    tt.this.c(str);
                                } else {
                                    tt.this.c(new com.byazt.jzl.ve(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        m.c("UpieVideoPlayer", "--==-- lottie use cache ok");
                        tt.this.c(strC, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ve veVar) {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.tt.2
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.uj) {
                    return;
                }
                tt.this.uj = true;
                m.c("UpieVideoPlayer", "--==--play err, code: " + veVar.getCode() + ", extra: " + veVar.getExtraCode() + ", msg: " + veVar.getMsg());
                Iterator it = tt.this.da.entrySet().iterator();
                while (it.hasNext()) {
                    ((sp.c) ((Map.Entry) it.next()).getKey()).onError(tt.this, veVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2) {
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.tt.3
            @Override // java.lang.Runnable
            public void run() {
                tt.this.sp = true;
                if (tt.this.t != null) {
                    tt.this.t.c(str, str2);
                }
                tt.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.tt.4
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.x && tt.this.sp) {
                    tt.this.i.play();
                    if (tt.this.t != null) {
                        tt.this.t.c();
                        if (tt.this.f28728a > 0) {
                            tt ttVar = tt.this;
                            ttVar.c(ttVar.f28728a);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = getVideoDuration();
            }
            if (duration > 0) {
                this.t.setProgress((j % duration) / duration);
            }
        }
    }
}
