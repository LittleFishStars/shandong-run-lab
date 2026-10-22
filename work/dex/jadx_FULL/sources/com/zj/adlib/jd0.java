package com.zj.adlib;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.source.UrlSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.video.OnPlayerCallback;
import com.huachenjie.works.page.alumni.attention.AttentionVideoTextureView;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010%¨\u0006)"}, d2 = {"Lcom/zj/adlib/jd0;", "", "Landroid/content/Context;", "context", "", "k", "Lcom/huachenjie/common/video/OnPlayerCallback;", RenderCallContext.TYPE_CALLBACK, "y", "", "url", j.o, "B", "w", "v", "x", "u", "Landroid/widget/FrameLayout;", "container", "j", "i", "", "show", "A", "t", "s", t.d, "Lcom/aliyun/player/AliPlayer;", "a", "Lcom/aliyun/player/AliPlayer;", "aliPlayer", "Lcom/huachenjie/works/page/alumni/attention/AttentionVideoTextureView;", "Lcom/huachenjie/works/page/alumni/attention/AttentionVideoTextureView;", "mTextureView", "Lcom/huachenjie/common/video/OnPlayerCallback;", "mCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPlaying", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttentionVideoPlayerHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttentionVideoPlayerHelper.kt\ncom/huachenjie/works/page/alumni/attention/AttentionVideoPlayerHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,289:1\n1#2:290\n*E\n"})
public final class jd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42555a = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f17359a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AliPlayer aliPlayer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnPlayerCallback mCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AttentionVideoTextureView mTextureView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean isPlaying = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/zj/adlib/jd0$a;", "", "", "mTimerIntervalMs", "I", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/jd0$b", "Lcom/aliyun/player/IPlayer$OnLoadingStatusListener;", "", "onLoadingBegin", "", "percent", "", "netSpeed", "onLoadingProgress", "onLoadingEnd", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements IPlayer.OnLoadingStatusListener {
        public b() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            OnPlayerCallback onPlayerCallback = jd0.this.mCallback;
            if (onPlayerCallback != null) {
                onPlayerCallback.onLoadingChanged(true);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            OnPlayerCallback onPlayerCallback = jd0.this.mCallback;
            if (onPlayerCallback != null) {
                onPlayerCallback.onLoadingChanged(false);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int percent, float netSpeed) {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"com/zj/adlib/jd0$c", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            i4a.a("onSurfaceTextureAvailable");
            AliPlayer aliPlayer = jd0.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.setSurface(new Surface(surface));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            i4a.a("onSurfaceTextureDestroyed");
            AliPlayer aliPlayer = jd0.this.aliPlayer;
            if (aliPlayer == null) {
                return false;
            }
            aliPlayer.setSurface(null);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            i4a.a("onSurfaceTextureSizeChanged");
            AliPlayer aliPlayer = jd0.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.surfaceChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public static final void m(ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, MyLocationStyle.ERROR_INFO);
        i4a.a("errorInfo:" + errorInfo.getCode());
        i4a.a("errorInfo:" + errorInfo.getMsg());
        fv5.b("视频播放出错");
    }

    public static final void n(jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(jd0Var, "this$0");
        i4a.a("OnPrepared");
        AliPlayer aliPlayer = jd0Var.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        OnPlayerCallback onPlayerCallback = jd0Var.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.a(jd0Var.aliPlayer);
        }
    }

