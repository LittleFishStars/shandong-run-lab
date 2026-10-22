package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.geofence.GeoFenceActivityVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityRunGeoGuideV3BindingImpl extends RunActivityRunGeoGuideV3Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11539a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11536a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35487a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.tab_layout, 2);
        sparseIntArray.put(com.huachenjie.run.R.id.view_pager, 3);
    }

    public RunActivityRunGeoGuideV3BindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11536a, f35487a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11537a;
            this.f11537a = 0L;
        }
        GeoFenceActivityVM geoFenceActivityVM = ((RunActivityRunGeoGuideV3Binding) this).f11535a;
        long j2 = j & 7;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MediatorLiveData<BindingTitleBean> mediatorLiveData = geoFenceActivityVM != null ? geoFenceActivityVM.titleBean : null;
            updateLiveDataRegistration(0, mediatorLiveData);
            if (mediatorLiveData != null) {
                value = mediatorLiveData.getValue();
            }
        }
        if (j2 != 0) {
            this.f11539a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f11539a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11537a != 0) {
                return true;
            }
            return this.f11539a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11537a = 4L;
        }
        this.f11539a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityRunGeoGuideV3Binding
    public void k(@Nullable GeoFenceActivityVM MState) {
        ((RunActivityRunGeoGuideV3Binding) this).f11535a = MState;
        synchronized (this) {
            this.f11537a |= 2;
        }
        notifyPropertyChanged(lk0.L);
        super.requestRebind();
    }

    public final boolean l(MediatorLiveData<BindingTitleBean> MStateTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11537a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MediatorLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11539a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L != variableId) {
            return false;
        }
        k((GeoFenceActivityVM) variable);
        return true;
    }

    public RunActivityRunGeoGuideV3BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (CommonTabLayout) bindings[2], (ViewPager) bindings[3]);
        this.f11537a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[1];
        this.f11539a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11538a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
