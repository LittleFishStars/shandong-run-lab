package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.comment.me_list.CommentOnMeListModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityCommentOnMeListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f13841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f13842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentOnMeListModel f13844a;

    public WorksActivityCommentOnMeListBinding(Object _bindingComponent, View _root, int _localFieldCount, SwipeRefreshLayout refreshLayout, RecyclerView rvList, LayoutToolbarBindingBinding toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13842a = refreshLayout;
        this.f36775a = rvList;
        this.f13843a = toolbar;
    }

    public static WorksActivityCommentOnMeListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityCommentOnMeListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityCommentOnMeListBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_comment_on_me_list);
    }

    @NonNull
    public static WorksActivityCommentOnMeListBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityCommentOnMeListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityCommentOnMeListBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityCommentOnMeListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_comment_on_me_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityCommentOnMeListBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityCommentOnMeListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_comment_on_me_list, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f13841a;
    }

    @Nullable
    public CommentOnMeListModel g() {
        return this.f13844a;
    }

    public abstract void l(@Nullable CommentOnMeListModel vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
