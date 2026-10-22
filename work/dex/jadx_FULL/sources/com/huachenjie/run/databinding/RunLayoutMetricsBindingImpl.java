package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutMetricsBindingImpl extends RunLayoutMetricsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12097a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(2);
        f12095a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_metrics_content"}, new int[]{1}, new int[]{R.layout.run_layout_metrics_content});
        f35675a = null;
    }

    public RunLayoutMetricsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f12095a, f35675a));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0055  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.f12096a;
            this.f12096a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutMetricsBinding) this).f12094a;
        long j2 = j & 14;
        List<RunRecordStatusLog> statusLogRecords = null;
        boolean z3 = false;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(1, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            statusLogRecords = value != null ? value.getStatusLogRecords() : null;
            z = statusLogRecords != null;
            if (j2 != 0) {
                j = z ? j | 32 : j | 16;
            }
        } else {
            z = false;
        }
        if ((j & 32) != 0) {
            z2 = (statusLogRecords != null ? statusLogRecords.size() : 0) > 0;
        }
        long j3 = 14 & j;
        if (j3 != 0 && z) {
            z3 = z2;
        }
        if ((j & 12) != 0) {
            ((RunLayoutMetricsBinding) this).f35674a.k(runDetailVM);
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f12097a, z3);
        }
        ViewDataBinding.executeBindingsOn(((RunLayoutMetricsBinding) this).f35674a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12096a != 0) {
                return true;
            }
            return ((RunLayoutMetricsBinding) this).f35674a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12096a = 8L;
        }
        ((RunLayoutMetricsBinding) this).f35674a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutMetricsBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutMetricsBinding) this).f12094a = Vm;
        synchronized (this) {
            this.f12096a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(RunLayoutMetricsContentBinding LayoutMetricsContent, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12096a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12096a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return l((RunLayoutMetricsContentBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunLayoutMetricsBinding) this).f35674a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((RunDetailVM) variable);
        return true;
    }

    public RunLayoutMetricsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RunLayoutMetricsContentBinding) bindings[1]);
        this.f12096a = -1L;
        setContainedBinding(((RunLayoutMetricsBinding) this).f35674a);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f12097a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
