package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunVision;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutRunVisionBindingImpl extends RunLayoutRunVisionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12166a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12168a;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35700a = sparseIntArray;
        sparseIntArray.put(R.id.tv_vision_title, 3);
        sparseIntArray.put(R.id.tv_require_title, 4);
        sparseIntArray.put(R.id.tv_actual_title, 5);
    }

    public RunLayoutRunVisionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f12166a, f35700a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String visionActualDisplay;
        RunVision runVision;
        boolean z;
        boolean zIsVisionDisplay;
        String strValueOf;
        synchronized (this) {
            j = this.f12167a;
            this.f12167a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutRunVisionBinding) this).f12165a;
        long j2 = j & 7;
        String str = null;
        boolean z2 = false;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if (value != null) {
                zIsVisionDisplay = value.isVisionDisplay();
                runVision = value.getRunVision();
                visionActualDisplay = value.getVisionActualDisplay();
            } else {
                visionActualDisplay = null;
                runVision = null;
                zIsVisionDisplay = false;
            }
            if (j2 != 0) {
                j |= zIsVisionDisplay ? 64L : 32L;
            }
            z = runVision != null;
            if ((j & 7) != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            visionActualDisplay = null;
            runVision = null;
            z = false;
            zIsVisionDisplay = false;
        }
        if ((16 & j) != 0) {
            strValueOf = String.valueOf(runVision != null ? runVision.getTargetNumber() : 0);
        } else {
            strValueOf = null;
        }
        long j3 = j & 7;
        if (j3 != 0 && zIsVisionDisplay) {
            z2 = z;
        }
        if (j3 != 0) {
            str = z ? strValueOf : "";
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f12168a, z2);
            TextViewBindingAdapter.setText(this.d, str);
            TextViewBindingAdapter.setText(this.e, visionActualDisplay);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12167a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12167a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunVisionBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutRunVisionBinding) this).f12165a = Vm;
        synchronized (this) {
            this.f12167a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12167a |= 1;
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
        if (lk0.p0 != variableId) {
            return false;
        }
        k((RunDetailVM) variable);
        return true;
    }

    public RunLayoutRunVisionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[3]);
        this.f12167a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f12168a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.e = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
