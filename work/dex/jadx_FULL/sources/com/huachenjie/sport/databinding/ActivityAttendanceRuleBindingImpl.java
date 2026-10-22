package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleActivity;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleAdapter;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleVM;
import com.zj.adlib.ok0;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendanceRuleBindingImpl extends ActivityAttendanceRuleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13150a;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceRuleActivity.a f36372a;

        public a a(AttendanceRuleActivity.a aVar) {
            this.f36372a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36372a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        f13145a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36371a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_rule_detail, 9);
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_rule_detail, 10);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_rule_detail, 11);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_cycle, 12);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_location, 13);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_location_range, 14);
        sparseIntArray.put(com.huachenjie.sport.R.id.line_rule_detail, 15);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_times, 16);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_week_times, 17);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_duration, 18);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_attendance_period, 19);
    }

    public ActivityAttendanceRuleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, f13145a, f36371a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        AttendanceRuleAdapter value;
        String str4;
        String str5;
        BindingTitleBean value2;
        a aVarA;
        long j2;
        long startDate;
        int weekTimes;
        int attendanceTimes;
        int exerciseTime;
        String locationName;
        synchronized (this) {
            j = this.f13146a;
            this.f13146a = 0L;
        }
        AttendanceRuleVM attendanceRuleVM = ((ActivityAttendanceRuleBinding) this).f13144a;
        AttendanceRuleActivity.a aVar = ((ActivityAttendanceRuleBinding) this).f13143a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<AttendanceRuleAdapter> mutableLiveDataI = attendanceRuleVM != null ? attendanceRuleVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataK = attendanceRuleVM != null ? attendanceRuleVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) != 0) {
                MutableLiveData<OutsideAttendanceRule> mutableLiveDataH = attendanceRuleVM != null ? attendanceRuleVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                OutsideAttendanceRule value3 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                if (value3 != null) {
                    long endDate = value3.getEndDate();
                    locationName = value3.getLocationName();
                    weekTimes = value3.getWeekTimes();
                    attendanceTimes = value3.getAttendanceTimes();
                    exerciseTime = value3.getExerciseTime();
                    j2 = endDate;
                    startDate = value3.getStartDate();
                } else {
                    j2 = 0;
                    startDate = 0;
                    weekTimes = 0;
                    attendanceTimes = 0;
                    exerciseTime = 0;
                    locationName = null;
                }
                String strC = s72.c(j2, "yyyy.MM.dd");
                str4 = String.format("%d次", Integer.valueOf(weekTimes));
                str2 = String.format("%d次", Integer.valueOf(attendanceTimes));
                String strC2 = s72.c(startDate, "yyyy.MM.dd");
                str5 = String.format("%dmin", Integer.valueOf(exerciseTime / 60));
                str = String.format("%s-%s", strC2, strC);
                str3 = locationName;
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            value = null;
            str4 = null;
            str5 = null;
            value2 = null;
        }
        long j3 = 48 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13150a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13150a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((42 & j) != 0) {
            this.f13149a.k(value2);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(this.j, str);
            TextViewBindingAdapter.setText(this.l, str2);
            TextViewBindingAdapter.setText(this.m, str4);
            TextViewBindingAdapter.setText(this.n, str5);
            TextViewBindingAdapter.setText(this.d, str3);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.k, aVarA, null);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.g(this.f13148a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13149a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13146a != 0) {
                return true;
            }
            return this.f13149a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13146a = 32L;
        }
        this.f13149a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceRuleBinding
    public void l(@Nullable AttendanceRuleActivity.a aVar) {
        ((ActivityAttendanceRuleBinding) this).f13143a = aVar;
        synchronized (this) {
            this.f13146a |= 16;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceRuleBinding
    public void m(@Nullable AttendanceRuleVM attendanceRuleVM) {
        ((ActivityAttendanceRuleBinding) this).f13144a = attendanceRuleVM;
        synchronized (this) {
            this.f13146a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<OutsideAttendanceRule> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13146a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<AttendanceRuleAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13146a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13146a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13149a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendanceRuleVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendanceRuleActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendanceRuleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[10], (RoundImageView) objArr[11], (View) objArr[15], (TextView) objArr[12], (TextView) objArr[18], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[14], (TextView) objArr[19], (TextView) objArr[16], (TextView) objArr[9], (TextView) objArr[17]);
        this.f13146a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[8];
        this.f13149a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13147a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.j = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.k = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.l = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.m = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.n = textView5;
        textView5.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[7];
        this.f13148a = recyclerView;
        recyclerView.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