    public static final void o(jd0 jd0Var, int i, int i2) {
        Intrinsics.checkNotNullParameter(jd0Var, "this$0");
        if (i == 0 && i2 == 0) {
            return;
        }
        i4a.a("setOnVideoSizeChanged(" + i + ',' + i2 + ')');
        AttentionVideoTextureView attentionVideoTextureView = jd0Var.mTextureView;
        if (attentionVideoTextureView != null) {
            attentionVideoTextureView.setVideoSize(i, i2);
        }
        OnPlayerCallback onPlayerCallback = jd0Var.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.d(i, i2);
        }
    }

    public static final void p(jd0 jd0Var, int i) {
        Intrinsics.checkNotNullParameter(jd0Var, "this$0");
        switch (i) {
            case -1:
                i4a.a("unknow");
                break;
            case 0:
                i4a.a("idle");
                break;
            case 1:
                i4a.a("initalized");
                break;
            case 2:
                i4a.a("prepared");
                OnPlayerCallback onPlayerCallback = jd0Var.mCallback;
                if (onPlayerCallback != null) {
                    onPlayerCallback.a(jd0Var.aliPlayer);
                }
                break;
            case 3:
                i4a.a("started");
                jd0Var.isPlaying.set(true);
                OnPlayerCallback onPlayerCallback2 = jd0Var.mCallback;
                if (onPlayerCallback2 != null) {
                    onPlayerCallback2.c(true);
                }
                break;
            case 4:
                i4a.a("paused");
                jd0Var.isPlaying.set(false);
                OnPlayerCallback onPlayerCallback3 = jd0Var.mCallback;
                if (onPlayerCallback3 != null) {
                    onPlayerCallback3.c(false);
                }
                break;
            case 5:
                jd0Var.isPlaying.set(false);
                i4a.a("stopped");
                break;
            case 6:
                jd0Var.isPlaying.set(false);
                i4a.a("completion");
                break;
            case 7:
                jd0Var.isPlaying.set(false);
                i4a.a("error");
                break;
        }
    }

    public static final void q(jd0 jd0Var, InfoBean infoBean) {
        Intrinsics.checkNotNullParameter(jd0Var, "this$0");
        Intrinsics.checkNotNullParameter(infoBean, "infoBean");
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            OnPlayerCallback onPlayerCallback = jd0Var.mCallback;
            if (onPlayerCallback != null) {
                AliPlayer aliPlayer = jd0Var.aliPlayer;
                onPlayerCallback.onProgressChanged(extraValue, aliPlayer != null ? aliPlayer.getDuration() : 0L);
            }
        }
    }

    public static final void r(jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(jd0Var, "this$0");
        i4a.a("onRenderingStart");
        OnPlayerCallback onPlayerCallback = jd0Var.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.onLoadingChanged(false);
        }
        jd0Var.A(false);
    }

    public final void A(boolean show) {
        i4a.a("showVideoCover:" + show);
        OnPlayerCallback onPlayerCallback = this.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.b(show);
        }
    }

    public final void B() {
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
    }

    public final void i(@NotNull FrameLayout container) {
        AliPlayer aliPlayer;
        Intrinsics.checkNotNullParameter(container, "container");
        i4a.a("attachedToContainer:" + container);
        AttentionVideoTextureView attentionVideoTextureView = this.mTextureView;
        if (attentionVideoTextureView != null) {
            if (attentionVideoTextureView.getParent() != null) {
                i4a.a("attachedToContainer has parent ：" + attentionVideoTextureView.getParent());
                ViewParent parent = attentionVideoTextureView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(attentionVideoTextureView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
            layoutParams.gravity = 17;
            attentionVideoTextureView.setLayoutParams(layoutParams);
            i4a.a("attached To Container");
            container.addView(attentionVideoTextureView, 0);
            SurfaceTexture surfaceTexture = attentionVideoTextureView.getSurfaceTexture();
            if (surfaceTexture == null || (aliPlayer = this.aliPlayer) == null) {
                return;
            }
            aliPlayer.setSurface(new Surface(surfaceTexture));
        }
    }

    public final void j(@NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        AttentionVideoTextureView attentionVideoTextureView = this.mTextureView;
        if (attentionVideoTextureView != null) {
            container.removeView(attentionVideoTextureView);
        }
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
    }

    public final void k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        l(applicationContext);
        s(context);
    }

    public final void l(Context context) {
        AliPlayerGlobalSettings.enableLocalCache(true, 0, context.getCacheDir().getAbsolutePath() + "/video");
        AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(context);
        aliPlayerCreateAliPlayer.setTraceId("DisableAnalytics");
        aliPlayerCreateAliPlayer.setAutoPlay(false);
        aliPlayerCreateAliPlayer.setLoop(true);
        PlayerConfig config = aliPlayerCreateAliPlayer.getConfig();
        config.mPositionTimerIntervalMs = 50;
        config.mClearFrameWhenStop = true;
        aliPlayerCreateAliPlayer.setConfig(config);
        aliPlayerCreateAliPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FILL);
        aliPlayerCreateAliPlayer.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.zj.adlib.dd0
            @Override // com.aliyun.player.IPlayer.OnErrorListener
            public final void onError(ErrorInfo errorInfo) {
                jd0.m(errorInfo);
            }
        });
        aliPlayerCreateAliPlayer.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.zj.adlib.ed0
            @Override // com.aliyun.player.IPlayer.OnPreparedListener
            public final void onPrepared() {
                jd0.n(this.f41407a);
            }
        });
        aliPlayerCreateAliPlayer.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.zj.adlib.fd0
            @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(int i, int i2) {
                jd0.o(this.f41645a, i, i2);
            }
        });
        aliPlayerCreateAliPlayer.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.zj.adlib.gd0
            @Override // com.aliyun.player.IPlayer.OnStateChangedListener
            public final void onStateChanged(int i) {
                jd0.p(this.f41874a, i);
            }
        });
        aliPlayerCreateAliPlayer.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.zj.adlib.hd0
            @Override // com.aliyun.player.IPlayer.OnInfoListener
            public final void onInfo(InfoBean infoBean) {
                jd0.q(this.f42100a, infoBean);
            }
        });
        aliPlayerCreateAliPlayer.setOnLoadingStatusListener(new b());
        aliPlayerCreateAliPlayer.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.zj.adlib.id0
            @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
            public final void onRenderingStart() {
                jd0.r(this.f42329a);
            }
        });
        this.aliPlayer = aliPlayerCreateAliPlayer;
    }

    public final void s(Context context) {
        AttentionVideoTextureView attentionVideoTextureView = new AttentionVideoTextureView(context);
        this.mTextureView = attentionVideoTextureView;
        attentionVideoTextureView.setSurfaceTextureListener(new c());
    }

    public final boolean t() {
        return this.isPlaying.get();
    }

    public final void u() {
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        AliPlayer aliPlayer2 = this.aliPlayer;
        if (aliPlayer2 != null) {
            aliPlayer2.release();
        }
        AliPlayer aliPlayer3 = this.aliPlayer;
        if (aliPlayer3 != null) {
            aliPlayer3.setSurface(null);
        }
        this.aliPlayer = null;
        AttentionVideoTextureView attentionVideoTextureView = this.mTextureView;
        if (attentionVideoTextureView == null || attentionVideoTextureView.getParent() == null) {
            return;
        }
        ViewParent parent = attentionVideoTextureView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(attentionVideoTextureView);
    }

    public final void v() {
        this.isPlaying.set(false);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
    }

    public final void w(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        z(url);
        B();
    }

    public final void x() {
        this.isPlaying.set(true);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
    }

    public final void y(@NotNull OnPlayerCallback callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        this.mCallback = callback;
    }

    public final void z(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.isPlaying.set(false);
        A(true);
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(url);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
    }
}
