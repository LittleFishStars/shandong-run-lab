package com.kc.dw.core.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.ipd.dsp.internal.i.q;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.j0;
import com.kc.dw.core.utils.m0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends k {
    public final e e;
    public volatile boolean f;
    public com.kc.dw.core.webview.listener.b g;
    public g h;

    public d(Context context, String str, e eVar) {
        super(context);
        this.f = true;
        this.e = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean[] zArr, j0 j0Var, boolean z) {
        LogUtil.dev("FreedomWebViewClient", "h5 openDeepLink res :" + z);
        if (zArr[0]) {
            boolean z2 = j0Var.d;
            try {
                com.kc.dw.core.webview.listener.b bVar = this.g;
                if (bVar != null) {
                    bVar.onJumpDPRes(z, z2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.core.webview.k
    public boolean a(Intent intent) {
        if (!this.f) {
            return false;
        }
        try {
            com.kc.dw.core.webview.listener.b bVar = this.g;
            if (bVar != null) {
                bVar.onDPStart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final boolean[] zArr = {false};
        final j0 j0Var = new j0(com.igexin.push.config.c.j, true);
        m0.b.f39387a.f39386a = new m0.a(this, zArr, j0Var) { // from class: com.kc.dw.core.webview.d$$ExternalSyntheticLambda0
            public final d f$0;
            public final boolean[] f$1;
            public final j0 f$2;

            {
                this.f$0 = this;
                this.f$1 = zArr;
                this.f$2 = j0Var;
            }

            @Override // com.kc.dw.core.utils.m0.a
            public final void a(boolean z) {
                this.f$0.a(this.f$1, this.f$2, z);
            }
        };
        com.kc.dw.core.router.helper.a.a(j0Var);
        zArr[0] = super.a(intent);
        StringBuilder sbA = com.kc.dw.activity.a.a("super.jump res:");
        sbA.append(zArr[0]);
        LogUtil.dev("FreedomWebViewClient", sbA.toString());
        if (!zArr[0]) {
            boolean z = j0Var.d;
            try {
                com.kc.dw.core.webview.listener.b bVar2 = this.g;
                if (bVar2 != null) {
                    bVar2.onJumpDPRes(false, z);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            m0.b.f39387a.f39386a = null;
            com.kc.dw.core.router.helper.a.b(j0Var);
        }
        return zArr[0];
    }

    @Override // com.kc.dw.core.webview.k, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String str2;
        LogUtil.dev("FreedomWebViewClient", "onPageFinished:" + str);
        super.onPageFinished(webView, str);
        e eVar = this.e;
        eVar.getClass();
        try {
            LogUtil.dev("H5LoadSate", "notifyOnPageFinished:" + str);
            if (TextUtils.isEmpty(str)) {
                str2 = "notifyOnPageFinished url null";
            } else {
                if (!eVar.b.contains(str)) {
                    eVar.b.add(str);
                }
                if (eVar.d != null) {
                    com.kc.dw.core.webview.listener.c cVar = eVar.d;
                    boolean z = false;
                    boolean z2 = eVar.b.size() == 1;
                    try {
                        if (!TextUtils.isEmpty(str) && eVar.b.contains(str) && !eVar.f39438a.containsKey(str) && !l.a(str)) {
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                    if (cVar.onPageFinished(str, z2, z, eVar.a(str))) {
                        return;
                    }
                    LogUtil.dev("H5LoadSate", "notifyOnPageFinished nokeep");
                    eVar.d = null;
                    return;
                }
                str2 = "notifyOnPageFinished listener null";
            }
            LogUtil.dev("H5LoadSate", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtil.dev("FreedomWebViewClient", "onPageStarted:" + str);
        e eVar = this.e;
        eVar.getClass();
        try {
            eVar.c = str;
            LogUtil.dev("H5LoadSate", "notifyOnPageStarted:" + str);
            if (eVar.d != null && !TextUtils.isEmpty(str)) {
                eVar.d.onPageStarted(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        i iVar;
        super.onReceivedError(webView, i, str, str2);
        StringBuilder sbA = com.kc.dw.activity.a.a("onReceivedError2:");
        sbA.append(webView.getUrl());
        sbA.append(q.a.i);
        sbA.append(i);
        sbA.append(q.a.i);
        sbA.append(str);
        sbA.append(" ");
        sbA.append(str2);
        LogUtil.dev("FreedomWebViewClient", sbA.toString());
        try {
            g gVar = this.h;
            if (gVar == null || (iVar = ((l.a) gVar).f39445a.g) == null) {
                return;
            }
            iVar.onWebError(i, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        try {
            LogUtil.dev("FreedomWebViewClient", "onReceivedError1:" + webView.getUrl() + " " + webResourceRequest.getUrl());
            this.e.a(webResourceRequest.getUrl().toString(), -1);
            try {
                if (this.h != null) {
                    Integer num = com.kc.dw.core.exception.b.f39252a;
                    ((l.a) this.h).a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()));
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        try {
            int statusCode = webResourceResponse.getStatusCode();
            LogUtil.dev("FreedomWebViewClient", "onReceivedHttpError " + webResourceRequest.isForMainFrame() + " statusCode:" + statusCode + u15.f19942b + webView.getUrl() + " " + webResourceRequest.getUrl());
            if (statusCode == 404 || statusCode >= 500) {
                this.e.a(webResourceRequest.getUrl().toString(), statusCode);
            }
            g gVar = this.h;
            if (gVar != null) {
                ((l.a) gVar).a(statusCode, "onReceivedHttpError");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        StringBuilder sbA = com.kc.dw.activity.a.a("onReceivedSslError:");
        sbA.append(webView.getUrl());
        sbA.append(" ");
        sbA.append(sslError.toString());
        LogUtil.dev("FreedomWebViewClient", sbA.toString());
        g gVar = this.h;
        if (gVar != null) {
            Integer num = com.kc.dw.core.exception.b.f39252a;
            ((l.a) gVar).a(800005, "onReceivedSslError");
        }
    }
}
