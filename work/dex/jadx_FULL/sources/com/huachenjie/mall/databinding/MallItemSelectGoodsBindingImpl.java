package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemSelectGoodsBindingImpl extends MallItemSelectGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35035a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10907a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f10911a;

    public MallItemSelectGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10907a, f35035a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean checked;
        boolean z;
        int i;
        String str;
        String str2;
        String url;
        RequestOptions requestOptions;
        boolean zIsSingleSelect;
        String goodsName;
        String minSkuPrice;
        ImageBean imageInfo;
        synchronized (this) {
            j = this.f10908a;
            this.f10908a = 0L;
        }
        SelectGoodsBean selectGoodsBean = ((MallItemSelectGoodsBinding) this).f10906a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (selectGoodsBean != null) {
                goodsName = selectGoodsBean.getGoodsName();
                minSkuPrice = selectGoodsBean.getMinSkuPrice();
                imageInfo = selectGoodsBean.getImageInfo();
                zIsSingleSelect = selectGoodsBean.isSingleSelect();
                checked = selectGoodsBean.getChecked();
            } else {
                checked = false;
                zIsSingleSelect = false;
                goodsName = null;
                minSkuPrice = null;
                imageInfo = null;
            }
            if (j2 != 0) {
                j |= zIsSingleSelect ? 8L : 4L;
            }
            String str3 = String.format("¥%s", minSkuPrice);
            int i2 = zIsSingleSelect ? 0 : 12;
            z = !zIsSingleSelect;
            url = imageInfo != null ? imageInfo.getUrl() : null;
            int i3 = i2;
            str2 = str3;
            str = goodsName;
            i = i3;
        } else {
            checked = false;
            z = false;
            i = 0;
            str = null;
            str2 = null;
            url = null;
            requestOptions = null;
        }
        if ((j & 3) != 0) {
            CompoundButtonBindingAdapter.setChecked(((MallItemSelectGoodsBinding) this).f35034a, checked);
            CommonBindingAdapter.l0(((MallItemSelectGoodsBinding) this).f35034a, z);
            CommonBindingAdapter.b0(((MallItemSelectGoodsBinding) this).f10905a, url, requestOptions, false);
            CommonBindingAdapter.I(((MallItemSelectGoodsBinding) this).f10905a, i, 0, 0, 0, null);
            TextViewBindingAdapter.setText(this.f10909a, str);
            TextViewBindingAdapter.setText(this.f10910a, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10908a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10908a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemSelectGoodsBinding
    public void k(@Nullable SelectGoodsBean selectGoodsBean) {
        ((MallItemSelectGoodsBinding) this).f10906a = selectGoodsBean;
        synchronized (this) {
            this.f10908a |= 1;
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
        k((SelectGoodsBean) obj);
        return true;
    }

    public MallItemSelectGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[1], (ImageView) objArr[2]);
        this.f10908a = -1L;
        ((MallItemSelectGoodsBinding) this).f35034a.setTag(null);
        ((MallItemSelectGoodsBinding) this).f10905a.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f10911a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f10909a = textView;
        textView.setTag(null);
        PriceView priceView = (PriceView) objArr[4];
        this.f10910a = priceView;
        priceView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
