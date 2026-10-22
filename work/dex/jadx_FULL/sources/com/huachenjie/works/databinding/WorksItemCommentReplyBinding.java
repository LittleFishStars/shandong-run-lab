package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemCommentReplyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Flow f14545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentReplyBean f14547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f14549a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Integer f14550b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WorksItemCommentReplyBinding(Object _bindingComponent, View _root, int _localFieldCount, BLOperateAnimView btLike, Flow flow, AvatarView ivAvatar, ImageView ivPic, TextView tvContent, TextView tvName, TextView tvReply, TextView tvReplyName, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14548a = btLike;
        this.f14545a = flow;
        this.f14546a = ivAvatar;
        this.f37023a = ivPic;
        this.f14544a = tvContent;
        this.b = tvName;
        this.c = tvReply;
        this.d = tvReplyName;
        this.e = tvTime;
    }

    public static WorksItemCommentReplyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemCommentReplyBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemCommentReplyBinding) ViewDataBinding.bind(component, view, R.layout.works_item_comment_reply);
    }

    @NonNull
    public static WorksItemCommentReplyBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemCommentReplyBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentReplyBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemCommentReplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_reply, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentReplyBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemCommentReplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_reply, null, false, component);
    }

    @Nullable
    public CommentReplyBean f() {
        return this.f14547a;
    }

    @Nullable
    public Integer g() {
        return this.f14549a;
    }

    @Nullable
    public Integer h() {
        return this.f14550b;
    }

    public abstract void m(@Nullable CommentReplyBean bean);

    public abstract void n(@Nullable Integer commentType);

    public abstract void o(@Nullable Integer source);
}
