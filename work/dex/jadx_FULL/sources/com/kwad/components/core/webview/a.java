package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.ce;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private WebView ade;
    private final Map<String, com.kwad.sdk.core.webview.c.a> aou = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a aov = new d();
    private boolean aow;

    public a(WebView webView) {
        this.ade = webView;
        xZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, String str2) {
        if (this.aow) {
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback is empty");
                return;
            }
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.ade;
            if (webView == null) {
                return;
            }
            ce.a(webView, str, str2);
        }
    }

    private void xZ() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new ab());
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        } else {
            this.aou.put(aVar.getKey(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.aou.get(bVar.bcX);
            if (aVar == null) {
                aVar = this.aov;
            }
            WebView webView = this.ade;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.bcX, bVar.data);
            }
            if (aVar != null) {
                aVar.a(bVar.data, !TextUtils.isEmpty(bVar.bcY) ? new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void b(com.kwad.sdk.core.b bVar2) {
                        a.this.q(bVar.bcY, new f(bVar2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i, String str2) {
                        a.this.q(bVar.bcY, new e(i, str2).toJson().toString());
                    }
                } : new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void b(com.kwad.sdk.core.b bVar2) {
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i, String str2) {
                    }
                });
            } else {
                com.kwad.sdk.core.d.c.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> it = this.aou.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.aow = true;
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.aou.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.aou.put(aVar.getKey(), aVar);
    }
}
