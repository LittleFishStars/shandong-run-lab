package com.alibaba.triver.embed.video.fullscreenvideo;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class TBMiniAppVideo extends FrameLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static boolean A = true;
    public static int B = 4;
    public static int C = 1;
    public static boolean D = true;
    public static boolean E = false;
    public static int F = 0;
    public static long G = 0;
    public static long H = 0;
    protected static e J = null;
    protected static Timer K = null;
    public static final String g = "JiaoZiVideoPlayer";
    public static final int h = 80;
    public static final int i = 300;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 5;
    public static final int s = 6;
    public static final int t = 7;
    public static final int u = 8;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static boolean z = true;
    public int L;
    public int M;
    public long N;
    public ImageView O;
    public SeekBar P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public ViewGroup T;
    public ViewGroup U;
    public ViewGroup V;
    public int W;
    public int aa;
    public com.alibaba.triver.embed.video.fullscreenvideo.a ab;
    public int ac;
    public int ad;
    protected int ae;
    protected int af;
    protected AudioManager ag;
    protected b ah;
    protected boolean ai;
    protected float aj;
    protected float ak;
    protected boolean al;
    protected boolean am;
    protected boolean an;
    protected long ao;
    protected int ap;
    protected float aq;
    protected long ar;
    boolean as;
    public static AudioManager.OnAudioFocusChangeListener I = new AudioManager.OnAudioFocusChangeListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (i2 != -2) {
                if (i2 != -1) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TBMiniAppVideo.s();
                    }
                });
                RVLogger.d("JiaoZiVideoPlayer", "AUDIOFOCUS_LOSS [" + hashCode() + "]");
                return;
            }
            try {
                TBMiniAppVideo tBMiniAppVideoC = h.c();
                if (tBMiniAppVideoC != null && tBMiniAppVideoC.L == 3) {
                    tBMiniAppVideoC.O.performClick();
                }
            } catch (IllegalStateException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
            RVLogger.d("JiaoZiVideoPlayer", "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]");
        }
    };
    public static int at = 0;

    public static class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if ((f < -12.0f || f > 12.0f) && System.currentTimeMillis() - TBMiniAppVideo.H > 2000) {
                if (h.c() != null) {
                    h.c().a(f);
                }
                TBMiniAppVideo.H = System.currentTimeMillis();
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            TBMiniAppVideo tBMiniAppVideo = TBMiniAppVideo.this;
            int i = tBMiniAppVideo.L;
            if (i == 3 || i == 5) {
                tBMiniAppVideo.post(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentPositionWhenPlaying = TBMiniAppVideo.this.getCurrentPositionWhenPlaying();
                        long duration = TBMiniAppVideo.this.getDuration();
                        long j = c.j();
                        int i2 = (int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration));
                        TBMiniAppVideo.this.a(currentPositionWhenPlaying / 1000, duration / 1000, j / 1000);
                        TBMiniAppVideo.this.a(i2, currentPositionWhenPlaying, duration);
                    }
                });
            }
        }
    }

    public TBMiniAppVideo(Context context) {
        super(context);
        this.L = -1;
        this.M = -1;
        this.N = 0L;
        this.W = 0;
        this.aa = 0;
        this.ac = -1;
        this.ad = 0;
        this.as = false;
        a(context);
    }

    public static void a(Context context, Class cls, String str, String str2) {
        a(context, cls, new com.alibaba.triver.embed.video.fullscreenvideo.a(str, str2));
    }

    @SuppressLint({"RestrictedApi"})
    public static void b(Context context) {
        ActionBar supportActionBar;
        if (z && g.c(context) != null && (supportActionBar = g.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (A) {
            g.d(context).clearFlags(1024);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static void c(Context context) {
        ActionBar supportActionBar;
        if (z && g.c(context) != null && (supportActionBar = g.c(context).getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (A) {
            g.d(context).setFlags(1024, 1024);
        }
    }

    public static void s() {
        if (System.currentTimeMillis() - G > 300) {
            RVLogger.d("JiaoZiVideoPlayer", "releaseAllVideos");
            h.d();
            c.a().h = -1;
            c.a().k();
        }
    }

    public static void setJzUserAction(e eVar) {
        J = eVar;
    }

    public static void setMediaInterface(com.alibaba.triver.embed.video.fullscreenvideo.b bVar) {
        c.a().i = bVar;
    }

    public static void setTextureViewRotation(int i2) {
        TBMiniAppTextureView tBMiniAppTextureView = c.d;
        if (tBMiniAppTextureView != null) {
            tBMiniAppTextureView.setRotation(i2);
        }
    }

    public static void setVideoImageDisplayType(int i2) {
        F = i2;
        TBMiniAppTextureView tBMiniAppTextureView = c.d;
        if (tBMiniAppTextureView != null) {
            tBMiniAppTextureView.requestLayout();
        }
    }

    public static void t() {
        RVLogger.d("JiaoZiVideoPlayer", "releaseAllVideos2");
        h.d();
        c.a().h = -1;
        c.a().k();
    }

    public static boolean u() {
        RVLogger.d("JiaoZiVideoPlayer", "backPress");
        if (System.currentTimeMillis() - G < 300) {
            return false;
        }
        if (h.b() != null) {
            G = System.currentTimeMillis();
            if (h.a().ab.a(c.b().a())) {
                TBMiniAppVideo tBMiniAppVideoB = h.b();
                tBMiniAppVideoB.a(tBMiniAppVideoB.M == 2 ? 8 : 10);
                h.a().P();
            } else {
                v();
            }
            return true;
        }
        if (h.a() == null || !(h.a().M == 2 || h.a().M == 3)) {
            return false;
        }
        G = System.currentTimeMillis();
        v();
        return true;
    }

    public static void v() {
        if (h.a() != null) {
            h.a().I();
            c.a().k();
            h.d();
        }
        try {
            ((MyTBMiniAppVideoStd) h.c()).ab();
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    public static void w() {
        if (h.c() != null) {
            TBMiniAppVideo tBMiniAppVideoC = h.c();
            if (tBMiniAppVideoC.L == 5) {
                if (at == 5) {
                    tBMiniAppVideoC.e();
                    c.g();
                } else {
                    tBMiniAppVideoC.d();
                    c.h();
                }
                at = 0;
            }
        }
    }

    public static void x() {
        TBMiniAppVideo tBMiniAppVideoC;
        int i2;
        if (h.c() == null || (i2 = (tBMiniAppVideoC = h.c()).L) == 6 || i2 == 0 || i2 == 7) {
            return;
        }
        at = i2;
        tBMiniAppVideoC.e();
        c.g();
    }

    public void A() {
        RVLogger.d("JiaoZiVideoPlayer", "onStateStop  [" + hashCode() + "] ");
        this.L = 8;
        L();
        this.P.setProgress(0);
        this.R.setText("0");
    }

    public void B() {
        Runtime.getRuntime().gc();
        RVLogger.d("JiaoZiVideoPlayer", "onAutoCompletion  [" + hashCode() + "] ");
        a(6);
        U();
        T();
        V();
        g();
        int i2 = this.M;
        if (i2 == 2 || i2 == 3) {
            u();
        }
        c.a().k();
        g.a(getContext(), this.ab.a(), 0L);
    }

    public void C() {
        RVLogger.d("JiaoZiVideoPlayer", "onCompletion  [" + hashCode() + "] ");
        int i2 = this.L;
        if (i2 == 3 || i2 == 5) {
            g.a(getContext(), this.ab.a(), getCurrentPositionWhenPlaying());
        }
        L();
        V();
        T();
        U();
        b();
        this.T.removeView(c.d);
        c.a().j = 0;
        c.a().k = 0;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(I);
        g.b(getContext()).getWindow().clearFlags(128);
        H();
        g.a(getContext(), C);
        Surface surface = c.f;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = c.e;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        c.d = null;
        c.e = null;
    }

    public void D() {
        try {
            if (this.ab.a() != null && this.ab.a().equals(c.c()) && System.currentTimeMillis() - G > 300) {
                if (h.b() != null && h.b().M == 2) {
                    t();
                } else if (h.b() != null || h.a() == null || h.a().M != 2) {
                    RVLogger.d("JiaoZiVideoPlayer", "releaseMediaPlayer [" + hashCode() + "]");
                    s();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void E() {
        G();
        TBMiniAppTextureView tBMiniAppTextureView = new TBMiniAppTextureView(getContext());
        c.d = tBMiniAppTextureView;
        tBMiniAppTextureView.setSurfaceTextureListener(c.a());
    }

    public void F() {
        RVLogger.d("JiaoZiVideoPlayer", "addTextureView [" + hashCode() + "] ");
        this.T.addView(c.d, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void G() {
        c.e = null;
        TBMiniAppTextureView tBMiniAppTextureView = c.d;
        if (tBMiniAppTextureView == null || tBMiniAppTextureView.getParent() == null) {
            return;
        }
        ((ViewGroup) c.d.getParent()).removeView(c.d);
    }

    public void H() {
        ViewGroup viewGroup = (ViewGroup) g.b(getContext()).findViewById(R.id.content);
        View viewFindViewById = viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
        View viewFindViewById2 = viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_tiny_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
        b(getContext());
    }

    public void I() {
        g.a(getContext(), C);
        b(getContext());
        ViewGroup viewGroup = (ViewGroup) g.b(getContext()).findViewById(R.id.content);
        TBMiniAppVideo tBMiniAppVideo = (TBMiniAppVideo) viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
        TBMiniAppVideo tBMiniAppVideo2 = (TBMiniAppVideo) viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_tiny_id);
        if (tBMiniAppVideo != null) {
            viewGroup.removeView(tBMiniAppVideo);
            ViewGroup viewGroup2 = tBMiniAppVideo.T;
            if (viewGroup2 != null) {
                viewGroup2.removeView(c.d);
            }
        }
        if (tBMiniAppVideo2 != null) {
            viewGroup.removeView(tBMiniAppVideo2);
            ViewGroup viewGroup3 = tBMiniAppVideo2.T;
            if (viewGroup3 != null) {
                viewGroup3.removeView(c.d);
            }
        }
        h.b(null);
    }

    public void J() {
        RVLogger.d("JiaoZiVideoPlayer", "onVideoSizeChanged  [" + hashCode() + "] ");
        TBMiniAppTextureView tBMiniAppTextureView = c.d;
        if (tBMiniAppTextureView != null) {
            int i2 = this.ad;
            if (i2 != 0) {
                tBMiniAppTextureView.setRotation(i2);
            }
            c.d.a(c.a().j, c.a().k);
        }
    }

    public void K() {
        RVLogger.d("JiaoZiVideoPlayer", "startProgressTimer:  [" + hashCode() + "] ");
        L();
        K = new Timer();
        b bVar = new b();
        this.ah = bVar;
        K.schedule(bVar, 0L, 300L);
    }

    public void L() {
        Timer timer = K;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.ah;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void M() {
        this.P.setProgress(0);
        this.P.setSecondaryProgress(0);
        this.R.setText(g.a(0L));
        this.S.setText(g.a(0L));
    }

    public boolean N() {
        return O() && this.ab.a(c.c());
    }

    public boolean O() {
        return h.c() != null && h.c() == this;
    }

    public void P() {
        RVLogger.d("JiaoZiVideoPlayer", "playOnThisJzvd  [" + hashCode() + "] ");
        this.L = h.b().L;
        I();
        setState(this.L);
        F();
    }

    public void Q() {
        if (System.currentTimeMillis() - H > 2000 && N() && this.L == 3 && this.M == 2) {
            H = System.currentTimeMillis();
            u();
        }
    }

    public void R() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.c() != null) {
                    h.c().R();
                }
            }
        });
    }

    public void S() {
    }

    public void T() {
    }

    public void U() {
    }

    public void V() {
    }

    public void a(float f, int i2) {
    }

    public void a(float f, String str, long j2, String str2, long j3) {
    }

    public void a(long j2, long j3, long j4) {
    }

    public void c(int i2) {
    }

    public void d() {
        RVLogger.d("JiaoZiVideoPlayer", "onStatePlaying  [" + hashCode() + "] ");
        this.L = 3;
        K();
    }

    public void e() {
        RVLogger.d("JiaoZiVideoPlayer", "onStatePause  [" + hashCode() + "] ");
        this.L = 5;
        K();
    }

    public void f() {
        RVLogger.d("JiaoZiVideoPlayer", "onStateError  [" + hashCode() + "] ");
        this.L = 7;
        L();
    }

    public void g() {
        RVLogger.d("JiaoZiVideoPlayer", "onStateAutoComplete  [" + hashCode() + "] ");
        this.L = 6;
        L();
        this.P.setProgress(100);
        this.R.setText(this.S.getText());
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.L;
        if (i2 != 3 && i2 != 5) {
            return 0L;
        }
        try {
            return c.d();
        } catch (IllegalStateException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return 0L;
        }
    }

    public Object getCurrentUrl() {
        return this.ab.a();
    }

    public long getDuration() {
        try {
            return c.e();
        } catch (IllegalStateException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public void onClick(View view) {
        int id = view.getId();
        if (id != com.alibaba.triver.embed.video.R.id.trv_start) {
            if (id == com.alibaba.triver.embed.video.R.id.trv_fullscreen) {
                RVLogger.d("JiaoZiVideoPlayer", "onClick fullscreen [" + hashCode() + "] ");
                if (this.L == 6) {
                    return;
                }
                if (this.M == 2) {
                    u();
                    return;
                }
                RVLogger.d("JiaoZiVideoPlayer", "toFullscreenActivity [" + hashCode() + "] ");
                a(7);
                p();
                return;
            }
            return;
        }
        RVLogger.d("JiaoZiVideoPlayer", "onClick start [" + hashCode() + "] ");
        if (this.ab.c.isEmpty() || this.ab.a() == null || TextUtils.isEmpty(this.ab.a().toString())) {
            TriverToastUtils.showToast(getContext(), getResources().getString(com.alibaba.triver.embed.video.R.string.triver_video_no_url));
            return;
        }
        int i2 = this.L;
        if (i2 == 0) {
            if (!this.ab.a().toString().startsWith("file") && !this.ab.a().toString().startsWith(WVNativeCallbackUtil.SEPERATER) && !g.a(getContext()) && !E) {
                S();
                return;
            } else {
                a();
                a(0);
                return;
            }
        }
        if (i2 == 3) {
            a(3);
            RVLogger.d("JiaoZiVideoPlayer", "pauseVideo [" + hashCode() + "] ");
            c.g();
            e();
            if (this instanceof MyTBMiniAppVideoStd) {
                ((TBMiniAppVideoStd) this).l();
                return;
            }
            return;
        }
        if (i2 == 5) {
            a(4);
            c.h();
            d();
        } else if (i2 == 6) {
            a(2);
            a();
            if (this instanceof MyTBMiniAppVideoStd) {
                ((TBMiniAppVideoStd) this).k();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.M;
        if (i4 == 2 || i4 == 3) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.W == 0 || this.aa == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = (int) ((size * this.aa) / this.W);
        setMeasuredDimension(size, i5);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        if (z2) {
            this.R.setText(g.a((((long) i2) * getDuration()) / 100));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        RVLogger.d("JiaoZiVideoPlayer", "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        L();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        RVLogger.d("JiaoZiVideoPlayer", "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        a(5);
        K();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.L;
        if (i2 == 3 || i2 == 5) {
            long progress = (((long) seekBar.getProgress()) * getDuration()) / 100;
            c.a(progress);
            RVLogger.d("JiaoZiVideoPlayer", "seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (view.getId() == com.alibaba.triver.embed.video.R.id.trv_surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                RVLogger.d("JiaoZiVideoPlayer", "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                this.ai = true;
                this.aj = x2;
                this.ak = y2;
                this.al = false;
                this.am = false;
                this.an = false;
            } else if (action == 1) {
                RVLogger.d("JiaoZiVideoPlayer", "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                this.ai = false;
                T();
                U();
                V();
                if (this.am) {
                    a(12);
                    c.a(this.ar);
                    long duration = getDuration();
                    long j2 = this.ar * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.P.setProgress((int) (j2 / duration));
                }
                if (this.al) {
                    a(11);
                }
                K();
            } else if (action == 2) {
                RVLogger.d("JiaoZiVideoPlayer", "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                float f = x2 - this.aj;
                float f2 = y2 - this.ak;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (this.M == 2 && !this.am && !this.al && !this.an && (fAbs > 80.0f || fAbs2 > 80.0f)) {
                    L();
                    if (fAbs >= 80.0f) {
                        if (this.L != 7) {
                            this.am = true;
                            this.ao = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.aj < this.ae * 0.5f) {
                        this.an = true;
                        float f3 = g.d(getContext()).getAttributes().screenBrightness;
                        if (f3 < 0.0f) {
                            try {
                                this.aq = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                RVLogger.d("JiaoZiVideoPlayer", "current system brightness: " + this.aq);
                            } catch (Settings.SettingNotFoundException e) {
                                RVLogger.w(Log.getStackTraceString(e));
                            }
                        } else {
                            this.aq = f3 * 255.0f;
                            RVLogger.d("JiaoZiVideoPlayer", "current activity brightness: " + this.aq);
                        }
                    } else {
                        this.al = true;
                        this.ap = this.ag.getStreamVolume(3);
                    }
                }
                if (this.am) {
                    long duration2 = getDuration();
                    long j3 = (int) (this.ao + ((duration2 * f) / this.ae));
                    this.ar = j3;
                    if (j3 > duration2) {
                        this.ar = duration2;
                    }
                    a(f, g.a(this.ar), this.ar, g.a(duration2), duration2);
                }
                if (this.al) {
                    f2 = -f2;
                    int streamMaxVolume = this.ag.getStreamMaxVolume(3);
                    this.ag.setStreamVolume(3, this.ap + ((int) (((streamMaxVolume * f2) * 3.0f) / this.af)), 0);
                    a(-f2, (int) (((this.ap * 100) / streamMaxVolume) + (((f2 * 3.0f) * 100.0f) / this.af)));
                }
                if (this.an) {
                    float f4 = -f2;
                    int i2 = (int) (((f4 * 255.0f) * 3.0f) / this.af);
                    WindowManager.LayoutParams attributes = g.d(getContext()).getAttributes();
                    float f5 = this.aq;
                    float f6 = i2;
                    if ((f5 + f6) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f5 + f6) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f5 + f6) / 255.0f;
                    }
                    g.d(getContext()).setAttributes(attributes);
                    c((int) (((this.aq * 100.0f) / 255.0f) + (((f4 * 3.0f) * 100.0f) / this.af)));
                }
            }
        }
        return false;
    }

    public void p() {
        RVLogger.d("JiaoZiVideoPlayer", "startWindowFullscreen  [" + hashCode() + "] ");
        c(getContext());
        ViewGroup viewGroup = (ViewGroup) g.b(getContext()).findViewById(R.id.content);
        View viewFindViewById = viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        this.T.removeView(c.d);
        try {
            TBMiniAppVideo tBMiniAppVideo = (TBMiniAppVideo) getClass().getConstructor(Context.class).newInstance(getContext());
            tBMiniAppVideo.setId(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
            viewGroup.addView(tBMiniAppVideo, new FrameLayout.LayoutParams(-1, -1));
            tBMiniAppVideo.setSystemUiVisibility(4102);
            tBMiniAppVideo.a(this.ab, 2);
            tBMiniAppVideo.setState(this.L);
            tBMiniAppVideo.F();
            if ((tBMiniAppVideo instanceof TBMiniAppVideoStd) && h.c() != null && (h.c() instanceof TBMiniAppVideo)) {
                ((TBMiniAppVideoStd) tBMiniAppVideo).a((TBMiniAppVideoStd) h.c());
            }
            h.b(tBMiniAppVideo);
            g.a(getContext(), B);
            b();
            tBMiniAppVideo.P.setSecondaryProgress(this.P.getSecondaryProgress());
            tBMiniAppVideo.K();
            G = System.currentTimeMillis();
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    public void q() {
        RVLogger.d("JiaoZiVideoPlayer", "startWindowTiny  [" + hashCode() + "] ");
        a(9);
        int i2 = this.L;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) g.b(getContext()).findViewById(R.id.content);
        View viewFindViewById = viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_tiny_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        this.T.removeView(c.d);
        try {
            TBMiniAppVideo tBMiniAppVideo = (TBMiniAppVideo) getClass().getConstructor(Context.class).newInstance(getContext());
            tBMiniAppVideo.setId(com.alibaba.triver.embed.video.R.id.jz_tiny_id);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400, 400);
            layoutParams.gravity = 85;
            viewGroup.addView(tBMiniAppVideo, layoutParams);
            tBMiniAppVideo.a(this.ab, 3);
            tBMiniAppVideo.setState(this.L);
            tBMiniAppVideo.F();
            h.b(tBMiniAppVideo);
            b();
        } catch (InstantiationException e) {
            RVLogger.w(Log.getStackTraceString(e));
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    public void setBufferProgress(int i2) {
        if (i2 != 0) {
            this.P.setSecondaryProgress(i2);
        }
    }

    public void setState(int i2) {
        a(i2, 0, 0);
    }

    public void y() {
        RVLogger.d("JiaoZiVideoPlayer", "onPrepared  [" + hashCode() + "] ");
        z();
        d();
        if (MyTBMiniAppVideoStd.getEmbedview() != null) {
            MyTBMiniAppVideoStd.getEmbedview().a();
        }
    }

    public void z() {
        int iD;
        long j2 = this.N;
        if (j2 != 0) {
            c.a(j2);
            this.N = 0L;
            return;
        }
        TriverEmbedVideoView embedview = MyTBMiniAppVideoStd.getEmbedview();
        if (embedview == null || (iD = embedview.d()) < 0) {
            return;
        }
        c.a(iD * 1000);
    }

    public static void a(Context context, Class cls, com.alibaba.triver.embed.video.fullscreenvideo.a aVar) {
        c(context);
        g.a(context, B);
        ViewGroup viewGroup = (ViewGroup) g.b(context).findViewById(R.id.content);
        View viewFindViewById = viewGroup.findViewById(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        try {
            TBMiniAppVideo tBMiniAppVideo = (TBMiniAppVideo) cls.getConstructor(Context.class).newInstance(context);
            tBMiniAppVideo.setId(com.alibaba.triver.embed.video.R.id.jz_fullscreen_id);
            viewGroup.addView(tBMiniAppVideo, new FrameLayout.LayoutParams(-1, -1));
            tBMiniAppVideo.a(aVar, 2);
            G = System.currentTimeMillis();
            tBMiniAppVideo.O.performClick();
        } catch (InstantiationException e) {
            RVLogger.w(Log.getStackTraceString(e));
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    public static void b(AbsListView absListView, int i2, int i3, int i4) {
        int i5 = i3 + i2;
        int i6 = c.a().h;
        RVLogger.e("JiaoZiVideoPlayer", "onScrollReleaseAllVideos: " + i6 + " " + i2 + " " + i6 + " " + i5);
        if (i6 >= 0) {
            if ((i6 < i2 || i6 > i5 - 1) && h.c().M != 2) {
                s();
            }
        }
    }

    public void c() {
        RVLogger.d("JiaoZiVideoPlayer", "onStatePreparing  [" + hashCode() + "] ");
        this.L = 1;
        M();
    }

    public TBMiniAppVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = -1;
        this.M = -1;
        this.N = 0L;
        this.W = 0;
        this.aa = 0;
        this.ac = -1;
        this.ad = 0;
        this.as = false;
        a(context);
    }

    public void b(int i2) {
        long duration = getDuration();
        long j2 = i2 * 100;
        if (duration == 0) {
            duration = 1;
        }
        this.P.setProgress((int) (j2 / duration));
    }

    public void b() {
        RVLogger.d("JiaoZiVideoPlayer", "onStateNormal  [" + hashCode() + "] ");
        this.L = 0;
        L();
    }

    public void b(int i2, int i3) {
        RVLogger.e("JiaoZiVideoPlayer", "onError " + i2 + " - " + i3 + " [" + hashCode() + "] ");
        if (i2 == 38 || i3 == -38 || i2 == -38 || i3 == 38 || i3 == -19) {
            return;
        }
        f();
        if (N()) {
            c.a().k();
        }
    }

    public static void a(Context context, String str) {
        g.b(context, str);
    }

    public static void a(AbsListView absListView, int i2, int i3, int i4) {
        int i5 = i3 + i2;
        int i6 = c.a().h;
        if (i6 >= 0) {
            if (i6 >= i2 && i6 <= i5 - 1) {
                if (h.c() == null || h.c().M != 3) {
                    return;
                }
                RVLogger.e("JiaoZiVideoPlayer", "onScroll: into screen");
                u();
                return;
            }
            if (h.c() == null || h.c().M == 3 || h.c().M == 2) {
                return;
            }
            if (h.c().L == 5) {
                s();
            } else {
                RVLogger.e("JiaoZiVideoPlayer", "onScroll: out screen");
                h.c().q();
            }
        }
    }

    public static void a(View view, int i2) {
        TBMiniAppVideo tBMiniAppVideo;
        if (h.c() == null || h.c().M != 3 || (tBMiniAppVideo = (TBMiniAppVideo) view.findViewById(i2)) == null || !tBMiniAppVideo.ab.a(c.c())) {
            return;
        }
        u();
    }

    public static void a(View view) {
        if (h.c() == null || h.c().M == 3) {
            return;
        }
        TBMiniAppVideo tBMiniAppVideoC = h.c();
        if (((ViewGroup) view).indexOfChild(tBMiniAppVideoC) != -1) {
            if (tBMiniAppVideoC.L == 5) {
                s();
            } else {
                tBMiniAppVideoC.q();
            }
        }
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        setClickable(true);
        this.O = (ImageView) findViewById(com.alibaba.triver.embed.video.R.id.trv_start);
        this.Q = (ImageView) findViewById(com.alibaba.triver.embed.video.R.id.trv_fullscreen);
        this.P = (SeekBar) findViewById(com.alibaba.triver.embed.video.R.id.trv_bottom_seek_progress);
        this.R = (TextView) findViewById(com.alibaba.triver.embed.video.R.id.trv_current);
        this.S = (TextView) findViewById(com.alibaba.triver.embed.video.R.id.trv_total);
        this.V = (ViewGroup) findViewById(com.alibaba.triver.embed.video.R.id.trv_layout_bottom);
        this.T = (ViewGroup) findViewById(com.alibaba.triver.embed.video.R.id.trv_surface_container);
        this.U = (ViewGroup) findViewById(com.alibaba.triver.embed.video.R.id.trv_layout_top);
        this.O.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.P.setOnSeekBarChangeListener(this);
        this.V.setOnClickListener(this);
        this.ae = getContext().getResources().getDisplayMetrics().widthPixels;
        this.af = getContext().getResources().getDisplayMetrics().heightPixels;
        this.ag = (AudioManager) getContext().getSystemService("audio");
        try {
            if (N()) {
                C = ((AppCompatActivity) context).getRequestedOrientation();
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    public void a(String str, String str2, int i2, boolean z2) {
        a(new com.alibaba.triver.embed.video.fullscreenvideo.a(str, str2, z2), i2);
    }

    public void a(String str, String str2, int i2) {
        a(new com.alibaba.triver.embed.video.fullscreenvideo.a(str, str2), i2);
    }

    public void a(com.alibaba.triver.embed.video.fullscreenvideo.a aVar, int i2) {
        long jD;
        if (this.ab == null || aVar.a() == null || !this.ab.a(aVar.a())) {
            if (O() && aVar.a(c.c())) {
                try {
                    jD = c.d();
                } catch (IllegalStateException e) {
                    RVLogger.w(Log.getStackTraceString(e));
                    jD = 0;
                }
                if (jD != 0) {
                    g.a(getContext(), c.c(), jD);
                }
                c.a().k();
            } else if (O() && !aVar.a(c.c())) {
                q();
            } else if (!O() && aVar.a(c.c())) {
                if (h.c() != null && h.c().M == 3) {
                    this.as = true;
                }
            } else if (!O()) {
                aVar.a(c.c());
            }
            this.ab = aVar;
            this.M = i2;
            b();
        }
    }

    public void a() {
        h.d();
        RVLogger.d("JiaoZiVideoPlayer", "startVideo [" + hashCode() + "] ");
        E();
        F();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(I, 3, 2);
        g.b(getContext()).getWindow().addFlags(128);
        c.a(this.ab);
        c.a().h = this.ac;
        c();
        h.a(this);
    }

    public void a(int i2, int i3, int i4) {
        switch (i2) {
            case 0:
                b();
                break;
            case 1:
                c();
                break;
            case 2:
                a(i3, i4);
                break;
            case 3:
                d();
                break;
            case 5:
                e();
                break;
            case 6:
                g();
                break;
            case 7:
                f();
                break;
            case 8:
                A();
                break;
        }
    }

    public void a(int i2, long j2) {
        this.L = 2;
        this.N = j2;
        com.alibaba.triver.embed.video.fullscreenvideo.a aVar = this.ab;
        aVar.b = i2;
        c.a(aVar);
        c.a().l();
    }

    public void a(int i2, int i3) {
        RVLogger.d("JiaoZiVideoPlayer", "onInfo what - " + i2 + " extra - " + i3);
    }

    public void a(int i2, long j2, long j3) {
        if (!this.ai && i2 != 0) {
            this.P.setProgress(i2);
        }
        if (j2 != 0) {
            this.R.setText(g.a(j2));
        }
        this.S.setText(g.a(j3));
    }

    public void a(float f) {
        int i2;
        if (N()) {
            int i3 = this.L;
            if ((i3 != 3 && i3 != 5) || (i2 = this.M) == 2 || i2 == 3) {
                return;
            }
            if (f > 0.0f) {
                g.a(getContext(), 0);
            } else {
                g.a(getContext(), 8);
            }
            a(7);
            p();
        }
    }

    public void a(int i2) {
        if (J == null || !N() || this.ab.c.isEmpty()) {
            return;
        }
        J.a(i2, this.ab.a(), this.M, new Object[0]);
    }
}
