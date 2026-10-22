package com.kc.bw.common.bean;

import com.google.gson.annotations.SerializedName;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkMediationAppResp {
    public MediationAppCfg app;

    @SerializedName("a4")
    public List<AndroidBundle> bundle;
    public int code;

    public MediationAppCfg getApp() {
        return this.app;
    }

    public List<AndroidBundle> getBundle() {
        return this.bundle;
    }

    public int getCode() {
        return this.code;
    }

    public void setApp(MediationAppCfg mediationAppCfg) {
        this.app = mediationAppCfg;
    }

    public void setBundle(List<AndroidBundle> list) {
        this.bundle = list;
    }

    public void setCode(int i) {
        this.code = i;
    }
}
