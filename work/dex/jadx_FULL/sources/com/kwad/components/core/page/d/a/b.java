package com.kwad.components.core.page.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @NonNull
    public AdWebViewActivityProxy.a adC;
    public WebView aea;

    @Nullable
    public com.kwad.components.core.page.a.b aeb;

    @Nullable
    public KsAdWebView.c aec;

    @Nullable
    public f.a aed;

    @Nullable
    @Deprecated
    public com.kwad.components.core.webview.jshandler.b aee;

    @Nullable
    public com.kwad.components.core.page.a.a aef;
    public com.kwad.components.core.b.a aeg;
    public boolean aeh = false;
    public boolean aei = false;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;
    public String mH5AuthUrl;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;

    @NonNull
    public ViewGroup mRootContainer;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aU(boolean z) {
        this.aei = z;
    }

    public final void a(KsAdWebView.c cVar) {
        this.aec = cVar;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.aec = null;
        this.aed = null;
        this.mWebCardCloseListener = null;
        this.aee = null;
    }

    public final void setH5AuthListener(@Nullable com.kwad.components.core.page.a.a aVar) {
        this.aef = aVar;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final boolean tV() {
        return this.mShowPermission;
    }

    public final void uc() {
        com.kwad.components.core.webview.jshandler.b bVar = this.aee;
        if (bVar != null) {
            bVar.ux();
        }
    }

    public final boolean uk() {
        return this.aei;
    }

    public final void ul() {
        this.aee = null;
        aU(false);
    }

    public final boolean um() {
        return !tV();
    }

    public final void a(f.a aVar) {
        this.aed = aVar;
    }

    public final void a(boolean z, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z) {
                com.kwad.sdk.core.adlog.c.cv(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.b bVar = this.aeb;
        if (bVar != null) {
            bVar.tQ();
        }
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.aee = bVar;
        aU(true);
    }
}
