package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.RunQuitConfirmDialog;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogQuitConfirmBindingImpl extends RunDialogQuitConfirmBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11767a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunQuitConfirmDialog.a f35553a;

        public a a(RunQuitConfirmDialog.a value) {
            this.f35553a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35553a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunQuitConfirmDialog.a f35554a;

        public b a(RunQuitConfirmDialog.a value) {
            this.f35554a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35554a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11762a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_pause_header"}, new int[]{3}, new int[]{R.layout.run_layout_pause_header});
        f35552a = null;
    }

    public RunDialogQuitConfirmBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11762a, f35552a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11763a;
            this.f11763a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunDialogQuitConfirmBinding) this).f11761a;
        RunQuitConfirmDialog.a aVar = ((RunDialogQuitConfirmBinding) this).f11760a;
        long j2 = 10 & j;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11765a;
            if (bVar == null) {
                bVar = new b();
                this.f11765a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11764a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11764a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11767a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        if (j2 != 0) {
            ((RunDialogQuitConfirmBinding) this).f35551a.k(sunshineRunVM);
        }
        ViewDataBinding.executeBindingsOn(((RunDialogQuitConfirmBinding) this).f35551a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11763a != 0) {
                return true;
            }
            return ((RunDialogQuitConfirmBinding) this).f35551a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11763a = 8L;
        }
        ((RunDialogQuitConfirmBinding) this).f35551a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogQuitConfirmBinding
    public void l(@Nullable RunQuitConfirmDialog.a Click) {
        ((RunDialogQuitConfirmBinding) this).f11760a = Click;
        synchronized (this) {
            this.f11763a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogQuitConfirmBinding
    public void m(@Nullable SunshineRunVM Vm) {
        ((RunDialogQuitConfirmBinding) this).f11761a = Vm;
        synchronized (this) {
            this.f11763a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(RunLayoutPauseHeaderBinding PauseHeader, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11763a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((RunLayoutPauseHeaderBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunDialogQuitConfirmBinding) this).f35551a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRunVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunQuitConfirmDialog.a) variable);
        }
        return true;
    }

    public RunDialogQuitConfirmBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RunLayoutPauseHeaderBinding) bindings[3]);
        this.f11763a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f11766a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[1];
        this.f11767a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[2];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setContainedBinding(((RunDialogQuitConfirmBinding) this).f35551a);
        setRootTag(root);
        invalidateAll();
    }
}
