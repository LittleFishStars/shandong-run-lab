package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.widget.PostNineGridView;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostItemBean f14614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksLayoutPostCommentBinding f14615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PostNineGridView f14617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f14619a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final WorksLayoutPostCommentBinding f14620b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Integer f14621b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final WorksLayoutPostCommentBinding f14622c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final WorksLayoutPostCommentBinding f14623d;

    @NonNull
    public final TextView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final WorksLayoutPostCommentBinding f14624e;

    @NonNull
    public final TextView f;

    public WorksItemPostBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, ImageView ivShare, BLOperateAnimView llLike, LinearLayout llShare, PostNineGridView nineGridLayout, WorksLayoutPostCommentBinding postCommentFive, WorksLayoutPostCommentBinding postCommentFour, WorksLayoutPostCommentBinding postCommentOne, WorksLayoutPostCommentBinding postCommentThree, WorksLayoutPostCommentBinding postCommentTwo, FrameLayout postNum, TextView tvCommentNum, TextView tvContent, TextView tvNickName, TextView tvPostTime, TextView tvShare, TextView tvTop, BLLinearLayout vCommentContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14613a = ivAvatar;
        this.f14610a = ivShare;
        this.f14616a = llLike;
        this.f14611a = llShare;
        this.f14617a = nineGridLayout;
        this.f14615a = postCommentFive;
        this.f14620b = postCommentFour;
        this.f14622c = postCommentOne;
        this.f14623d = postCommentThree;
        this.f14624e = postCommentTwo;
        this.f37043a = postNum;
        this.f14612a = tvCommentNum;
        this.b = tvContent;
        this.c = tvNickName;
        this.d = tvPostTime;
        this.e = tvShare;
        this.f = tvTop;
        this.f14618a = vCommentContainer;
    }

    public static WorksItemPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPostBinding) ViewDataBinding.bind(component, view, R.layout.works_item_post);
    }

    @NonNull
    public static WorksItemPostBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPostBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPostBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPostBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_post, null, false, component);
    }

    @Nullable
    public Integer f() {
        return this.f14621b;
    }

    @Nullable
    public Integer g() {
        return this.f14619a;
    }

    @Nullable
    public PostItemBean h() {
        return this.f14614a;
    }

    public abstract void m(@Nullable Integer position);

    public abstract void n(@Nullable Integer postType);

    public abstract void o(@Nullable PostItemBean vm);
}
