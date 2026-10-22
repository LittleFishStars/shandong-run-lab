package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.comment.base.BaseCommentVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentBaseCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewStubProxy f36900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseCommentVM f14177a;

    public WorksFragmentBaseCommentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, ViewStubProxy vsTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14176a = recyclerView;
        this.f36900a = vsTitle;
    }

    public static WorksFragmentBaseCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentBaseCommentBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentBaseCommentBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_base_comment);
    }

    @NonNull
    public static WorksFragmentBaseCommentBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentBaseCommentBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentBaseCommentBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentBaseCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_base_comment, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentBaseCommentBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentBaseCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_base_comment, null, false, component);
    }

    @Nullable
    public BaseCommentVM f() {
        return this.f14177a;
    }

    public abstract void k(@Nullable BaseCommentVM vm);
}
