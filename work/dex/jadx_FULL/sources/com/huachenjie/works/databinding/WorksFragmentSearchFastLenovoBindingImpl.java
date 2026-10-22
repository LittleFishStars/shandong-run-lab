package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.adapter.search.SearchFastLenovoAdapter;
import com.huachenjie.works.page.search.fast_lenovo.SearchFastLenovoModel;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentSearchFastLenovoBindingImpl extends WorksFragmentSearchFastLenovoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36945a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14298a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14300a;

    public WorksFragmentSearchFastLenovoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f14298a, f36945a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14299a;
            this.f14299a = 0L;
        }
        SearchFastLenovoModel searchFastLenovoModel = ((WorksFragmentSearchFastLenovoBinding) this).f36944a;
        long j2 = j & 7;
        SearchFastLenovoAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<SearchFastLenovoAdapter> mutableLiveDataI = searchFastLenovoModel != null ? searchFastLenovoModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f14300a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14299a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14299a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchFastLenovoBinding
    public void k(@Nullable SearchFastLenovoModel Vm) {
        ((WorksFragmentSearchFastLenovoBinding) this).f36944a = Vm;
        synchronized (this) {
            this.f14299a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<SearchFastLenovoAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14299a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((SearchFastLenovoModel) variable);
        return true;
    }

    public WorksFragmentSearchFastLenovoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f14299a = -1L;
        RecyclerView recyclerView = (RecyclerView) bindings[0];
        this.f14300a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
