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
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewRefundDetailAddressBindingImpl extends MallViewRefundDetailAddressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11089a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11093a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RefundDetailActivity.ClickProxy f35101a;

        public a a(RefundDetailActivity.ClickProxy clickProxy) {
            this.f35101a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35101a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35100a = sparseIntArray;
        sparseIntArray.put(R.id.tv_sub_info, 5);
    }

    public MallViewRefundDetailAddressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f11089a, f35100a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        String str;
        String receiverName;
        String receiverPhone;
        String city;
        String address;
        synchronized (this) {
            j = this.f11090a;
            this.f11090a = 0L;
        }
        RefundDetailActivity.ClickProxy clickProxy = ((MallViewRefundDetailAddressBinding) this).f11088a;
        ShippingAddressBean shippingAddressBean = ((MallViewRefundDetailAddressBinding) this).f11087a;
        long j2 = 5 & j;
        if (j2 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f11092a;
            if (aVar == null) {
                aVar = new a();
                this.f11092a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        long j3 = j & 6;
        if (j3 != 0) {
            if (shippingAddressBean != null) {
                city = shippingAddressBean.formatCity();
                receiverName = shippingAddressBean.getReceiverName();
                receiverPhone = shippingAddressBean.getReceiverPhone();
                address = shippingAddressBean.getAddress();
            } else {
                city = null;
                receiverName = null;
                receiverPhone = null;
                address = null;
            }
            str = String.format("%s\n%s", city, address);
        } else {
            str = null;
            receiverName = null;
            receiverPhone = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11093a, aVarA, null);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.b, receiverName);
            TextViewBindingAdapter.setText(this.c, receiverPhone);
            TextViewBindingAdapter.setText(this.d, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11090a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11090a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewRefundDetailAddressBinding
    public void l(@Nullable ShippingAddressBean shippingAddressBean) {
        ((MallViewRefundDetailAddressBinding) this).f11087a = shippingAddressBean;
        synchronized (this) {
            this.f11090a |= 2;
        }
        notifyPropertyChanged(hk0.c);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewRefundDetailAddressBinding
    public void m(@Nullable RefundDetailActivity.ClickProxy clickProxy) {
        ((MallViewRefundDetailAddressBinding) this).f11088a = clickProxy;
        synchronized (this) {
            this.f11090a |= 1;
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
        if (hk0.k == i) {
            m((RefundDetailActivity.ClickProxy) obj);
        } else {
            if (hk0.c != i) {
                return false;
            }
            l((ShippingAddressBean) obj);
        }
        return true;
    }

    public MallViewRefundDetailAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5]);
        this.f11090a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11091a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[1];
        this.f11093a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.d = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
