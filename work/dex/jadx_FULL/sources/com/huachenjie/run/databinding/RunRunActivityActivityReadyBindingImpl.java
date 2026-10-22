package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
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
import com.huachenjie.run.page.activities_run.ActivityReadyActivity;
import com.huachenjie.run.page.activities_run.ActivityReadyVM;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunRunActivityActivityReadyBindingImpl extends RunRunActivityActivityReadyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f12265a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ActivityReadyActivity.a f35734a;

        public a a(ActivityReadyActivity.a value) {
            this.f35734a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35734a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f12261a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35733a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.fl_map_container, 3);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_target_distance, 4);
    }

    public RunRunActivityActivityReadyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f12261a, f35733a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f12262a;
            this.f12262a = 0L;
        }
        ActivityReadyVM activityReadyVM = ((RunRunActivityActivityReadyBinding) this).f12259a;
        ActivityReadyActivity.a aVar = ((RunRunActivityActivityReadyBinding) this).f12258a;
        long j2 = 21 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveDataY = activityReadyVM != null ? activityReadyVM.y() : null;
            updateLiveDataRegistration(0, mutableLiveDataY);
            if (mutableLiveDataY != null) {
                value = mutableLiveDataY.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f12264a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12264a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f12265a, aVarA, null);
        }
        if (j2 != 0) {
            ((RunRunActivityActivityReadyBinding) this).f12257a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunRunActivityActivityReadyBinding) this).f12257a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12262a != 0) {
                return true;
            }
            return ((RunRunActivityActivityReadyBinding) this).f12257a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12262a = 16L;
        }
        ((RunRunActivityActivityReadyBinding) this).f12257a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunActivityActivityReadyBinding
    public void l(@Nullable ActivityReadyActivity.a Click) {
        ((RunRunActivityActivityReadyBinding) this).f12258a = Click;
        synchronized (this) {
            this.f12262a |= 8;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunActivityActivityReadyBinding
    public void m(@Nullable ActivityReadyVM Vm) {
        ((RunRunActivityActivityReadyBinding) this).f12259a = Vm;
        synchronized (this) {
            this.f12262a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12262a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12262a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunRunActivityActivityReadyBinding) this).f12257a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((ActivityReadyVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((ActivityReadyActivity.a) variable);
        }
        return true;
    }

    public RunRunActivityActivityReadyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (FrameLayout) bindings[3], (LayoutToolbarBindingBinding) bindings[2], (BLTextView) bindings[4]);
        this.f12262a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f12263a = relativeLayout;
        relativeLayout.setTag(null);
        BLButton bLButton = (BLButton) bindings[1];
        this.f12265a = bLButton;
        bLButton.setTag(null);
        setContainedBinding(((RunRunActivityActivityReadyBinding) this).f12257a);
        setRootTag(root);
        invalidateAll();
    }
}
