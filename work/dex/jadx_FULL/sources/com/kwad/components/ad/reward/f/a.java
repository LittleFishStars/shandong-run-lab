package com.kwad.components.ad.reward.f;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.monitor.LivePlayMonitorType;
import com.kwad.components.ad.reward.monitor.b;
import com.kwad.components.core.video.h;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.k.a<h> {
    private IAdLivePlayModule ir;
    private AdInfo mAdInfo;
    private AdLivePlayStateListener vA;
    private List<h> vy;
    private long vz;

    public a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule, AdInfo adInfo) {
        super(adTemplate);
        this.vy = new CopyOnWriteArrayList();
        this.vz = 30000L;
        this.vA = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(h hVar) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    private static void c(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    private static void c(h hVar) {
                        hVar.onLivePlayEnd();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    private static void c(h hVar) {
                        hVar.onMediaPlayPaused();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(a.this.vz, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    private static void c(h hVar) {
                        hVar.onLivePlayResume();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    private static void c(h hVar) {
                        hVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    private static void c(h hVar) {
                        hVar.onMediaPrepared();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }
                });
            }
        };
        this.ir = iAdLivePlayModule;
        this.mAdInfo = adInfo;
        if (e.eI(adTemplate) == 2) {
            this.vz = com.kwad.sdk.core.response.helper.a.ak(e.eO(adTemplate));
        }
        this.ir.registerAdLivePlayStateListener(this.vA);
    }

    private void iq() {
        try {
            this.vy.clear();
            this.ir.unRegisterAdLivePlayStateListener(this.vA);
            this.ir.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            b.a(2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), Long.valueOf(com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo)), LivePlayMonitorType.LIVE_PLAY_MODULE_RELEASE_INNER_EXCEPTION.getValue(), "LivePlayModule releaseInner error: " + th.getMessage());
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.ir.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.ir.getPlayDuration();
    }

    public final void onPause() {
        this.ir.onPause();
    }

    public final void onResume() {
        this.ir.onResume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.ir.pause();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.ir.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        iq();
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.ir.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.ir.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.ir.setAudioEnabled(z, z2);
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.ir.skipToEnd();
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.ir.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.kwad.sdk.g.a<h> aVar) {
        if (aVar != null) {
            Iterator<h> it = this.vy.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(h hVar) {
        if (hVar != null) {
            this.vy.add(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h hVar) {
        if (hVar != null) {
            this.vy.remove(hVar);
        }
    }
}
