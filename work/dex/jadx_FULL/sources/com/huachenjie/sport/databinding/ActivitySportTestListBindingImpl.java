package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySportTestListBindingImpl extends ActivitySportTestListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13365a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13362a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36435a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.tab, 2);
        sparseIntArray.put(com.huachenjie.sport.R.id.vp, 3);
    }

    public ActivitySportTestListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13362a, f36435a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13363a;
            this.f13363a = 0L;
        }
        SportTestListVM sportTestListVM = ((ActivitySportTestListBinding) this).f13361a;
        long j2 = j & 7;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataK = sportTestListVM != null ? sportTestListVM.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value = mutableLiveDataK.getValue();
            }
        }
        if (j2 != 0) {
            this.f13365a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f13365a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13363a != 0) {
                return true;
            }
            return this.f13365a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13363a = 4L;
        }
        this.f13365a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestListBinding
    public void k(@Nullable SportTestListVM sportTestListVM) {
        ((ActivitySportTestListBinding) this).f13361a = sportTestListVM;
        synchronized (this) {
            this.f13363a |= 2;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13363a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13365a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((SportTestListVM) obj);
        return true;
    }

    public ActivitySportTestListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (SlidingTabLayout2) objArr[2], (ViewPager2) objArr[3]);
        this.f13363a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[1];
        this.f13365a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13364a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
