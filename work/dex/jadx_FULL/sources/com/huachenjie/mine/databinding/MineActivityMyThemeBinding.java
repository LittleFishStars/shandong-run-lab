package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import com.huachenjie.mine.page.my_theme.MyThemeViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineActivityMyThemeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyThemeActivity.a f35300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyThemeViewModel f11212a;

    public MineActivityMyThemeBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineActivityMyThemeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineActivityMyThemeBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineActivityMyThemeBinding) ViewDataBinding.bind(obj, view, R.layout.mine_activity_my_theme);
    }

    @NonNull
    public static MineActivityMyThemeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineActivityMyThemeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineActivityMyThemeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineActivityMyThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_my_theme, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineActivityMyThemeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineActivityMyThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_my_theme, null, false, obj);
    }

    @Nullable
    public MyThemeActivity.a f() {
        return this.f35300a;
    }

    @Nullable
    public MyThemeViewModel g() {
        return this.f11212a;
    }

    public abstract void l(@Nullable MyThemeActivity.a aVar);

    public abstract void m(@Nullable MyThemeViewModel myThemeViewModel);
}
