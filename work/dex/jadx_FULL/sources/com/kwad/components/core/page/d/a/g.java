package com.kwad.components.core.page.d.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bg;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.by;
import java.net.URI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends a implements com.kwad.components.core.webview.jshandler.a.c {
    private static final Handler jk = new Handler(Looper.getMainLooper());
    public AdWebViewActivityProxy.a adC;
    private az aeD;
    private av aeE;
    private bi aeF;
    private String aeG;
    private Runnable aeH;
    private com.kwad.components.core.webview.b jp;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean adK = false;
    private boolean aeC = false;
    private boolean aeI = false;
    private final com.kwad.sdk.core.c.c Bq = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.d.a.g.3
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    private com.kwad.components.core.webview.jshandler.b aee = new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.core.page.d.a.g.4
        @Override // com.kwad.components.core.webview.jshandler.b
        public final void ux() {
            if (g.this.aeE != null) {
                g.this.aeE.yw();
            }
        }
    };
    private com.kwad.components.core.webview.c jq = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.d.a.g.5
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bg(new bg.b() { // from class: com.kwad.components.core.page.d.a.g.5.1
                @Override // com.kwad.components.core.webview.jshandler.bg.b
                public final void a(bg.a aVar2) {
                    f.a aVar3 = g.this.adZ.aed;
                    if (aVar3 == null || aVar2 == null) {
                        return;
                    }
                    aVar3.bx(aVar2.visibility);
                }
            }));
            g.this.aeE = new av(new av.b() { // from class: com.kwad.components.core.page.d.a.g.5.2
                @Override // com.kwad.components.core.webview.jshandler.av.b
                public final void uA() {
                    g gVar = g.this;
                    gVar.adZ.a(gVar.aee);
                }
            });
            g.this.aeF = new bi(new bi.a() { // from class: com.kwad.components.core.page.d.a.g.5.3
                @Override // com.kwad.components.core.webview.jshandler.bi.a
                public final void uB() {
                    g.this.adZ.ul();
                }
            });
            aVar.a(g.this.aeE);
            aVar.a(g.this.aeF);
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.b(bVar, g.this.adZ.mAdTemplate));
            l lVar = new l();
            lVar.aur = g.this.adZ.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.g(lVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.adK = true;
            if (!g.this.aeC) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.f.a.n(gVar.mAdTemplate, gVar.adC.tU(), g.this.adC.tT());
            }
            if (g.this.adZ.um()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onReceivedHttpError(int i, String str, String str2) {
            String string;
            g.this.adK = false;
            try {
                URI uri = new URI(g.this.adC.tT());
                if (TextUtils.isEmpty(uri.getPath())) {
                    string = new URI(g.this.adC.tT() + WVNativeCallbackUtil.SEPERATER).normalize().toString();
                } else {
                    string = uri.normalize().toString();
                }
                if (!TextUtils.equals(str2, g.this.adC.tT()) && !TextUtils.equals(str2, string)) {
                    g gVar = g.this;
                    com.kwad.sdk.commercial.f.a.b(gVar.mAdTemplate, gVar.adC.tU(), g.this.adC.tT(), i, str);
                    return;
                }
                g gVar2 = g.this;
                com.kwad.sdk.commercial.f.a.a(gVar2.mAdTemplate, gVar2.adC.tU(), g.this.adC.tT(), i, str);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean uy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean uz() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            g.this.aeD = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            g.this.adZ.aeh = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.adZ.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    };

    private void fA() {
        com.kwad.components.core.webview.b bVar = new com.kwad.components.core.webview.b();
        this.jp = bVar;
        bVar.bi(true);
        this.jp.a(new com.kwad.components.core.webview.b.a().bi(this.adZ.mAdTemplate).bu(this.adZ.mPageUrl).f(this.mAdWebView).m(this.adZ.mRootContainer).a(this.jq).b(this.adZ.aec).a(this));
        uv();
        com.kwad.sdk.commercial.f.a.m(this.mAdTemplate, this.adC.tU(), this.adC.tT());
        if (this.mAdWebView.getClientConfig() != null) {
            this.mAdWebView.getClientConfig().a(new KsAdWebView.d() { // from class: com.kwad.components.core.page.d.a.g.1
                @Override // com.kwad.sdk.core.webview.KsAdWebView.d
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    com.kwad.sdk.core.d.c.w("LandPageWebViewLoadPresenter", "shouldOverrideUrlLoading url=" + str);
                    com.kwad.sdk.core.webview.b.c.b.ah(g.this.mAdWebView.getUniqueId(), "shouldOverrideUrlLoading");
                    AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(g.this.mAdTemplate);
                    g.this.aeG = str;
                    if (!com.kwad.sdk.core.response.helper.a.bq(adInfoEO) || !ao.dy(g.this.adZ.mContext) || !ao.hP(str)) {
                        return false;
                    }
                    final com.kwad.sdk.core.webview.a.c.a clientConfig = g.this.mAdWebView.getClientConfig();
                    final com.kwad.components.core.urlReplace.c cVar = new com.kwad.components.core.urlReplace.c();
                    final Object obj = new Object();
                    g.this.aeH = new Runnable() { // from class: com.kwad.components.core.page.d.a.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (obj) {
                                com.kwad.components.core.urlReplace.c cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.wB();
                                }
                                com.kwad.sdk.core.webview.a.c.a aVar = clientConfig;
                                if (aVar != null && aVar.PE() && clientConfig.Py()) {
                                    g gVar = g.this;
                                    if (gVar.a(clientConfig, gVar.aeG) == 1) {
                                        com.kwad.sdk.core.adlog.c.i(g.this.mAdTemplate, false);
                                    } else {
                                        com.kwad.sdk.core.adlog.c.j(g.this.mAdTemplate, false);
                                    }
                                } else {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                }
                            }
                        }
                    };
                    g.jk.postDelayed(g.this.aeH, com.kwad.sdk.core.response.helper.a.br(adInfoEO));
                    cVar.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.d.a.g.1.2
                        @Override // com.kwad.components.core.urlReplace.a
                        public final void onSuccess(String str2) {
                            synchronized (obj) {
                                g.this.aeG = str2;
                                if (g.this.aeH != null) {
                                    g.jk.removeCallbacks(g.this.aeH);
                                }
                                com.kwad.sdk.core.webview.a.c.a aVar = clientConfig;
                                if (aVar != null && aVar.PE() && clientConfig.Py()) {
                                    g gVar = g.this;
                                    if (gVar.a(clientConfig, gVar.aeG) == 1) {
                                        com.kwad.sdk.core.adlog.c.i(g.this.mAdTemplate, true);
                                    } else {
                                        com.kwad.sdk.core.adlog.c.j(g.this.mAdTemplate, true);
                                    }
                                } else {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                }
                            }
                        }
                    });
                    return true;
                }
            });
        }
        this.mAdWebView.loadUrl(this.adZ.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void uv() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bV(true).fo(this.adZ.mAdTemplate).bR(false));
        if (com.kwad.sdk.core.response.helper.a.bR(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate)) > 0) {
            by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.d.a.g.6
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bR(true);
                        g.this.mAdWebView.getClientConfig().bT(true);
                    }
                }
            }, com.kwad.sdk.core.response.helper.a.bR(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.helper.a.bR(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bR(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.d.a.g.7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().bR(true);
                g.this.mAdWebView.getClientConfig().bS(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        b bVar = this.adZ;
        this.adC = bVar.adC;
        this.mAdTemplate = bVar.mAdTemplate;
        fA();
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(this.Bq);
    }

    public final void hide() {
        az azVar = this.aeD;
        if (azVar != null) {
            azVar.yz();
        }
        KsAdWebView ksAdWebView = this.adZ.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        az azVar2 = this.aeD;
        if (azVar2 != null) {
            azVar2.yA();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jp.kV();
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.b(this.Bq);
    }

    public final void show() {
        if (this.adK) {
            az azVar = this.aeD;
            if (azVar != null) {
                azVar.yx();
            }
            try {
                KsAdWebView ksAdWebView = this.adZ.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(0);
                }
            } catch (Exception e) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
            }
            az azVar2 = this.aeD;
            if (azVar2 != null) {
                azVar2.yy();
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void ug() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ boolean b(g gVar, boolean z) {
        gVar.aeC = true;
        return true;
    }

    public static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    public final int a(@NonNull com.kwad.sdk.core.webview.a.c.a aVar, String str) {
        boolean zCr;
        int I;
        try {
            zCr = com.kwad.sdk.core.response.helper.a.cr(com.kwad.sdk.core.response.helper.e.eO(aVar.getAdTemplate()));
        } catch (Throwable unused) {
            zCr = false;
        }
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        if (zCr) {
            if (aVar2.QZ == null) {
                aVar2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
            }
            aVar2.QZ.aLr = true;
            I = com.kwad.sdk.core.download.a.b.a(aVar.getContext(), str, new com.kwad.sdk.core.download.a.b.a() { // from class: com.kwad.components.core.page.d.a.g.2
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
}
