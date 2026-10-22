package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.post.MyPostVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f35335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyPostVM f11298a;

    public MineFragmentPostBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentPostBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentPostBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_post);
    }

    @NonNull
    public static MineFragmentPostBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentPostBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentPostBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_post, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentPostBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_post, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f35335a;
    }

    @Nullable
    public MyPostVM g() {
        return this.f11298a;
    }

    public abstract void l(@Nullable MyPostVM myPostVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
