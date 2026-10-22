package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.attendance.plan.AttendancePlanActivity;
import com.huachenjie.sport.page.mine.attendance.plan.AttendancePlanAdapter;
import com.huachenjie.sport.page.mine.attendance.plan.AttendancePlanVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendancePlanBindingImpl extends ActivityAttendancePlanBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13130a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f13126a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f36365a = null;
    }

    public ActivityAttendancePlanBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13126a, f36365a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        AttendancePlanAdapter value;
        synchronized (this) {
            j = this.f13127a;
            this.f13127a = 0L;
        }
        AttendancePlanVM attendancePlanVM = ((ActivityAttendancePlanBinding) this).f13125a;
        BindingTitleBean value2 = null;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<AttendancePlanAdapter> mutableLiveDataI = attendancePlanVM != null ? attendancePlanVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<BindingTitleBean> mutableLiveDataK = attendancePlanVM != null ? attendancePlanVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((22 & j) != 0) {
            this.f13130a.k(value2);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.g(this.f13129a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13130a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13127a != 0) {
                return true;
            }
            return this.f13130a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13127a = 16L;
        }
        this.f13130a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePlanBinding
    public void l(@Nullable AttendancePlanActivity.a aVar) {
        ((ActivityAttendancePlanBinding) this).f36364a = aVar;
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePlanBinding
    public void m(@Nullable AttendancePlanVM attendancePlanVM) {
        ((ActivityAttendancePlanBinding) this).f13125a = attendancePlanVM;
        synchronized (this) {
            this.f13127a |= 4;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<AttendancePlanAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13127a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13127a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13130a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendancePlanVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendancePlanActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendancePlanBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f13127a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[2];
        this.f13130a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13128a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f13129a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
