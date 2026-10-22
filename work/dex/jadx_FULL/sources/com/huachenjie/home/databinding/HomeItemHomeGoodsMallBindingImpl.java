package com.huachenjie.home.databinding;

import android.text.TextUtils;
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
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemHomeGoodsMallBindingImpl extends HomeItemHomeGoodsMallBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34274a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9479a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9482a;

    public HomeItemHomeGoodsMallBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9479a, f34274a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        RequestOptions requestOptions;
        String str;
        String strFindPrice;
        String strFindBargainPrice;
        String str2;
        synchronized (this) {
            j = this.f9480a;
            this.f9480a = 0L;
        }
        PromoSlotBean promoSlotBean = ((HomeItemHomeGoodsMallBinding) this).f9478a;
        long j2 = j & 3;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (promoSlotBean != null) {
                String imageUrl = promoSlotBean.getImageUrl();
                String flashPrice = promoSlotBean.getFlashPrice();
                strFindPrice = promoSlotBean.findPrice();
                strFindBargainPrice = promoSlotBean.findBargainPrice();
                String strFindDeduction = promoSlotBean.findDeduction();
                str2 = imageUrl;
                str3 = flashPrice;
                str = strFindDeduction;
            } else {
                str2 = null;
                str = null;
                strFindPrice = null;
                strFindBargainPrice = null;
            }
            String str4 = str2;
            z = !TextUtils.isEmpty(str3);
            str3 = str4;
        } else {
            z = false;
            requestOptions = null;
            str = null;
            strFindPrice = null;
            strFindBargainPrice = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemHomeGoodsMallBinding) this).f34273a, str3, requestOptions, false);
            CommonBindingAdapter.l0(this.f9482a, z);
            TextViewBindingAdapter.setText(this.f9482a, strFindBargainPrice);
            TextViewBindingAdapter.setText(((HomeItemHomeGoodsMallBinding) this).f9477a, str);
            TextViewBindingAdapter.setText(this.b, strFindPrice);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9480a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9480a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemHomeGoodsMallBinding
    public void k(@Nullable PromoSlotBean promoSlotBean) {
        ((HomeItemHomeGoodsMallBinding) this).f9478a = promoSlotBean;
        synchronized (this) {
            this.f9480a |= 1;
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

    public HomeItemHomeGoodsMallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.f9480a = -1L;
        ((HomeItemHomeGoodsMallBinding) this).f34273a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9481a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f9482a = bLTextView;
        bLTextView.setTag(null);
        ((HomeItemHomeGoodsMallBinding) this).f9477a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
