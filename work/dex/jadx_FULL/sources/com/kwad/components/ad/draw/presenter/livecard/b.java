package com.kwad.components.ad.draw.presenter.livecard;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.draw.b.a implements View.OnClickListener {
    private IAdLivePlayModule dT;
    private KSFrameLayout et;
    private KsLiveAuthorView eu;
    private TextView ev;
    private TextView ew;
    private TextView ex;
    private final AdLivePlayStateListener ey = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.b.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (b.this.et != null) {
                b.this.et.setVisibility(0);
            }
        }
    };
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    private void aY() {
        this.dT.registerAdLivePlayStateListener(this.ey);
        this.et.setOnClickListener(this);
        this.eu.setOnClickListener(this);
        this.ew.setOnClickListener(this);
        this.ex.setOnClickListener(this);
        this.ev.setOnClickListener(this);
    }

    private void initView() {
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_draw_live_end);
        this.et = kSFrameLayout;
        this.eu = (KsLiveAuthorView) kSFrameLayout.findViewById(R.id.ksad_draw_author_icon);
        this.ev = (TextView) this.et.findViewById(R.id.ksad_draw_live_end_app_name);
        this.ex = (TextView) this.et.findViewById(R.id.ksad_live_actionbar_btn);
        this.ew = (TextView) this.et.findViewById(R.id.ksad_draw_live_end_text);
        this.eu.n(this.dQ.mAdTemplate);
        this.ev.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
        this.ew.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.ex.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
        this.et.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.draw.b.b bVar = this.dQ;
        this.dT = bVar.dT;
        AdTemplate adTemplate = bVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        if (this.dT == null) {
            return;
        }
        initView();
        aY();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.et)) {
            this.dQ.a(2, view.getContext(), 53, 2);
            return;
        }
        if (view.equals(this.eu)) {
            this.dQ.a(2, view.getContext(), 15, 2);
            return;
        }
        if (view.equals(this.ew)) {
            this.dQ.a(2, view.getContext(), 17, 2);
        } else if (view.equals(this.ev)) {
            this.dQ.a(2, view.getContext(), 16, 2);
        } else if (view.equals(this.ex)) {
            this.dQ.a(2, view.getContext(), 26, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLivePlayModule iAdLivePlayModule = this.dT;
        if (iAdLivePlayModule == null) {
            return;
        }
        iAdLivePlayModule.unRegisterAdLivePlayStateListener(this.ey);
    }
}
