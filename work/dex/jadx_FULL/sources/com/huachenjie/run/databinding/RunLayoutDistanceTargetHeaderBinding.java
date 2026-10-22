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
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutDistanceTargetHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12028a;

    @NonNull
    public final TextView b;

    public RunLayoutDistanceTargetHeaderBinding(@NonNull LinearLayout rootView, @NonNull CustomerTextView tvDistance, @NonNull TextView tvTargetTitle, @NonNull TextView tvTitle) {
        this.f35653a = rootView;
        this.f12028a = tvDistance;
        this.f12027a = tvTargetTitle;
        this.b = tvTitle;
    }

    @NonNull
    public static RunLayoutDistanceTargetHeaderBinding a(@NonNull View rootView) {
        int i = R.id.tv_distance;
        CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
        if (customerTextView != null) {
            i = R.id.tv_target_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new RunLayoutDistanceTargetHeaderBinding((LinearLayout) rootView, customerTextView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutDistanceTargetHeaderBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutDistanceTargetHeaderBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_distance_target_header, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35653a;
    }
}
