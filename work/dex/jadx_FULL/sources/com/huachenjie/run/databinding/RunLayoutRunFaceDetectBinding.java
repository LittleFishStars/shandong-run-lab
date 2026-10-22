package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunFaceDetectBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailActivity.a f12129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12130a;

    public RunLayoutRunFaceDetectBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFaceImg, TextView tvViewFaceRule) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12128a = rvFaceImg;
        this.f35685a = tvViewFaceRule;
    }

    public static RunLayoutRunFaceDetectBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunFaceDetectBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunFaceDetectBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_face_detect);
    }

    @NonNull
    public static RunLayoutRunFaceDetectBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunFaceDetectBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunFaceDetectBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunFaceDetectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_face_detect, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunFaceDetectBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunFaceDetectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_face_detect, null, false, component);
    }

    @Nullable
    public RunDetailActivity.a f() {
        return this.f12129a;
    }

    @Nullable
    public RunDetailVM g() {
        return this.f12130a;
    }

    public abstract void l(@Nullable RunDetailActivity.a click);

    public abstract void m(@Nullable RunDetailVM vm);
}
