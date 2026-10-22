package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogDormitoryExchangeBindingImpl extends WorksDialogDormitoryExchangeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14080a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14082a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36865a = sparseIntArray;
        sparseIntArray.put(R.id.rv_exchange_cards, 1);
        sparseIntArray.put(R.id.btn_exchange, 2);
        sparseIntArray.put(R.id.iv_close, 3);
    }

    public WorksDialogDormitoryExchangeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14080a, f36865a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14081a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14081a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14081a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogDormitoryExchangeBinding
    public void k(@Nullable DormitoryExchangeVM Vm) {
        ((WorksDialogDormitoryExchangeBinding) this).f14078a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((DormitoryExchangeVM) variable);
        return true;
    }

    public WorksDialogDormitoryExchangeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLTextView) bindings[2], (ImageView) bindings[3], (RecyclerView) bindings[1]);
        this.f14081a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14082a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
