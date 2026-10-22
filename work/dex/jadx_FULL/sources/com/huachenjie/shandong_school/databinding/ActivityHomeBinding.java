package com.huachenjie.shandong_school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;
import com.huachenjie.shandong_school.home.HomeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class ActivityHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawerLayout f12624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutHomeTabBarBinding f12625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeActivity.a f12626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeVM f12627a;

    public ActivityHomeBinding(Object obj, View view, int i, DrawerLayout drawerLayout, FrameLayout frameLayout, LayoutHomeTabBarBinding layoutHomeTabBarBinding) {
        super(obj, view, i);
        this.f12624a = drawerLayout;
        this.f36019a = frameLayout;
        this.f12625a = layoutHomeTabBarBinding;
    }

    public static ActivityHomeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_home);
    }

    @NonNull
    public static ActivityHomeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityHomeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityHomeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityHomeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, null, false, obj);
    }

    @Nullable
    public HomeActivity.a f() {
        return this.f12626a;
    }

    @Nullable
    public HomeVM g() {
        return this.f12627a;
    }

    public abstract void l(@Nullable HomeActivity.a aVar);

    public abstract void m(@Nullable HomeVM homeVM);
}
