package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityReplenishEnergyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f36100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f12764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReplenishEnergyVM f12765a;

    public ActivityReplenishEnergyBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f12764a = slidingTabLayout2;
        this.f36100a = viewPager2;
    }

    public static ActivityReplenishEnergyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityReplenishEnergyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityReplenishEnergyBinding) ViewDataBinding.bind(obj, view, R.layout.activity_replenish_energy);
    }

    @NonNull
    public static ActivityReplenishEnergyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityReplenishEnergyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityReplenishEnergyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityReplenishEnergyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_replenish_energy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityReplenishEnergyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityReplenishEnergyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_replenish_energy, null, false, obj);
    }

    @Nullable
    public ReplenishEnergyVM f() {
        return this.f12765a;
    }

    public abstract void k(@Nullable ReplenishEnergyVM replenishEnergyVM);
}
