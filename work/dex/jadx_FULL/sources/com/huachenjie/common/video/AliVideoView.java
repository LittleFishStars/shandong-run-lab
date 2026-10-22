package com.huachenjie.common.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.source.UrlSource;
import com.bumptech.glide.Glide;
import com.huachenjie.common.R;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.gv1;
import com.zj.adlib.i4a;
import com.zj.adlib.io9;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class AliVideoView extends FrameLayout implements DefaultLifecycleObserver, View.OnTouchListener {
    public static final int Q = 1;
    public static final int R = 2;
    public static final int S = 3;
    public static final int T = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f33948a = false;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f8941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f8943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f8944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressBar f8945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SeekBar f8946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f8947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AliPlayer f8948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AliVideoCallback f8949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VideoTextureView f8950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f8951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f8952a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f8953b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f8954b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LinearLayout f8955b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f8956b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AtomicBoolean f8957b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ImageView f8958c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LinearLayout f8959c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TextView f8960c;
    public ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public LinearLayout f8961d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f8962d;
    public ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public TextView f8963e;
    public ImageView f;
    public ImageView g;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            if (AliVideoView.this.f8948a != null) {
                AliVideoView.this.f8948a.setSurface(new Surface(surface));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
            if (AliVideoView.this.f8948a == null) {
                return false;
            }
            AliVideoView.this.f8948a.setSurface(null);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
            if (AliVideoView.this.f8948a != null) {
                AliVideoView.this.f8948a.surfaceChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {
        public int K = 0;

        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                long j = progress;
                io9.a(AliVideoView.this.f8947a, j);
                io9.a(AliVideoView.this.f8960c, j);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            this.K = seekBar.getProgress();
            AliVideoView aliVideoView = AliVideoView.this;
            aliVideoView.setViewVisible(aliVideoView.f8959c);
            AliVideoView.this.P = 3;
            AliVideoView.this.s0(false);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            AliVideoView.this.P = 0;
            AliVideoView aliVideoView = AliVideoView.this;
            aliVideoView.setViewGone(aliVideoView.f8959c);
            long progress = seekBar.getProgress();
            if (AliVideoView.this.V() != (progress > AliVideoView.this.f8953b)) {
                AliVideoView.this.seekTo(progress);
                AliVideoView.this.s0(true);
            } else {
                AliVideoView aliVideoView2 = AliVideoView.this;
                aliVideoView2.seekTo(aliVideoView2.f8953b);
                AliVideoView.this.i0();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (AliVideoView.this.f8949a != null) {
                AliVideoView.this.f8949a.h();
            }
        }
    }

    public class d implements IPlayer.OnPreparedListener {
        public d() {
        }

        @Override // com.aliyun.player.IPlayer.OnPreparedListener
        public void onPrepared() {
            i4a.a("OnPrepared");
            AliVideoView.this.k0();
        }
    }

    public class e implements IPlayer.OnVideoSizeChangedListener {
        public e() {
        }

        @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int width, int height) {
            if (width == 0 && height == 0) {
                return;
            }
            i4a.a("setOnVideoSizeChanged(" + width + "," + height + ")");
        }
    }

    public class f implements IPlayer.OnInfoListener {
        public f() {
        }

        @Override // com.aliyun.player.IPlayer.OnInfoListener
        public void onInfo(InfoBean infoBean) {
            if (infoBean.getCode() == InfoCode.CurrentPosition) {
                AliVideoView.this.h0(infoBean.getExtraValue());
            }
        }
    }

    public class g implements IPlayer.OnLoadingStatusListener {
        public g() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            AliVideoView.this.u0(true);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            AliVideoView.this.u0(false);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int percent, float netSpeed) {
        }
    }

    public class h implements IPlayer.OnRenderingStartListener {
        public h() {
        }

        @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
        public void onRenderingStart() {
            AliVideoView aliVideoView = AliVideoView.this;
            aliVideoView.setViewGone(aliVideoView.f8943a);
        }
    }

    public class i implements IPlayer.OnStateChangedListener {
        public i() {
        }

        @Override // com.aliyun.player.IPlayer.OnStateChangedListener
        public void onStateChanged(int newState) {
            switch (newState) {
                case -1:
                    i4a.a("unKnow");
                    break;
                case 0:
                    i4a.a("idle");
                    break;
                case 1:
                    i4a.a("initialized");
                    break;
                case 2:
                    i4a.a("prepared");
                    AliVideoView.this.k0();
                    break;
                case 3:
                    i4a.a("started");
                    AliVideoView.this.f8952a.set(true);
                    AliVideoView aliVideoView = AliVideoView.this;
                    aliVideoView.setViewGone(aliVideoView.f8954b);
                    AliVideoView.this.d.setImageResource(R.drawable.ic_video_view_control_pause);
                    if (AliVideoView.this.f8949a != null && AliVideoView.this.f8948a != null) {
                        AliVideoView.this.f8949a.g(true);
                        break;
                    }
                    break;
                case 4:
                    i4a.a("paused");
                    AliVideoView.this.f8952a.set(false);
                    AliVideoView.this.d.setImageResource(R.drawable.ic_video_view_control_play);
                    if (AliVideoView.this.f8949a != null && AliVideoView.this.f8948a != null) {
                        AliVideoView.this.f8949a.g(false);
                        break;
                    }
                    break;
                case 5:
                    i4a.a("stopped");
                    break;
                case 6:
                    i4a.a("completion");
                    AliVideoView.this.e0();
                    break;
                case 7:
                    i4a.a("error");
                    AliVideoView.this.f0();
                    break;
            }
        }
    }

    public AliVideoView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer == null) {
            return;
        }
        if (aliPlayer.isMute()) {
            this.f8948a.setMute(false);
            this.e.setImageResource(R.drawable.ic_video_view_volume);
        } else {
            this.f8948a.setMute(true);
            this.e.setImageResource(R.drawable.ic_video_view_mute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        Activity activity = gv1.getActivity(view.getContext());
        if (activity == null || T(activity)) {
            return;
        }
        setScreenPortrait(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(ErrorInfo errorInfo) {
        i4a.a("errorInfo:" + errorInfo.getCode());
        i4a.a("errorInfo:" + errorInfo.getMsg());
        fv5.b("视频播放出错");
        f0();
    }

    public static Window getWindow(Context context) {
        Activity activity = gv1.getActivity(context);
        if (activity != null) {
            return activity.getWindow();
        }
        return null;
    }

    private void setScreenLandscape(@NonNull Activity activity) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        setLayoutParams(layoutParams);
        this.f.setImageResource(R.drawable.ic_video_view_screen_vertical);
        activity.setRequestedOrientation(0);
        activity.getWindow().addFlags(1024);
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null) {
            aliVideoCallback.e(0);
        }
        n0();
    }

    private void setScreenPortrait(@NonNull Activity activity) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.L;
        setLayoutParams(layoutParams);
        this.f.setImageResource(R.drawable.ic_video_view_screen_horizontal);
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null) {
            aliVideoCallback.e(1);
        }
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewGone(View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisible(View view) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
    }

    public final void D(Context context, float dY, int height) {
        Window window = getWindow(context);
        if (window == null) {
            return;
        }
        float f2 = dY / height;
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.c == -1.0f) {
            this.c = attributes.screenBrightness;
        }
        float f3 = this.c + f2;
        if (f3 <= 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        attributes.screenBrightness = f3;
        r0((int) ((f3 * 100.0f) / 1.0f));
        window.setAttributes(attributes);
    }

    public final void E(float dX) {
        L();
        setViewVisible(this.f8959c);
        int max = this.f8946a.getMax();
        if (this.N == -1) {
            this.N = this.f8946a.getProgress();
        }
        float f2 = max;
        float width = (((dX / getWidth()) * f2) / 2.0f) + this.N;
        if (width <= 0.0f) {
            width = 0.0f;
        } else if (width > f2) {
            width = f2;
        }
        io9.a(this.f8960c, (long) (((1.0f * width) / f2) * this.f8948a.getDuration()));
        int i2 = (int) width;
        this.f8946a.setProgress(i2);
        this.O = i2;
    }

    public final void F(Context context, float dY, int height) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (this.M == -1) {
            this.M = audioManager.getStreamVolume(3);
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f2 = dY / height;
        float f3 = streamMaxVolume;
        int i2 = (int) (this.M + (f2 * f3));
        if (i2 <= 0) {
            streamMaxVolume = 0;
        } else if (i2 <= streamMaxVolume) {
            streamMaxVolume = i2;
        }
        v0((int) ((streamMaxVolume * 100.0f) / f3));
        audioManager.setStreamVolume(3, streamMaxVolume, 1);
    }

    public final void G() {
        if (!this.f8952a.get()) {
            this.f8954b.setImageResource(R.drawable.ic_video_view_pause);
            s0(true);
            w0();
        } else {
            s0(false);
            l0();
            setViewVisible(this.f8954b);
            this.f8954b.setImageResource(R.drawable.ic_video_view_play);
            this.f8954b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.y30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45947a.W(view);
                }
            });
        }
    }

    public final void H() {
        Activity activity = gv1.getActivity(this);
        if (activity == null) {
            return;
        }
        if (T(activity)) {
            setScreenLandscape(activity);
        } else {
            setScreenPortrait(activity);
        }
    }

    public final int I(float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, getContext().getResources().getDisplayMetrics());
    }

    public final int J(float startX, float dX, float dY) {
        if (Math.abs(dX) >= Math.abs(dY)) {
            return 3;
        }
        return startX >= ((float) getWidth()) / 2.0f ? 1 : 2;
    }

    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final void d0() {
        removeCallbacks(this.f8951a);
        setViewGone(this.f8944a);
        setViewGone(this.f8955b);
    }

    public final void L() {
        setViewGone(this.f8961d);
        setViewGone(this.f8959c);
    }

    public final void M() {
        setOnTouchListener(this);
        this.f8946a.setOnSeekBarChangeListener(new b());
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.z30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46175a.X(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40448a.Y(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.b40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40673a.Z(view);
            }
        });
        this.f8958c.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.c40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40896a.b0(view);
            }
        });
        this.f8943a.setOnClickListener(new c());
    }

    public final void N() {
        AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(getContext());
        this.f8948a = aliPlayerCreateAliPlayer;
        aliPlayerCreateAliPlayer.setTraceId("DisableAnalytics");
        this.f8948a.setAutoPlay(false);
        this.f8948a.setLoop(false);
        PlayerConfig config = this.f8948a.getConfig();
        config.mPositionTimerIntervalMs = 50;
        config.mClearFrameWhenStop = true;
        this.f8948a.setConfig(config);
        this.f8948a.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
        this.f8948a.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.zj.adlib.w30
            @Override // com.aliyun.player.IPlayer.OnErrorListener
            public final void onError(ErrorInfo errorInfo) {
                this.f45515a.c0(errorInfo);
            }
        });
        this.f8948a.setOnPreparedListener(new d());
        this.f8948a.setOnVideoSizeChangedListener(new e());
        this.f8948a.setOnInfoListener(new f());
        this.f8948a.setOnLoadingStatusListener(new g());
        this.f8948a.setOnRenderingStartListener(new h());
        this.f8948a.setOnStateChangedListener(new i());
    }

    public final void O() {
        this.f8950a.setSurfaceTextureListener(new a());
    }

    public final void R(Context context) {
        View.inflate(context, R.layout.default_ali_video_view, this);
        this.f8950a = (VideoTextureView) findViewById(R.id.video_texture_view);
        this.f8943a = (ImageView) findViewById(R.id.video_cover);
        this.f8954b = (ImageView) findViewById(R.id.video_play_or_pause);
        this.f8944a = (LinearLayout) findViewById(R.id.video_control_bar_top);
        this.f8958c = (ImageView) findViewById(R.id.video_back);
        this.f8955b = (LinearLayout) findViewById(R.id.video_control_bar_bottom);
        this.d = (ImageView) findViewById(R.id.video_control_play);
        this.e = (ImageView) findViewById(R.id.video_control_volume);
        this.f = (ImageView) findViewById(R.id.video_control_orientation);
        this.f8947a = (TextView) findViewById(R.id.video_current_time);
        this.f8956b = (TextView) findViewById(R.id.video_duration);
        this.f8946a = (SeekBar) findViewById(R.id.video_seek_bar);
        this.f8959c = (LinearLayout) findViewById(R.id.video_control_time_progress);
        this.f8960c = (TextView) findViewById(R.id.drag_video_current_duration);
        this.f8962d = (TextView) findViewById(R.id.drag_video_duration);
        this.f8961d = (LinearLayout) findViewById(R.id.video_remind);
        this.g = (ImageView) findViewById(R.id.video_remind_icon);
        this.f8945a = (ProgressBar) findViewById(R.id.video_loading);
        this.f8963e = (TextView) findViewById(R.id.video_remind_text);
        O();
        o0();
        L();
        M();
    }

    public final boolean S() {
        LinearLayout linearLayout = this.f8955b;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean T(@NonNull Activity activity) {
        return activity.getRequestedOrientation() == 1;
    }

    public final boolean V() {
        return this.f8953b > 0;
    }

    public final void e0() {
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null) {
            aliVideoCallback.c();
        }
    }

    public final void f0() {
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null) {
            aliVideoCallback.d();
        }
    }

    public final void h0(long progress) {
        AliPlayer aliPlayer;
        if (this.P != 3) {
            if (V()) {
                long j = this.f8953b;
                if (progress > j) {
                    this.f8946a.setProgress((int) j);
                    i0();
                    return;
                }
            }
            SeekBar seekBar = this.f8946a;
            if (seekBar != null) {
                seekBar.setProgress((int) progress);
            }
            io9.a(this.f8947a, progress);
        }
        if (this.f8942a != progress) {
            this.f8942a = progress;
            AliVideoCallback aliVideoCallback = this.f8949a;
            if (aliVideoCallback == null || (aliPlayer = this.f8948a) == null) {
                return;
            }
            aliVideoCallback.i(progress, aliPlayer.getDuration());
        }
    }

    public final void i0() {
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null) {
            aliVideoCallback.f(this);
        }
        d0();
    }

    public final void j0() {
        if (this.M != -1) {
            this.M = -1;
        }
        if (this.c != -1.0f) {
            this.c = -1.0f;
        }
        if (this.N != -1) {
            seekTo(this.O);
            this.O = 0;
            this.N = -1;
        }
    }

    public final void k0() {
        long duration;
        AliPlayer aliPlayer;
        AliPlayer aliPlayer2 = this.f8948a;
        if (aliPlayer2 != null) {
            aliPlayer2.start();
            duration = this.f8948a.getDuration();
        } else {
            duration = 0;
        }
        AliVideoCallback aliVideoCallback = this.f8949a;
        if (aliVideoCallback != null && (aliPlayer = this.f8948a) != null) {
            aliVideoCallback.a(aliPlayer);
        }
        SeekBar seekBar = this.f8946a;
        if (seekBar != null) {
            seekBar.setMax((int) duration);
            this.f8946a.setProgress(0);
        }
        this.f8942a = 0L;
        io9.a(this.f8947a, 0L);
        io9.a(this.f8956b, duration);
        io9.a(this.f8960c, 0L);
        io9.b(this.f8962d, duration, " / ");
    }

    public final void l0() {
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.pause();
    }

    public final void m0(String url, String coverUrl, long duration, boolean showControl) {
        this.f8952a.set(false);
        this.d.setImageResource(R.drawable.ic_video_view_control_play);
        showCover(coverUrl);
        SeekBar seekBar = this.f8946a;
        if (seekBar != null) {
            seekBar.setMax(100);
            this.f8946a.setProgress(0);
        }
        this.f8942a = 0L;
        io9.a(this.f8947a, 0L);
        io9.a(this.f8956b, 0L);
        io9.a(this.f8960c, this.f8942a);
        io9.b(this.f8962d, 0L, " / ");
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer != null) {
            aliPlayer.pause();
            UrlSource urlSource = new UrlSource();
            urlSource.setUri(url);
            this.f8948a.setDataSource(urlSource);
            this.f8948a.seekTo(duration, IPlayer.SeekMode.Accurate);
            this.f8948a.prepare();
        }
        if (showControl) {
            s0(true);
        }
    }

    public final void n0() {
        int I = I(40.0f);
        q0(this.d, I, I);
        q0(this.e, I, I);
        q0(this.f, I, I);
        setViewVisible(this.f8944a);
    }

    public final void o0() {
        int I = I(32.0f);
        q0(this.d, I, I);
        q0(this.e, I, I);
        q0(this.f, I, I);
        setViewGone(this.f8944a);
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NonNull LifecycleOwner owner) {
        onDestroy();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onPause(@NonNull LifecycleOwner owner) {
        onPause();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onResume(@NonNull LifecycleOwner owner) {
        onResume();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        int id = view.getId();
        Activity activity = gv1.getActivity(this);
        if (activity != null) {
            T(activity);
        }
        if (id == R.id.video_back || id == R.id.video_control_play || id == R.id.video_control_volume || id == R.id.video_control_orientation || id == R.id.video_remind_text || id == R.id.video_seek_bar || id == R.id.video_control_bar_bottom || id == R.id.video_control_bar_top || id == R.id.video_play_or_pause) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.f8941a = event.getX();
            this.b = event.getY();
        } else if (action == 1) {
            if (this.P != 0) {
                this.P = 0;
                j0();
                L();
            }
            if (this.f8941a == event.getX() && this.b == event.getY()) {
                if (S()) {
                    d0();
                } else {
                    s0(true);
                }
                return true;
            }
        } else if (action == 2) {
            float x = event.getX();
            float y = event.getY();
            float f2 = x - this.f8941a;
            float f3 = y - this.b;
            if (Math.abs(f2) < 1.0f) {
                Math.abs(f3);
            }
        }
        return true;
    }

    public final void p0(View view, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = leftMargin;
            marginLayoutParams.topMargin = topMargin;
            marginLayoutParams.rightMargin = rightMargin;
            marginLayoutParams.bottomMargin = bottomMargin;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void playPreview(String url, String coverUrl, long previewTime, boolean showControl) {
        this.f8953b = previewTime;
        m0(url, coverUrl, 0L, showControl);
    }

    public void playVideo(String url, String coverUrl, long duration, boolean showControl) {
        this.f8953b = 0L;
        m0(url, coverUrl, duration, showControl);
    }

    public final void q0(View view, int width, int height) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    public final void r0(int progress) {
        setViewVisible(this.f8961d);
        setViewVisible(this.g);
        this.g.setImageResource(R.drawable.ic_video_view_play_brightness);
        setViewGone(this.f8945a);
        setViewVisible(this.f8963e);
        this.f8963e.setText(progress + "%");
    }

    public void replay() {
        seekTo(0L);
        io9.a(this.f8947a, 0L);
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        s0(true);
    }

    public final void s0(boolean autoHide) {
        removeCallbacks(this.f8951a);
        setViewVisible(this.f8955b);
        Activity activity = gv1.getActivity(this);
        if (activity != null && !T(activity)) {
            setViewVisible(this.f8944a);
        }
        if (autoHide) {
            postDelayed(this.f8951a, SplashActivity.f36053a);
        }
    }

    public void seekTo(long duration) {
        i4a.a("seekTo:" + duration);
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer != null) {
            aliPlayer.seekTo(duration, IPlayer.SeekMode.Accurate);
        }
    }

    public void setCallback(AliVideoCallback callback) {
        this.f8949a = callback;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    public void setVideoPortraitSize(int width, int height) {
        this.K = width;
        this.L = height;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.L;
        setLayoutParams(layoutParams);
    }

    public void showCover(String coverUrl) {
        ImageView imageView = this.f8943a;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            Glide.with(this.f8943a).load(coverUrl).into(this.f8943a);
            this.f8943a.setVisibility(0);
        }
        d0();
    }

    public final void u0(boolean show) {
        if (!show) {
            setViewGone(this.f8961d);
            return;
        }
        setViewVisible(this.f8961d);
        setViewGone(this.g);
        setViewVisible(this.f8945a);
        setViewVisible(this.f8963e);
        this.f8963e.setText("加载中...");
    }

    public final void v0(int progress) {
        setViewVisible(this.f8961d);
        setViewVisible(this.g);
        this.g.setImageResource(R.drawable.ic_video_view_play_volume);
        setViewGone(this.f8945a);
        setViewVisible(this.f8963e);
        this.f8963e.setText(progress + "%");
    }

    public final void w0() {
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.start();
    }

    public AliVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void onDestroy() {
        this.f8952a.set(false);
        AliPlayer aliPlayer = this.f8948a;
        if (aliPlayer != null) {
            aliPlayer.stop();
            this.f8948a.setSurface(null);
            this.f8948a.release();
            this.f8948a = null;
        }
    }

    public void onPause() {
        if (this.f8952a.get()) {
            this.f8948a.pause();
        }
        this.f8957b.set(this.f8952a.get());
    }

    public void onResume() {
        if (this.f8948a == null || !this.f8957b.get()) {
            return;
        }
        this.f8948a.start();
    }

    public AliVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8952a = new AtomicBoolean(false);
        this.f8957b = new AtomicBoolean(false);
        this.f8953b = 0L;
        this.M = -1;
        this.f8951a = new Runnable() { // from class: com.zj.adlib.x30
            @Override // java.lang.Runnable
            public final void run() {
                this.f45738a.d0();
            }
        };
        R(context);
        N();
    }
}
