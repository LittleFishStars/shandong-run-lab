package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectLastFaceFragment;
import com.huachenjie.base.aliyun.detect_face.DetectLastFaceVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectLaseFaceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectLastFaceFragment.a f7092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectLastFaceVM f7093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7095a;

    @NonNull
    public final BLTextView b;

    public FragmentDetectLaseFaceBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btCommit, BLTextView btReUpload, View roundRect, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7095a = btCommit;
        this.b = btReUpload;
        this.f32851a = roundRect;
        this.f7094a = titleBar;
    }

    public static FragmentDetectLaseFaceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectLaseFaceBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectLaseFaceBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_lase_face);
    }

    @NonNull
    public static FragmentDetectLaseFaceBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectLaseFaceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectLaseFaceBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectLaseFaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_lase_face, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectLaseFaceBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectLaseFaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_lase_face, null, false, component);
    }

    @Nullable
    public DetectLastFaceFragment.a f() {
        return this.f7092a;
    }

    @Nullable
    public DetectLastFaceVM g() {
        return this.f7093a;
    }

    public abstract void l(@Nullable DetectLastFaceFragment.a click);

    public abstract void m(@Nullable DetectLastFaceVM vm);
}
