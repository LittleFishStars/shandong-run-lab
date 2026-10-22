package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemAttentionWorksPictureBindingImpl extends WorksItemAttentionWorksPictureBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14458a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f14456a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"works_item_attention_works_header", "works_item_attention_works_bottom"}, new int[]{1, 2}, new int[]{R.layout.works_item_attention_works_header, R.layout.works_item_attention_works_bottom});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37002a = sparseIntArray;
        sparseIntArray.put(R.id.works_banner, 3);
    }

    public WorksItemAttentionWorksPictureBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14456a, f37002a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14457a;
            this.f14457a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemAttentionWorksPictureBinding) this).f14453a;
        if ((j & 12) != 0) {
            ((WorksItemAttentionWorksPictureBinding) this).f14454a.k(workDetailBean);
            ((WorksItemAttentionWorksPictureBinding) this).f14455a.k(workDetailBean);
        }
        ViewDataBinding.executeBindingsOn(((WorksItemAttentionWorksPictureBinding) this).f14455a);
        ViewDataBinding.executeBindingsOn(((WorksItemAttentionWorksPictureBinding) this).f14454a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14457a != 0) {
                return true;
            }
            return ((WorksItemAttentionWorksPictureBinding) this).f14455a.hasPendingBindings() || ((WorksItemAttentionWorksPictureBinding) this).f14454a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14457a = 8L;
        }
        ((WorksItemAttentionWorksPictureBinding) this).f14455a.invalidateAll();
        ((WorksItemAttentionWorksPictureBinding) this).f14454a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemAttentionWorksPictureBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemAttentionWorksPictureBinding) this).f14453a = Vm;
        synchronized (this) {
            this.f14457a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(WorksItemAttentionWorksBottomBinding AttentionWorksBottom, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14457a |= 2;
        }
        return true;
    }

    public final boolean m(WorksItemAttentionWorksHeaderBinding AttentionWorksHeader, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14457a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((WorksItemAttentionWorksHeaderBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return l((WorksItemAttentionWorksBottomBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksItemAttentionWorksPictureBinding) this).f14455a.setLifecycleOwner(lifecycleOwner);
        ((WorksItemAttentionWorksPictureBinding) this).f14454a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemAttentionWorksPictureBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (WorksItemAttentionWorksBottomBinding) bindings[2], (WorksItemAttentionWorksHeaderBinding) bindings[1], (CommonBanner) bindings[3]);
        this.f14457a = -1L;
        setContainedBinding(((WorksItemAttentionWorksPictureBinding) this).f14454a);
        setContainedBinding(((WorksItemAttentionWorksPictureBinding) this).f14455a);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14458a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
