package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogFailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f11703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11704a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11705b;

    public RunDialogFailBinding(@NonNull ConstraintLayout rootView, @NonNull ShadowLayout cardView, @NonNull TextView tvFailContent, @NonNull TextView tvFailSubContent, @NonNull BLTextView tvQuit, @NonNull BLTextView tvRetry) {
        this.f11702a = rootView;
        this.f11703a = cardView;
        this.f35530a = tvFailContent;
        this.b = tvFailSubContent;
        this.f11704a = tvQuit;
        this.f11705b = tvRetry;
    }

    @NonNull
    public static RunDialogFailBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        BLTextView bLTextViewFindChildViewById2;
        int i = R.id.cardView;
        ShadowLayout shadowLayout = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
        if (shadowLayout != null) {
            i = R.id.tvFailContent;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvFailSubContent;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvQuit))) != null && (bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.tvRetry))) != null) {
                    return new RunDialogFailBinding((ConstraintLayout) rootView, shadowLayout, textView, textView2, bLTextViewFindChildViewById, bLTextViewFindChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogFailBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogFailBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_fail, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f11702a;
    }
}
