package com.huachenjie.run.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.RunActionButton;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutRunStatusSheetBindingImpl extends RunLayoutRunStatusSheetBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f12162a;

    @NonNull
    public final LinearLayout b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f12160a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_pause_header"}, new int[]{5}, new int[]{R.layout.run_layout_pause_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35697a = sparseIntArray;
        sparseIntArray.put(R.id.llCollapsedHeader, 6);
        sparseIntArray.put(R.id.tvRunKmLabel, 7);
        sparseIntArray.put(R.id.actionButton, 8);
    }

    public RunLayoutRunStatusSheetBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f12160a, f35697a));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0085  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        String str2;
        int i;
        long j2;
        String value;
        synchronized (this) {
            j = this.f12161a;
            this.f12161a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutRunStatusSheetBinding) this).f12158a;
        String value2 = null;
        if ((126 & j) != 0) {
            long j3 = j & 98;
            if (j3 != 0) {
                MutableLiveData<Integer> mutableLiveDataG = sunshineRunVM != null ? sunshineRunVM.G() : null;
                updateLiveDataRegistration(1, mutableLiveDataG);
                int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataG != null ? mutableLiveDataG.getValue() : null);
                boolean z = iSafeUnbox >= 100;
                if (j3 != 0) {
                    j |= z ? 256L : 128L;
                }
                drawable = AppCompatResources.getDrawable(this.f12162a.getContext(), z ? R.drawable.run_bg_run_sheet_progress_done : R.drawable.run_bg_run_sheet_progress);
                i = iSafeUnbox;
            } else {
                drawable = null;
                i = 0;
            }
            if ((j & 100) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = sunshineRunVM != null ? sunshineRunVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value = mutableLiveDataO.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 104) != 0) {
                MutableLiveData<String> mutableLiveDataN = sunshineRunVM != null ? sunshineRunVM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                str = (mutableLiveDataN != null ? mutableLiveDataN.getValue() : null) + "km";
            } else {
                str = null;
            }
            if ((j & 112) != 0) {
                MutableLiveData<String> mutableLiveDataT = sunshineRunVM != null ? sunshineRunVM.t() : null;
                updateLiveDataRegistration(4, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value2 = mutableLiveDataT.getValue();
                }
            }
            str2 = value2;
            j2 = 98;
        } else {
            drawable = null;
            str = null;
            str2 = null;
            i = 0;
            j2 = 98;
            value = null;
        }
        if ((j & j2) != 0) {
            CommonBindingAdapter.R(this.f12162a, i);
            this.f12162a.setProgressDrawable(drawable);
        }
        if ((96 & j) != 0) {
            ((RunLayoutRunStatusSheetBinding) this).f12157a.k(sunshineRunVM);
        }
        if ((100 & j) != 0) {
            TextViewBindingAdapter.setText(((RunLayoutRunStatusSheetBinding) this).f12156a, value);
        }
        if ((104 & j) != 0) {
            TextViewBindingAdapter.setText(super.b, str);
        }
        if ((j & 112) != 0) {
            TextViewBindingAdapter.setText(this.d, str2);
        }
        ViewDataBinding.executeBindingsOn(((RunLayoutRunStatusSheetBinding) this).f12157a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12161a != 0) {
                return true;
            }
            return ((RunLayoutRunStatusSheetBinding) this).f12157a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12161a = 64L;
        }
        ((RunLayoutRunStatusSheetBinding) this).f12157a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunStatusSheetBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunLayoutRunStatusSheetBinding) this).f12158a = Vm;
        synchronized (this) {
            this.f12161a |= 32;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(RunLayoutPauseHeaderBinding PauseHeader, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12161a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> VmDistanceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12161a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> VmDurationText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12161a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmMinKmText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12161a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return l((RunLayoutPauseHeaderBinding) object, fieldId);
        }
        if (localFieldId == 1) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmProgressPercent, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12161a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunLayoutRunStatusSheetBinding) this).f12157a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public RunLayoutRunStatusSheetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (RunActionButton) bindings[8], (LinearLayout) bindings[6], (RunLayoutPauseHeaderBinding) bindings[5], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[7], (TextView) bindings[1]);
        this.f12161a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[4];
        this.f12162a = progressBar;
        progressBar.setTag(null);
        setContainedBinding(((RunLayoutRunStatusSheetBinding) this).f12157a);
        ((RunLayoutRunStatusSheetBinding) this).f12156a.setTag(null);
        super.b.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
