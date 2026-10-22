package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
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
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsActivity;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivitySettingInterestTagsBindingImpl extends WorksActivitySettingInterestTagsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13954a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SettingInterestTagsActivity.a f36810a;

        public a a(SettingInterestTagsActivity.a value) {
            this.f36810a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36810a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f13951a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36809a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.works.R.id.tv_tips, 4);
        sparseIntArray.put(com.huachenjie.works.R.id.sl_bottom, 5);
    }

    public WorksActivitySettingInterestTagsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f13951a, f36809a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        SettingInterestTagsAdapter value;
        BindingTitleBean value2;
        a aVarA;
        synchronized (this) {
            j = this.f13952a;
            this.f13952a = 0L;
        }
        SettingInterestTagsVM settingInterestTagsVM = ((WorksActivitySettingInterestTagsBinding) this).f13949a;
        SettingInterestTagsActivity.a aVar = ((WorksActivitySettingInterestTagsBinding) this).f13948a;
        if ((45 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = settingInterestTagsVM != null ? settingInterestTagsVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<SettingInterestTagsAdapter> mutableLiveDataJ = settingInterestTagsVM != null ? settingInterestTagsVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13954a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13954a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((WorksActivitySettingInterestTagsBinding) this).f36808a, value, false, false);
        }
        if ((j & 41) != 0) {
            ((WorksActivitySettingInterestTagsBinding) this).f13946a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((WorksActivitySettingInterestTagsBinding) this).f13946a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13952a != 0) {
                return true;
            }
            return ((WorksActivitySettingInterestTagsBinding) this).f13946a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13952a = 32L;
        }
        ((WorksActivitySettingInterestTagsBinding) this).f13946a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivitySettingInterestTagsBinding
    public void l(@Nullable SettingInterestTagsActivity.a Click) {
        ((WorksActivitySettingInterestTagsBinding) this).f13948a = Click;
        synchronized (this) {
            this.f13952a |= 16;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivitySettingInterestTagsBinding
    public void m(@Nullable SettingInterestTagsVM Vm) {
        ((WorksActivitySettingInterestTagsBinding) this).f13949a = Vm;
        synchronized (this) {
            this.f13952a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding ToolBar, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13952a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<SettingInterestTagsAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13952a |= 4;
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
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13952a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksActivitySettingInterestTagsBinding) this).f13946a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((SettingInterestTagsVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((SettingInterestTagsActivity.a) variable);
        }
        return true;
    }

    public WorksActivitySettingInterestTagsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[1], (ShadowLayout) bindings[5], (LayoutToolbarBindingBinding) bindings[3], (BLTextView) bindings[4]);
        this.f13952a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f13953a = relativeLayout;
        relativeLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.b = bLTextView;
        bLTextView.setTag(null);
        ((WorksActivitySettingInterestTagsBinding) this).f36808a.setTag(null);
        setContainedBinding(((WorksActivitySettingInterestTagsBinding) this).f13946a);
        setRootTag(root);
        invalidateAll();
    }
}
