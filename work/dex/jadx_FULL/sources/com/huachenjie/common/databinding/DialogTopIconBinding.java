package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class DialogTopIconBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutDialogHorizontalButtonBinding f8636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutDialogVerticalButtonBinding f8637a;

    @NonNull
    public final TextView b;

    public DialogTopIconBinding(@NonNull RelativeLayout rootView, @NonNull ImageView imgIcon, @NonNull LayoutDialogHorizontalButtonBinding llHotizontalButton, @NonNull LayoutDialogVerticalButtonBinding llVerticalButton, @NonNull TextView tvMessage, @NonNull TextView tvTitle, @NonNull LinearLayout viewMessage) {
        this.f8634a = rootView;
        this.f33758a = imgIcon;
        this.f8636a = llHotizontalButton;
        this.f8637a = llVerticalButton;
        this.f8635a = tvMessage;
        this.b = tvTitle;
        this.f8633a = viewMessage;
    }

    @NonNull
    public static DialogTopIconBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.img_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.ll_hotizontal_button))) != null) {
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
                            return new DialogTopIconBinding((RelativeLayout) rootView, imageView, layoutDialogHorizontalButtonBindingA, layoutDialogVerticalButtonBindingA, textView, textView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogTopIconBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogTopIconBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_top_icon, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f8634a;
    }
}
