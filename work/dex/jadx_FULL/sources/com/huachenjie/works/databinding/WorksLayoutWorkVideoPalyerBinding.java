package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.LoadingLineView;
import com.huachenjie.works.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksLayoutWorkVideoPalyerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextureView f37103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f14793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SeekBar f14794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LoadingLineView f14797a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14798b;

    public WorksLayoutWorkVideoPalyerBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivPlayButton, @NonNull LinearLayout llTimeContainer, @NonNull LoadingLineView loadingLine, @NonNull ProgressBar pbVideoProgress, @NonNull SeekBar sbVideoSeek, @NonNull TextView tvCurrentPlayTime, @NonNull TextView tvVideoDuration, @NonNull ConstraintLayout videoContainer, @NonNull TextureView worksTextureView) {
        this.f14796a = rootView;
        this.f14791a = ivPlayButton;
        this.f14792a = llTimeContainer;
        this.f14797a = loadingLine;
        this.f14793a = pbVideoProgress;
        this.f14794a = sbVideoSeek;
        this.f14795a = tvCurrentPlayTime;
        this.b = tvVideoDuration;
        this.f14798b = videoContainer;
        this.f37103a = worksTextureView;
    }

    @NonNull
    public static WorksLayoutWorkVideoPalyerBinding a(@NonNull View rootView) {
        int i = R.id.ivPlayButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.llTimeContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.loadingLine;
                LoadingLineView loadingLineView = (LoadingLineView) ViewBindings.findChildViewById(rootView, i);
                if (loadingLineView != null) {
                    i = R.id.pb_video_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                    if (progressBar != null) {
                        i = R.id.sb_video_seek;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                        if (seekBar != null) {
                            i = R.id.tvCurrentPlayTime;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvVideoDuration;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                    i = R.id.worksTextureView;
                                    TextureView textureView = (TextureView) ViewBindings.findChildViewById(rootView, i);
                                    if (textureView != null) {
                                        return new WorksLayoutWorkVideoPalyerBinding(constraintLayout, imageView, linearLayout, loadingLineView, progressBar, seekBar, textView, textView2, constraintLayout, textureView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static WorksLayoutWorkVideoPalyerBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksLayoutWorkVideoPalyerBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_layout_work_video_palyer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14796a;
    }
}
