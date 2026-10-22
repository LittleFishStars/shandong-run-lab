package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutDurationTargetStaticsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12038a;

    @NonNull
    public final CustomerTextView b;

    @NonNull
    public final CustomerTextView c;

    public RunLayoutDurationTargetStaticsBinding(@NonNull LinearLayout rootView, @NonNull CustomerTextView tvAveragePace, @NonNull CustomerTextView tvBurnedCalories, @NonNull CustomerTextView tvDistance) {
        this.f35658a = rootView;
        this.f12038a = tvAveragePace;
        this.b = tvBurnedCalories;
        this.c = tvDistance;
    }

    @NonNull
    public static RunLayoutDurationTargetStaticsBinding a(@NonNull View rootView) {
        int i = R.id.tv_average_pace;
        CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
        if (customerTextView != null) {
            i = R.id.tv_burned_calories;
            CustomerTextView customerTextView2 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
            if (customerTextView2 != null) {
                i = R.id.tv_distance;
                CustomerTextView customerTextView3 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                if (customerTextView3 != null) {
                    return new RunLayoutDurationTargetStaticsBinding((LinearLayout) rootView, customerTextView, customerTextView2, customerTextView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutDurationTargetStaticsBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutDurationTargetStaticsBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_duration_target_statics, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35658a;
    }
}
