package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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
        return dexg.dexa("NfjebBetmpuJeDpogjh|telBetmpuJe>(") + this.sdkAdslotId + '\'' + dexg.dexa("-!telUijseQmbugpsnt>") + this.sdkThirdPlatforms + dexg.dexa("-!telBetmpuDpogjh>") + this.sdkAdslotConfig + '}';
    }
}
