package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.appeal.AppealActivity;
import com.huachenjie.run.page.appeal.AppealVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityAppealBindingImpl extends RunActivityAppealBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11432a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AppealActivity.a f35450a;

        public a a(AppealActivity.a value) {
            this.f35450a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35450a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f11428a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35449a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.edit_appeal, 4);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_appeal_tip, 5);
    }

    public RunActivityAppealBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f11428a, f35449a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String value2;
        boolean zSafeUnbox;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f11429a;
            this.f11429a = 0L;
        }
        AppealVM appealVM = ((RunActivityAppealBinding) this).f11426a;
        AppealActivity.a aVar = ((RunActivityAppealBinding) this).f11425a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = appealVM != null ? appealVM.i() : null;
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
                MutableLiveData<String> mutableLiveDataL = appealVM != null ? appealVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = appealVM != null ? appealVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            }
            j2 = j & 48;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f11432a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f11432a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 44) != 0) {
                CommonBindingAdapter.e0(((RunActivityAppealBinding) this).f11427a, zSafeUnbox);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((RunActivityAppealBinding) this).f11427a, aVarA, null);
            }
            if ((j & 41) != 0) {
                this.f11431a.k(value);
            }
            if ((j & 42) != 0) {
                TextViewBindingAdapter.setText(((RunActivityAppealBinding) this).f11424a, value2);
            }
            ViewDataBinding.executeBindingsOn(this.f11431a);
        }
        value = null;
        value2 = null;
        zSafeUnbox = false;
        j2 = j & 48;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.e0(((RunActivityAppealBinding) this).f11427a, zSafeUnbox);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunActivityAppealBinding) this).f11427a, aVarA, null);
        }
        if ((j & 41) != 0) {
            this.f11431a.k(value);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((RunActivityAppealBinding) this).f11424a, value2);
        }
        ViewDataBinding.executeBindingsOn(this.f11431a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11429a != 0) {
                return true;
            }
            return this.f11431a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11429a = 32L;
        }
        this.f11431a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityAppealBinding
    public void l(@Nullable AppealActivity.a Click) {
        ((RunActivityAppealBinding) this).f11425a = Click;
        synchronized (this) {
            this.f11429a |= 16;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityAppealBinding
    public void m(@Nullable AppealVM Vm) {
        ((RunActivityAppealBinding) this).f11426a = Vm;
        synchronized (this) {
            this.f11429a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmContentCount, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11429a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmSubmitEnable, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11429a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((MutableLiveData) object, fieldId);
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
            this.f11429a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11431a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((AppealVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((AppealActivity.a) variable);
        }
        return true;
    }

    public RunActivityAppealBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BLTextView) bindings[2], (EditText) bindings[4], (TextView) bindings[1], (TextView) bindings[5]);
        this.f11429a = -1L;
        ((RunActivityAppealBinding) this).f11427a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[3];
        this.f11431a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11430a = linearLayout;
        linearLayout.setTag(null);
        ((RunActivityAppealBinding) this).f11424a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
