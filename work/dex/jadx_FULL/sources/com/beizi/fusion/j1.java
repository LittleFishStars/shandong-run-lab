package com.beizi.fusion;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.LandingPageWebView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class j1 extends ha {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27424a;
        final /* synthetic */ ViewGroup b;

        public a(View view, ViewGroup viewGroup) {
            this.f27424a = view;
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            LandingPageWebView landingPageWebView = new LandingPageWebView(this.f27424a.getContext());
            LinkModel link = j1.this.b != null ? j1.this.b.getLink() : null;
            if (link == null || TextUtils.isEmpty(link.getLandingPageURL())) {
                return;
            }
            this.b.addView(landingPageWebView, new ViewGroup.LayoutParams(-1, -1));
            landingPageWebView.setAllowDeeplinkDirect(!link.shouldWebIntercept());
            landingPageWebView.loadUrl(link.getLandingPageURL());
        }
    }

    private boolean b(LinkModel linkModel) {
        if (linkModel == null) {
            return false;
        }
        gq gqVarA = gq.a(this.c);
        if (gqVarA.a(linkModel.getWxOriginalId(), linkModel.getWxProgramPath(), linkModel.getWxExtraData())) {
            return true;
        }
        return gqVarA.b(linkModel.getWxNativeCanvas());
    }

    @Override // com.beizi.fusion.ha
    public void a(LinkModel linkModel, View view, int i) {
        if (linkModel == null || view == null || view.getContext() == null || b(linkModel) || i == dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER.getEventCode()) {
            return;
        }
        a(view.getContext(), linkModel);
    }

    public Bundle a(LinkModel linkModel) {
        return new Bundle();
    }

    public void a(Context context, LinkModel linkModel) {
        a(context, linkModel.getLandingPageURL(), a(linkModel));
    }

    private void a(Context context, String str, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        wf.a(context, str, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        ScopeExpressContainer expressRoot;
        ViewGroup viewGroupG;
        if (view instanceof ScopeExpressContainer) {
            expressRoot = (ScopeExpressContainer) view;
        } else {
            expressRoot = view instanceof he ? ((he) view).getExpressRoot() : null;
        }
        if (expressRoot == null || (viewGroupG = ScopeExpressContainer.d.g(expressRoot)) == null) {
            return;
        }
        viewGroupG.post(new a(view, viewGroupG));
    }
}
