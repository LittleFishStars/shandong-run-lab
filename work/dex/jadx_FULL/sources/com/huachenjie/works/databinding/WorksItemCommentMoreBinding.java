package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentMoreBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemCommentMoreBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CommentMoreBean f37019a;

    public WorksItemCommentMoreBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemCommentMoreBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemCommentMoreBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemCommentMoreBinding) ViewDataBinding.bind(component, view, R.layout.works_item_comment_more);
    }

    @NonNull
    public static WorksItemCommentMoreBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemCommentMoreBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentMoreBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemCommentMoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_more, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentMoreBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemCommentMoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_more, null, false, component);
    }

    @Nullable
    public CommentMoreBean f() {
        return this.f37019a;
    }

    public abstract void k(@Nullable CommentMoreBean bean);
}
