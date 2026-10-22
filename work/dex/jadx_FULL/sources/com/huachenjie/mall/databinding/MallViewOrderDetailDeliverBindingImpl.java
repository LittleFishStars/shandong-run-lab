package com.huachenjie.mall.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.OrderDetailLogisticBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewOrderDetailDeliverBindingImpl extends MallViewOrderDetailDeliverBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35093a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11077a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11080a;

    @NonNull
    public final TextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f35094a;

        public a a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f35094a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35094a.e(view);
        }
    }

    public MallViewOrderDetailDeliverBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f11077a, f35093a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int colorFromResource;
        int logisticsStatusIcon;
        int colorFromResource2;
        int colorFromResource3;
        String nodeItemDesc;
        String str;
        String str2;
        Drawable drawable;
        String str3;
        String receiverName;
        a aVarA;
        OrderDetailLogisticBean logisticInfo;
        boolean signFlag;
        ShippingAddressBean addressInfo;
        String address;
        String city;
        String phone;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f11078a;
            this.f11078a = 0L;
        }
        OrderDetailBean orderDetailBean = ((MallViewOrderDetailDeliverBinding) this).f11074a;
        OrderDetailActivity.ClickProxy clickProxy = ((MallViewOrderDetailDeliverBinding) this).f11075a;
        long j4 = j & 5;
        if (j4 != 0) {
            if (orderDetailBean != null) {
                signFlag = orderDetailBean.getSignFlag();
                addressInfo = orderDetailBean.getAddressInfo();
                logisticInfo = orderDetailBean.getLogisticInfo();
            } else {
                logisticInfo = null;
                signFlag = false;
                addressInfo = null;
            }
            if (j4 != 0) {
                if (signFlag) {
                    j2 = j | 16 | 64 | 256 | 1024;
                    j3 = 4096;
                } else {
                    j2 = j | 8 | 32 | 128 | 512;
                    j3 = 2048;
                }
                j = j2 | j3;
            }
            int colorFromResource4 = ViewDataBinding.getColorFromResource(((MallViewOrderDetailDeliverBinding) this).f35092a, signFlag ? R.color.color_650aec : R.color.color_e5e5e5);
            colorFromResource3 = ViewDataBinding.getColorFromResource(this.c, signFlag ? R.color.color_2C3E50 : R.color.color_8997A4);
            colorFromResource2 = signFlag ? ViewDataBinding.getColorFromResource(((MallViewOrderDetailDeliverBinding) this).f11073a, R.color.color_2C3E50) : ViewDataBinding.getColorFromResource(((MallViewOrderDetailDeliverBinding) this).f11073a, R.color.color_8997A4);
            drawable = signFlag ? AppCompatResources.getDrawable(((MallViewOrderDetailDeliverBinding) this).f11072a.getContext(), R.drawable.mall_ic_selected_address) : AppCompatResources.getDrawable(((MallViewOrderDetailDeliverBinding) this).f11072a.getContext(), R.drawable.mall_ic_normal_address);
            colorFromResource = ViewDataBinding.getColorFromResource(((MallViewOrderDetailDeliverBinding) this).f11076b, signFlag ? R.color.color_2C3E50 : R.color.color_8997A4);
            if (addressInfo != null) {
                address = addressInfo.getAddress();
                city = addressInfo.formatCity();
                phone = addressInfo.formatPhone();
                receiverName = addressInfo.getReceiverName();
            } else {
                address = null;
                receiverName = null;
                city = null;
                phone = null;
            }
            if (logisticInfo != null) {
                int currentNode = logisticInfo.getCurrentNode();
                String currentNodeDesc = logisticInfo.getCurrentNodeDesc();
                nodeItemDesc = logisticInfo.getNodeItemDesc();
                i2 = currentNode;
                str2 = currentNodeDesc;
            } else {
                nodeItemDesc = null;
                i2 = 0;
                str2 = null;
            }
            String str4 = city + address;
            i = colorFromResource4;
            str3 = phone;
            logisticsStatusIcon = ExpressLogisticsBean.getLogisticsStatusIcon(i2, true, false);
            str = str4;
        } else {
            i = 0;
            colorFromResource = 0;
            logisticsStatusIcon = 0;
            colorFromResource2 = 0;
            colorFromResource3 = 0;
            nodeItemDesc = null;
            str = null;
            str2 = null;
            drawable = null;
            str3 = null;
            receiverName = null;
        }
        long j5 = j & 6;
        if (j5 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f11080a;
            if (aVar == null) {
                aVar = new a();
                this.f11080a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if ((j & 5) != 0) {
            ImageViewBindingAdapter.setImageDrawable(((MallViewOrderDetailDeliverBinding) this).f11072a, drawable);
            CommonBindingAdapter.S(((MallViewOrderDetailDeliverBinding) this).b, logisticsStatusIcon);
            TextViewBindingAdapter.setText(this.e, nodeItemDesc);
            TextViewBindingAdapter.setText(((MallViewOrderDetailDeliverBinding) this).f11073a, str);
            ((MallViewOrderDetailDeliverBinding) this).f11073a.setTextColor(colorFromResource2);
            TextViewBindingAdapter.setText(((MallViewOrderDetailDeliverBinding) this).f11076b, receiverName);
            ((MallViewOrderDetailDeliverBinding) this).f11076b.setTextColor(colorFromResource);
            TextViewBindingAdapter.setText(this.c, str3);
            this.c.setTextColor(colorFromResource3);
            TextViewBindingAdapter.setText(this.d, str2);
            ((MallViewOrderDetailDeliverBinding) this).f35092a.setBackgroundColor(i);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(this.d, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11078a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11078a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewOrderDetailDeliverBinding
    public void l(@Nullable OrderDetailBean orderDetailBean) {
        ((MallViewOrderDetailDeliverBinding) this).f11074a = orderDetailBean;
        synchronized (this) {
            this.f11078a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewOrderDetailDeliverBinding
    public void m(@Nullable OrderDetailActivity.ClickProxy clickProxy) {
        ((MallViewOrderDetailDeliverBinding) this).f11075a = clickProxy;
        synchronized (this) {
            this.f11078a |= 2;
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

    public MallViewOrderDetailDeliverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[2], (View) objArr[3]);
        this.f11078a = -1L;
        ((MallViewOrderDetailDeliverBinding) this).f11072a.setTag(null);
        ((MallViewOrderDetailDeliverBinding) this).b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11079a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.e = textView;
        textView.setTag(null);
        ((MallViewOrderDetailDeliverBinding) this).f11073a.setTag(null);
        ((MallViewOrderDetailDeliverBinding) this).f11076b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ((MallViewOrderDetailDeliverBinding) this).f35092a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
