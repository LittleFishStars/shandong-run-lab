package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.PaceInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutPaceListBindingImpl extends RunLayoutPaceListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12109a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12111a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35681a = sparseIntArray;
        sparseIntArray.put(R.id.ll_pace_per_kilometer, 1);
    }

    public RunLayoutPaceListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f12109a, f35681a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.f12110a;
            this.f12110a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutPaceListBinding) this).f12108a;
        long j2 = j & 7;
        List<PaceInfo> paceInfoList = null;
        boolean z3 = false;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            paceInfoList = value != null ? value.getPaceInfoList() : null;
            z = paceInfoList != null;
            if (j2 != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            z = false;
        }
        if ((16 & j) != 0) {
            z2 = !(paceInfoList != null ? paceInfoList.isEmpty() : false);
        } else {
            z2 = false;
        }
        long j3 = j & 7;
        if (j3 != 0 && z) {
            z3 = z2;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f12111a, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12110a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12110a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutPaceListBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutPaceListBinding) this).f12108a = Vm;
        synchronized (this) {
            this.f12110a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12110a |= 1;
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

    public RunLayoutPaceListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LinearLayout) bindings[1]);
        this.f12110a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f12111a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
