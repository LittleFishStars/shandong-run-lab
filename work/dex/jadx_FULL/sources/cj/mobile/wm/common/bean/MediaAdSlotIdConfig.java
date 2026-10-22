package cj.mobile.wm.common.bean;

import cj.mobile.wm.dexc;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MediaAdSlotIdConfig {
    public SdkAdSlotConfig sdkAdslotConfig;
    public String sdkAdslotId;
    public List<SdkThirdPlatform> sdkThirdPlatforms;

    public SdkAdSlotConfig getSdkAdslotConfig() {
        return this.sdkAdslotConfig;
    }

    public String getSdkAdslotId() {
        return this.sdkAdslotId;
    }

    public List<SdkThirdPlatform> getSdkThirdPlatforms() {
        return this.sdkThirdPlatforms;
    }

    public void setSdkAdslotConfig(SdkAdSlotConfig sdkAdSlotConfig) {
        this.sdkAdslotConfig = sdkAdSlotConfig;
    }

    public void setSdkAdslotId(String str) {
        this.sdkAdslotId = str;
    }

    public void setSdkThirdPlatforms(List<SdkThirdPlatform> list) {
        this.sdkThirdPlatforms = list;
    }

    public String toString() {
        return dexc.dexa("NfjebBetmpuJeDpogjh|telBetmpuJe>(") + this.sdkAdslotId + '\'' + dexc.dexa("-!telUijseQmbugpsnt>") + this.sdkThirdPlatforms + dexc.dexa("-!telBetmpuDpogjh>") + this.sdkAdslotConfig + '}';
    }
}
