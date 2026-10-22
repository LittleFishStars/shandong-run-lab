package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";
    public static boolean hadCreateInstance = false;

    public d() {
        this(0, null);
    }

    private void appendKUAHeader() {
        com.kwad.sdk.service.a.f fVar;
        com.kwad.sdk.core.i.c cVarK = com.kwad.sdk.core.i.a.k(true, false);
        if (cVarK == null || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null) {
            return;
        }
        addHeader("KUA", cVarK.cd(fVar.getContext()));
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        try {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            int i = 1;
            putBody(UserTrackConstant.SDK_TYPE, 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.Np());
            putBody("tkVersion", "6.2.3");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.Nt());
            putBody("liveSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tu() ? 1 : 0);
            putBody("waynePlayerSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tt() ? 1 : 0);
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tr()) {
                i = 0;
            }
            putBody("closureSupportMode", i);
            putBody("userInfo", com.kwad.sdk.core.request.model.g.Nw());
            putBody("requestSessionData", q.Mj().eL(getUrl()));
            putBody("timestamp", System.currentTimeMillis());
            if (enablePrivateInfoObtain()) {
                buildBaseBodyWithPrivateInfo();
            }
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        putBody("mediumDisableSensor", be.useSensorManagerDisable());
        putBody("kwaiMerchantSdkVersion", "1.1.0");
    }

    public void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.Ns());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fz());
            putBody(LoginConstants.EXT, com.kwad.sdk.core.request.model.e.Nv());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        if (com.kwad.framework.b.a.pe.booleanValue()) {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        }
    }

    public boolean enablePrivateInfoObtain() {
        return true;
    }

    public boolean needAppList() {
        return false;
    }

    public boolean needAppendKuaHeader() {
        return true;
    }

    public boolean needDeviceInfoBody() {
        return true;
    }

    public d(int i, @Nullable SceneImpl sceneImpl) {
        hadCreateInstance = true;
        if (needAppendKuaHeader()) {
            appendKUAHeader();
        }
        if (needDeviceInfoBody()) {
            putBody("deviceInfo", com.kwad.sdk.utils.c.d.k(needAppList(), i));
        }
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.e(sceneImpl));
        }
    }
}
