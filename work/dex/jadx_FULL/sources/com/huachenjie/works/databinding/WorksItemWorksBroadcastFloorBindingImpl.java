package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksBroadcastFloorBindingImpl extends WorksItemWorksBroadcastFloorBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14751a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14753a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37088a = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 2);
    }

    public WorksItemWorksBroadcastFloorBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14751a, f37088a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f14752a;
            this.f14752a = 0L;
        }
        WorkItemBean workItemBean = ((WorksItemWorksBroadcastFloorBinding) this).f14750a;
        long j2 = j & 3;
        Object coverUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (workItemBean != null) {
                coverUrl = workItemBean.formatCoverUrl();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((WorksItemWorksBroadcastFloorBinding) this).f37087a, coverUrl, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14752a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14752a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksBroadcastFloorBinding
    public void k(@Nullable WorkItemBean Vm) {
        ((WorksItemWorksBroadcastFloorBinding) this).f14750a = Vm;
        synchronized (this) {
            this.f14752a |= 1;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
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

    public WorksItemWorksBroadcastFloorBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[2]);
        this.f14752a = -1L;
        ((WorksItemWorksBroadcastFloorBinding) this).f37087a.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14753a = cardView;
        cardView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
