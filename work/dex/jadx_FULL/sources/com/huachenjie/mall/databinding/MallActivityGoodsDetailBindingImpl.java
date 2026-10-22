package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailAdapter;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityGoodsDetailBindingImpl extends MallActivityGoodsDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f10232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f10233a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f10230a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"mall_layout_goods_detail_toolbar", "layout_toolbar_binding"}, new int[]{3, 4}, new int[]{R.layout.mall_layout_goods_detail_toolbar, com.huachenjie.common.R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34798a = sparseIntArray;
        sparseIntArray.put(R.id.vs_bottom, 5);
    }

    public MallActivityGoodsDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10230a, f34798a));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ee  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        GoodsDetailAdapter value;
        int iSafeUnbox;
        Integer value2;
        boolean z;
        BindingTitleBean value3;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.f10231a;
            this.f10231a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallActivityGoodsDetailBinding) this).f10228a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallActivityGoodsDetailBinding) this).f10227a;
        if ((381 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                GoodsDetailBean value4 = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                int goodsStatus = value4 != null ? value4.getGoodsStatus() : 0;
                z = true;
                z3 = goodsStatus == 1;
                if (goodsStatus == 1) {
                    z = false;
                }
            } else {
                z = false;
                z3 = false;
            }
            if ((j & 344) != 0) {
                BaseViewModel.b bVarE = goodsDetailVM != null ? goodsDetailVM.e() : null;
                if ((j & 328) == 0) {
                    value2 = null;
                } else {
                    MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                    updateLiveDataRegistration(3, mutableLiveDataB);
                    if (mutableLiveDataB != null) {
                        value2 = mutableLiveDataB.getValue();
                    } else {
                        value2 = null;
                    }
                }
                if ((j & 336) != 0) {
                    MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                    updateLiveDataRegistration(4, mutableLiveDataC);
                    iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(50.0f)));
                } else {
                    iSafeUnbox = 0;
                }
            } else {
                iSafeUnbox = 0;
                value2 = null;
            }
            if ((j & 324) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataE = goodsDetailVM != null ? goodsDetailVM.E() : null;
                updateLiveDataRegistration(2, mutableLiveDataE);
                if (mutableLiveDataE != null) {
                    value3 = mutableLiveDataE.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 352) == 0) {
                z2 = z3;
                value = null;
            } else {
                MutableLiveData<GoodsDetailAdapter> mutableLiveDataQ = goodsDetailVM != null ? goodsDetailVM.q() : null;
                updateLiveDataRegistration(5, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value = mutableLiveDataQ.getValue();
                    z2 = z3;
                } else {
                    z2 = z3;
                    value = null;
                }
            }
        } else {
            value = null;
            iSafeUnbox = 0;
            value2 = null;
            z = false;
            value3 = null;
            z2 = false;
        }
        long j2 = j & 384;
        if ((j & 321) != 0) {
            CommonBindingAdapter.l0(((MallActivityGoodsDetailBinding) this).f10226a.getRoot(), z2);
            CommonBindingAdapter.l0(this.f10233a.getRoot(), z);
            CommonBindingAdapter.l0(((MallActivityGoodsDetailBinding) this).f10229a, z2);
        }
        if (j2 != 0) {
            ((MallActivityGoodsDetailBinding) this).f10226a.l(clickProxy);
        }
        if ((328 & j) != 0) {
            ((MallActivityGoodsDetailBinding) this).f10226a.m(value2);
        }
        if ((j & 324) != 0) {
            this.f10233a.k(value3);
        }
        if ((352 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityGoodsDetailBinding) this).f10225a, value, false, false);
        }
        if ((j & 336) != 0) {
            CommonBindingAdapter.G(((MallActivityGoodsDetailBinding) this).f10229a, iSafeUnbox);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityGoodsDetailBinding) this).f10226a);
        ViewDataBinding.executeBindingsOn(this.f10233a);
        if (((MallActivityGoodsDetailBinding) this).f34797a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((MallActivityGoodsDetailBinding) this).f34797a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10231a != 0) {
                return true;
            }
            return ((MallActivityGoodsDetailBinding) this).f10226a.hasPendingBindings() || this.f10233a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10231a = 256L;
        }
        ((MallActivityGoodsDetailBinding) this).f10226a.invalidateAll();
        this.f10233a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityGoodsDetailBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallActivityGoodsDetailBinding) this).f10227a = clickProxy;
        synchronized (this) {
            this.f10231a |= 128;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityGoodsDetailBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallActivityGoodsDetailBinding) this).f10228a = goodsDetailVM;
        synchronized (this) {
            this.f10231a |= 64;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MallLayoutGoodsDetailToolbarBinding mallLayoutGoodsDetailToolbarBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<GoodsDetailAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MallLayoutGoodsDetailToolbarBinding) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return s((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10231a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityGoodsDetailBinding) this).f10226a.setLifecycleOwner(lifecycleOwner);
        this.f10233a.setLifecycleOwner(lifecycleOwner);
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

    public MallActivityGoodsDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (MallLayoutGoodsDetailToolbarBinding) objArr[3], (RecyclerView) objArr[1], (BLView) objArr[2], new ViewStubProxy((ViewStub) objArr[5]));
        this.f10231a = -1L;
        setContainedBinding(((MallActivityGoodsDetailBinding) this).f10226a);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10232a = relativeLayout;
        relativeLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f10233a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ((MallActivityGoodsDetailBinding) this).f10225a.setTag(null);
        ((MallActivityGoodsDetailBinding) this).f10229a.setTag(null);
        ((MallActivityGoodsDetailBinding) this).f34797a.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
