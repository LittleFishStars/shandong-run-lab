package com.kc.aw.lib.helper.imp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.kc.aw._fn;
import com.kc.aw._r;
import com.kc.aw.lib.utils._d;
import com.kc.aw.widget.web.AdvancedWebView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class WebManager$1 extends WebViewClient {
    public final Activity _a;
    public final com.kc.aw.lib.helper.imp._a _b;

    @Keep
    public final class _a implements Runnable {
        public final WebManager$1 _a;

        public _a(WebManager$1 webManager$1) {
            this._a = webManager$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdvancedWebView advancedWebView = this._a._b._a;
            if (advancedWebView != null && advancedWebView.getSettings() != null) {
                this._a._b._a.getSettings().setJavaScriptEnabled(false);
            }
            com.kc.aw.lib.helper.imp._a _aVar = this._a._b;
            com.kc.aw.lib.helper.imp._a.RunnableC0956_a runnableC0956_a = _aVar._g;
            long j = _aVar._e;
            if (runnableC0956_a != null) {
                _d._b.postDelayed(new _d._c(runnableC0956_a), j);
            } else {
                _d._b _bVar = _d._a;
            }
        }
    }

    public WebManager$1(com.kc.aw.lib.helper.imp._a _aVar, Activity activity) {
        this._b = _aVar;
        this._a = activity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ProgressBar progressBar;
        super.onPageFinished(webView, str);
        if (this._a.isFinishing() || (progressBar = this._b._b) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ProgressBar progressBar;
        super.onPageStarted(webView, str, bitmap);
        if (this._a.isFinishing() || (progressBar = this._b._b) == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("https") || str.startsWith("http")) {
            webView.loadUrl(str);
            return false;
        }
        try {
            if (webView.getContext() != null) {
                if (!com.kc.aw.lib.helper.imp._a._a(this._b, str)) {
                    _r _rVar = this._b._f;
                    if (_rVar != null) {
                        _rVar._c = str;
                        new _fn()._a(this._a, new Intent("android.intent.action.VIEW", Uri.parse(str)), _rVar);
                    }
                } else if (com.kc.aw.lib.helper.imp._a._a(this._b)) {
                    _d._c(new _a(this));
                }
            }
            return true;
        } catch (ActivityNotFoundException | Exception unused) {
            return true;
        }
    }
}
