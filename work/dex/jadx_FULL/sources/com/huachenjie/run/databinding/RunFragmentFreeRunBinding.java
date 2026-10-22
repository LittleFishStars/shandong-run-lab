package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunFragmentFreeRunBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f11830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f11831a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11832b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunFragmentFreeRunBinding(@NonNull ConstraintLayout rootView, @NonNull FrameLayout flFd, @NonNull ImageView ivBack, @NonNull ImageView ivStartRun, @NonNull ShadowLayout sclTartgetSetting, @NonNull TextView totalDistanceTitle, @NonNull CustomerTextView totalDistanceValue, @NonNull TextView tvTartgetSetting, @NonNull TextView tvTip, @NonNull TextView tvTitle) {
        this.f11829a = rootView;
        this.f35580a = flFd;
        this.f11827a = ivBack;
        this.b = ivStartRun;
        this.f11831a = sclTartgetSetting;
        this.f11828a = totalDistanceTitle;
        this.f11830a = totalDistanceValue;
        this.f11832b = tvTartgetSetting;
        this.c = tvTip;
        this.d = tvTitle;
    }

    @NonNull
    public static RunFragmentFreeRunBinding a(@NonNull View rootView) {
        int i = R.id.flFd;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.iv_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_start_run;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.scl_tartget_setting;
                    ShadowLayout shadowLayout = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                    if (shadowLayout != null) {
                        i = R.id.total_distance_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.total_distance_value;
                            CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                            if (customerTextView != null) {
                                i = R.id.tv_tartget_setting;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvTip;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            return new RunFragmentFreeRunBinding((ConstraintLayout) rootView, frameLayout, imageView, imageView2, shadowLayout, textView, customerTextView, textView2, textView3, textView4);
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
    public static RunFragmentFreeRunBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunFragmentFreeRunBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_fragment_free_run, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f11829a;
    }
}
