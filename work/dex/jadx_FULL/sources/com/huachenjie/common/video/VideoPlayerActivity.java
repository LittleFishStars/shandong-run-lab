package com.huachenjie.common.video;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.player.AliPlayer;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.huachenjie.common.databinding.ActivityVideoPlayerBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.LoadingLineView;
import com.zj.adlib.i4a;
import com.zj.adlib.io9;
import com.zj.adlib.vk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0016\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u0011B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/common/video/VideoPlayerActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/common/databinding/ActivityVideoPlayerBinding;", "Lcom/huachenjie/common/video/VideoPlayerVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "Lcom/huachenjie/common/video/VideoPlayerHelper;", "a", "Lcom/huachenjie/common/video/VideoPlayerHelper;", "videoPlayer", "", "b", "Lkotlin/Lazy;", "b0", "()Ljava/lang/String;", VideoPlayerActivity.t, "com/huachenjie/common/video/VideoPlayerActivity$d", "Lcom/huachenjie/common/video/VideoPlayerActivity$d;", "videoPlayerCallback", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class VideoPlayerActivity extends BaseMVVMActivity<ActivityVideoPlayerBinding, VideoPlayerVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "videoUrl";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final VideoPlayerHelper videoPlayer = new VideoPlayerHelper();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy videoUrl = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.common.video.VideoPlayerActivity$videoUrl$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(VideoPlayerActivity.t)) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final d videoPlayerCallback = new d();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/video/VideoPlayerActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/common/video/VideoPlayerActivity;)V", "common_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoPlayerActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.common.video.VideoPlayerActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/video/VideoPlayerActivity$b;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "VIDEO_URL", "Ljava/lang/String;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) VideoPlayerActivity.class);
            intent.putExtra(VideoPlayerActivity.t, url);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/common/video/VideoPlayerActivity$c", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityVideoPlayerBinding f33960a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ VideoPlayerActivity f8966a;

        public c(ActivityVideoPlayerBinding activityVideoPlayerBinding, VideoPlayerActivity videoPlayerActivity) {
            this.f33960a = activityVideoPlayerBinding;
            this.f8966a = videoPlayerActivity;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                io9.a(this.f33960a.f8581a, progress);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.setAlpha(1.0f);
            io9.a(this.f33960a.f8581a, seekBar.getProgress());
            this.f33960a.f8578a.setVisibility(0);
            this.f33960a.f8579a.setVisibility(8);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            seekBar.setAlpha(0.0f);
            this.f33960a.f8578a.setVisibility(8);
            this.f33960a.f8579a.setVisibility(0);
            this.f8966a.videoPlayer.y(seekBar.getProgress());
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¨\u0006\u0015"}, d2 = {"com/huachenjie/common/video/VideoPlayerActivity$d", "Lcom/huachenjie/common/video/OnPlayerCallback;", "Lcom/aliyun/player/AliPlayer;", "aliPlayer", "", "a", "", "width", "height", "d", "", "progress", "totalProgress", "onProgressChanged", "", RVParams.LONG_SHOW_LOADING, "onLoadingChanged", "showCover", "b", "isPlaying", "c", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements OnPlayerCallback {
        public d() {
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void a(@Nullable AliPlayer aliPlayer) {
            if (aliPlayer != null) {
                VideoPlayerActivity videoPlayerActivity = VideoPlayerActivity.this;
                i4a.a("onPrepared: " + aliPlayer.getDuration());
                VideoPlayerActivity.Z(videoPlayerActivity).f8579a.setMax((int) aliPlayer.getDuration());
                VideoPlayerActivity.Z(videoPlayerActivity).f8580a.setMax((int) aliPlayer.getDuration());
                io9.a(VideoPlayerActivity.Z(videoPlayerActivity).b, aliPlayer.getDuration());
            }
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void b(boolean showCover) {
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void c(boolean isPlaying) {
            ActivityVideoPlayerBinding activityVideoPlayerBindingZ = VideoPlayerActivity.Z(VideoPlayerActivity.this);
            ImageView imageView = activityVideoPlayerBindingZ != null ? activityVideoPlayerBindingZ.f33742a : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(isPlaying ? 8 : 0);
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void d(int width, int height) {
            VideoTextureView videoTextureView;
            ActivityVideoPlayerBinding activityVideoPlayerBindingZ = VideoPlayerActivity.Z(VideoPlayerActivity.this);
            if (activityVideoPlayerBindingZ == null || (videoTextureView = activityVideoPlayerBindingZ.f8584a) == null) {
                return;
            }
            videoTextureView.setVideoSize(width, height);
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void onLoadingChanged(boolean showLoading) {
            ActivityVideoPlayerBinding activityVideoPlayerBindingZ = VideoPlayerActivity.Z(VideoPlayerActivity.this);
            LoadingLineView loadingLineView = activityVideoPlayerBindingZ != null ? activityVideoPlayerBindingZ.f8585a : null;
            if (loadingLineView == null) {
                return;
            }
            loadingLineView.setVisibility(showLoading ? 0 : 8);
        }

        @Override // com.huachenjie.common.video.OnPlayerCallback
        public void onProgressChanged(long progress, long totalProgress) {
            VideoPlayerActivity.Z(VideoPlayerActivity.this).f8579a.setProgress((int) progress);
        }
    }

    public static final /* synthetic */ ActivityVideoPlayerBinding Z(VideoPlayerActivity videoPlayerActivity) {
        return videoPlayerActivity.getMBinding();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.black).G1(false).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(vk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(vk0.k), new a())});
    }

    public final String b0() {
        return (String) this.videoUrl.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_video_player;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ActivityVideoPlayerBinding mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        VideoPlayerHelper videoPlayerHelper = this.videoPlayer;
        VideoTextureView videoTextureView = mBinding.f8584a;
        Intrinsics.checkNotNullExpressionValue(videoTextureView, "binding.videoTextureView");
        videoPlayerHelper.j(this, videoTextureView);
        this.videoPlayer.z(this.videoPlayerCallback);
        getLifecycle().addObserver(this.videoPlayer);
        mBinding.f8580a.setOnSeekBarChangeListener(new c(mBinding, this));
        VideoPlayerHelper videoPlayerHelper2 = this.videoPlayer;
        String strB0 = b0();
        Intrinsics.checkNotNullExpressionValue(strB0, t);
        videoPlayerHelper2.u(strB0);
    }
}
