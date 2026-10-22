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
import com.huachenjie.mine.page.home.topic.MyTopicVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentMyTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f35332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyTopicVM f11291a;

    public MineFragmentMyTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentMyTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentMyTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentMyTopicBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_my_topic);
    }

    @NonNull
    public static MineFragmentMyTopicBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentMyTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentMyTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentMyTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_my_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentMyTopicBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentMyTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_my_topic, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f35332a;
    }

    @Nullable
    public MyTopicVM g() {
        return this.f11291a;
    }

    public abstract void l(@Nullable MyTopicVM myTopicVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
