package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPulishPostTagBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PostCategoryBean f37062a;

    public WorksItemPulishPostTagBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemPulishPostTagBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPulishPostTagBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPulishPostTagBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pulish_post_tag);
    }

    @NonNull
    public static WorksItemPulishPostTagBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPulishPostTagBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPulishPostTagBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPulishPostTagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pulish_post_tag, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPulishPostTagBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPulishPostTagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pulish_post_tag, null, false, component);
    }

    @Nullable
    public PostCategoryBean f() {
        return this.f37062a;
    }

    public abstract void k(@Nullable PostCategoryBean bean);
}
