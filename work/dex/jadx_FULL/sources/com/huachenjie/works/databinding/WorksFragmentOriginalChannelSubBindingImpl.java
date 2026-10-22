package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.original.OriginalChannelSubAdapter;
import com.huachenjie.works.page.alumni.original.OriginalChannelSubVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentOriginalChannelSubBindingImpl extends WorksFragmentOriginalChannelSubBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14233a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14237a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36923a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36923a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36923a.onRefresh();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36922a = sparseIntArray;
        sparseIntArray.put(R.id.state_layout, 3);
    }

    public WorksFragmentOriginalChannelSubBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14233a, f36922a));
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
        OriginalChannelSubAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f14234a;
            this.f14234a = 0L;
        }
        OriginalChannelSubVM originalChannelSubVM = ((WorksFragmentOriginalChannelSubBinding) this).f14232a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentOriginalChannelSubBinding) this).f14230a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = originalChannelSubVM != null ? originalChannelSubVM.v() : null;
                updateLiveDataRegistration(0, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<OriginalChannelSubAdapter> mutableLiveDataB = originalChannelSubVM != null ? originalChannelSubVM.B() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f14237a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f14237a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if (j2 != 0) {
                this.f14236a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((21 & j) != 0) {
                this.f14236a.setRefreshing(zSafeUnbox);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.g(((WorksFragmentOriginalChannelSubBinding) this).f36921a, value, false, false);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f14237a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f14237a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f14236a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((21 & j) != 0) {
            this.f14236a.setRefreshing(zSafeUnbox);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(((WorksFragmentOriginalChannelSubBinding) this).f36921a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14234a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14234a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentOriginalChannelSubBinding
    public void l(@Nullable OriginalChannelSubVM Vm) {
        ((WorksFragmentOriginalChannelSubBinding) this).f14232a = Vm;
        synchronized (this) {
            this.f14234a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<OriginalChannelSubAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14234a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14234a |= 1;
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

    @Override // com.huachenjie.works.databinding.WorksFragmentOriginalChannelSubBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentOriginalChannelSubBinding) this).f14230a = Refresh;
        synchronized (this) {
            this.f14234a |= 8;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((OriginalChannelSubVM) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentOriginalChannelSubBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RecyclerView) bindings[2], (StateLayout) bindings[3]);
        this.f14234a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14235a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) bindings[1];
        this.f14236a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((WorksFragmentOriginalChannelSubBinding) this).f36921a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
