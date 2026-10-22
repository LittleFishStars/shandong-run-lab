package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ViewItemImagePickAddBindingImpl extends ViewItemImagePickAddBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32875a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7141a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7144a;

    public ViewItemImagePickAddBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f7141a, f32875a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7142a;
            this.f7142a = 0L;
        }
        ImagePickBean imagePickBean = ((ViewItemImagePickAddBinding) this).f32874a;
        long j2 = j & 3;
        String addTip = (j2 == 0 || imagePickBean == null) ? null : imagePickBean.getAddTip();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f7143a, addTip);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7142a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7142a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.ViewItemImagePickAddBinding
    public void k(@Nullable ImagePickBean Bean) {
        ((ViewItemImagePickAddBinding) this).f32874a = Bean;
        synchronized (this) {
            this.f7142a |= 1;
        }
        notifyPropertyChanged(sk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.g != variableId) {
            return false;
        }
        k((ImagePickBean) variable);
        return true;
    }

    public ViewItemImagePickAddBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f7142a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f7144a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f7143a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
