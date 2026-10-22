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
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.SearchVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivitySearchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchViewV2 f13941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchVM f13942a;

    public WorksActivitySearchBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContainer, CommonSearchViewV2 searchView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36806a = flContainer;
        this.f13941a = searchView;
    }

    public static WorksActivitySearchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivitySearchBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivitySearchBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_search);
    }

    @NonNull
    public static WorksActivitySearchBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivitySearchBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivitySearchBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivitySearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_search, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivitySearchBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivitySearchBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_search, null, false, component);
    }

    @Nullable
    public SearchVM f() {
        return this.f13942a;
    }

    public abstract void k(@Nullable SearchVM vm);
}
