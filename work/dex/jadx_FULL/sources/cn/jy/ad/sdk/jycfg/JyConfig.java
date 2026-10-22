package cn.jy.ad.sdk.jycfg;

import cn.jy.ad.sdk.jycfg.ctr.CustomController;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JyConfig {
    private String appId;
    private String channelId;
    private CustomController controller;
    private int[] directDownloadNetworkTypes;
    private Map<String, Object> extraUserDataMap;
    private boolean limitPersonAds = false;

    public static class Builder {
        public String appId;
        public String channelId;
        public CustomController controller;
        public Map<String, Object> extraUserDataMap;
        public int[] directDownloadNetworkTypes = null;
        public boolean limitPersonalAds = false;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public JyConfig build() {
            JyConfig jyConfig = new JyConfig();
            jyConfig.appId = this.appId;
            jyConfig.controller = this.controller;
            jyConfig.channelId = this.channelId;
            jyConfig.directDownloadNetworkTypes = this.directDownloadNetworkTypes;
            jyConfig.limitPersonAds = this.limitPersonalAds;
            jyConfig.extraUserDataMap = this.extraUserDataMap;
            return jyConfig;
        }

        @Deprecated
        public Builder channelId(String str) {
            this.channelId = str;
            return this;
        }

        public Builder customController(CustomController customController) {
            this.controller = customController;
            return this;
        }

        @Deprecated
        public Builder directDownloadNetworkType(int... iArr) {
            this.directDownloadNetworkTypes = iArr;
            return this;
        }

        public Builder limitPersonalAds(boolean z) {
            this.limitPersonalAds = z;
            return this;
        }

        public Builder setExtraUserData(Map<String, Object> map) {
            this.extraUserDataMap = map;
            return this;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    @Deprecated
    public String getChannelId() {
        return this.channelId;
    }

    public CustomController getCustomController() {
        return this.controller;
    }

    @Deprecated
    public int[] getDirectDownloadNetworkTypes() {
        return this.directDownloadNetworkTypes;
    }

    public Map<String, Object> getExtraUserData() {
        return this.extraUserDataMap;
    }

    public boolean isLimitPersonalAds() {
        return this.limitPersonAds;
    }
}
