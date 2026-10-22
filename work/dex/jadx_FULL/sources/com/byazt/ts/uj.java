package com.byazt.ts;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.dna.qp;
import com.byazt.fk.sp;
import com.byazt.fk.u;
import com.byazt.jzl.a;
import com.byazt.nr.d;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 357, 15})
public class uj implements ve.a, ve.c, ve.n, ve.sp, ve.tt, ve.uj, ve.InterfaceC0537ve, sp, qp.c {
    public static final AtomicInteger c = new AtomicInteger(0);
    public static final SparseIntArray zm = new SparseIntArray();
    public volatile boolean bx;
    public com.byazt.jzl.tt d;
    public boolean da;
    public ArrayList<Runnable> gu;
    public int n;
    public boolean qy;
    public boolean sl;
    public SurfaceTexture tt;
    public SurfaceHolder ve;
    public volatile Handler yp;
    public boolean yv;
    public int uj = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29073a = false;
    public volatile ve sp = null;
    public final boolean x = false;
    public boolean i = false;
    public volatile int t = 201;
    public long u = -1;
    public volatile boolean z = false;
    public boolean m = false;
    public long nu = 0;
    public long rh = Long.MIN_VALUE;
    public long my = 0;
    public long gt = 0;
    public long rl = 0;
    public int gr = 0;
    public final List<WeakReference<sp.c>> p = new CopyOnWriteArrayList();
    public u md = null;
    public boolean h = false;
    public volatile int eo = 200;
    public AtomicBoolean zb = new AtomicBoolean(false);
    public AtomicBoolean or = new AtomicBoolean(false);
    public AtomicBoolean cu = new AtomicBoolean(false);
    public Surface qp = null;
    public final Runnable nb = new Runnable() { // from class: com.byazt.ts.uj.1
        @Override // java.lang.Runnable
        public void run() {
            if (uj.this.sp == null) {
                return;
            }
            long currentPosition = uj.this.getCurrentPosition();
            if (currentPosition > 0 && uj.this.isPlaying() && uj.this.rh != Long.MIN_VALUE) {
                try {
                    if (uj.this.rh == currentPosition) {
                        if (!uj.this.m && uj.this.my >= 400) {
                            uj.this.tt(701, 800);
                            uj.this.m = true;
                        }
                        uj.this.my += (long) uj.this.eo;
                    } else {
                        if (uj.this.m) {
                            uj.this.nu += uj.this.my;
                            uj.this.tt(702, 800);
                            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(uj.this.nu), "  bufferCount =", Integer.valueOf(uj.this.uj));
                        }
                        uj.this.my = 0L;
                        uj.this.m = false;
                    }
                } catch (Throwable th) {
                    com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (uj.this.getVideoDuration() > 0) {
                if (uj.this.rh != currentPosition) {
                    if (com.byazt.oy.tt.uj()) {
                        com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(uj.this.rh), "  curPosition = ", Long.valueOf(currentPosition));
                    }
                    uj ujVar = uj.this;
                    ujVar.c(currentPosition, ujVar.getVideoDuration());
                }
                uj.this.rh = currentPosition;
            }
            if (uj.this.isCompleted()) {
                uj ujVar2 = uj.this;
                ujVar2.c(ujVar2.getVideoDuration(), uj.this.getVideoDuration());
            } else if (uj.this.yp != null) {
                uj.this.yp.postDelayed(this, uj.this.eo);
            }
        }
    };
    public final c pf = new c();
    public long sv = 0;
    public long aw = 0;
    public boolean ic = true;

    @com.byazt.zqa.c(c = {0, 1, 357, 123})
    public class c implements Runnable {
        public long tt;
        public boolean ve;

        public c() {
        }

        public void c(boolean z) {
            this.ve = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (uj.this.sp != null) {
                try {
                    if (!this.ve) {
                        long jI = uj.this.sp.i();
                        uj.this.u = Math.max(this.tt, jI);
                    }
                    long unused = uj.this.u;
                } catch (Throwable unused2) {
                }
            }
            if (uj.this.yp != null) {
                uj.this.yp.sendEmptyMessageDelayed(100, 0L);
            }
        }

        public void c(long j) {
            this.tt = j;
        }
    }

