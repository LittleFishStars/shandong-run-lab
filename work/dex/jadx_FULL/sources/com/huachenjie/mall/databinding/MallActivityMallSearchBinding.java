package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.home_tab.search.MallSearchActivity;
import com.huachenjie.mall.page.home_tab.search.MallSearchVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityMallSearchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Flow f10266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f10269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MallSearchActivity.a f10270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MallSearchVM f10271a;

    @NonNull
    public final TextView b;

    public MallActivityMallSearchBinding(Object obj, View view, int i, Flow flow, RecyclerView recyclerView, ConstraintLayout constraintLayout, CommonSearchView commonSearchView, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f10266a = flow;
        this.f10268a = recyclerView;
        this.f10267a = constraintLayout;
        this.f10269a = commonSearchView;
        this.f10265a = textView;
        this.b = textView2;
        this.f34811a = view2;
    }

    public static MallActivityMallSearchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityMallSearchBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityMallSearchBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_mall_search);
    }

    @NonNull
    public static MallActivityMallSearchBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityMallSearchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityMallSearchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityMallSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_mall_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityMallSearchBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityMallSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_mall_search, null, false, obj);
    }

    @Nullable
    public MallSearchActivity.a f() {
        return this.f10270a;
    }

    @Nullable
    public MallSearchVM g() {
        return this.f10271a;
    }

    public abstract void l(@Nullable MallSearchActivity.a aVar);

    public abstract void m(@Nullable MallSearchVM mallSearchVM);
}
