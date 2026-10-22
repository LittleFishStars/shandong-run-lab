package com.huachenjie.common.webview;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.databinding.ActivityWebviewBinding;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.common.webview.WebViewActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.i62;
import com.zj.adlib.k94;
import com.zj.adlib.ov5;
import com.zj.adlib.sh9;
import com.zj.adlib.ti4;
import com.zj.adlib.vk0;
import com.zj.adlib.vo6;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = RoutePathConstants.Common.c)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0006\u0010\u000b\u001a\u00020\u0004J\f\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J4\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00170\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0002R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u00101¨\u00066"}, d2 = {"Lcom/huachenjie/common/webview/WebViewActivity;", "T", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/webview/WebViewVM;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initWebView", "Ljava/lang/Class;", "m0", "Landroid/webkit/WebView;", "webview", "l0", "view", "", "url", "w0", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "s0", "initViewModel", "onPause", "onResume", "onBackPressed", "onDestroy", "Landroid/content/res/Configuration;", "config", "onConfigurationChanged", "r0", "q0", bo.g, "origin", "Landroid/webkit/GeolocationPermissions$Callback;", RenderCallContext.TYPE_CALLBACK, "t0", "", "progress", "v0", "x", "Ljava/lang/String;", "title", "y", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public class WebViewActivity<T> extends BaseVmActivity<WebViewVM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "title")
    @JvmField
    @Nullable
    public String title;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Autowired(name = "url")
    @JvmField
    @Nullable
    public String url;

    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J4\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00150\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001f¨\u0006!"}, d2 = {"com/huachenjie/common/webview/WebViewActivity$a", "Lcom/zj/adlib/k94;", "Landroid/webkit/WebView;", "view", "", "newProgress", "", "onProgressChanged", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", RenderCallContext.TYPE_CALLBACK, "onShowCustomView", "onHideCustomView", "", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "onGeolocationPermissionsShowPrompt", "newTitle", "onReceivedTitle", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "a", "Landroid/view/View;", "mCustomView", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "mCustomViewCallback", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends k94 {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public View mCustomView;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public WebChromeClient.CustomViewCallback mCustomViewCallback;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ActivityWebviewBinding f8975a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WebViewActivity<T> f8976a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WebViewActivity<T> webViewActivity, ActivityWebviewBinding activityWebviewBinding, Class<?> cls) {
            super(webViewActivity, "jsInterface", cls);
            this.f8976a = webViewActivity;
            this.f8975a = activityWebviewBinding;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(@NotNull String origin, @NotNull GeolocationPermissions.Callback callback) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            this.f8976a.t0(origin, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            this.f8975a.f8593a.setVisibility(0);
            View view = this.mCustomView;
            if (view == null) {
                return;
            }
            Intrinsics.checkNotNull(view);
            view.setVisibility(8);
            this.f8975a.f8591a.removeView(this.mCustomView);
            WebChromeClient.CustomViewCallback customViewCallback = this.mCustomViewCallback;
            Intrinsics.checkNotNull(customViewCallback);
            customViewCallback.onCustomViewHidden();
            this.mCustomView = null;
            this.f8976a.setRequestedOrientation(1);
            super.onHideCustomView();
        }

        @Override // com.zj.adlib.k94, android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView view, int newProgress) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onProgressChanged(view, newProgress);
            this.f8976a.v0(newProgress);
        }

        @Override // com.zj.adlib.k94, android.webkit.WebChromeClient
        public void onReceivedTitle(@Nullable WebView view, @Nullable String newTitle) {
            if (!TextUtils.isEmpty(this.f8976a.title) || TextUtils.isEmpty(newTitle)) {
                return;
            }
            BindingTitleBean value = ((WebViewVM) ((BaseVmActivity) this.f8976a).f8507a).h().getValue();
            if (value != null) {
                value.setTitleName(newTitle);
            }
            ((WebViewVM) ((BaseVmActivity) this.f8976a).f8507a).h().setValue(value);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(@NotNull View view, @NotNull WebChromeClient.CustomViewCallback callback) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            super.onShowCustomView(view, callback);
            if (this.mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            this.mCustomView = view;
            this.f8975a.f8591a.addView(view);
            this.mCustomViewCallback = callback;
            this.f8975a.f8593a.setVisibility(8);
            this.f8976a.setRequestedOrientation(0);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
            Intrinsics.checkNotNullParameter(filePathCallback, "filePathCallback");
            return this.f8976a.s0(webView, filePathCallback, fileChooserParams);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/common/webview/WebViewActivity$b", "Lcom/zj/adlib/ov5;", "Landroid/webkit/WebView;", "view", "", "url", "", "onPageFinished", "", "shouldOverrideUrlLoading", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends ov5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityWebviewBinding f33967a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WebViewActivity<T> f8977a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebViewActivity<T> webViewActivity, ActivityWebviewBinding activityWebviewBinding) {
            super(webViewActivity);
            this.f8977a = webViewActivity;
            this.f33967a = activityWebviewBinding;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            String title = Intrinsics.areEqual(view.getTitle(), url) ? "" : view.getTitle();
            String str = sh9.k(title, true) ? "" : title;
            MutableLiveData<BindingTitleBean> mutableLiveDataH = ((WebViewVM) ((BaseVmActivity) this.f8977a).f8507a).h();
            BindingTitleBean value = ((WebViewVM) ((BaseVmActivity) this.f8977a).f8507a).h().getValue();
            if (value != null) {
                WebViewActivity<T> webViewActivity = this.f8977a;
                if (!TextUtils.isEmpty(webViewActivity.title)) {
                    str = webViewActivity.title;
                }
                value.setTitleName(str);
            } else {
                value = null;
            }
            mutableLiveDataH.setValue(value);
            this.f33967a.f33745a.setVisibility(8);
        }

        @Override // com.zj.adlib.ov5, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable String url) {
            this.f8977a.w0(view, url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    public static final void n0(WebViewActivity webViewActivity, View view) {
        Intrinsics.checkNotNullParameter(webViewActivity, "this$0");
        webViewActivity.onBackPressed();
    }

    public static final void o0(WebViewActivity webViewActivity, View view) {
        Intrinsics.checkNotNullParameter(webViewActivity, "this$0");
        webViewActivity.finish();
    }

    public static final void u0(GeolocationPermissions.Callback callback, String str, boolean z) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(str, "$origin");
        callback.invoke(str, z, false);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.transparent).G1(true).q1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_webview), Integer.valueOf(vk0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        String str;
        MutableLiveData<BindingTitleBean> mutableLiveDataH = ((WebViewVM) ((BaseVmActivity) this).f8507a).h();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((WebViewVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean backIconResId = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackShow(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.uu9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewActivity.n0(this.f45230a, view);
            }
        }).setBackIconResId(R.drawable.ic_back_black);
        int i = R.color.color_2C3E50;
        BindingTitleBean titleTextColor = backIconResId.setBackTintColor(Integer.valueOf(zn1.a(i))).setLeftSubIconShow(true).setLeftSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.vu9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewActivity.o0(this.f45457a, view);
            }
        }).setLeftSubIconResId(R.drawable.ic_home).setLeftSubIconTintColor(Integer.valueOf(zn1.a(i))).setTitleTextColor(zn1.a(i));
        if (TextUtils.isEmpty(this.title)) {
            str = "";
        } else {
            str = this.title;
            Intrinsics.checkNotNull(str);
        }
        mutableLiveDataH.setValue(titleTextColor.setTitleName(str));
        initWebView();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void initWebView() {
        q0();
        p0();
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.ActivityWebviewBinding");
        MyWebView myWebView = ((ActivityWebviewBinding) binding).f8593a;
        Intrinsics.checkNotNullExpressionValue(myWebView, "binding as ActivityWebviewBinding).webView");
        l0(myWebView);
        r0();
    }

    public void l0(@NotNull WebView webview) {
        Intrinsics.checkNotNullParameter(webview, "webview");
    }

    @NotNull
    public Class<?> m0() {
        return ti4.class;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MyWebView myWebView;
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) getBinding();
        boolean z = false;
        if (activityWebviewBinding != null && (myWebView = activityWebviewBinding.f8593a) != null && myWebView.canGoBack()) {
            z = true;
        }
        if (z) {
            activityWebviewBinding.f8593a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.onConfigurationChanged(config);
        int i = config.orientation;
        if (i == 1) {
            getWindow().clearFlags(1024);
            getWindow().addFlags(2048);
        } else {
            if (i != 2) {
                return;
            }
            getWindow().clearFlags(2048);
            getWindow().addFlags(1024);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MyWebView myWebView;
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) getBinding();
        if (activityWebviewBinding != null && (myWebView = activityWebviewBinding.f8593a) != null) {
            myWebView.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        MyWebView myWebView;
        super.onPause();
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) getBinding();
        if (activityWebviewBinding == null || (myWebView = activityWebviewBinding.f8593a) == null) {
            return;
        }
        myWebView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MyWebView myWebView;
        super.onResume();
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) getBinding();
        if (activityWebviewBinding == null || (myWebView = activityWebviewBinding.f8593a) == null) {
            return;
        }
        myWebView.onResume();
    }

    public final void p0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.ActivityWebviewBinding");
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) binding;
        activityWebviewBinding.f8593a.setWebChromeClient(new a(this, activityWebviewBinding, m0()));
    }

    public final void q0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.ActivityWebviewBinding");
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) binding;
        activityWebviewBinding.f8593a.setWebViewClient(new b(this, activityWebviewBinding));
    }

    public final void r0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.ActivityWebviewBinding");
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) binding;
        if (TextUtils.isEmpty(this.url)) {
            return;
        }
        String str = this.url;
        Intrinsics.checkNotNull(str);
        if (StringsKt.startsWith$default(str, "file:///android_asset", false, 2, (Object) null)) {
            activityWebviewBinding.f8593a.setAllowFileAccess(true);
            activityWebviewBinding.f8593a.setSupportZoom(true);
        }
        MyWebView myWebView = activityWebviewBinding.f8593a;
        String str2 = this.url;
        Intrinsics.checkNotNull(str2);
        myWebView.loadUrl(str2);
    }

    public boolean s0(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        Intrinsics.checkNotNullParameter(filePathCallback, "filePathCallback");
        return false;
    }

    public final void t0(final String origin, final GeolocationPermissions.Callback callback) {
        vo6.k(this, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}), CollectionsKt.listOf("为了能根据您的位置用于展示附近的信息，我们需要获取您的位置权限"), new PermissionResultListener() { // from class: com.zj.adlib.tu9
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                WebViewActivity.u0(callback, origin, z);
            }
        });
    }

    public final void v0(int progress) {
        ActivityWebviewBinding activityWebviewBinding = (ActivityWebviewBinding) getBinding();
        ProgressBar progressBar = activityWebviewBinding != null ? activityWebviewBinding.f33745a : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(progress);
    }

    public void w0(@Nullable WebView view, @Nullable String url) {
    }
}
