package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.CancelAccountTipActivity;
import com.huachenjie.compat.page.account.CancelAccountTipVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityCancelAccountTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f34019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelAccountTipActivity.a f9073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelAccountTipVM f9074a;

    @NonNull
    public final TextView b;

    public ActivityCancelAccountTipBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34019a = linearLayout;
        this.f9072a = textView;
        this.b = textView2;
    }

    public static ActivityCancelAccountTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCancelAccountTipBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityCancelAccountTipBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cancel_account_tip);
    }

    @NonNull
    public static ActivityCancelAccountTipBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityCancelAccountTipBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountTipBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCancelAccountTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account_tip, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountTipBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCancelAccountTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account_tip, null, false, obj);
    }

    @Nullable
    public CancelAccountTipActivity.a f() {
        return this.f9073a;
    }

    @Nullable
    public CancelAccountTipVM g() {
        return this.f9074a;
    }

    public abstract void l(@Nullable CancelAccountTipActivity.a aVar);

    public abstract void m(@Nullable CancelAccountTipVM cancelAccountTipVM);
}
