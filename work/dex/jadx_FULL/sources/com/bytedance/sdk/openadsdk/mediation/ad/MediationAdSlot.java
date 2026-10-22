package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.zqa.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 686, 1572})
public class MediationAdSlot implements IMediationAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29304a;
    private boolean c;
    private String da;
    private boolean i;
    private MediationSplashRequestInfo m;
    private float n;
    private boolean sl;
    private boolean sp;
    private MediationNativeToBannerListener t;
    private boolean tt;
    private float u;
    private int uj;
    private String ve;
    private Map<String, Object> x;
    private float yp;
    private String z;

    @c(c = {0, 80, 81, 82, 83, 686, 1033})
    public static class Builder {
        private boolean c;
        private int da;
        private MediationSplashRequestInfo m;
        private boolean n;
        private boolean sl;
        private boolean sp;
        private MediationNativeToBannerListener t;
        private boolean tt;
        private float uj;
        private boolean ve;
        private String x;
        private String z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Object> f29305a = new HashMap();
        private String i = "";
        private float u = 80.0f;
        private float yp = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.c = this.c;
            mediationAdSlot.tt = this.tt;
            mediationAdSlot.sp = this.ve;
            mediationAdSlot.n = this.uj;
            mediationAdSlot.f29304a = this.n;
            mediationAdSlot.x = this.f29305a;
            mediationAdSlot.i = this.sp;
            mediationAdSlot.da = this.x;
            mediationAdSlot.ve = this.i;
            mediationAdSlot.uj = this.da;
            mediationAdSlot.sl = this.sl;
            mediationAdSlot.t = this.t;
            mediationAdSlot.u = this.u;
            mediationAdSlot.yp = this.yp;
            mediationAdSlot.z = this.z;
            mediationAdSlot.m = this.m;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.sl = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.sp = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f29305a;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.t = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.m = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.ve = z;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.da = i;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.i = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.x = str;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.u = f;
            this.yp = f2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.tt = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.uj = f;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.z = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.uj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.ve;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.da;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.yp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.sl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.sp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f29304a;
    }

    private MediationAdSlot() {
        this.ve = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.m;
    }
}
