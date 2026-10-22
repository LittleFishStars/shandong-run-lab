package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.ActivityRunBean;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemActivityRunListBindingImpl extends RunItemActivityRunListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11917a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11919a;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35608a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 6);
        sparseIntArray.put(R.id.iv_arrow, 7);
        sparseIntArray.put(R.id.tv_run_plan_name_title, 8);
        sparseIntArray.put(R.id.tv_reward_info_title, 9);
        sparseIntArray.put(R.id.tv_date_time_title, 10);
    }

    public RunItemActivityRunListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 11, f11917a, f35608a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int textColor;
        String activityStatusStr;
        String rewardInfo;
        String dateTime;
        String activityName;
        String runPlanName;
        int backgroundResource;
        synchronized (this) {
            j = this.f11918a;
            this.f11918a = 0L;
        }
        ActivityRunBean activityRunBean = ((RunItemActivityRunListBinding) this).f11915a;
        long j2 = j & 3;
        if (j2 == 0 || activityRunBean == null) {
            textColor = 0;
            activityStatusStr = null;
            rewardInfo = null;
            dateTime = null;
            activityName = null;
            runPlanName = null;
            backgroundResource = 0;
        } else {
            activityStatusStr = activityRunBean.getActivityStatusStr();
            textColor = activityRunBean.getTextColor();
            backgroundResource = activityRunBean.getBackgroundResource();
            dateTime = activityRunBean.getDateTime();
            activityName = activityRunBean.getActivityName();
            runPlanName = activityRunBean.getRunPlanName();
            rewardInfo = activityRunBean.getRewardInfo();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f, runPlanName);
            TextViewBindingAdapter.setText(this.g, rewardInfo);
            TextViewBindingAdapter.setText(this.h, dateTime);
            TextViewBindingAdapter.setText(((RunItemActivityRunListBinding) this).f11914a, activityName);
            CommonBindingAdapter.x(this.e, backgroundResource);
            TextViewBindingAdapter.setText(this.e, activityStatusStr);
            this.e.setTextColor(textColor);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11918a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11918a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemActivityRunListBinding
    public void k(@Nullable ActivityRunBean Item) {
        ((RunItemActivityRunListBinding) this).f11915a = Item;
        synchronized (this) {
            this.f11918a |= 1;
        }
        notifyPropertyChanged(lk0.H);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.H != variableId) {
            return false;
        }
        k((ActivityRunBean) variable);
        return true;
    }

    public RunItemActivityRunListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[7], (TextView) bindings[1], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[2], (BLView) bindings[6]);
        this.f11918a = -1L;
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) bindings[0];
        this.f11919a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.g = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.h = textView3;
        textView3.setTag(null);
        ((RunItemActivityRunListBinding) this).f11914a.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
