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
import com.huachenjie.base.aliyun.detect_face.DetectFaceNoticeFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceNoticeVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class FragmentDetectFaceNoticeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public DetectFaceNoticeFragment.a f32844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetectFaceNoticeVM f7074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7075a;

    public FragmentDetectFaceNoticeBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btCommit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7075a = btCommit;
    }

    public static FragmentDetectFaceNoticeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDetectFaceNoticeBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentDetectFaceNoticeBinding) ViewDataBinding.bind(component, view, R.layout.fragment_detect_face_notice);
    }

    @NonNull
    public static FragmentDetectFaceNoticeBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentDetectFaceNoticeBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceNoticeBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentDetectFaceNoticeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_notice, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentDetectFaceNoticeBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentDetectFaceNoticeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_detect_face_notice, null, false, component);
    }

    @Nullable
    public DetectFaceNoticeFragment.a f() {
        return this.f32844a;
    }

    @Nullable
    public DetectFaceNoticeVM g() {
        return this.f7074a;
    }

    public abstract void l(@Nullable DetectFaceNoticeFragment.a click);

    public abstract void m(@Nullable DetectFaceNoticeVM vm);
}
