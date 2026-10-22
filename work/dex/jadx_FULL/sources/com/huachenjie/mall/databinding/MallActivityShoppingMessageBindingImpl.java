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
import com.huachenjie.mall.page.shopping_message.ShoppingMessageAdapter;
import com.huachenjie.mall.page.shopping_message.ShoppingMessageVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityShoppingMessageBindingImpl extends MallActivityShoppingMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f10453a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34877a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34877a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34877a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f10449a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34876a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.state_layout, 4);
    }

    public MallActivityShoppingMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10449a, f34876a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        ShoppingMessageAdapter value;
        BindingTitleBean value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f10450a;
            this.f10450a = 0L;
        }
        ShoppingMessageVM shoppingMessageVM = ((MallActivityShoppingMessageBinding) this).f10448a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MallActivityShoppingMessageBinding) this).f10445a;
        if ((93 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = shoppingMessageVM != null ? shoppingMessageVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = shoppingMessageVM != null ? shoppingMessageVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM = shoppingMessageVM != null ? shoppingMessageVM.m() : null;
                updateLiveDataRegistration(3, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 96;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f10453a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f10453a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f10452a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((84 & j) != 0) {
            this.f10452a.setRefreshing(zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityShoppingMessageBinding) this).f34875a, value, false, false);
        }
        if ((j & 81) != 0) {
            ((MallActivityShoppingMessageBinding) this).f10446a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityShoppingMessageBinding) this).f10446a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10450a != 0) {
                return true;
            }
            return ((MallActivityShoppingMessageBinding) this).f10446a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10450a = 64L;
        }
        ((MallActivityShoppingMessageBinding) this).f10446a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShoppingMessageBinding
    public void l(@Nullable ShoppingMessageVM shoppingMessageVM) {
        ((MallActivityShoppingMessageBinding) this).f10448a = shoppingMessageVM;
        synchronized (this) {
            this.f10450a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10450a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<ShoppingMessageAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10450a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10450a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10450a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityShoppingMessageBinding) this).f10446a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShoppingMessageBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MallActivityShoppingMessageBinding) this).f10445a = onRefreshListener;
        synchronized (this) {
            this.f10450a |= 32;
        }
        notifyPropertyChanged(hk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            l((ShoppingMessageVM) obj);
        } else {
            if (hk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MallActivityShoppingMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[2], (StateLayout) objArr[4], (LayoutToolbarBindingBinding) objArr[3]);
        this.f10450a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10451a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f10452a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((MallActivityShoppingMessageBinding) this).f34875a.setTag(null);
        setContainedBinding(((MallActivityShoppingMessageBinding) this).f10446a);
        setRootTag(view);
        invalidateAll();
    }
}
