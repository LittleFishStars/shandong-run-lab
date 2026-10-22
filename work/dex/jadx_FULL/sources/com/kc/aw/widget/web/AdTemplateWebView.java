package com.kc.aw.widget.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.czhj.sdk.common.Constants;
import com.kc.aw._jf;
import com.kc.aw._n2;
import com.kc.aw._n3;
import com.kc.aw._t;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdTemplateWebView extends WebView {
    public _a _a;
    public boolean _b;

    @Keep
    public interface _a {
    }

    @Keep
    public static final class _b {
        public AdTemplateWebView _a;

        @Keep
        public final class _a implements Runnable {
            public final String _a;
            public final String _b;
            public final _b _c;

            public _a(_b _bVar, String str, String str2) {
                this._c = _bVar;
                this._a = str;
                this._b = str2;
            }

            /* JADX WARN: Code duplicated, block: B:27:0x005a  */
            @Override // java.lang.Runnable
            public final void run() {
                byte b;
                _n2 _n2Var;
                try {
                    AdTemplateWebView adTemplateWebView = this._c._a;
                    if (adTemplateWebView._a != null && !adTemplateWebView._b) {
                        JSONObject jSONObject = TextUtil.isEmpty(this._a) ? new JSONObject() : new JSONObject(this._a);
                        String str = this._b;
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1351902487) {
                            if (iHashCode != -1013170331) {
                                if (iHashCode == 22327279 && str.equals("onTimeEnd")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (str.equals("onLoad")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("onClick")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            ((_n3._a) this._c._a._a)._a(jSONObject.optInt(Constants.CLICK_TYPE, 1), jSONObject);
                            return;
                        }
                        if (b != 1) {
                            if (b != 2) {
                                return;
                            }
                            ((_n3._a) this._c._a._a)._b();
                            return;
                        }
                        if (jSONObject.optInt(UserTrackConstant.IS_SUCCESS, 0) == 1) {
                            ((_n3._a) this._c._a._a)._a();
                            return;
                        }
                        _n3._a _aVar = (_n3._a) this._c._a._a;
                        _n3 _n3Var = _aVar._a;
                        Handler handler = _n3Var._n;
                        if (handler != null && (_n2Var = _n3Var._o) != null) {
                            handler.removeCallbacks(_n2Var);
                            _n3Var._o = null;
                        }
                        _n3 _n3Var2 = _aVar._a;
                        _t _tVar = _n3Var2._c;
                        if (_tVar != null) {
                            _tVar._a(_n3Var2, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("开屏模版页面加载失败"));
                        }
                    }
                } catch (Exception e) {
                    StringBuilder sb_a = _jf._a("js调用失败: ");
                    sb_a.append(e.getMessage());
                    Logger.e("AdTemplateWebView", sb_a.toString());
                }
            }
        }

        public _b(AdTemplateWebView adTemplateWebView) {
            this._a = adTemplateWebView;
        }

        @JavascriptInterface
        public void handleNativeMethod(String str, String str2) {
            this._a.post(new _a(this, str2, str));
        }
    }

    public AdTemplateWebView(Context context) {
        this(context, null, 0);
    }

    public AdTemplateWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdTemplateWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        requestFocus();
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSupportZoom(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setDisplayZoomControls(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setLoadsImagesAutomatically(true);
        addJavascriptInterface(new _b(this), "androidJsBridge");
        setWebViewClient(new WebViewClient() { // from class: com.kc.aw.widget.web.AdTemplateWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        super.destroy();
        this._b = true;
    }
}
