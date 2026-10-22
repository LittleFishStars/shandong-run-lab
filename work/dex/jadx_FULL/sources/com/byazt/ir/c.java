package com.byazt.ir;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.aliyun.credentials.utils.AuthConstant;
import com.byazt.dna.qp;
import com.byazt.fk.sp;
import com.byazt.fk.u;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.byazt.jzl.ve;
import com.byazt.nr.d;
import com.byazt.oy.tt;
import com.byazt.ut.uj;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME, 20})
public class c implements sp, qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f28664a;
    public ILivePlayer c;
    public boolean cu;
    public long gu;
    public volatile u h;
    public int n;
    public long nu;
    public JSONObject or;
    public SurfaceTexture p;
    public boolean qp;
    public volatile boolean sp;
    public int uj;
    public final Context ve;
    public SurfaceHolder yv;
    public final List<WeakReference<sp.c>> tt = Collections.synchronizedList(new ArrayList());
    public AtomicBoolean x = new AtomicBoolean(false);
    public AtomicBoolean i = new AtomicBoolean(false);
    public volatile boolean da = false;
    public volatile boolean sl = false;
    public volatile boolean t = false;
    public volatile boolean u = false;
    public volatile boolean yp = false;
    public volatile boolean z = false;
    public volatile boolean m = true;
    public long rh = 0;
    public long my = 0;
    public final int gt = 0;
    public int rl = 0;
    public long qy = 0;
    public long gr = 0;
    public volatile boolean zm = false;
    public volatile int md = 200;
    public long d = 0;
    public final ArrayList<Runnable> eo = new ArrayList<>();
    public final Runnable zb = new Runnable() { // from class: com.byazt.ir.c.1
        @Override // java.lang.Runnable
        public void run() {
            sp.c cVar;
            long currentPosition = c.this.getCurrentPosition();
            c.this.gr += (long) c.this.md;
            if (c.this.getVideoDuration() > 0 && c.this.d != currentPosition) {
                if (tt.uj()) {
                    com.byazt.lt.tt.c("TTLiveVideoPlayer", "run: lastCur = " + c.this.d + "  currentPosition=" + currentPosition);
                }
                c cVar2 = c.this;
                cVar2.c(currentPosition, cVar2.getVideoDuration());
            }
            c.this.d = currentPosition;
            if (c.this.getCurrentPosition() >= c.this.gu) {
                c.this.u = true;
                c.this.release();
                for (WeakReference weakReference : c.this.tt) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onCompletion(c.this);
                    }
                }
            }
            if (c.this.u) {
                c cVar3 = c.this;
                cVar3.c(cVar3.getVideoDuration(), c.this.getVideoDuration());
            } else if (c.this.f28664a != null) {
                c.this.f28664a.postDelayed(this, c.this.md);
            }
        }
    };
    public final ILiveListener nb = new ILiveListener() { // from class: com.byazt.ir.c.7
        public boolean tt = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            sp.c cVar;
            if (c.this.f28664a == null) {
                return;
            }
            c.this.f28664a.removeCallbacks(c.this.zb);
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onBufferStart(c.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            sp.c cVar;
            if (liveError != null) {
                if (this.tt) {
                    return;
                }
                this.tt = true;
                ve veVar = new ve(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : c.this.tt) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onError(c.this, veVar);
                    }
                }
            }
            c.this.m = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            sp.c cVar;
            sp.c cVar2;
            if (c.this.f28664a == null) {
                return;
            }
            c.this.zm = true;
            c.this.f28664a.removeCallbacks(c.this.zb);
            if (c.this.gu > 0) {
                c.this.f28664a.postDelayed(c.this.zb, c.this.md);
            }
            c.this.m = false;
            if (!z) {
                com.byazt.lt.tt.tt("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z)));
                for (WeakReference weakReference : c.this.tt) {
                    if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                        cVar.onBufferEnd(c.this, -1);
                    }
                }
                return;
            }
            c.this.rh = System.currentTimeMillis() - c.this.nu;
            for (WeakReference weakReference2 : c.this.tt) {
                if (weakReference2 != null && (cVar2 = (sp.c) weakReference2.get()) != null) {
                    c cVar3 = c.this;
                    cVar2.onRenderStart(cVar3, cVar3.rh);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            sp.c cVar;
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onMonitorLog(c.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            sp.c cVar;
            com.byazt.lt.tt.c("TTLiveVideoPlayer", "onPrepared.....");
            c.this.yp = true;
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onPrepared(c.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            sp.c cVar;
            if (c.this.f28664a == null) {
                return;
            }
            if (c.this.gu > 0) {
                c.this.f28664a.postDelayed(c.this.zb, c.this.md);
            }
            c.this.my += System.currentTimeMillis() - c.this.qy;
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onBufferEnd(c.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            sp.c cVar;
            if (c.this.f28664a == null) {
                return;
            }
            c.nu(c.this);
            c.this.qy = System.currentTimeMillis();
            c.this.f28664a.removeCallbacks(c.this.zb);
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onBufferStart(c.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            sp.c cVar;
            c.this.uj = i;
            c.this.n = i2;
            for (WeakReference weakReference : c.this.tt) {
                if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                    cVar.onVideoSizeChanged(c.this, i, i2);
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.byazt.ir.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME, 44})
    public static class C0440c implements INetworkClient {
        public final t c;

        public C0440c() {
            t.c cVarTt = tt.ve().tt();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.c = cVarTt.c(10L, timeUnit).tt(10L, timeUnit).ve(10L, timeUnit).c();
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strTt;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    m mVarTt = this.c.c(new yp.c().c(str).tt(com.alipay.sdk.m.n.c.f, str2).tt()).tt();
                    if (mVarTt.uj()) {
                        strTt = mVarTt.a().tt();
                        try {
                            string = mVarTt.sp().toString();
                            jSONObject = new JSONObject(strTt);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strTt;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strTt = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strTt).build();
                } catch (JSONException e2) {
                    e = e2;
                    str3 = null;
                }
            } catch (IOException e3) {
                return INetworkClient.Result.newBuilder().setException(e3).build();
            } catch (Exception e4) {
                return INetworkClient.Result.newBuilder().setException(e4).build();
            }
        }
    }

    public c(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.f28664a = null;
        this.sp = false;
        this.gu = 0L;
        this.ve = context;
        this.or = jSONObject;
        this.gu = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.f28664a = new d(looper, this);
            this.sp = true;
        } else if (this.f28664a == null) {
            this.f28664a = ((qp) uj.getService("thread_service")).obtainHandler(this, "tt-live-video-player");
        }
        c(z);
    }

    public static /* synthetic */ int nu(c cVar) {
        int i = cVar.rl;
        cVar.rl = i + 1;
        return i;
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        for (WeakReference<sp.c> weakReference : this.tt) {
            if (weakReference != null && weakReference.get() == cVar) {
                return;
            }
        }
        this.tt.add(new WeakReference<>(cVar));
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        return this.rl;
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        return "";
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        return this.gr;
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        return this.yv;
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        return this.p;
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        return this.my;
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        return this.md;
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        return this.gu;
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        return this.n;
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        return this.uj;
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        sp.c cVar;
        sp.c cVar2;
        try {
            switch (message.what) {
                case 100:
                    for (WeakReference<sp.c> weakReference : this.tt) {
                        if (weakReference != null && (cVar = weakReference.get()) != null) {
                            cVar.onStart(this);
                        }
                    }
                    play();
                    this.z = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.c;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<sp.c> weakReference2 : this.tt) {
                                if (weakReference2 != null && (cVar2 = weakReference2.get()) != null) {
                                    cVar2.onPause(this);
                                }
                            }
                        } catch (Throwable th) {
                            com.byazt.lt.tt.c("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.m = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.c;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable th2) {
                            com.byazt.lt.tt.c("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.m = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.c;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable th3) {
                            com.byazt.lt.tt.c("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.sl = true;
                        this.m = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.c;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable th4) {
                            com.byazt.lt.tt.c("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.m = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.c == null || this.h == null) {
                        return;
                    }
                    String url = this.h.getUrl();
                    c(url);
                    this.c.setStreamInfo(url);
                    this.da = true;
                    com.byazt.lt.tt.c("TTLiveVideoPlayer", "set Datasource:" + this.da);
                    this.rl = 0;
                    return;
                case 110:
                    ILivePlayer iLivePlayer5 = this.c;
                    if (iLivePlayer5 != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        iLivePlayer5.setSurfaceHolder(surfaceHolder);
                        this.c.setSurface(surfaceHolder.getSurface());
                        this.i.set(true);
                        if (this.x.get()) {
                            c();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer6 = this.c;
                    if (iLivePlayer6 != null) {
                        iLivePlayer6.setSurface(new Surface(this.p));
                        this.i.set(true);
                        if (this.x.get()) {
                            c();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        e.getMessage();
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.u);
        return this.u;
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        return this.zm;
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        com.byazt.lt.tt.c("TTLiveVideoPlayer", "isLooping: live is invalid ");
        return false;
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        return this.m;
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        ILivePlayer iLivePlayer = this.c;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.byazt.lt.tt.c("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        return this.yp;
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        return this.sl;
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        return this.z;
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + getCurrentPosition());
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.removeCallbacks(this.zb);
            handler.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.fk.sp
    public void play() {
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ir.c.5
                @Override // java.lang.Runnable
                public void run() {
                    sp.c cVar;
                    if (c.this.c == null || c.this.isPlaying()) {
                        return;
                    }
                    try {
                        c.this.c.play();
                        c cVar2 = c.this;
                        cVar2.setQuietPlay(cVar2.qp);
                        for (WeakReference weakReference : c.this.tt) {
                            if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                                cVar.onResume(c.this);
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.lt.tt.c("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    c.this.m = false;
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void release() {
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.removeCallbacks(this.zb);
            handler.sendEmptyMessage(103);
            ve();
        }
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator<WeakReference<sp.c>> it = this.tt.iterator();
        while (it.hasNext()) {
            WeakReference<sp.c> next = it.next();
            if (next != null && next.get() == cVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void reset() {
        uj();
        Handler handler = this.f28664a;
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...reset......reset....");
        if (handler != null) {
            handler.removeCallbacks(this.zb);
            handler.sendEmptyMessage(102);
        }
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        this.rl = 0;
        this.my = 0L;
        this.qy = 0L;
        start(true, 0L, false);
    }

    @Override // com.byazt.fk.sp
    public void seekTo(long j) {
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(u uVar) {
        if (uVar == null) {
            return;
        }
        this.h = uVar;
        com.byazt.lt.tt.c("TTLiveVideoPlayer", "setDataSource: model = " + uVar.getUrl());
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.sendEmptyMessage(107);
        }
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.yv = surfaceHolder;
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        com.byazt.lt.tt.c("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(boolean z) {
        this.qp = z;
        if (this.c != null) {
            com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z)));
            try {
                this.c.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
                com.byazt.lt.tt.c("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
    }

    @Override // com.byazt.fk.sp
    public void setSurface(SurfaceTexture surfaceTexture) {
        this.p = surfaceTexture;
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(boolean z) {
        this.t = z;
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        this.md = i;
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, final long j, final boolean z2) {
        Handler handler;
        if (this.i.get() && this.da && this.c != null) {
            this.gr = j;
            this.nu = System.currentTimeMillis();
            setQuietPlay(z2);
            Handler handler2 = this.f28664a;
            if (handler2 != null) {
                handler2.sendEmptyMessage(100);
            }
            com.byazt.nr.m.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            c(new Runnable() { // from class: com.byazt.ir.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.gr = j;
                    c.this.nu = System.currentTimeMillis();
                    c.this.setQuietPlay(z2);
                    if (c.this.f28664a != null) {
                        c.this.f28664a.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.x.set(true);
        if (!this.i.get() || (handler = this.f28664a) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.byazt.ir.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.c();
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        com.byazt.lt.tt.tt("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + getCurrentPosition());
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.removeCallbacks(this.zb);
            handler.sendEmptyMessage(105);
        }
    }

    private void uj() {
        this.da = false;
        this.u = false;
        this.yp = false;
        this.z = false;
        this.m = true;
    }

    private void ve() {
        Handler handler = this.f28664a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f28664a.post(new Runnable() { // from class: com.byazt.ir.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f28664a == null || c.this.f28664a.getLooper() == null) {
                    return;
                }
                try {
                    c.this.p = null;
                    c.this.yv = null;
                    if (c.this.sp) {
                        c.this.f28664a.removeCallbacksAndMessages(null);
                    } else {
                        ((qp) uj.getService("thread_service")).recycleHandler(c.this.f28664a);
                    }
                    c.this.f28664a = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    private synchronized void tt() {
        if (this.cu) {
            return;
        }
        this.cu = true;
        Iterator it = new ArrayList(this.eo).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.eo.clear();
        this.cu = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, long j2) {
        sp.c cVar;
        for (WeakReference<sp.c> weakReference : this.tt) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onPlayPositionUpdate(this, j, j2);
            }
        }
    }

    private void c(final boolean z) {
        Handler handler = this.f28664a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.byazt.ir.c.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.byazt.ir.c.2.1
                            /* JADX WARN: Code duplicated, block: B:13:0x002c  */
                            /* JADX WARN: Code duplicated, block: B:14:0x002f  */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            public <T> T getSettingsValueForKey(String str, T t) {
                                Object objValueOf;
                                str.hashCode();
                                if (str.equals("live_enable_close_play_retry")) {
                                    if (t.getClass() == Integer.class) {
                                        objValueOf = Integer.valueOf("1");
                                    }
                                    return t.getClass() == Boolean.class ? (T) Boolean.TRUE : (T) objValueOf;
                                }
                                if (!str.equals("live_sdk_cancel_sdk_dns_fail_retry")) {
                                    return t;
                                }
                                objValueOf = t;
                                if (t.getClass() == Boolean.class) {
                                }
                            }
                        };
                        c cVar = c.this;
                        cVar.c = VideoLiveManager.newBuilder(cVar.ve).setProjectKey("pangle_ad_live").setNetworkClient(new C0440c()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(c.this.nb).build();
                        c.this.c.setIntOption(69, z ? 1 : 0);
                        c.this.c.setStringOption(72, com.byazt.nys.tt.c(c.this.ve, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.byazt.lt.tt.ve("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        ArrayList<Runnable> arrayList = this.eo;
        if (arrayList != null && !arrayList.isEmpty()) {
            tt();
        }
    }

    private synchronized void c(Runnable runnable) {
        this.eo.add(runnable);
    }

    private void c(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.or;
            if (jSONObject == null) {
                return;
            }
            com.byazt.lt.tt.c("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int iOptInt = jSONObject.optInt(AuthConstant.INI_ENABLE);
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("common");
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("app_id");
                    com.byazt.lt.tt.c("TTLiveVideoPlayer", "api ".concat(String.valueOf(strOptString2)));
                    if (strOptString.contains(strOptString2)) {
                        if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                            str2 = LiveConfigKey.UHD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (jSONObjectOptJSONObject2.optJSONObject("sd") != null) {
                            str2 = "sd";
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.byazt.lt.tt.c("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.c.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            com.byazt.lt.tt.c("TTLiveVideoPlayer", "updateStream: catch exception:", e.getMessage());
        }
    }
}
