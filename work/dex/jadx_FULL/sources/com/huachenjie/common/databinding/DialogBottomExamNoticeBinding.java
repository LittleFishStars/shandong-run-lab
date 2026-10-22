package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class DialogBottomExamNoticeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f8614a;

    @NonNull
    public final TextView b;

    public DialogBottomExamNoticeBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvConfirm, TextView tvRule) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f33750a = tvConfirm;
        this.b = tvRule;
    }

    public static DialogBottomExamNoticeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBottomExamNoticeBinding d(@NonNull View view, @Nullable Object component) {
        return (DialogBottomExamNoticeBinding) ViewDataBinding.bind(component, view, R.layout.dialog_bottom_exam_notice);
    }

    @NonNull
    public static DialogBottomExamNoticeBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogBottomExamNoticeBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogBottomExamNoticeBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogBottomExamNoticeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_bottom_exam_notice, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static DialogBottomExamNoticeBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogBottomExamNoticeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_bottom_exam_notice, null, false, component);
    }

    @Nullable
    public BaseVM f() {
        return this.f8614a;
    }

    public abstract void k(@Nullable BaseVM vm);
}
