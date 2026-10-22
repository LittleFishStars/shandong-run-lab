package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.FlowAdapter;
import com.huachenjie.run.R;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunHeadActivityRuleBindingImpl extends RunHeadActivityRuleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11872a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f11875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11876a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35595a = sparseIntArray;
        sparseIntArray.put(R.id.time_flow, 5);
    }

    public RunHeadActivityRuleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f11872a, f35595a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        List<String> dateList;
        String runPlanName;
        String date;
        String activityName;
        synchronized (this) {
            j = this.f11873a;
            this.f11873a = 0L;
        }
        ActivityRunDetailBean activityRunDetailBean = ((RunHeadActivityRuleBinding) this).f11870a;
        FlowAdapter flowAdapter = ((RunHeadActivityRuleBinding) this).f11871a;
        long j2 = 7 & j;
        String str = null;
        if (j2 != 0) {
            if ((j & 5) == 0 || activityRunDetailBean == null) {
                runPlanName = null;
                date = null;
                activityName = null;
            } else {
                runPlanName = activityRunDetailBean.getRunPlanName();
                date = activityRunDetailBean.getDate();
                activityName = activityRunDetailBean.getActivityName();
            }
            dateList = activityRunDetailBean != null ? activityRunDetailBean.getDateList() : null;
            str = activityName;
        } else {
            dateList = null;
            runPlanName = null;
            date = null;
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.f11874a, str);
            TextViewBindingAdapter.setText(this.b, runPlanName);
            TextViewBindingAdapter.setText(this.c, date);
        }
        if (j2 != 0) {
            CommonBindingAdapter.h0(this.f11876a, R.id.time_flow, dateList, flowAdapter);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11873a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11873a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunHeadActivityRuleBinding
    public void l(@Nullable FlowAdapter FlowAdapter) {
        ((RunHeadActivityRuleBinding) this).f11871a = FlowAdapter;
        synchronized (this) {
            this.f11873a |= 2;
        }
        notifyPropertyChanged(lk0.r);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunHeadActivityRuleBinding
    public void m(@Nullable ActivityRunDetailBean MState) {
        ((RunHeadActivityRuleBinding) this).f11870a = MState;
        synchronized (this) {
            this.f11873a |= 1;
        }
        notifyPropertyChanged(lk0.L);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L == variableId) {
            m((ActivityRunDetailBean) variable);
        } else {
            if (lk0.r != variableId) {
                return false;
            }
            l((FlowAdapter) variable);
        }
        return true;
    }

    public RunHeadActivityRuleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Flow) bindings[5]);
        this.f11873a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.f11875a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11874a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.c = textView3;
        textView3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[4];
        this.f11876a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
