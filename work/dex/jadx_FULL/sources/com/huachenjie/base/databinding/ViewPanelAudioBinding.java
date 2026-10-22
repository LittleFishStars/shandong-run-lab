package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ViewPanelAudioBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f7152a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f7153b;

    public ViewPanelAudioBinding(@NonNull View rootView, @NonNull ImageView ivAudioBt, @NonNull LottieAnimationView ivAudioLineLeft, @NonNull LottieAnimationView ivAudioLineRight, @NonNull ImageView ivAudioRecordeTip, @NonNull TextView tvAudioRecordeTip) {
        this.f32878a = rootView;
        this.f7150a = ivAudioBt;
        this.f7152a = ivAudioLineLeft;
        this.f7153b = ivAudioLineRight;
        this.b = ivAudioRecordeTip;
        this.f7151a = tvAudioRecordeTip;
    }

    @NonNull
    public static ViewPanelAudioBinding a(@NonNull View rootView) {
        int i = R.id.iv_audio_bt;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.iv_audio_line_left;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
            if (lottieAnimationView != null) {
                i = R.id.iv_audio_line_right;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                if (lottieAnimationView2 != null) {
                    i = R.id.iv_audio_recorde_tip;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.tv_audio_recorde_tip;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            return new ViewPanelAudioBinding(rootView, imageView, lottieAnimationView, lottieAnimationView2, imageView2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewPanelAudioBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.view_panel_audio, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f32878a;
    }
}
