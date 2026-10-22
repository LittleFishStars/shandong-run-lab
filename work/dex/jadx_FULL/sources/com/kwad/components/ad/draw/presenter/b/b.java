package com.kwad.components.ad.draw.presenter.b;

import android.view.ViewGroup;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private a.InterfaceC1135a eY = new a.InterfaceC1135a() { // from class: com.kwad.components.ad.draw.presenter.b.b.1
        @Override // com.kwad.components.ad.draw.presenter.b.a.InterfaceC1135a
        public final void bb() {
            b.this.bb();
        }
    };
    private ViewGroup ee;
    private DrawCardApp fb;
    private DrawCardH5 fc;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            bd();
        } else {
            be();
        }
    }

    private void bd() {
        this.ee.setVisibility(8);
        this.fb.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.presenter.b.b.2
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void bg() {
                b.this.ee.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void bh() {
                b.this.bf();
            }
        });
        this.fb.setVisibility(0);
        this.fb.bZ();
    }

    private void be() {
        this.ee.setVisibility(8);
        this.fc.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.presenter.b.b.3
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void bg() {
                b.this.ee.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void bh() {
                b.this.bf();
            }
        });
        this.fc.setVisibility(0);
        this.fc.bZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 29, this.dQ.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.dQ.dB;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.dQ.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.dQ.dV.a(this.eY);
        this.fb.setVisibility(8);
        this.fc.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ee = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.fb = (DrawCardApp) findViewById(R.id.ksad_card_app_container);
        this.fc = (DrawCardH5) findViewById(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fb.release();
        this.fc.release();
        this.dQ.dV.a((a.InterfaceC1135a) null);
    }
}
