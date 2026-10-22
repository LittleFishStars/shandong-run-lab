package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.social_contact.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentUserWearSuitBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f36167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f12931a;

    public FragmentUserWearSuitBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f12931a = tabLayout;
        this.f36167a = viewPager2;
    }

    public static FragmentUserWearSuitBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserWearSuitBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentUserWearSuitBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_user_wear_suit);
    }

    @NonNull
    public static FragmentUserWearSuitBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentUserWearSuitBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearSuitBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentUserWearSuitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_suit, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearSuitBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentUserWearSuitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_suit, null, false, obj);
    }
}
