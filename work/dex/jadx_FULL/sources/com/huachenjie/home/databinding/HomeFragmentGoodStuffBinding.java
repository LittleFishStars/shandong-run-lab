package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.home.R;
import com.huachenjie.home.page.good_stuff.GoodStuffVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentGoodStuffBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffVM f9402a;

    public HomeFragmentGoodStuffBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f34247a = recyclerView;
    }

    public static HomeFragmentGoodStuffBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentGoodStuffBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentGoodStuffBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_good_stuff);
    }

    @NonNull
    public static HomeFragmentGoodStuffBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentGoodStuffBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentGoodStuffBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_good_stuff, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentGoodStuffBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_good_stuff, null, false, obj);
    }

    @Nullable
    public GoodStuffVM f() {
        return this.f9402a;
    }

    public abstract void k(@Nullable GoodStuffVM goodStuffVM);
}
