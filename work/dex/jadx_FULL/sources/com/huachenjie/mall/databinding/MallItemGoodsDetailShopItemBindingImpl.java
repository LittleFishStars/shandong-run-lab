package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.widget.PriceView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsDetailShopItemBindingImpl extends MallItemGoodsDetailShopItemBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35008a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10819a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10824a;

    public MallItemGoodsDetailShopItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10819a, f35008a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String goodsName;
        synchronized (this) {
            j = this.f10820a;
            this.f10820a = 0L;
        }
        CommodityBean commodityBean = ((MallItemGoodsDetailShopItemBinding) this).f35007a;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (commodityBean != null) {
                String priceStr = commodityBean.getPriceStr();
                String goodsCover = commodityBean.getGoodsCover();
                goodsName = commodityBean.getGoodsName();
                str = priceStr;
                str2 = goodsCover;
            } else {
                str = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(this.f10821a, str2, requestOptions, false);
                TextViewBindingAdapter.setText(this.f10823a, goodsName);
                TextViewBindingAdapter.setText(this.f10824a, str);
            }
        }
        requestOptions = null;
        str = null;
        goodsName = str;
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10821a, str2, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10823a, goodsName);
            TextViewBindingAdapter.setText(this.f10824a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10820a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10820a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsDetailShopItemBinding
    public void k(@Nullable CommodityBean commodityBean) {
        ((MallItemGoodsDetailShopItemBinding) this).f35007a = commodityBean;
        synchronized (this) {
            this.f10820a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((CommodityBean) obj);
        return true;
    }

    public MallItemGoodsDetailShopItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10820a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10822a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10821a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10823a = textView;
        textView.setTag(null);
        PriceView priceView = (PriceView) objArr[3];
        this.f10824a = priceView;
        priceView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
