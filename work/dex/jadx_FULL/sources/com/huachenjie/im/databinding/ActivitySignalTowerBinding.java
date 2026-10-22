package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ActivitySignalTowerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f9653a;

    public ActivitySignalTowerBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f34407a = frameLayout;
    }

    public static ActivitySignalTowerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySignalTowerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySignalTowerBinding) ViewDataBinding.bind(obj, view, R.layout.activity_signal_tower);
    }

    @NonNull
    public static ActivitySignalTowerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySignalTowerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySignalTowerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_signal_tower, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySignalTowerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_signal_tower, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f9653a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
