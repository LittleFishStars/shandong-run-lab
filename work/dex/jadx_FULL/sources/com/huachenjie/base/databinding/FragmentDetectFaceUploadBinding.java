package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceUploadVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceUploadBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PreviewView f7083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceUploadFragment.a f7084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceUploadVM f7085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7087a;

    public FragmentDetectFaceUploadBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btCommit, PreviewView mPreviewView, View roundRect, LayoutToolbarBindingBinding titleBar, TextView tvBottomTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7087a = btCommit;
        this.f7083a = mPreviewView;
        this.f32848a = roundRect;
        this.f7086a = titleBar;
        this.f7082a = tvBottomTip;
    }

    public static FragmentDetectFaceUploadBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceUploadBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceUploadBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face_upload);
    }

    @NonNull
    public static FragmentDetectFaceUploadBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceUploadBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceUploadBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceUploadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_upload, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceUploadBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceUploadBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_upload, null, false, component);
    }

    @Nullable
    public DetectFaceUploadFragment.a f() {
        return this.f7084a;
    }

    @Nullable
    public DetectFaceUploadVM g() {
        return this.f7085a;
    }

    public abstract void l(@Nullable DetectFaceUploadFragment.a click);

    public abstract void m(@Nullable DetectFaceUploadVM vm);
}
