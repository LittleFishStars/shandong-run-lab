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
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.page.search.result.child.SearchResultUserModel;
import com.zj.adlib.qk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentSearchResultUserBindingImpl extends WorksFragmentSearchResultUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36957a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14330a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14332a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36958a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36958a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36958a.onRefresh();
        }
    }

    public WorksFragmentSearchResultUserBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14330a, f36957a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        BaseQuickAdapter<UserInfoBean, ?> value;
        Integer value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f14331a;
            this.f14331a = 0L;
        }
        SearchResultUserModel searchResultUserModel = ((WorksFragmentSearchResultUserBinding) this).f14329a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentSearchResultUserBinding) this).f14326a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = searchResultUserModel != null ? searchResultUserModel.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = searchResultUserModel != null ? searchResultUserModel.v() : null;
                updateLiveDataRegistration(1, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<BaseQuickAdapter<UserInfoBean, ?>> mutableLiveDataB = searchResultUserModel != null ? searchResultUserModel.B() : null;
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
            OnRefreshListenerImpl onRefreshListenerImpl = this.f14332a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f14332a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentSearchResultUserBinding) this).f36956a, value, false, false);
        }
        if (j2 != 0) {
            ((WorksFragmentSearchResultUserBinding) this).f14327a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((42 & j) != 0) {
            ((WorksFragmentSearchResultUserBinding) this).f14327a.setRefreshing(zSafeUnbox);
        }
        if ((j & 41) != 0) {
            xq8.a(((WorksFragmentSearchResultUserBinding) this).f14328a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14331a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14331a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchResultUserBinding
    public void l(@Nullable SearchResultUserModel Vm) {
        ((WorksFragmentSearchResultUserBinding) this).f14329a = Vm;
        synchronized (this) {
            this.f14331a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14331a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14331a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmLayoutState, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14331a |= 1;
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

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchResultUserBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentSearchResultUserBinding) this).f14326a = Refresh;
        synchronized (this) {
            this.f14331a |= 16;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((SearchResultUserModel) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentSearchResultUserBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[2], (SwipeRefreshLayout) bindings[1], (StateLayout) bindings[0]);
        this.f14331a = -1L;
        ((WorksFragmentSearchResultUserBinding) this).f36956a.setTag(null);
        ((WorksFragmentSearchResultUserBinding) this).f14327a.setTag(null);
        ((WorksFragmentSearchResultUserBinding) this).f14328a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
