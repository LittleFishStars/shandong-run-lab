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
import com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailAdapter;
import com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityWearableDeductionDetailBindingImpl extends RunActivityWearableDeductionDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11666a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f11664a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f35515a = null;
    }

    public RunActivityWearableDeductionDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11664a, f35515a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f11665a;
            this.f11665a = 0L;
        }
        WearableDeductionDetailVM wearableDeductionDetailVM = ((RunActivityWearableDeductionDetailBinding) this).f11663a;
        WearableDeductionDetailAdapter value2 = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = wearableDeductionDetailVM != null ? wearableDeductionDetailVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<WearableDeductionDetailAdapter> mutableLiveDataJ = wearableDeductionDetailVM != null ? wearableDeductionDetailVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((26 & j) != 0) {
            CommonBindingAdapter.g(((RunActivityWearableDeductionDetailBinding) this).f35514a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((RunActivityWearableDeductionDetailBinding) this).f11662a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityWearableDeductionDetailBinding) this).f11662a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11665a != 0) {
                return true;
            }
            return ((RunActivityWearableDeductionDetailBinding) this).f11662a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11665a = 16L;
        }
        ((RunActivityWearableDeductionDetailBinding) this).f11662a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityWearableDeductionDetailBinding
    public void k(@Nullable WearableDeductionDetailVM Vm) {
        ((RunActivityWearableDeductionDetailBinding) this).f11663a = Vm;
        synchronized (this) {
            this.f11665a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11665a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<WearableDeductionDetailAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11665a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11665a |= 1;
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
        ((RunActivityWearableDeductionDetailBinding) this).f11662a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((WearableDeductionDetailVM) variable);
        return true;
    }

    public RunActivityWearableDeductionDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[1], (LayoutToolbarBindingBinding) bindings[2]);
        this.f11665a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f11666a = frameLayout;
        frameLayout.setTag(null);
        ((RunActivityWearableDeductionDetailBinding) this).f35514a.setTag(null);
        setContainedBinding(((RunActivityWearableDeductionDetailBinding) this).f11662a);
        setRootTag(root);
        invalidateAll();
    }
}
