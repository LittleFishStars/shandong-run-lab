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
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.noober.background.view.BLCheckBox;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemCommentOnMeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentOnMeBean f14536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLCheckBox f14537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14539a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WorksItemCommentOnMeBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btComment, BLCheckBox cbLike, AvatarView ivAvatar, BLImageView ivCover, TextView tvCommentImage, TextView tvContent, TextView tvName, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14539a = btComment;
        this.f14537a = cbLike;
        this.f14535a = ivAvatar;
        this.f14538a = ivCover;
        this.f37021a = tvCommentImage;
        this.b = tvContent;
        this.c = tvName;
        this.d = tvTime;
    }

    public static WorksItemCommentOnMeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemCommentOnMeBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemCommentOnMeBinding) ViewDataBinding.bind(component, view, R.layout.works_item_comment_on_me);
    }

    @NonNull
    public static WorksItemCommentOnMeBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemCommentOnMeBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentOnMeBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemCommentOnMeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_on_me, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemCommentOnMeBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemCommentOnMeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_comment_on_me, null, false, component);
    }

    @Nullable
    public CommentOnMeBean f() {
        return this.f14536a;
    }

    public abstract void k(@Nullable CommentOnMeBean bean);
}
