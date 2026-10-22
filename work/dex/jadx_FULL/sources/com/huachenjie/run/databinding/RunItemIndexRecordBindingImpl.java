package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemIndexRecordBindingImpl extends RunItemIndexRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11949a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11951a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35621a = sparseIntArray;
        sparseIntArray.put(R.id.tv_run_distance, 3);
        sparseIntArray.put(R.id.tv_run_distance_unit, 4);
        sparseIntArray.put(R.id.iv_status, 5);
        sparseIntArray.put(R.id.tv_visioning, 6);
        sparseIntArray.put(R.id.tv_total, 7);
        sparseIntArray.put(R.id.v_scene, 8);
        sparseIntArray.put(R.id.tv_scene, 9);
        sparseIntArray.put(R.id.tvDateTime, 10);
        sparseIntArray.put(R.id.tv_duration, 11);
        sparseIntArray.put(R.id.tv_pace, 12);
        sparseIntArray.put(R.id.tv_calories, 13);
        sparseIntArray.put(R.id.v_appeal_divider, 14);
        sparseIntArray.put(R.id.tvErrorInfo, 15);
        sparseIntArray.put(R.id.tvErrorBtn, 16);
        sparseIntArray.put(R.id.group_scene, 17);
        sparseIntArray.put(R.id.group_appeal, 18);
    }

    public RunItemIndexRecordBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 19, f11949a, f35621a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsMorningFlag;
        boolean runActivityFlag;
        synchronized (this) {
            j = this.f11950a;
            this.f11950a = 0L;
        }
        SportRecord sportRecord = ((RunItemIndexRecordBinding) this).f11941a;
        long j2 = j & 3;
        if (j2 == 0 || sportRecord == null) {
            zIsMorningFlag = false;
            runActivityFlag = false;
        } else {
            zIsMorningFlag = sportRecord.isMorningFlag();
            runActivityFlag = sportRecord.getRunActivityFlag();
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((RunItemIndexRecordBinding) this).f11942a, zIsMorningFlag);
            CommonBindingAdapter.l0(((RunItemIndexRecordBinding) this).f11947c, runActivityFlag);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11950a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11950a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemIndexRecordBinding
    public void k(@Nullable SportRecord Bean) {
        ((RunItemIndexRecordBinding) this).f11941a = Bean;
        synchronized (this) {
            this.f11950a |= 1;
        }
        notifyPropertyChanged(lk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.g != variableId) {
            return false;
        }
        k((SportRecord) variable);
        return true;
    }

    public RunItemIndexRecordBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Group) bindings[18], (Group) bindings[17], (BLTextView) bindings[1], (BLTextView) bindings[5], (BLTextView) bindings[2], (TextView) bindings[13], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[16], (TextView) bindings[15], (TextView) bindings[12], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[9], (TextView) bindings[7], (BLTextView) bindings[6], (BLView) bindings[14], (BLView) bindings[8]);
        this.f11950a = -1L;
        ((RunItemIndexRecordBinding) this).f11942a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f11951a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((RunItemIndexRecordBinding) this).f11947c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
