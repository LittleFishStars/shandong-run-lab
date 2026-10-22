package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogNfcPermissionTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11747a;

    public RunDialogNfcPermissionTipBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivClose, @NonNull BLLinearLayout llNfcStatus, @NonNull TextView tvNfcStatus, @NonNull BLTextView tvOpen) {
        this.f11744a = rootView;
        this.f35547a = ivClose;
        this.f11746a = llNfcStatus;
        this.f11745a = tvNfcStatus;
        this.f11747a = tvOpen;
    }

    @NonNull
    public static RunDialogNfcPermissionTipBinding a(@NonNull View rootView) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.ll_nfc_status))) != null) {
            i = R.id.tv_nfc_status;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_open))) != null) {
                return new RunDialogNfcPermissionTipBinding((LinearLayout) rootView, imageView, bLLinearLayoutFindChildViewById, textView, bLTextViewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogNfcPermissionTipBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogNfcPermissionTipBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_nfc_permission_tip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f11744a;
    }
}
