package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityWebviewGiftBindingImpl extends RunActivityWebviewGiftBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11672a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11671a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35517a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.webView, 2);
        sparseIntArray.put(com.huachenjie.run.R.id.webView_progressbar, 3);
    }

    public RunActivityWebviewGiftBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11671a, f35517a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11672a;
            this.f11672a = 0L;
        }
        GeoFenceV2VM geoFenceV2VM = ((RunActivityWebviewGiftBinding) this).f11670a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MediatorLiveData<BindingTitleBean> mediatorLiveData = geoFenceV2VM != null ? geoFenceV2VM.titleBean : null;
            updateLiveDataRegistration(0, mediatorLiveData);
            if (mediatorLiveData != null) {
                value = mediatorLiveData.getValue();
            }
        }
        if (j2 != 0) {
            ((RunActivityWebviewGiftBinding) this).f11668a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityWebviewGiftBinding) this).f11668a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11672a != 0) {
                return true;
            }
            return ((RunActivityWebviewGiftBinding) this).f11668a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11672a = 8L;
        }
        ((RunActivityWebviewGiftBinding) this).f11668a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityWebviewGiftBinding
    public void k(@Nullable GeoFenceV2VM Vm) {
        ((RunActivityWebviewGiftBinding) this).f11670a = Vm;
        synchronized (this) {
            this.f11672a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11672a |= 2;
        }
        return true;
    }

    public final boolean m(MediatorLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11672a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((MediatorLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivityWebviewGiftBinding) this).f11668a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((GeoFenceV2VM) variable);
        return true;
    }

    public RunActivityWebviewGiftBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RelativeLayout) bindings[0], (LayoutToolbarBindingBinding) bindings[1], (MyWebView) bindings[2], (ProgressBar) bindings[3]);
        this.f11672a = -1L;
        ((RunActivityWebviewGiftBinding) this).f11667a.setTag(null);
        setContainedBinding(((RunActivityWebviewGiftBinding) this).f11668a);
        setRootTag(root);
        invalidateAll();
    }
}
