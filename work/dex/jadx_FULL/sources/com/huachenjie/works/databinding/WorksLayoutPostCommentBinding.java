package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksLayoutPostCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostItemBean f14784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f14785a;

    @NonNull
    public final TextView b;

    public WorksLayoutPostCommentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView commentContent, TextView commentTime, AvatarView commentUserAvatar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37100a = commentContent;
        this.b = commentTime;
        this.f14783a = commentUserAvatar;
    }

    public static WorksLayoutPostCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksLayoutPostCommentBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksLayoutPostCommentBinding) ViewDataBinding.bind(component, view, R.layout.works_layout_post_comment);
    }

    @NonNull
    public static WorksLayoutPostCommentBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksLayoutPostCommentBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksLayoutPostCommentBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksLayoutPostCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_layout_post_comment, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksLayoutPostCommentBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksLayoutPostCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_layout_post_comment, null, false, component);
    }

    @Nullable
    public Integer f() {
        return this.f14785a;
    }

    @Nullable
    public PostItemBean g() {
        return this.f14784a;
    }

    public abstract void l(@Nullable Integer index);

    public abstract void m(@Nullable PostItemBean vm);
}
