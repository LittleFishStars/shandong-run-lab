package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.bean.WorksDetailMenuBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksDetailMenuBindingImpl extends WorksItemWorksDetailMenuBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37092a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14759a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14763a;

    public WorksItemWorksDetailMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14759a, f37092a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        int icon;
        synchronized (this) {
            j = this.f14760a;
            this.f14760a = 0L;
        }
        WorksDetailMenuBean worksDetailMenuBean = ((WorksItemWorksDetailMenuBinding) this).f37091a;
        long j2 = j & 3;
        if (j2 == 0 || worksDetailMenuBean == null) {
            name = null;
            icon = 0;
        } else {
            name = worksDetailMenuBean.getName();
            icon = worksDetailMenuBean.getIcon();
        }
        if (j2 != 0) {
            CommonBindingAdapter.S(this.f14761a, icon);
            TextViewBindingAdapter.setText(this.f14763a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14760a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14760a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksDetailMenuBinding
    public void k(@Nullable WorksDetailMenuBean Bean) {
        ((WorksItemWorksDetailMenuBinding) this).f37091a = Bean;
        synchronized (this) {
            this.f14760a |= 1;
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
        k((WorksDetailMenuBean) variable);
        return true;
    }

    public WorksItemWorksDetailMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14760a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14762a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14761a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14763a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
