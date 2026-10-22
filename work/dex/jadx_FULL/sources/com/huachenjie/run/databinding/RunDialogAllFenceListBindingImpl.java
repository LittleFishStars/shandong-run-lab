package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GeoFenceListV2Adapter;
import com.huachenjie.run.dialog.AllFenceListDialog;
import com.huachenjie.run.dialog.AllFenceListVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogAllFenceListBindingImpl extends RunDialogAllFenceListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11685a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11687a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AllFenceListDialog.a f35523a;

        public a a(AllFenceListDialog.a value) {
            this.f35523a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35523a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35522a = sparseIntArray;
        sparseIntArray.put(R.id.tvCloseDrawer, 3);
    }

    public RunDialogAllFenceListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11685a, f35522a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        GeoFenceListV2Adapter value;
        a aVarA;
        synchronized (this) {
            j = this.f11686a;
            this.f11686a = 0L;
        }
        AllFenceListVM allFenceListVM = ((RunDialogAllFenceListBinding) this).f11683a;
        AllFenceListDialog.a aVar = ((RunDialogAllFenceListBinding) this).f11682a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<GeoFenceListV2Adapter> mutableLiveDataH = allFenceListVM != null ? allFenceListVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11687a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11687a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((RunDialogAllFenceListBinding) this).f11681a, value, false, false);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((RunDialogAllFenceListBinding) this).f35521a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11686a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11686a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogAllFenceListBinding
    public void l(@Nullable AllFenceListDialog.a Click) {
        ((RunDialogAllFenceListBinding) this).f11682a = Click;
        synchronized (this) {
            this.f11686a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogAllFenceListBinding
    public void m(@Nullable AllFenceListVM Vm) {
        ((RunDialogAllFenceListBinding) this).f11683a = Vm;
        synchronized (this) {
            this.f11686a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GeoFenceListV2Adapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11686a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((AllFenceListVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((AllFenceListDialog.a) variable);
        }
        return true;
    }

    public RunDialogAllFenceListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[2], (ImageView) bindings[1], (BLConstraintLayout) bindings[0], (TextView) bindings[3]);
        this.f11686a = -1L;
        ((RunDialogAllFenceListBinding) this).f11681a.setTag(null);
        ((RunDialogAllFenceListBinding) this).f35521a.setTag(null);
        ((RunDialogAllFenceListBinding) this).f11684a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
