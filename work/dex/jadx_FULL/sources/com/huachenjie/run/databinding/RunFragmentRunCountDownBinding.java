package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunFragmentRunCountDownBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f11861a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f11862b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f11863c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public RunFragmentRunCountDownBinding(@NonNull RelativeLayout rootView, @NonNull ImageView ivBottomBg, @NonNull LottieAnimationView ivGirl01, @NonNull LottieAnimationView ivGirl02, @NonNull LottieAnimationView ivGirl03, @NonNull TextView tvCountTime, @NonNull TextView tvHotBodyTips, @NonNull TextView tvPage4thGO, @NonNull TextView tvTopTips1, @NonNull TextView tvTopTips2, @NonNull TextView tvTopTips3) {
        this.f11859a = rootView;
        this.f35590a = ivBottomBg;
        this.f11861a = ivGirl01;
        this.f11862b = ivGirl02;
        this.f11863c = ivGirl03;
        this.f11860a = tvCountTime;
        this.b = tvHotBodyTips;
        this.c = tvPage4thGO;
        this.d = tvTopTips1;
        this.e = tvTopTips2;
        this.f = tvTopTips3;
    }

    @NonNull
    public static RunFragmentRunCountDownBinding a(@NonNull View rootView) {
        int i = R.id.ivBottomBg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.ivGirl01;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
            if (lottieAnimationView != null) {
                i = R.id.ivGirl02;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                if (lottieAnimationView2 != null) {
                    i = R.id.ivGirl03;
                    LottieAnimationView lottieAnimationView3 = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                    if (lottieAnimationView3 != null) {
                        i = R.id.tv_count_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvHotBodyTips;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvPage4thGO;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.tvTopTips1;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.tvTopTips2;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView5 != null) {
                                            i = R.id.tvTopTips3;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView6 != null) {
                                                return new RunFragmentRunCountDownBinding((RelativeLayout) rootView, imageView, lottieAnimationView, lottieAnimationView2, lottieAnimationView3, textView, textView2, textView3, textView4, textView5, textView6);
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
    public static RunFragmentRunCountDownBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunFragmentRunCountDownBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_fragment_run_count_down, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f11859a;
    }
}
