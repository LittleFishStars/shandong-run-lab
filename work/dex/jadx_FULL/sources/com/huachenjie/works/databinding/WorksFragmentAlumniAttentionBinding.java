package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.attention.AttentionVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentAlumniAttentionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f14140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttentionVM f14144a;

    public WorksFragmentAlumniAttentionBinding(Object _bindingComponent, View _root, int _localFieldCount, ProgressBar pbPublishProgress, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, ImageView thumbPublishProgress, View vStatusSpace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14140a = pbPublishProgress;
        this.f14141a = recyclerView;
        this.f14143a = refreshLayout;
        this.f14139a = thumbPublishProgress;
        this.f36889a = vStatusSpace;
    }

    public static WorksFragmentAlumniAttentionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentAlumniAttentionBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentAlumniAttentionBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_alumni_attention);
    }

    @NonNull
    public static WorksFragmentAlumniAttentionBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentAlumniAttentionBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniAttentionBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentAlumniAttentionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_attention, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniAttentionBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentAlumniAttentionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_attention, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14142a;
    }

    @Nullable
    public AttentionVM g() {
        return this.f14144a;
    }

    public abstract void l(@Nullable AttentionVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
