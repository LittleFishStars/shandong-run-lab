package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.CircleProgressButton;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutFreePauseOperateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CircleProgressButton f12041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f12042a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f12043b;

    public RunLayoutFreePauseOperateBinding(@NonNull LinearLayout rootView, @NonNull CircleProgressButton btnFinish, @NonNull LinearLayout llPauseOperate, @NonNull RelativeLayout rlFinish, @NonNull ShadowLayout slFinish, @NonNull ShadowLayout slResume) {
        this.f35660a = rootView;
        this.f12041a = btnFinish;
        this.b = llPauseOperate;
        this.f12040a = rlFinish;
        this.f12042a = slFinish;
        this.f12043b = slResume;
    }

    @NonNull
    public static RunLayoutFreePauseOperateBinding a(@NonNull View rootView) {
        int i = R.id.btn_finish;
        CircleProgressButton circleProgressButton = (CircleProgressButton) ViewBindings.findChildViewById(rootView, i);
        if (circleProgressButton != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.rl_finish;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
                i = R.id.sl_finish;
                ShadowLayout shadowLayout = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                if (shadowLayout != null) {
                    i = R.id.sl_resume;
                    ShadowLayout shadowLayout2 = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                    if (shadowLayout2 != null) {
                        return new RunLayoutFreePauseOperateBinding(linearLayout, circleProgressButton, linearLayout, relativeLayout, shadowLayout, shadowLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutFreePauseOperateBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutFreePauseOperateBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_free_pause_operate, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35660a;
    }
}
