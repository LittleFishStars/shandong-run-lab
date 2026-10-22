package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.activity.ActivityListModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityActivityListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityListModel f13807a;

    public WorksActivityActivityListBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivBack, RecyclerView rvList, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36765a = ivBack;
        this.f13805a = rvList;
        this.f13806a = titleBar;
    }

    public static WorksActivityActivityListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityActivityListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityActivityListBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_activity_list);
    }

    @NonNull
    public static WorksActivityActivityListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityActivityListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityActivityListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityActivityListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_activity_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityActivityListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityActivityListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_activity_list, null, false, component);
    }

    @Nullable
    public ActivityListModel f() {
        return this.f13807a;
    }

    public abstract void k(@Nullable ActivityListModel vm);
}
