package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.sun_run.success.CameraRunSuccessActivity;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityCameraRunSuccessBindingImpl extends RunActivityCameraRunSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f11441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11442a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CameraRunSuccessActivity.a f35453a;

        public a a(CameraRunSuccessActivity.a value) {
            this.f35453a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35453a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f11436a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35452a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.tvTip, 4);
        sparseIntArray.put(com.huachenjie.run.R.id.flExpressAd, 5);
        sparseIntArray.put(com.huachenjie.run.R.id.flFd, 6);
    }

    public RunActivityCameraRunSuccessBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f11436a, f35452a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f11437a;
            this.f11437a = 0L;
        }
        BaseTitleViewModel baseTitleViewModel = ((RunActivityCameraRunSuccessBinding) this).f11434a;
        CameraRunSuccessActivity.a aVar = ((RunActivityCameraRunSuccessBinding) this).f11435a;
        int iSafeUnbox = 0;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = baseTitleViewModel != null ? baseTitleViewModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                BaseViewModel.b bVarE = baseTitleViewModel != null ? baseTitleViewModel.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            }
            i = iSafeUnbox;
        } else {
            i = 0;
            value = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11440a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11440a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.O(this.f11438a, 0, i, 0, 0, null);
        }
        if ((j & 21) != 0) {
            this.f11439a.k(value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11442a, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f11439a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11437a != 0) {
                return true;
            }
            return this.f11439a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11437a = 16L;
        }
        this.f11439a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityCameraRunSuccessBinding
    public void l(@Nullable CameraRunSuccessActivity.a Click) {
        ((RunActivityCameraRunSuccessBinding) this).f11435a = Click;
        synchronized (this) {
            this.f11437a |= 8;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityCameraRunSuccessBinding
    public void m(@Nullable BaseTitleViewModel Vm) {
        ((RunActivityCameraRunSuccessBinding) this).f11434a = Vm;
        synchronized (this) {
            this.f11437a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11437a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11437a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11439a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((BaseTitleViewModel) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((CameraRunSuccessActivity.a) variable);
        }
        return true;
    }

    public RunActivityCameraRunSuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (FrameLayout) bindings[5], (FrameLayout) bindings[6], (TextView) bindings[4]);
        this.f11437a = -1L;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) bindings[0];
        this.f11441a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f11438a = linearLayout;
        linearLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[3];
        this.f11439a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f11442a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
