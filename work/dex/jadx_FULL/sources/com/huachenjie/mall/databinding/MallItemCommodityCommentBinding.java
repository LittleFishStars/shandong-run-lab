package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.CommodityCommentBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemCommodityCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f10748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommodityCommentBean f10749a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10750b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10751c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10752d;

    @NonNull
    public final RoundImageView e;

    @NonNull
    public final RoundImageView f;

    public MallItemCommodityCommentBinding(Object obj, View view, int i, AvatarView avatarView, RoundImageView roundImageView, RoundImageView roundImageView2, RoundImageView roundImageView3, RoundImageView roundImageView4, RoundImageView roundImageView5, RoundImageView roundImageView6, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f10748a = avatarView;
        this.f10747a = roundImageView;
        this.f10750b = roundImageView2;
        this.f10751c = roundImageView3;
        this.f10752d = roundImageView4;
        this.e = roundImageView5;
        this.f = roundImageView6;
        this.f34984a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static MallItemCommodityCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemCommodityCommentBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemCommodityCommentBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_commodity_comment);
    }

    @NonNull
    public static MallItemCommodityCommentBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemCommodityCommentBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemCommodityCommentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemCommodityCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_commodity_comment, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemCommodityCommentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemCommodityCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_commodity_comment, null, false, obj);
    }

    @Nullable
    public CommodityCommentBean f() {
        return this.f10749a;
    }

    public abstract void k(@Nullable CommodityCommentBean commodityCommentBean);
}
