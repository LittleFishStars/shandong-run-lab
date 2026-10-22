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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.page.search.result.child.SearchResultBuddyModel;
import com.zj.adlib.qk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentSearchResultBuddyBindingImpl extends WorksFragmentSearchResultBuddyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36951a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14316a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14318a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36952a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36952a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36952a.onRefresh();
        }
    }

    public WorksFragmentSearchResultBuddyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14316a, f36951a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        BaseQuickAdapter<BuddyCardBean, ?> value;
        Integer value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f14317a;
            this.f14317a = 0L;
        }
        SearchResultBuddyModel searchResultBuddyModel = ((WorksFragmentSearchResultBuddyBinding) this).f14315a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentSearchResultBuddyBinding) this).f14312a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = searchResultBuddyModel != null ? searchResultBuddyModel.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = searchResultBuddyModel != null ? searchResultBuddyModel.v() : null;
                updateLiveDataRegistration(1, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<BaseQuickAdapter<BuddyCardBean, ?>> mutableLiveDataB = searchResultBuddyModel != null ? searchResultBuddyModel.B() : null;
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
            OnRefreshListenerImpl onRefreshListenerImpl = this.f14318a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f14318a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentSearchResultBuddyBinding) this).f36950a, value, false, false);
        }
        if (j2 != 0) {
            ((WorksFragmentSearchResultBuddyBinding) this).f14313a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((42 & j) != 0) {
            ((WorksFragmentSearchResultBuddyBinding) this).f14313a.setRefreshing(zSafeUnbox);
        }
        if ((j & 41) != 0) {
            xq8.a(((WorksFragmentSearchResultBuddyBinding) this).f14314a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14317a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14317a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchResultBuddyBinding
    public void l(@Nullable SearchResultBuddyModel Vm) {
        ((WorksFragmentSearchResultBuddyBinding) this).f14315a = Vm;
        synchronized (this) {
            this.f14317a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14317a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14317a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmLayoutState, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14317a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchResultBuddyBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentSearchResultBuddyBinding) this).f14312a = Refresh;
        synchronized (this) {
            this.f14317a |= 16;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((SearchResultBuddyModel) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentSearchResultBuddyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[2], (SwipeRefreshLayout) bindings[1], (StateLayout) bindings[0]);
        this.f14317a = -1L;
        ((WorksFragmentSearchResultBuddyBinding) this).f36950a.setTag(null);
        ((WorksFragmentSearchResultBuddyBinding) this).f14313a.setTag(null);
        ((WorksFragmentSearchResultBuddyBinding) this).f14314a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
