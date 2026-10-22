package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.MoreOptBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseItemMoreOptBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MoreOptBean f32810a;

    public BaseItemMoreOptBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static BaseItemMoreOptBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BaseItemMoreOptBinding d(@NonNull View view, @Nullable Object component) {
        return (BaseItemMoreOptBinding) ViewDataBinding.bind(component, view, R.layout.base_item_more_opt);
    }

    @NonNull
    public static BaseItemMoreOptBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static BaseItemMoreOptBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static BaseItemMoreOptBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (BaseItemMoreOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.base_item_more_opt, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static BaseItemMoreOptBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (BaseItemMoreOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.base_item_more_opt, null, false, component);
    }

    @Nullable
    public MoreOptBean f() {
        return this.f32810a;
    }

    public abstract void k(@Nullable MoreOptBean bean);
}
