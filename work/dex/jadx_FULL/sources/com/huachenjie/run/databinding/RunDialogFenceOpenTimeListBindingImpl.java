package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.FenceOpenTimeListDialog;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogFenceOpenTimeListBindingImpl extends RunDialogFenceOpenTimeListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11708a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11712a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FenceOpenTimeListDialog.a f35533a;

        public a a(FenceOpenTimeListDialog.a value) {
            this.f35533a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35533a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35532a = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 2);
        sparseIntArray.put(R.id.recyclerView, 3);
    }

    public RunDialogFenceOpenTimeListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11708a, f35532a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f11709a;
            this.f11709a = 0L;
        }
        FenceOpenTimeListDialog.a aVar = ((RunDialogFenceOpenTimeListBinding) this).f11707a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11711a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11711a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11710a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11709a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11709a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogFenceOpenTimeListBinding
    public void k(@Nullable FenceOpenTimeListDialog.a Click) {
        ((RunDialogFenceOpenTimeListBinding) this).f11707a = Click;
        synchronized (this) {
            this.f11709a |= 1;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.k != variableId) {
            return false;
        }
        k((FenceOpenTimeListDialog.a) variable);
        return true;
    }

    public RunDialogFenceOpenTimeListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[3], (TextView) bindings[2]);
        this.f11709a = -1L;
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) bindings[0];
        this.f11712a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f11710a = imageView;
        imageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
