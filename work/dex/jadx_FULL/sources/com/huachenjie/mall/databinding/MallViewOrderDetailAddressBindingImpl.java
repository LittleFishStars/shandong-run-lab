package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewOrderDetailAddressBindingImpl extends MallViewOrderDetailAddressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35090a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11068a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11071a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f35091a;

        public a a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f35091a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35091a.b(view);
        }
    }

    public MallViewOrderDetailAddressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f11068a, f35090a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String address;
        String city;
        String phone;
        a aVarA;
        boolean zIsWaitPayOrPayingStatus;
        ShippingAddressBean addressInfo;
        synchronized (this) {
            j = this.f11069a;
            this.f11069a = 0L;
        }
        OrderDetailBean orderDetailBean = ((MallViewOrderDetailAddressBinding) this).f11065a;
        OrderDetailActivity.ClickProxy clickProxy = ((MallViewOrderDetailAddressBinding) this).f11066a;
        long j2 = 5 & j;
        boolean z = false;
        if (j2 == 0) {
            str = null;
            address = null;
            city = null;
            phone = null;
        } else {
            if (orderDetailBean != null) {
                addressInfo = orderDetailBean.getAddressInfo();
                zIsWaitPayOrPayingStatus = orderDetailBean.isWaitPayOrPayingStatus();
            } else {
                zIsWaitPayOrPayingStatus = false;
                addressInfo = null;
            }
            if (addressInfo != null) {
                address = addressInfo.getAddress();
                city = addressInfo.formatCity();
                phone = addressInfo.formatPhone();
                String receiverName = addressInfo.getReceiverName();
                z = zIsWaitPayOrPayingStatus;
                str = receiverName;
            } else {
                z = zIsWaitPayOrPayingStatus;
                str = null;
                address = null;
                city = null;
                phone = null;
            }
        }
        long j3 = j & 6;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f11070a;
            if (aVar == null) {
                aVar = new a();
                this.f11070a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.c, city);
            TextViewBindingAdapter.setText(this.d, address);
            CommonBindingAdapter.l0(((MallViewOrderDetailAddressBinding) this).f11067a, z);
            TextViewBindingAdapter.setText(((MallViewOrderDetailAddressBinding) this).f35089a, str);
            TextViewBindingAdapter.setText(this.b, phone);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallViewOrderDetailAddressBinding) this).f11067a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11069a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11069a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewOrderDetailAddressBinding
    public void l(@Nullable OrderDetailBean orderDetailBean) {
        ((MallViewOrderDetailAddressBinding) this).f11065a = orderDetailBean;
        synchronized (this) {
            this.f11069a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewOrderDetailAddressBinding
    public void m(@Nullable OrderDetailActivity.ClickProxy clickProxy) {
        ((MallViewOrderDetailAddressBinding) this).f11066a = clickProxy;
        synchronized (this) {
            this.f11069a |= 2;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g == i) {
            l((OrderDetailBean) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            m((OrderDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallViewOrderDetailAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4]);
        this.f11069a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f11071a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.d = textView2;
        textView2.setTag(null);
        ((MallViewOrderDetailAddressBinding) this).f11067a.setTag(null);
        ((MallViewOrderDetailAddressBinding) this).f35089a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
