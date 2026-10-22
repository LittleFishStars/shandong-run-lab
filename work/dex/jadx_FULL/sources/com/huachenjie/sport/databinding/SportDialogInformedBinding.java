package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog;
import com.huachenjie.sport.page.mine.sport_test.informed.InformedVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class SportDialogInformedBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebView f36547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InformedDialog.a f13691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InformedVM f13692a;

    public SportDialogInformedBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, WebView webView) {
        super(obj, view, i);
        this.f13689a = linearLayout;
        this.f13690a = textView;
        this.f36547a = webView;
    }

    public static SportDialogInformedBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SportDialogInformedBinding d(@NonNull View view, @Nullable Object obj) {
        return (SportDialogInformedBinding) ViewDataBinding.bind(obj, view, R.layout.sport_dialog_informed);
    }

    @NonNull
    public static SportDialogInformedBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SportDialogInformedBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SportDialogInformedBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SportDialogInformedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.sport_dialog_informed, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static SportDialogInformedBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SportDialogInformedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.sport_dialog_informed, null, false, obj);
    }

    @Nullable
    public InformedDialog.a f() {
        return this.f13691a;
    }

    @Nullable
    public InformedVM g() {
        return this.f13692a;
    }

    public abstract void l(@Nullable InformedDialog.a aVar);

    public abstract void m(@Nullable InformedVM informedVM);
}
