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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.search.SearchHotSpotAdapter;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentSearchHotSpotBindingImpl extends WorksFragmentSearchHotSpotBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14302a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14305a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36947a = sparseIntArray;
        sparseIntArray.put(R.id.state_view, 2);
    }

    public WorksFragmentSearchHotSpotBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14302a, f36947a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14303a;
            this.f14303a = 0L;
        }
        SearchHotSpotModel searchHotSpotModel = ((WorksFragmentSearchHotSpotBinding) this).f14301a;
        long j2 = j & 7;
        SearchHotSpotAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<SearchHotSpotAdapter> mutableLiveDataC = searchHotSpotModel != null ? searchHotSpotModel.C() : null;
            updateLiveDataRegistration(0, mutableLiveDataC);
            if (mutableLiveDataC != null) {
                value = mutableLiveDataC.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f14304a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14303a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14303a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchHotSpotBinding
    public void k(@Nullable SearchHotSpotModel Vm) {
        ((WorksFragmentSearchHotSpotBinding) this).f14301a = Vm;
        synchronized (this) {
            this.f14303a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<SearchHotSpotAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14303a |= 1;
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
        k((SearchHotSpotModel) variable);
        return true;
    }

    public WorksFragmentSearchHotSpotBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (StateLayout) bindings[2]);
        this.f14303a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14305a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) bindings[1];
        this.f14304a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
