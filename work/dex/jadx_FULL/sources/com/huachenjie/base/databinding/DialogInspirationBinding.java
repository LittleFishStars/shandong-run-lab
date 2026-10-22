package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.inspiration.InspirationDialog;
import com.huachenjie.base.dialog.inspiration.InspirationVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class DialogInspirationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f6998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationDialog.a f6999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationVM f7000a;

    @NonNull
    public final ImageView b;

    public DialogInspirationBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivBg, ImageView ivClose, LinearLayout llContent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32817a = ivBg;
        this.b = ivClose;
        this.f6998a = llContent;
    }

    public static DialogInspirationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogInspirationBinding d(@NonNull View view, @Nullable Object component) {
        return (DialogInspirationBinding) ViewDataBinding.bind(component, view, R.layout.dialog_inspiration);
    }

    @NonNull
    public static DialogInspirationBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogInspirationBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogInspirationBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogInspirationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_inspiration, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static DialogInspirationBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogInspirationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_inspiration, null, false, component);
    }

    @Nullable
    public InspirationDialog.a f() {
        return this.f6999a;
    }

    @Nullable
    public InspirationVM g() {
        return this.f7000a;
    }

    public abstract void l(@Nullable InspirationDialog.a click);

    public abstract void m(@Nullable InspirationVM vm);
}
