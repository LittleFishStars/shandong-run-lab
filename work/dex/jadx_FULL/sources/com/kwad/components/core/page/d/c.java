package com.kwad.components.core.page.d;

import android.annotation.SuppressLint;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends Presenter {
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private as.b fo = new as.b() { // from class: com.kwad.components.core.page.d.c.1
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new as(this.fo, com.kwad.sdk.core.response.helper.a.aY(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))));
        aVar.a(new am(this.fi));
        aVar.b(new o(this.fi));
        aVar.b(new n(this.fi));
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        bVar2.mScreenOrientation = 0;
        bVar2.ade = this.mAdWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bk() {
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.fh = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) SB()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().bV(true).fo(this.mAdTemplate));
        bi();
        bk();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.helper.a.aY(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        bl();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
