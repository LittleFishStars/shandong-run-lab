package com.huachenjie.works.databinding;

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
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksActivityBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkItemBean f14726a;

    public WorksItemWorksActivityBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivImage, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37081a = ivImage;
        this.f14725a = tvTitle;
    }

    public static WorksItemWorksActivityBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksActivityBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksActivityBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_activity);
    }

    @NonNull
    public static WorksItemWorksActivityBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksActivityBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksActivityBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksActivityBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_activity, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksActivityBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksActivityBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_activity, null, false, component);
    }

    @Nullable
    public WorkItemBean f() {
        return this.f14726a;
    }

    public abstract void k(@Nullable WorkItemBean vm);
}
