package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniVM;
import com.huachenjie.works.widget.FindAlumniPicker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentFindAlumniBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f36905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FindAlumniVM f14189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FindAlumniPicker f14190a;

    @NonNull
    public final FindAlumniPicker b;

    @NonNull
    public final FindAlumniPicker c;

    public WorksFragmentFindAlumniBinding(Object _bindingComponent, View _root, int _localFieldCount, FindAlumniPicker fapGrade, FindAlumniPicker fapSex, FindAlumniPicker fapTag, SwipeRefreshLayout refreshLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14190a = fapGrade;
        this.b = fapSex;
        this.c = fapTag;
        this.f14188a = refreshLayout;
    }

    public static WorksFragmentFindAlumniBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentFindAlumniBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentFindAlumniBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_find_alumni);
    }

    @NonNull
    public static WorksFragmentFindAlumniBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentFindAlumniBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentFindAlumniBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentFindAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_find_alumni, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentFindAlumniBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentFindAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_find_alumni, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f36905a;
    }

    @Nullable
    public FindAlumniVM g() {
        return this.f14189a;
    }

    public abstract void l(@Nullable FindAlumniVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
