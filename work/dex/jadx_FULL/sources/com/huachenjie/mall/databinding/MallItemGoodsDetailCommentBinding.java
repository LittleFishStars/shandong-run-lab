package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailOneGoodsComment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsDetailCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailOneGoodsComment f10802a;

    @NonNull
    public final ImageView b;

    public MallItemGoodsDetailCommentBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f35001a = imageView;
        this.b = imageView2;
        this.f10801a = textView;
    }

    public static MallItemGoodsDetailCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsDetailCommentBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsDetailCommentBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_detail_comment);
    }

    @NonNull
    public static MallItemGoodsDetailCommentBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsDetailCommentBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailCommentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsDetailCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_comment, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailCommentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsDetailCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_comment, null, false, obj);
    }

    @Nullable
    public GoodsDetailOneGoodsComment f() {
        return this.f10802a;
    }

    public abstract void k(@Nullable GoodsDetailOneGoodsComment goodsDetailOneGoodsComment);
}
