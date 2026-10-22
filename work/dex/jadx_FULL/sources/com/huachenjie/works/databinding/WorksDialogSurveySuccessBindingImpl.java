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
public class WorksDialogSurveySuccessBindingImpl extends WorksDialogSurveySuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14136a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14138a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36888a = sparseIntArray;
        sparseIntArray.put(R.id.ll_container, 1);
        sparseIntArray.put(R.id.tv_name, 2);
        sparseIntArray.put(R.id.iv_image, 3);
        sparseIntArray.put(R.id.bt_close, 4);
    }

    public WorksDialogSurveySuccessBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14136a, f36888a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14137a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14137a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14137a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogSurveySuccessBinding
    public void k(@Nullable BaseViewModel Vm) {
        ((WorksDialogSurveySuccessBinding) this).f14134a = Vm;
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

    public WorksDialogSurveySuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLTextView) bindings[4], (ImageView) bindings[3], (LinearLayout) bindings[1], (TextView) bindings[2]);
        this.f14137a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14138a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
