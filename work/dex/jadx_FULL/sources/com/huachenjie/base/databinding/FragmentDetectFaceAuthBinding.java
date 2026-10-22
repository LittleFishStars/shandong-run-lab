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
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceAuthBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PreviewView f7041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceAuthFragment.a f7042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceAuthVM f7043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7045a;

    @NonNull
    public final TextView b;

    public FragmentDetectFaceAuthBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btCommit, PreviewView mPreviewView, View roundRect, LayoutToolbarBindingBinding titleBar, TextView tvCountdown, TextView tvTips) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7045a = btCommit;
        this.f7041a = mPreviewView;
        this.f32834a = roundRect;
        this.f7044a = titleBar;
        this.f7040a = tvCountdown;
        this.b = tvTips;
    }

    public static FragmentDetectFaceAuthBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceAuthBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceAuthBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face_auth);
    }

    @NonNull
    public static FragmentDetectFaceAuthBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceAuthBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceAuthBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceAuthBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_auth, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceAuthBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceAuthBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_auth, null, false, component);
    }

    @Nullable
    public DetectFaceAuthFragment.a f() {
        return this.f7042a;
    }

    @Nullable
    public DetectFaceAuthVM g() {
        return this.f7043a;
    }

    public abstract void l(@Nullable DetectFaceAuthFragment.a click);

    public abstract void m(@Nullable DetectFaceAuthVM vm);
}
