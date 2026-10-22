package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsSpecificationBindingImpl extends MallItemGoodsSpecificationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10832a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10835a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35012a = sparseIntArray;
        sparseIntArray.put(R.id.iv_preview, 4);
    }

    public MallItemGoodsSpecificationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10832a, f35012a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        float f;
        RequestOptions requestOptions;
        String specValue;
        boolean outOfStock;
        ImageBean specImageInfo;
        synchronized (this) {
            j = this.f10833a;
            this.f10833a = 0L;
        }
        GoodsDetailSpecValue goodsDetailSpecValue = ((MallItemGoodsSpecificationBinding) this).f10830a;
        long j2 = j & 3;
        String url = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (goodsDetailSpecValue != null) {
                specValue = goodsDetailSpecValue.getSpecValue();
                specImageInfo = goodsDetailSpecValue.getSpecImageInfo();
                outOfStock = goodsDetailSpecValue.getOutOfStock();
            } else {
                outOfStock = false;
                specValue = null;
                specImageInfo = null;
            }
            if (j2 != 0) {
                j |= outOfStock ? 8L : 4L;
            }
            url = specImageInfo != null ? specImageInfo.getUrl() : null;
            f = outOfStock ? 0.4f : 1.0f;
        } else {
            f = 0.0f;
            requestOptions = null;
            specValue = null;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.c0(((MallItemGoodsSpecificationBinding) this).f10831a, f);
            CommonBindingAdapter.b0(this.f10835a, url, requestOptions, false);
            TextViewBindingAdapter.setText(((MallItemGoodsSpecificationBinding) this).f10829a, specValue);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10833a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10833a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsSpecificationBinding
    public void k(@Nullable GoodsDetailSpecValue goodsDetailSpecValue) {
        ((MallItemGoodsSpecificationBinding) this).f10830a = goodsDetailSpecValue;
        synchronized (this) {
            this.f10833a |= 1;
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
        k((GoodsDetailSpecValue) obj);
        return true;
    }

    public MallItemGoodsSpecificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (BLLinearLayout) objArr[1], (TextView) objArr[3]);
        this.f10833a = -1L;
        ((MallItemGoodsSpecificationBinding) this).f10831a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10834a = frameLayout;
        frameLayout.setTag(null);
        RoundImageView roundImageView = (RoundImageView) objArr[2];
        this.f10835a = roundImageView;
        roundImageView.setTag(null);
        ((MallItemGoodsSpecificationBinding) this).f10829a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
