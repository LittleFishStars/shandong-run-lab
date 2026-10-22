package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.channel.AlumniChannelFragment;
import com.huachenjie.works.page.alumni.channel.AlumniChannelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksLayoutAlumniChannelHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AlumniChannelFragment.a f14776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AlumniChannelVM f14777a;

    public WorksLayoutAlumniChannelHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView headerRecycler, TextView tvHotWorks) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14775a = headerRecycler;
        this.f37097a = tvHotWorks;
    }

    public static WorksLayoutAlumniChannelHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksLayoutAlumniChannelHeaderBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksLayoutAlumniChannelHeaderBinding) ViewDataBinding.bind(component, view, R.layout.works_layout_alumni_channel_header);
    }

    @NonNull
    public static WorksLayoutAlumniChannelHeaderBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksLayoutAlumniChannelHeaderBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksLayoutAlumniChannelHeaderBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksLayoutAlumniChannelHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_layout_alumni_channel_header, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksLayoutAlumniChannelHeaderBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksLayoutAlumniChannelHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_layout_alumni_channel_header, null, false, component);
    }

    @Nullable
    public AlumniChannelFragment.a f() {
        return this.f14776a;
    }

    @Nullable
    public AlumniChannelVM g() {
        return this.f14777a;
    }

    public abstract void l(@Nullable AlumniChannelFragment.a click);

    public abstract void m(@Nullable AlumniChannelVM vm);
}
