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
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksFirstBindingImpl extends WorksItemWorksFirstBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37094a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14764a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14768a;

    public WorksItemWorksFirstBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14764a, f37094a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        Object coverUrl;
        int workSize;
        synchronized (this) {
            j = this.f14765a;
            this.f14765a = 0L;
        }
        WorkItemBean workItemBean = ((WorksItemWorksFirstBinding) this).f37093a;
        long j2 = j & 3;
        Object obj = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (workItemBean != null) {
                workSize = workItemBean.getWorkSize();
                coverUrl = workItemBean.formatCoverUrl();
            } else {
                coverUrl = null;
                workSize = 0;
            }
            Object obj2 = coverUrl;
            str = String.format("共%d个", Integer.valueOf(workSize));
            obj = obj2;
        } else {
            requestOptions = null;
            str = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f14766a, obj, requestOptions, false);
            TextViewBindingAdapter.setText(this.f14767a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14765a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14765a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksFirstBinding
    public void k(@Nullable WorkItemBean Vm) {
        ((WorksItemWorksFirstBinding) this).f37093a = Vm;
        synchronized (this) {
            this.f14765a |= 1;
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

    public WorksItemWorksFirstBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14765a = -1L;
        CardView cardView = (CardView) bindings[0];
        this.f14768a = cardView;
        cardView.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14766a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14767a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
