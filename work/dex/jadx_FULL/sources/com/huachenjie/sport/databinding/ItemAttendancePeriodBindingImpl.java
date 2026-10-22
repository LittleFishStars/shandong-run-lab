package com.huachenjie.sport.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.huachenjie.common.bean.ClockTime;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemAttendancePeriodBindingImpl extends ItemAttendancePeriodBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13535a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13537a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36492a = sparseIntArray;
        sparseIntArray.put(R.id.dot_attendance_start_period, 5);
        sparseIntArray.put(R.id.dot_attendance_end_period, 6);
    }

    public ItemAttendancePeriodBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13535a, f36492a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        long j2;
        String str;
        String str2;
        String str3;
        int i;
        boolean zShowEndTagStr;
        boolean z;
        int i2;
        boolean z2;
        String startTime;
        String str4;
        String strEndTagStr;
        boolean z3;
        boolean zShowStartTagStr;
        Context context;
        int i3;
        synchronized (this) {
            j = this.f13536a;
            this.f13536a = 0L;
        }
        Integer num = ((ItemAttendancePeriodBinding) this).f13531a;
        ClockTime clockTime = ((ItemAttendancePeriodBinding) this).f13528a;
        Integer num2 = ((ItemAttendancePeriodBinding) this).f13534b;
        long j3 = j & 13;
        String str5 = null;
        boolean z4 = false;
        if (j3 != 0) {
            boolean z5 = num == num2;
            if (j3 != 0) {
                j |= z5 ? 128L : 64L;
            }
            if (z5) {
                context = this.f13537a.getContext();
                i3 = R.drawable.bg_attendance_plan_selected;
            } else {
                context = this.f13537a.getContext();
                i3 = R.drawable.bg_attendance_plan_unselected;
            }
            drawable = AppCompatResources.getDrawable(context, i3);
        } else {
            drawable = null;
        }
        long j4 = j & 10;
        if (j4 != 0) {
            if (clockTime != null) {
                String strStartTagStr = clockTime.startTagStr();
                zShowEndTagStr = clockTime.showEndTagStr();
                boolean zShowStartTagStr2 = clockTime.showStartTagStr();
                strEndTagStr = clockTime.endTagStr();
                String endTime = clockTime.getEndTime();
                zShowStartTagStr = clockTime.showStartTagStr();
                startTime = clockTime.getStartTime();
                str4 = strStartTagStr;
                str5 = endTime;
                z3 = zShowStartTagStr2;
            } else {
                startTime = null;
                str4 = null;
                strEndTagStr = null;
                zShowEndTagStr = false;
                z3 = false;
                zShowStartTagStr = false;
            }
            boolean z6 = !zShowEndTagStr;
            str5 = String.format("签退时段：%s", str5);
            boolean z7 = !zShowStartTagStr;
            String str6 = String.format("签到时段：%s", startTime);
            if (j4 != 0) {
                j |= z6 ? 32L : 16L;
            }
            if ((j & 10) != 0) {
                j |= z7 ? 512L : 256L;
            }
            int i4 = z6 ? -13877680 : -4079167;
            i2 = z7 ? -13877680 : -4079167;
            z = z7;
            i = i4;
            str3 = str4;
            z2 = z3;
            z4 = z6;
            str2 = str6;
            str = strEndTagStr;
            j2 = 13;
        } else {
            j2 = 13;
            str = null;
            str2 = null;
            str3 = null;
            i = 0;
            zShowEndTagStr = false;
            z = false;
            i2 = 0;
            z2 = false;
        }
        if ((j & j2) != 0) {
            ViewBindingAdapter.setBackground(this.f13537a, drawable);
        }
        if ((j & 10) != 0) {
            CommonBindingAdapter.z(((ItemAttendancePeriodBinding) this).f36491a, z4);
            TextViewBindingAdapter.setText(((ItemAttendancePeriodBinding) this).f36491a, str5);
            ((ItemAttendancePeriodBinding) this).f36491a.setTextColor(i);
            CommonBindingAdapter.l0(((ItemAttendancePeriodBinding) this).f13529a, zShowEndTagStr);
            TextViewBindingAdapter.setText(((ItemAttendancePeriodBinding) this).f13529a, str);
            CommonBindingAdapter.z(((ItemAttendancePeriodBinding) this).b, z);
            TextViewBindingAdapter.setText(((ItemAttendancePeriodBinding) this).b, str2);
            ((ItemAttendancePeriodBinding) this).b.setTextColor(i2);
            CommonBindingAdapter.l0(((ItemAttendancePeriodBinding) this).f13532b, z2);
            TextViewBindingAdapter.setText(((ItemAttendancePeriodBinding) this).f13532b, str3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13536a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13536a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePeriodBinding
    public void m(@Nullable Integer num) {
        ((ItemAttendancePeriodBinding) this).f13531a = num;
        synchronized (this) {
            this.f13536a |= 1;
        }
        notifyPropertyChanged(ok0.P);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePeriodBinding
    public void n(@Nullable Integer num) {
        ((ItemAttendancePeriodBinding) this).f13534b = num;
        synchronized (this) {
            this.f13536a |= 4;
        }
        notifyPropertyChanged(ok0.T);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemAttendancePeriodBinding
    public void o(@Nullable ClockTime clockTime) {
        ((ItemAttendancePeriodBinding) this).f13528a = clockTime;
        synchronized (this) {
            this.f13536a |= 2;
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
            o((ClockTime) obj);
        } else {
            if (ok0.T != i) {
                return false;
            }
            n((Integer) obj);
        }
        return true;
    }

    public ItemAttendancePeriodBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLView) objArr[6], (BLView) objArr[5], (TextView) objArr[3], (BLTextView) objArr[4], (TextView) objArr[1], (BLTextView) objArr[2]);
        this.f13536a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13537a = constraintLayout;
        constraintLayout.setTag(null);
        ((ItemAttendancePeriodBinding) this).f36491a.setTag(null);
        ((ItemAttendancePeriodBinding) this).f13529a.setTag(null);
        ((ItemAttendancePeriodBinding) this).b.setTag(null);
        ((ItemAttendancePeriodBinding) this).f13532b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
