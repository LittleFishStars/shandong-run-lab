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
public final class RunDialogNfcPauseTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11743a;

    @NonNull
    public final LinearLayout b;

    public RunDialogNfcPauseTipBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout llScan, @NonNull BLTextView tvResume, @NonNull TextView tvTitle) {
        this.f35546a = rootView;
        this.b = llScan;
        this.f11743a = tvResume;
        this.f11742a = tvTitle;
    }

    @NonNull
    public static RunDialogNfcPauseTipBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.ll_scan;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_resume))) != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RunDialogNfcPauseTipBinding((LinearLayout) rootView, linearLayout, bLTextViewFindChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogNfcPauseTipBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogNfcPauseTipBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_nfc_pause_tip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35546a;
    }
}
