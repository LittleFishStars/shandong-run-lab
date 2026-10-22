package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.CancelAccountActivity;
import com.huachenjie.compat.page.account.CancelAccountVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityCancelAccountBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f9052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelAccountActivity.a f9055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelAccountVM f9056a;

    @NonNull
    public final EditText b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9057b;

    @NonNull
    public final TextView c;

    public ActivityCancelAccountBinding(Object obj, View view, int i, EditText editText, EditText editText2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.f9052a = editText;
        this.b = editText2;
        this.f9053a = linearLayout;
        this.f9054a = textView;
        this.f9057b = textView2;
        this.c = textView3;
        this.f34010a = view2;
    }

    public static ActivityCancelAccountBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCancelAccountBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityCancelAccountBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cancel_account);
    }

    @NonNull
    public static ActivityCancelAccountBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityCancelAccountBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCancelAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCancelAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account, null, false, obj);
    }

    @Nullable
    public CancelAccountActivity.a f() {
        return this.f9055a;
    }

    @Nullable
    public CancelAccountVM g() {
        return this.f9056a;
    }

    public abstract void l(@Nullable CancelAccountActivity.a aVar);

    public abstract void m(@Nullable CancelAccountVM cancelAccountVM);
}
