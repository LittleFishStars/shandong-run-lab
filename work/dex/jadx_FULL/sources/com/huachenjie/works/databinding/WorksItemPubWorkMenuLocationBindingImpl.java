package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPubWorkMenuLocationBindingImpl extends WorksItemPubWorkMenuLocationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37052a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14644a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14647a;

    public WorksItemPubWorkMenuLocationBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14644a, f37052a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14645a;
            this.f14645a = 0L;
        }
        PubWorkLocationItemBean pubWorkLocationItemBean = ((WorksItemPubWorkMenuLocationBinding) this).f37051a;
        long j2 = j & 3;
        String subName = (j2 == 0 || pubWorkLocationItemBean == null) ? null : pubWorkLocationItemBean.getSubName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14647a, subName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14645a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14645a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPubWorkMenuLocationBinding
    public void k(@Nullable PubWorkLocationItemBean Bean) {
        ((WorksItemPubWorkMenuLocationBinding) this).f37051a = Bean;
        synchronized (this) {
            this.f14645a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((PubWorkLocationItemBean) variable);
        return true;
    }

    public WorksItemPubWorkMenuLocationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14645a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14646a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f14647a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
