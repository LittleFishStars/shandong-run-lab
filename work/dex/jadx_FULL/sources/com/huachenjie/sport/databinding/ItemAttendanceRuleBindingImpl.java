package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AttendancePeriodView;
import com.huachenjie.common.bean.SignPeriod;
import com.huachenjie.sport.R;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemAttendanceRuleBindingImpl extends ItemAttendanceRuleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13550a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13553a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36496a = sparseIntArray;
        sparseIntArray.put(R.id.period_view, 2);
    }

    public ItemAttendanceRuleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13550a, f36496a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13551a;
            this.f13551a = 0L;
        }
        SignPeriod signPeriod = ((ItemAttendanceRuleBinding) this).f13548a;
        long j2 = j & 9;
        String week = (j2 == 0 || signPeriod == null) ? null : signPeriod.getWeek();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f13552a, week);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13551a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13551a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendanceRuleBinding
    public void m(@Nullable Integer num) {
        ((ItemAttendanceRuleBinding) this).f13549a = num;
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendanceRuleBinding
    public void n(@Nullable Integer num) {
        this.b = num;
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendanceRuleBinding
    public void o(@Nullable SignPeriod signPeriod) {
        ((ItemAttendanceRuleBinding) this).f13548a = signPeriod;
        synchronized (this) {
            this.f13551a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            o((SignPeriod) obj);
        } else if (ok0.T == i) {
            n((Integer) obj);
        } else {
            if (ok0.P != i) {
                return false;
            }
            m((Integer) obj);
        }
        return true;
    }

    public ItemAttendanceRuleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AttendancePeriodView) objArr[2]);
        this.f13551a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f13553a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13552a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
