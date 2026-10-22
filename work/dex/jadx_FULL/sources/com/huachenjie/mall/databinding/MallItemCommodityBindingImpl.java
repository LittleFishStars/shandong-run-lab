package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemCommodityBindingImpl extends MallItemCommodityBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10744a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f10746a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34983a = sparseIntArray;
        sparseIntArray.put(R.id.tv_name, 5);
        sparseIntArray.put(R.id.ll_price, 6);
        sparseIntArray.put(R.id.tv_money, 7);
    }

    public MallItemCommodityBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10744a, f34983a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        CharSequence charSequence;
        RequestOptions requestOptions2;
        CharSequence saleCount;
        CharSequence charSequenceFindLabelImage;
        synchronized (this) {
            j = this.f10745a;
            this.f10745a = 0L;
        }
        CommodityBean commodityBean = ((MallItemCommodityBinding) this).f10743a;
        long j2 = j & 3;
        boolean z = false;
        String str = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            requestOptions2 = ju3.s;
            if (commodityBean != null) {
                CharSequence price = commodityBean.formatPrice();
                saleCount = commodityBean.formatSaleCount();
                String goodsCover = commodityBean.getGoodsCover();
                charSequenceFindLabelImage = commodityBean.findLabelImage();
                boolean zShowLabelImage = commodityBean.showLabelImage();
                charSequence = price;
                str = goodsCover;
                z = zShowLabelImage;
            } else {
                charSequence = null;
                saleCount = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((MallItemCommodityBinding) this).f34982a, str, requestOptions2, false);
                CommonBindingAdapter.l0(this.b, z);
                CommonBindingAdapter.b0(this.b, charSequenceFindLabelImage, requestOptions, false);
                TextViewBindingAdapter.setText(this.c, saleCount);
                TextViewBindingAdapter.setText(this.d, charSequence);
            }
        }
        requestOptions = null;
        charSequence = null;
        requestOptions2 = null;
        saleCount = null;
        charSequenceFindLabelImage = saleCount;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallItemCommodityBinding) this).f34982a, str, requestOptions2, false);
            CommonBindingAdapter.l0(this.b, z);
            CommonBindingAdapter.b0(this.b, charSequenceFindLabelImage, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, saleCount);
            TextViewBindingAdapter.setText(this.d, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10745a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10745a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemCommodityBinding
    public void k(@Nullable CommodityBean commodityBean) {
        ((MallItemCommodityBinding) this).f10743a = commodityBean;
        synchronized (this) {
            this.f10745a |= 1;
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
        k((CommodityBean) obj);
        return true;
    }

    public MallItemCommodityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ConstraintLayout) objArr[6], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[3]);
        this.f10745a = -1L;
        ((MallItemCommodityBinding) this).f34982a.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.f10746a = cardView;
        cardView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.b = imageView;
        imageView.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
