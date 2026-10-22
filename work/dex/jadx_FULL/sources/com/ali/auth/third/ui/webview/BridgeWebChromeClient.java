package com.ali.auth.third.ui.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.SystemMessageConstants;
import com.ali.auth.third.core.trace.SDKLogger;
import com.alibaba.ariver.remotedebug.b;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeWebChromeClient extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23545a = "BridgeWebChromeClient";
    private static boolean b = true;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WebView f23546a;
        public String b;

        public a(WebView webView, String str) {
            this.f23546a = webView;
            this.b = str;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0044 A[Catch: Exception -> 0x0049, TryCatch #1 {Exception -> 0x0049, blocks: (B:2:0x0000, B:9:0x002b, B:11:0x0044, B:12:0x0046, B:8:0x0013, B:4:0x0006), top: B:17:0x0000, inners: #0 }] */
        @Override // java.lang.Runnable
        @TargetApi(19)
        public void run() {
            WebView webView;
            try {
                if (!BridgeWebChromeClient.b) {
                    String str = b.k + this.b;
                    webView = this.f23546a;
                    if (webView instanceof AuthWebView) {
                        webView = (AuthWebView) webView;
                    }
                    webView.loadUrl(str);
                }
                try {
                    this.f23546a.evaluateJavascript(this.b, null);
                } catch (Exception e) {
                    SDKLogger.e("ui", "fail to evaluate the script " + e.getMessage(), e);
                    String str2 = b.k + this.b;
                    webView = this.f23546a;
                    if (webView instanceof AuthWebView) {
                        webView = (AuthWebView) webView;
                    }
                    webView.loadUrl(str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    private com.ali.auth.third.ui.webview.a a(String str) {
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        int port = uri.getPort();
        String lastPathSegment = uri.getLastPathSegment();
        uri.getQuery();
        int iIndexOf = str.indexOf("?");
        String strSubstring = iIndexOf == -1 ? null : str.substring(iIndexOf + 1);
        com.ali.auth.third.ui.webview.a aVar = new com.ali.auth.third.ui.webview.a();
        aVar.b = lastPathSegment;
        aVar.f23547a = host;
        aVar.c = strSubstring;
        aVar.d = port;
        return aVar;
    }

    private void a(WebView webView, String str) {
        try {
            int iIndexOf = str.indexOf(58, 9);
            webView.post(new a(webView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", str.substring(iIndexOf + 1, str.indexOf(47, iIndexOf)))));
        } catch (Exception e) {
            SDKLogger.e("ui", "fail to handler windvane request, the error message is " + e.getMessage(), e);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null) {
            return false;
        }
        if (str3.equals("wv_hybrid:")) {
            a(webView, str2);
        } else {
            if (!TextUtils.equals(str3, "hv_hybrid:") || !(webView instanceof AuthWebView)) {
                return false;
            }
            AuthWebView authWebView = (AuthWebView) webView;
            com.ali.auth.third.ui.webview.a aVarA = a(str2);
            com.ali.auth.third.ui.context.a aVar = new com.ali.auth.third.ui.context.a();
            aVar.b = aVarA.d;
            aVar.f23523a = authWebView;
            Object bridgeObj = authWebView.getBridgeObj(aVarA.f23547a);
            if (bridgeObj == null) {
                Message messageCreateMessage = MessageUtils.createMessage(10000, aVarA.f23547a);
                SDKLogger.e(f23545a, messageCreateMessage.toString());
                aVar.a(messageCreateMessage.code, messageCreateMessage.message);
            } else {
                try {
                    Method method = bridgeObj.getClass().getMethod(aVarA.b, com.ali.auth.third.ui.context.a.class, String.class);
                    if (method.isAnnotationPresent(BridgeMethod.class)) {
                        try {
                            Object[] objArr = new Object[2];
                            objArr[0] = aVar;
                            objArr[1] = TextUtils.isEmpty(aVarA.c) ? "{}" : aVarA.c;
                            method.invoke(bridgeObj, objArr);
                        } catch (Exception e) {
                            Message messageCreateMessage2 = MessageUtils.createMessage(10010, e.getMessage());
                            SDKLogger.e(f23545a, messageCreateMessage2.toString() + "," + e.toString());
                            aVar.a(messageCreateMessage2.code, messageCreateMessage2.message);
                        }
                    } else {
                        Message messageCreateMessage3 = MessageUtils.createMessage(952, aVarA.f23547a, aVarA.b);
                        SDKLogger.e(f23545a, messageCreateMessage3.toString());
                        aVar.a(messageCreateMessage3.code, messageCreateMessage3.message);
                    }
                    jsPromptResult.confirm("");
                    return true;
                } catch (NoSuchMethodException e2) {
                    Message messageCreateMessage4 = MessageUtils.createMessage(SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, aVarA.f23547a, aVarA.b);
                    SDKLogger.e(f23545a, messageCreateMessage4 + "," + e2.toString());
                    aVar.a(messageCreateMessage4.code, messageCreateMessage4.message);
                }
            }
        }
        jsPromptResult.confirm("");
        return true;
    }
}
