package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutPaceListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12108a;

    public RunLayoutPaceListBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llPacePerKilometer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35680a = llPacePerKilometer;
    }

    public static RunLayoutPaceListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutPaceListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutPaceListBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_pace_list);
    }

    @NonNull
    public static RunLayoutPaceListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutPaceListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutPaceListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutPaceListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_pace_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutPaceListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutPaceListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_pace_list, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12108a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
