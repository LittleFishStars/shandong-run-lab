package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogRankingTipBindingImpl extends RunDialogRankingTipBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11771a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11773a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35556a = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 2);
        sparseIntArray.put(R.id.ivClose, 3);
    }

    public RunDialogRankingTipBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11771a, f35556a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11772a;
            this.f11772a = 0L;
        }
        BaseVM baseVM = ((RunDialogRankingTipBinding) this).f11770a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseVM != null ? baseVM.b : null;
            updateLiveDataRegistration(0, mutableLiveData);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null) + jj8.a(44.0f)));
        }
        if (j2 != 0) {
            CommonBindingAdapter.G(((RunDialogRankingTipBinding) this).f35555a, iSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11772a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11772a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogRankingTipBinding
    public void k(@Nullable BaseVM Vm) {
        ((RunDialogRankingTipBinding) this).f11770a = Vm;
        synchronized (this) {
            this.f11772a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> VmStatusBarHeightPx, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11772a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((BaseVM) variable);
        return true;
    }

    public RunDialogRankingTipBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[3], (TextView) bindings[2], (View) bindings[1]);
        this.f11772a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11773a = linearLayout;
        linearLayout.setTag(null);
        ((RunDialogRankingTipBinding) this).f35555a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
