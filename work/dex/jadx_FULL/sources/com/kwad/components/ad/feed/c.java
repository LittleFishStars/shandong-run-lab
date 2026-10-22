package com.kwad.components.ad.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.widget.q;
import com.kwad.components.ad.feed.widget.r;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.wrapper.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    private final KsAdVideoPlayConfig ce;
    private KsFeedAd.AdInteractionListener he;
    private com.kwad.components.core.widget.b hf;
    private r hg;
    private boolean hh;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;
    private AtomicBoolean hi = new AtomicBoolean(false);
    private AtomicBoolean hj = new AtomicBoolean(false);
    private AtomicInteger hk = new AtomicInteger(2);
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.j.b dH = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.j.b
        public final void aP() {
            c.this.bz.h(c.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aQ() {
            c.this.bz.i(c.this);
        }
    };

    public interface a {
        void e(int i, String str);
    }

    public c(@NonNull AdResultData adResultData, boolean z) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        adTemplateR.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        this.hh = z;
        this.ce = new KSAdVideoPlayConfigImpl();
        com.kwad.components.ad.i.b.gd().a(this);
    }

    @Nullable
    private com.kwad.components.core.widget.b<?, ?> C(Context context) {
        com.kwad.components.core.widget.b<?, ?> bVarA;
        int width = this.mAdTemplate.mAdScene.getWidth();
        if (width < com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPK) * ((double) n.getScreenWidth(context))) {
            int iBk = com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
            AdTemplate adTemplate = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(width, iBk, adTemplate.type, adTemplate);
        }
        if (com.kwad.sdk.core.response.helper.b.dD(this.mAdTemplate)) {
            r rVar = new r(m.wrapContextIfNeed(context));
            this.hg = rVar;
            rVar.setWidth(width);
            this.hg.setVideoPlayConfig(this.ce);
            bVarA = this.hg;
        } else if (this.hh && com.kwad.sdk.core.response.helper.b.dC(this.mAdTemplate)) {
            try {
                context = m.wrapContextIfNeed(context);
                q qVar = new q(context);
                qVar.setWidth(width);
                qVar.setVideoPlayConfig(this.ce);
                bVarA = qVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                bVarA = null;
            }
        } else {
            int iBk2 = com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
            AdTemplate adTemplate2 = this.mAdTemplate;
            bVarA = b.a(context, FeedType.fromInt(adTemplate2.type, adTemplate2.defaultType), iBk2);
        }
        if (bVarA != null) {
            if (!(bVarA instanceof r)) {
                bVarA.setMargin(com.kwad.sdk.c.a.a.a(context, 16.0f));
            }
            bVarA.setPageExitListener(this.dH);
        }
        return bVarA;
    }

    private void cd() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.b.a.Lx().remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.helper.a.ch(this.mAdInfo);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(this.mAdInfo);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
            com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
            com.kwad.components.core.widget.b bVar = this.hf;
            if (bVar != null) {
                try {
                    if (bVar.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.hf.getParent()).removeView(this.hf);
                    }
                } catch (NullPointerException unused) {
                }
                try {
                    com.kwad.sdk.commercial.convert.d.f(com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return this.hf;
            }
            cd();
            this.mAdTemplate.loadType = 1;
            com.kwad.components.core.widget.b<?, ?> bVarC = C(contextWrapContextIfNeed);
            this.hf = bVarC;
            if (bVarC == null) {
                return null;
            }
            bVarC.d(this.mAdResultData);
            com.kwad.components.core.widget.b bVar2 = this.hf;
            if (bVar2 instanceof com.kwad.components.ad.feed.widget.c) {
                ((com.kwad.components.ad.feed.widget.c) bVar2).b(this.ce);
            }
            com.kwad.components.core.widget.b bVar3 = this.hf;
            if (bVar3 instanceof q) {
                a(bVar3, false);
            } else {
                a(bVar3, true);
            }
            try {
                com.kwad.sdk.commercial.convert.d.f(com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
            return this.hf;
        } catch (Throwable th3) {
            if (o.Gs().Fu()) {
                throw th3;
            }
            ServiceProvider.reportSdkCaughtException(th3);
            return null;
        }
        if (o.Gs().Fu()) {
            throw th3;
        }
        ServiceProvider.reportSdkCaughtException(th3);
        return null;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void render(final KsFeedAd.AdRenderListener adRenderListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.r(this.mAdTemplate);
        if (!this.hj.get()) {
            if (this.hi.get()) {
                return;
            }
            final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            final int i = com.kwad.sdk.core.response.helper.b.dD(this.mAdTemplate) ? 3 : 2;
            this.hi.set(true);
            a(new a() { // from class: com.kwad.components.ad.feed.c.3
                @Override // com.kwad.components.ad.feed.c.a
                public final void e(int i2, String str) {
                    com.kwad.components.ad.feed.monitor.b.a(c.this.getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - jElapsedRealtime2, str);
                    c.this.hk.set(i2);
                    c.this.hj.set(true);
                    try {
                        if (adRenderListener != null) {
                            if (c.this.hf == null) {
                                KsFeedAd.AdRenderListener adRenderListener2 = adRenderListener;
                                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTj;
                                adRenderListener2.onAdRenderFailed(eVar.errorCode, eVar.msg);
                            } else {
                                by.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        try {
                                            com.kwad.sdk.commercial.convert.d.e(com.kwad.sdk.core.response.helper.e.eI(c.this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
                                        } catch (Throwable th) {
                                            ServiceProvider.reportSdkCaughtException(th);
                                        }
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        adRenderListener.onAdRenderSuccess(c.this.hf);
                                        com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.helper.a.bh(c.this.mAdInfo), c.this.hk.get());
                                    }
                                });
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        if (this.hf != null) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.c.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    try {
                        com.kwad.sdk.commercial.convert.d.e(com.kwad.sdk.core.response.helper.e.eI(c.this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                    adRenderListener.onAdRenderSuccess(c.this.hf);
                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.helper.a.bh(c.this.mAdInfo), c.this.hk.get());
                }
            });
            return;
        }
        com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTj;
        adRenderListener.onAdRenderFailed(eVar.errorCode, eVar.msg);
        this.hj.set(false);
        this.hi.set(false);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.he = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    @SuppressLint({"WrongConstant"})
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.ce.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.ce.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.ce.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.ce.setDataFlowAutoStart(com.kwad.sdk.core.config.e.JW());
                try {
                    this.ce.setVideoAutoPlayType(0);
                } catch (NoSuchMethodError unused) {
                } catch (Throwable th) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }
            com.kwad.components.core.widget.b bVar = this.hf;
            if (bVar instanceof q) {
                ((q) bVar).setVideoPlayConfig(this.ce);
            }
            com.kwad.components.core.widget.b bVar2 = this.hf;
            if (bVar2 instanceof r) {
                ((r) bVar2).setVideoPlayConfig(this.ce);
            }
            com.kwad.components.core.widget.b bVar3 = this.hf;
            if (bVar3 instanceof com.kwad.components.ad.feed.widget.c) {
                ((com.kwad.components.ad.feed.widget.c) bVar3).setVideoPlayConfig(this.ce);
            }
        }
        if (isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        this.ce.setVideoSoundEnable(z);
        if (this.ce.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    public final void a(@NonNull final a aVar) {
        Context context = ServiceProvider.getContext();
        this.mAdTemplate.loadType = 2;
        this.hi.set(true);
        com.kwad.components.core.widget.b<?, ?> bVarC = C(context);
        this.hf = bVarC;
        if (bVarC != null) {
            if (bVarC instanceof q) {
                q qVar = (q) bVarC;
                qVar.setPreloadListener(new q.a() { // from class: com.kwad.components.ad.feed.c.4
                    @Override // com.kwad.components.ad.feed.widget.q.a
                    public final void e(int i, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.hf, false);
                        c.this.hj.set(true);
                        aVar.e(i, str);
                    }
                });
                qVar.d(this.mAdResultData);
                return;
            } else {
                if (bVarC instanceof r) {
                    r rVar = (r) bVarC;
                    rVar.setTKLoadListener(new r.a() { // from class: com.kwad.components.ad.feed.c.5
                        @Override // com.kwad.components.ad.feed.widget.r.a
                        public final void e(int i, String str) {
                            c cVar = c.this;
                            cVar.a(cVar.hf, false);
                            c.this.hj.set(true);
                            aVar.e(i, str);
                        }
                    });
                    rVar.d(this.mAdResultData);
                    return;
                }
                bVarC.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.hf;
                if (bVar instanceof com.kwad.components.ad.feed.widget.c) {
                    ((com.kwad.components.ad.feed.widget.c) bVar).b(this.ce);
                }
                a(this.hf, true);
                this.hj.set(true);
                aVar.e(1, "");
                return;
            }
        }
        this.hj.set(false);
        this.hi.set(false);
        aVar.e(1, "render Failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new com.kwad.components.core.widget.b.a() { // from class: com.kwad.components.ad.feed.c.6
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (c.this.he != null) {
                    c.this.he.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(4, c.this.mAdTemplate, com.kwad.sdk.core.response.helper.a.bh(c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                com.kwad.components.ad.feed.monitor.b.s(c.this.mAdTemplate);
                com.kwad.sdk.commercial.convert.c.ch(c.this.mAdTemplate);
                if (c.this.he != null) {
                    c.this.he.onAdShow();
                }
                com.kwad.components.ad.feed.monitor.b.a(3, c.this.mAdTemplate, com.kwad.sdk.core.response.helper.a.bh(c.this.mAdInfo), z ? 1 : 2);
                if (z) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                    FeedType feedTypeFromInt = FeedType.fromInt(c.this.mAdTemplate.type, c.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c1273a.templateId = String.valueOf(feedTypeFromInt.getType());
                    c1273a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
                    bVar2.b(c1273a);
                    bVar2.z(c.this.hf.getHeight(), c.this.hf.getWidth());
                    com.kwad.components.core.t.b.wF().a(c.this.mAdTemplate, null, bVar2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (c.this.he != null) {
                    c.this.he.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
                com.kwad.components.ad.feed.monitor.b.a(5, c.this.mAdTemplate, com.kwad.sdk.core.response.helper.a.bh(c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.he != null) {
                    try {
                        c.this.he.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (c.this.he != null) {
                    try {
                        c.this.he.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
