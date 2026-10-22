package com.huachenjie.run.databinding;

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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemRunFaceDetectBindingImpl extends RunItemRunFaceDetectBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35628a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11957a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11961a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public RunItemRunFaceDetectBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f11957a, f35628a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String runFaceImg;
        String str2;
        synchronized (this) {
            j = this.f11958a;
            this.f11958a = 0L;
        }
        RunDetailFaceCheckInfoBean runDetailFaceCheckInfoBean = ((RunItemRunFaceDetectBinding) this).f35627a;
        long j2 = j & 3;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = RunDetailFaceCheckInfoBean.rounded12;
            if (runDetailFaceCheckInfoBean != null) {
                String str4 = runDetailFaceCheckInfoBean.formatterPopTime();
                str = runDetailFaceCheckInfoBean.formatterCheckDistance();
                String imgName = runDetailFaceCheckInfoBean.getImgName();
                runFaceImg = runDetailFaceCheckInfoBean.getRunFaceImg();
                str2 = str4;
                str3 = imgName;
            } else {
                str = null;
            }
            if (j2 != 0) {
                TextViewBindingAdapter.setText(this.f11961a, str3);
                CommonBindingAdapter.b0(this.f11959a, runFaceImg, requestOptions, false);
                TextViewBindingAdapter.setText(this.b, str);
                TextViewBindingAdapter.setText(this.c, str2);
            }
        }
        requestOptions = null;
        str = null;
        runFaceImg = str;
        str2 = runFaceImg;
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f11961a, str3);
            CommonBindingAdapter.b0(this.f11959a, runFaceImg, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.c, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11958a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11958a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunFaceDetectBinding
    public void k(@Nullable RunDetailFaceCheckInfoBean Bean) {
        ((RunItemRunFaceDetectBinding) this).f35627a = Bean;
        synchronized (this) {
            this.f11958a |= 1;
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
        k((RunDetailFaceCheckInfoBean) variable);
        return true;
    }

    public RunItemRunFaceDetectBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f11958a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11960a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11961a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.f11959a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[4];
        this.c = textView3;
        textView3.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
