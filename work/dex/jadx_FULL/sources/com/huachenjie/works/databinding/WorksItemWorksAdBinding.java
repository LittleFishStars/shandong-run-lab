package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import cn.hzjizhun.admin.JZUnifiedADContainer;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksAdBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final JZUnifiedADContainer f14731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkItemBean f14732a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public WorksItemWorksAdBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView btClose, ConstraintLayout flAdContainer, JZUnifiedADContainer unifiedAdContainer, ImageView unifiedImg, ImageView unifiedLogo) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37083a = btClose;
        this.f14730a = flAdContainer;
        this.f14731a = unifiedAdContainer;
        this.b = unifiedImg;
        this.c = unifiedLogo;
    }

    public static WorksItemWorksAdBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksAdBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksAdBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_ad);
    }

    @NonNull
    public static WorksItemWorksAdBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksAdBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksAdBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksAdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_ad, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksAdBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksAdBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_ad, null, false, component);
    }

    @Nullable
    public WorkItemBean f() {
        return this.f14732a;
    }

    public abstract void k(@Nullable WorkItemBean vm);
}
