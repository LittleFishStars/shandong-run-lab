package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.ruler.VerticalRulerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogMoreDistanceBindingImpl extends RunDialogMoreDistanceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11736a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11740a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MoreDistanceDialog.a f35543a;

        public a a(MoreDistanceDialog.a value) {
            this.f35543a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35543a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MoreDistanceDialog.a f35544a;

        public b a(MoreDistanceDialog.a value) {
            this.f35544a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35544a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35542a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.ll_content, 4);
        sparseIntArray.put(R.id.ruler_distance, 5);
        sparseIntArray.put(R.id.cb_remember, 6);
    }

    public RunDialogMoreDistanceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f11736a, f35542a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11737a;
            this.f11737a = 0L;
        }
        MoreDistanceDialog.a aVar = ((RunDialogMoreDistanceBinding) this).f11734a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11739a;
            if (bVar == null) {
                bVar = new b();
                this.f11739a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11738a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11738a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunDialogMoreDistanceBinding) this).f11731a, aVarA, null);
            CommonBindingAdapter.q(((RunDialogMoreDistanceBinding) this).f11735a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11737a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11737a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogMoreDistanceBinding
    public void k(@Nullable MoreDistanceDialog.a Click) {
        ((RunDialogMoreDistanceBinding) this).f11734a = Click;
        synchronized (this) {
            this.f11737a |= 1;
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
        k((MoreDistanceDialog.a) variable);
        return true;
    }

    public RunDialogMoreDistanceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CheckBox) bindings[6], (ImageView) bindings[1], (FrameLayout) bindings[4], (VerticalRulerView) bindings[5], (BLTextView) bindings[2], (TextView) bindings[3]);
        this.f11737a = -1L;
        ((RunDialogMoreDistanceBinding) this).f11731a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f11740a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((RunDialogMoreDistanceBinding) this).f11735a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
