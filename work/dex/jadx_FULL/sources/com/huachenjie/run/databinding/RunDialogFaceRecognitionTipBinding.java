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
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.FaceRecognitionTipDialog;
import com.huachenjie.run.dialog.FaceRecognitionTipViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogFaceRecognitionTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FaceRecognitionTipDialog.a f11695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FaceRecognitionTipViewModel f11696a;

    public RunDialogFaceRecognitionTipBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvDesc) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35527a = tvDesc;
    }

    public static RunDialogFaceRecognitionTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogFaceRecognitionTipBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogFaceRecognitionTipBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_face_recognition_tip);
    }

    @NonNull
    public static RunDialogFaceRecognitionTipBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogFaceRecognitionTipBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogFaceRecognitionTipBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogFaceRecognitionTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_face_recognition_tip, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogFaceRecognitionTipBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogFaceRecognitionTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_face_recognition_tip, null, false, component);
    }

    @Nullable
    public FaceRecognitionTipDialog.a f() {
        return this.f11695a;
    }

    @Nullable
    public FaceRecognitionTipViewModel g() {
        return this.f11696a;
    }

    public abstract void l(@Nullable FaceRecognitionTipDialog.a click);

    public abstract void m(@Nullable FaceRecognitionTipViewModel vm);
}
