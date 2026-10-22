package com.kwad.components.ad.reward.n;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e extends com.kwad.sdk.core.download.a.a implements al.b, as.b {
    private View Dk;
    private bf Dl;
    private f Dm;
    private KsAdWebView ff;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private com.kwad.sdk.core.webview.d.a.a fl;

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.Dl != null) {
                e.this.Dl.aj(true);
            }
        }
    };

    public e(KsAdWebView ksAdWebView, View view, @Nullable com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.Dk = view;
        this.ff = ksAdWebView;
        this.mApkDownloadHelper = dVar;
        this.fl = aVar;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void ac(String str) {
        if (br.isNullString(str)) {
            lz();
            return;
        }
        bl();
        this.ff.setClientConfig(this.ff.getClientConfig().fo(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.ff);
        this.fh = aVar;
        a(aVar, str);
        this.ff.addJavascriptInterface(this.fh, "KwaiAd");
        this.ff.loadUrl(str);
    }

    private void ae(boolean z) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    @NonNull
    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                e.this.lz();
            }
        };
    }

    private void k(String str, int i) {
        f fVar = this.Dm;
        if (fVar != null) {
            fVar.i(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        View view = this.Dk;
        if (view != null) {
            view.setVisibility(0);
        }
        ae(false);
    }

    public final void ly() {
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.c(this);
        }
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.helper.a.cK(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.helper.a.af(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        k(com.kwad.sdk.core.response.helper.a.eG(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            k(com.kwad.sdk.core.response.helper.a.eF(i), i);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        bVar2.mScreenOrientation = 0;
        bVar2.bbV = null;
        bVar2.adW = viewGroup;
        bVar2.ade = this.ff;
        bVar2.mReportExtData = null;
        bVar2.bbX = true;
    }

    public final void a(f fVar) {
        this.Dm = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.ff.getBackground() != null) {
                this.ff.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        ac(com.kwad.sdk.core.response.helper.b.cV(this.mAdTemplate));
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new z(this.fi, this.mApkDownloadHelper, this.fl));
        aVar.a(new af(this.fi));
        aVar.a(new ae(this.fi));
        aVar.a(new as(this, str));
        bf bfVar = new bf();
        this.Dl = bfVar;
        aVar.a(bfVar);
        aVar.a(new am(this.fi));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.fi));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new al(this.fi, this));
        aVar.a(new bc(this.fi, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.ff.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ae(true);
        } else {
            lz();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.al.b
    public final void a(@NonNull al.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }
}
