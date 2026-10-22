package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.ReportReasonBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemReportUserBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ReportReasonBean f36189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12986a;

    public ItemReportUserBinding(Object obj, View view, int i, BLTextView bLTextView) {
        super(obj, view, i);
        this.f12986a = bLTextView;
    }

    public static ItemReportUserBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReportUserBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemReportUserBinding) ViewDataBinding.bind(obj, view, R.layout.item_report_user);
    }

    @NonNull
    public static ItemReportUserBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemReportUserBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemReportUserBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemReportUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemReportUserBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemReportUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_user, null, false, obj);
    }

    @Nullable
    public ReportReasonBean f() {
        return this.f36189a;
    }

    public abstract void k(@Nullable ReportReasonBean reportReasonBean);
}
