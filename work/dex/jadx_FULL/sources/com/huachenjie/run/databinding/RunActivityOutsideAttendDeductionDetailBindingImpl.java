package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailAdapter;
import com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityOutsideAttendDeductionDetailBindingImpl extends RunActivityOutsideAttendDeductionDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11533a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f11531a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f35485a = null;
    }

    public RunActivityOutsideAttendDeductionDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11531a, f35485a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f11532a;
            this.f11532a = 0L;
        }
        OutsideAttendDeductionDetailVM outsideAttendDeductionDetailVM = ((RunActivityOutsideAttendDeductionDetailBinding) this).f11530a;
        OutsideAttendDeductionDetailAdapter value2 = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = outsideAttendDeductionDetailVM != null ? outsideAttendDeductionDetailVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<OutsideAttendDeductionDetailAdapter> mutableLiveDataJ = outsideAttendDeductionDetailVM != null ? outsideAttendDeductionDetailVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((26 & j) != 0) {
            CommonBindingAdapter.g(((RunActivityOutsideAttendDeductionDetailBinding) this).f35484a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11532a != 0) {
                return true;
            }
            return ((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11532a = 16L;
        }
        ((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityOutsideAttendDeductionDetailBinding
    public void k(@Nullable OutsideAttendDeductionDetailVM Vm) {
        ((RunActivityOutsideAttendDeductionDetailBinding) this).f11530a = Vm;
        synchronized (this) {
            this.f11532a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11532a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<OutsideAttendDeductionDetailAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11532a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11532a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((OutsideAttendDeductionDetailVM) variable);
        return true;
    }

    public RunActivityOutsideAttendDeductionDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[1], (LayoutToolbarBindingBinding) bindings[2]);
        this.f11532a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f11533a = frameLayout;
        frameLayout.setTag(null);
        ((RunActivityOutsideAttendDeductionDetailBinding) this).f35484a.setTag(null);
        setContainedBinding(((RunActivityOutsideAttendDeductionDetailBinding) this).f11529a);
        setRootTag(root);
        invalidateAll();
    }
}
