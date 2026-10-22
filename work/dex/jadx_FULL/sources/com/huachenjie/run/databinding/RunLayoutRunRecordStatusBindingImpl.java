package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutRunRecordStatusBindingImpl extends RunLayoutRunRecordStatusBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12153a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12155a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35695a = sparseIntArray;
        sparseIntArray.put(R.id.rv_status_log, 2);
        sparseIntArray.put(R.id.tv_status_expand, 3);
        sparseIntArray.put(R.id.iv_status_expand, 4);
    }

    public RunLayoutRunRecordStatusBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f12153a, f35695a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.f12154a;
            this.f12154a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutRunRecordStatusBinding) this).f12151a;
        long j2 = j & 7;
        List<RunRecordStatusLog> statusLogRecords = null;
        boolean z4 = true;
        boolean z5 = false;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            statusLogRecords = value != null ? value.getStatusLogRecords() : null;
            z = statusLogRecords != null;
            if (j2 != 0) {
                j = z ? j | 16 | 64 : j | 8 | 32;
            }
        } else {
            z = false;
        }
        if ((j & 80) != 0) {
            int size = statusLogRecords != null ? statusLogRecords.size() : 0;
            z2 = (64 & j) != 0 && size > 0;
            if ((16 & j) == 0 || size <= 1) {
                z4 = false;
            }
        } else {
            z2 = false;
            z4 = false;
        }
        long j3 = j & 7;
        if (j3 != 0) {
            if (!z) {
                z4 = false;
            }
            z3 = z ? z2 : false;
            z5 = z4;
        } else {
            z3 = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(((RunLayoutRunRecordStatusBinding) this).f12152a, z5);
            CommonBindingAdapter.l0(this.f12155a, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12154a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12154a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunRecordStatusBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutRunRecordStatusBinding) this).f12151a = Vm;
        synchronized (this) {
            this.f12154a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12154a |= 1;
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

    public RunLayoutRunRecordStatusBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[4], (BLLinearLayout) bindings[1], (RecyclerView) bindings[2], (TextView) bindings[3]);
        this.f12154a = -1L;
        ((RunLayoutRunRecordStatusBinding) this).f12152a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f12155a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
