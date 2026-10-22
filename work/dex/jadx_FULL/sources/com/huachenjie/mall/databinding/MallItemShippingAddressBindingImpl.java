package com.huachenjie.mall.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemShippingAddressBindingImpl extends MallItemShippingAddressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10916a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10919a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35037a = sparseIntArray;
        sparseIntArray.put(R.id.ll_address, 9);
        sparseIntArray.put(R.id.btDefault, 10);
        sparseIntArray.put(R.id.tv_delete, 11);
        sparseIntArray.put(R.id.tv_edit, 12);
    }

    public MallItemShippingAddressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f10916a, f35037a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String address;
        String str3;
        String str4;
        boolean zIsSelected;
        String shippingUser;
        String phone;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10917a;
            this.f10917a = 0L;
        }
        ShippingAddressBean shippingAddressBean = ((MallItemShippingAddressBinding) this).f10915a;
        long j4 = j & 3;
        boolean defaultFlag = false;
        Drawable drawable = null;
        String city = null;
        if (j4 != 0) {
            if (shippingAddressBean != null) {
                defaultFlag = shippingAddressBean.getDefaultFlag();
                city = shippingAddressBean.formatCity();
                phone = shippingAddressBean.formatPhone();
                address = shippingAddressBean.getAddress();
                zIsSelected = shippingAddressBean.isSelected();
                shippingUser = shippingAddressBean.formatShippingUser();
            } else {
                zIsSelected = false;
                shippingUser = null;
                phone = null;
                address = null;
            }
            if (j4 != 0) {
                if (defaultFlag) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            String str5 = defaultFlag ? "已设为默认" : "设为默认";
            Drawable drawable2 = AppCompatResources.getDrawable(((MallItemShippingAddressBinding) this).f10912a.getContext(), defaultFlag ? R.drawable.mall_ic_address_default : R.drawable.mall_ic_address_normal);
            boolean z = zIsSelected;
            str3 = shippingUser;
            i = defaultFlag ? -10155284 : -7759964;
            defaultFlag = z;
            String str6 = phone;
            str2 = str5;
            str = city;
            drawable = drawable2;
            str4 = str6;
        } else {
            i = 0;
            str = null;
            str2 = null;
            address = null;
            str3 = null;
            str4 = null;
        }
        if ((j & 3) != 0) {
            ImageViewBindingAdapter.setImageDrawable(((MallItemShippingAddressBinding) this).f10912a, drawable);
            CommonBindingAdapter.l0(this.f10919a, defaultFlag);
            CommonBindingAdapter.l0(this.b, defaultFlag);
            TextViewBindingAdapter.setText(((MallItemShippingAddressBinding) this).f10914a, str);
            TextViewBindingAdapter.setText(super.b, address);
            TextViewBindingAdapter.setText(this.c, str2);
            this.c.setTextColor(i);
            TextViewBindingAdapter.setText(this.f, str3);
            TextViewBindingAdapter.setText(this.g, str4);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10917a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10917a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemShippingAddressBinding
    public void k(@Nullable ShippingAddressBean shippingAddressBean) {
        ((MallItemShippingAddressBinding) this).f10915a = shippingAddressBean;
        synchronized (this) {
            this.f10917a |= 1;
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

    public MallItemShippingAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[10], (ImageView) objArr[7], (LinearLayout) objArr[9], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[5], (TextView) objArr[6]);
        this.f10917a = -1L;
        ((MallItemShippingAddressBinding) this).f10912a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10918a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f10919a = bLView;
        bLView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.b = imageView;
        imageView.setTag(null);
        ((MallItemShippingAddressBinding) this).f10914a.setTag(null);
        super.b.setTag(null);
        this.c.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
