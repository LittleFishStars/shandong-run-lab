package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorkListVideoBindingImpl extends WorksItemWorkListVideoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14724a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f14723a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"works_item_work_detail_list"}, new int[]{2}, new int[]{R.layout.works_item_work_detail_list});
        f37080a = null;
    }

    public WorksItemWorkListVideoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14723a, f37080a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f14724a;
            this.f14724a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemWorkListVideoBinding) this).f14721a;
        long j2 = j & 6;
        String path = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            WorkImageBean coverBean = workDetailBean != null ? workDetailBean.formatCoverBean() : null;
            if (coverBean != null) {
                path = coverBean.getPath();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            ((WorksItemWorkListVideoBinding) this).f14722a.k(workDetailBean);
            CommonBindingAdapter.b0(((WorksItemWorkListVideoBinding) this).f14720a, path, requestOptions, false);
        }
        ViewDataBinding.executeBindingsOn(((WorksItemWorkListVideoBinding) this).f14722a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14724a != 0) {
                return true;
            }
            return ((WorksItemWorkListVideoBinding) this).f14722a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14724a = 4L;
        }
        ((WorksItemWorkListVideoBinding) this).f14722a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorkListVideoBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemWorkListVideoBinding) this).f14721a = Vm;
        synchronized (this) {
            this.f14724a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(WorksItemWorkDetailListBinding LayoutWorksDetail, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14724a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((WorksItemWorkDetailListBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksItemWorkListVideoBinding) this).f14722a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemWorkListVideoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (WorksItemWorkDetailListBinding) bindings[2], (ImageView) bindings[1], (FrameLayout) bindings[0]);
        this.f14724a = -1L;
        setContainedBinding(((WorksItemWorkListVideoBinding) this).f14722a);
        ((WorksItemWorkListVideoBinding) this).f14720a.setTag(null);
        ((WorksItemWorkListVideoBinding) this).f37079a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
