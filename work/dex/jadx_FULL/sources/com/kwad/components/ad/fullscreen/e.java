package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private long jP;
    private KsLoadManager.FullScreenVideoAdListener jQ;

    public e(long j, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.jP = j;
        this.jQ = fullScreenVideoAdListener;
    }

    public final void a(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list) {
        com.kwad.components.ad.reward.monitor.d.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = com.kwad.components.core.t.f.a(stackTrace[2]);
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.jQ;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.d.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void onError(int i, String str) {
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.jQ;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onError(i, str);
        }
        com.kwad.components.ad.reward.monitor.d.a(false, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void a(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list, long j) {
        com.kwad.components.ad.reward.monitor.d.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = com.kwad.components.core.t.f.a(stackTrace[2]);
        }
        if (adTemplate != null) {
            try {
                com.kwad.sdk.commercial.convert.d.a(com.kwad.sdk.core.response.helper.e.eI(adTemplate), SystemClock.elapsedRealtime() - j, 2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.jQ;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.d.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.jP, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }
}
