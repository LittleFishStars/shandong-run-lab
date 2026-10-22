package com.byazt.apd;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.bzd.x;
import com.byazt.el.SSWebView;
import com.byazt.ol.n;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1580, 2353})
public class EcBackUpWebView extends SSWebView {
    public EcBackUpWebView(Context context) {
        super(context);
        x.c(new Runnable() { // from class: com.byazt.apd.EcBackUpWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcBackUpWebView.this.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        setWebViewClient(new WebViewClient() { // from class: com.byazt.apd.EcBackUpWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (renderProcessGoneDetail.didCrash()) {
                    if (webView != null) {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                        n.c().tt();
                    }
                    return true;
                }
                if (webView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(webView);
                    }
                    webView.destroy();
                    n.c().tt();
                }
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
        com.byazt.ogz.tt ttVarKu = gt.tt().ku();
        if (ttVarKu != null) {
            String strUj = ttVarKu.uj();
            if (!TextUtils.isEmpty(strUj)) {
                loadUrl(strUj);
                return;
            }
        }
        loadUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/pattern-aggregation/pattern-aggregation-eCommerce-abtest/shoppingMall-defaultPage/index.html");
    }

    @Override // com.byazt.el.SSWebView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.destroy();
    }
}
