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
public class WorksItemWorksActivityBindingImpl extends WorksItemWorksActivityBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14727a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14729a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37082a = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 2);
    }

    public WorksItemWorksActivityBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14727a, f37082a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f14728a;
            this.f14728a = 0L;
        }
        WorkItemBean workItemBean = ((WorksItemWorksActivityBinding) this).f14726a;
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
            CommonBindingAdapter.b0(((WorksItemWorksActivityBinding) this).f37081a, coverUrl, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14728a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14728a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksActivityBinding
    public void k(@Nullable WorkItemBean Vm) {
        ((WorksItemWorksActivityBinding) this).f14726a = Vm;
        synchronized (this) {
            this.f14728a |= 1;
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

    public WorksItemWorksActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[2]);
        this.f14728a = -1L;
        ((WorksItemWorksActivityBinding) this).f37081a.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14729a = cardView;
        cardView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
