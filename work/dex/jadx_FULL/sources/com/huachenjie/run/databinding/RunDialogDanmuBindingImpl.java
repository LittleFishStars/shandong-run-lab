package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialog;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialogAdapter;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialogVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogDanmuBindingImpl extends RunDialogDanmuBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35525a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11690a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11694a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DanmuDialog.a f35526a;

        public a a(DanmuDialog.a value) {
            this.f35526a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35526a.a(arg0);
        }
    }

    public RunDialogDanmuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11690a, f35525a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        DanmuDialogAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f11691a;
            this.f11691a = 0L;
        }
        DanmuDialogVM danmuDialogVM = ((RunDialogDanmuBinding) this).f11689a;
        DanmuDialog.a aVar = ((RunDialogDanmuBinding) this).f11688a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<DanmuDialogAdapter> mutableLiveDataJ = danmuDialogVM != null ? danmuDialogVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11693a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11693a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11692a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((RunDialogDanmuBinding) this).f35524a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11691a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11691a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogDanmuBinding
    public void l(@Nullable DanmuDialog.a Click) {
        ((RunDialogDanmuBinding) this).f11688a = Click;
        synchronized (this) {
            this.f11691a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogDanmuBinding
    public void m(@Nullable DanmuDialogVM Vm) {
        ((RunDialogDanmuBinding) this).f11689a = Vm;
        synchronized (this) {
            this.f11691a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<DanmuDialogAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11691a |= 1;
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
            m((DanmuDialogVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((DanmuDialog.a) variable);
        }
        return true;
    }

    public RunDialogDanmuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[2]);
        this.f11691a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f11694a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f11692a = imageView;
        imageView.setTag(null);
        ((RunDialogDanmuBinding) this).f35524a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
