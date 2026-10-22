package com.acse.ottn;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.widget.CustomWebView;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b1 {
    public static b1 d = null;
    public static String e = "ExcessActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22875a;
    public CustomWebView b;
    public c c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22876a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        /* JADX INFO: renamed from: com.acse.ottn.b1$a$a, reason: collision with other inner class name */
        public class RunnableC0098a implements Runnable {
            public RunnableC0098a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b1.this.f22875a.finishAndRemoveTask();
            }
        }

        public a(String str, String str2, String str3, String str4, int i) {
            this.f22876a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f22876a)) {
                AccessiblityModel accessiblityModel = new AccessiblityModel();
                accessiblityModel.getData().setSpop_deeplink(this.f22876a);
                accessiblityModel.getData().setSpop_link(this.b);
                accessiblityModel.getData().setPackage_name(this.c);
                accessiblityModel.getData().setJump_type(this.d);
                n4.c().a(b1.this.f22875a, accessiblityModel);
            }
            new Handler().postDelayed(new RunnableC0098a(), this.e);
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public /* synthetic */ c(b1 b1Var, a aVar) {
            this();
        }
    }

    public final Object b() throws ObjectStreamException {
        return d;
    }

    public static b1 a() {
        if (d == null) {
            synchronized (b1.class) {
                if (d == null) {
                    d = new b1();
                }
            }
        }
        return d;
    }

    public void a(Activity activity) {
        this.f22875a = activity;
        this.b = (CustomWebView) activity.findViewById(R.id.dwebView);
        String stringExtra = this.f22875a.getIntent().getStringExtra("password");
        String stringExtra2 = this.f22875a.getIntent().getStringExtra("link");
        String stringExtra3 = this.f22875a.getIntent().getStringExtra("deeplink");
        String stringExtra4 = this.f22875a.getIntent().getStringExtra("origin_url");
        String stringExtra5 = this.f22875a.getIntent().getStringExtra("jump_type");
        String stringExtra6 = this.f22875a.getIntent().getStringExtra("name");
        int intExtra = this.f22875a.getIntent().getIntExtra("time", 100);
        int intExtra2 = this.f22875a.getIntent().getIntExtra("dissmiss_time", 0);
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                String strL = t0.b().l(stringExtra6);
                if (!TextUtils.isEmpty(strL)) {
                    o.c().a(this.f22875a, strL);
                } else {
                    o.c().a(this.f22875a, stringExtra);
                }
            } catch (Exception unused) {
                o.c().a(this.f22875a, stringExtra);
            }
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            h2.a(e, "loadH5Url = " + stringExtra4);
            a(stringExtra4);
        } else {
            h2.a(e, "origin_url is null");
        }
        new Handler().postDelayed(new a(stringExtra3, stringExtra2, stringExtra6, stringExtra5, intExtra2), intExtra);
    }

    public final void a(String str) {
        try {
            CustomWebView customWebView = this.b;
            if (customWebView == null) {
                return;
            }
            WebSettings settings = customWebView.getSettings();
            settings.setTextZoom(100);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setMixedContentMode(0);
            c cVar = new c(this, null);
            this.c = cVar;
            this.b.setWebChromeClient(cVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.b.setWebViewClient(new b());
            this.b.loadUrl(str);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
