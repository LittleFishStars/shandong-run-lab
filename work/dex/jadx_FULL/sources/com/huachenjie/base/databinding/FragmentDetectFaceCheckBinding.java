package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceCheckBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PreviewView f7057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceAuthVM f7058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceCheckFragment.a f7059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7061a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public FragmentDetectFaceCheckBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btCommit, ImageView ivFaceCheckTip, PreviewView mPreviewView, View roundRect, LayoutToolbarBindingBinding titleBar, TextView tvBottomTip, TextView tvCountdown, TextView tvTips) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7061a = btCommit;
        this.f7055a = ivFaceCheckTip;
        this.f7057a = mPreviewView;
        this.f32839a = roundRect;
        this.f7060a = titleBar;
        this.f7056a = tvBottomTip;
        this.b = tvCountdown;
        this.c = tvTips;
    }

    public static FragmentDetectFaceCheckBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceCheckBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceCheckBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face_check);
    }

    @NonNull
    public static FragmentDetectFaceCheckBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceCheckBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceCheckBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceCheckBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_check, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceCheckBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceCheckBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_check, null, false, component);
    }

    @Nullable
    public DetectFaceCheckFragment.a f() {
        return this.f7059a;
    }

    @Nullable
    public DetectFaceAuthVM g() {
        return this.f7058a;
    }

    public abstract void l(@Nullable DetectFaceCheckFragment.a click);

    public abstract void m(@Nullable DetectFaceAuthVM vm);
}
