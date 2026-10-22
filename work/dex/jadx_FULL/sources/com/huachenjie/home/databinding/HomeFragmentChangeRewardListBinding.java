package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.page.change_reward.ChangeRewardListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentChangeRewardListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChangeRewardListVM f34245a;

    public HomeFragmentChangeRewardListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeFragmentChangeRewardListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentChangeRewardListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentChangeRewardListBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_change_reward_list);
    }

    @NonNull
    public static HomeFragmentChangeRewardListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentChangeRewardListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentChangeRewardListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentChangeRewardListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_change_reward_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentChangeRewardListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentChangeRewardListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_change_reward_list, null, false, obj);
    }

    @Nullable
    public ChangeRewardListVM f() {
        return this.f34245a;
    }

    public abstract void k(@Nullable ChangeRewardListVM changeRewardListVM);
}
