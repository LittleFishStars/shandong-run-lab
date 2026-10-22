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
import com.huachenjie.works.page.comment.report.CommentOptDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogCommentOptBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CommentOptDialog.a f36860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f14070a;

    public WorksDialogCommentOptBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksDialogCommentOptBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogCommentOptBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogCommentOptBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_comment_opt);
    }

    @NonNull
    public static WorksDialogCommentOptBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogCommentOptBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentOptBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogCommentOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment_opt, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogCommentOptBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogCommentOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_comment_opt, null, false, component);
    }

    @Nullable
    public CommentOptDialog.a f() {
        return this.f36860a;
    }

    @Nullable
    public Boolean g() {
        return this.f14070a;
    }

    public abstract void l(@Nullable CommentOptDialog.a click);

    public abstract void m(@Nullable Boolean isSelf);
}
