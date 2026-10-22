package com.acse.ottn.activity;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.acse.ottn.a0;
import com.acse.ottn.h2;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.CustomWebView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SeedWebViewActivity extends a0 {
    public static final String g = "SeedWebViewActivity";
    public CustomWebView e;
    public d f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SeedWebViewActivity.this.finish();
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

    public static class c extends FrameLayout {
        public c(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public /* synthetic */ d(SeedWebViewActivity seedWebViewActivity, a aVar) {
            this();
        }
    }

    public final void a(String str) {
        h2.a(g, "loadH5Url = " + str);
        try {
            CustomWebView customWebView = this.e;
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
            d dVar = new d(this, null);
            this.f = dVar;
            this.e.setWebChromeClient(dVar);
            Method method = settings.getClass().getMethod("setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            if (method != null) {
                method.invoke(settings, Boolean.TRUE);
            }
            this.e.setWebViewClient(new b());
            this.e.loadUrl(str);
        } catch (IllegalArgumentException e) {
            h2.a(g, "IllegalArgumentException=" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            h2.a(g, "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(Color.argb(0, 0, 0, 0));
        setContentView(com.acse.ottn.R.layout.activity_seed_web_view);
        if (HelpShopAppUtil.getContext() == null) {
            new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        }
        a(false);
        getIntent().getStringExtra("title");
        String stringExtra = getIntent().getStringExtra("url");
        this.e = (CustomWebView) findViewById(com.acse.ottn.R.id.dwebView);
        findViewById(com.acse.ottn.R.id.iv_back).setOnClickListener(new a());
        a(stringExtra);
    }
}
