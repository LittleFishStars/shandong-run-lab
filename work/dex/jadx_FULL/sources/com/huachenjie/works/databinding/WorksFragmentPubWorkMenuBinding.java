package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentPubWorkMenuBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f36934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewStubProxy f14274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BasePubWorkMenuFragment f14277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BasePubWorkMenuModel f14278a;

    @NonNull
    public final ViewStubProxy b;

    public WorksFragmentPubWorkMenuBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etSearch, RecyclerView rvList, StateLayout stateLayout, TextView tvTitle, ViewStubProxy vsPlaceholder1, ViewStubProxy vsPlaceholder2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36934a = etSearch;
        this.f14275a = rvList;
        this.f14276a = stateLayout;
        this.f14273a = tvTitle;
        this.f14274a = vsPlaceholder1;
        this.b = vsPlaceholder2;
    }

    public static WorksFragmentPubWorkMenuBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentPubWorkMenuBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentPubWorkMenuBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_pub_work_menu);
    }

    @NonNull
    public static WorksFragmentPubWorkMenuBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentPubWorkMenuBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPubWorkMenuBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentPubWorkMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_pub_work_menu, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPubWorkMenuBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentPubWorkMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_pub_work_menu, null, false, component);
    }

    @Nullable
    public BasePubWorkMenuFragment f() {
        return this.f14277a;
    }

    @Nullable
    public BasePubWorkMenuModel g() {
        return this.f14278a;
    }

    public abstract void l(@Nullable BasePubWorkMenuFragment fragment);

    public abstract void m(@Nullable BasePubWorkMenuModel vm);
}
