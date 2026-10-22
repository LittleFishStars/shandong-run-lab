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
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemShippingAddressModifyBindingImpl extends MallItemShippingAddressModifyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10922a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10926a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35039a = sparseIntArray;
        sparseIntArray.put(R.id.ll_address, 7);
    }

    public MallItemShippingAddressModifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10922a, f35039a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String address;
        boolean zIsSelected;
        String shippingUser;
        String city;
        String phone;
        synchronized (this) {
            j = this.f10923a;
            this.f10923a = 0L;
        }
        ShippingAddressBean shippingAddressBean = ((MallItemShippingAddressModifyBinding) this).f10921a;
        long j2 = j & 3;
        if (j2 == 0 || shippingAddressBean == null) {
            address = null;
            zIsSelected = false;
            shippingUser = null;
            city = null;
            phone = null;
        } else {
            address = shippingAddressBean.getAddress();
            shippingUser = shippingAddressBean.formatShippingUser();
            city = shippingAddressBean.formatCity();
            zIsSelected = shippingAddressBean.isSelected();
            phone = shippingAddressBean.formatPhone();
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f10926a, zIsSelected);
            CommonBindingAdapter.l0(this.f10924a, zIsSelected);
            TextViewBindingAdapter.setText(((MallItemShippingAddressModifyBinding) this).f10920a, city);
            TextViewBindingAdapter.setText(this.b, address);
            TextViewBindingAdapter.setText(this.c, shippingUser);
            TextViewBindingAdapter.setText(this.d, phone);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10923a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10923a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemShippingAddressModifyBinding
    public void k(@Nullable ShippingAddressBean shippingAddressBean) {
        ((MallItemShippingAddressModifyBinding) this).f10921a = shippingAddressBean;
        synchronized (this) {
            this.f10923a |= 1;
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
        k((ShippingAddressBean) obj);
        return true;
    }

    public MallItemShippingAddressModifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.f10923a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10925a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f10926a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f10924a = imageView;
        imageView.setTag(null);
        ((MallItemShippingAddressModifyBinding) this).f10920a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
