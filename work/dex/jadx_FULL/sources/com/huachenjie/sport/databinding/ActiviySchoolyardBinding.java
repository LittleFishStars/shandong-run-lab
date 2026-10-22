package com.huachenjie.sport.databinding;

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
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.SchoolyardActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActiviySchoolyardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f36440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f13377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f13378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolyardActivity.a f13379a;

    public ActiviySchoolyardBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f13377a = tabLayout;
        this.f36440a = viewPager2;
    }

    public static ActiviySchoolyardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActiviySchoolyardBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActiviySchoolyardBinding) ViewDataBinding.bind(obj, view, R.layout.activiy_schoolyard);
    }

    @NonNull
    public static ActiviySchoolyardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActiviySchoolyardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActiviySchoolyardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActiviySchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activiy_schoolyard, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActiviySchoolyardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActiviySchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activiy_schoolyard, null, false, obj);
    }

    @Nullable
    public SchoolyardActivity.a f() {
        return this.f13379a;
    }

    @Nullable
    public BaseVM g() {
        return this.f13378a;
    }

    public abstract void l(@Nullable SchoolyardActivity.a aVar);

    public abstract void m(@Nullable BaseVM baseVM);
}
