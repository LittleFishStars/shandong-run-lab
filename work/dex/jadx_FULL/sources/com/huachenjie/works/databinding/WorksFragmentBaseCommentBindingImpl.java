package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.page.comment.base.BaseCommentAdapter;
import com.huachenjie.works.page.comment.base.BaseCommentVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentBaseCommentBindingImpl extends WorksFragmentBaseCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14178a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14180a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36901a = sparseIntArray;
        sparseIntArray.put(R.id.vs_title, 2);
    }

    public WorksFragmentBaseCommentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14178a, f36901a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14179a;
            this.f14179a = 0L;
        }
        BaseCommentVM baseCommentVM = ((WorksFragmentBaseCommentBinding) this).f14177a;
        long j2 = j & 7;
        BaseCommentAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<BaseCommentAdapter> mutableLiveDataI = baseCommentVM != null ? baseCommentVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((WorksFragmentBaseCommentBinding) this).f14176a, value, false, false);
        }
        if (((WorksFragmentBaseCommentBinding) this).f36900a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((WorksFragmentBaseCommentBinding) this).f36900a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14179a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14179a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentBaseCommentBinding
    public void k(@Nullable BaseCommentVM Vm) {
        ((WorksFragmentBaseCommentBinding) this).f14177a = Vm;
        synchronized (this) {
            this.f14179a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<BaseCommentAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14179a |= 1;
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
        if (qk0.p0 != variableId) {
            return false;
        }
        k((BaseCommentVM) variable);
        return true;
    }

    public WorksFragmentBaseCommentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[1], new ViewStubProxy((ViewStub) bindings[2]));
        this.f14179a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14180a = linearLayout;
        linearLayout.setTag(null);
        ((WorksFragmentBaseCommentBinding) this).f14176a.setTag(null);
        ((WorksFragmentBaseCommentBinding) this).f36900a.setContainingBinding(this);
        setRootTag(root);
        invalidateAll();
    }
}
