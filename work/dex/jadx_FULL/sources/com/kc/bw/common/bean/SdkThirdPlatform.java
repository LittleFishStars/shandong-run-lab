package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
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
        return dexg.dexa("TelUijseQmbugpsn|je>") + this.id + dexg.dexa("-!obnf>(") + this.name + '\'' + dexg.dexa("-!dmbttUzqf>(") + this.classType + '\'' + dexg.dexa("-!telUijseBetmpuDpogjh>") + this.sdkThirdAdslotConfig + '}';
    }
}