    public uj(String str, com.byazt.jzl.tt ttVar) {
        this.d = ttVar;
        c("mda_" + str + LoginConstants.UNDER_LINE + c.addAndGet(1), (Looper) null);
        c("0501");
    }

    private boolean c(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && weakReference.get() == cVar) {
                return;
            }
        }
        this.p.add(new WeakReference<>(cVar));
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        return this.uj;
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        return "";
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        if (isReleased()) {
            return 0L;
        }
        if (this.t == 206 || this.t == 207) {
            try {
                return this.sp.i();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        return this.ve;
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        return this.tt;
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        if (this.m) {
            long j = this.my;
            if (j > 0) {
                return this.nu + j;
            }
        }
        return this.nu;
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        return this.eo;
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        long j = this.gt;
        if (j != 0) {
            return j;
        }
        if (this.t == 206 || this.t == 207) {
            try {
                this.gt = this.sp.da();
            } catch (Throwable unused) {
            }
        }
        return this.gt;
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        if (this.sp == null || isReleased()) {
            return 0;
        }
        return this.sp.yp();
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        if (this.sp == null || isReleased()) {
            return 0;
        }
        return this.sp.u();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:116:0x0218  */
    /* JADX WARN: Code duplicated, block: B:55:0x0120  */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        int i;
        int i2;
        sp.c cVar;
        sp.c cVar2;
        sp.c cVar3;
        sp.c cVar4;
        int i3 = this.t;
        int i4 = message.what;
        if (this.sp != null) {
            i = message.what;
            try {
                try {
                    switch (i) {
                        case 100:
                            i = 0;
                            if (this.t == 205 || this.t == 207 || this.t == 209) {
                                c("0505");
                                this.sp.n();
                                this.rl = SystemClock.elapsedRealtime();
                                this.t = 206;
                                if (this.u > 0) {
                                    this.sp.c(this.u, this.n);
                                    this.u = -1L;
                                }
                                if (this.md != null) {
                                    setQuietPlay(this.h);
                                }
                                for (WeakReference<sp.c> weakReference : this.p) {
                                    if (weakReference != null && (cVar3 = weakReference.get()) != null) {
                                        cVar3.onStart(this);
                                    }
                                }
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 101:
                            if (this.m) {
                                this.nu += this.my;
                            }
                            this.m = false;
                            this.my = 0L;
                            this.rh = Long.MIN_VALUE;
                            if (this.t == 206 || this.t == 207 || this.t == 209) {
                                this.sp.sp();
                                c("0507");
                                this.t = 207;
                                i = 0;
                                this.bx = false;
                                for (WeakReference<sp.c> weakReference2 : this.p) {
                                    if (weakReference2 != null && (cVar4 = weakReference2.get()) != null) {
                                        cVar4.onPause(this);
                                    }
                                }
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 102:
                            this.sp.t();
                            this.t = 201;
                            i = 0;
                            i2 = i;
                            break;
                        case 103:
                            try {
                                n();
                            } catch (Throwable th) {
                                com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                            }
                            for (WeakReference<sp.c> weakReference3 : this.p) {
                                if (weakReference3 != null && (cVar2 = weakReference3.get()) != null) {
                                    cVar2.onRelease(this);
                                }
                            }
                            this.t = 203;
                            i = 0;
                            i2 = i;
                            break;
                        case 104:
                            if (this.t == 202 || this.t == 208) {
                                try {
                                    this.sp.x();
                                } catch (Throwable th2) {
                                    com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                                }
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 105:
                            if (this.t == 205 || this.t == 206 || this.t == 208 || this.t == 207 || this.t == 209) {
                                this.sp.a();
                                c("0508");
                                this.t = 208;
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 106:
                            if (this.t == 206 || this.t == 207 || this.t == 209) {
                                this.sp.c(((Long) message.obj).longValue(), this.n);
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 107:
                            tt();
                            if (this.t == 201 || this.t == 203) {
                                a aVar = (a) message.obj;
                                if (TextUtils.isEmpty(aVar.getCacheParentDir())) {
                                    aVar.setCacheParentDir(com.byazt.oy.tt.c());
                                }
                                File file = new File(aVar.getCacheParentDir(), aVar.getFileNameKey());
                                if (file.exists()) {
                                    file.getAbsolutePath();
                                    if (com.byazt.oy.tt.tt()) {
                                        tt(file.getAbsolutePath());
                                    } else {
                                        this.sp.c(file.getAbsolutePath());
                                    }
                                } else {
                                    aVar.getUrl();
                                    this.sp.c(aVar, this.d);
                                }
                                c("0503");
                                this.t = 202;
                                i = 0;
                                i2 = i;
                            } else {
                                i2 = 1;
                            }
                            break;
                        case 108:
                        case 109:
                        default:
                            i = 0;
                            i2 = i;
                            break;
                        case 110:
                            this.sp.c((SurfaceHolder) message.obj);
                            c("0502");
                            this.sp.tt(true);
                            this.or.set(true);
                            if (this.zb.get()) {
                                sl();
                            }
                            i = 0;
                            i2 = i;
                            break;
                        case 111:
                            this.qp = new Surface((SurfaceTexture) message.obj);
                            this.sp.c(this.qp);
                            c("0502");
                            this.sp.tt(true);
                            this.cu.set(true);
                            if (this.zb.get()) {
                                sl();
                            }
                            i = 0;
                            i2 = i;
                            break;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        } else {
            i = 0;
            i2 = i;
        }
        if (i2 != 0) {
            this.t = 200;
            if (this.i) {
                return;
            }
            com.byazt.jzl.ve veVar = new com.byazt.jzl.ve(308, i4);
            veVar.setMsg(i3 + "," + i4);
            c("0510");
            com.byazt.jzl.tt ttVar = this.d;
            if (ttVar != null) {
                ttVar.c(308, i4, "state error");
            }
            for (WeakReference<sp.c> weakReference4 : this.p) {
                if (weakReference4 != null && (cVar = weakReference4.get()) != null) {
                    cVar.onError(this, veVar);
                }
            }
            this.i = true;
        }
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        return this.t == 209;
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        return this.f29073a;
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        return (isReleased() || this.sp == null || !this.sp.z()) ? false : true;
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        return ((this.t != 207 && !this.bx) || this.yp == null || this.yp.hasMessages(100)) ? false : true;
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        return (this.t == 206 || (this.yp != null && this.yp.hasMessages(100))) && !this.bx;
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        return this.t == 205;
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        return this.sl;
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        return isPrepared() || isPlaying() || isPaused();
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (isReleased() || this.yp == null) {
            return;
        }
        this.yp.removeMessages(100);
        this.bx = true;
        if (this.ic) {
            if (!this.f29073a && !c(this.md)) {
                c(new Runnable() { // from class: com.byazt.ts.uj.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uj.this.yp != null) {
                            uj.this.yp.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            } else {
                if (this.yp != null) {
                    this.yp.sendEmptyMessage(101);
                    return;
                }
                return;
            }
        }
        if (!this.qy && !c(this.md)) {
            c(new Runnable() { // from class: com.byazt.ts.uj.16
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.yp != null) {
                        uj.this.yp.sendEmptyMessage(101);
                    }
                }
            });
        } else if (this.yp != null) {
            this.yp.sendEmptyMessage(101);
        }
    }

    @Override // com.byazt.fk.sp
    public void play() {
        if (isReleased() || this.yp == null) {
            return;
        }
        this.zb.set(true);
        this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.15
            @Override // java.lang.Runnable
            public void run() {
                sp.c cVar;
                if (!uj.this.isPaused() || uj.this.sp == null) {
                    return;
                }
                try {
                    uj.this.sp.n();
                    com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : uj.this.p) {
                        if (weakReference != null && (cVar = (sp.c) weakReference.get()) != null) {
                            cVar.onResume(uj.this);
                        }
                    }
                    uj.this.t = 206;
                } catch (Throwable th) {
                    com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void release() {
        if (isReleased()) {
            return;
        }
        this.sl = true;
        t();
        if (this.yp != null) {
            try {
                this.yp.removeCallbacksAndMessages(null);
                if (this.sp != null) {
                    this.yp.sendEmptyMessage(103);
                }
                a();
            } catch (Throwable unused) {
                a();
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        if (cVar == null) {
            return;
        }
        Iterator<WeakReference<sp.c>> it = this.p.iterator();
        while (it.hasNext()) {
            WeakReference<sp.c> next = it.next();
            if (next != null && next.get() == cVar) {
                it.remove();
            }
        }
    }

    @Override // com.byazt.fk.sp
    @SuppressLint({"unused"})
    public void reset() {
        if (isReleased()) {
            return;
        }
        tt(new Runnable() { // from class: com.byazt.ts.uj.18
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.yp != null) {
                    uj.this.yp.sendEmptyMessage(102);
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        if (isReleased() || this.sp == null) {
            return;
        }
        if (this.t != 206) {
            tt();
            this.bx = false;
            this.pf.c(true);
            c(0L);
            if (this.yp != null) {
                this.yp.removeCallbacks(this.nb);
                this.yp.postDelayed(this.nb, this.eo);
            }
        }
        this.zb.set(true);
        if ((this.or.get() || this.cu.get()) && this.yp != null) {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.13
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.sl();
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void seekTo(final long j) {
        if (isReleased()) {
            return;
        }
        if (this.t == 207 || this.t == 206 || this.t == 209) {
            tt(new Runnable() { // from class: com.byazt.ts.uj.4
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.yp != null) {
                        uj.this.yp.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(final u uVar) {
        if (isReleased()) {
            return;
        }
        this.md = uVar;
        if (uVar != null) {
            this.ic = !uVar.isAudio();
        }
        tt(new Runnable() { // from class: com.byazt.ts.uj.7
            @Override // java.lang.Runnable
            public void run() {
                uj.this.ve();
                if (uj.this.yp != null) {
                    uj.this.yp.obtainMessage(107, uVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(final SurfaceHolder surfaceHolder) {
        if (isReleased()) {
            return;
        }
        this.ve = surfaceHolder;
        setSurfaceValid(true);
        tt(new Runnable() { // from class: com.byazt.ts.uj.6
            @Override // java.lang.Runnable
            public void run() {
                uj.this.ve();
                if (uj.this.yp != null) {
                    uj.this.yp.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        if (isReleased()) {
            return;
        }
        this.sp.n(z);
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
        try {
            com.byazt.oy.c cVar = new com.byazt.oy.c();
            cVar.c(f);
            this.sp.c(cVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(final boolean z) {
        if (isReleased()) {
            return;
        }
        if (this.yp == null) {
            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.10
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.isReleased() || uj.this.sp == null) {
                        return;
                    }
                    try {
                        uj.this.h = z;
                        uj.this.sp.uj(z);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
        this.n = i;
    }

    @Override // com.byazt.fk.sp
    public void setSurface(final SurfaceTexture surfaceTexture) {
        if (isReleased()) {
            return;
        }
        this.tt = surfaceTexture;
        setSurfaceValid(true);
        tt(new Runnable() { // from class: com.byazt.ts.uj.5
            @Override // java.lang.Runnable
            public void run() {
                uj.this.ve();
                if (uj.this.yp != null) {
                    uj.this.yp.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(final boolean z) {
        if (isReleased()) {
            return;
        }
        this.yv = z;
        if (this.sp != null) {
            this.sp.c(z);
        } else if (this.yp != null) {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.11
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.sp != null) {
                        uj.this.sp.c(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        if (isReleased()) {
            return;
        }
        this.eo = i;
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, long j, boolean z2) {
        if (isReleased()) {
            return;
        }
        ve();
        this.h = z2;
        this.bx = false;
        setQuietPlay(z2);
        if (z) {
            this.u = j;
            uj();
        } else {
            c(j);
        }
        if (this.yp != null) {
            this.yp.removeCallbacks(this.nb);
            this.yp.postDelayed(this.nb, this.eo);
        }
        this.zb.set(true);
        if ((this.or.get() || this.cu.get()) && this.yp != null) {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.14
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.sl();
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        if (isReleased()) {
            return;
        }
        tt(new Runnable() { // from class: com.byazt.ts.uj.3
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.yp != null) {
                    uj.this.yp.sendEmptyMessage(105);
                }
            }
        });
    }

    private void a() {
        Handler handler = this.yp;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.byazt.ts.uj.8
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.yp == null || uj.this.yp.getLooper() == null) {
                    return;
                }
                try {
                    if (uj.this.z) {
                        uj.this.yp.removeCallbacksAndMessages(null);
                    } else {
                        ((qp) com.byazt.ut.uj.getService("thread_service")).recycleHandler(uj.this.yp);
                    }
                    uj.this.yp = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void da() {
        if (this.da) {
            return;
        }
        this.da = true;
        Iterator it = new ArrayList(this.gu).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.gu.clear();
        this.da = false;
    }

    private void i() {
        if (this.yp != null) {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uj.this.sp.sp();
                        uj.this.t = 207;
                        uj.this.bx = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void n() {
        com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.sp == null) {
            return;
        }
        try {
            this.sp.t();
        } catch (Throwable unused) {
        }
        this.sp.c((ve.tt) null);
        this.sp.c((ve.sp) null);
        this.sp.c((ve.c) null);
        this.sp.c((ve.uj) null);
        this.sp.c((ve.InterfaceC0537ve) null);
        this.sp.c((ve.n) null);
        this.sp.c((ve.a) null);
        try {
            this.sp.sl();
            com.byazt.jzl.tt ttVar = this.d;
            if (ttVar != null) {
                ttVar.c(this.rh, this.md);
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        ArrayList<Runnable> arrayList = this.gu;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        da();
    }

    private void sp() {
        SparseIntArray sparseIntArray = zm;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.gr));
        if (numValueOf == null) {
            sparseIntArray.put(this.gr, 1);
        } else {
            sparseIntArray.put(this.gr, numValueOf.intValue() + 1);
        }
    }

    private void t() {
        ArrayList<Runnable> arrayList = this.gu;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.gu.clear();
    }

    private void x() {
        sp.c cVar;
        c("0506");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.rl;
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onRenderStart(this, jElapsedRealtime);
            }
        }
        this.f29073a = true;
    }

    private void tt() {
        this.nu = 0L;
        this.uj = 0;
        this.my = 0L;
        this.m = false;
        this.rh = Long.MIN_VALUE;
    }

    private void uj() {
        tt(new Runnable() { // from class: com.byazt.ts.uj.2
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.yp != null) {
                    uj.this.yp.sendEmptyMessage(104);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        if (this.yp != null) {
            this.yp.post(new Runnable() { // from class: com.byazt.ts.uj.12
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.sp == null) {
                        try {
                            uj.this.sp = new tt();
                        } catch (Throwable th) {
                            com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (uj.this.sp == null) {
                            return;
                        }
                        ve unused = uj.this.sp;
                        uj.this.sp.c((ve.n) uj.this);
                        uj.this.sp.c((ve.tt) uj.this);
                        uj.this.sp.c((ve.InterfaceC0537ve) uj.this);
                        uj.this.sp.c((ve.c) uj.this);
                        uj.this.sp.c((ve.a) uj.this);
                        uj.this.sp.c((ve.uj) uj.this);
                        uj.this.sp.c((ve.sp) uj.this);
                        try {
                            uj.this.sp.ve(false);
                        } catch (Throwable unused2) {
                        }
                        uj.this.i = false;
                    }
                }
            });
        }
    }

    @Override // com.byazt.ts.ve.a
    public void ve(ve veVar) {
        sp.c cVar;
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onSeekCompletion(this, true);
            }
        }
    }

    private void c(String str) {
        com.byazt.jzl.tt ttVar = this.d;
        if (ttVar != null) {
            ttVar.c(str);
        }
    }

    private void tt(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.sp.c(fileInputStream.getFD());
        fileInputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, long j2) {
        sp.c cVar;
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onPlayPositionUpdate(this, j, j2);
            }
        }
    }

    @Override // com.byazt.ts.ve.uj
    public boolean tt(ve veVar, int i, int i2) {
        sp.c cVar;
        com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.sp != veVar) {
            return false;
        }
        if (i2 == -1004) {
            com.byazt.jzl.ve veVar2 = new com.byazt.jzl.ve(i, i2);
            c("0510");
            com.byazt.jzl.tt ttVar = this.d;
            if (ttVar != null) {
                ttVar.c(i, i2, "");
            }
            for (WeakReference<sp.c> weakReference : this.p) {
                if (weakReference != null && (cVar = weakReference.get()) != null) {
                    cVar.onError(this, veVar2);
                }
            }
        }
        tt(i, i2);
        return false;
    }

    private void c(String str, Looper looper) {
        this.gr = 0;
        if (looper != null) {
            this.z = true;
            this.yp = new d(looper, this);
        } else if (this.yp == null) {
            this.yp = ((qp) com.byazt.ut.uj.getService("thread_service")).obtainHandler(this, "csj_" + str);
        }
        ve();
    }

    private void c(long j) {
        this.pf.c(j);
        if (this.yv) {
            tt(this.pf);
        } else if (c(this.md)) {
            tt(this.pf);
        } else {
            c(this.pf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i, int i2) {
        sp.c cVar;
        sp.c cVar2;
        if (i == 701) {
            this.sv = SystemClock.elapsedRealtime();
            this.uj++;
            for (WeakReference<sp.c> weakReference : this.p) {
                if (weakReference != null && (cVar2 = weakReference.get()) != null) {
                    cVar2.onBufferStart(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.uj));
            return;
        }
        if (i == 702) {
            if (this.sv > 0) {
                this.aw += SystemClock.elapsedRealtime() - this.sv;
                this.sv = 0L;
            }
            for (WeakReference<sp.c> weakReference2 : this.p) {
                if (weakReference2 != null && (cVar = weakReference2.get()) != null) {
                    cVar.onBufferEnd(this, Integer.MAX_VALUE);
                }
            }
            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.uj), " mBufferTotalTime = ", Long.valueOf(this.aw));
            return;
        }
        if (this.ic && i == 3) {
            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.bx);
            sl();
            x();
            setQuietPlay(this.h);
            com.byazt.lt.tt.c("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    private boolean c(u uVar) {
        return uVar != null && uVar.isAudio();
    }

    public int c() {
        if (isReleased()) {
            return 203;
        }
        return this.t;
    }

    @Override // com.byazt.ts.ve.c
    public void c(ve veVar, int i) {
        sp.c cVar;
        if (this.sp != veVar) {
            return;
        }
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onBufferingUpdate(this, i);
            }
        }
    }

    @Override // com.byazt.ts.ve.tt
    public void c(ve veVar) {
        sp.c cVar;
        this.t = 209;
        zm.delete(this.gr);
        if (this.yp != null) {
            this.yp.removeCallbacks(this.nb);
        }
        c("0509");
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onCompletion(this);
            }
        }
    }

    @Override // com.byazt.ts.ve.InterfaceC0537ve
    public boolean c(ve veVar, int i, int i2) {
        sp.c cVar;
        com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "what=" + i + " extra=" + i2);
        sp();
        this.t = 200;
        if (this.yp != null) {
            this.yp.removeCallbacks(this.nb);
        }
        if (c(i, i2)) {
            a();
        }
        if (!this.zb.get()) {
            return true;
        }
        this.zb.set(false);
        com.byazt.jzl.ve veVar2 = new com.byazt.jzl.ve(i, i2);
        c("0510");
        com.byazt.jzl.tt ttVar = this.d;
        if (ttVar != null) {
            ttVar.c(i, i2, "");
        }
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onError(this, veVar2);
            }
        }
        return true;
    }

    @Override // com.byazt.ts.ve.n
    public void tt(ve veVar) {
        sp.c cVar;
        if (isReleased()) {
            return;
        }
        this.t = 205;
        try {
            u uVar = this.md;
            if (uVar != null) {
                float playSpeedRatio = uVar.getPlaySpeedRatio();
                if (playSpeedRatio > 0.0f) {
                    com.byazt.oy.c cVar2 = new com.byazt.oy.c();
                    cVar2.c(playSpeedRatio);
                    this.sp.c(cVar2);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.yp != null) {
            if (this.bx) {
                i();
            } else {
                com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.yp.sendMessage(this.yp.obtainMessage(100, -1, -1));
            }
        }
        zm.delete(this.gr);
        com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", "onPrepared:" + this.ic + " " + this.qy);
        if (!this.ic && !this.qy) {
            x();
            this.qy = true;
        }
        c("0504");
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onPrepared(this);
            }
        }
    }

    private void c(Runnable runnable) {
        try {
            if (this.gu == null) {
                this.gu = new ArrayList<>();
            }
            this.gu.add(runnable);
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    @Override // com.byazt.ts.ve.sp
    public void c(ve veVar, int i, int i2, int i3, int i4) {
        sp.c cVar;
        for (WeakReference<sp.c> weakReference : this.p) {
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.onVideoSizeChanged(this, i, i2);
            }
        }
    }

    private void tt(Runnable runnable) {
        if (runnable == null || isReleased()) {
            return;
        }
        if (!this.sl) {
            runnable.run();
        } else {
            c(runnable);
        }
    }
}
