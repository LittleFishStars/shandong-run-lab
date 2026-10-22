package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.RunRecordFaceThumb;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemRunRecordFaceThumbBindingImpl extends RunItemRunRecordFaceThumbBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35630a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11962a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11966a;

    public RunItemRunRecordFaceThumbBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11962a, f35630a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String strF;
        synchronized (this) {
            j = this.f11963a;
            this.f11963a = 0L;
        }
        RunRecordFaceThumb runRecordFaceThumb = ((RunItemRunRecordFaceThumbBinding) this).f35629a;
        long j2 = j & 3;
        String strE = null;
        if (j2 != 0) {
            requestOptions = RunDetailFaceCheckInfoBean.rounded12;
            if (runRecordFaceThumb != null) {
                strF = runRecordFaceThumb.f();
                strE = runRecordFaceThumb.e();
            } else {
                strF = null;
            }
        } else {
            requestOptions = null;
            strF = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f11964a, strE, requestOptions, false);
            TextViewBindingAdapter.setText(this.f11966a, strF);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11963a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11963a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunRecordFaceThumbBinding
    public void k(@Nullable RunRecordFaceThumb Bean) {
        ((RunItemRunRecordFaceThumbBinding) this).f35629a = Bean;
        synchronized (this) {
            this.f11963a |= 1;
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
        k((RunRecordFaceThumb) variable);
        return true;
    }

    public RunItemRunRecordFaceThumbBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f11963a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11965a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f11964a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f11966a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
