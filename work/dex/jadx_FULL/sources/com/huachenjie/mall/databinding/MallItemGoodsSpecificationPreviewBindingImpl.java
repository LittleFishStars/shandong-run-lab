package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.lxj.xpopup.photoview.PhotoView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsSpecificationPreviewBindingImpl extends MallItemGoodsSpecificationPreviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35014a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10837a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PhotoView f10841a;

    public MallItemGoodsSpecificationPreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10837a, f35014a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String specValue;
        ImageBean specImageInfo;
        synchronized (this) {
            j = this.f10838a;
            this.f10838a = 0L;
        }
        GoodsDetailSpecValue goodsDetailSpecValue = ((MallItemGoodsSpecificationPreviewBinding) this).f35013a;
        Integer num = ((MallItemGoodsSpecificationPreviewBinding) this).f10836a;
        long j2 = 5 & j;
        String url = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (goodsDetailSpecValue != null) {
                specValue = goodsDetailSpecValue.getSpecValue();
                specImageInfo = goodsDetailSpecValue.getSpecImageInfo();
            } else {
                specImageInfo = null;
                specValue = null;
            }
            if (specImageInfo != null) {
                url = specImageInfo.getUrl();
            }
        } else {
            requestOptions = null;
            specValue = null;
        }
        long j3 = j & 6;
        int iSafeUnbox = j3 != 0 ? ViewDataBinding.safeUnbox(num) : 0;
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10841a, url, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10840a, specValue);
        }
        if (j3 != 0) {
            CommonBindingAdapter.I(this.f10840a, 0, iSafeUnbox, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10838a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10838a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsSpecificationPreviewBinding
    public void l(@Nullable GoodsDetailSpecValue goodsDetailSpecValue) {
        ((MallItemGoodsSpecificationPreviewBinding) this).f35013a = goodsDetailSpecValue;
        synchronized (this) {
            this.f10838a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsSpecificationPreviewBinding
    public void m(@Nullable Integer num) {
        ((MallItemGoodsSpecificationPreviewBinding) this).f10836a = num;
        synchronized (this) {
            this.f10838a |= 2;
        }
        notifyPropertyChanged(hk0.x);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g == i) {
            l((GoodsDetailSpecValue) obj);
        } else {
            if (hk0.x != i) {
                return false;
            }
            m((Integer) obj);
        }
        return true;
    }

    public MallItemGoodsSpecificationPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10838a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10839a = frameLayout;
        frameLayout.setTag(null);
        PhotoView photoView = (PhotoView) objArr[1];
        this.f10841a = photoView;
        photoView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10840a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
