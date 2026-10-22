package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutSunRunPaceInfoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f35715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f12208a;

    public RunLayoutSunRunPaceInfoBinding(Object _bindingComponent, View _root, int _localFieldCount, ShadowFrameLayout paceCard) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35715a = paceCard;
    }

    public static RunLayoutSunRunPaceInfoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutSunRunPaceInfoBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutSunRunPaceInfoBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_sun_run_pace_info);
    }

    @NonNull
    public static RunLayoutSunRunPaceInfoBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutSunRunPaceInfoBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutSunRunPaceInfoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutSunRunPaceInfoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_sun_run_pace_info, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutSunRunPaceInfoBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutSunRunPaceInfoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_sun_run_pace_info, null, false, component);
    }

    @Nullable
    public SunshineRunVM f() {
        return this.f12208a;
    }

    public abstract void k(@Nullable SunshineRunVM vm);
}
