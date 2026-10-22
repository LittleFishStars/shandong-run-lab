package com.kc.aw.widget.web;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.android.arouter.utils.Consts;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class AdvancedWebView extends WebView {
    public WeakReference<Activity> _a;
    public final LinkedList _b;
    public ValueCallback<Uri> _c;
    public ValueCallback<Uri[]> _d;
    public long _e;
    public String _f;
    public int _g;
    public WebViewClient _h;
    public WebChromeClient _i;
    public boolean _j;
    public String _k;
    public final HashMap _l;
    public int _m;
    public boolean _n;
    public long _o;
    public final Handler _p;
    public final _c _q;
    public boolean _r;

    @Keep
    public final class _a extends WebChromeClient {
        public final AdvancedWebView _a;

        public _a(AdvancedWebView advancedWebView) {
            this._a = advancedWebView;
        }

        @Override // android.webkit.WebChromeClient
        public final Bitmap getDefaultVideoPoster() {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }

        @Override // android.webkit.WebChromeClient
        public final View getVideoLoadingProgressView() {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }

        @Override // android.webkit.WebChromeClient
        public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onConsoleMessage(String str, int i, String str2) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(str, i, str2);
            } else {
                super.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            AdvancedWebView advancedWebView = this._a;
            if (advancedWebView._j) {
                callback.invoke(str, true, false);
                return;
            }
            WebChromeClient webChromeClient = advancedWebView._i;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onHideCustomView() {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsTimeout() {
            WebChromeClient webChromeClient = this._a._i;
            return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        public final void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onProgressChanged(webView, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }

        public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view, i, customViewCallback);
            } else {
                super.onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this._a._i;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            this._a._a((ValueCallback<Uri>) null, valueCallback, fileChooserParams.getMode() == 1);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            openFileChooser(valueCallback, null);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            openFileChooser(valueCallback, str, null);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            this._a._a(valueCallback, (ValueCallback<Uri[]>) null, false);
        }
    }

    @Keep
    public final class _b implements DownloadListener {
        public final AdvancedWebView _a;

        public _b(AdvancedWebView advancedWebView) {
            this._a = advancedWebView;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            URLUtil.guessFileName(str, str3, str4);
            this._a.getClass();
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final AdvancedWebView _a;

        public _c(AdvancedWebView advancedWebView) {
            this._a = advancedWebView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdvancedWebView advancedWebView = this._a;
            long j = advancedWebView._o + 1;
            advancedWebView._o = j;
            if (advancedWebView._n && j == 2) {
                advancedWebView._n = false;
                advancedWebView._p.removeCallbacks(this);
                this._a.getClass();
            } else {
                long jUptimeMillis = SystemClock.uptimeMillis();
                AdvancedWebView advancedWebView2 = this._a;
                advancedWebView2._p.postAtTime(advancedWebView2._q, (1000 - (jUptimeMillis % 1000)) + jUptimeMillis);
            }
        }
    }

    @Keep
    public interface _d {
        void _a();

        void _b();
    }

    public AdvancedWebView(Context context) {
        super(context);
        this._b = new LinkedList();
        this._g = 51426;
        this._k = "*/*";
        this._l = new HashMap();
        this._m = 0;
        this._p = new Handler();
        this._q = new _c(this);
        this._r = true;
        _a(context);
    }

    public static String _a(String str) {
        return new String(Base64.decode(str, 0), "UTF-8");
    }

    private int getBackwardSize() {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                return webBackForwardListCopyBackForwardList.getSize();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getLanguageIso3() {
        try {
            return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
        } catch (MissingResourceException unused) {
            return "eng";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0055, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void _a(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == this._g) {
            if (i2 != -1) {
                ValueCallback<Uri> valueCallback = this._c;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this._c = null;
                    return;
                }
                ValueCallback<Uri[]> valueCallback2 = this._d;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this._d = null;
                }
                return;
            }
            if (intent != null) {
                ValueCallback<Uri> valueCallback3 = this._c;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(intent.getData());
                    this._c = null;
                    return;
                }
                if (this._d != null) {
                    try {
                        if (intent.getDataString() != null) {
                            uriArr = new Uri[]{Uri.parse(intent.getDataString())};
                        } else if (intent.getClipData() != null) {
                            int itemCount = intent.getClipData().getItemCount();
                            Uri[] uriArr2 = new Uri[itemCount];
                            for (int i3 = 0; i3 < itemCount; i3++) {
                                try {
                                    uriArr2[i3] = intent.getClipData().getItemAt(i3).getUri();
                                } catch (Exception unused) {
                                }
                            }
                            uriArr = uriArr2;
                        } else {
                            uriArr = null;
                        }
                    } catch (Exception unused2) {
                        uriArr = null;
                    }
                    this._d.onReceiveValue(uriArr);
                    this._d = null;
                }
            }
        }
    }

    public final void _a(Context context) {
        if (isInEditMode()) {
            return;
        }
        if (context instanceof Activity) {
            this._a = new WeakReference<>((Activity) context);
        }
        this._f = getLanguageIso3();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSaveEnabled(true);
        String path = context.getFilesDir().getPath();
        path.substring(0, path.lastIndexOf(WVNativeCallbackUtil.SEPERATER));
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString());
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(0);
        setThirdPartyCookiesEnabled(true);
        super.setWebChromeClient(new _a(this));
        super.setWebViewClient(new WebViewClient(this) { // from class: com.kc.aw.widget.web.AdvancedWebView.2
            public final AdvancedWebView _a;

            {
                this._a = this;
            }

            @Override // android.webkit.WebViewClient
            public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.doUpdateVisitedHistory(webView, str, z);
                } else {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onFormResubmission(WebView webView, Message message, Message message2) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onFormResubmission(webView, message, message2);
                } else {
                    super.onFormResubmission(webView, message, message2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onLoadResource(WebView webView, String str) {
                this._a.getClass();
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onLoadResource(webView, str);
                } else {
                    super.onLoadResource(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (!(this._a._e + 500 >= System.currentTimeMillis())) {
                    this._a.getClass();
                }
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (!(this._a._e + 500 >= System.currentTimeMillis())) {
                    this._a.getClass();
                }
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onPageStarted(webView, str, bitmap);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
                } else {
                    super.onReceivedClientCertRequest(webView, clientCertRequest);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                AdvancedWebView advancedWebView = this._a;
                advancedWebView.getClass();
                advancedWebView._e = System.currentTimeMillis();
                this._a.getClass();
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onReceivedError(webView, i, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                } else {
                    super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(webView, str, str2, str3);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onScaleChanged(WebView webView, float f, float f2) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onScaleChanged(webView, f, f2);
                } else {
                    super.onScaleChanged(webView, f, f2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null) {
                    webViewClient.onUnhandledKeyEvent(webView, keyEvent);
                } else {
                    super.onUnhandledKeyEvent(webView, keyEvent);
                }
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebViewClient webViewClient = this._a._h;
                return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebViewClient webViewClient = this._a._h;
                return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
                WebViewClient webViewClient = this._a._h;
                return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                boolean z;
                AdvancedWebView advancedWebView = this._a;
                if (!advancedWebView._b.isEmpty()) {
                    String host = Uri.parse(str).getHost();
                    Iterator it = advancedWebView._b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        String str2 = (String) it.next();
                        if (!host.equals(str2)) {
                            if (host.endsWith(Consts.DOT + str2)) {
                            }
                        }
                        z = true;
                        break;
                    }
                }
                z = true;
                break;
                if (!z) {
                    this._a.getClass();
                    return true;
                }
                WebViewClient webViewClient = this._a._h;
                if (webViewClient != null && webViewClient.shouldOverrideUrlLoading(webView, str)) {
                    return true;
                }
                if (str.startsWith("https") || str.startsWith("http")) {
                    webView.loadUrl(str);
                    return false;
                }
                try {
                    if (this._a.getContext() != null) {
                        this._a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (ActivityNotFoundException | Exception unused) {
                }
                return true;
            }
        });
        setDownloadListener(new _b(this));
    }

    public final void _a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, boolean z) {
        ValueCallback<Uri> valueCallback3 = this._c;
        if (valueCallback3 != null) {
            valueCallback3.onReceiveValue(null);
        }
        this._c = valueCallback;
        ValueCallback<Uri[]> valueCallback4 = this._d;
        if (valueCallback4 != null) {
            valueCallback4.onReceiveValue(null);
        }
        this._d = valueCallback2;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (z) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.setType(this._k);
        try {
            WeakReference<Activity> weakReference = this._a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this._a.get().startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this._g);
        } catch (Exception unused) {
        }
    }

    public final boolean _a() {
        int backwardSize = getBackwardSize();
        int i = this._m;
        boolean z = true;
        if ((backwardSize != i || (backwardSize != 1 && backwardSize != 2)) && i - backwardSize < 1) {
            z = false;
        }
        this._m = backwardSize;
        return z;
    }

    public final boolean _b() {
        boolean z = false;
        try {
            try {
                if (!canGoBack() || _a()) {
                    return true;
                }
                try {
                    goBack();
                } catch (Exception unused) {
                }
                return false;
            } catch (Exception unused2) {
                return true ^ z;
            }
        } catch (Exception unused3) {
            if (canGoBack()) {
                goBack();
                z = true;
            }
            return true ^ z;
        }
    }

    public String getFileUploadPromptLabel() {
        try {
            if (this._f.equals("zho")) {
                return _a("6YCJ5oup5LiA5Liq5paH5Lu2");
            }
            if (this._f.equals("spa")) {
                return _a("RWxpamEgdW4gYXJjaGl2bw==");
            }
            if (this._f.equals("hin")) {
                return _a("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=");
            }
            if (this._f.equals("ben")) {
                return _a("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=");
            }
            if (this._f.equals("ara")) {
                return _a("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==");
            }
            if (this._f.equals("por")) {
                return _a("RXNjb2xoYSB1bSBhcnF1aXZv");
            }
            if (this._f.equals("rus")) {
                return _a("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==");
            }
            if (this._f.equals("jpn")) {
                return _a("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==");
            }
            if (this._f.equals("pan")) {
                return _a("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=");
            }
            if (this._f.equals("deu")) {
                return _a("V8OkaGxlIGVpbmUgRGF0ZWk=");
            }
            if (this._f.equals("jav")) {
                return _a("UGlsaWggc2lqaSBiZXJrYXM=");
            }
            if (this._f.equals("msa")) {
                return _a("UGlsaWggc2F0dSBmYWls");
            }
            if (this._f.equals("tel")) {
                return _a("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=");
            }
            if (this._f.equals("vie")) {
                return _a("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==");
            }
            if (this._f.equals("kor")) {
                return _a("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=");
            }
            if (this._f.equals("fra")) {
                return _a("Q2hvaXNpc3NleiB1biBmaWNoaWVy");
            }
            if (this._f.equals("mar")) {
                return _a("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==");
            }
            if (this._f.equals("tam")) {
                return _a("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=");
            }
            if (this._f.equals("urd")) {
                return _a("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==");
            }
            if (this._f.equals("fas")) {
                return _a("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==");
            }
            if (this._f.equals("tur")) {
                return _a("QmlyIGRvc3lhIHNlw6dpbg==");
            }
            if (this._f.equals("ita")) {
                return _a("U2NlZ2xpIHVuIGZpbGU=");
            }
            if (this._f.equals("tha")) {
                return _a("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH");
            }
            return this._f.equals("guj") ? _a("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=") : "Choose a file";
        } catch (Exception unused) {
            return "Choose a file";
        }
    }

    public List<String> getPermittedHostnames() {
        return this._b;
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String str) {
        if (this._l.isEmpty()) {
            super.loadUrl(str);
        } else {
            super.loadUrl(str, this._l);
        }
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String str, Map<String, String> map) {
        if (map == null) {
            map = this._l;
        } else if (this._l.size() > 0) {
            map.putAll(this._l);
        }
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public final void onPause() {
        pauseTimers();
        super.onPause();
    }

    @Override // android.webkit.WebView
    public final void onResume() {
        super.onResume();
        resumeTimers();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        Math.abs(i4 - i2);
    }

    public void setCanScrollListener(boolean z) {
        this._r = z;
    }

    public void setCookiesEnabled(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    public void setDesktopMode(boolean z) {
        WebSettings settings = getSettings();
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(z ? userAgentString.replace("Mobile", "eliboM").replace("Android", "diordnA") : userAgentString.replace("eliboM", "Mobile").replace("diordnA", "Android"));
        settings.setUseWideViewPort(z);
        settings.setLoadWithOverviewMode(z);
        settings.setSupportZoom(z);
        settings.setBuiltInZoomControls(z);
    }

    public void setGeolocationEnabled(boolean z) {
        if (z) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setGeolocationEnabled(true);
            WeakReference<Activity> weakReference = this._a;
            if (weakReference != null && weakReference.get() != null) {
                getSettings().setGeolocationDatabasePath(this._a.get().getFilesDir().getPath());
            }
        }
        this._j = z;
    }

    public void setMixedContentAllowed(boolean z) {
        getSettings().setMixedContentMode(!z ? 1 : 0);
    }

    public void setScrollListener(_d _dVar) {
    }

    public void setThirdPartyCookiesEnabled(boolean z) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, z);
    }

    public void setUploadableFileTypes(String str) {
        this._k = str;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this._i = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this._h = webViewClient;
    }
}
