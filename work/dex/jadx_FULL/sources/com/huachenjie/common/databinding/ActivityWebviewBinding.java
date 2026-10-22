package com.huachenjie.common.databinding;

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
import com.huachenjie.common.R;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.common.webview.WebViewVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ActivityWebviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ProgressBar f33745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f8592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MyWebView f8593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WebViewVM f8594a;

    public ActivityWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout rlRoot, LayoutToolbarBindingBinding toolbar, MyWebView webView, ProgressBar webViewProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f8591a = rlRoot;
        this.f8592a = toolbar;
        this.f8593a = webView;
        this.f33745a = webViewProgressbar;
    }

    public static ActivityWebviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebviewBinding d(@NonNull View view, @Nullable Object component) {
        return (ActivityWebviewBinding) ViewDataBinding.bind(component, view, R.layout.activity_webview);
    }

    @NonNull
    public static ActivityWebviewBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityWebviewBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityWebviewBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ActivityWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_webview, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static ActivityWebviewBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ActivityWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_webview, null, false, component);
    }

    @Nullable
    public WebViewVM f() {
        return this.f8594a;
    }

    public abstract void k(@Nullable WebViewVM vm);
}
