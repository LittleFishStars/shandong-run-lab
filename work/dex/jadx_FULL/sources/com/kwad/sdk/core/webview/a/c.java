package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a NL;
    private boolean bcm = false;
    private boolean bcn = false;
    private boolean bco = false;
    private boolean bcp = false;
    private boolean aeI = false;

    public static class a {
        private int ads;
        private KsAdWebView.c aec;
        private KsAdWebView.b atg;
        private KsAdWebView.e bcr;
        private KsAdWebView.d bcs;
        private boolean bct;
        private boolean bcy;
        private AdTemplate mAdTemplate;
        private Context mContext;
        private boolean bcu = true;
        private boolean bcv = true;
        private boolean bcw = false;
        private boolean bcx = false;
        private boolean bcl = true;
        private boolean bcz = false;
        private long bcA = 600;
        private long bcB = 0;

        public a(Context context) {
            this.mContext = context;
        }

        private boolean Px() {
            return this.bcz;
        }

        public final boolean PA() {
            return this.bcx;
        }

        public final boolean PB() {
            return this.bcl;
        }

        public final boolean PC() {
            return this.bcu;
        }

        public final boolean PD() {
            return this.bcy;
        }

        public final boolean PE() {
            if (!Px()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.bcB;
            return j > 0 && jCurrentTimeMillis - j <= this.bcA;
        }

        public final boolean PF() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.helper.a.dE(e.eO(adTemplate));
        }

        public final boolean PG() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.helper.a.dF(e.eO(adTemplate));
        }

        public final KsAdWebView.d Pw() {
            return this.bcs;
        }

        public final boolean Py() {
            return this.bcv;
        }

        public final boolean Pz() {
            return this.bcw;
        }

        public final a a(KsAdWebView.d dVar) {
            this.bcs = dVar;
            return this;
        }

        public final void aR(long j) {
            this.bcB = j;
        }

        public final a b(KsAdWebView.e eVar) {
            this.bcr = eVar;
            return this;
        }

        public final a bP(boolean z) {
            this.bcz = true;
            return this;
        }

        public final a bQ(boolean z) {
            this.bct = true;
            return this;
        }

        public final a bR(boolean z) {
            this.bcv = z;
            return this;
        }

        public final a bS(boolean z) {
            this.bcw = true;
            return this;
        }

        public final a bT(boolean z) {
            this.bcx = true;
            return this;
        }

        public final a bU(boolean z) {
            this.bcu = z;
            return this;
        }

        public final a bV(boolean z) {
            this.bcy = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.aec = cVar;
            return this;
        }

        public final a eU(int i) {
            this.ads = i;
            return this;
        }

        public final a fo(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e jG() {
            return this.bcr;
        }

        public final KsAdWebView.b oq() {
            return this.atg;
        }

        public final com.kwad.sdk.core.adlog.c.a qa() {
            return com.kwad.sdk.core.adlog.c.a.Jf().ea(this.ads).eb(this.bct ? 1 : 0);
        }

        public final void release() {
            this.atg = null;
            this.bcs = null;
            this.aec = null;
            this.bcr = null;
            this.mContext = null;
            this.mAdTemplate = null;
        }

        public final KsAdWebView.c ut() {
            return this.aec;
        }

        public final a a(KsAdWebView.b bVar) {
            this.atg = bVar;
            return this;
        }
    }

    private int a(@NonNull a aVar, String str) {
        boolean zCr;
        int I;
        try {
            zCr = com.kwad.sdk.core.response.helper.a.cr(e.eO(aVar.getAdTemplate()));
        } catch (Throwable unused) {
            zCr = false;
        }
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        if (zCr) {
            if (aVar2.QZ == null) {
                aVar2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
            }
            aVar2.QZ.aLr = true;
            I = com.kwad.sdk.core.download.a.b.a(aVar.getContext(), str, new com.kwad.sdk.core.download.a.b.a() { // from class: com.kwad.sdk.core.webview.a.c.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public final void aT(int i) {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onPreStart() {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void qG() {
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final boolean qH() {
                    return true;
                }
            });
        } else {
            I = com.kwad.sdk.core.download.a.b.I(aVar.getContext(), str);
        }
        if (I == 1) {
            if (aVar.oq() != null) {
                aVar.oq().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.c(aVar.getAdTemplate(), "", 2, aVar2);
            com.kwad.sdk.core.adlog.c.m(aVar.getAdTemplate(), zCr);
        } else {
            if (aVar.oq() != null) {
                aVar.oq().onFailed();
            }
            if (I == -1 && !this.aeI) {
                this.aeI = true;
                com.kwad.sdk.core.adlog.c.d(aVar.getAdTemplate(), "", 2, aVar2);
                com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), zCr, 0);
            } else if (I == 0 && TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), zCr, 3);
            } else if (I == 0 && aVar.getContext() == null) {
                com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), zCr, 4);
            }
        }
        return I;
    }

    private void eS(int i) {
        if (this.NL.Pz()) {
            if (this.bcp) {
                return;
            }
            this.bcp = true;
            com.kwad.sdk.core.adlog.c.cB(this.NL.getAdTemplate());
            return;
        }
        if (this.bco) {
            return;
        }
        this.bco = true;
        if (this.NL.PA()) {
            com.kwad.sdk.core.adlog.c.p(this.NL.getAdTemplate(), i, 2);
        } else if (i == 0) {
            com.kwad.sdk.core.adlog.c.p(this.NL.getAdTemplate(), i, 1);
        } else {
            com.kwad.sdk.core.adlog.c.p(this.NL.getAdTemplate(), i, 0);
        }
    }

    private void eT(int i) {
        if (this.bcn) {
            return;
        }
        this.bcn = true;
        if (!this.NL.Pz()) {
            if (i < 0 && i != -1000) {
                com.kwad.sdk.core.adlog.c.q(this.NL.getAdTemplate(), i, 1);
                return;
            } else if (!this.NL.PA() && i > 0) {
                com.kwad.sdk.core.adlog.c.q(this.NL.getAdTemplate(), i, 2);
                return;
            }
        }
        com.kwad.sdk.core.adlog.c.q(this.NL.getAdTemplate(), i, 0);
    }

    private boolean fH(String str) {
        int iBS;
        try {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (!str.startsWith(WVUCWebViewClient.SCHEME_TEL) && !str.startsWith(WVUCWebViewClient.SCHEME_SMS)) {
                    a aVar = this.NL;
                    if (aVar != null) {
                        try {
                            iBS = com.kwad.sdk.core.response.helper.a.bS(e.eO(aVar.getAdTemplate()));
                        } catch (Throwable unused) {
                            iBS = -1000;
                        }
                        if (!this.NL.Pz() && !this.bcm) {
                            this.bcm = true;
                            com.kwad.sdk.core.adlog.c.v(this.NL.getAdTemplate(), iBS);
                        }
                        if (this.NL.Py()) {
                            eS(iBS);
                            a(this.NL, str);
                            return true;
                        }
                        if (fI(str)) {
                            eT(iBS);
                            return true;
                        }
                        eT(iBS);
                    }
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                a aVar2 = this.NL;
                if (aVar2 != null) {
                    aVar2.getContext().startActivity(intent);
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static boolean fI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    public final void S(String str) {
        this.mUniqueId = str;
    }

    public final void destroy() {
        a aVar = this.NL;
        if (aVar != null) {
            aVar.release();
            this.NL = null;
        }
    }

    public final a getClientConfig() {
        return this.NL;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ah(this.mUniqueId, "onPageFinished");
        a aVar = this.NL;
        if (aVar == null || aVar.jG() == null) {
            return;
        }
        this.NL.jG().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ah(this.mUniqueId, "onPageStart");
        a aVar = this.NL;
        if (aVar == null || aVar.jG() == null) {
            return;
        }
        this.NL.jG().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.d.c.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.NL;
        if (aVar != null && aVar.jG() != null) {
            this.NL.jG().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.aj(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        try {
            String string = webResourceRequest.getUrl().toString();
            int statusCode = webResourceResponse.getStatusCode();
            a aVar = this.NL;
            if (aVar == null || aVar.jG() == null) {
                return;
            }
            this.NL.jG().onReceivedHttpError(statusCode, "http errorCode: " + statusCode, string);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        try {
            String url = sslError.getUrl();
            int primaryError = sslError.getPrimaryError();
            a aVar = this.NL;
            if (aVar == null || aVar.jG() == null) {
                return;
            }
            this.NL.jG().onReceivedHttpError(primaryError, "SSL errorCode: " + primaryError, url);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.NL = aVar;
        setNeedHybridLoad(aVar.PB());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ah(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.NL;
        if (aVar == null || !aVar.PE() || ((this.NL.Pw() != null && this.NL.Pw().shouldOverrideUrlLoading(webView, str)) || fH(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
