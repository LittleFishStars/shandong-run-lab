package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends KSFrameLayout {

    @Nullable
    private KsDrawAd.AdInteractionListener dB;
    private com.kwad.sdk.core.j.b dH;
    private com.kwad.components.ad.draw.b.b dQ;
    private boolean dR;
    private com.kwad.components.ad.draw.c.a dS;
    private boolean eU;
    private boolean fY;
    private boolean fZ;
    private com.kwad.components.core.widget.a.c fx;
    private boolean ga;
    private ImageView gf;
    private long gg;
    private View.OnClickListener gh;
    private l gi;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;

    public b(@NonNull Context context) {
        super(context);
        this.dR = false;
        this.fY = false;
        this.fZ = false;
        this.ga = false;
        this.gh = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.b.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(b.this.dQ.mRootContainer.getContext()).aJ(b.this.dQ.mAdTemplate).b(b.this.dQ.mApkDownloadHelper).as(false).aN(3).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.draw.view.b.2.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        b.this.notifyAdClick();
                    }
                }));
                b.this.bM();
            }
        };
        this.gi = new m() { // from class: com.kwad.components.ad.draw.view.b.3
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                super.onMediaPlayCompleted();
                if (b.this.ga) {
                    return;
                }
                b.b(b.this, true);
                com.kwad.components.ad.draw.a.c.k(b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.ad.draw.a.c.b(b.this.mAdTemplate, SystemClock.elapsedRealtime() - b.this.gg, "what : " + i + " extra : " + i2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                b.this.gf.setVisibility(0);
                if (b.this.fY) {
                    return;
                }
                b.a(b.this, true);
                com.kwad.components.ad.draw.a.c.i(b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                b.this.gf.setVisibility(8);
                com.kwad.components.ad.draw.a.c.a(b.this.mAdTemplate, SystemClock.elapsedRealtime() - b.this.gg);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                b.this.gf.setVisibility(8);
                if (b.this.fZ) {
                    return;
                }
                b.c(b.this, true);
                com.kwad.components.ad.draw.a.c.j(b.this.mAdTemplate);
            }
        };
        this.mContext = context;
        initView();
    }

    private com.kwad.components.ad.draw.b.b bI() {
        com.kwad.components.ad.draw.b.b bVar = new com.kwad.components.ad.draw.b.b();
        bVar.dB = this.dB;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new d(this.mAdTemplate);
        }
        bVar.dS = this.dS;
        bVar.dV = new com.kwad.components.ad.draw.presenter.b.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.helper.b.dk(this.mAdTemplate)) {
            bVar.dW = new com.kwad.components.ad.l.b();
        }
        return bVar;
    }

    private Presenter bJ() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.presenter.a.a());
        presenter.a(new com.kwad.components.ad.draw.presenter.b());
        presenter.a(new com.kwad.components.ad.draw.presenter.d());
        presenter.a(new com.kwad.components.ad.draw.presenter.c());
        presenter.a(new com.kwad.components.ad.draw.presenter.b.b());
        if (com.kwad.sdk.core.response.helper.b.cX(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.presenter.b.c());
        }
        presenter.a(new com.kwad.components.ad.draw.presenter.c.a());
        if (com.kwad.sdk.core.response.helper.b.dk(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.presenter.c.b());
        }
        if (com.kwad.sdk.core.response.helper.a.aV(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.presenter.a());
        }
        return presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM() {
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            if (3 == com.kwad.sdk.core.response.helper.a.bE(e.eO(this.dQ.mAdTemplate))) {
                bN();
            }
        } else if (1 == com.kwad.sdk.core.response.helper.a.bE(e.eO(this.dQ.mAdTemplate))) {
            bN();
        }
    }

    private void bN() {
        this.dS.g(!this.eU);
        if (this.eU) {
            this.dS.resume();
        } else {
            this.dS.pause();
        }
        this.eU = !this.eU;
    }

    private void bO() {
        this.dQ = bI();
        Presenter presenterBJ = bJ();
        this.mPresenter = presenterBJ;
        presenterBJ.N(this.mRootContainer);
        this.mPresenter.q(this.dQ);
        this.fx.a(this.dH);
        this.fx.Aa();
        this.dS.bu();
        this.dS.b(this.gi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP() {
        com.kwad.components.core.widget.a.c cVar = this.fx;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar != null) {
            aVar.bw();
            this.dS.a(this.gi);
        }
        com.kwad.components.ad.draw.b.b bVar = this.dQ;
        if (bVar != null) {
            bVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    private void initView() {
        com.kwad.sdk.wrapper.m.inflate(this.mContext, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.gf = (ImageView) adBaseFrameLayout.findViewById(R.id.ksad_video_control_button);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.e.Ky());
        this.mDetailVideoView.setOnClickListener(this.gh);
        this.gf.setOnClickListener(this.gh);
        final WeakReference weakReference = new WeakReference(com.kwad.sdk.wrapper.m.getActivityFromContext(this.mContext));
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.draw.view.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                b.this.bP();
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.dQ.mRootContainer.getTouchCoords()).ec(85), (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.dQ.dB;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.dR) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.draw.a.d.h(adTemplate, 1, com.kwad.sdk.core.response.helper.b.dF(adTemplate) ? 2 : 1);
        com.kwad.components.ad.draw.a.d.b(this.mAdTemplate, 1);
        this.dR = true;
    }

    public final void bQ() {
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar != null) {
            aVar.fC = false;
        }
    }

    public final void o(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.fx = new com.kwad.components.ad.draw.b(this);
        com.kwad.components.ad.draw.a.c.h(this.mAdTemplate);
        this.gg = SystemClock.elapsedRealtime();
        this.dS = new com.kwad.components.ad.draw.c.a(this.mAdTemplate, this.fx, this.mDetailVideoView);
        bO();
    }

    public final void pause() {
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar == null || aVar.bx()) {
            return;
        }
        com.kwad.components.ad.draw.c.a aVar2 = this.dS;
        aVar2.fD = 2;
        aVar2.g(true);
        this.dS.pause();
    }

    public final void play() {
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar == null || aVar.bx()) {
            return;
        }
        com.kwad.components.ad.draw.c.a aVar2 = this.dS;
        aVar2.fD = 1;
        aVar2.g(false);
        this.dS.resume();
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dB = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    public final void setVideoSound(boolean z) {
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar != null) {
            aVar.setVideoSound(z);
        }
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.fY = true;
        return true;
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.ga = true;
        return true;
    }

    public static /* synthetic */ boolean c(b bVar, boolean z) {
        bVar.fZ = true;
        return true;
    }
}
