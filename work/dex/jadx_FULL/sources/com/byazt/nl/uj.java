package com.byazt.nl;

import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface uj extends ve {
    void addJavascriptInterface(Object obj, String str);

    void c(String str, String str2, Object obj);

    boolean canGoBack();

    void clearCache(boolean z);

    void clearHistory();

    void clearView();

    void computeScroll();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    int getProgress();

    String getUrl();

    String getUserAgentString();

    View getView();

    WebView getWebView();

    void goBack();

    void loadUrl(String str);

    void onPause();

    void onResume();

    void pauseTimers();

    void removeAllViews();

    void removeJavascriptInterface(String str);

    void resumeTimers();

    void setAllowFileAccess(boolean z);

    void setAllowFileAccessFromFileURLs(boolean z);

    void setAllowUniversalAccessFromFileURLs(boolean z);

    void setAlpha(float f);

    void setAppCacheEnabled(boolean z);

    void setBackgroundColor(int i);

    void setBlockNetworkImage(boolean z);

    void setBuiltInZoomControls(boolean z);

    void setCacheMode(int i);

    void setDatabaseEnabled(boolean z);

    void setDefaultFontSize(int i);

    void setDefaultTextEncodingName(String str);

    void setDisplayZoomControls(boolean z);

    void setDomStorageEnabled(boolean z);

    void setDownloadListener(DownloadListener downloadListener);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    void setJavaScriptEnabled(boolean z);

    void setLayerType(int i, Paint paint);

    void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm);

    void setLoadWithOverviewMode(boolean z);

    void setMediaPlaybackRequiresUserGesture(boolean z);

    void setMixedContentMode(int i);

    void setNetworkAvailable(boolean z);

    void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener);

    void setOverScrollMode(int i);

    void setSavePassword(boolean z);

    void setSupportZoom(boolean z);

    void setUseWideViewPort(boolean z);

    void setUserAgentString(String str);

    void setVisibility(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);
}
