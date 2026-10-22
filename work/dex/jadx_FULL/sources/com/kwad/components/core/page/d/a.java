package com.kwad.components.core.page.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.kwad.components.core.innerEc.InnerEcUserLoginBindInfo;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.core.page.d.a.a implements com.kwad.components.core.innerEc.c, com.kwad.components.core.webview.jshandler.a.c {
    public AdWebViewActivityProxy.a adC;
    private boolean adK = false;
    private volatile boolean adL = false;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.b.a mTitleBarHelper;

    private void fA() {
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.components.core.page.d.a.4
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
                if (TextUtils.isEmpty(com.kwad.sdk.core.config.e.KU()) || !str.contains(com.kwad.sdk.core.config.e.KU())) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                if (com.kwad.components.core.innerEc.f.a(str, a.this)) {
                    a.a(a.this, true);
                    by.postOnUiThread(new bi() { // from class: com.kwad.components.core.page.d.a.4.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (a.this.adZ.aef != null) {
                                a.this.adZ.aef.tN();
                            }
                        }
                    });
                } else {
                    com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, "fail", "h5", 0);
                    a.this.rc();
                    com.kwad.components.core.innerEc.local.a.f(a.this.mAdTemplate, "h5");
                }
                return true;
            }
        };
        cVar.setClientConfig(this.mAdWebView.getClientConfig());
        this.mAdWebView.setWebViewClient(cVar);
        this.mAdWebView.setVisibility(0);
        com.kwad.sdk.core.d.c.d("H5AuthLoadPresenter", "loadUrl url: " + this.adZ.mH5AuthUrl);
        this.mAdWebView.loadUrl(this.adZ.mH5AuthUrl);
        this.mAdWebView.onActivityCreate();
    }

    private void uf() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.adZ.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b("授权登录"));
        this.mTitleBarHelper.ak(true);
        this.mTitleBarHelper.al(false);
        this.mTitleBarHelper.a(new com.kwad.components.core.b.a.InterfaceC1190a() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void w(View view) {
                com.kwad.sdk.core.d.c.d("H5AuthLoadPresenter", "onBackClicked");
                a.this.getActivity().onBackPressed();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void x(View view) {
                com.kwad.sdk.core.d.c.d("H5AuthLoadPresenter", "onCloseClicked");
                a.this.getActivity().finish();
            }
        });
        this.mTitleBarHelper.ib().setVisibility(0);
        this.adZ.a(new com.kwad.components.core.page.d.a.f.a() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.components.core.page.d.a.f.a
            public final void bx(int i) {
                a.this.mTitleBarHelper.ib().setVisibility(0);
            }
        });
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.page.d.a.b bVar = this.adZ;
        this.adC = bVar.adC;
        this.mAdTemplate = bVar.mAdTemplate;
        uf();
        fA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview_h5auth);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("H5AuthLoadPresenter", "onUnbind hasGetCode: " + this.adL);
        if (this.adL) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, SubscribeResouceItemModel.REJECT, "h5", 0);
        com.kwad.components.core.innerEc.local.a.g(this.mAdTemplate, "h5");
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.page.d.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.adZ.aef != null) {
                    a.this.adZ.aef.tP();
                }
            }
        });
    }

    @Override // com.kwad.components.core.innerEc.c
    public final void rc() {
        ug();
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, "fail", "h5", 0);
        com.kwad.components.core.innerEc.local.a.f(this.mAdTemplate, "h5");
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.page.d.a.6
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.adZ.aef != null) {
                    a.this.adZ.aef.aP(a.this.adL);
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void ug() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.adL = true;
        return true;
    }

    @Override // com.kwad.components.core.innerEc.c
    public final void a(InnerEcUserLoginBindInfo innerEcUserLoginBindInfo) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, "success", "h5", 1);
        com.kwad.components.core.innerEc.local.a.aQ("h5");
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.page.d.a.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.adZ.aef != null) {
                    a.this.adZ.aef.tO();
                }
            }
        });
    }
}
