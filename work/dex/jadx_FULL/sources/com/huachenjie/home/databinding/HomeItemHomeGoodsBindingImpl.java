package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.bean.PromoSlotBean;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemHomeGoodsBindingImpl extends HomeItemHomeGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34272a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9473a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9476a;

    public HomeItemHomeGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f9473a, f34272a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String price;
        synchronized (this) {
            j = this.f9474a;
            this.f9474a = 0L;
        }
        PromoSlotBean promoSlotBean = ((HomeItemHomeGoodsBinding) this).f9472a;
        long j2 = j & 3;
        String imageUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (promoSlotBean != null) {
                imageUrl = promoSlotBean.getImageUrl();
                price = promoSlotBean.getPrice();
            } else {
                price = null;
            }
        } else {
            requestOptions = null;
            price = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemHomeGoodsBinding) this).f34271a, imageUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f9475a, price);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9474a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9474a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemHomeGoodsBinding
    public void k(@Nullable PromoSlotBean promoSlotBean) {
        ((HomeItemHomeGoodsBinding) this).f9472a = promoSlotBean;
        synchronized (this) {
            this.f9474a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((PromoSlotBean) obj);
        return true;
    }

    public HomeItemHomeGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f9474a = -1L;
        ((HomeItemHomeGoodsBinding) this).f34271a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9476a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9475a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
