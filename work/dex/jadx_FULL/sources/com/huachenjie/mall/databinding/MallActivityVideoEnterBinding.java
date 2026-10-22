package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.video_enter.VideoEnterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityVideoEnterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f10474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VideoEnterVM f10476a;

    public MallActivityVideoEnterBinding(Object obj, View view, int i, TabLayout tabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f10474a = tabLayout;
        this.f10475a = layoutToolbarBindingBinding;
        this.f34885a = viewPager2;
    }

    public static MallActivityVideoEnterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityVideoEnterBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityVideoEnterBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_video_enter);
    }

    @NonNull
    public static MallActivityVideoEnterBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityVideoEnterBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityVideoEnterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityVideoEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_video_enter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityVideoEnterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityVideoEnterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_video_enter, null, false, obj);
    }

    @Nullable
    public VideoEnterVM f() {
        return this.f10476a;
    }

    public abstract void k(@Nullable VideoEnterVM videoEnterVM);
}
