package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jsPublicBridge.KSAdChinaMobileJSBridge;
import com.kwad.components.core.webview.jsPublicBridge.KSAdPublicJSBridge;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.core.webview.tachikoma.b.j;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.l;
import com.kwad.components.core.webview.tachikoma.b.s;
import com.kwad.components.core.webview.tachikoma.c.g;
import com.kwad.components.core.webview.tachikoma.c.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.d;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ae;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private KsAdWebView ND;
    private KsAdWebView.c aec;
    private com.kwad.components.core.webview.a.a aoA;
    private aw aoB;
    private d aoC;
    private boolean aoD;
    private com.kwad.components.core.webview.jshandler.a.c aoE;
    private KSAdPublicJSBridge aoF;
    private KSAdChinaMobileJSBridge aoG;
    private boolean aoH = false;
    private as.b aoI = new as.b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            if (b.this.jq != null) {
                b.this.jq.a(aVar);
            }
        }
    };
    private ViewGroup aoz;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private c jq;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private String mPageUrl;

    public static class a {
        private KsAdWebView ND;
        private KsAdWebView.c aec;
        private boolean aoD;
        private com.kwad.components.core.webview.jshandler.a.c aoE;
        private ViewGroup aoz;
        private c jq;
        private AdTemplate mAdTemplate;
        private com.kwad.components.core.e.d.d mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        @Nullable
        public final a a(c cVar) {
            this.jq = cVar;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.aec = cVar;
            return this;
        }

        @Nullable
        public final a bi(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final a bj(boolean z) {
            this.aoD = z;
            return this;
        }

        @NonNull
        public final a bu(String str) {
            this.mPageUrl = str;
            return this;
        }

        @NonNull
        public final a f(KsAdWebView ksAdWebView) {
            this.ND = ksAdWebView;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final com.kwad.components.core.e.d.d iv() {
            return this.mApkDownloadHelper;
        }

        @NonNull
        public final a m(ViewGroup viewGroup) {
            this.aoz = viewGroup;
            return this;
        }

        public final String tT() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c ut() {
            return this.aec;
        }

        public final ViewGroup yh() {
            return this.aoz;
        }

        public final KsAdWebView yi() {
            return this.ND;
        }

        public final c yj() {
            return this.jq;
        }

        public final boolean yk() {
            return this.aoD;
        }

        public final com.kwad.components.core.webview.jshandler.a.c yl() {
            return this.aoE;
        }

        public final a a(com.kwad.components.core.webview.jshandler.a.c cVar) {
            this.aoE = cVar;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.d dVar) {
            this.mApkDownloadHelper = dVar;
            return this;
        }

        public final a f(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.aoA;
        if (aVar2 != null) {
            aVar2.destroy();
            this.aoA = null;
        }
        KSAdPublicJSBridge kSAdPublicJSBridge = this.aoF;
        if (kSAdPublicJSBridge != null) {
            kSAdPublicJSBridge.destroy();
            this.aoF = null;
        }
        if (this.aoG != null) {
            this.aoG = null;
        }
    }

    private static String bt(String str) {
        if (str != null && !str.trim().isEmpty()) {
            try {
                return Uri.parse(str).getHost();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return "";
    }

    private void e(KsAdWebView ksAdWebView) {
        bl();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.fi);
        this.aoA = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void fA() {
        this.ND.setClientConfig(this.ND.getClientConfig().fo(this.mAdTemplate).eU(yf()).b(ye()).a(yd()).c(this.aec));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.jq != null) {
                    b.this.jq.a(aVar);
                }
            }
        };
    }

    private boolean ya() {
        c cVar = this.jq;
        if (cVar == null) {
            return false;
        }
        return cVar.uz();
    }

    private boolean yb() {
        return false;
    }

    private am.a yc() {
        return new am.a() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.am.a
            public final void onAdShow() {
                if (b.this.jq != null) {
                    b.this.jq.onAdShow();
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.b yd() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.aoB != null) {
                    b.this.aoB.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.aoB != null) {
                    b.this.aoB.onSuccess();
                }
            }
        };
    }

    private KsAdWebView.e ye() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (b.this.jq != null) {
                    b.this.jq.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (b.this.jq != null) {
                    b.this.jq.onReceivedHttpError(i, str, str2);
                }
            }
        };
    }

    private int yf() {
        return com.kwad.sdk.core.response.helper.a.V(e.eO(this.mAdTemplate)) ? 5 : 1;
    }

    public final void bi(boolean z) {
        this.aoH = true;
    }

    public final void kV() {
        bl();
        if (this.aoC != null) {
            com.kwad.sdk.core.download.b.Lz().a(this.aoC);
        }
        this.aoE = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.fh = aVar;
        b(aVar, this.fi);
        c cVar = this.jq;
        if (cVar != null) {
            cVar.a(this.fh, this.fi);
        }
        ksAdWebView.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        bVar2.mScreenOrientation = 0;
        bVar2.ade = this.ND;
        bVar2.adW = this.aoz;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void c(KsAdWebView ksAdWebView) {
        KSAdPublicJSBridge kSAdPublicJSBridge = new KSAdPublicJSBridge(ksAdWebView);
        this.aoF = kSAdPublicJSBridge;
        ksAdWebView.addJavascriptInterface(kSAdPublicJSBridge, "KwaiAdPublic");
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void d(KsAdWebView ksAdWebView) {
        KSAdChinaMobileJSBridge kSAdChinaMobileJSBridge = new KSAdChinaMobileJSBridge(ksAdWebView);
        this.aoG = kSAdChinaMobileJSBridge;
        ksAdWebView.addJavascriptInterface(kSAdChinaMobileJSBridge, "KSAdChinaMobile");
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.tT();
        this.mAdTemplate = aVar.getAdTemplate();
        this.aoz = aVar.yh();
        this.ND = aVar.yi();
        this.jq = aVar.yj();
        this.mApkDownloadHelper = aVar.iv();
        this.aoD = aVar.yk();
        this.aec = aVar.ut();
        this.aoE = aVar.yl();
        fA();
        a(this.jq, this.ND);
        bi();
        if (com.kwad.sdk.core.config.e.KY().contains(bt(this.mPageUrl)) && this.aoH) {
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.R(e.eO(this.mAdTemplate))) {
            e(this.ND);
        } else if (com.kwad.sdk.core.response.helper.b.fm(this.mPageUrl)) {
            b(this.ND);
        }
        c(this.ND);
        d(this.ND);
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        az azVar = new az();
        aVar.a(azVar);
        a(azVar);
        aVar.a(new v());
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        aVar.a(new w());
        aVar.a(new q());
        aVar.a(new r());
        am amVar = new am(bVar);
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        amVar.a(yc());
        aVar.a(amVar);
        aVar.a(new af(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        }
        if (!this.aoD) {
            aVar.a(new ac(this.fi, this.mApkDownloadHelper, getClickListener(), ya(), false, true));
            aVar.a(new z(this.fi, this.mApkDownloadHelper, getClickListener(), ya(), 0, yb(), true));
        }
        aVar.a(new bc(this.fi, this.mApkDownloadHelper));
        aVar.a(new au(this.fi));
        aVar.a(new ar(this.fi.ade.getContext(), this.mAdTemplate));
        aVar.a(new bh(new bh.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.bh.a
            public final void yg() {
                if (com.kwad.sdk.core.response.helper.b.dQ(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.fi.ade.getContext(), new com.kwad.components.core.e.c.b.a().aH(b.this.mAdTemplate).ao(com.kwad.sdk.core.response.helper.b.dP(b.this.mAdTemplate)).pJ());
                }
            }
        }));
        aVar.a(new aj(this.fi));
        aVar.a(new as(this.aoI, this.mPageUrl));
        aw awVar = new aw();
        this.aoB = awVar;
        aVar.a(awVar);
        aVar.a(new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.jq != null) {
                    b.this.jq.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(t tVar) {
                if (TextUtils.isEmpty(tVar.message)) {
                    return;
                }
                ae.d(b.this.fi.ade.getContext(), tVar.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new ai(bVar));
        if (com.kwad.sdk.core.response.helper.a.aL(e.eO(this.mAdTemplate))) {
            final l lVar = new l();
            aVar.a(lVar);
            this.aoC = new d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar2 = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar2.aui = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.b.Lz().a(this.aoC, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(g gVar) {
                com.kwad.components.core.p.a.vL().a(gVar.actionType, b.this.mAdTemplate, gVar.QY);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(b.this.fi.ade.getContext(), new AdWebViewActivityProxy.a.C1220a().aY(oVar.title).aZ(oVar.url).aQ(true).aY(b.this.mAdTemplate).ua());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.f());
        aVar.a(new i());
        aVar.a(new com.kwad.components.core.webview.jshandler.l());
        aVar.a(new com.kwad.components.core.webview.jshandler.e());
        com.kwad.components.core.webview.jshandler.ae aeVar = new com.kwad.components.core.webview.jshandler.ae(this.fi);
        aeVar.a(new com.kwad.components.core.webview.jshandler.ae.c() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.ae.c
            public final void c(com.kwad.components.core.webview.jshandler.ae.a aVar2) {
                if (b.this.jq != null) {
                    b.this.jq.b(aVar2);
                }
            }
        });
        aVar.a(aeVar);
        aVar.a(new m(this.fi.ade.getContext(), this.mAdTemplate));
        aVar.a(new al(this.fi, new al.b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(al.a aVar2) {
                if (b.this.jq != null) {
                    b.this.jq.a(aVar2);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.k());
        aVar.a(new u());
        aVar.a(new com.kwad.components.core.webview.jshandler.t());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.f(this.fi.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.d(this.fi.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.b(this.aoE));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.a());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.e(this.fi.getContext()));
    }

    private void a(az azVar) {
        c cVar = this.jq;
        if (cVar == null) {
            return;
        }
        cVar.a(azVar);
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.uy()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }
}
