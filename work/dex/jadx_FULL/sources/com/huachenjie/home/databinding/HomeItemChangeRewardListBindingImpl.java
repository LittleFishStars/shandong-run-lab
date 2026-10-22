package com.huachenjie.home.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.bean.reward.AwardListBean;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemChangeRewardListBindingImpl extends HomeItemChangeRewardListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34266a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9458a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f9460a;

    @NonNull
    public final TextView b;

    public HomeItemChangeRewardListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9458a, f34266a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String awardName;
        boolean z;
        boolean z2;
        String price;
        ImageBean imageInfo;
        int stock;
        synchronized (this) {
            j = this.f9459a;
            this.f9459a = 0L;
        }
        AwardListBean awardListBean = ((HomeItemChangeRewardListBinding) this).f9453a;
        Integer num = ((HomeItemChangeRewardListBinding) this).f9457a;
        long j2 = 5 & j;
        RequestOptions requestOptions = null;
        if (j2 != 0) {
            RequestOptions requestOptions2 = ju3.o;
            if (awardListBean != null) {
                imageInfo = awardListBean.getImageInfo();
                awardName = awardListBean.getAwardName();
                stock = awardListBean.getStock();
                price = awardListBean.getPrice();
            } else {
                price = null;
                imageInfo = null;
                awardName = null;
                stock = 0;
            }
            String url = imageInfo != null ? imageInfo.getUrl() : null;
            str3 = String.format("库存 %d", Integer.valueOf(stock));
            z = stock > 0;
            z2 = !TextUtils.isEmpty(price);
            str2 = price;
            str = url;
            requestOptions = requestOptions2;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            awardName = null;
            z = false;
            z2 = false;
        }
        long j3 = j & 6;
        boolean z3 = j3 != 0 && ViewDataBinding.safeUnbox(num) == 3;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemChangeRewardListBinding) this).f9455a, str, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(((HomeItemChangeRewardListBinding) this).f9454a, str2);
            CommonBindingAdapter.i(((HomeItemChangeRewardListBinding) this).f9454a, z2);
            CommonBindingAdapter.e0(((HomeItemChangeRewardListBinding) this).f9456a, z);
            TextViewBindingAdapter.setText(((HomeItemChangeRewardListBinding) this).f34265a, awardName);
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.b, z3);
            CommonBindingAdapter.l0(((HomeItemChangeRewardListBinding) this).f9456a, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9459a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9459a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemChangeRewardListBinding
    public void l(@Nullable AwardListBean awardListBean) {
        ((HomeItemChangeRewardListBinding) this).f9453a = awardListBean;
        synchronized (this) {
            this.f9459a |= 1;
        }
        notifyPropertyChanged(xk0.H);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemChangeRewardListBinding
    public void m(@Nullable Integer num) {
        ((HomeItemChangeRewardListBinding) this).f9457a = num;
        synchronized (this) {
            this.f9459a |= 2;
        }
        notifyPropertyChanged(xk0.I);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.H == i) {
            l((AwardListBean) obj);
        } else {
            if (xk0.I != i) {
                return false;
            }
            m((Integer) obj);
        }
        return true;
    }

    public HomeItemChangeRewardListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1], (PriceView) objArr[3], (BLTextView) objArr[5], (TextView) objArr[2]);
        this.f9459a = -1L;
        ((HomeItemChangeRewardListBinding) this).f9455a.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f9460a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.b = textView;
        textView.setTag(null);
        ((HomeItemChangeRewardListBinding) this).f9454a.setTag(null);
        ((HomeItemChangeRewardListBinding) this).f9456a.setTag(null);
        ((HomeItemChangeRewardListBinding) this).f34265a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
