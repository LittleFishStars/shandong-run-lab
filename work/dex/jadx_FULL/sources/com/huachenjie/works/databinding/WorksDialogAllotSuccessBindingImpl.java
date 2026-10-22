package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogAllotSuccessBindingImpl extends WorksDialogAllotSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13973a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13975a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36818a = sparseIntArray;
        sparseIntArray.put(R.id.ll_container, 1);
        sparseIntArray.put(R.id.tv_dormitory_name, 2);
        sparseIntArray.put(R.id.tv_dormitory_user, 3);
        sparseIntArray.put(R.id.iv_dormitory_image, 4);
        sparseIntArray.put(R.id.tv_dormitory_bt, 5);
    }

    public WorksDialogAllotSuccessBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f13973a, f36818a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13974a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13974a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13974a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogAllotSuccessBinding
    public void k(@Nullable BaseViewModel Vm) {
        ((WorksDialogAllotSuccessBinding) this).f13971a = Vm;
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
        k((BaseViewModel) variable);
        return true;
    }

    public WorksDialogAllotSuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (LinearLayout) bindings[1], (BLTextView) bindings[5], (TextView) bindings[2], (BLTextView) bindings[3]);
        this.f13974a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f13975a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
