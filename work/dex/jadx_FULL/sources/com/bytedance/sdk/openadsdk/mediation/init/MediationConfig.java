package com.bytedance.sdk.openadsdk.mediation.init;

import com.byazt.zqa.c;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 84, 1837})
public class MediationConfig implements IMediationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f29313a;
    private String c;
    private boolean da;
    private boolean i;
    private boolean n;
    private String sl;
    private boolean sp;
    private boolean tt;
    private Map<String, Object> uj;
    private MediationConfigUserInfoForSegment ve;
    private String x;

    @c(c = {0, 80, 81, 82, 83, 84, 2050})
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f29314a;
        private String c;
        private boolean da;
        private boolean i;
        private boolean n;
        private String sl;
        private boolean sp;
        private boolean tt;
        private Map<String, Object> uj;
        private MediationConfigUserInfoForSegment ve;
        private String x;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.c = this.c;
            mediationConfig.tt = this.tt;
            mediationConfig.ve = this.ve;
            mediationConfig.uj = this.uj;
            mediationConfig.n = this.n;
            mediationConfig.f29313a = this.f29314a;
            mediationConfig.sp = this.sp;
            mediationConfig.x = this.x;
            mediationConfig.i = this.i;
            mediationConfig.da = this.da;
            mediationConfig.sl = this.sl;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f29314a = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.n = z;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.uj = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.ve = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.tt = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.x = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.c = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.da = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.sl = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.sp = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f29313a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.uj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.ve;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.da;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.sp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.sl;
    }

    private MediationConfig() {
    }
}
