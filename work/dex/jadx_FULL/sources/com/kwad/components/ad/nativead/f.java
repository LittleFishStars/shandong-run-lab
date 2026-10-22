package com.kwad.components.ad.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.nativead.b.h;
import com.kwad.components.ad.nativead.b.i;
import com.kwad.components.ad.nativead.b.j;
import com.kwad.components.ad.nativead.b.k;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.l;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends KSFrameLayout {
    private l eW;
    private com.kwad.components.core.widget.a.c fx;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private d.a pD;
    private AdBasePvFrameLayout pR;
    private com.kwad.components.ad.nativead.a.b pW;
    public com.kwad.components.ad.nativead.d.a pX;
    private KsAdVideoPlayConfig pY;
    private boolean pZ;
    private KsNativeAd.VideoPlayListener pv;
    private boolean qa;

    public f(@NonNull Context context) {
        this(context, null);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.pR = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.fx = new g(getParent() == null ? this : (View) getParent());
    }

    private Presenter bJ() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.nativead.b.e());
        presenter.a(new com.kwad.components.ad.nativead.b.c());
        presenter.a(new i());
        presenter.a(new j());
        presenter.a(new com.kwad.components.ad.nativead.b.d());
        presenter.a(new com.kwad.components.ad.nativead.b.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.nativead.b.a(this.pY));
        presenter.a(new com.kwad.components.ad.nativead.b.g());
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.ad.nativead.b.f());
        } else {
            presenter.a(new h());
        }
        return presenter;
    }

    private com.kwad.components.ad.nativead.a.b fC() {
        com.kwad.components.ad.nativead.a.b bVar = new com.kwad.components.ad.nativead.a.b();
        bVar.pR = this.pR;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.pD = this.pD;
        bVar.pv = this.pv;
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
            if (dVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            } else {
                dVar.ql();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        bVar.qd = this.qa;
        bVar.qc = this.pZ;
        bVar.pX = this.pX;
        return bVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        if (this.pX == null) {
            if (this.fx == null) {
                this.fx = new g(getParent() == null ? this : (View) getParent());
            }
            this.pX = new com.kwad.components.ad.nativead.d.a(this.mAdTemplate, this.fx, this.mDetailVideoView, this.pY);
        }
        this.pW = fC();
        Presenter presenterBJ = bJ();
        this.mPresenter = presenterBJ;
        presenterBJ.N(this.pR);
        this.mPresenter.q(this.pW);
        com.kwad.components.core.widget.a.c cVar = this.fx;
        if (cVar != null) {
            cVar.Aa();
        }
        this.pX.bu();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.nativead.f.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (f.this.fx != null) {
                    f.this.fx.release();
                }
                com.kwad.components.ad.nativead.d.a aVar = f.this.pX;
                if (aVar != null) {
                    aVar.bw();
                }
                if (f.this.pW != null) {
                    f.this.pW.release();
                }
                if (f.this.mPresenter != null) {
                    f.this.mPresenter.destroy();
                }
            }
        });
    }

    public final void g(int i, int i2) {
        if (i == 0) {
            this.qa = true;
        }
        if (i2 == 0) {
            this.pZ = true;
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.pD = aVar;
    }

    public final void setPlayState(int i) {
        com.kwad.components.ad.nativead.d.a aVar = this.pX;
        if (aVar != null) {
            aVar.af(i);
        }
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.pv = videoPlayListener;
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = dVar;
        this.pY = ksAdVideoPlayConfig;
        this.pR.setVisibleListener(this.eW);
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.pZ = false;
        this.qa = false;
        this.eW = new l() { // from class: com.kwad.components.ad.nativead.f.1
            @Override // com.kwad.sdk.widget.l
            public final void aZ() {
                o.fr(f.this.mAdTemplate);
            }
        };
        B(context);
    }
}
