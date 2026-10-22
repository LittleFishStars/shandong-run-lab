package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationVM;
import com.huachenjie.mall.widget.PriceView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogGoodsSpecificationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f10570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsSpecificationDialog.a f10571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsSpecificationVM f10572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10573a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10574b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f10575c;

    public MallDialogGoodsSpecificationBinding(Object obj, View view, int i, CardView cardView, EditText editText, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, PriceView priceView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f10570a = cardView;
        this.f34916a = editText;
        this.f10567a = imageView;
        this.f10568a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.f10573a = priceView;
        this.f10569a = textView;
        this.f10574b = textView2;
        this.f10575c = textView3;
    }

    public static MallDialogGoodsSpecificationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogGoodsSpecificationBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogGoodsSpecificationBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_goods_specification);
    }

    @NonNull
    public static MallDialogGoodsSpecificationBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogGoodsSpecificationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogGoodsSpecificationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogGoodsSpecificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_goods_specification, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogGoodsSpecificationBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogGoodsSpecificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_goods_specification, null, false, obj);
    }

    @Nullable
    public GoodsSpecificationDialog.a f() {
        return this.f10571a;
    }

    @Nullable
    public GoodsSpecificationVM g() {
        return this.f10572a;
    }

    public abstract void l(@Nullable GoodsSpecificationDialog.a aVar);

    public abstract void m(@Nullable GoodsSpecificationVM goodsSpecificationVM);
}
