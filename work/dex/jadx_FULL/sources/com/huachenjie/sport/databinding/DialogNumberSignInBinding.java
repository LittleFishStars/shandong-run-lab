package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.PinEntryEditText;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.signin.NumberSignInDialog;
import com.huachenjie.sport.page.mine.signin.NumberSignInVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogNumberSignInBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PinEntryEditText f13403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NumberSignInDialog.c f13404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NumberSignInVM f13405a;

    @NonNull
    public final TextView b;

    public DialogNumberSignInBinding(Object obj, View view, int i, PinEntryEditText pinEntryEditText, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f13403a = pinEntryEditText;
        this.f36450a = textView;
        this.b = textView2;
    }

    public static DialogNumberSignInBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNumberSignInBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogNumberSignInBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_number_sign_in);
    }

    @NonNull
    public static DialogNumberSignInBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogNumberSignInBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogNumberSignInBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogNumberSignInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_sign_in, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogNumberSignInBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogNumberSignInBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_number_sign_in, null, false, obj);
    }

    @Nullable
    public NumberSignInDialog.c f() {
        return this.f13404a;
    }

    @Nullable
    public NumberSignInVM g() {
        return this.f13405a;
    }

    public abstract void l(@Nullable NumberSignInDialog.c cVar);

    public abstract void m(@Nullable NumberSignInVM numberSignInVM);
}
