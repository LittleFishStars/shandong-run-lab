package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunRecordStatusBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12152a;

    public RunLayoutRunRecordStatusBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivStatusExpand, BLLinearLayout llStatusExpand, RecyclerView rvStatusLog, TextView tvStatusExpand) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35694a = ivStatusExpand;
        this.f12152a = llStatusExpand;
        this.f12150a = rvStatusLog;
        this.f12149a = tvStatusExpand;
    }

    public static RunLayoutRunRecordStatusBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunRecordStatusBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunRecordStatusBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_record_status);
    }

    @NonNull
    public static RunLayoutRunRecordStatusBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunRecordStatusBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunRecordStatusBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunRecordStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_record_status, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunRecordStatusBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunRecordStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_record_status, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12151a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
