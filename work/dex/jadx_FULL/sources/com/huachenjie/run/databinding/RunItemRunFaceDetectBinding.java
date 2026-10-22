package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemRunFaceDetectBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunDetailFaceCheckInfoBean f35627a;

    public RunItemRunFaceDetectBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunItemRunFaceDetectBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemRunFaceDetectBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemRunFaceDetectBinding) ViewDataBinding.bind(component, view, R.layout.run_item_run_face_detect);
    }

    @NonNull
    public static RunItemRunFaceDetectBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemRunFaceDetectBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemRunFaceDetectBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemRunFaceDetectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_face_detect, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemRunFaceDetectBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemRunFaceDetectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_face_detect, null, false, component);
    }

    @Nullable
    public RunDetailFaceCheckInfoBean f() {
        return this.f35627a;
    }

    public abstract void k(@Nullable RunDetailFaceCheckInfoBean bean);
}
