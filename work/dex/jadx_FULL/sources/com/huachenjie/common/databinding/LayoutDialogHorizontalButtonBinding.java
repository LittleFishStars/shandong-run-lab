package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutDialogHorizontalButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8660a;

    @NonNull
    public final TextView b;

    public LayoutDialogHorizontalButtonBinding(@NonNull LinearLayout rootView, @NonNull TextView tvHorizontalNegative, @NonNull TextView tvHorizontalPositive, @NonNull View viewHorizontalBtnLine) {
        this.f8659a = rootView;
        this.f8660a = tvHorizontalNegative;
        this.b = tvHorizontalPositive;
        this.f33769a = viewHorizontalBtnLine;
    }

    @NonNull
    public static LayoutDialogHorizontalButtonBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.tv_horizontal_negative;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_horizontal_positive;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_horizontal_btn_line))) != null) {
                return new LayoutDialogHorizontalButtonBinding((LinearLayout) rootView, textView, textView2, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutDialogHorizontalButtonBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutDialogHorizontalButtonBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_dialog_horizontal_button, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8659a;
    }
}
