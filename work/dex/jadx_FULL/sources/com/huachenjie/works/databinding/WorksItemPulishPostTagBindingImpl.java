package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.PostCategoryBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPulishPostTagBindingImpl extends WorksItemPulishPostTagBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37063a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14671a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14673a;

    public WorksItemPulishPostTagBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f14671a, f37063a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14672a;
            this.f14672a = 0L;
        }
        PostCategoryBean postCategoryBean = ((WorksItemPulishPostTagBinding) this).f37062a;
        long j2 = j & 3;
        String tagName = (j2 == 0 || postCategoryBean == null) ? null : postCategoryBean.getTagName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14673a, tagName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14672a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14672a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPulishPostTagBinding
    public void k(@Nullable PostCategoryBean Bean) {
        ((WorksItemPulishPostTagBinding) this).f37062a = Bean;
        synchronized (this) {
            this.f14672a |= 1;
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
        k((PostCategoryBean) variable);
        return true;
    }

    public WorksItemPulishPostTagBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14672a = -1L;
        BLTextView bLTextView = (BLTextView) bindings[0];
        this.f14673a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
