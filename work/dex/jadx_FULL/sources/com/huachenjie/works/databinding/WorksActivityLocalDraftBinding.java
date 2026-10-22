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
import com.huachenjie.works.R;
import com.huachenjie.works.page.local.LocalDraftActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityLocalDraftBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LocalDraftActivity f13878a;

    public WorksActivityLocalDraftBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36784a = flContainer;
    }

    public static WorksActivityLocalDraftBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityLocalDraftBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityLocalDraftBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_local_draft);
    }

    @NonNull
    public static WorksActivityLocalDraftBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityLocalDraftBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityLocalDraftBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityLocalDraftBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_local_draft, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityLocalDraftBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityLocalDraftBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_local_draft, null, false, component);
    }

    @Nullable
    public LocalDraftActivity f() {
        return this.f13878a;
    }

    public abstract void k(@Nullable LocalDraftActivity vm);
}
