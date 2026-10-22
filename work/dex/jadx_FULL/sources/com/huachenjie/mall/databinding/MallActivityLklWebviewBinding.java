package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityLklWebviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebView f34802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10242a;

    public MallActivityLklWebviewBinding(Object obj, View view, int i, WebView webView) {
        super(obj, view, i);
        this.f34802a = webView;
    }

    public static MallActivityLklWebviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityLklWebviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityLklWebviewBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_lkl_webview);
    }

    @NonNull
    public static MallActivityLklWebviewBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityLklWebviewBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityLklWebviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityLklWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_lkl_webview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityLklWebviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityLklWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_lkl_webview, null, false, obj);
    }

    @Nullable
    public BaseTitleViewModel f() {
        return this.f10242a;
    }

    public abstract void k(@Nullable BaseTitleViewModel baseTitleViewModel);
}
