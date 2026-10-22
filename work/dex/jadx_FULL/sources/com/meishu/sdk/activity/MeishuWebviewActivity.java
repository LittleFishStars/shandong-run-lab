package com.meishu.sdk.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ZoomButtonsController;
import com.google.common.net.b;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.loader.ShareInfo;
import com.meishu.sdk.core.loader.ShareInteractionListener;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.k0;
import com.meishu.sdk.core.utils.r;
import com.meishu.sdk.core.webview.d;
import com.meishu.sdk.core.webview.l;
import com.meishu.sdk.core.webview.m;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuWebviewActivity extends SafeAppCompatActivity {
    public static final String EXTRA_AD_AMID_KEY = "EXTRA_AD_AMID_KEY";
    public static final String EXTRA_AD_DURL_KEY = "EXTRA_AD_DURL_KEY";
    public static final String EXTRA_AD_UUID_KEY = "EXTRA_AD_UUID_KEY";
    private static ShareInteractionListener shareListener;
    public Map<String, String> extraHeaders = new HashMap();
    private String shareInfo;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeOnCreate$0(m mVar) {
        try {
            mVar.a(this.webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setShareListener(ShareInteractionListener shareInteractionListener) {
        shareListener = shareInteractionListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public void safeOnCreate(Bundle bundle) {
        final m mVar;
        super.safeOnCreate(bundle);
        setContentView(R.layout.ms_activity_meishu_webview);
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
        if (Build.VERSION.SDK_INT < 31) {
            settings.setAppCachePath(getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
        }
        this.webView.setWebChromeClient(new WebChromeClient());
        int i = m.d;
        try {
            if (AdSdk.adConfig() == null || AdSdk.adConfig().webViewClient() == null) {
                mVar = new m(this);
            } else {
                Constructor declaredConstructor = AdSdk.adConfig().webViewClient().getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                mVar = (m) declaredConstructor.newInstance(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.webView.setWebViewClient(mVar);
        d dVarA = d.a(this);
        dVarA.b = new d.a() { // from class: com.zj.adlib.sl5
            public final void onDownloadStart() {
                this.f44712a.lambda$safeOnCreate$0(mVar);
            }
        };
        this.webView.setDownloadListener(dVarA);
        try {
            if (k0.a) {
                k0.a = false;
                String defaultUserAgent = WebSettings.getDefaultUserAgent(this);
                if (defaultUserAgent != null) {
                    AdSdk.getSharedPreferences().edit().putString("user_agent", defaultUserAgent).apply();
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
                    imageView.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuWebviewActivity.1
                        public void safeOnClick(View view) {
                            if (MeishuWebviewActivity.shareListener != null) {
                                MeishuWebviewActivity.shareListener.onShareButtonClicked(new ShareInfo(MeishuWebviewActivity.this.shareInfo, MeishuWebviewActivity.this.webView.getUrl()));
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
            mVar.getClass();
            SdkHandler.getInstance().postDelay(new l(mVar, new SoftReference(webView2)), 5000L);
        }
        findViewById(R.id.ms_img_close).setOnClickListener(new o() { // from class: com.meishu.sdk.activity.MeishuWebviewActivity.2
            public void safeOnClick(View view) {
                MeishuWebviewActivity.this.finish();
            }
        });
    }

    public void safeOnDestroy() {
        try {
            super.safeOnDestroy();
            shareListener = null;
            this.webView.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean safeOnKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.webView.canGoBack()) {
            return super.safeOnKeyDown(i, keyEvent);
        }
        this.webView.goBack();
        return true;
    }

    public void safeOnPause() {
        try {
            super.safeOnPause();
            this.webView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
