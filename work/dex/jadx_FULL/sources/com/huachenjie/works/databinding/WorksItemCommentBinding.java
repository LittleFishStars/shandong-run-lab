package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentBean f14521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f14523a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Integer f14524b;

    @NonNull
    public final TextView c;

    public WorksItemCommentBinding(Object _bindingComponent, View _root, int _localFieldCount, BLOperateAnimView btLike, AvatarView ivAvatar, ImageView ivPic, TextView tvContent, TextView tvName, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14522a = btLike;
        this.f14520a = ivAvatar;
        this.f37017a = ivPic;
        this.f14519a = tvContent;
        this.b = tvName;
        this.c = tvTime;
    }

    public static WorksItemCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemCommentBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemCommentBinding) ViewDataBinding.bind(component, view, R.layout.works_item_comment);
    }

    @NonNull
    public static WorksItemCommentBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemCommentBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemCommentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment, null, false, component);
    }

    @Nullable
    public CommentBean f() {
        return this.f14521a;
    }

    @Nullable
    public Integer g() {
        return this.f14523a;
    }

    @Nullable
    public Integer h() {
        return this.f14524b;
    }

    public abstract void m(@Nullable CommentBean bean);

    public abstract void n(@Nullable Integer commentType);

    public abstract void o(@Nullable Integer source);
}
