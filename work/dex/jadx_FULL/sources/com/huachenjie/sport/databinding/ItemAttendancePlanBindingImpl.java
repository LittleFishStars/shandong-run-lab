package com.huachenjie.sport.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendancePlanBean;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemAttendancePlanBindingImpl extends ItemAttendancePlanBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13545a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13547a;

    @NonNull
    public final TextView m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36494a = sparseIntArray;
        sparseIntArray.put(R.id.line_top, 9);
        sparseIntArray.put(R.id.tv_attendance_cycle, 10);
        sparseIntArray.put(R.id.tv_attendance_period, 11);
        sparseIntArray.put(R.id.line_bottom, 12);
        sparseIntArray.put(R.id.iv_attendance_times, 13);
        sparseIntArray.put(R.id.tv_attendance_times, 14);
        sparseIntArray.put(R.id.tv_week_times, 15);
        sparseIntArray.put(R.id.iv_attendance_duration, 16);
        sparseIntArray.put(R.id.tv_attendance_duration, 17);
    }

    public ItemAttendancePlanBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f13545a, f36494a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int statusBackground;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String weekTimesStr;
        Context context;
        int i2;
        synchronized (this) {
            j = this.f13546a;
            this.f13546a = 0L;
        }
        Integer num = ((ItemAttendancePlanBinding) this).f13541a;
        AttendancePlanBean attendancePlanBean = ((ItemAttendancePlanBinding) this).f13540a;
        Integer num2 = ((ItemAttendancePlanBinding) this).f13544b;
        long j2 = j & 13;
        boolean z = false;
        String str7 = null;
        if (j2 != 0) {
            boolean z2 = num == num2;
            if (j2 != 0) {
                j |= z2 ? 32L : 16L;
            }
            if (z2) {
                context = this.f13547a.getContext();
                i2 = R.drawable.bg_attendance_plan_selected;
            } else {
                context = this.f13547a.getContext();
                i2 = R.drawable.bg_attendance_plan_unselected;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
        } else {
            drawable = null;
        }
        long j3 = 10 & j;
        if (j3 == 0 || attendancePlanBean == null) {
            statusBackground = 0;
            i = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            weekTimesStr = null;
        } else {
            int statusColor = attendancePlanBean.getStatusColor();
            boolean zShowSecondSignPeriod = attendancePlanBean.showSecondSignPeriod();
            String exerciseTimeStr = attendancePlanBean.getExerciseTimeStr();
            String statusStr = attendancePlanBean.getStatusStr();
            statusBackground = attendancePlanBean.getStatusBackground();
            String attendanceTimesStr = attendancePlanBean.getAttendanceTimesStr();
            String dateStr = attendancePlanBean.getDateStr();
            String name = attendancePlanBean.getName();
            String firstSignPeriod = attendancePlanBean.getFirstSignPeriod();
            String secondSignPeriod = attendancePlanBean.getSecondSignPeriod();
            weekTimesStr = attendancePlanBean.getWeekTimesStr();
            str5 = statusStr;
            str6 = attendanceTimesStr;
            str = name;
            str3 = firstSignPeriod;
            str4 = secondSignPeriod;
            z = zShowSecondSignPeriod;
            str2 = exerciseTimeStr;
            str7 = dateStr;
            i = statusColor;
        }
        if ((j & 13) != 0) {
            ViewBindingAdapter.setBackground(this.f13547a, drawable);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.m, str7);
            TextViewBindingAdapter.setText(this.c, str2);
            TextViewBindingAdapter.setText(this.e, str3);
            CommonBindingAdapter.l0(this.f, z);
            TextViewBindingAdapter.setText(this.f, str4);
            TextViewBindingAdapter.setText(this.g, str);
            CommonBindingAdapter.x(this.h, statusBackground);
            TextViewBindingAdapter.setText(this.h, str5);
            this.h.setTextColor(i);
            TextViewBindingAdapter.setText(this.j, str6);
            TextViewBindingAdapter.setText(this.l, weekTimesStr);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13546a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13546a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePlanBinding
    public void m(@Nullable Integer num) {
        ((ItemAttendancePlanBinding) this).f13541a = num;
        synchronized (this) {
            this.f13546a |= 1;
        }
        notifyPropertyChanged(ok0.P);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePlanBinding
    public void n(@Nullable Integer num) {
        ((ItemAttendancePlanBinding) this).f13544b = num;
        synchronized (this) {
            this.f13546a |= 4;
        }
        notifyPropertyChanged(ok0.T);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePlanBinding
    public void o(@Nullable AttendancePlanBean attendancePlanBean) {
        ((ItemAttendancePlanBinding) this).f13540a = attendancePlanBean;
        synchronized (this) {
            this.f13546a |= 2;
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
        if (ok0.P == i) {
            m((Integer) obj);
        } else if (ok0.p0 == i) {
            o((AttendancePlanBean) obj);
        } else {
            if (ok0.T != i) {
                return false;
            }
            n((Integer) obj);
        }
        return true;
    }

    public ItemAttendancePlanBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[16], (ImageView) objArr[13], (View) objArr[12], (View) objArr[9], (TextView) objArr[10], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[14], (TextView) objArr[6], (TextView) objArr[15], (TextView) objArr[7]);
        this.f13546a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13547a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.m = textView;
        textView.setTag(null);
        this.c.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
