package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.page.goods_detail.item_binder.ShopItemBinder;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsDetailShopBindingImpl extends MallItemGoodsDetailShopBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10815a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Group f10817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10818a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35006a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 7);
        sparseIntArray.put(R.id.tv_go_shop, 8);
    }

    public MallItemGoodsDetailShopBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f10815a, f35006a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        RequestOptions requestOptions;
        String shopUrl;
        boolean z;
        boolean shopGoodsShow;
        MerchantsBean desc;
        int type;
        String shopName;
        String score;
        synchronized (this) {
            j = this.f10816a;
            this.f10816a = 0L;
        }
        ShopItemBinder.ShopItemAdapter shopItemAdapter = ((MallItemGoodsDetailShopBinding) this).f10813a;
        GoodsDetailShop goodsDetailShop = ((MallItemGoodsDetailShopBinding) this).f10812a;
        long j2 = j & 6;
        String saleCount = null;
        if (j2 != 0) {
            requestOptions = ju3.d;
            if (goodsDetailShop != null) {
                shopGoodsShow = goodsDetailShop.getShopGoodsShow();
                desc = goodsDetailShop.getDesc();
                type = goodsDetailShop.getType();
            } else {
                desc = null;
                type = 0;
                shopGoodsShow = false;
            }
            if (j2 != 0) {
                j |= shopGoodsShow ? 16L : 8L;
            }
            if (desc != null) {
                saleCount = desc.getSaleCount();
                shopName = desc.getShopName();
                score = desc.getScore();
                shopUrl = desc.getShopUrl();
            } else {
                shopName = null;
                shopUrl = null;
                score = null;
            }
            z = type != 3;
            String str3 = String.format(this.c.getResources().getString(R.string.mall_goods_detail_sales), saleCount);
            str2 = String.format(((MallItemGoodsDetailShopBinding) this).f10810a.getResources().getString(R.string.mall_goods_detail_kb), score);
            str = str3;
            saleCount = shopName;
        } else {
            str = null;
            str2 = null;
            requestOptions = null;
            shopUrl = null;
            z = false;
            shopGoodsShow = false;
        }
        long j3 = 5 & j;
        long j4 = j & 6;
        boolean z2 = (j4 == 0 || !shopGoodsShow) ? false : z;
        if (j4 != 0) {
            CommonBindingAdapter.b0(((MallItemGoodsDetailShopBinding) this).f10809a, shopUrl, requestOptions, false);
            CommonBindingAdapter.l0(this.f10817a, z);
            CommonBindingAdapter.l0(((MallItemGoodsDetailShopBinding) this).f10811a, z2);
            TextViewBindingAdapter.setText(((MallItemGoodsDetailShopBinding) this).f10810a, str2);
            TextViewBindingAdapter.setText(this.b, saleCount);
            TextViewBindingAdapter.setText(this.c, str);
        }
        if (j3 != 0) {
            CommonBindingAdapter.g(((MallItemGoodsDetailShopBinding) this).f10811a, shopItemAdapter, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10816a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10816a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsDetailShopBinding
    public void l(@Nullable ShopItemBinder.ShopItemAdapter shopItemAdapter) {
        ((MallItemGoodsDetailShopBinding) this).f10813a = shopItemAdapter;
        synchronized (this) {
            this.f10816a |= 1;
        }
        notifyPropertyChanged(hk0.b);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsDetailShopBinding
    public void m(@Nullable GoodsDetailShop goodsDetailShop) {
        ((MallItemGoodsDetailShopBinding) this).f10812a = goodsDetailShop;
        synchronized (this) {
            this.f10816a |= 2;
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
        if (hk0.b == i) {
            l((ShopItemBinder.ShopItemAdapter) obj);
        } else {
            if (hk0.g != i) {
                return false;
            }
            m((GoodsDetailShop) obj);
        }
        return true;
    }

    public MallItemGoodsDetailShopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (RecyclerView) objArr[6], (BLTextView) objArr[8], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[4], (View) objArr[7]);
        this.f10816a = -1L;
        ((MallItemGoodsDetailShopBinding) this).f10809a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10818a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        Group group = (Group) objArr[5];
        this.f10817a = group;
        group.setTag(null);
        ((MallItemGoodsDetailShopBinding) this).f10811a.setTag(null);
        ((MallItemGoodsDetailShopBinding) this).f10810a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
