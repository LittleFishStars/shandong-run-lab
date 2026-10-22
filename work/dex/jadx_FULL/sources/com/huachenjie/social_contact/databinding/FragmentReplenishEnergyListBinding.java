package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentReplenishEnergyListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ReplenishEnergyListVM f36161a;

    public FragmentReplenishEnergyListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static FragmentReplenishEnergyListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReplenishEnergyListBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentReplenishEnergyListBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_replenish_energy_list);
    }

    @NonNull
    public static FragmentReplenishEnergyListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentReplenishEnergyListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentReplenishEnergyListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentReplenishEnergyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_replenish_energy_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentReplenishEnergyListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentReplenishEnergyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_replenish_energy_list, null, false, obj);
    }

    @Nullable
    public ReplenishEnergyListVM f() {
        return this.f36161a;
    }

    public abstract void k(@Nullable ReplenishEnergyListVM replenishEnergyListVM);
}
