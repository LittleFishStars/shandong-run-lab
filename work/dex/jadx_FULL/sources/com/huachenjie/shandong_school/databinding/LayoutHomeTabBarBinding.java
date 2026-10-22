package com.huachenjie.shandong_school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.BottomIconView;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class LayoutHomeTabBarBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BottomIconView f36041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeActivity.a f12664a;

    @NonNull
    public final BottomIconView b;

    @NonNull
    public final BottomIconView c;

    @NonNull
    public final BottomIconView d;

    @NonNull
    public final BottomIconView e;

    public LayoutHomeTabBarBinding(Object obj, View view, int i, BottomIconView bottomIconView, BottomIconView bottomIconView2, BottomIconView bottomIconView3, BottomIconView bottomIconView4, BottomIconView bottomIconView5) {
        super(obj, view, i);
        this.f36041a = bottomIconView;
        this.b = bottomIconView2;
        this.c = bottomIconView3;
        this.d = bottomIconView4;
        this.e = bottomIconView5;
    }

    public static LayoutHomeTabBarBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutHomeTabBarBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutHomeTabBarBinding) ViewDataBinding.bind(obj, view, R.layout.layout_home_tab_bar);
    }

    @NonNull
    public static LayoutHomeTabBarBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutHomeTabBarBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutHomeTabBarBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutHomeTabBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_home_tab_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutHomeTabBarBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutHomeTabBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_home_tab_bar, null, false, obj);
    }

    @Nullable
    public HomeActivity.a f() {
        return this.f12664a;
    }

    public abstract void k(@Nullable HomeActivity.a aVar);
}
