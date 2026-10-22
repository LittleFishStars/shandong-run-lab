package com.bytedance.sdk.openadsdk;

import android.os.SystemClock;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 2497})
public final class TTAdConfig extends CSJConfig {

    @c(c = {0, 80, 81, 82, 2232})
    public static class Builder {
        private CSJConfig.c c = new CSJConfig.c();
        private final long tt = SystemClock.elapsedRealtime();

        public Builder addExtra(String str, Object obj) {
            this.c.c(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.c.tt(z);
            return this;
        }

        public Builder appId(String str) {
            this.c.c(str);
            return this;
        }

        public Builder appName(String str) {
            this.c.tt(str);
            return this;
        }

        public TTAdConfig build() {
            this.c.c("csj_b_st_ts", Long.valueOf(this.tt));
            return new TTAdConfig(this.c);
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.c.c(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.c.uj(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.c.ve(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.c.c(iArr);
            return this;
        }

        public Builder keywords(String str) {
            this.c.ve(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.c.c(z);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.c.uj(i);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.c.c(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.c.ve(i);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.c.uj(z);
            return this;
        }

        public Builder themeStatus(int i) {
            this.c.tt(i);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.c.c(i);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.c.n(z);
            return this;
        }
    }

    private TTAdConfig(CSJConfig.c cVar) {
        super(cVar);
    }
}
