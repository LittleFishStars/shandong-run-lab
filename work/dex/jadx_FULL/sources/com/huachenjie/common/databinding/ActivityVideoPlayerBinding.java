package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.common.video.VideoPlayerVM;
import com.huachenjie.common.video.VideoTextureView;
import com.huachenjie.common.widget.LoadingLineView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ActivityVideoPlayerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f8579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SeekBar f8580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VideoPlayerActivity.a f8582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VideoPlayerVM f8583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VideoTextureView f8584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LoadingLineView f8585a;

    @NonNull
    public final TextView b;

    public ActivityVideoPlayerBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivPlayButton, LinearLayout llTimeContainer, LoadingLineView loadingLine, ProgressBar pbVideoProgress, SeekBar sbVideoSeek, TextView tvCurrentPlayTime, TextView tvVideoDuration, VideoTextureView videoTextureView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f33742a = ivPlayButton;
        this.f8578a = llTimeContainer;
        this.f8585a = loadingLine;
        this.f8579a = pbVideoProgress;
        this.f8580a = sbVideoSeek;
        this.f8581a = tvCurrentPlayTime;
        this.b = tvVideoDuration;
        this.f8584a = videoTextureView;
    }

    public static ActivityVideoPlayerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityVideoPlayerBinding d(@NonNull View view, @Nullable Object component) {
        return (ActivityVideoPlayerBinding) ViewDataBinding.bind(component, view, R.layout.activity_video_player);
    }

    @NonNull
    public static ActivityVideoPlayerBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityVideoPlayerBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityVideoPlayerBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ActivityVideoPlayerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_video_player, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static ActivityVideoPlayerBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ActivityVideoPlayerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_video_player, null, false, component);
    }

    @Nullable
    public VideoPlayerActivity.a f() {
        return this.f8582a;
    }

    @Nullable
    public VideoPlayerVM g() {
        return this.f8583a;
    }

    public abstract void l(@Nullable VideoPlayerActivity.a click);

    public abstract void m(@Nullable VideoPlayerVM vm);
}
