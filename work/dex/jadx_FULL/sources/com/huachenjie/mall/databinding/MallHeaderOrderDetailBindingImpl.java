package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.noober.background.view.BLImageView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallHeaderOrderDetailBindingImpl extends MallHeaderOrderDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10718a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10721a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34973a;

        public a a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34973a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34973a.i(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34972a = sparseIntArray;
        sparseIntArray.put(R.id.vs_address, 3);
        sparseIntArray.put(R.id.vs_deliver, 4);
    }

    public MallHeaderOrderDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10718a, f34972a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String shopLogo;
        RequestOptions requestOptions;
        String shopName;
        a aVarA;
        synchronized (this) {
            j = this.f10719a;
            this.f10719a = 0L;
        }
        OrderDetailVM orderDetailVM = ((MallHeaderOrderDetailBinding) this).f10716a;
        OrderDetailActivity.ClickProxy clickProxy = ((MallHeaderOrderDetailBinding) this).f10715a;
        long j2 = 11 & j;
        if (j2 != 0) {
            requestOptions = ju3.m;
            MutableLiveData<OrderDetailBean> mutableLiveDataQ = orderDetailVM != null ? orderDetailVM.q() : null;
            updateLiveDataRegistration(0, mutableLiveDataQ);
            OrderDetailBean value = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
            if (value != null) {
                shopName = value.getShopName();
                shopLogo = value.getShopLogo();
            } else {
                shopLogo = null;
                shopName = null;
            }
        } else {
            shopLogo = null;
            requestOptions = null;
            shopName = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f10721a;
            if (aVar == null) {
                aVar = new a();
                this.f10721a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallHeaderOrderDetailBinding) this).f10717a, shopLogo, requestOptions, false);
            TextViewBindingAdapter.setText(((MallHeaderOrderDetailBinding) this).f34971a, shopName);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallHeaderOrderDetailBinding) this).f10717a, aVarA, null);
            CommonBindingAdapter.q(((MallHeaderOrderDetailBinding) this).f34971a, aVarA, null);
        }
        if (((MallHeaderOrderDetailBinding) this).f10714a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((MallHeaderOrderDetailBinding) this).f10714a.getBinding());
        }
        if (this.b.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(this.b.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10719a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10719a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallHeaderOrderDetailBinding
    public void l(@Nullable OrderDetailActivity.ClickProxy clickProxy) {
        ((MallHeaderOrderDetailBinding) this).f10715a = clickProxy;
        synchronized (this) {
            this.f10719a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallHeaderOrderDetailBinding
    public void m(@Nullable OrderDetailVM orderDetailVM) {
        ((MallHeaderOrderDetailBinding) this).f10716a = orderDetailVM;
        synchronized (this) {
            this.f10719a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<OrderDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10719a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((OrderDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((OrderDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallHeaderOrderDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BLImageView) objArr[1], (TextView) objArr[2], new ViewStubProxy((ViewStub) objArr[3]), new ViewStubProxy((ViewStub) objArr[4]));
        this.f10719a = -1L;
        ((MallHeaderOrderDetailBinding) this).f10717a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10720a = linearLayout;
        linearLayout.setTag(null);
        ((MallHeaderOrderDetailBinding) this).f34971a.setTag(null);
        ((MallHeaderOrderDetailBinding) this).f10714a.setContainingBinding(this);
        this.b.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
