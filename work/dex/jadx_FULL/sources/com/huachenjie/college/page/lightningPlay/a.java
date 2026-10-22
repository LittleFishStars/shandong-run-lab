package com.huachenjie.college.page.lightningPlay;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.blankj.utilcode.util.b;
import com.huachenjie.base.dsbridge_webview.DWebView;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class a {

    /* JADX INFO: renamed from: com.huachenjie.college.page.lightningPlay.a$a, reason: collision with other inner class name */
    public class C0793a extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            i4a.c(str);
            if (str.startsWith("weixin://wap/pay?") || str.startsWith("alipay")) {
                fv5.b("唤起支付中...");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                webView.getContext().startActivity(intent);
                return true;
            }
            if (str.startsWith("https")) {
                HashMap map = new HashMap();
                map.put("Referer", "http://www.shandw.com");
                i4a.c(str);
                webView.loadUrl(str, map);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public static void a(DWebView dWebView, LightningPlayJavascript.ILightningPlayProvider iLightningPlayProvider) {
        WebSettings settings = dWebView.getSettings();
        String userAgentString = settings.getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            userAgentString = "";
        }
        settings.setUserAgentString(userAgentString + " shandong/" + b.C());
        dWebView.addJavascriptObject(new LightningPlayJavascript(iLightningPlayProvider), "shandong");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(false);
        settings.setDatabaseEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        dWebView.setWebViewClient(new C0793a());
    }
}
