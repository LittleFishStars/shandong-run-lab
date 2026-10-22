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
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutRunTimeAreaViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12164a;

    public RunLayoutRunTimeAreaViewBinding(@NonNull LinearLayout rootView, @NonNull BLTextView tvMorningTag, @NonNull TextView tvTime) {
        this.f35698a = rootView;
        this.f12164a = tvMorningTag;
        this.f12163a = tvTime;
    }

    @NonNull
    public static RunLayoutRunTimeAreaViewBinding a(@NonNull View rootView) {
        int i = R.id.tvMorningTag;
        BLTextView bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (bLTextViewFindChildViewById != null) {
            i = R.id.tvTime;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RunLayoutRunTimeAreaViewBinding((LinearLayout) rootView, bLTextViewFindChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutRunTimeAreaViewBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutRunTimeAreaViewBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_run_time_area_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35698a;
    }
}
