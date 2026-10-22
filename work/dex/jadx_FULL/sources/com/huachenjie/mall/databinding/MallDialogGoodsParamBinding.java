package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsParamDialog;
import com.huachenjie.mall.page.goods_detail.GoodsParamVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogGoodsParamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f10557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsParamDialog.a f10558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsParamVM f10559a;

    public MallDialogGoodsParamBinding(Object obj, View view, int i, CardView cardView, TextView textView) {
        super(obj, view, i);
        this.f10557a = cardView;
        this.f34913a = textView;
    }

    public static MallDialogGoodsParamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogGoodsParamBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogGoodsParamBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_goods_param);
    }

    @NonNull
    public static MallDialogGoodsParamBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogGoodsParamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogGoodsParamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogGoodsParamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_goods_param, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogGoodsParamBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogGoodsParamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_goods_param, null, false, obj);
    }

    @Nullable
    public GoodsParamDialog.a f() {
        return this.f10558a;
    }

    @Nullable
    public GoodsParamVM g() {
        return this.f10559a;
    }

    public abstract void l(@Nullable GoodsParamDialog.a aVar);

    public abstract void m(@Nullable GoodsParamVM goodsParamVM);
}
