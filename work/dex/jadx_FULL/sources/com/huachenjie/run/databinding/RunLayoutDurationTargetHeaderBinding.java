package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.BackgroundChronometer;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutDurationTargetHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BackgroundChronometer f12037a;

    public RunLayoutDurationTargetHeaderBinding(@NonNull LinearLayout rootView, @NonNull BackgroundChronometer tvCostedTime, @NonNull TextView tvTargetTitle) {
        this.f35657a = rootView;
        this.f12037a = tvCostedTime;
        this.f12036a = tvTargetTitle;
    }

    @NonNull
    public static RunLayoutDurationTargetHeaderBinding a(@NonNull View rootView) {
        int i = R.id.tv_costed_time;
        BackgroundChronometer backgroundChronometer = (BackgroundChronometer) ViewBindings.findChildViewById(rootView, i);
        if (backgroundChronometer != null) {
            i = R.id.tv_target_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RunLayoutDurationTargetHeaderBinding((LinearLayout) rootView, backgroundChronometer, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutDurationTargetHeaderBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutDurationTargetHeaderBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_duration_target_header, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35657a;
    }
}
