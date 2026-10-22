package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.open_oaid.OpenOaidDialog;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.noober.background.view.BLFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class DialogOpenOaidBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OpenOaidDialog.a f7025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f7026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f7027a;

    public DialogOpenOaidBinding(Object _bindingComponent, View _root, int _localFieldCount, BLFrameLayout flCenterContainer, ImageView ivTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7027a = flCenterContainer;
        this.f32827a = ivTip;
    }

    public static DialogOpenOaidBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogOpenOaidBinding d(@NonNull View view, @Nullable Object component) {
        return (DialogOpenOaidBinding) ViewDataBinding.bind(component, view, R.layout.dialog_open_oaid);
    }

    @NonNull
    public static DialogOpenOaidBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogOpenOaidBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogOpenOaidBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogOpenOaidBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_open_oaid, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static DialogOpenOaidBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogOpenOaidBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_open_oaid, null, false, component);
    }

    @Nullable
    public OpenOaidDialog.a f() {
        return this.f7025a;
    }

    @Nullable
    public BaseVM g() {
        return this.f7026a;
    }

    public abstract void l(@Nullable OpenOaidDialog.a click);

    public abstract void m(@Nullable BaseVM vm);
}
