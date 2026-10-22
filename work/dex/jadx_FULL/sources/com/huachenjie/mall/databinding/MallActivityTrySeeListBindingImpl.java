package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.page.try_see_list.TrySeeListAdapter;
import com.huachenjie.mall.page.try_see_list.TrySeeListVM;
import com.zj.adlib.hk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityTrySeeListBindingImpl extends MallActivityTrySeeListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f10473a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34884a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34884a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34884a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f10469a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f34883a = null;
    }

    public MallActivityTrySeeListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10469a, f34883a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        TrySeeListAdapter value;
        Integer value2;
        BindingTitleBean value3;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f10470a;
            this.f10470a = 0L;
        }
        TrySeeListVM trySeeListVM = ((MallActivityTrySeeListBinding) this).f10468a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MallActivityTrySeeListBinding) this).f10465a;
        if ((187 & j) != 0) {
            if ((j & 161) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = trySeeListVM != null ? trySeeListVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 162) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = trySeeListVM != null ? trySeeListVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 168) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = trySeeListVM != null ? trySeeListVM.v() : null;
                updateLiveDataRegistration(3, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 176) == 0) {
                value = null;
            } else {
                MutableLiveData<TrySeeListAdapter> mutableLiveDataB = trySeeListVM != null ? trySeeListVM.B() : null;
                updateLiveDataRegistration(4, mutableLiveDataB);
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
            value3 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f10473a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f10473a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f10472a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((168 & j) != 0) {
            this.f10472a.setRefreshing(zSafeUnbox);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityTrySeeListBinding) this).f34882a, value, false, false);
        }
        if ((161 & j) != 0) {
            xq8.a(((MallActivityTrySeeListBinding) this).f10467a, value2, null);
        }
        if ((j & 162) != 0) {
            ((MallActivityTrySeeListBinding) this).f10466a.k(value3);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityTrySeeListBinding) this).f10466a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10470a != 0) {
                return true;
            }
            return ((MallActivityTrySeeListBinding) this).f10466a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10470a = 128L;
        }
        ((MallActivityTrySeeListBinding) this).f10466a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityTrySeeListBinding
    public void l(@Nullable TrySeeListVM trySeeListVM) {
        ((MallActivityTrySeeListBinding) this).f10468a = trySeeListVM;
        synchronized (this) {
            this.f10470a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10470a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<TrySeeListAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10470a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10470a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return m((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 3) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10470a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10470a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityTrySeeListBinding) this).f10466a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.mall.databinding.MallActivityTrySeeListBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MallActivityTrySeeListBinding) this).f10465a = onRefreshListener;
        synchronized (this) {
            this.f10470a |= 64;
        }
        notifyPropertyChanged(hk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            l((TrySeeListVM) obj);
        } else {
            if (hk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MallActivityTrySeeListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[3], (StateLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[4]);
        this.f10470a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10471a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f10472a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((MallActivityTrySeeListBinding) this).f34882a.setTag(null);
        ((MallActivityTrySeeListBinding) this).f10467a.setTag(null);
        setContainedBinding(((MallActivityTrySeeListBinding) this).f10466a);
        setRootTag(view);
        invalidateAll();
    }
}
