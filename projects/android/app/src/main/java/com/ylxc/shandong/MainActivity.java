package com.ylxc.shandong;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 闪动校园 · 安卓版唯一 Activity。
 *
 * 全屏 WebView 加载本地前端（file:///android_asset/web/index.html），
 * 注册 window.SDAndroid JS 桥，Python 业务逻辑通过 Chaquopy 在 JsApiBridge 中调用。
 */
public class MainActivity extends Activity {

    private static final String TAG = "SDMain";

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 全屏，无状态栏沉浸模式
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        // file:// 加载本地 Leaflet 需要允许跨 file 访问
        // noinspection deprecation
        settings.setAllowFileAccessFromFileURLs(true);
        // noinspection deprecation
        settings.setAllowUniversalAccessFromFileURLs(true);
        // 缓存模式采用默认值
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAllowFileAccess(true);

        // 宿主桥实现
        HostBridge hostBridge = new HostBridgeImpl(this);

        // JS 桥：window.SDAndroid —— 由 JS 侧 bridge.js 调用
        webView.addJavascriptInterface(new JsApiBridge(this, hostBridge), "SDAndroid");

        // 处理 JS 的 alert，避免阻塞 WebView
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(android.webkit.WebView view, String url,
                                     String message, JsResult result) {
                Log.d("MainActivity", "JS alert: " + message);
                result.confirm(); // 直接关闭，不阻塞
                return true;
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 页面加载完成，注入 __SD_READY__ 标记（辅助前端判定）
                view.evaluateJavascript(
                        "window.__SD_READY__=true; console.log('SD_READY injected');", null);
            }
        });

        // 加载本地前端
        webView.loadUrl("file:///android_asset/web/index.html");
    }

    @Override
    public void onBackPressed() {
        // 返回键：优先回退 WebView 历史，否则退出
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}