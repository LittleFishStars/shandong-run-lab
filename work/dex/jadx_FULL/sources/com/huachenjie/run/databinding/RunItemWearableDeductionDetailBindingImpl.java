package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.WearableDeductionRecordBean;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemWearableDeductionDetailBindingImpl extends RunItemWearableDeductionDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11997a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11999a;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35642a = sparseIntArray;
        sparseIntArray.put(R.id.tv_deduction_km_title, 5);
        sparseIntArray.put(R.id.tv_deduction_times_title, 6);
    }

    public RunItemWearableDeductionDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f11997a, f35642a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String sportTypeName;
        String distance;
        String deductionTime;
        String times;
        synchronized (this) {
            j = this.f11998a;
            this.f11998a = 0L;
        }
        WearableDeductionRecordBean wearableDeductionRecordBean = ((RunItemWearableDeductionDetailBinding) this).f11996a;
        long j2 = j & 3;
        if (j2 == 0 || wearableDeductionRecordBean == null) {
            sportTypeName = null;
            distance = null;
            deductionTime = null;
            times = null;
        } else {
            sportTypeName = wearableDeductionRecordBean.getSportTypeName();
            distance = wearableDeductionRecordBean.formatDistance();
            deductionTime = wearableDeductionRecordBean.formatDeductionTime();
            times = wearableDeductionRecordBean.formatTimes();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.e, distance);
            TextViewBindingAdapter.setText(this.f, times);
            TextViewBindingAdapter.setText(this.c, sportTypeName);
            TextViewBindingAdapter.setText(this.d, deductionTime);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11998a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11998a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemWearableDeductionDetailBinding
    public void k(@Nullable WearableDeductionRecordBean Bean) {
        ((RunItemWearableDeductionDetailBinding) this).f11996a = Bean;
        synchronized (this) {
            this.f11998a |= 1;
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
        k((WearableDeductionRecordBean) variable);
        return true;
    }

    public RunItemWearableDeductionDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[1], (TextView) bindings[2]);
        this.f11998a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11999a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.f = textView2;
        textView2.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
