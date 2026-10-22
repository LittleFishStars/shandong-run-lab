package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.ad_report.AdReportActivity;
import com.huachenjie.compat.page.ad_report.AdReportViewModel;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class CompatActivityAdReportBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f34054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AdReportActivity.a f9171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AdReportViewModel f9172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f9173a;

    public CompatActivityAdReportBinding(Object obj, View view, int i, BLEditText bLEditText, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f9173a = bLEditText;
        this.f34054a = layoutToolbarBindingBinding;
    }

    public static CompatActivityAdReportBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompatActivityAdReportBinding d(@NonNull View view, @Nullable Object obj) {
        return (CompatActivityAdReportBinding) ViewDataBinding.bind(obj, view, R.layout.compat_activity_ad_report);
    }

    @NonNull
    public static CompatActivityAdReportBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CompatActivityAdReportBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CompatActivityAdReportBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CompatActivityAdReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_ad_report, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CompatActivityAdReportBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CompatActivityAdReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_ad_report, null, false, obj);
    }

    @Nullable
    public AdReportActivity.a f() {
        return this.f9171a;
    }

    @Nullable
    public AdReportViewModel g() {
        return this.f9172a;
    }

    public abstract void l(@Nullable AdReportActivity.a aVar);

    public abstract void m(@Nullable AdReportViewModel adReportViewModel);
}
