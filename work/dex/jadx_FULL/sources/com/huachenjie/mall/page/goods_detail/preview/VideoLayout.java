package com.huachenjie.mall.page.goods_detail.preview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.net.c;
import com.gyf.immersionbar.e;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.preview.VideoLayout;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\r¢\u0006\u0004\bQ\u0010RJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J4\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\b\u0010 \u001a\u00020\u0003H\u0014J\b\u0010!\u001a\u00020\u0003H\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010$R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010*\u001a\u0004\b+\u0010,R\u001b\u00101\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010*\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010*\u001a\u0004\b3\u00100R\u001b\u00106\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b5\u00100R\u001b\u0010:\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010*\u001a\u0004\b=\u0010>R\u001b\u0010C\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010*\u001a\u0004\bF\u0010GR\u001b\u0010K\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010*\u001a\u0004\bJ\u0010G¨\u0006S"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/VideoLayout;", "Landroid/widget/RelativeLayout;", "Lcom/huachenjie/mall/page/goods_detail/preview/PlayerStatusListener;", "", "e", "k", "", "isFullScreen", y6b.f, "", "milliseconds", "", "d", "", "j", t.d, "coverUrl", "Lkotlin/Function1;", "onItemClickListener", "position", "initData", "onShowCover", "onHideCover", "duration", "total", "onProgressChanged", "autoPlay", "showCover", "bindTextureView", "rebindTextureView", "resume", "pause", "onAttachedToWindow", "onDetachedFromWindow", "a", "Z", "Lkotlin/jvm/functions/Function1;", "K", "I", "b", "isDragEnable", "Landroid/view/TextureView;", "Lkotlin/Lazy;", "getTextureView", "()Landroid/view/TextureView;", "textureView", "Landroid/widget/ImageView;", "getSoundView", "()Landroid/widget/ImageView;", "soundView", "c", "getThumbnailView", "thumbnailView", "getPlayButton", "playButton", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/ProgressBar;", "f", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar", "Landroid/view/View;", "getLineView", "()Landroid/view/View;", "lineView", "Landroid/widget/TextView;", y6b.g, "getDurationTotalView", "()Landroid/widget/TextView;", "durationTotalView", "i", "getProgressView", "progressView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"SetTextI18n"})
public final class VideoLayout extends RelativeLayout implements PlayerStatusListener {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int position;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy textureView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> onItemClickListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isFullScreen;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy soundView;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean isDragEnable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy thumbnailView;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy playButton;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy seekBar;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy progressBar;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy lineView;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy durationTotalView;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final Lazy progressView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VideoLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void f(VideoLayout videoLayout, View view) {
        Intrinsics.checkNotNullParameter(videoLayout, "this$0");
        if (videoLayout.getThumbnailView().getVisibility() == 0) {
            PlayerManager.INSTANCE.a().y(false);
            return;
        }
        Function1<? super Integer, Unit> function1 = videoLayout.onItemClickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(videoLayout.position));
        }
        videoLayout.k();
    }

    private final TextView getDurationTotalView() {
        return (TextView) this.durationTotalView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getLineView() {
        return (View) this.lineView.getValue();
    }

    private final ImageView getPlayButton() {
        return (ImageView) this.playButton.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProgressBar getProgressBar() {
        return (ProgressBar) this.progressBar.getValue();
    }

    private final TextView getProgressView() {
        return (TextView) this.progressView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SeekBar getSeekBar() {
        return (SeekBar) this.seekBar.getValue();
    }

    private final ImageView getSoundView() {
        return (ImageView) this.soundView.getValue();
    }

    private final TextureView getTextureView() {
        return (TextureView) this.textureView.getValue();
    }

    private final ImageView getThumbnailView() {
        return (ImageView) this.thumbnailView.getValue();
    }

    public static final void h(VideoLayout videoLayout, View view) {
        Intrinsics.checkNotNullParameter(videoLayout, "this$0");
        PlayerManager.Companion companion = PlayerManager.INSTANCE;
        if (companion.a().q()) {
            companion.a().x(false);
            videoLayout.getSoundView().setImageResource(R.drawable.mall_ic_video_voice_gray);
        } else {
            companion.a().x(true);
            videoLayout.getSoundView().setImageResource(R.drawable.mall_ic_video_mute_gray);
        }
    }

    public static final void i(VideoLayout videoLayout, View view) {
        Intrinsics.checkNotNullParameter(videoLayout, "this$0");
        PlayerManager.Companion companion = PlayerManager.INSTANCE;
        if (companion.a().q()) {
            companion.a().x(false);
            videoLayout.getSoundView().setImageResource(R.drawable.mall_ic_video_voice);
        } else {
            companion.a().x(true);
            videoLayout.getSoundView().setImageResource(R.drawable.mall_ic_video_mute);
        }
    }

    public final void bindTextureView(boolean autoPlay, boolean showCover) {
        PlayerManager.Companion companion = PlayerManager.INSTANCE;
        companion.a().i(getTextureView(), showCover);
        if (autoPlay) {
            companion.a().y(true);
        }
        getSoundView().setImageResource(companion.a().q() ? j() : l());
    }

    public final String d(long milliseconds) {
        long j = milliseconds / ((long) 1000);
        long j2 = 60;
        long j3 = j / j2;
        long j4 = j % j2;
        StringBuilder sb = new StringBuilder();
        sb.append(j3 < 10 ? "0" : "");
        sb.append(j3);
        sb.append(c.b);
        sb.append(j4 >= 10 ? "" : "0");
        sb.append(j4);
        return sb.toString();
    }

    public final void e() {
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mn9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoLayout.f(this.f43342a, view);
            }
        });
    }

    public final void g(boolean isFullScreen) {
        if (isFullScreen) {
            getSoundView().setImageResource(R.drawable.mall_ic_video_mute_gray);
            getSoundView().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nn9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoLayout.h(this.f43568a, view);
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SizeUtils.b(36.0f), SizeUtils.b(36.0f));
            layoutParams.addRule(11);
            layoutParams.rightMargin = SizeUtils.b(16.0f);
            layoutParams.topMargin = e.J0(getContext()) + SizeUtils.b(10.0f);
            getSoundView().setLayoutParams(layoutParams);
            return;
        }
        getSoundView().setImageResource(R.drawable.mall_ic_video_mute);
        getSoundView().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.on9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoLayout.i(this.f43788a, view);
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(SizeUtils.b(32.0f), SizeUtils.b(32.0f));
        layoutParams2.addRule(12);
        layoutParams2.leftMargin = SizeUtils.b(16.0f);
        layoutParams2.bottomMargin = SizeUtils.b(12.0f);
        getSoundView().setLayoutParams(layoutParams2);
    }

    public final void initData(@NotNull String coverUrl, boolean isFullScreen, @Nullable Function1<? super Integer, Unit> onItemClickListener, int position) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.isFullScreen = isFullScreen;
        this.onItemClickListener = onItemClickListener;
        this.position = position;
        g(isFullScreen);
        Glide.with(getThumbnailView()).load(coverUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(getThumbnailView());
        if (isFullScreen) {
            getProgressBar().setVisibility(0);
        }
    }

    public final int j() {
        return this.isFullScreen ? R.drawable.mall_ic_video_mute_gray : R.drawable.mall_ic_video_mute;
    }

    public final void k() {
        ImagePreviewViewPager imagePreviewViewPager;
        if (this.isFullScreen) {
            if (this.isDragEnable) {
                this.isDragEnable = false;
                getSeekBar().setVisibility(8);
                getProgressBar().setVisibility(0);
                getDurationTotalView().setVisibility(4);
                getProgressView().setVisibility(4);
                getLineView().setVisibility(4);
                getPlayButton().setVisibility(8);
                ViewParent parent = getParent();
                imagePreviewViewPager = parent instanceof ImagePreviewViewPager ? (ImagePreviewViewPager) parent : null;
                if (imagePreviewViewPager != null) {
                    imagePreviewViewPager.setTouchEnable(true);
                    return;
                }
                return;
            }
            this.isDragEnable = true;
            getSeekBar().setVisibility(0);
            getProgressBar().setVisibility(8);
            getDurationTotalView().setVisibility(0);
            getProgressView().setVisibility(0);
            getLineView().setVisibility(0);
            getPlayButton().setImageResource(PlayerManager.INSTANCE.a().getIsPlaying() ? R.drawable.mall_ic_video_pause : R.drawable.mall_ic_video_play);
            getPlayButton().setClickable(true);
            getPlayButton().setVisibility(0);
            ViewParent parent2 = getParent();
            imagePreviewViewPager = parent2 instanceof ImagePreviewViewPager ? (ImagePreviewViewPager) parent2 : null;
            if (imagePreviewViewPager != null) {
                imagePreviewViewPager.setTouchEnable(false);
            }
        }
    }

    public final int l() {
        return this.isFullScreen ? R.drawable.mall_ic_video_voice_gray : R.drawable.mall_ic_video_voice;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PlayerManager.INSTANCE.a().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PlayerManager.INSTANCE.a().t(this);
        super.onDetachedFromWindow();
    }

    @Override // com.huachenjie.mall.page.goods_detail.preview.PlayerStatusListener
    public void onHideCover() {
        getPlayButton().setVisibility(8);
        getThumbnailView().setVisibility(8);
    }

    @Override // com.huachenjie.mall.page.goods_detail.preview.PlayerStatusListener
    public void onProgressChanged(long duration, long total) {
        if (total > 0) {
            int i = (int) ((duration * 100.0f) / total);
            getSeekBar().setProgress(i);
            getProgressBar().setProgress(i);
            getProgressView().setText(d(duration));
            getDurationTotalView().setText(d(total));
        }
    }

    @Override // com.huachenjie.mall.page.goods_detail.preview.PlayerStatusListener
    public void onShowCover() {
        getPlayButton().setImageResource(R.drawable.mall_ic_video_play);
        getPlayButton().setClickable(false);
        getPlayButton().setVisibility(0);
        getThumbnailView().setVisibility(0);
    }

    public final void pause() {
        PlayerManager.INSTANCE.a().s(false);
    }

    public final void rebindTextureView() {
        PlayerManager.Companion companion = PlayerManager.INSTANCE;
        companion.a().i(getTextureView(), false);
        getSoundView().setImageResource(companion.a().q() ? j() : l());
    }

    public final void resume() {
        PlayerManager.INSTANCE.a().u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = -1;
        this.textureView = LazyKt.lazy(new Function0<TextureView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$textureView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextureView m553invoke() {
                TextureView textureView = new TextureView(context);
                this.addView(textureView, new RelativeLayout.LayoutParams(-1, -1));
                return textureView;
            }
        });
        this.soundView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$soundView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m552invoke() {
                ImageView imageView = new ImageView(context);
                this.addView(imageView);
                return imageView;
            }
        });
        this.thumbnailView = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$thumbnailView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m554invoke() {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                return imageView;
            }
        });
        this.playButton = LazyKt.lazy(new VideoLayout$playButton$2(context, this));
        this.seekBar = LazyKt.lazy(new Function0<SeekBar>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$seekBar$2

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/mall/page/goods_detail/preview/VideoLayout$seekBar$2$a", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "mall_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements SeekBar.OnSeekBarChangeListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ VideoLayout f35216a;

                public a(VideoLayout videoLayout) {
                    this.f35216a = videoLayout;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        PlayerManager.Companion companion = PlayerManager.INSTANCE;
                        long jL = companion.a().l();
                        this.f35216a.getProgressBar().setProgress(progress);
                        companion.a().v((long) ((jL * ((long) progress)) / 100.0f));
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SeekBar m551invoke() {
                SeekBar seekBar = new SeekBar(context);
                seekBar.setId(View.generateViewId());
                seekBar.setMax(100);
                seekBar.setSplitTrack(false);
                seekBar.setThumbOffset(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(1308622847);
                gradientDrawable.setCornerRadius(SizeUtils.b(4.0f));
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setColor(-1);
                gradientDrawable2.setCornerRadius(SizeUtils.b(4.0f));
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, GravityCompat.START, 1)});
                layerDrawable.setLayerInset(0, 0, SizeUtils.b(4.0f), 0, SizeUtils.b(4.0f));
                layerDrawable.setLayerInset(1, 0, SizeUtils.b(4.0f), 0, SizeUtils.b(4.0f));
                seekBar.setProgressDrawable(layerDrawable);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(1);
                gradientDrawable3.setColor(-1);
                gradientDrawable3.setSize(SizeUtils.b(16.0f), SizeUtils.b(16.0f));
                seekBar.setThumb(gradientDrawable3);
                seekBar.setOnSeekBarChangeListener(new a(this));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, SizeUtils.b(53.0f));
                this.addView(seekBar, layoutParams);
                return seekBar;
            }
        });
        this.progressBar = LazyKt.lazy(new Function0<ProgressBar>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$progressBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ProgressBar m549invoke() {
                ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(1308622847);
                gradientDrawable.setCornerRadius(SizeUtils.b(1.0f));
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setColor(-1);
                gradientDrawable2.setCornerRadius(SizeUtils.b(1.0f));
                progressBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, GravityCompat.START, 1)}));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, SizeUtils.b(2.0f));
                layoutParams.addRule(12);
                layoutParams.setMargins(SizeUtils.b(16.0f), 0, SizeUtils.b(16.0f), SizeUtils.b(60.0f));
                this.addView(progressBar, layoutParams);
                return progressBar;
            }
        });
        this.lineView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$lineView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m547invoke() {
                View view = new View(context);
                view.setId(View.generateViewId());
                view.setBackgroundColor(1308622847);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SizeUtils.b(2.0f), SizeUtils.b(20.0f));
                layoutParams.addRule(14);
                layoutParams.addRule(2, this.getSeekBar().getId());
                layoutParams.bottomMargin = SizeUtils.b(16.0f);
                this.addView(view, layoutParams);
                return view;
            }
        });
        this.durationTotalView = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$durationTotalView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m546invoke() {
                TextView textView = new TextView(context);
                textView.setTextColor(-2130706433);
                textView.setTextSize(24.0f);
                textView.setText("0:00");
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(17, this.getLineView().getId());
                layoutParams.addRule(2, this.getSeekBar().getId());
                layoutParams.bottomMargin = SizeUtils.b(10.0f);
                layoutParams.leftMargin = SizeUtils.b(20.0f);
                this.addView(textView, layoutParams);
                return textView;
            }
        });
        this.progressView = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.mall.page.goods_detail.preview.VideoLayout$progressView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m550invoke() {
                TextView textView = new TextView(context);
                textView.setTextColor(-1);
                textView.setTextSize(24.0f);
                textView.setText("0:00");
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(16, this.getLineView().getId());
                layoutParams.addRule(2, this.getSeekBar().getId());
                layoutParams.bottomMargin = SizeUtils.b(10.0f);
                layoutParams.rightMargin = SizeUtils.b(20.0f);
                this.addView(textView, layoutParams);
                return textView;
            }
        });
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(-16777216);
        getTextureView();
        getSoundView();
        getSeekBar().setVisibility(8);
        getProgressBar().setVisibility(8);
        getLineView().setVisibility(8);
        getDurationTotalView().setVisibility(8);
        getProgressView().setVisibility(8);
        getThumbnailView().setVisibility(8);
        getPlayButton().setVisibility(8);
        e();
    }
}
