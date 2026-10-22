package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.amap.api.maps.MapView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeActivity;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendanceRangeBindingImpl extends ActivityAttendanceRangeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13139a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceRangeActivity.a f36368a;

        public a a(AttendanceRangeActivity.a aVar) {
            this.f36368a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36368a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceRangeActivity.a f36369a;

        public b a(AttendanceRangeActivity.a aVar) {
            this.f36369a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36369a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13133a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36367a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.mapView, 4);
    }

    public ActivityAttendanceRangeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13133a, f36367a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f13134a;
            this.f13134a = 0L;
        }
        AttendanceRangeVM attendanceRangeVM = ((ActivityAttendanceRangeBinding) this).f13132a;
        AttendanceRangeActivity.a aVar = ((ActivityAttendanceRangeBinding) this).f13131a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveData = attendanceRangeVM != null ? attendanceRangeVM.i : null;
            updateLiveDataRegistration(0, mutableLiveData);
            if (mutableLiveData != null) {
                value = mutableLiveData.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f13139a;
            if (bVar == null) {
                bVar = new b();
                this.f13139a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f13138a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13138a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            this.f13137a.k(value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f13135a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f13137a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13134a != 0) {
                return true;
            }
            return this.f13137a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13134a = 8L;
        }
        this.f13137a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceRangeBinding
    public void l(@Nullable AttendanceRangeActivity.a aVar) {
        ((ActivityAttendanceRangeBinding) this).f13131a = aVar;
        synchronized (this) {
            this.f13134a |= 4;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceRangeBinding
    public void m(@Nullable AttendanceRangeVM attendanceRangeVM) {
        ((ActivityAttendanceRangeBinding) this).f13132a = attendanceRangeVM;
        synchronized (this) {
            this.f13134a |= 2;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13134a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13137a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendanceRangeVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendanceRangeActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendanceRangeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (MapView) objArr[4]);
        this.f13134a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f13137a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13136a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13135a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.b = imageView2;
        imageView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
