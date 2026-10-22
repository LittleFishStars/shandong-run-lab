package com.byazt.kft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.byazt.fk.sp;
import com.byazt.fk.u;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.ga.i;
import com.byazt.ga.uj;
import com.byazt.jzl.a;
import com.byazt.jzl.ve;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 20})
public class c implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.jr.tt f28727a;
    public long d;
    public LottieAnimationView da;
    public boolean gr;
    public boolean gt;
    public boolean gu;
    public int h;
    public String i;
    public final sp m;
    public final int n;
    public ViewTreeObserverOnGlobalLayoutListenerC0452c nb;
    public boolean nu;
    public boolean p;
    public boolean qy;
    public sp.c rh;
    public boolean rl;
    public Bitmap sl;
    public final Context sp;
    public final String tt;
    public final int uj;
    public final long ve;
    public final com.byazt.jzl.tt x;
    public final String yp;
    public boolean yv;
    public final JSONObject z;
    public boolean zb;
    public boolean zm;
    public final String c = "TTLottieFakeVideoPlayer";
    public final Map<String, Bitmap> t = new HashMap();
    public final Map<String, Integer> u = new HashMap();
    public final Set<sp.c> my = new HashSet();
    public volatile int md = 200;
    public float eo = 1.0f;
    public int or = 0;
    public int cu = 0;
    public final Handler pf = new Handler(Looper.getMainLooper());
    public final Runnable bx = new Runnable() { // from class: com.byazt.kft.c.5
        @Override // java.lang.Runnable
        public void run() {
            for (sp.c cVar : c.this.my) {
                c cVar2 = c.this;
                cVar.onPlayPositionUpdate(cVar2, cVar2.h, c.this.getVideoDuration());
            }
            m.c("TTLottieFakeVideoPlayer", "--==--play curr: " + c.this.h);
            if (c.this.h < c.this.getVideoDuration()) {
                c.this.h += c.this.md;
                c.this.pf.postDelayed(c.this.bx, c.this.md);
                return;
            }
            if (c.this.da != null) {
                c.this.da.a();
            }
            if (c.this.qy && !c.this.gr && c.this.m != null && c.this.m.isPlaying()) {
                c.this.m.pause();
            }
            c.this.rl = false;
            c.this.gu = true;
            c.this.a();
            Iterator it = c.this.my.iterator();
            while (it.hasNext()) {
                ((sp.c) it.next()).onCompletion(c.this);
            }
        }
    };
    public long qp = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: com.byazt.kft.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 44})
    public class ViewTreeObserverOnGlobalLayoutListenerC0452c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final ViewGroup tt;
        public int ve;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.tt.getWidth();
            int height = this.tt.getHeight();
            this.tt.removeAllViews();
            int i = this.ve;
            this.ve = i - 1;
            if (i < 0) {
                this.tt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.tt.addView(c.this.da);
            } else {
                this.tt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = width;
                float f2 = height;
                float f3 = f / f2;
                float f4 = c.this.n > 0 ? c.this.uj / c.this.n : f3;
                if (f4 <= 0.0f || f4 < f3) {
                    width = (int) (f2 * f4);
                } else {
                    height = (int) (f / f4);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.tt.addView(c.this.da, layoutParams);
            }
            if (!c.this.gt || c.this.da.n()) {
                return;
            }
            c.this.da.c();
        }

        private ViewTreeObserverOnGlobalLayoutListenerC0452c(ViewGroup viewGroup) {
            this.ve = 10;
            this.tt = viewGroup;
        }
    }

    public c(com.byazt.jr.tt ttVar, com.byazt.cph.c cVar, sp spVar, a aVar, com.byazt.jzl.tt ttVar2) {
        this.sp = ttVar.getView().getContext();
        this.f28727a = ttVar;
        this.x = ttVar2;
        this.ve = cVar.a();
        this.uj = cVar.uj();
        this.n = cVar.n();
        String strVe = cVar.ve();
        this.yp = strVe;
        String strC = cVar.c();
        this.tt = strC;
        String strTt = cVar.tt();
        this.z = cVar.sp();
        c(strC);
        tt(strVe);
        this.m = spVar;
        c(strTt, aVar);
    }

    public static /* synthetic */ int gu(c cVar) {
        int i = cVar.cu;
        cVar.cu = i + 1;
        return i;
    }

    public static /* synthetic */ int zm(c cVar) {
        int i = cVar.or;
        cVar.or = i + 1;
        return i;
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(sp.c cVar) {
        this.my.add(cVar);
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        m.c("TTLottieFakeVideoPlayer", "--==--getBufferCount: 1");
        return 1;
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        return "";
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        m.c("TTLottieFakeVideoPlayer", "--==--getCurrentPosition: " + this.h);
        return this.h;
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        if (!this.qy) {
            m.c("TTLottieFakeVideoPlayer", "--==--is not prepared, getTotalBufferTime: 0");
            return 0L;
        }
        m.c("TTLottieFakeVideoPlayer", "--==--getTotalBufferTime: " + this.qp);
        return this.qp;
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        return this.md;
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        return this.ve;
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        m.c("TTLottieFakeVideoPlayer", "--==--getVideoHeight: " + this.n);
        return this.n;
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        m.c("TTLottieFakeVideoPlayer", "--==--getVideoWidth: " + this.uj);
        return this.uj;
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        m.c("TTLottieFakeVideoPlayer", "--==--isCompleted: " + this.gu);
        return this.gu;
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        m.c("TTLottieFakeVideoPlayer", "--==--isFirstFrameSuccess: " + this.qy);
        return this.qy;
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        return this.zm;
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        boolean z = (this.rl || this.gu || this.gr || !this.qy) ? false : true;
        m.c("TTLottieFakeVideoPlayer", "--==--isPaused: ".concat(String.valueOf(z)));
        return z;
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        m.c("TTLottieFakeVideoPlayer", "--==--isPlaying: " + this.rl);
        return this.rl;
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        m.c("TTLottieFakeVideoPlayer", "--==--isPrepared: " + this.qy);
        return this.qy;
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        m.c("TTLottieFakeVideoPlayer", "--==--isReleased: " + this.gr);
        return this.gr;
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        m.c("TTLottieFakeVideoPlayer", "--==--isStarted: " + this.gt);
        return this.gt;
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        x();
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = c.this.my.iterator();
                while (it.hasNext()) {
                    ((sp.c) it.next()).onPause(c.this);
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void play() {
        sp();
        if (this.h > 0) {
            com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = c.this.my.iterator();
                    while (it.hasNext()) {
                        ((sp.c) it.next()).onResume(c.this);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fk.sp
    public void release() {
        m.c("TTLottieFakeVideoPlayer", "--==--release");
        this.gr = true;
        a();
        this.t.clear();
        this.sl = null;
        sp spVar = this.m;
        if (spVar != null) {
            if (this.qy) {
                spVar.stop();
            }
            this.m.release();
        }
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.8
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) c.this.f28727a.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(c.this.nb);
                }
                Iterator it = c.this.my.iterator();
                while (it.hasNext()) {
                    ((sp.c) it.next()).onRelease(c.this);
                }
            }
        });
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        this.my.remove(cVar);
    }

    @Override // com.byazt.fk.sp
    public void reset() {
        sp spVar;
        m.c("TTLottieFakeVideoPlayer", "--==--reset");
        this.h = 0;
        a();
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.da.setProgress(0.0f);
        }
        if (!this.qy || this.gr || (spVar = this.m) == null) {
            return;
        }
        if (spVar.isPlaying()) {
            this.m.pause();
        }
        this.m.seekTo(0L);
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        m.c("TTLottieFakeVideoPlayer", "--==--reStart");
        a();
        this.h = 0;
        this.qy = true;
        this.gu = false;
        this.gr = false;
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.da.setProgress(0.0f);
        }
        play();
    }

    @Override // com.byazt.fk.sp
    public void seekTo(long j) {
        m.c("TTLottieFakeVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.h = (int) j;
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = getVideoDuration();
            }
            if (duration > 0) {
                this.da.setProgress((j % duration) / duration);
            }
        }
        sp spVar = this.m;
        if (spVar != null && spVar.getVideoDuration() > 0) {
            this.m.seekTo((int) (j % this.m.getVideoDuration()));
        }
        c(true);
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(u uVar) {
        m.c("TTLottieFakeVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(uVar)));
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(SurfaceHolder surfaceHolder) {
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        m.c("TTLottieFakeVideoPlayer", "--==--setLoop:".concat(String.valueOf(z)));
        this.zm = z;
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
        this.eo = f;
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(boolean z) {
        m.c("TTLottieFakeVideoPlayer", "--==--setQuietPlay: ".concat(String.valueOf(z)));
        this.zb = z;
        sp spVar = this.m;
        if (spVar != null) {
            spVar.setQuietPlay(z);
        }
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
        m.c("TTLottieFakeVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
    }

    @Override // com.byazt.fk.sp
    public void setSurface(SurfaceTexture surfaceTexture) {
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(boolean z) {
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        this.md = i;
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, long j, boolean z2) {
        m.c("TTLottieFakeVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.zb = z2;
        this.gt = true;
        this.d = j;
        this.m.start(z, j, z2);
        if (this.qy) {
            this.m.setQuietPlay(z2);
            this.m.setLoop(true);
            if (j > 0) {
                c(j);
            } else {
                play();
            }
        }
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        sp spVar;
        m.c("TTLottieFakeVideoPlayer", "--==--stop");
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.gt = false;
        }
        if (this.qy && !this.gr && (spVar = this.m) != null && spVar.isPlaying()) {
            this.m.pause();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp() {
        sp spVar;
        m.c("TTLottieFakeVideoPlayer", "--==--play");
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null && this.qy && !lottieAnimationView.n()) {
            m.c("TTLottieFakeVideoPlayer", "--==--play --- enter");
            if (this.h > 0) {
                this.da.tt();
            } else {
                this.da.c();
            }
        }
        if (this.qy && !this.gr && (spVar = this.m) != null && !spVar.isPlaying()) {
            m.c("TTLottieFakeVideoPlayer", "--==--audio play --- enter");
            if (this.h > 0) {
                this.m.play();
            } else {
                this.m.seekTo(0L);
                this.m.play();
            }
        }
        this.rl = true;
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        sp spVar;
        m.c("TTLottieFakeVideoPlayer", "--==--pause");
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null && this.qy && lottieAnimationView.n()) {
            m.c("TTLottieFakeVideoPlayer", "--==--pause --- enter");
            this.da.sp();
        }
        if (this.qy && !this.gr && (spVar = this.m) != null && spVar.isPlaying()) {
            m.c("TTLottieFakeVideoPlayer", "--==--audio pause --- enter");
            this.m.pause();
        }
        this.rl = false;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.pf.removeCallbacksAndMessages(null);
    }

    private void n() {
        this.pf.removeCallbacksAndMessages(null);
        this.pf.post(this.bx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.2
            @Override // java.lang.Runnable
            public void run() {
                m.c("TTLottieFakeVideoPlayer", "--==--audio buffering end");
                c.this.p = false;
                if (c.this.isPaused()) {
                    c.this.sp();
                }
                Iterator it = c.this.my.iterator();
                while (it.hasNext()) {
                    ((sp.c) it.next()).onBufferEnd(c.this, -1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.15
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.p) {
                    m.c("TTLottieFakeVideoPlayer", "--==--audio buffering start");
                    if (c.this.isPlaying()) {
                        c.this.x();
                    }
                    Iterator it = c.this.my.iterator();
                    while (it.hasNext()) {
                        ((sp.c) it.next()).onBufferStart(c.this, -1, -1, -1);
                    }
                }
                c.this.p = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.sl == null || c.this.i == null || !c.this.nu || c.this.da != null) {
                    return;
                }
                c.this.da = new LottieAnimationView(c.this.sp);
                c.this.da.setVideoStats(c.this.x);
                c.this.da.setRepeatCount(-1);
                c.this.da.setSpeed(c.this.eo);
                c.this.da.setImageAssetDelegate(new uj() { // from class: com.byazt.kft.c.9.1
                    @Override // com.byazt.ga.uj
                    public Bitmap c(i iVar) {
                        if (iVar != null) {
                            String strU = iVar.u();
                            if (!TextUtils.isEmpty(strU)) {
                                if (strU.startsWith("${") && strU.endsWith("}")) {
                                    strU = com.byazt.qk.c.c(strU, c.this.z);
                                    if (TextUtils.isEmpty(strU)) {
                                        return null;
                                    }
                                    if (!strU.startsWith("http") || TextUtils.equals(strU, c.this.yp)) {
                                        Bitmap bitmap = c.this.sl;
                                        if (bitmap != null && (bitmap.getWidth() != iVar.c() || bitmap.getHeight() != iVar.tt())) {
                                            c.this.sl = Bitmap.createScaledBitmap(bitmap, iVar.c(), iVar.tt(), false);
                                        }
                                        return c.this.sl;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) c.this.t.get(strU);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                c.this.c(strU, iVar.c(), iVar.tt());
                            }
                        }
                        return null;
                    }
                });
                c.this.da.setTextDelegate(new gt(c.this.da) { // from class: com.byazt.kft.c.9.2
                    @Override // com.byazt.ga.gt
                    public String c(String str) {
                        return com.byazt.qk.c.c(str, c.this.z != null ? c.this.z : null);
                    }
                });
                c.this.da.c(c.this.i, c.this.tt);
                c.this.c();
                c.this.qy = true;
                m.c("TTLottieFakeVideoPlayer", "--==--onPrepared");
                c.this.qp = SystemClock.elapsedRealtime() - c.this.qp;
                for (sp.c cVar : c.this.my) {
                    cVar.onPrepared(c.this);
                    c cVar2 = c.this;
                    cVar.onVideoSizeChanged(cVar2, cVar2.uj, c.this.n);
                }
                if (c.this.gt) {
                    c.this.m.setQuietPlay(c.this.zb);
                    c.this.m.setLoop(true);
                    if (c.this.d > 0) {
                        c cVar3 = c.this;
                        cVar3.c(cVar3.d);
                    } else {
                        c.this.play();
                    }
                }
                for (sp.c cVar4 : c.this.my) {
                    c cVar5 = c.this;
                    cVar4.onRenderStart(cVar5, cVar5.qp);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final String str) {
        if (TextUtils.isEmpty(str)) {
            c(new ve(60008, 10002, "广告主图url为空"));
        } else {
            com.byazt.cph.tt.c().tt(str, new com.byazt.cph.tt.c<Bitmap>() { // from class: com.byazt.kft.c.11
                @Override // com.byazt.cph.tt.c
                public void c(Bitmap bitmap) {
                    c.this.sl = bitmap;
                    c.this.tt();
                }

                @Override // com.byazt.cph.tt.c
                public void c(int i, String str2) {
                    c.zm(c.this);
                    if (c.this.or <= 3) {
                        c.this.tt(str);
                    } else {
                        c.this.c(new ve(60008, 10003, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final ViewGroup viewGroup = (ViewGroup) this.f28727a.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.da);
        this.nb = new ViewTreeObserverOnGlobalLayoutListenerC0452c(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.nb);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.kft.c.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(c.this.nb);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            c(new ve(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.qk.tt.ve(new Runnable() { // from class: com.byazt.kft.c.10
                @Override // java.lang.Runnable
                public void run() {
                    String strC = com.byazt.cph.tt.c().c(str);
                    if (TextUtils.isEmpty(strC)) {
                        com.byazt.cph.tt.c().c(str, new com.byazt.cph.tt.c<String>() { // from class: com.byazt.kft.c.10.1
                            @Override // com.byazt.cph.tt.c
                            public void c(String str2) {
                                m.c("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr ok");
                                c.this.i = str2;
                                c.this.tt();
                            }

                            @Override // com.byazt.cph.tt.c
                            public void c(int i, String str2) {
                                m.c("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    c.this.c(new ve(60008, i, str2));
                                    return;
                                }
                                c.gu(c.this);
                                if (c.this.cu <= 3) {
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    c.this.c(str);
                                } else {
                                    c.this.c(new ve(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        c.this.i = strC;
                        c.this.tt();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final int i, final int i2) {
        Integer num = this.u.get(str);
        if (num == null || num.intValue() != 1) {
            this.u.put(str, 1);
            this.da.c(str, new com.byazt.rs.i() { // from class: com.byazt.kft.c.12
                @Override // com.byazt.rs.i
                public void c(Bitmap bitmap) {
                    c.this.c(bitmap, str, i, i2);
                }

                @Override // com.byazt.rs.i
                public void c() {
                    com.byazt.cph.tt.c().c(c.this.sp, str, new com.byazt.cph.tt.c<Bitmap>() { // from class: com.byazt.kft.c.12.1
                        @Override // com.byazt.cph.tt.c
                        public void c(Bitmap bitmap) {
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            c.this.c(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.cph.tt.c
                        public void c(int i3, String str2) {
                            c.this.u.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            }
            this.t.put(str, bitmap);
            com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.c.13
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.da != null) {
                        c.this.da.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ve veVar) {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.14
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.yv) {
                    m.c("TTLottieFakeVideoPlayer", "--==--play err, code: " + veVar.getCode() + ", extra: " + veVar.getExtraCode() + ", msg: " + veVar.getMsg());
                    Iterator it = c.this.my.iterator();
                    while (it.hasNext()) {
                        ((sp.c) it.next()).onError(c.this, veVar);
                    }
                }
                c.this.yv = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i) {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.16
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = c.this.my.iterator();
                while (it.hasNext()) {
                    ((sp.c) it.next()).onBufferingUpdate(c.this, i);
                }
            }
        });
    }

    private void c(final boolean z) {
        com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.kft.c.3
            @Override // java.lang.Runnable
            public void run() {
                m.c("TTLottieFakeVideoPlayer", "--==--seek completed");
                Iterator it = c.this.my.iterator();
                while (it.hasNext()) {
                    ((sp.c) it.next()).onSeekCompletion(c.this, z);
                }
            }
        });
    }

    private void c(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            c(new ve(60008, 10004, "lottie音频url为空"));
            return;
        }
        sp.c cVar = new sp.c() { // from class: com.byazt.kft.c.4
            @Override // com.byazt.fk.sp.c
            public void onBufferEnd(sp spVar, int i) {
                c.this.uj();
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferStart(sp spVar, int i, int i2, int i3) {
                c.this.ve();
            }

            @Override // com.byazt.fk.sp.c
            public void onBufferingUpdate(sp spVar, int i) {
                c.this.c(i);
            }

            @Override // com.byazt.fk.sp.c
            public void onCompletion(sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onError(sp spVar, com.byazt.fk.ve veVar) {
                int code;
                String msg;
                int extraCode;
                if (veVar != null) {
                    code = veVar.getCode();
                    extraCode = veVar.getExtraCode();
                    msg = veVar.getMsg();
                } else {
                    code = -1;
                    msg = "";
                    extraCode = -1;
                }
                c.this.c(new ve(code, extraCode, "lottie音频播放失败:".concat(String.valueOf(msg))));
            }

            @Override // com.byazt.fk.sp.c
            public void onMonitorLog(sp spVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPause(sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPlayPositionUpdate(sp spVar, long j, long j2) {
            }

            @Override // com.byazt.fk.sp.c
            public void onPrepared(sp spVar) {
                c.this.nu = true;
                c.this.tt();
            }

            @Override // com.byazt.fk.sp.c
            public void onRelease(sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onRenderStart(sp spVar, long j) {
            }

            @Override // com.byazt.fk.sp.c
            public void onResume(sp spVar) {
            }

            @Override // com.byazt.fk.sp.c
            public void onSeekCompletion(sp spVar, boolean z) {
            }

            @Override // com.byazt.fk.sp.c
            public void onStart(sp spVar) {
                for (sp.c cVar2 : c.this.my) {
                    if (cVar2 != null) {
                        cVar2.onStart(c.this);
                    }
                }
            }

            @Override // com.byazt.fk.sp.c
            public void onVideoSizeChanged(sp spVar, int i, int i2) {
            }
        };
        this.rh = cVar;
        this.m.addIVideoPlayerCallback(cVar);
        this.m.setDataSource(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        LottieAnimationView lottieAnimationView = this.da;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
        }
        seekTo(j);
        sp spVar = this.m;
        if (spVar != null) {
            spVar.play();
        }
        this.rl = true;
        n();
    }
}
