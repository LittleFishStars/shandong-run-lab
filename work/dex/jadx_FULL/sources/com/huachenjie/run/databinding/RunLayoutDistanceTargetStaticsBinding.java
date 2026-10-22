package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.BackgroundChronometer;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutDistanceTargetStaticsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BackgroundChronometer f12029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12030a;

    @NonNull
    public final CustomerTextView b;

    public RunLayoutDistanceTargetStaticsBinding(@NonNull LinearLayout rootView, @NonNull CustomerTextView tvAveragePace, @NonNull CustomerTextView tvBurnedCalories, @NonNull BackgroundChronometer tvCostedTime) {
        this.f35654a = rootView;
        this.f12030a = tvAveragePace;
        this.b = tvBurnedCalories;
        this.f12029a = tvCostedTime;
    }

    @NonNull
    public static RunLayoutDistanceTargetStaticsBinding a(@NonNull View rootView) {
        int i = R.id.tv_average_pace;
        CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
        if (customerTextView != null) {
            i = R.id.tv_burned_calories;
            CustomerTextView customerTextView2 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
            if (customerTextView2 != null) {
                i = R.id.tv_costed_time;
                BackgroundChronometer backgroundChronometer = (BackgroundChronometer) ViewBindings.findChildViewById(rootView, i);
                if (backgroundChronometer != null) {
                    return new RunLayoutDistanceTargetStaticsBinding((LinearLayout) rootView, customerTextView, customerTextView2, backgroundChronometer);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutDistanceTargetStaticsBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutDistanceTargetStaticsBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_distance_target_statics, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35654a;
    }
}
