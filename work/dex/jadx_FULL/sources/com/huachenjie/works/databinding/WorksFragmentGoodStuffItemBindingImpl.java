package com.huachenjie.works.databinding;

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
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffAdapter;
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentGoodStuffItemBindingImpl extends WorksFragmentGoodStuffItemBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36912a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14210a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14212a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36913a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36913a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36913a.onRefresh();
        }
    }

    public WorksFragmentGoodStuffItemBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14210a, f36912a));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        GoodStuffAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f14211a;
            this.f14211a = 0L;
        }
        GoodStuffItemVM goodStuffItemVM = ((WorksFragmentGoodStuffItemBinding) this).f14209a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentGoodStuffItemBinding) this).f14206a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = goodStuffItemVM != null ? goodStuffItemVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<GoodStuffAdapter> mutableLiveDataI = goodStuffItemVM != null ? goodStuffItemVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f14212a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f14212a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if ((22 & j) != 0) {
                CommonBindingAdapter.g(((WorksFragmentGoodStuffItemBinding) this).f36911a, value, false, false);
            }
            if (j2 != 0) {
                ((WorksFragmentGoodStuffItemBinding) this).f14207a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((j & 21) != 0) {
                ((WorksFragmentGoodStuffItemBinding) this).f14207a.setRefreshing(zSafeUnbox);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f14212a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f14212a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentGoodStuffItemBinding) this).f36911a, value, false, false);
        }
        if (j2 != 0) {
            ((WorksFragmentGoodStuffItemBinding) this).f14207a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 21) != 0) {
            ((WorksFragmentGoodStuffItemBinding) this).f14207a.setRefreshing(zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14211a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14211a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentGoodStuffItemBinding
    public void l(@Nullable GoodStuffItemVM Vm) {
        ((WorksFragmentGoodStuffItemBinding) this).f14209a = Vm;
        synchronized (this) {
            this.f14211a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<GoodStuffAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14211a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14211a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentGoodStuffItemBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentGoodStuffItemBinding) this).f14206a = Refresh;
        synchronized (this) {
            this.f14211a |= 8;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((GoodStuffItemVM) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentGoodStuffItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RecyclerView) bindings[2], (SwipeRefreshLayout) bindings[1], (StateLayout) bindings[0]);
        this.f14211a = -1L;
        ((WorksFragmentGoodStuffItemBinding) this).f36911a.setTag(null);
        ((WorksFragmentGoodStuffItemBinding) this).f14207a.setTag(null);
        ((WorksFragmentGoodStuffItemBinding) this).f14208a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
