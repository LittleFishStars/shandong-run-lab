package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import cn.hzjizhun.admin.JZUnifiedADContainer;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksAdBindingImpl extends WorksItemWorksAdBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14733a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14735a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37084a = sparseIntArray;
        sparseIntArray.put(R.id.fl_ad_container, 1);
        sparseIntArray.put(R.id.unified_ad_container, 2);
        sparseIntArray.put(R.id.unified_img, 3);
        sparseIntArray.put(R.id.bt_close, 4);
        sparseIntArray.put(R.id.unified_logo, 5);
    }

    public WorksItemWorksAdBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14733a, f37084a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14734a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14734a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14734a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksAdBinding
    public void k(@Nullable WorkItemBean Vm) {
        ((WorksItemWorksAdBinding) this).f14732a = Vm;
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
        k((WorkItemBean) variable);
        return true;
    }

    public WorksItemWorksAdBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (ConstraintLayout) bindings[1], (JZUnifiedADContainer) bindings[2], (ImageView) bindings[3], (ImageView) bindings[5]);
        this.f14734a = -1L;
        CardView cardView = (CardView) bindings[0];
        this.f14735a = cardView;
        cardView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
