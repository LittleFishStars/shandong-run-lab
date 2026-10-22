package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends c implements View.OnClickListener {
    private Runnable QE;

    @Nullable
    public b Qv;
    public b.C1200b Qw;
    private KsAdWebView ff;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private az fk;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private boolean QF = false;
    private com.kwad.sdk.core.webview.d.a.a fl = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.QF);
            e.a(e.this, true);
        }
    };
    private al.b fm = new al.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.ff.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    private ak.b fn = new ak.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.bq();
        }
    };
    private as.b fo = new as.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            com.kwad.sdk.core.d.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.pM();
                return;
            }
            e.this.bq();
            if (e.this.getContext() != null) {
                ae.V(e.this.getContext(), ag.dl(e.this.getContext()));
            }
        }
    };

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.Qx.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        AdBaseFrameLayout adBaseFrameLayout = this.Qx.mRootContainer;
        bVar2.bbV = adBaseFrameLayout;
        bVar2.adW = adBaseFrameLayout;
        bVar2.ade = this.ff;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bk() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.ff);
        this.fh = aVar;
        a(aVar);
        this.ff.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.QF);
        if (this.ff.getVisibility() != 0) {
            return;
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yz();
        }
        this.ff.setVisibility(4);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yA();
        }
        if (this.QF) {
            com.kwad.sdk.core.adlog.c.cx(this.mAdTemplate);
        }
        b bVar = this.Qv;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.Qv.an(this.QF);
    }

    private void pK() {
        bk();
        this.ff.loadUrl(this.Qw.url);
        this.ff.postDelayed(pL(), com.igexin.push.config.c.j);
        this.ff.setBackgroundColor(0);
        this.ff.getBackground().setAlpha(0);
        this.ff.setVisibility(0);
    }

    private Runnable pL() {
        if (this.QE == null) {
            this.QE = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.bq();
                    if (e.this.getContext() != null) {
                        ae.V(e.this.getContext(), ag.dl(e.this.getContext()));
                    }
                }
            };
        }
        return this.QE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        Runnable runnable = this.QE;
        if (runnable != null) {
            this.ff.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.ff.setVisibility(8);
        this.ff.release();
        bl();
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        d dVar = this.Qx;
        this.Qv = dVar.Qv;
        this.Qw = dVar.Qw;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Qx.mApkDownloadHelper;
        bi();
        pK();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.cx(this.mAdTemplate);
        b bVar = this.Qv;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ff = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        pM();
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.QF = true;
        return true;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.fi, this.mApkDownloadHelper, this.fl));
        aVar.a(new z(this.fi, this.mApkDownloadHelper, this.fl, 1));
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new com.kwad.components.core.webview.jshandler.ae(this.fi));
        aVar.a(new al(this.fi, this.fm));
        aVar.a(new as(this.fo, this.Qw.url));
        az azVar = new az();
        this.fk = azVar;
        aVar.a(azVar);
        aVar.a(new bc(this.fi, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(e.this.mAdTemplate);
                String strAE = com.kwad.sdk.core.response.helper.a.aE(adInfoEO);
                if (com.kwad.sdk.core.response.helper.a.aU(adInfoEO) && com.kwad.sdk.core.response.helper.a.aL(adInfoEO) && au.aw(e.this.getContext(), strAE) && com.kwad.components.core.r.a.wm().wq() && com.kwad.sdk.core.response.helper.a.aT(adInfoEO) == 1) {
                    e.this.Qv.dismiss();
                }
            }
        }));
        aVar.a(new ak(this.fn));
        aVar.a(new am(this.fi));
        aVar.b(new o(this.fi));
        aVar.b(new n(this.fi));
    }
}
