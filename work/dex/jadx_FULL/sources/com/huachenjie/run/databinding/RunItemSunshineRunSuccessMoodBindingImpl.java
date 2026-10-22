package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.bean.EmaOptionBean;
import com.zj.adlib.ju3;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemSunshineRunSuccessMoodBindingImpl extends RunItemSunshineRunSuccessMoodBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35638a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11988a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11991a;

    public RunItemSunshineRunSuccessMoodBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11988a, f35638a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String content;
        synchronized (this) {
            j = this.f11989a;
            this.f11989a = 0L;
        }
        EmaOptionBean emaOptionBean = ((RunItemSunshineRunSuccessMoodBinding) this).f11987a;
        long j2 = j & 3;
        String logoUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (emaOptionBean != null) {
                logoUrl = emaOptionBean.getLogoUrl();
                content = emaOptionBean.getContent();
            } else {
                content = null;
            }
        } else {
            requestOptions = null;
            content = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((RunItemSunshineRunSuccessMoodBinding) this).f35637a, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f11990a, content);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11989a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11989a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemSunshineRunSuccessMoodBinding
    public void k(@Nullable EmaOptionBean Bean) {
        ((RunItemSunshineRunSuccessMoodBinding) this).f11987a = Bean;
        synchronized (this) {
            this.f11989a |= 1;
        }
        notifyPropertyChanged(lk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.g != variableId) {
            return false;
        }
        k((EmaOptionBean) variable);
        return true;
    }

    public RunItemSunshineRunSuccessMoodBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1]);
        this.f11989a = -1L;
        ((RunItemSunshineRunSuccessMoodBinding) this).f35637a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11991a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f11990a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
