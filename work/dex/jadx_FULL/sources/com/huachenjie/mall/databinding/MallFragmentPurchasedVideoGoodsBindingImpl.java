package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsAdapter;
import com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsVM;
import com.zj.adlib.hk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallFragmentPurchasedVideoGoodsBindingImpl extends MallFragmentPurchasedVideoGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34961a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10693a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f10696a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34962a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34962a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34962a.onRefresh();
        }
    }

    public MallFragmentPurchasedVideoGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10693a, f34961a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        PurchasedVideoGoodsAdapter value;
        Integer value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f10694a;
            this.f10694a = 0L;
        }
        PurchasedVideoGoodsVM purchasedVideoGoodsVM = ((MallFragmentPurchasedVideoGoodsBinding) this).f10692a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MallFragmentPurchasedVideoGoodsBinding) this).f10690a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = purchasedVideoGoodsVM != null ? purchasedVideoGoodsVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = purchasedVideoGoodsVM != null ? purchasedVideoGoodsVM.v() : null;
                updateLiveDataRegistration(1, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<PurchasedVideoGoodsAdapter> mutableLiveDataB = purchasedVideoGoodsVM != null ? purchasedVideoGoodsVM.B() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f10696a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f10696a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f10695a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((42 & j) != 0) {
            this.f10695a.setRefreshing(zSafeUnbox);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((MallFragmentPurchasedVideoGoodsBinding) this).f34960a, value, false, false);
        }
        if ((j & 41) != 0) {
            xq8.a(((MallFragmentPurchasedVideoGoodsBinding) this).f10691a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10694a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10694a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentPurchasedVideoGoodsBinding
    public void l(@Nullable PurchasedVideoGoodsVM purchasedVideoGoodsVM) {
        ((MallFragmentPurchasedVideoGoodsBinding) this).f10692a = purchasedVideoGoodsVM;
        synchronized (this) {
            this.f10694a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<PurchasedVideoGoodsAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10694a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10694a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10694a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentPurchasedVideoGoodsBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MallFragmentPurchasedVideoGoodsBinding) this).f10690a = onRefreshListener;
        synchronized (this) {
            this.f10694a |= 16;
        }
        notifyPropertyChanged(hk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            l((PurchasedVideoGoodsVM) obj);
        } else {
            if (hk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MallFragmentPurchasedVideoGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[2], (StateLayout) objArr[1]);
        this.f10694a = -1L;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[0];
        this.f10695a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((MallFragmentPurchasedVideoGoodsBinding) this).f34960a.setTag(null);
        ((MallFragmentPurchasedVideoGoodsBinding) this).f10691a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
