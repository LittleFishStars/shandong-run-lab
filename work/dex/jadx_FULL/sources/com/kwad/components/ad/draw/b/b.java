package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.d;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public KsDrawAd.AdInteractionListener dB;
    private boolean dR;

    @Nullable
    public com.kwad.components.ad.draw.c.a dS;

    @Nullable
    public IAdLivePlayModule dT;

    @Nullable
    public IAdLiveOfflineView dU;

    @NonNull
    public com.kwad.components.ad.draw.presenter.b.a dV;

    @Nullable
    public com.kwad.components.ad.l.b dW;

    @Nullable
    public d mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        IAdLivePlayModule iAdLivePlayModule = this.dT;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
            this.dT = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.dU;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.dU = null;
        }
        com.kwad.components.ad.draw.c.a aVar = this.dS;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void a(int i, Context context, final int i2, int i3) {
        com.kwad.components.core.e.d.a.C1201a c1201aAN = new com.kwad.components.core.e.d.a.C1201a(context).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aN(i3);
        IAdLivePlayModule iAdLivePlayModule = this.dT;
        com.kwad.components.core.e.d.a.a(c1201aAN.D(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).aA(true).aM(i2).aL(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.draw.b.b.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    b.this.a(i2, null);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.ec(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        c.a(this.mAdTemplate, bVar, (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.dB;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.dR) {
            return;
        }
        com.kwad.components.ad.draw.a.d.b(this.mAdTemplate, 1);
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.draw.a.d.h(adTemplate, 1, com.kwad.sdk.core.response.helper.b.dF(adTemplate) ? 2 : 1);
        this.dR = true;
    }
}
