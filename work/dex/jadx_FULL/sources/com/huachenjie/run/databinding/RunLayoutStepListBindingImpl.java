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
import com.github.mikephil.charting.charts.LineChart;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutStepListBindingImpl extends RunLayoutStepListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12201a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12203a;

    @NonNull
    public final TextView g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35712a = sparseIntArray;
        sparseIntArray.put(R.id.tv_step_title, 3);
        sparseIntArray.put(R.id.tv_step_suggest, 4);
        sparseIntArray.put(R.id.tv_total_steps_title, 5);
        sparseIntArray.put(R.id.tv_average_steps_title, 6);
        sparseIntArray.put(R.id.tv_chart_unit, 7);
        sparseIntArray.put(R.id.chart_step, 8);
    }

    public RunLayoutStepListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f12201a, f35712a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        boolean z;
        boolean zIsEmpty;
        List<Float> stepList;
        int frequency;
        int totalStep;
        synchronized (this) {
            j = this.f12202a;
            this.f12202a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutStepListBinding) this).f12200a;
        long j2 = j & 7;
        List<Float> list = null;
        boolean z2 = false;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if (value != null) {
                totalStep = value.getTotalStep();
                stepList = value.getStepList();
                frequency = value.getFrequency();
            } else {
                stepList = null;
                frequency = 0;
                totalStep = 0;
            }
            String strValueOf = String.valueOf(totalStep);
            z = stepList != null;
            String strValueOf2 = String.valueOf(frequency);
            if (j2 != 0) {
                j = z ? j | 16 : j | 8;
            }
            str2 = strValueOf2;
            str = strValueOf;
            list = stepList;
        } else {
            str = null;
            str2 = null;
            z = false;
        }
        if ((16 & j) != 0) {
            zIsEmpty = true ^ (list != null ? list.isEmpty() : false);
        } else {
            zIsEmpty = false;
        }
        long j3 = j & 7;
        if (j3 != 0 && z) {
            z2 = zIsEmpty;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f12203a, z2);
            TextViewBindingAdapter.setText(this.g, str2);
            TextViewBindingAdapter.setText(this.e, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12202a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12202a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutStepListBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutStepListBinding) this).f12200a = Vm;
        synchronized (this) {
            this.f12202a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12202a |= 1;
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

    public RunLayoutStepListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LineChart) bindings[8], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[1], (TextView) bindings[5]);
        this.f12202a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f12203a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.g = textView;
        textView.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
