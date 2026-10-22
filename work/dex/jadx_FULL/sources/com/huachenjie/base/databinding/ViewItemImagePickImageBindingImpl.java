package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.R;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ViewItemImagePickImageBindingImpl extends ViewItemImagePickImageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7147a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7149a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32877a = sparseIntArray;
        sparseIntArray.put(R.id.iv_delete, 2);
    }

    public ViewItemImagePickImageBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f7147a, f32877a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f7148a;
            this.f7148a = 0L;
        }
        ImagePickBean imagePickBean = ((ViewItemImagePickImageBinding) this).f7146a;
        long j2 = j & 3;
        String localPath = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (imagePickBean != null) {
                localPath = imagePickBean.getLocalPath();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ViewItemImagePickImageBinding) this).f7145a, localPath, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7148a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7148a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.ViewItemImagePickImageBinding
    public void k(@Nullable ImagePickBean Bean) {
        ((ViewItemImagePickImageBinding) this).f7146a = Bean;
        synchronized (this) {
            this.f7148a |= 1;
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

    public ViewItemImagePickImageBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RoundImageView) bindings[1], (ImageView) bindings[2]);
        this.f7148a = -1L;
        ((ViewItemImagePickImageBinding) this).f7145a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f7149a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
