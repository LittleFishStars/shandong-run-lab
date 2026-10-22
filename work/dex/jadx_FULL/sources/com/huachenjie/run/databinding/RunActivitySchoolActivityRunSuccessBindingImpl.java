package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivitySchoolActivityRunSuccessBindingImpl extends RunActivitySchoolActivityRunSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f11558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11559a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SchoolActivitySuccessActivity.a f35493a;

        public a a(SchoolActivitySuccessActivity.a value) {
            this.f35493a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35493a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        f11554a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35492a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.scrollView, 4);
        sparseIntArray.put(com.huachenjie.run.R.id.tvName, 5);
        sparseIntArray.put(com.huachenjie.run.R.id.tvGoalName1, 6);
        sparseIntArray.put(com.huachenjie.run.R.id.icon1, 7);
        sparseIntArray.put(com.huachenjie.run.R.id.tvDistance, 8);
        sparseIntArray.put(com.huachenjie.run.R.id.tvTimeTitle, 9);
        sparseIntArray.put(com.huachenjie.run.R.id.tvTimeIcon, 10);
        sparseIntArray.put(com.huachenjie.run.R.id.tvTime, 11);
    }

    public RunActivitySchoolActivityRunSuccessBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 12, f11554a, f35492a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f11555a;
            this.f11555a = 0L;
        }
        BaseTitleVM baseTitleVM = ((RunActivitySchoolActivityRunSuccessBinding) this).f11550a;
        SchoolActivitySuccessActivity.a aVar = ((RunActivitySchoolActivityRunSuccessBinding) this).f11552a;
        int iSafeUnbox = 0;
        if ((45 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData = baseTitleVM != null ? baseTitleVM.i : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 44) != 0) {
                MutableLiveData<Integer> mutableLiveData2 = baseTitleVM != null ? ((BaseVM) baseTitleVM).f33644a : null;
                updateLiveDataRegistration(2, mutableLiveData2);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? mutableLiveData2.getValue() : null);
            }
            i = iSafeUnbox;
        } else {
            i = 0;
            value = null;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11557a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11557a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.O(this.f11559a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11556a, aVarA, null);
        }
        if ((j & 41) != 0) {
            ((RunActivitySchoolActivityRunSuccessBinding) this).f11551a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunActivitySchoolActivityRunSuccessBinding) this).f11551a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11555a != 0) {
                return true;
            }
            return ((RunActivitySchoolActivityRunSuccessBinding) this).f11551a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11555a = 32L;
        }
        ((RunActivitySchoolActivityRunSuccessBinding) this).f11551a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySchoolActivityRunSuccessBinding
    public void l(@Nullable SchoolActivitySuccessActivity.a Click) {
        ((RunActivitySchoolActivityRunSuccessBinding) this).f11552a = Click;
        synchronized (this) {
            this.f11555a |= 16;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySchoolActivityRunSuccessBinding
    public void m(@Nullable BaseTitleVM Vm) {
        ((RunActivitySchoolActivityRunSuccessBinding) this).f11550a = Vm;
        synchronized (this) {
            this.f11555a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11555a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11555a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11555a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivitySchoolActivityRunSuccessBinding) this).f11551a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((BaseTitleVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SchoolActivitySuccessActivity.a) variable);
        }
        return true;
    }

    public RunActivitySchoolActivityRunSuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (ImageView) bindings[7], (NestedScrollView) bindings[4], (LayoutToolbarBindingBinding) bindings[3], (TextView) bindings[8], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[11], (ImageView) bindings[10], (TextView) bindings[9]);
        this.f11555a = -1L;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) bindings[0];
        this.f11558a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[1];
        this.f11559a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[2];
        this.f11556a = frameLayout;
        frameLayout.setTag(null);
        setContainedBinding(((RunActivitySchoolActivityRunSuccessBinding) this).f11551a);
        setRootTag(root);
        invalidateAll();
    }
}
