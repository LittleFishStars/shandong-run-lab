package com.alibaba.alibcwebview.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23717a = "c";
    private static ArrayList<String> b = new ArrayList<>();

    public static void a(final WebView webView, final Activity activity) {
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setMixedContentMode(0);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(webView.getContext().getApplicationContext().getDir("cache", 0).getPath());
            settings.setAllowFileAccess(false);
            settings.setAppCacheEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            if (NetWorkUtils.isNetWorkAvailable(webView.getContext())) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(1);
            }
            settings.setBuiltInZoomControls(false);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            StringBuilder sb = new StringBuilder();
            String userAgentString = settings.getUserAgentString();
            if (userAgentString != null) {
                sb.append(userAgentString);
            }
            sb.append(" tae_sdk_5.0.2.5");
            sb.append(" AliApp(BC/5.0.2.5)");
            sb.append(String.format(" AliBaichuan(%s/%s)", AlibcBaseTradeCommon.ttid, AlibcCommonUtils.getAppVersion(AlibcBaseTradeCommon.context)));
            for (String str : b) {
                sb.append(" ");
                sb.append(str);
            }
            settings.setUserAgentString(sb.toString());
        }
        try {
            webView.setTag(Integer.valueOf(AlibcBaseTradeCommon.context.getResources().getIdentifier("com_taobao_biz_ultimate_webview_click", "id", AlibcBaseTradeCommon.context.getPackageName())));
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.alibcwebview.container.c.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    webView.setTag(Integer.valueOf(AlibcBaseTradeCommon.context.getResources().getIdentifier("com_taobao_biz_ultimate_webview_click", "id", AlibcBaseTradeCommon.context.getPackageName())));
                    return false;
                }
            });
            webView.setDownloadListener(new DownloadListener() { // from class: com.alibaba.alibcwebview.container.c.2
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    try {
                        AlibcLogger.i(c.f23717a, "url=" + str2);
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                        intent.addCategory("android.intent.category.BROWSABLE");
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        AlibcLogger.e(c.f23717a, "jump exception: " + e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            AlibcLogger.e(f23717a, "setTag exception: " + e.getMessage());
        }
        b bVar = new b(webView);
        webView.setWebViewClient(bVar);
        a aVar = new a(webView);
        webView.setWebChromeClient(aVar);
        AlibcTradeContext.getInstance().mWebView = new WeakReference<>(webView);
        AlibcTradeContext.getInstance().mActivity = new WeakReference<>(activity);
        AlibcTradeContext.getInstance().setWebViewClient(bVar);
        AlibcTradeContext.getInstance().setWebChromeClient(aVar);
    }
}
