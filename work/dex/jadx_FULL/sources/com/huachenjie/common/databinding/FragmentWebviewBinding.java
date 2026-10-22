package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.webview.MyWebView;
import com.huachenjie.common.webview.WebViewFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class FragmentWebviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MyWebView f8638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WebViewFragment.a f8639a;

    public FragmentWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivBack, MyWebView webView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f33759a = ivBack;
        this.f8638a = webView;
    }

    public static FragmentWebviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding d(@NonNull View view, @Nullable Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.bind(component, view, R.layout.fragment_webview);
    }

    @NonNull
    public static FragmentWebviewBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentWebviewBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentWebviewBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static FragmentWebviewBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, null, false, component);
    }

    @Nullable
    public WebViewFragment.a f() {
        return this.f8639a;
    }

    public abstract void k(@Nullable WebViewFragment.a click);
}
