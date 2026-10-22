package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.LiveData;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.RunActionButton;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogPauseBindingImpl extends RunDialogPauseBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11759a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f11757a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_pause_header"}, new int[]{3}, new int[]{R.layout.run_layout_pause_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35550a = sparseIntArray;
        sparseIntArray.put(R.id.clRest, 4);
        sparseIntArray.put(R.id.tvRestTitle, 5);
        sparseIntArray.put(R.id.tvRestSecUnit, 6);
        sparseIntArray.put(R.id.tvRestMinUnit, 7);
        sparseIntArray.put(R.id.quitRunView, 8);
        sparseIntArray.put(R.id.resumeRunView, 9);
    }

    public RunDialogPauseBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f11757a, f35550a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String value;
        synchronized (this) {
            j = this.f11758a;
            this.f11758a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunDialogPauseBinding) this).f11753a;
        String value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                LiveData<String> liveDataB = sunshineRunVM != null ? sunshineRunVM.B() : null;
                updateLiveDataRegistration(0, liveDataB);
                if (liveDataB != null) {
                    value = liveDataB.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                LiveData<String> liveDataC = sunshineRunVM != null ? sunshineRunVM.C() : null;
                updateLiveDataRegistration(2, liveDataC);
                if (liveDataC != null) {
                    value2 = liveDataC.getValue();
                }
            }
            String str2 = value2;
            value2 = value;
            str = str2;
        } else {
            str = null;
        }
        if ((24 & j) != 0) {
            ((RunDialogPauseBinding) this).f11752a.k(sunshineRunVM);
        }
        if ((25 & j) != 0) {
            TextViewBindingAdapter.setText(((RunDialogPauseBinding) this).f35549a, value2);
        }
        if ((j & 28) != 0) {
            TextViewBindingAdapter.setText(this.c, str);
        }
        ViewDataBinding.executeBindingsOn(((RunDialogPauseBinding) this).f11752a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11758a != 0) {
                return true;
            }
            return ((RunDialogPauseBinding) this).f11752a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11758a = 16L;
        }
        ((RunDialogPauseBinding) this).f11752a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogPauseBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunDialogPauseBinding) this).f11753a = Vm;
        synchronized (this) {
            this.f11758a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(RunLayoutPauseHeaderBinding PauseHeader, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11758a |= 2;
        }
        return true;
    }

    public final boolean m(LiveData<String> VmPauseMinText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11758a |= 1;
        }
        return true;
    }

    public final boolean n(LiveData<String> VmPauseSecText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11758a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((LiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return l((RunLayoutPauseHeaderBinding) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return n((LiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunDialogPauseBinding) this).f11752a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public RunDialogPauseBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BLRelativeLayout) bindings[4], (RunLayoutPauseHeaderBinding) bindings[3], (RunActionButton) bindings[8], (RunActionButton) bindings[9], (TextView) bindings[2], (TextView) bindings[7], (TextView) bindings[1], (TextView) bindings[6], (TextView) bindings[5]);
        this.f11758a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f11759a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        setContainedBinding(((RunDialogPauseBinding) this).f11752a);
        ((RunDialogPauseBinding) this).f35549a.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
