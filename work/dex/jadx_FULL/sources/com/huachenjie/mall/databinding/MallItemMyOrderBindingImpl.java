package com.huachenjie.mall.databinding;

import android.content.res.Resources;
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
import com.noober.background.view.BLButton;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLImageView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemMyOrderBindingImpl extends MallItemMyOrderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final MallItemMyOrderGoodsBinding f10851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10852a;

    @NonNull
    public final LinearLayout b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        f10849a = includedLayouts;
        includedLayouts.setIncludes(4, new String[]{"mall_item_my_order_goods"}, new int[]{16}, new int[]{R.layout.mall_item_my_order_goods});
        f35016a = null;
    }

    public MallItemMyOrderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f10849a, f35016a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean payStatus;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String string;
        String string2;
        RequestOptions requestOptions;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        boolean zIsWaitReceiveStatus;
        boolean logisticTrackEnable;
        boolean commentViewEnable;
        boolean zShowLearOrSeenButton;
        boolean zIsWaitPayOrPayingStatus;
        int payRemainTime;
        boolean zIsWaitCommentStatus;
        boolean zNeedShowButton;
        String shopLogo;
        String orderStatusDesc;
        String remainPayTime;
        String shopName;
        String statusColor;
        Resources resources;
        int i2;
        synchronized (this) {
            j = this.f10850a;
            this.f10850a = 0L;
        }
        MyOrderBean myOrderBean = ((MallItemMyOrderBinding) this).f10843a;
        long j2 = j & 3;
        if (j2 != 0) {
            RequestOptions requestOptions2 = ju3.m;
            if (myOrderBean != null) {
                zIsWaitReceiveStatus = myOrderBean.isWaitReceiveStatus();
                logisticTrackEnable = myOrderBean.getLogisticTrackEnable();
                payStatus = myOrderBean.getPayStatus();
                shopLogo = myOrderBean.getShopLogo();
                commentViewEnable = myOrderBean.getCommentViewEnable();
                orderStatusDesc = myOrderBean.getOrderStatusDesc();
                remainPayTime = myOrderBean.getRemainPayTime();
                int categoryView = myOrderBean.getCategoryView();
                shopName = myOrderBean.getShopName();
                zShowLearOrSeenButton = myOrderBean.showLearOrSeenButton();
                zIsWaitPayOrPayingStatus = myOrderBean.isWaitPayOrPayingStatus();
                payRemainTime = myOrderBean.getPayRemainTime();
                zIsWaitCommentStatus = myOrderBean.isWaitCommentStatus();
                zNeedShowButton = myOrderBean.needShowButton();
                statusColor = myOrderBean.getStatusColor();
                i = categoryView;
            } else {
                i = 0;
                zIsWaitReceiveStatus = false;
                logisticTrackEnable = false;
                payStatus = false;
                commentViewEnable = false;
                zShowLearOrSeenButton = false;
                zIsWaitPayOrPayingStatus = false;
                payRemainTime = 0;
                zIsWaitCommentStatus = false;
                zNeedShowButton = false;
                shopLogo = null;
                orderStatusDesc = null;
                remainPayTime = null;
                shopName = null;
                statusColor = null;
            }
            if (j2 != 0) {
                j = payStatus ? j | 8 | 32 : j | 4 | 16;
            }
            string = ((MallItemMyOrderBinding) this).f10842a.getResources().getString(payStatus ? R.string.mall_my_order_pay_pre2 : R.string.mall_my_order_pay_pre1);
            boolean z9 = i == 1;
            z = payRemainTime > 0;
            if ((j & 3) != 0) {
                j |= z9 ? 128L : 64L;
            }
            if (z9) {
                resources = this.g.getResources();
                i2 = R.string.mall_my_order_menu_start_learn;
            } else {
                resources = this.g.getResources();
                i2 = R.string.mall_my_order_menu_start_see;
            }
            string2 = resources.getString(i2);
            requestOptions = requestOptions2;
            z2 = zIsWaitReceiveStatus;
            z3 = logisticTrackEnable;
            str = shopLogo;
            z4 = commentViewEnable;
            str2 = orderStatusDesc;
            str3 = remainPayTime;
            str4 = shopName;
            z5 = zShowLearOrSeenButton;
            z6 = zIsWaitPayOrPayingStatus;
            z7 = zIsWaitCommentStatus;
            z8 = zNeedShowButton;
            str5 = statusColor;
        } else {
            z = false;
            payStatus = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            string = null;
            string2 = null;
            requestOptions = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        if ((16 & j) != 0) {
            str6 = String.format("¥%s", myOrderBean != null ? myOrderBean.getOrderAmount() : null);
        } else {
            str6 = null;
        }
        if ((32 & j) != 0) {
            str7 = String.format("¥%s", myOrderBean != null ? myOrderBean.getPayAmount() : null);
        } else {
            str7 = null;
        }
        long j3 = j & 3;
        if (j3 == 0) {
            str7 = null;
        } else if (!payStatus) {
            str7 = str6;
        }
        if (j3 != 0) {
            boolean z10 = z6;
            CommonBindingAdapter.l0(((MallItemMyOrderBinding) this).f10845a, z10);
            CommonBindingAdapter.l0(((MallItemMyOrderBinding) this).f10847b, z10);
            CommonBindingAdapter.l0(((MallItemMyOrderBinding) this).f10848c, z7);
            CommonBindingAdapter.l0(this.d, z3);
            CommonBindingAdapter.l0(this.e, z10);
            TextViewBindingAdapter.setText(this.e, str3);
            CommonBindingAdapter.e0(this.e, z);
            CommonBindingAdapter.l0(this.f, z4);
            CommonBindingAdapter.l0(this.g, z5);
            TextViewBindingAdapter.setText(this.g, string2);
            CommonBindingAdapter.l0(this.h, z2);
            CommonBindingAdapter.b0(((MallItemMyOrderBinding) this).f10846a, str, requestOptions, false);
            CommonBindingAdapter.l0(this.b, z8);
            TextViewBindingAdapter.setText(((MallItemMyOrderBinding) this).f10844a, str7);
            TextViewBindingAdapter.setText(((MallItemMyOrderBinding) this).f10842a, string);
            TextViewBindingAdapter.setText(((MallItemMyOrderBinding) this).b, str4);
            TextViewBindingAdapter.setText(((MallItemMyOrderBinding) this).c, str2);
            CommonBindingAdapter.W(((MallItemMyOrderBinding) this).c, str5);
        }
        ViewDataBinding.executeBindingsOn(this.f10851a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10850a != 0) {
                return true;
            }
            return this.f10851a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10850a = 2L;
        }
        this.f10851a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemMyOrderBinding
    public void k(@Nullable MyOrderBean myOrderBean) {
        ((MallItemMyOrderBinding) this).f10843a = myOrderBean;
        synchronized (this) {
            this.f10850a |= 1;
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
        this.f10851a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((MyOrderBean) obj);
        return true;
    }

    public MallItemMyOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLButton) objArr[8], (BLButton) objArr[9], (BLButton) objArr[14], (BLButton) objArr[11], (BLButton) objArr[10], (BLButton) objArr[15], (BLButton) objArr[12], (BLButton) objArr[13], (BLImageView) objArr[1], (LinearLayout) objArr[4], (PriceView) objArr[6], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.f10850a = -1L;
        ((MallItemMyOrderBinding) this).f10845a.setTag(null);
        ((MallItemMyOrderBinding) this).f10847b.setTag(null);
        ((MallItemMyOrderBinding) this).f10848c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        ((MallItemMyOrderBinding) this).f10846a.setTag(null);
        ((MallItemMyOrderBinding) this).f35015a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10852a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        MallItemMyOrderGoodsBinding mallItemMyOrderGoodsBinding = (MallItemMyOrderGoodsBinding) objArr[16];
        this.f10851a = mallItemMyOrderGoodsBinding;
        setContainedBinding(mallItemMyOrderGoodsBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[7];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ((MallItemMyOrderBinding) this).f10844a.setTag(null);
        ((MallItemMyOrderBinding) this).f10842a.setTag(null);
        ((MallItemMyOrderBinding) this).b.setTag(null);
        ((MallItemMyOrderBinding) this).c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
