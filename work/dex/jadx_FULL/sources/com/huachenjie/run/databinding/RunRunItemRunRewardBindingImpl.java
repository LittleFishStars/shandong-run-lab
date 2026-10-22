package com.huachenjie.run.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunRewardBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunRunItemRunRewardBindingImpl extends RunRunItemRunRewardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12306a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12308a;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35746a = sparseIntArray;
        sparseIntArray.put(R.id.tv_distance_label, 9);
        sparseIntArray.put(R.id.tv_times_label, 10);
        sparseIntArray.put(R.id.tv_time_label, 11);
    }

    public RunRunItemRunRewardBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 12, f12306a, f35746a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        String activityTimesDisplay;
        String activityName;
        String activityDistanceDisplay;
        String str;
        String activityTimesStr;
        String indexStr;
        boolean z;
        String expandBtnText;
        Boolean showLookMore;
        synchronized (this) {
            j = this.f12307a;
            this.f12307a = 0L;
        }
        RunRewardBean runRewardBean = ((RunRunItemRunRewardBinding) this).f12304a;
        long j2 = j & 3;
        String remarks = null;
        if (j2 != 0) {
            if (runRewardBean != null) {
                remarks = runRewardBean.getRemarks();
                activityTimesDisplay = runRewardBean.getActivityTimesDisplay();
                activityName = runRewardBean.getActivityName();
                expandBtnText = runRewardBean.getExpandBtnText();
                activityTimesStr = runRewardBean.getActivityTimesStr();
                showLookMore = runRewardBean.getShowLookMore();
                indexStr = runRewardBean.getIndexStr();
                activityDistanceDisplay = runRewardBean.getActivityDistanceDisplay();
            } else {
                activityTimesDisplay = null;
                activityName = null;
                activityDistanceDisplay = null;
                expandBtnText = null;
                activityTimesStr = null;
                showLookMore = null;
                indexStr = null;
            }
            boolean zIsEmpty = TextUtils.isEmpty(remarks);
            zSafeUnbox = ViewDataBinding.safeUnbox(showLookMore);
            z = !zIsEmpty;
            String str2 = expandBtnText;
            str = remarks;
            remarks = str2;
        } else {
            zSafeUnbox = false;
            activityTimesDisplay = null;
            activityName = null;
            activityDistanceDisplay = null;
            str = null;
            activityTimesStr = null;
            indexStr = null;
            z = false;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((RunRunItemRunRewardBinding) this).f35745a, remarks);
            CommonBindingAdapter.l0(((RunRunItemRunRewardBinding) this).f35745a, zSafeUnbox);
            TextViewBindingAdapter.setText(this.h, activityDistanceDisplay);
            TextViewBindingAdapter.setText(this.i, activityTimesDisplay);
            TextViewBindingAdapter.setText(this.j, activityTimesStr);
            TextViewBindingAdapter.setText(((RunRunItemRunRewardBinding) this).f12305a, indexStr);
            TextViewBindingAdapter.setText(this.c, activityName);
            TextViewBindingAdapter.setText(this.d, str);
            CommonBindingAdapter.l0(this.d, z);
            CommonBindingAdapter.l0(this.e, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12307a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12307a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunItemRunRewardBinding
    public void k(@Nullable RunRewardBean Bean) {
        ((RunRunItemRunRewardBinding) this).f12304a = Bean;
        synchronized (this) {
            this.f12307a |= 1;
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
        k((RunRewardBean) variable);
        return true;
    }

    public RunRunItemRunRewardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[8], (TextView) bindings[9], (BLTextView) bindings[1], (TextView) bindings[2], (TextView) bindings[7], (TextView) bindings[6], (TextView) bindings[11], (TextView) bindings[10]);
        this.f12307a = -1L;
        ((RunRunItemRunRewardBinding) this).f35745a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f12308a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.h = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.i = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.j = textView3;
        textView3.setTag(null);
        ((RunRunItemRunRewardBinding) this).f12305a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
