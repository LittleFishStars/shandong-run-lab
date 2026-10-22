package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.flyco.tablayout.SlideTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.AlumniVM;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentAlumniBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlideTabLayout f14151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AlumniVM f14152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f14153a;

    public WorksFragmentAlumniBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout fragmentSubContainer, SlideTabLayout headerTabLayout, BLView vStatusBarMask) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36892a = fragmentSubContainer;
        this.f14151a = headerTabLayout;
        this.f14153a = vStatusBarMask;
    }

    public static WorksFragmentAlumniBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentAlumniBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentAlumniBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_alumni);
    }

    @NonNull
    public static WorksFragmentAlumniBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentAlumniBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni, null, false, component);
    }

    @Nullable
    public AlumniVM f() {
        return this.f14152a;
    }

    public abstract void k(@Nullable AlumniVM vm);
}
