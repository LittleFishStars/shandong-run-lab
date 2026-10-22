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
public final class LayoutDialogVerticalButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8662a;

    @NonNull
    public final TextView b;

    public LayoutDialogVerticalButtonBinding(@NonNull LinearLayout rootView, @NonNull TextView tvVerticalNegative, @NonNull TextView tvVerticalPositive, @NonNull View viewVerticalBtnLine) {
        this.f8661a = rootView;
        this.f8662a = tvVerticalNegative;
        this.b = tvVerticalPositive;
        this.f33770a = viewVerticalBtnLine;
    }

    @NonNull
    public static LayoutDialogVerticalButtonBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.tv_vertical_negative;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_vertical_positive;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_vertical_btn_line))) != null) {
                return new LayoutDialogVerticalButtonBinding((LinearLayout) rootView, textView, textView2, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutDialogVerticalButtonBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutDialogVerticalButtonBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_dialog_vertical_button, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8661a;
    }
}
