package cj.mobile.wm.common.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
