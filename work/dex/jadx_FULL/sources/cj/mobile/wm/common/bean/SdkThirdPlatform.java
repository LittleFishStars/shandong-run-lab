package cj.mobile.wm.common.bean;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SdkThirdPlatform {
    public String classType;
    public int id;
    public String name;
    public int requestIndex;
    public SdkThirdPlatformAdslotConfig sdkThirdAdslotConfig;

    public String getClassType() {
        return this.classType;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getRequestIndex() {
        return this.requestIndex;
    }

    public SdkThirdPlatformAdslotConfig getSdkThirdAdslotConfig() {
        return this.sdkThirdAdslotConfig;
    }

    public void setClassType(String str) {
        this.classType = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRequestIndex(int i) {
        this.requestIndex = i;
    }

    public void setSdkThirdAdslotConfig(SdkThirdPlatformAdslotConfig sdkThirdPlatformAdslotConfig) {
        this.sdkThirdAdslotConfig = sdkThirdPlatformAdslotConfig;
    }

    public String toString() {
        return dexc.dexa("TelUijseQmbugpsn|je>") + this.id + dexc.dexa("-!obnf>(") + this.name + '\'' + dexc.dexa("-!dmbttUzqf>(") + this.classType + '\'' + dexc.dexa("-!telUijseBetmpuDpogjh>") + this.sdkThirdAdslotConfig + '}';
    }
}
