package com.kc.dw.core.webview;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f39437a;

    public c(String str, e eVar) {
        this.f39437a = eVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        LogUtil.dev("FreedomWebViewClient", "onReceivedTitle:" + str);
        try {
            String url = webView.getUrl();
            if (l.a(url)) {
                return;
            }
            int iA = this.f39437a.a(url);
            if (iA == 404 || iA >= 500) {
                webView.stopLoading();
                try {
                    if (TextUtils.isEmpty("\n<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n    <title>500 - 服务器错误</title>\n    <style>\n        body {\n            margin: 0;\n            padding: 0;\n            background-color: white;\n            display: flex;\n            flex-direction: column;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            overflow: hidden;\n            touch-action: none;\n        }\n        .error-image {\n            width: 140px;\n            height: 119px;\n            margin-bottom: 16px;\n        }\n        .error-text {\n            font-weight: 400;\n            font-size: 14px;\n            color: #888888;\n            text-align: center;\n            line-height: 24px;\n            max-width: 80%;\n        }\n    </style>\n</head>\n<body>\n<img class=\"error-image\" src=\"file:///android_asset/ad_mate_error.png\" alt=\"500错误提示图\">\n<p class=\"error-text\">页面加载失败<br>可尝试刷新或检查网络~</p>\n</body>\n</html>\n")) {
                        return;
                    }
                    webView.loadDataWithBaseURL(com.ipd.dsp.internal.n.a.d, "\n<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n    <title>500 - 服务器错误</title>\n    <style>\n        body {\n            margin: 0;\n            padding: 0;\n            background-color: white;\n            display: flex;\n            flex-direction: column;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            overflow: hidden;\n            touch-action: none;\n        }\n        .error-image {\n            width: 140px;\n            height: 119px;\n            margin-bottom: 16px;\n        }\n        .error-text {\n            font-weight: 400;\n            font-size: 14px;\n            color: #888888;\n            text-align: center;\n            line-height: 24px;\n            max-width: 80%;\n        }\n    </style>\n</head>\n<body>\n<img class=\"error-image\" src=\"file:///android_asset/ad_mate_error.png\" alt=\"500错误提示图\">\n<p class=\"error-text\">页面加载失败<br>可尝试刷新或检查网络~</p>\n</body>\n</html>\n", "text/html", "UTF-8", null);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
