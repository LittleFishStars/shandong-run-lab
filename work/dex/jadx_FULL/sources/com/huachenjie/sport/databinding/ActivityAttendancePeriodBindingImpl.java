package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodActivity;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodAdapter;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendancePeriodBindingImpl extends ActivityAttendancePeriodBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13112a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13107a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36358a = null;
    }

    public ActivityAttendancePeriodBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13107a, f36358a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String currentDate;
        AttendancePeriodAdapter value;
        BindingTitleBean value2;
        synchronized (this) {
            j = this.f13108a;
            this.f13108a = 0L;
        }
        AttendancePeriodVM attendancePeriodVM = ((ActivityAttendancePeriodBinding) this).f13106a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<AttendancePeriodAdapter> mutableLiveDataI = attendancePeriodVM != null ? attendancePeriodVM.i() : null;
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
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = attendancePeriodVM != null ? attendancePeriodVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                currentDate = null;
            } else {
                MutableLiveData<ClockTimeData> mutableLiveDataH = attendancePeriodVM != null ? attendancePeriodVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                ClockTimeData value3 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                if (value3 != null) {
                    currentDate = value3.getCurrentDate();
                } else {
                    currentDate = null;
                }
            }
        } else {
            currentDate = null;
            value = null;
            value2 = null;
        }
        if ((42 & j) != 0) {
            this.f13112a.k(value2);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(this.f13110a, currentDate);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.g(this.f13111a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13112a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13108a != 0) {
                return true;
            }
            return this.f13112a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13108a = 32L;
        }
        this.f13112a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePeriodBinding
    public void l(@Nullable AttendancePeriodActivity.a aVar) {
        ((ActivityAttendancePeriodBinding) this).f36357a = aVar;
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePeriodBinding
    public void m(@Nullable AttendancePeriodVM attendancePeriodVM) {
        ((ActivityAttendancePeriodBinding) this).f13106a = attendancePeriodVM;
        synchronized (this) {
            this.f13108a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ClockTimeData> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13108a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<AttendancePeriodAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13108a |= 1;
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
            this.f13108a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13112a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendancePeriodVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendancePeriodActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendancePeriodBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3);
        this.f13108a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f13112a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13109a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13110a = textView;
        textView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f13111a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
