package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogPublishPostBindingImpl extends WorksDialogPublishPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14109a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14112a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishPostDialog.a f36879a;

        public a a(PublishPostDialog.a value) {
            this.f36879a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36879a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36878a = sparseIntArray;
        sparseIntArray.put(R.id.iv_close, 1);
        sparseIntArray.put(R.id.ll_content, 2);
        sparseIntArray.put(R.id.recycler_view, 3);
    }

    public WorksDialogPublishPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14109a, f36878a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f14110a;
            this.f14110a = 0L;
        }
        PublishPostDialog.a aVar = ((WorksDialogPublishPostBinding) this).f14107a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14112a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14112a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14111a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14110a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14110a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogPublishPostBinding
    public void k(@Nullable PublishPostDialog.a Click) {
        ((WorksDialogPublishPostBinding) this).f14107a = Click;
        synchronized (this) {
            this.f14110a |= 1;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.k != variableId) {
            return false;
        }
        k((PublishPostDialog.a) variable);
        return true;
    }

    public WorksDialogPublishPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (BLLinearLayout) bindings[2], (RecyclerView) bindings[3]);
        this.f14110a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14111a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
