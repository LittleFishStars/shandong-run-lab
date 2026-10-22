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
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.works.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemInputSelectUserBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserInfoBean f14592a;

    public WorksItemInputSelectUserBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37039a = tvName;
    }

    public static WorksItemInputSelectUserBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemInputSelectUserBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemInputSelectUserBinding) ViewDataBinding.bind(component, view, R.layout.works_item_input_select_user);
    }

    @NonNull
    public static WorksItemInputSelectUserBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemInputSelectUserBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemInputSelectUserBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemInputSelectUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_input_select_user, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemInputSelectUserBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemInputSelectUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_input_select_user, null, false, component);
    }

    @Nullable
    public UserInfoBean f() {
        return this.f14592a;
    }

    public abstract void k(@Nullable UserInfoBean bean);
}
