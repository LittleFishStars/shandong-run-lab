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
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;
import com.zj.adlib.cy6;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemOrderDetailGoodsBindingImpl extends MallItemOrderDetailGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35020a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10863a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10864a;

    public MallItemOrderDetailGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10863a, f35020a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        RequestOptions requestOptions;
        String str3;
        String string;
        String str4;
        boolean afterSaleApplyFlag;
        String goodsName;
        String goodsSpec;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10864a;
            this.f10864a = 0L;
        }
        OrderGoodsBean orderGoodsBean = ((MallItemOrderDetailGoodsBinding) this).f10860a;
        long j4 = j & 3;
        String str5 = null;
        if (j4 != 0) {
            requestOptions = ju3.m;
            if (orderGoodsBean != null) {
                String goodsImage = orderGoodsBean.getGoodsImage();
                int payPointsUnit = orderGoodsBean.getPayPointsUnit();
                String goodsUnitPrice = orderGoodsBean.getGoodsUnitPrice();
                int goodsCount = orderGoodsBean.getGoodsCount();
                afterSaleApplyFlag = orderGoodsBean.getAfterSaleApplyFlag();
                goodsName = orderGoodsBean.getGoodsName();
                goodsSpec = orderGoodsBean.getGoodsSpec();
                i = goodsCount;
                str3 = goodsImage;
                str5 = goodsUnitPrice;
                i2 = payPointsUnit;
            } else {
                str3 = null;
                goodsName = null;
                goodsSpec = null;
                i = 0;
                i2 = 0;
                afterSaleApplyFlag = false;
            }
            if (j4 != 0) {
                if (afterSaleApplyFlag) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            String strF = cy6.f(str5, i2);
            str = "x" + i;
            string = ((MallItemOrderDetailGoodsBinding) this).f10859a.getResources().getString(afterSaleApplyFlag ? R.string.mall_order_detail_refund : R.string.mall_order_detail_refunding);
            str2 = strF;
            str4 = goodsName;
            str5 = goodsSpec;
        } else {
            str = null;
            str2 = null;
            requestOptions = null;
            str3 = null;
            string = null;
            str4 = null;
            afterSaleApplyFlag = false;
        }
        boolean zIsSaleProcessing = ((4 & j) == 0 || orderGoodsBean == null) ? false : orderGoodsBean.isSaleProcessing();
        long j5 = j & 3;
        if (j5 == 0) {
            zIsSaleProcessing = false;
        } else if (afterSaleApplyFlag) {
            zIsSaleProcessing = true;
        }
        if (j5 != 0) {
            CommonBindingAdapter.b0(((MallItemOrderDetailGoodsBinding) this).f10862a, str3, requestOptions, false);
            CommonBindingAdapter.l0(((MallItemOrderDetailGoodsBinding) this).f10859a, zIsSaleProcessing);
            TextViewBindingAdapter.setText(((MallItemOrderDetailGoodsBinding) this).f10859a, string);
            TextViewBindingAdapter.setText(this.b, str4);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(((MallItemOrderDetailGoodsBinding) this).f10861a, str2);
            TextViewBindingAdapter.setText(this.d, str5);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10864a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10864a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemOrderDetailGoodsBinding
    public void k(@Nullable OrderGoodsBean orderGoodsBean) {
        ((MallItemOrderDetailGoodsBinding) this).f10860a = orderGoodsBean;
        synchronized (this) {
            this.f10864a |= 1;
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

    public MallItemOrderDetailGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[3], (PriceView) objArr[5], (TextView) objArr[4]);
        this.f10864a = -1L;
        ((MallItemOrderDetailGoodsBinding) this).f10862a.setTag(null);
        ((MallItemOrderDetailGoodsBinding) this).f35019a.setTag(null);
        ((MallItemOrderDetailGoodsBinding) this).f10859a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        ((MallItemOrderDetailGoodsBinding) this).f10861a.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
