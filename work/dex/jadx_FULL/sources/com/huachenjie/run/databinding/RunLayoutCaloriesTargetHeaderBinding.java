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
public final class RunLayoutCaloriesTargetHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12013a;

    @NonNull
    public final TextView b;

    public RunLayoutCaloriesTargetHeaderBinding(@NonNull LinearLayout rootView, @NonNull CustomerTextView tvBurnedCalories, @NonNull TextView tvTargetTitle, @NonNull TextView tvTitle) {
        this.f35647a = rootView;
        this.f12013a = tvBurnedCalories;
        this.f12012a = tvTargetTitle;
        this.b = tvTitle;
    }

    @NonNull
    public static RunLayoutCaloriesTargetHeaderBinding a(@NonNull View rootView) {
        int i = R.id.tv_burned_calories;
        CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
        if (customerTextView != null) {
            i = R.id.tv_target_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new RunLayoutCaloriesTargetHeaderBinding((LinearLayout) rootView, customerTextView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutCaloriesTargetHeaderBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutCaloriesTargetHeaderBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_calories_target_header, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35647a;
    }
}
