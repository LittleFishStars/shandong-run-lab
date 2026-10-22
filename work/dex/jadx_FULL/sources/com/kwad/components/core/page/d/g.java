package com.kwad.components.core.page.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends d {
    private int adV = -1;
    private ViewGroup adW;
    private final a adX;
    private WebView ade;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    public interface a {
        void bw(int i);
    }

    public g(a aVar, boolean z) {
        this.adX = aVar;
        this.mIsRewardLandPage = z;
    }

    private void bb(String str) {
        bk();
        this.ade.loadUrl(str);
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        bVar2.adW = this.adW;
        bVar2.ade = this.ade;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bk() {
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.ade);
        this.fh = aVar;
        a(aVar);
        this.ade.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    private aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.core.page.d.g.2
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(g.this.ade.getContext(), new AdWebViewActivityProxy.a.C1220a().aY(bVar.title).aZ(bVar.url).aQ(true).aY(g.this.mAdTemplate).ua());
            }
        };
    }

    private as.b uj() {
        return new as.b() { // from class: com.kwad.components.core.page.d.g.1
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar) {
                g.this.adV = aVar.status;
                if (g.this.adX != null) {
                    g.this.adX.bw(aVar.status);
                }
                if (aVar.status == 1) {
                    g.this.adW.setVisibility(0);
                } else {
                    g.this.ade.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.d.d, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.adT.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String strDh = com.kwad.sdk.core.response.helper.b.dh(adTemplate);
        if (!TextUtils.isEmpty(strDh)) {
            bi();
            bb(strDh);
        } else {
            a aVar = this.adX;
            if (aVar != null) {
                aVar.bw(this.adV);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ade = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.adW = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.ade.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bl();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.adT.mAdTemplate);
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new bc(this.fi, dVar));
        aVar.a(new ae(this.fi));
        aVar.a(new az());
        aVar.a(new as(uj(), com.kwad.sdk.core.response.helper.b.dh(this.mAdTemplate)));
        aVar.a(new am(this.fi));
        aVar.b(new o(this.fi));
        aVar.b(new n(this.fi));
        aVar.a(new aq(getOpenNewPageListener()));
        aVar.a(new ac(this.fi, dVar, null, (byte) 0));
        aVar.a(new z(this.fi, dVar, null, 2, this.mIsRewardLandPage));
    }
}
