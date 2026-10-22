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
import com.huachenjie.run.bean.AiRecordDetailBean;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemAiDeductionDetailBindingImpl extends RunItemAiDeductionDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11921a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11923a;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35610a = sparseIntArray;
        sparseIntArray.put(R.id.tv_deduction_km_title, 5);
        sparseIntArray.put(R.id.tv_deduction_times_title, 6);
    }

    public RunItemAiDeductionDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f11921a, f35610a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String distance;
        String endTime;
        String configName;
        String times;
        synchronized (this) {
            j = this.f11922a;
            this.f11922a = 0L;
        }
        AiRecordDetailBean aiRecordDetailBean = ((RunItemAiDeductionDetailBinding) this).f11920a;
        long j2 = j & 3;
        if (j2 == 0 || aiRecordDetailBean == null) {
            distance = null;
            endTime = null;
            configName = null;
            times = null;
        } else {
            distance = aiRecordDetailBean.formatDistance();
            endTime = aiRecordDetailBean.getEndTime();
            configName = aiRecordDetailBean.getConfigName();
            times = aiRecordDetailBean.formatTimes();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.e, distance);
            TextViewBindingAdapter.setText(this.f, times);
            TextViewBindingAdapter.setText(this.c, configName);
            TextViewBindingAdapter.setText(this.d, endTime);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11922a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11922a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemAiDeductionDetailBinding
    public void k(@Nullable AiRecordDetailBean Bean) {
        ((RunItemAiDeductionDetailBinding) this).f11920a = Bean;
        synchronized (this) {
            this.f11922a |= 1;
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
        k((AiRecordDetailBean) variable);
        return true;
    }

    public RunItemAiDeductionDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[1], (TextView) bindings[2]);
        this.f11922a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11923a = constraintLayout;
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
