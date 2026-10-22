package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DialogConfirmBoxBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f32814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f6988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f6989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f6990a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public DialogConfirmBoxBinding(@NonNull FrameLayout rootView, @NonNull TextView confirmDialogCancel, @NonNull TextView confirmDialogConfirm, @NonNull LinearLayout confirmDialogContainer, @NonNull EditText confirmDialogContent, @NonNull TextView confirmDialogTitle) {
        this.f6988a = rootView;
        this.f6990a = confirmDialogCancel;
        this.b = confirmDialogConfirm;
        this.f6989a = confirmDialogContainer;
        this.f32814a = confirmDialogContent;
        this.c = confirmDialogTitle;
    }

    @NonNull
    public static DialogConfirmBoxBinding a(@NonNull View rootView) {
        int i = R.id.confirm_dialog_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.confirm_dialog_confirm;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.confirm_dialog_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.confirm_dialog_content;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText != null) {
                        i = R.id.confirm_dialog_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new DialogConfirmBoxBinding((FrameLayout) rootView, textView, textView2, linearLayout, editText, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogConfirmBoxBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static DialogConfirmBoxBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_confirm_box, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f6988a;
    }
}
