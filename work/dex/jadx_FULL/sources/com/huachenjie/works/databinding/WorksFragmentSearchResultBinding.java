package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.result.SearchResultModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchResultBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f14306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f14307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultModel f14308a;

    public WorksFragmentSearchResultBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout cardView, SelectBoldTabLayout tabLayout, ViewPager2 vp) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36948a = cardView;
        this.f14307a = tabLayout;
        this.f14306a = vp;
    }

    public static WorksFragmentSearchResultBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchResultBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchResultBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_result);
    }

    @NonNull
    public static WorksFragmentSearchResultBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchResultBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchResultBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchResultBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result, null, false, component);
    }

    @Nullable
    public SearchResultModel f() {
        return this.f14308a;
    }

    public abstract void k(@Nullable SearchResultModel vm);
}
