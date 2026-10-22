package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class StatusInfo extends com.kwad.sdk.core.response.a.a {
    public int aXs;
    public int aXt;
    public SplashAdInfo aXu;
    public NativeAdRequestInfo aXv;
    public List<f> aXw;

    @KsJson
    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.c.g(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    @KsJson
    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableRotate = true;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            ac.putValue(jSONObject, "enableShake", this.enableShake);
            ac.putValue(jSONObject, "enableRotate", this.enableRotate);
        }
    }

    @KsJson
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.c.Ue();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.c.f(sceneImpl);
            return splashAdInfo;
        }
    }

    @KsJson
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        try {
            int i = 1;
            this.aXs = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fv() ? 1 : 0;
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fw()) {
                i = 0;
            }
            this.aXt = i;
            this.aXw = com.kwad.sdk.core.local.a.Ma();
            this.aXv = NativeAdRequestInfo.create(sceneImpl);
            this.aXu = SplashAdInfo.create(sceneImpl);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static StatusInfo e(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
