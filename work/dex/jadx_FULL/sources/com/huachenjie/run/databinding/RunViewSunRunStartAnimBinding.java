package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.widget.AnimatedWebpImageView;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.run.R;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunViewSunRunStartAnimBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f12312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AnimatedWebpImageView f12313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f12314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f12315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f12316a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f12317b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12318b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f12319b;

    @NonNull
    public final TextView c;

    public RunViewSunRunStartAnimBinding(@NonNull View rootView, @NonNull FrameLayout flCountdownContent, @NonNull BLFrameLayout flTip, @NonNull FrameLayout flWarmUpCard, @NonNull ImageView ivBrand, @NonNull AnimatedWebpImageView ivCharacter, @NonNull ImageView ivTip, @NonNull LottieAnimationView lottieIntro, @NonNull StrokeTextView tvCountdown, @NonNull TextView tvTip, @NonNull TextView tvWarmUp, @NonNull TextView tvWarmUpAction, @NonNull BLView vGradient, @NonNull BLFrameLayout vWarmUpBg) {
        this.f35747a = rootView;
        this.f12309a = flCountdownContent;
        this.f12315a = flTip;
        this.b = flWarmUpCard;
        this.f12310a = ivBrand;
        this.f12313a = ivCharacter;
        this.f12317b = ivTip;
        this.f12312a = lottieIntro;
        this.f12314a = tvCountdown;
        this.f12311a = tvTip;
        this.f12318b = tvWarmUp;
        this.c = tvWarmUpAction;
        this.f12316a = vGradient;
        this.f12319b = vWarmUpBg;
    }

    @NonNull
    public static RunViewSunRunStartAnimBinding a(@NonNull View rootView) {
        BLFrameLayout bLFrameLayoutFindChildViewById;
        BLView bLViewFindChildViewById;
        BLFrameLayout bLFrameLayoutFindChildViewById2;
        int i = R.id.fl_countdown_content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null && (bLFrameLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.fl_tip))) != null) {
            i = R.id.fl_warm_up_card;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout2 != null) {
                i = R.id.iv_brand;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.iv_character;
                    AnimatedWebpImageView animatedWebpImageView = (AnimatedWebpImageView) ViewBindings.findChildViewById(rootView, i);
                    if (animatedWebpImageView != null) {
                        i = R.id.iv_tip;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.lottie_intro;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                            if (lottieAnimationView != null) {
                                i = R.id.tv_countdown;
                                StrokeTextView strokeTextView = (StrokeTextView) ViewBindings.findChildViewById(rootView, i);
                                if (strokeTextView != null) {
                                    i = R.id.tv_tip;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.tv_warm_up;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_warm_up_action;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null && (bLViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.v_gradient))) != null && (bLFrameLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.v_warm_up_bg))) != null) {
                                                return new RunViewSunRunStartAnimBinding(rootView, frameLayout, bLFrameLayoutFindChildViewById, frameLayout2, imageView, animatedWebpImageView, imageView2, lottieAnimationView, strokeTextView, textView, textView2, textView3, bLViewFindChildViewById, bLFrameLayoutFindChildViewById2);
                                            }
                                        }
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
    public static RunViewSunRunStartAnimBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_view_sun_run_start_anim, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35747a;
    }
}
