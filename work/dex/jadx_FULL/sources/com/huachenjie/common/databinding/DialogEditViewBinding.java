package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class DialogEditViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f33755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutDialogHorizontalButtonBinding f8628a;

    public DialogEditViewBinding(@NonNull LinearLayout rootView, @NonNull EditText etContent, @NonNull LayoutDialogHorizontalButtonBinding llHotizontalButton, @NonNull TextView tvTitle) {
        this.f8626a = rootView;
        this.f33755a = etContent;
        this.f8628a = llHotizontalButton;
        this.f8627a = tvTitle;
    }

    @NonNull
    public static DialogEditViewBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.etContent;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
        if (editText != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.ll_hotizontal_button))) != null) {
            LayoutDialogHorizontalButtonBinding layoutDialogHorizontalButtonBindingA = LayoutDialogHorizontalButtonBinding.a(viewFindChildViewById);
            int i2 = R.id.tvTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i2);
            if (textView != null) {
                return new DialogEditViewBinding((LinearLayout) rootView, editText, layoutDialogHorizontalButtonBindingA, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogEditViewBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogEditViewBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_edit_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8626a;
    }
}
