package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.binding.RunBindingAdapter;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.AutoPauseView;
import com.huachenjie.run.widget.PaceErrorView;
import com.huachenjie.run.widget.RunActionButton;
import com.huachenjie.run.widget.RunStatusBottomSheet;
import com.zj.adlib.PaceErrorBigState;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivitySunshineRunBindingImpl extends RunActivitySunshineRunBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final RunLayoutSunRunDebugInfoBinding f11627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final RunLayoutSunRunPaceInfoBinding f11628a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f11624a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_sun_run_qualify_conditions", "run_layout_sun_run_debug_info", "run_layout_sun_run_pace_info", "run_layout_sun_run_side_toolbar"}, new int[]{2, 3, 4, 5}, new int[]{R.layout.run_layout_sun_run_qualify_conditions, R.layout.run_layout_sun_run_debug_info, R.layout.run_layout_sun_run_pace_info, R.layout.run_layout_sun_run_side_toolbar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35505a = sparseIntArray;
        sparseIntArray.put(R.id.mapContainer, 6);
        sparseIntArray.put(R.id.tvCreditSwordTip, 7);
        sparseIntArray.put(R.id.quitRunView, 8);
        sparseIntArray.put(R.id.runStatusSheet, 9);
        sparseIntArray.put(R.id.autoPauseView, 10);
    }

    public RunActivitySunshineRunBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 11, f11624a, f35505a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11625a;
            this.f11625a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunActivitySunshineRunBinding) this).f11619a;
        SunshineRunActivity.a aVar = ((RunActivitySunshineRunBinding) this).f11618a;
        long j2 = 41 & j;
        PaceErrorBigState value = null;
        if (j2 != 0) {
            MutableLiveData<PaceErrorBigState> mutableLiveDataX = sunshineRunVM != null ? sunshineRunVM.x() : null;
            updateLiveDataRegistration(0, mutableLiveDataX);
            if (mutableLiveDataX != null) {
                value = mutableLiveDataX.getValue();
            }
        }
        long j3 = 48 & j;
        if ((j & 40) != 0) {
            this.f11627a.k(sunshineRunVM);
            this.f11628a.k(sunshineRunVM);
            ((RunActivitySunshineRunBinding) this).f11616a.k(sunshineRunVM);
            ((RunActivitySunshineRunBinding) this).f11617a.m(sunshineRunVM);
        }
        if (j2 != 0) {
            RunBindingAdapter.c(((RunActivitySunshineRunBinding) this).f11621a, value);
        }
        if (j3 != 0) {
            ((RunActivitySunshineRunBinding) this).f11617a.l(aVar);
        }
        ViewDataBinding.executeBindingsOn(((RunActivitySunshineRunBinding) this).f11616a);
        ViewDataBinding.executeBindingsOn(this.f11627a);
        ViewDataBinding.executeBindingsOn(this.f11628a);
        ViewDataBinding.executeBindingsOn(((RunActivitySunshineRunBinding) this).f11617a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11625a != 0) {
                return true;
            }
            return ((RunActivitySunshineRunBinding) this).f11616a.hasPendingBindings() || this.f11627a.hasPendingBindings() || this.f11628a.hasPendingBindings() || ((RunActivitySunshineRunBinding) this).f11617a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11625a = 32L;
        }
        ((RunActivitySunshineRunBinding) this).f11616a.invalidateAll();
        this.f11627a.invalidateAll();
        this.f11628a.invalidateAll();
        ((RunActivitySunshineRunBinding) this).f11617a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRunBinding
    public void l(@Nullable SunshineRunActivity.a Click) {
        ((RunActivitySunshineRunBinding) this).f11618a = Click;
        synchronized (this) {
            this.f11625a |= 16;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRunBinding
    public void m(@Nullable SunshineRunVM Vm) {
        ((RunActivitySunshineRunBinding) this).f11619a = Vm;
        synchronized (this) {
            this.f11625a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(RunLayoutSunRunQualifyConditionsBinding QualifyConditions, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11625a |= 4;
        }
        return true;
    }

    public final boolean o(RunLayoutSunRunSideToolbarBinding SideToolbar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11625a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((RunLayoutSunRunSideToolbarBinding) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return n((RunLayoutSunRunQualifyConditionsBinding) object, fieldId);
    }

    public final boolean p(MutableLiveData<PaceErrorBigState> VmPaceErrorBigState, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11625a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivitySunshineRunBinding) this).f11616a.setLifecycleOwner(lifecycleOwner);
        this.f11627a.setLifecycleOwner(lifecycleOwner);
        this.f11628a.setLifecycleOwner(lifecycleOwner);
        ((RunActivitySunshineRunBinding) this).f11617a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRunVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRunActivity.a) variable);
        }
        return true;
    }

    public RunActivitySunshineRunBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (AutoPauseView) bindings[10], (FrameLayout) bindings[6], (PaceErrorView) bindings[1], (RunLayoutSunRunQualifyConditionsBinding) bindings[2], (RunActionButton) bindings[8], (RunStatusBottomSheet) bindings[9], (RunLayoutSunRunSideToolbarBinding) bindings[5], (ShadowFrameLayout) bindings[7]);
        this.f11625a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11626a = relativeLayout;
        relativeLayout.setTag(null);
        RunLayoutSunRunDebugInfoBinding runLayoutSunRunDebugInfoBinding = (RunLayoutSunRunDebugInfoBinding) bindings[3];
        this.f11627a = runLayoutSunRunDebugInfoBinding;
        setContainedBinding(runLayoutSunRunDebugInfoBinding);
        RunLayoutSunRunPaceInfoBinding runLayoutSunRunPaceInfoBinding = (RunLayoutSunRunPaceInfoBinding) bindings[4];
        this.f11628a = runLayoutSunRunPaceInfoBinding;
        setContainedBinding(runLayoutSunRunPaceInfoBinding);
        ((RunActivitySunshineRunBinding) this).f11621a.setTag(null);
        setContainedBinding(((RunActivitySunshineRunBinding) this).f11616a);
        setContainedBinding(((RunActivitySunshineRunBinding) this).f11617a);
        setRootTag(root);
        invalidateAll();
    }
}
