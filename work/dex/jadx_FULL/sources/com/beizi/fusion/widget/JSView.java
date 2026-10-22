package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.m9;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.oo;
import com.beizi.fusion.q1;
import com.beizi.fusion.v3;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JSView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f27944a;
    private int b;
    private Context c;
    private Handler d;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            JSView jSView = JSView.this;
            if (jSView.b > 0) {
                jSView.load();
            } else {
                jSView.a();
            }
        }
    }

    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
        }
    }

    public class c extends WebViewClient {

        public class a implements ValueCallback {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                List<String> report;
                TaskBean.BackTaskArrayBean backTaskArrayBean = JSView.this.f27944a;
                if (backTaskArrayBean == null || (report = backTaskArrayBean.getReport()) == null || report.size() <= 0) {
                    return;
                }
                for (int i = 0; i < report.size(); i++) {
                    if (!TextUtils.isEmpty(report.get(i))) {
                        if (m9.a(oo.a(JSView.this.c, report.get(i), null), JSView.this.f27944a.getUserAgent()) != null) {
                            EventCar.getInstance(JSView.this.c).goRoadWithoutThread(new EventBean(q1.u, "", "520.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                        } else {
                            EventCar.getInstance(JSView.this.c).goRoadWithoutThread(new EventBean(q1.u, "", "520.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                        }
                        try {
                            Thread.sleep(JSView.this.f27944a.getSleepTime());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            List<String> action = JSView.this.f27944a.getAction();
            if (action != null && action.size() > 0) {
                for (int i = 0; i < action.size(); i++) {
                    if (!TextUtils.isEmpty(action.get(i))) {
                        JSView.this.evaluateJavascript(com.alibaba.ariver.remotedebug.b.k + action.get(i) + "()", new a());
                    }
                }
            }
            v3.b().f().execute(new b());
            JSView jSView = JSView.this;
            jSView.d.sendEmptyMessageDelayed(1, jSView.f27944a.getShowTime());
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            JSView.this.b();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            JSView.this.b();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            JSView.this.b();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public JSView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            EventCar.getInstance(this.c).goRoad(new EventBean(q1.u, "", "510.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        EventCar.getInstance(this.c).goRoad(new EventBean(q1.u, "", "510.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public void init() {
        WebSettings settings = getSettings();
        settings.setSavePassword(false);
        WebView.setWebContentsDebuggingEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setWebChromeClient(new b());
        setWebViewClient(new c());
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f27944a;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f27944a.getContentUrl());
        this.b--;
    }

    public JSView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.c = context;
        this.f27944a = backTaskArrayBean;
        this.b = backTaskArrayBean.getRepeatCount();
    }

    public JSView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1;
        this.d = new a();
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
