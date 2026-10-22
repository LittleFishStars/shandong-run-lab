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
import androidx.p002lifecycle.LifecycleOwner;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemChooseShopOrderBindingImpl extends MallItemChooseShopOrderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final MallItemMyOrderGoodsBinding f10739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10740a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f10737a = includedLayouts;
        includedLayouts.setIncludes(4, new String[]{"mall_item_my_order_goods"}, new int[]{7}, new int[]{R.layout.mall_item_my_order_goods});
        f34981a = null;
    }

    public MallItemChooseShopOrderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10737a, f34981a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean payStatus;
        String string;
        String str;
        RequestOptions requestOptions;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String orderStatusDesc;
        String shopName;
        String shopLogo;
        String statusColor;
        synchronized (this) {
            j = this.f10738a;
            this.f10738a = 0L;
        }
        MyOrderBean myOrderBean = ((MallItemChooseShopOrderBinding) this).f10734a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (myOrderBean != null) {
                orderStatusDesc = myOrderBean.getOrderStatusDesc();
                payStatus = myOrderBean.getPayStatus();
                shopName = myOrderBean.getShopName();
                shopLogo = myOrderBean.getShopLogo();
                statusColor = myOrderBean.getStatusColor();
            } else {
                payStatus = false;
                orderStatusDesc = null;
                shopName = null;
                shopLogo = null;
                statusColor = null;
            }
            if (j2 != 0) {
                j = payStatus ? j | 8 | 32 : j | 4 | 16;
            }
            string = ((MallItemChooseShopOrderBinding) this).f10733a.getResources().getString(payStatus ? R.string.mall_my_order_pay_pre2 : R.string.mall_my_order_pay_pre1);
            str = orderStatusDesc;
            str2 = shopName;
            str3 = shopLogo;
            str4 = statusColor;
        } else {
            payStatus = false;
            string = null;
            str = null;
            requestOptions = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if ((16 & j) != 0) {
            str5 = String.format("¥%s", myOrderBean != null ? myOrderBean.getOrderAmount() : null);
        } else {
            str5 = null;
        }
        if ((32 & j) != 0) {
            str6 = String.format("¥%s", myOrderBean != null ? myOrderBean.getPayAmount() : null);
        } else {
            str6 = null;
        }
        long j3 = j & 3;
        if (j3 == 0) {
            str6 = null;
        } else if (!payStatus) {
            str6 = str5;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((MallItemChooseShopOrderBinding) this).f10736a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(((MallItemChooseShopOrderBinding) this).f10735a, str6);
            TextViewBindingAdapter.setText(((MallItemChooseShopOrderBinding) this).f10733a, string);
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(this.c, str);
            CommonBindingAdapter.W(this.c, str4);
        }
        ViewDataBinding.executeBindingsOn(this.f10739a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10738a != 0) {
                return true;
            }
            return this.f10739a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10738a = 2L;
        }
        this.f10739a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemChooseShopOrderBinding
    public void k(@Nullable MyOrderBean myOrderBean) {
        ((MallItemChooseShopOrderBinding) this).f10734a = myOrderBean;
        synchronized (this) {
            this.f10738a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f10739a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((MyOrderBean) obj);
        return true;
    }

    public MallItemChooseShopOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1], (LinearLayout) objArr[4], (PriceView) objArr[6], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.f10738a = -1L;
        ((MallItemChooseShopOrderBinding) this).f10736a.setTag(null);
        ((MallItemChooseShopOrderBinding) this).f34980a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10740a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        MallItemMyOrderGoodsBinding mallItemMyOrderGoodsBinding = (MallItemMyOrderGoodsBinding) objArr[7];
        this.f10739a = mallItemMyOrderGoodsBinding;
        setContainedBinding(mallItemMyOrderGoodsBinding);
        ((MallItemChooseShopOrderBinding) this).f10735a.setTag(null);
        ((MallItemChooseShopOrderBinding) this).f10733a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
