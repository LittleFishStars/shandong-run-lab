package com.kc.dw.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ZoomButtonsController;
import com.google.common.net.b;
import com.kc.dw.core.loader.ShareInfo;
import com.kc.dw.core.loader.ShareInteractionListener;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.n1;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.webview.j;
import com.kc.dw.core.webview.k;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdWebviewActivity extends SafeAppCompatActivity {
    public static final String EXTRA_AD_AMID_KEY = "EXTRA_AD_AMID_KEY";
    public static final String EXTRA_AD_DURL_KEY = "EXTRA_AD_DURL_KEY";
    public static final String EXTRA_AD_UUID_KEY = "EXTRA_AD_UUID_KEY";
    private static ShareInteractionListener shareListener;
    public Map<String, String> extraHeaders = new HashMap();
    private String shareInfo;
    private WebView webView;

    public static void setShareListener(ShareInteractionListener shareInteractionListener) {
        shareListener = shareInteractionListener;
    }

    private void showLoading() {
        try {
            View viewFindViewById = findViewById(R.id.ms_webivew_loading);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: lambda$safeOnCreate$0$com-kc-dw-activity-SsdWebviewActivity, reason: not valid java name */
    public /* synthetic */ void m1002lambda$safeOnCreate$0$comkcdwactivitySsdWebviewActivity(k kVar) {
        try {
            kVar.a(this.webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        final k kVar;
        super.safeOnCreate(bundle);
        setContentView(R.layout.ssd_activity_webview);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("EXTRA_AD_DURL_KEY");
        ImageView imageView = (ImageView) findViewById(R.id.ms_img_share);
        WebView webView = (WebView) findViewById(R.id.ms_webView);
        this.webView = webView;
        webView.setScrollBarStyle(0);
        this.extraHeaders.put(b.c1, "");
        WebSettings settings = this.webView.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        this.webView.setWebChromeClient(new WebChromeClient());
        int i = k.d;
        try {
            if (com.kc.dw.base.a.adConfig() == null || com.kc.dw.base.a.adConfig().webViewClient() == null) {
                kVar = new k(this);
            } else {
                Constructor<? extends WebViewClient> declaredConstructor = com.kc.dw.base.a.adConfig().webViewClient().getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                kVar = (k) declaredConstructor.newInstance(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.webView.setWebViewClient(kVar);
        com.kc.dw.core.webview.b bVarA = com.kc.dw.core.webview.b.a(this);
        bVarA.b = new com.kc.dw.core.webview.b.a(this, kVar) { // from class: com.kc.dw.activity.SsdWebviewActivity$$ExternalSyntheticLambda0
            public final SsdWebviewActivity f$0;
            public final k f$1;

            {
                this.f$0 = this;
                this.f$1 = kVar;
            }

            @Override // com.kc.dw.core.webview.b.a
            public final void a() {
                this.f$0.m1002lambda$safeOnCreate$0$comkcdwactivitySsdWebviewActivity(this.f$1);
            }
        };
        this.webView.setDownloadListener(bVarA);
        try {
            if (n1.f39390a) {
                n1.f39390a = false;
                String defaultUserAgent = WebSettings.getDefaultUserAgent(this);
                if (defaultUserAgent != null) {
                    com.kc.dw.base.a.getSharedPreferences().edit().putString("user_agent", defaultUserAgent).apply();
                    r.a().b("user_agent", defaultUserAgent);
                }
            }
        } catch (Throwable unused) {
        }
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            try {
                String queryParameter = Uri.parse(stringArrayExtra[0]).getQueryParameter("__ms_share_info");
                this.shareInfo = queryParameter;
                if (shareListener == null || TextUtils.isEmpty(queryParameter)) {
                    imageView.setVisibility(4);
                } else {
                    imageView.setVisibility(0);
                    imageView.setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdWebviewActivity.1
                        public final SsdWebviewActivity this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view) {
                            if (SsdWebviewActivity.shareListener != null) {
                                SsdWebviewActivity.shareListener.onShareButtonClicked(new ShareInfo(this.this$0.shareInfo, this.this$0.webView.getUrl()));
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.webView.loadUrl(stringArrayExtra[0], this.extraHeaders);
            showLoading();
            WebView webView2 = this.webView;
            kVar.getClass();
            SdkHandler.getInstance().postDelay(new j(kVar, new SoftReference(webView2)), 5000L);
        }
        findViewById(R.id.ms_img_close).setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdWebviewActivity.2
            public final SsdWebviewActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view) {
                this.this$0.finish();
            }
        });
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        try {
            super.safeOnDestroy();
            shareListener = null;
            this.webView.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public boolean safeOnKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.webView.canGoBack()) {
            return super.safeOnKeyDown(i, keyEvent);
        }
        this.webView.goBack();
        return true;
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnPause() {
        try {
            super.safeOnPause();
            this.webView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnResume() {
        try {
            super.safeOnResume();
            this.webView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
