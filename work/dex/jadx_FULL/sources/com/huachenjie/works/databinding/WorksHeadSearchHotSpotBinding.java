package com.huachenjie.works.databinding;

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
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksHeadSearchHotSpotBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Flow f14386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchHotSpotFragment.a f14388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchHotSpotModel f14389a;

    public WorksHeadSearchHotSpotBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clHistory, Flow flHistory, TextView tvFinishDelete, View vFinishDeleteSplit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14387a = clHistory;
        this.f14386a = flHistory;
        this.f14385a = tvFinishDelete;
        this.f36979a = vFinishDeleteSplit;
    }

    public static WorksHeadSearchHotSpotBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksHeadSearchHotSpotBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksHeadSearchHotSpotBinding) ViewDataBinding.bind(component, view, R.layout.works_head_search_hot_spot);
    }

    @NonNull
    public static WorksHeadSearchHotSpotBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksHeadSearchHotSpotBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksHeadSearchHotSpotBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksHeadSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_search_hot_spot, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksHeadSearchHotSpotBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksHeadSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_search_hot_spot, null, false, component);
    }

    @Nullable
    public SearchHotSpotFragment.a f() {
        return this.f14388a;
    }

    @Nullable
    public SearchHotSpotModel g() {
        return this.f14389a;
    }

    public abstract void l(@Nullable SearchHotSpotFragment.a click);

    public abstract void m(@Nullable SearchHotSpotModel vm);
}
