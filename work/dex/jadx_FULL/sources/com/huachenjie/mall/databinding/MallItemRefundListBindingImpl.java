package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MyRefundBean;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemRefundListBindingImpl extends MallItemRefundListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10884a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10886a;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35026a = sparseIntArray;
        sparseIntArray.put(R.id.tv_price_pre, 13);
        sparseIntArray.put(R.id.tv_num, 14);
        sparseIntArray.put(R.id.bt_change_address, 15);
    }

    public MallItemRefundListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f10884a, f35026a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        String shopName;
        String afterSaleTypeDesc;
        String shopLogo;
        String goodsName;
        String str3;
        String memo;
        String refundStatusTypeDesc;
        boolean z;
        boolean z2;
        boolean z3;
        String goodsSpec;
        String goodsImage;
        int logisticStatus;
        int refundStatusType;
        boolean zCanCancelRefund;
        synchronized (this) {
            j = this.f10885a;
            this.f10885a = 0L;
        }
        MyRefundBean myRefundBean = ((MallItemRefundListBinding) this).f10877a;
        long j2 = j & 3;
        String refundAmount = null;
        if (j2 != 0) {
            RequestOptions requestOptions2 = ju3.m;
            if (myRefundBean != null) {
                refundAmount = myRefundBean.getRefundAmount();
                shopName = myRefundBean.getShopName();
                afterSaleTypeDesc = myRefundBean.getAfterSaleTypeDesc();
                shopLogo = myRefundBean.getShopLogo();
                logisticStatus = myRefundBean.getLogisticStatus();
                refundStatusType = myRefundBean.getRefundStatusType();
                goodsImage = myRefundBean.getGoodsImage();
                goodsName = myRefundBean.getGoodsName();
                str3 = myRefundBean.formatterRefundStatusColor();
                memo = myRefundBean.getMemo();
                refundStatusTypeDesc = myRefundBean.getRefundStatusTypeDesc();
                zCanCancelRefund = myRefundBean.canCancelRefund();
                goodsSpec = myRefundBean.getGoodsSpec();
            } else {
                goodsSpec = null;
                shopName = null;
                afterSaleTypeDesc = null;
                shopLogo = null;
                goodsImage = null;
                goodsName = null;
                str3 = null;
                memo = null;
                refundStatusTypeDesc = null;
                logisticStatus = 0;
                refundStatusType = 0;
                zCanCancelRefund = false;
            }
            String str4 = goodsSpec;
            String str5 = String.format("¥%s", refundAmount);
            boolean z4 = logisticStatus == 1;
            z2 = refundStatusType < 3;
            z = zCanCancelRefund;
            str2 = str4;
            requestOptions = requestOptions2;
            String str6 = goodsImage;
            z3 = z4;
            str = str5;
            refundAmount = str6;
        } else {
            requestOptions = null;
            str = null;
            str2 = null;
            shopName = null;
            afterSaleTypeDesc = null;
            shopLogo = null;
            goodsName = null;
            str3 = null;
            memo = null;
            refundStatusTypeDesc = null;
            z = false;
            z2 = false;
            z3 = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.e0(((MallItemRefundListBinding) this).f10881a, z2);
            CommonBindingAdapter.l0(((MallItemRefundListBinding) this).f10879a, z);
            CommonBindingAdapter.l0(((MallItemRefundListBinding) this).f10883b, z3);
            CommonBindingAdapter.b0(((MallItemRefundListBinding) this).f35025a, refundAmount, requestOptions, false);
            CommonBindingAdapter.b0(((MallItemRefundListBinding) this).f10880a, shopLogo, requestOptions, false);
            TextViewBindingAdapter.setText(this.g, memo);
            CommonBindingAdapter.W(this.g, str3);
            TextViewBindingAdapter.setText(this.h, refundStatusTypeDesc);
            CommonBindingAdapter.W(this.h, str3);
            TextViewBindingAdapter.setText(((MallItemRefundListBinding) this).f10876a, goodsName);
            TextViewBindingAdapter.setText(((MallItemRefundListBinding) this).f10878a, str);
            TextViewBindingAdapter.setText(this.d, shopName);
            TextViewBindingAdapter.setText(this.e, str2);
            TextViewBindingAdapter.setText(this.f, afterSaleTypeDesc);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10885a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10885a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemRefundListBinding
    public void k(@Nullable MyRefundBean myRefundBean) {
        ((MallItemRefundListBinding) this).f10877a = myRefundBean;
        synchronized (this) {
            this.f10885a |= 1;
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
        k((MyRefundBean) obj);
        return true;
    }

    public MallItemRefundListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLLinearLayout) objArr[8], (BLButton) objArr[11], (BLTextView) objArr[15], (BLButton) objArr[12], (ImageView) objArr[4], (BLImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[14], (PriceView) objArr[7], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[3]);
        this.f10885a = -1L;
        ((MallItemRefundListBinding) this).f10881a.setTag(null);
        ((MallItemRefundListBinding) this).f10879a.setTag(null);
        ((MallItemRefundListBinding) this).f10883b.setTag(null);
        ((MallItemRefundListBinding) this).f35025a.setTag(null);
        ((MallItemRefundListBinding) this).f10880a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10886a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[9];
        this.h = textView2;
        textView2.setTag(null);
        ((MallItemRefundListBinding) this).f10876a.setTag(null);
        ((MallItemRefundListBinding) this).f10878a.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
