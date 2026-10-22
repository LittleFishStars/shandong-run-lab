package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.SearchVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivitySearchBindingImpl extends WorksActivitySearchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13943a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13945a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36807a = sparseIntArray;
        sparseIntArray.put(R.id.fl_container, 2);
    }

    public WorksActivitySearchBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f13943a, f36807a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13944a;
            this.f13944a = 0L;
        }
        SearchVM searchVM = ((WorksActivitySearchBinding) this).f13942a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = searchVM != null ? searchVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 16));
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.I(((WorksActivitySearchBinding) this).f13941a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13944a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13944a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivitySearchBinding
    public void k(@Nullable SearchVM Vm) {
        ((WorksActivitySearchBinding) this).f13942a = Vm;
        synchronized (this) {
            this.f13944a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13944a |= 1;
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
        k((SearchVM) variable);
        return true;
    }

    public WorksActivitySearchBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (FrameLayout) bindings[2], (CommonSearchViewV2) bindings[1]);
        this.f13944a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f13945a = linearLayout;
        linearLayout.setTag(null);
        ((WorksActivitySearchBinding) this).f13941a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
