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
public final class DialogCustomizeViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutDialogHorizontalButtonBinding f8621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutDialogVerticalButtonBinding f8622a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8623b;

    public DialogCustomizeViewBinding(@NonNull LinearLayout rootView, @NonNull LayoutDialogHorizontalButtonBinding llHotizontalButton, @NonNull LayoutDialogVerticalButtonBinding llVerticalButton, @NonNull TextView tvMessage, @NonNull TextView tvTitle, @NonNull LinearLayout viewMessage) {
        this.f33753a = rootView;
        this.f8621a = llHotizontalButton;
        this.f8622a = llVerticalButton;
        this.f8620a = tvMessage;
        this.f8623b = tvTitle;
        this.b = viewMessage;
    }

    @NonNull
    public static DialogCustomizeViewBinding a(@NonNull View rootView) {
        int i = R.id.ll_hotizontal_button;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById != null) {
            LayoutDialogHorizontalButtonBinding layoutDialogHorizontalButtonBindingA = LayoutDialogHorizontalButtonBinding.a(viewFindChildViewById);
            i = R.id.ll_vertical_button;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (viewFindChildViewById2 != null) {
                LayoutDialogVerticalButtonBinding layoutDialogVerticalButtonBindingA = LayoutDialogVerticalButtonBinding.a(viewFindChildViewById2);
                i = R.id.tv_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.view_message;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            return new DialogCustomizeViewBinding((LinearLayout) rootView, layoutDialogHorizontalButtonBindingA, layoutDialogVerticalButtonBindingA, textView, textView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogCustomizeViewBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogCustomizeViewBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_customize_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f33753a;
    }
}
