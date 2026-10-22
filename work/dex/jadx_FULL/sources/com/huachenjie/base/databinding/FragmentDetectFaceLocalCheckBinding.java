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
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceLocalCheckBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PreviewView f7067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceAuthVM f7068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7070a;

    @NonNull
    public final TextView b;

    public FragmentDetectFaceLocalCheckBinding(Object _bindingComponent, View _root, int _localFieldCount, PreviewView mPreviewView, View roundRect, LayoutToolbarBindingBinding titleBar, TextView tvActionTips, TextView tvBottomTip, BLTextView tvCountdown) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7067a = mPreviewView;
        this.f32842a = roundRect;
        this.f7069a = titleBar;
        this.f7066a = tvActionTips;
        this.b = tvBottomTip;
        this.f7070a = tvCountdown;
    }

    public static FragmentDetectFaceLocalCheckBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceLocalCheckBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceLocalCheckBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face_local_check);
    }

    @NonNull
    public static FragmentDetectFaceLocalCheckBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceLocalCheckBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceLocalCheckBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceLocalCheckBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_local_check, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceLocalCheckBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceLocalCheckBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_local_check, null, false, component);
    }

    @Nullable
    public DetectFaceAuthVM f() {
        return this.f7068a;
    }

    public abstract void k(@Nullable DetectFaceAuthVM vm);
}
