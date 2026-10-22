package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.original.OriginalChannelVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentOriginalChannelBindingImpl extends WorksFragmentOriginalChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14227a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14229a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36920a = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 2);
        sparseIntArray.put(R.id.view_pager, 3);
    }

    public WorksFragmentOriginalChannelBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14227a, f36920a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14228a;
            this.f14228a = 0L;
        }
        OriginalChannelVM originalChannelVM = ((WorksFragmentOriginalChannelBinding) this).f14226a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = originalChannelVM != null ? originalChannelVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.I(((WorksFragmentOriginalChannelBinding) this).f36919a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14228a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14228a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentOriginalChannelBinding
    public void k(@Nullable OriginalChannelVM Vm) {
        ((WorksFragmentOriginalChannelBinding) this).f14226a = Vm;
        synchronized (this) {
            this.f14228a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14228a |= 1;
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
        k((OriginalChannelVM) variable);
        return true;
    }

    public WorksFragmentOriginalChannelBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (SelectBoldTabLayout) bindings[2], (View) bindings[1], (ViewPager2) bindings[3]);
        this.f14228a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14229a = linearLayout;
        linearLayout.setTag(null);
        ((WorksFragmentOriginalChannelBinding) this).f36919a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
