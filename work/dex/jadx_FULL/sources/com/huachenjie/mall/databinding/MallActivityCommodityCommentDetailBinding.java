package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.comment.detail.CommentDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityCommodityCommentDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommentDetailVM f10173a;

    public MallActivityCommodityCommentDetailBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34781a = recyclerView;
        this.f10172a = layoutToolbarBindingBinding;
    }

    public static MallActivityCommodityCommentDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityCommodityCommentDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityCommodityCommentDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_commodity_comment_detail);
    }

    @NonNull
    public static MallActivityCommodityCommentDetailBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityCommodityCommentDetailBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityCommodityCommentDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityCommodityCommentDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_commodity_comment_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityCommodityCommentDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityCommodityCommentDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_commodity_comment_detail, null, false, obj);
    }

    @Nullable
    public CommentDetailVM f() {
        return this.f10173a;
    }

    public abstract void k(@Nullable CommentDetailVM commentDetailVM);
}
