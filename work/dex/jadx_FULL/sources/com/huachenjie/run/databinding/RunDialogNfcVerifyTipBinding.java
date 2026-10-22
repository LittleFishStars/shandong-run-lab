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
public final class RunDialogNfcVerifyTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11749a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11750b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11751b;

    public RunDialogNfcVerifyTipBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout llScan, @NonNull BLTextView tvKnow, @NonNull TextView tvMessage, @NonNull BLTextView tvPause, @NonNull TextView tvTitle) {
        this.f35548a = rootView;
        this.b = llScan;
        this.f11749a = tvKnow;
        this.f11748a = tvMessage;
        this.f11751b = tvPause;
        this.f11750b = tvTitle;
    }

    @NonNull
    public static RunDialogNfcVerifyTipBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        BLTextView bLTextViewFindChildViewById2;
        int i = R.id.ll_scan;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_know))) != null) {
            i = R.id.tv_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null && (bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.tv_pause))) != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new RunDialogNfcVerifyTipBinding((LinearLayout) rootView, linearLayout, bLTextViewFindChildViewById, textView, bLTextViewFindChildViewById2, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogNfcVerifyTipBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogNfcVerifyTipBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_nfc_verify_tip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35548a;
    }
}
