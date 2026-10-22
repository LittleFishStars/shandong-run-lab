package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.TouchGestureView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.video.VideoWorkListVM;
import com.huachenjie.works.page.details.video.WorkVideoListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentVideoWorkListBindingImpl extends WorksFragmentVideoWorkListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14354a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14355a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36967a = sparseIntArray;
        sparseIntArray.put(R.id.refreshLayout, 2);
    }

    public WorksFragmentVideoWorkListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14354a, f36967a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14355a;
            this.f14355a = 0L;
        }
        VideoWorkListVM videoWorkListVM = ((WorksFragmentVideoWorkListBinding) this).f14352a;
        long j2 = j & 7;
        WorkVideoListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<WorkVideoListAdapter> mutableLiveDataM = videoWorkListVM != null ? videoWorkListVM.m() : null;
            updateLiveDataRegistration(0, mutableLiveDataM);
            if (mutableLiveDataM != null) {
                value = mutableLiveDataM.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.t(((WorksFragmentVideoWorkListBinding) this).f36966a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14355a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14355a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentVideoWorkListBinding
    public void k(@Nullable VideoWorkListVM Vm) {
        ((WorksFragmentVideoWorkListBinding) this).f14352a = Vm;
        synchronized (this) {
            this.f14355a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<WorkVideoListAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14355a |= 1;
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
        k((VideoWorkListVM) variable);
        return true;
    }

    public WorksFragmentVideoWorkListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TouchGestureView) bindings[0], (SmartRefreshLayout) bindings[2], (ViewPager2) bindings[1]);
        this.f14355a = -1L;
        ((WorksFragmentVideoWorkListBinding) this).f14351a.setTag(null);
        ((WorksFragmentVideoWorkListBinding) this).f36966a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
