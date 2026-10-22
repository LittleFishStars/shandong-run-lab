package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.activities_run.ActivityRuleAdapter;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.activities_run.DetailActivityVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityActivityRuleBindingImpl extends RunActivityActivityRuleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11412a;

    @NonNull
    public final RelativeLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetailActivity.a f35443a;

        public a a(DetailActivity.a value) {
            this.f35443a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35443a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        f11408a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35442a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.tvLeftName, 9);
        sparseIntArray.put(com.huachenjie.run.R.id.tvDisName, 10);
        sparseIntArray.put(com.huachenjie.run.R.id.tvStart2, 11);
        sparseIntArray.put(com.huachenjie.run.R.id.tvLeftName2, 12);
    }

    public RunActivityActivityRuleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 13, f11408a, f35442a));
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ed  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        ActivityRuleAdapter value;
        String str;
        String str2;
        BindingTitleBean value2;
        a aVarA;
        int joinCount;
        int totalCount;
        synchronized (this) {
            j = this.f11409a;
            this.f11409a = 0L;
        }
        DetailActivityVM detailActivityVM = ((RunActivityActivityRuleBinding) this).f11406a;
        DetailActivity.a aVar = ((RunActivityActivityRuleBinding) this).f11405a;
        if ((191 & j) != 0) {
            if ((j & 161) != 0) {
                MutableLiveData<Float> mutableLiveDataU = detailActivityVM != null ? detailActivityVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                str = String.format("%1s km", mutableLiveDataU != null ? mutableLiveDataU.getValue() : null);
            } else {
                str = null;
            }
            if ((j & 162) != 0) {
                MutableLiveData<ActivityRunDetailBean> mutableLiveDataT = detailActivityVM != null ? detailActivityVM.t() : null;
                updateLiveDataRegistration(1, mutableLiveDataT);
                ActivityRunDetailBean value3 = mutableLiveDataT != null ? mutableLiveDataT.getValue() : null;
                if (value3 != null) {
                    totalCount = value3.getTotalCount();
                    joinCount = value3.getJoinCount();
                } else {
                    joinCount = 0;
                    totalCount = 0;
                }
                str2 = String.format("%1s/%2s", Integer.valueOf(totalCount - joinCount), Integer.valueOf(totalCount));
            } else {
                str2 = null;
            }
            if ((j & 164) != 0) {
                MutableLiveData<Boolean> mutableLiveDataW = detailActivityVM != null ? detailActivityVM.w() : null;
                updateLiveDataRegistration(2, mutableLiveDataW);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
            } else {
                zSafeUnbox = false;
                zSafeUnbox2 = false;
            }
            if ((j & 168) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataX = detailActivityVM != null ? detailActivityVM.x() : null;
                updateLiveDataRegistration(3, mutableLiveDataX);
                if (mutableLiveDataX != null) {
                    value2 = mutableLiveDataX.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 176) == 0) {
                value = null;
            } else {
                MutableLiveData<ActivityRuleAdapter> mutableLiveDataV = detailActivityVM != null ? detailActivityVM.v() : null;
                updateLiveDataRegistration(4, mutableLiveDataV);
                if (mutableLiveDataV != null) {
                    value = mutableLiveDataV.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            value = null;
            str = null;
            str2 = null;
            value2 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11412a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11412a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((168 & j) != 0) {
            this.f11411a.k(value2);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(this.f11410a, value, false, false);
        }
        if ((164 & j) != 0) {
            CommonBindingAdapter.l0(((RunActivityActivityRuleBinding) this).f35441a, zSafeUnbox);
            CommonBindingAdapter.l0(((RunActivityActivityRuleBinding) this).b, zSafeUnbox2);
        }
        if ((j & 161) != 0) {
            TextViewBindingAdapter.setText(((RunActivityActivityRuleBinding) this).f11407b, str);
        }
        if ((j & 162) != 0) {
            TextViewBindingAdapter.setText(super.c, str2);
            TextViewBindingAdapter.setText(this.d, str2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.g, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f11411a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11409a != 0) {
                return true;
            }
            return this.f11411a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11409a = 128L;
        }
        this.f11411a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityActivityRuleBinding
    public void l(@Nullable DetailActivity.a Click) {
        ((RunActivityActivityRuleBinding) this).f11405a = Click;
        synchronized (this) {
            this.f11409a |= 64;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityActivityRuleBinding
    public void m(@Nullable DetailActivityVM Vm) {
        ((RunActivityActivityRuleBinding) this).f11406a = Vm;
        synchronized (this) {
            this.f11409a |= 32;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ActivityRunDetailBean> VmActivityRunDetail, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11409a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Float> VmActivityRunDisWrapper, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11409a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return p((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<ActivityRuleAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11409a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmCanStartActivityRun, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11409a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11409a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11411a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((DetailActivityVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((DetailActivity.a) variable);
        }
        return true;
    }

    public RunActivityActivityRuleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (RelativeLayout) bindings[2], (RelativeLayout) bindings[6], (TextView) bindings[10], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[7], (TextView) bindings[9], (TextView) bindings[12], (TextView) bindings[3], (TextView) bindings[11]);
        this.f11409a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[8];
        this.f11411a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.c = relativeLayout;
        relativeLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) bindings[1];
        this.f11410a = recyclerView;
        recyclerView.setTag(null);
        ((RunActivityActivityRuleBinding) this).f35441a.setTag(null);
        ((RunActivityActivityRuleBinding) this).b.setTag(null);
        ((RunActivityActivityRuleBinding) this).f11407b.setTag(null);
        super.c.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
