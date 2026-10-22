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
import com.zj.adlib.RunRecordFaceThumb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemRunRecordFaceThumbBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunRecordFaceThumb f35629a;

    public RunItemRunRecordFaceThumbBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunItemRunRecordFaceThumbBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemRunRecordFaceThumbBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemRunRecordFaceThumbBinding) ViewDataBinding.bind(component, view, R.layout.run_item_run_record_face_thumb);
    }

    @NonNull
    public static RunItemRunRecordFaceThumbBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemRunRecordFaceThumbBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemRunRecordFaceThumbBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemRunRecordFaceThumbBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_record_face_thumb, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemRunRecordFaceThumbBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemRunRecordFaceThumbBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_record_face_thumb, null, false, component);
    }

    @Nullable
    public RunRecordFaceThumb f() {
        return this.f35629a;
    }

    public abstract void k(@Nullable RunRecordFaceThumb bean);
}
