package com.huachenjie.works.page.details.video.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
import com.aliyun.player.AliListPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.amap.api.maps.model.MyLocationStyle;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.video.player.VideoListPlayer;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.m55;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000eR\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00103R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010FR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010JR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010J¨\u0006O"}, d2 = {"Lcom/huachenjie/works/page/details/video/player/VideoListPlayer;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "", "D", "B", "t", "I", "Landroid/widget/TextView;", "textView", "", "time", "L", "", "show", "N", "Landroid/view/View;", "container", "M", "Landroid/view/ViewGroup;", "parent", "", "viewId", "r", "s", "", "url", "p", "outsideContainer", "H", "G", "O", "duration", "K", "F", "E", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "onPause", "onDestroy", "", "scale", "J", "fullScreen", "q", "Lcom/aliyun/player/AliListPlayer;", "a", "Lcom/aliyun/player/AliListPlayer;", "aliListPlayer", "Landroid/view/View;", "mContainer", "Landroid/view/TextureView;", "Landroid/view/TextureView;", "mTextureView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mPlayIconImageView", "b", "loadingView", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "videoProgress", "Landroid/widget/SeekBar;", "Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "llTimeContainer", "Landroid/widget/TextView;", "tvCurrentPlayTime", "tvVideoDuration", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPlaying", "onFullScreen", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class VideoListPlayer implements DefaultLifecycleObserver {
    public static final int K = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public TextureView mTextureView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public View mContainer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ImageView mPlayIconImageView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public LinearLayout llTimeContainer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ProgressBar videoProgress;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SeekBar seekBar;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public TextView tvCurrentPlayTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AliListPlayer aliListPlayer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public View loadingView;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public TextView tvVideoDuration;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean isPlaying = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean onFullScreen = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/details/video/player/VideoListPlayer$b", "Lcom/aliyun/player/IPlayer$OnLoadingStatusListener;", "", "onLoadingBegin", "", "percent", "", "netSpeed", "onLoadingProgress", "onLoadingEnd", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements IPlayer.OnLoadingStatusListener {
        public b() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            View view = VideoListPlayer.this.loadingView;
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            View view = VideoListPlayer.this.loadingView;
            Intrinsics.checkNotNull(view);
            view.setVisibility(8);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int percent, float netSpeed) {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"com/huachenjie/works/page/details/video/player/VideoListPlayer$c", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliListPlayer aliListPlayer = VideoListPlayer.this.aliListPlayer;
            if (aliListPlayer != null) {
                aliListPlayer.setSurface(new Surface(surface));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliListPlayer aliListPlayer = VideoListPlayer.this.aliListPlayer;
            if (aliListPlayer == null) {
                return false;
            }
            aliListPlayer.setSurface(null);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            AliListPlayer aliListPlayer = VideoListPlayer.this.aliListPlayer;
            if (aliListPlayer != null) {
                aliListPlayer.surfaceChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/works/page/details/video/player/VideoListPlayer$d", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements SeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                VideoListPlayer videoListPlayer = VideoListPlayer.this;
                videoListPlayer.L(videoListPlayer.tvCurrentPlayTime, progress * 50);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.setAlpha(1.0f);
            VideoListPlayer videoListPlayer = VideoListPlayer.this;
            videoListPlayer.L(videoListPlayer.tvCurrentPlayTime, seekBar.getProgress() * 50);
            LinearLayout linearLayout = VideoListPlayer.this.llTimeContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ProgressBar progressBar = VideoListPlayer.this.videoProgress;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            VideoListPlayer.this.N(false);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.setAlpha(0.0f);
            LinearLayout linearLayout = VideoListPlayer.this.llTimeContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ProgressBar progressBar = VideoListPlayer.this.videoProgress;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            if (!VideoListPlayer.this.onFullScreen.get()) {
                VideoListPlayer.this.N(true);
            }
            VideoListPlayer.this.K(seekBar.getProgress() * 50);
        }
    }

    public static final void A(VideoListPlayer videoListPlayer, int i) {
        Intrinsics.checkNotNullParameter(videoListPlayer, "this$0");
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
                break;
            case 3:
                i4a.a("started");
                videoListPlayer.isPlaying.set(false);
                break;
            case 4:
                i4a.a("paused");
                videoListPlayer.isPlaying.set(false);
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

    public static final void C(VideoListPlayer videoListPlayer, View view) {
        Intrinsics.checkNotNullParameter(videoListPlayer, "this$0");
        if (videoListPlayer.isPlaying.get()) {
            videoListPlayer.G();
        } else {
            videoListPlayer.I();
        }
    }

    public static final void u(ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, MyLocationStyle.ERROR_INFO);
        i4a.a("OnError");
        i4a.a("errorInfo:" + errorInfo.getCode());
        i4a.a("errorInfo:" + errorInfo.getMsg());
        fv5.b("视频播放出错");
    }

    public static final void v(VideoListPlayer videoListPlayer) {
        Intrinsics.checkNotNullParameter(videoListPlayer, "this$0");
        i4a.a("OnPrepared");
        AliListPlayer aliListPlayer = videoListPlayer.aliListPlayer;
        if (aliListPlayer != null) {
            Intrinsics.checkNotNull(aliListPlayer);
            aliListPlayer.start();
            ProgressBar progressBar = videoListPlayer.videoProgress;
            Intrinsics.checkNotNull(progressBar);
            AliListPlayer aliListPlayer2 = videoListPlayer.aliListPlayer;
            Intrinsics.checkNotNull(aliListPlayer2);
            long j = 50;
            progressBar.setMax((int) (aliListPlayer2.getDuration() / j));
            SeekBar seekBar = videoListPlayer.seekBar;
            Intrinsics.checkNotNull(seekBar);
            AliListPlayer aliListPlayer3 = videoListPlayer.aliListPlayer;
            Intrinsics.checkNotNull(aliListPlayer3);
            seekBar.setMax((int) (aliListPlayer3.getDuration() / j));
            TextView textView = videoListPlayer.tvVideoDuration;
            AliListPlayer aliListPlayer4 = videoListPlayer.aliListPlayer;
            Intrinsics.checkNotNull(aliListPlayer4);
            videoListPlayer.L(textView, aliListPlayer4.getDuration());
        }
    }

    public static final void w(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        i4a.a("setOnVideoSizeChanged(" + i + ',' + i2 + ')');
    }

    public static final void y(VideoListPlayer videoListPlayer, InfoBean infoBean) {
        Intrinsics.checkNotNullParameter(videoListPlayer, "this$0");
        Intrinsics.checkNotNullParameter(infoBean, "infoBean");
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            ProgressBar progressBar = videoListPlayer.videoProgress;
            Intrinsics.checkNotNull(progressBar);
            progressBar.setProgress((int) (extraValue / ((long) 50)));
        }
    }

    public static final void z(VideoListPlayer videoListPlayer) {
        Intrinsics.checkNotNullParameter(videoListPlayer, "this$0");
        i4a.a("onRenderingStart");
        View view = videoListPlayer.loadingView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
        View view2 = videoListPlayer.mContainer;
        if (view2 != null) {
            Intrinsics.checkNotNull(view2);
            if (view2.getParent() != null) {
                View view3 = videoListPlayer.mContainer;
                Intrinsics.checkNotNull(view3);
                Object parent = view3.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                videoListPlayer.M(false, (View) parent);
            }
        }
    }

    public final void B() {
        TextureView textureView = this.mTextureView;
        if (textureView == null) {
            return;
        }
        textureView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vn9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoListPlayer.C(this.f45395a, view);
            }
        });
        textureView.setSurfaceTextureListener(new c());
    }

    public final void D(Context context) {
        View view = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.works_layout_work_video_palyer, (ViewGroup) null, false);
        if (viewInflate != null) {
            this.mTextureView = (TextureView) viewInflate.findViewById(R.id.worksTextureView);
            this.mPlayIconImageView = (ImageView) viewInflate.findViewById(R.id.ivPlayButton);
            this.loadingView = viewInflate.findViewById(R.id.loadingLine);
            this.videoProgress = (ProgressBar) viewInflate.findViewById(R.id.pb_video_progress);
            this.seekBar = (SeekBar) viewInflate.findViewById(R.id.sb_video_seek);
            this.llTimeContainer = (LinearLayout) viewInflate.findViewById(R.id.llTimeContainer);
            this.tvCurrentPlayTime = (TextView) viewInflate.findViewById(R.id.tvCurrentPlayTime);
            this.tvVideoDuration = (TextView) viewInflate.findViewById(R.id.tvVideoDuration);
            view = viewInflate;
        }
        this.mContainer = view;
        SeekBar seekBar = this.seekBar;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new d());
        }
    }

    public final void E() {
        View view = this.mContainer;
        if (view == null) {
            i4a.a("mContainer is null");
            return;
        }
        Intrinsics.checkNotNull(view);
        if (view.getParent() == null) {
            i4a.a("parent is null");
            return;
        }
        i4a.a("isPlaying:" + this.isPlaying.get());
        G();
    }

    public final void F() {
        View view = this.mContainer;
        if (view == null) {
            i4a.a("mContainer is null");
            return;
        }
        Intrinsics.checkNotNull(view);
        if (view.getParent() == null) {
            i4a.a("parent is null");
            return;
        }
        i4a.a("isPlaying:" + this.isPlaying.get());
        I();
    }

    public final void G() {
        this.isPlaying.set(false);
        ImageView imageView = this.mPlayIconImageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        AliListPlayer aliListPlayer = this.aliListPlayer;
        if (aliListPlayer != null) {
            aliListPlayer.pause();
        }
    }

    public final void H(@Nullable String url, @Nullable ViewGroup outsideContainer) {
        if (outsideContainer == null) {
            i4a.a("outsideContainer is null");
            return;
        }
        if (this.aliListPlayer == null) {
            i4a.a("aliListPlayer is null");
            i4a.a("initPlayer");
            Context context = outsideContainer.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "outsideContainer.context");
            t(context);
        } else {
            i4a.a("aliListPlayer is not null");
        }
        if (this.mContainer == null) {
            i4a.a("mContainer is null");
            i4a.a("initView");
            Context context2 = outsideContainer.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "outsideContainer.context");
            D(context2);
        }
        View view = this.mContainer;
        Intrinsics.checkNotNull(view);
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            i4a.a("parent is null or is not ViewGroup");
        } else {
            i4a.a("remove mContainer");
            ((ViewGroup) parent).removeView(this.mContainer);
        }
        i4a.a("add mContainer");
        outsideContainer.addView(this.mContainer, 0);
        LinearLayout linearLayout = this.llTimeContainer;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        SeekBar seekBar = this.seekBar;
        Intrinsics.checkNotNull(seekBar);
        seekBar.setAlpha(0.0f);
        i4a.a("play ->");
        i4a.a(url);
        M(true, outsideContainer);
        SeekBar seekBar2 = this.seekBar;
        Intrinsics.checkNotNull(seekBar2);
        seekBar2.setProgress(0);
        ProgressBar progressBar = this.videoProgress;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setProgress(0);
        View view2 = this.loadingView;
        Intrinsics.checkNotNull(view2);
        view2.setVisibility(0);
        ImageView imageView = this.mPlayIconImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        AliListPlayer aliListPlayer = this.aliListPlayer;
        Intrinsics.checkNotNull(aliListPlayer);
        aliListPlayer.moveTo(m55.c(url));
    }

    public final void I() {
        this.isPlaying.set(true);
        ImageView imageView = this.mPlayIconImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AliListPlayer aliListPlayer = this.aliListPlayer;
        if (aliListPlayer != null) {
            aliListPlayer.start();
        }
    }

    public final void J(float scale, @Nullable View container) {
        if (container == null || !(container instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) container;
        viewGroup.setScaleX(scale);
        viewGroup.setScaleY(scale);
    }

    public final void K(long duration) {
        AliListPlayer aliListPlayer = this.aliListPlayer;
        if (aliListPlayer != null) {
            aliListPlayer.seekTo(duration, IPlayer.SeekMode.Accurate);
        }
    }

    public final void L(TextView textView, long time) {
        String strValueOf;
        String strValueOf2;
        if (textView == null) {
            return;
        }
        long j = time / ((long) 1000);
        long j2 = 60;
        long j3 = j / j2;
        long j4 = j % j2;
        if (j3 > 9) {
            strValueOf = String.valueOf(j3);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            strValueOf = String.format("0%d", Arrays.copyOf(new Object[]{Long.valueOf(j3)}, 1));
            Intrinsics.checkNotNullExpressionValue(strValueOf, "format(format, *args)");
        }
        if (j4 > 9) {
            strValueOf2 = String.valueOf(j4);
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            strValueOf2 = String.format("0%d", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
            Intrinsics.checkNotNullExpressionValue(strValueOf2, "format(format, *args)");
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str = String.format("%s:%s", Arrays.copyOf(new Object[]{strValueOf, strValueOf2}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
    }

    public final void M(boolean show, View container) {
        i4a.a("showVideoCover:" + show);
        if (container == null || !(container instanceof ViewGroup)) {
            i4a.a("coverImage container is null");
            return;
        }
        View viewFindViewById = ((ViewGroup) container).findViewById(R.id.video_cover);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(show ? 0 : 8);
        } else {
            i4a.a("coverImage is null");
        }
    }

    public final void N(boolean show) {
        View view = this.mContainer;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return;
        }
        r((ViewGroup) parent, R.id.vBottomContainer, show);
    }

    public final void O() {
        i4a.a("stopPlay");
        View view = this.mContainer;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            Object parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                M(true, (View) parent);
                ((FrameLayout) parent).removeView(this.mContainer);
            }
        }
        if (this.aliListPlayer != null) {
            this.isPlaying.set(false);
            AliListPlayer aliListPlayer = this.aliListPlayer;
            Intrinsics.checkNotNull(aliListPlayer);
            aliListPlayer.stop();
            AliListPlayer aliListPlayer2 = this.aliListPlayer;
            Intrinsics.checkNotNull(aliListPlayer2);
            aliListPlayer2.setSurface(null);
        }
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        AliListPlayer aliListPlayer = this.aliListPlayer;
        if (aliListPlayer != null) {
            aliListPlayer.stop();
        }
        AliListPlayer aliListPlayer2 = this.aliListPlayer;
        if (aliListPlayer2 != null) {
            aliListPlayer2.release();
        }
        this.aliListPlayer = null;
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        E();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        F();
    }

    public final void p(@Nullable String url) {
        i4a.a("addUrl:" + url);
        AliListPlayer aliListPlayer = this.aliListPlayer;
        if (aliListPlayer != null) {
            aliListPlayer.addUrl(url, m55.c(url));
        }
    }

    public final void q(boolean fullScreen) {
        this.onFullScreen.set(fullScreen);
    }

    public final void r(ViewGroup parent, int viewId, boolean show) {
        View viewFindViewById = parent.findViewById(viewId);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(show ? 0 : 8);
        }
    }

    public final void s(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        D(context);
        B();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        t(applicationContext);
    }

    public final void t(Context context) {
        AliPlayerGlobalSettings.enableLocalCache(true, 0, context.getCacheDir().getAbsolutePath() + "/video");
        AliListPlayer aliListPlayerCreateAliListPlayer = AliPlayerFactory.createAliListPlayer(context);
        if (aliListPlayerCreateAliListPlayer != null) {
            aliListPlayerCreateAliListPlayer.setTraceId("DisableAnalytics");
            aliListPlayerCreateAliListPlayer.setPreloadCount(2);
            aliListPlayerCreateAliListPlayer.setAutoPlay(false);
            aliListPlayerCreateAliListPlayer.setLoop(true);
            PlayerConfig config = aliListPlayerCreateAliListPlayer.getConfig();
            config.mPositionTimerIntervalMs = 50;
            config.mClearFrameWhenStop = true;
            aliListPlayerCreateAliListPlayer.setConfig(config);
            aliListPlayerCreateAliListPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
            aliListPlayerCreateAliListPlayer.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.zj.adlib.pn9
                @Override // com.aliyun.player.IPlayer.OnErrorListener
                public final void onError(ErrorInfo errorInfo) {
                    VideoListPlayer.u(errorInfo);
                }
            });
            aliListPlayerCreateAliListPlayer.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.zj.adlib.qn9
                @Override // com.aliyun.player.IPlayer.OnPreparedListener
                public final void onPrepared() {
                    VideoListPlayer.v(this.f44250a);
                }
            });
            aliListPlayerCreateAliListPlayer.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.zj.adlib.rn9
                @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(int i, int i2) {
                    VideoListPlayer.w(i, i2);
                }
            });
            aliListPlayerCreateAliListPlayer.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.zj.adlib.sn9
                @Override // com.aliyun.player.IPlayer.OnInfoListener
                public final void onInfo(InfoBean infoBean) {
                    VideoListPlayer.y(this.f44725a, infoBean);
                }
            });
            aliListPlayerCreateAliListPlayer.setOnLoadingStatusListener(new b());
            aliListPlayerCreateAliListPlayer.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.zj.adlib.tn9
                @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
                public final void onRenderingStart() {
                    VideoListPlayer.z(this.f44966a);
                }
            });
            aliListPlayerCreateAliListPlayer.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.zj.adlib.un9
                @Override // com.aliyun.player.IPlayer.OnStateChangedListener
                public final void onStateChanged(int i) {
                    VideoListPlayer.A(this.f45189a, i);
                }
            });
        } else {
            aliListPlayerCreateAliListPlayer = null;
        }
        this.aliListPlayer = aliListPlayerCreateAliListPlayer;
    }
}
