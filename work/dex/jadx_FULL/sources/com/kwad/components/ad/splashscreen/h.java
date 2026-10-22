package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends com.kwad.sdk.mvp.a {
    private KsSplashScreenAd.SplashScreenAdInteractionListener GB;

    @Nullable
    public com.kwad.components.ad.splashscreen.d.a GN;
    public StyleTemplate GO;
    public com.kwad.sdk.core.j.a GP;
    public int GX;
    public int GY;
    public long GZ;
    public long Ha;
    public long Hb;
    public long Hc;
    public long Hd;
    public long He;
    public long Hf;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public long mStartRenderTime;
    public bx mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    private List<g> GQ = new CopyOnWriteArrayList();
    private List<f> GR = new CopyOnWriteArrayList();
    public boolean GS = false;
    private boolean GT = false;
    public boolean GU = false;
    public boolean GV = false;
    public boolean bY = false;
    public long GW = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    public interface a {
        void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar);
    }

    public static boolean aj(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfoDW;
        return com.kwad.sdk.core.config.e.JM() && (splashPlayCardTKInfoDW = com.kwad.sdk.core.response.helper.b.dW(adTemplate)) != null && !TextUtils.isEmpty(splashPlayCardTKInfoDW.templateId) && splashPlayCardTKInfoDW.renderType == 1;
    }

    private void mp() {
        mq();
        Iterator<g> it = this.GQ.iterator();
        while (it.hasNext()) {
            it.next().mc();
        }
    }

    private void mq() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setLoadType(this.mAdTemplate.splashAdLoadType).setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.e.a.zA().zB());
        bx bxVar = this.mTimerHelper;
        com.kwad.sdk.commercial.c.m(elementTypes.setShowEndTime(bxVar != null ? bxVar.getTime() : -1L).setRotateComposeTimeout(this.bY).setTkDefaultTimeout(aj(this.mAdTemplate) ? com.kwad.sdk.core.response.helper.b.dX(this.mAdTemplate) : com.kwad.sdk.core.response.helper.b.dT(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))).setSoSource(this.GX).setSoLoadTime(this.GZ).setOfflineSource(this.GY).setOfflineLoadTime(this.Ha).setTkFileLoadTime(this.Hb).setTkInitTime(this.Hc).setTkRenderTime(this.Hd).setNativeLoadTime(this.He).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.Hf).setInteractiveStyle(com.kwad.sdk.core.response.helper.b.ee(adInfoEO)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.helper.b.ef(adInfoEO)).setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.a.zA().zC();
    }

    private void mr() {
        Iterator<f> it = this.GR.iterator();
        while (it.hasNext()) {
            it.next().lY();
        }
    }

    public static boolean o(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    public static boolean s(AdInfo adInfo) {
        return com.kwad.sdk.core.response.helper.b.dL(adInfo) && com.kwad.sdk.core.response.helper.a.bj(adInfo);
    }

    public final void U(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        com.kwad.components.ad.splashscreen.local.a.V(context);
        if (!com.kwad.sdk.core.config.e.KK()) {
            com.kwad.components.core.t.b.wF().a(this.mAdTemplate, null, null);
        }
        com.kwad.sdk.commercial.convert.c.ch(this.mAdTemplate);
        ag(true);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    @MainThread
    public final void ab() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.mt().an(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mt().al(this.mAdTemplate);
    }

    @MainThread
    public final void ag(boolean z) {
        if (this.GT) {
            return;
        }
        this.GT = true;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (z && com.kwad.sdk.core.config.e.KK()) {
            com.kwad.components.core.t.b.wF().a(this.mAdTemplate, null, null);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mAdTemplate.showTime = jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, jElapsedRealtime - adTemplate.showStartTime, jElapsedRealtime - adTemplate.addStartTime, jElapsedRealtime - adTemplate.requestStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.ax(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.mt().z(this.mAdTemplate);
        com.kwad.sdk.a.a.c.Hl().bB(true);
        bx bxVar = this.mTimerHelper;
        if (bxVar != null) {
            bxVar.startTiming();
        }
    }

    public final void ax(int i) {
        Iterator<g> it = this.GQ.iterator();
        while (it.hasNext()) {
            it.next().aw(i);
        }
    }

    public final void c(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, null);
    }

    @MainThread
    public final void md() {
        com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mt().A(this.mAdTemplate);
    }

    public final void me() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    public final void mf() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void mg() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void mh() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    public final void mi() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void mj() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void mk() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void ml() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    @MainThread
    public final void mm() {
        if (this.GS) {
            return;
        }
        this.GS = true;
        if (!s(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)) || this.mAdTemplate.converted) {
            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
            bx bxVar = this.mTimerHelper;
            if (bxVar != null) {
                c1273a.duration = bxVar.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ed(14).el(22).b(c1273a), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.mt().A(this.mAdTemplate);
        } else {
            mr();
        }
        mp();
    }

    @MainThread
    public final void mn() {
        com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mt().A(this.mAdTemplate);
    }

    @MainThread
    public final void mo() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mt().A(this.mAdTemplate);
        mp();
    }

    public final void ms() {
        this.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.pG()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.mn();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.GN;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.j.a aVar2 = this.GP;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.GB = splashScreenAdInteractionListener;
    }

    public final void b(g gVar) {
        this.GQ.remove(gVar);
    }

    @MainThread
    public final void c(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i, String.valueOf(str));
        mp();
    }

    public final void a(final int i, Context context, final int i2, int i3, final a aVar) {
        com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(context).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(i3).as(i3 == 1).aM(i2).aL(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.components.ad.splashscreen.monitor.a.mt().an(h.this.mAdTemplate);
                if (h.this.GB != null) {
                    h.this.GB.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.mt().al(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    com.kwad.components.ad.splashscreen.d.a aVar2 = h.this.GN;
                    if (aVar2 != null) {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
                com.kwad.sdk.core.adlog.c.b bVarF = new com.kwad.sdk.core.adlog.c.b().ec(i2).f(h.this.mRootContainer.getTouchCoords());
                if (i == 2) {
                    bVarF.el(6);
                }
                com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, bVarF, jSONObject);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(bVarF);
                }
            }
        }));
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.GR.remove(fVar);
    }

    public final void a(g gVar) {
        this.GQ.add(gVar);
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.GR.add(fVar);
    }
}
