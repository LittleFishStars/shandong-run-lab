package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogAlipayBindTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f35520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11679a;

    @NonNull
    public final BLTextView b;

    public RunDialogAlipayBindTipBinding(@NonNull BLLinearLayout rootView, @NonNull BLTextView tvBind, @NonNull BLTextView tvClose) {
        this.f35520a = rootView;
        this.f11679a = tvBind;
        this.b = tvClose;
    }

    @NonNull
    public static RunDialogAlipayBindTipBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.tv_bind;
        BLTextView bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, i);
        if (bLTextViewFindChildViewById2 == null || (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_close))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new RunDialogAlipayBindTipBinding((BLLinearLayout) rootView, bLTextViewFindChildViewById2, bLTextViewFindChildViewById);
    }

    @NonNull
    public static RunDialogAlipayBindTipBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogAlipayBindTipBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_alipay_bind_tip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.f35520a;
    }
}
