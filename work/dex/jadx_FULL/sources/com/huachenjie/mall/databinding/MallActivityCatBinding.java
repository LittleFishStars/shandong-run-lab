package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityCatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10150a;

    public MallActivityCatBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f34774a = frameLayout;
    }

    public static MallActivityCatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityCatBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityCatBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_cat);
    }

    @NonNull
    public static MallActivityCatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityCatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityCatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityCatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_cat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityCatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityCatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_cat, null, false, obj);
    }

    @Nullable
    public BaseTitleViewModel f() {
        return this.f10150a;
    }

    public abstract void k(@Nullable BaseTitleViewModel baseTitleViewModel);
}
