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
import com.huachenjie.mall.page.comment.list.CommodityCommentAdapter;
import com.huachenjie.mall.page.comment.list.CommodityCommentListVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallFragmentCommodityCommentListBindingImpl extends MallFragmentCommodityCommentListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34950a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10669a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f10672a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34951a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34951a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34951a.onRefresh();
        }
    }

    public MallFragmentCommodityCommentListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10669a, f34950a));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        CommodityCommentAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f10670a;
            this.f10670a = 0L;
        }
        CommodityCommentListVM commodityCommentListVM = ((MallFragmentCommodityCommentListBinding) this).f10668a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MallFragmentCommodityCommentListBinding) this).f10666a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = commodityCommentListVM != null ? commodityCommentListVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<CommodityCommentAdapter> mutableLiveDataI = commodityCommentListVM != null ? commodityCommentListVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f10672a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f10672a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if (j2 != 0) {
                this.f10671a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((21 & j) != 0) {
                this.f10671a.setRefreshing(zSafeUnbox);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.g(((MallFragmentCommodityCommentListBinding) this).f34949a, value, false, false);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f10672a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f10672a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f10671a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((21 & j) != 0) {
            this.f10671a.setRefreshing(zSafeUnbox);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(((MallFragmentCommodityCommentListBinding) this).f34949a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10670a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10670a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentCommodityCommentListBinding
    public void l(@Nullable CommodityCommentListVM commodityCommentListVM) {
        ((MallFragmentCommodityCommentListBinding) this).f10668a = commodityCommentListVM;
        synchronized (this) {
            this.f10670a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<CommodityCommentAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10670a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10670a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentCommodityCommentListBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MallFragmentCommodityCommentListBinding) this).f10666a = onRefreshListener;
        synchronized (this) {
            this.f10670a |= 8;
        }
        notifyPropertyChanged(hk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            l((CommodityCommentListVM) obj);
        } else {
            if (hk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MallFragmentCommodityCommentListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[2], (StateLayout) objArr[0]);
        this.f10670a = -1L;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f10671a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((MallFragmentCommodityCommentListBinding) this).f34949a.setTag(null);
        ((MallFragmentCommodityCommentListBinding) this).f10667a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
