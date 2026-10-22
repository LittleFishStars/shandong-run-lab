package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f32837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceVM f7052a;

    public FragmentDetectFaceBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32837a = flContainer;
    }

    public static FragmentDetectFaceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face);
    }

    @NonNull
    public static FragmentDetectFaceBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face, null, false, component);
    }

    @Nullable
    public DetectFaceVM f() {
        return this.f7052a;
    }

    public abstract void k(@Nullable DetectFaceVM vm);
}
