package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;
import com.zj.adlib.cy6;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemMyOrderGoodsBindingImpl extends MallItemMyOrderGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35018a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10856a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10858a;

    public MallItemMyOrderGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10856a, f35018a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        String str3;
        String goodsName;
        int i;
        int goodsCount;
        String str4;
        synchronized (this) {
            j = this.f10857a;
            this.f10857a = 0L;
        }
        OrderGoodsBean orderGoodsBean = ((MallItemMyOrderGoodsBinding) this).f10853a;
        long j2 = j & 3;
        String str5 = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (orderGoodsBean != null) {
                String goodsImage = orderGoodsBean.getGoodsImage();
                int payPointsUnit = orderGoodsBean.getPayPointsUnit();
                String goodsUnitPrice = orderGoodsBean.getGoodsUnitPrice();
                goodsCount = orderGoodsBean.getGoodsCount();
                goodsName = orderGoodsBean.getGoodsName();
                String goodsSpec = orderGoodsBean.getGoodsSpec();
                str4 = goodsImage;
                str5 = goodsUnitPrice;
                i = payPointsUnit;
                str2 = goodsSpec;
            } else {
                i = 0;
                goodsCount = 0;
                str4 = null;
                str2 = null;
                goodsName = null;
            }
            String strF = cy6.f(str5, i);
            str3 = String.format("x%d", Integer.valueOf(goodsCount));
            String str6 = str4;
            str = strF;
            str5 = str6;
        } else {
            requestOptions = null;
            str = null;
            str2 = null;
            str3 = null;
            goodsName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallItemMyOrderGoodsBinding) this).f10855a, str5, requestOptions, false);
            TextViewBindingAdapter.setText(((MallItemMyOrderGoodsBinding) this).f35017a, goodsName);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(((MallItemMyOrderGoodsBinding) this).f10854a, str);
            TextViewBindingAdapter.setText(this.c, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10857a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10857a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemMyOrderGoodsBinding
    public void k(@Nullable OrderGoodsBean orderGoodsBean) {
        ((MallItemMyOrderGoodsBinding) this).f10853a = orderGoodsBean;
        synchronized (this) {
            this.f10857a |= 1;
        }
        notifyPropertyChanged(hk0.t);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.t != i) {
            return false;
        }
        k((OrderGoodsBean) obj);
        return true;
    }

    public MallItemMyOrderGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[5], (PriceView) objArr[4], (TextView) objArr[3]);
        this.f10857a = -1L;
        ((MallItemMyOrderGoodsBinding) this).f10855a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10858a = linearLayout;
        linearLayout.setTag(null);
        ((MallItemMyOrderGoodsBinding) this).f35017a.setTag(null);
        this.b.setTag(null);
        ((MallItemMyOrderGoodsBinding) this).f10854a.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
