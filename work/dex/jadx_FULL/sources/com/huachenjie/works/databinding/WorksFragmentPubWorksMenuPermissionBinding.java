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
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment;
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentPubWorksMenuPermissionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PubWorkMenuPermissionFragment.a f36939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PubWorkMenuPermissionModel f14286a;

    public WorksFragmentPubWorksMenuPermissionBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksFragmentPubWorksMenuPermissionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentPubWorksMenuPermissionBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentPubWorksMenuPermissionBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_pub_works_menu_permission);
    }

    @NonNull
    public static WorksFragmentPubWorksMenuPermissionBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentPubWorksMenuPermissionBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPubWorksMenuPermissionBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentPubWorksMenuPermissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_pub_works_menu_permission, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPubWorksMenuPermissionBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentPubWorksMenuPermissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_pub_works_menu_permission, null, false, component);
    }

    @Nullable
    public PubWorkMenuPermissionFragment.a f() {
        return this.f36939a;
    }

    @Nullable
    public PubWorkMenuPermissionModel g() {
        return this.f14286a;
    }

    public abstract void l(@Nullable PubWorkMenuPermissionFragment.a click);

    public abstract void m(@Nullable PubWorkMenuPermissionModel vm);
}
