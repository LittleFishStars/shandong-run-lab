package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallLayoutGoodsDetailBottomTeamLeaderBindingImpl extends MallLayoutGoodsDetailBottomTeamLeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35068a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10998a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10999a;

    public MallLayoutGoodsDetailBottomTeamLeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10998a, f35068a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f10999a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10999a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10999a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomTeamLeaderBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallLayoutGoodsDetailBottomTeamLeaderBinding) this).f10996a = clickProxy;
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomTeamLeaderBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallLayoutGoodsDetailBottomTeamLeaderBinding) this).f10997a = goodsDetailVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((GoodsDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallLayoutGoodsDetailBottomTeamLeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0]);
        this.f10999a = -1L;
        ((MallLayoutGoodsDetailBottomTeamLeaderBinding) this).f35067a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
