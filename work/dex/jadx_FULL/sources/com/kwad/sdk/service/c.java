package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.g;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class c {
    private static final Map<Class<?>, Class<?>> bnV = new HashMap(128);
    private static final Map<Class<?>, Class<?>> bnW = new HashMap();
    private static boolean bnX = false;
    private static boolean bnY = false;

    private static synchronized void TY() {
        if (bnX) {
            return;
        }
        TZ();
        bnX = true;
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void TZ() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        g.register();
        com.kwad.components.core.s.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    private static synchronized void Ua() {
        if (bnY) {
            return;
        }
        Ub();
        bnY = true;
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Ub() {
        com.kwad.components.ad.reward.retryReward.a.register();
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.q.b.register();
        SceneImpl.register();
    }

    public static void a(Class cls, Class cls2) {
        bnW.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        TY();
        return bnV.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Ua();
        return bnW.get(cls);
    }

    public static void init() {
        TY();
        Ua();
    }

    public static void putComponentProxy(Class<?> cls, Class<?> cls2) {
        bnV.put(cls, cls2);
    }
}
