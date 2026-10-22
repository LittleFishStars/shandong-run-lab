package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.episodes_detail.EpisodesListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentEpisodesListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EpisodesListVM f10673a;

    public MallFragmentEpisodesListBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f34952a = recyclerView;
    }

    public static MallFragmentEpisodesListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentEpisodesListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentEpisodesListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_episodes_list);
    }

    @NonNull
    public static MallFragmentEpisodesListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentEpisodesListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentEpisodesListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentEpisodesListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_episodes_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentEpisodesListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentEpisodesListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_episodes_list, null, false, obj);
    }

    @Nullable
    public EpisodesListVM f() {
        return this.f10673a;
    }

    public abstract void k(@Nullable EpisodesListVM episodesListVM);
}
