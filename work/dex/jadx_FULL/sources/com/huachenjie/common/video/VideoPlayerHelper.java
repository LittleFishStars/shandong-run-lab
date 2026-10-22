package com.huachenjie.common.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
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
import com.huachenjie.common.video.VideoPlayerHelper;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010'¨\u0006+"}, d2 = {"Lcom/huachenjie/common/video/VideoPlayerHelper;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Landroid/view/TextureView;", "textureView", "", "j", "Lcom/huachenjie/common/video/OnPlayerCallback;", RenderCallContext.TYPE_CALLBACK, j.o, "", "url", "u", "t", "w", "B", "", "duration", "y", "v", "", "show", "A", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "onPause", "onDestroy", "mTextureView", "r", "k", "Lcom/aliyun/player/AliPlayer;", "a", "Lcom/aliyun/player/AliPlayer;", "aliPlayer", "Lcom/huachenjie/common/video/OnPlayerCallback;", "mCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPlaying", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class VideoPlayerHelper implements DefaultLifecycleObserver {
    public static final int K = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AliPlayer aliPlayer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnPlayerCallback mCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean isPlaying = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/common/video/VideoPlayerHelper$b", "Lcom/aliyun/player/IPlayer$OnLoadingStatusListener;", "", "onLoadingBegin", "", "percent", "", "netSpeed", "onLoadingProgress", "onLoadingEnd", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements IPlayer.OnLoadingStatusListener {
        public b() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            OnPlayerCallback onPlayerCallback = VideoPlayerHelper.this.mCallback;
            if (onPlayerCallback != null) {
                onPlayerCallback.onLoadingChanged(true);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            OnPlayerCallback onPlayerCallback = VideoPlayerHelper.this.mCallback;
            if (onPlayerCallback != null) {
                onPlayerCallback.onLoadingChanged(false);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int percent, float netSpeed) {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"com/huachenjie/common/video/VideoPlayerHelper$c", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliPlayer aliPlayer = VideoPlayerHelper.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.setSurface(new Surface(surface));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliPlayer aliPlayer = VideoPlayerHelper.this.aliPlayer;
            if (aliPlayer == null) {
                return false;
            }
            aliPlayer.setSurface(null);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliPlayer aliPlayer = VideoPlayerHelper.this.aliPlayer;
            if (aliPlayer != null) {
                aliPlayer.surfaceChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public static final void l(ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, MyLocationStyle.ERROR_INFO);
        i4a.a("errorInfo:" + errorInfo.getCode());
        i4a.a("errorInfo:" + errorInfo.getMsg());
        fv5.b("视频播放出错");
    }

    public static final void m(VideoPlayerHelper videoPlayerHelper) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
        i4a.a("OnPrepared");
        AliPlayer aliPlayer = videoPlayerHelper.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        OnPlayerCallback onPlayerCallback = videoPlayerHelper.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.a(videoPlayerHelper.aliPlayer);
        }
    }

    public static final void n(VideoPlayerHelper videoPlayerHelper, int i, int i2) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
        if (i == 0 && i2 == 0) {
            return;
        }
        i4a.a("setOnVideoSizeChanged(" + i + "," + i2 + ")");
        OnPlayerCallback onPlayerCallback = videoPlayerHelper.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.d(i, i2);
        }
    }

    public static final void o(VideoPlayerHelper videoPlayerHelper, int i) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
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
                OnPlayerCallback onPlayerCallback = videoPlayerHelper.mCallback;
                if (onPlayerCallback != null) {
                    onPlayerCallback.a(videoPlayerHelper.aliPlayer);
                }
                break;
            case 3:
                i4a.a("started");
                OnPlayerCallback onPlayerCallback2 = videoPlayerHelper.mCallback;
                if (onPlayerCallback2 != null) {
                    onPlayerCallback2.c(true);
                }
                break;
            case 4:
                i4a.a("paused");
                OnPlayerCallback onPlayerCallback3 = videoPlayerHelper.mCallback;
                if (onPlayerCallback3 != null) {
                    onPlayerCallback3.c(false);
                }
                break;
            case 5:
                i4a.a("stopped");
                break;
            case 6:
                i4a.a("completion");
                break;
            case 7:
                i4a.a("error");
                break;
        }
    }

    public static final void p(VideoPlayerHelper videoPlayerHelper, InfoBean infoBean) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
        Intrinsics.checkNotNullParameter(infoBean, "infoBean");
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            OnPlayerCallback onPlayerCallback = videoPlayerHelper.mCallback;
            if (onPlayerCallback != null) {
                AliPlayer aliPlayer = videoPlayerHelper.aliPlayer;
                onPlayerCallback.onProgressChanged(extraValue, aliPlayer != null ? aliPlayer.getDuration() : 0L);
            }
        }
    }

    public static final void q(VideoPlayerHelper videoPlayerHelper) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
        i4a.a("onRenderingStart");
        OnPlayerCallback onPlayerCallback = videoPlayerHelper.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.onLoadingChanged(false);
        }
        videoPlayerHelper.A(false);
    }

    public static final void s(VideoPlayerHelper videoPlayerHelper, View view) {
        Intrinsics.checkNotNullParameter(videoPlayerHelper, "this$0");
        if (videoPlayerHelper.isPlaying.get()) {
            videoPlayerHelper.t();
        } else {
            videoPlayerHelper.w();
        }
    }

    public final void A(boolean show) {
        i4a.a("showVideoCover:" + show);
        OnPlayerCallback onPlayerCallback = this.mCallback;
        if (onPlayerCallback != null) {
            onPlayerCallback.b(show);
        }
    }

    public final void B() {
        i4a.a("stopPlay");
        this.isPlaying.set(false);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        AliPlayer aliPlayer2 = this.aliPlayer;
        if (aliPlayer2 != null) {
            aliPlayer2.setSurface(null);
        }
    }

    public final void j(@NotNull Context context, @NotNull TextureView textureView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        k(applicationContext);
        r(textureView);
    }

    public final void k(Context context) {
        AliPlayerGlobalSettings.enableLocalCache(true, 0, context.getCacheDir().getAbsolutePath() + "/video");
        AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(context);
        aliPlayerCreateAliPlayer.setTraceId("DisableAnalytics");
        aliPlayerCreateAliPlayer.setAutoPlay(false);
        aliPlayerCreateAliPlayer.setLoop(true);
        PlayerConfig config = aliPlayerCreateAliPlayer.getConfig();
        config.mPositionTimerIntervalMs = 50;
        config.mClearFrameWhenStop = true;
        aliPlayerCreateAliPlayer.setConfig(config);
        aliPlayerCreateAliPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
        aliPlayerCreateAliPlayer.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.zj.adlib.ao9
            @Override // com.aliyun.player.IPlayer.OnErrorListener
            public final void onError(ErrorInfo errorInfo) {
                VideoPlayerHelper.l(errorInfo);
            }
        });
        aliPlayerCreateAliPlayer.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.zj.adlib.bo9
            @Override // com.aliyun.player.IPlayer.OnPreparedListener
            public final void onPrepared() {
                VideoPlayerHelper.m(this.f40797a);
            }
        });
        aliPlayerCreateAliPlayer.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.zj.adlib.co9
            @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(int i, int i2) {
                VideoPlayerHelper.n(this.f41012a, i, i2);
            }
        });
        aliPlayerCreateAliPlayer.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.zj.adlib.do9
            @Override // com.aliyun.player.IPlayer.OnStateChangedListener
            public final void onStateChanged(int i) {
                VideoPlayerHelper.o(this.f41240a, i);
            }
        });
        aliPlayerCreateAliPlayer.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.zj.adlib.eo9
            @Override // com.aliyun.player.IPlayer.OnInfoListener
            public final void onInfo(InfoBean infoBean) {
                VideoPlayerHelper.p(this.f41483a, infoBean);
            }
        });
        aliPlayerCreateAliPlayer.setOnLoadingStatusListener(new b());
        aliPlayerCreateAliPlayer.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.zj.adlib.fo9
            @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
            public final void onRenderingStart() {
                VideoPlayerHelper.q(this.f41721a);
            }
        });
        this.aliPlayer = aliPlayerCreateAliPlayer;
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        v();
        owner.getLifecycle().removeObserver(this);
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        t();
        super.onPause(owner);
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        w();
    }

    public final void r(TextureView mTextureView) {
        mTextureView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zn9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerHelper.s(this.f46304a, view);
            }
        });
        mTextureView.setSurfaceTextureListener(new c());
    }

    public final void t() {
        this.isPlaying.set(false);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
    }

    public final void u(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.isPlaying.set(false);
        A(true);
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(url);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
        AliPlayer aliPlayer2 = this.aliPlayer;
        if (aliPlayer2 != null) {
            aliPlayer2.prepare();
        }
    }

    public final void v() {
        B();
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.release();
        }
        this.aliPlayer = null;
    }

    public final void w() {
        this.isPlaying.set(true);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
    }

    public final void y(long duration) {
        i4a.a("seekTo:" + duration);
        AliPlayer aliPlayer = this.aliPlayer;
        if (aliPlayer != null) {
            aliPlayer.seekTo(duration, IPlayer.SeekMode.Accurate);
        }
    }

    public final void z(@NotNull OnPlayerCallback callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        this.mCallback = callback;
    }
}
