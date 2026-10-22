package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityWebviewGiftBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ProgressBar f35516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MyWebView f11669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceV2VM f11670a;

    public RunActivityWebviewGiftBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout drawerLayout, LayoutToolbarBindingBinding toolbar, MyWebView webView, ProgressBar webViewProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11667a = drawerLayout;
        this.f11668a = toolbar;
        this.f11669a = webView;
        this.f35516a = webViewProgressbar;
    }

    public static RunActivityWebviewGiftBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityWebviewGiftBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityWebviewGiftBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_webview_gift);
    }

    @NonNull
    public static RunActivityWebviewGiftBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityWebviewGiftBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityWebviewGiftBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityWebviewGiftBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_webview_gift, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityWebviewGiftBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityWebviewGiftBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_webview_gift, null, false, component);
    }

    @Nullable
    public GeoFenceV2VM f() {
        return this.f11670a;
    }

    public abstract void k(@Nullable GeoFenceV2VM vm);
}
