package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.share.ShareActionClick;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutShareActionPanelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public BaseViewModel f35701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareActionClick f12169a;

    public RunLayoutShareActionPanelBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunLayoutShareActionPanelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutShareActionPanelBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutShareActionPanelBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_share_action_panel);
    }

    @NonNull
    public static RunLayoutShareActionPanelBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutShareActionPanelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutShareActionPanelBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutShareActionPanelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_share_action_panel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutShareActionPanelBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutShareActionPanelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_share_action_panel, null, false, component);
    }

    @Nullable
    public ShareActionClick f() {
        return this.f12169a;
    }

    @Nullable
    public BaseViewModel g() {
        return this.f35701a;
    }

    public abstract void l(@Nullable ShareActionClick click);

    public abstract void m(@Nullable BaseViewModel vm);
}
