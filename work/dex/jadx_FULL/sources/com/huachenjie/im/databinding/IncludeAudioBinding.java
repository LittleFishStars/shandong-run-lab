package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeAudioBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f9759a;

    @NonNull
    public final LinearLayout b;

    public IncludeAudioBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f9757a = linearLayout;
        this.f34445a = imageView;
        this.f9759a = lottieAnimationView;
        this.b = linearLayout2;
        this.f9758a = textView;
    }

    @NonNull
    public static IncludeAudioBinding a(@NonNull View view) {
        int i = R.id.ivAudio;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.jsonAudio;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.tvAudio;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new IncludeAudioBinding(linearLayout, imageView, lottieAnimationView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static IncludeAudioBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeAudioBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.include_audio, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9757a;
    }
}
