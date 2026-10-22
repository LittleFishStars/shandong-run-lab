package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppConfigRespBean {
    public Appconfig appConfig;
    public BundlesBean checkBundles;
    public long currentTimeStamp;
    public NbrBean nbr;
    public String realmName;
    public BundlesBean realtimeCheckBundles;
    public String trackHost;

    @Keep
    public static class NbrBean {
        public int code;
        public String msg;

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public String toString() {
            return dexg.dexa("OcsCfbo|dpef>") + this.code + dexg.dexa("-!nth>(") + this.msg + "'}";
        }
    }

    public Appconfig getAppConfig() {
        return this.appConfig;
    }

    public BundlesBean getCheckBundles() {
        return this.checkBundles;
    }

    public long getCurrentTimeStamp() {
        return this.currentTimeStamp;
    }

    public NbrBean getNbr() {
        return this.nbr;
    }

    public String getRealmName() {
        return this.realmName;
    }

    public BundlesBean getRealtimeCheckBundles() {
        return this.realtimeCheckBundles;
    }

    public String getTrackHost() {
        return this.trackHost;
    }

    public void setAppConfig(Appconfig appconfig) {
        this.appConfig = appconfig;
    }

    public void setCheckBundles(BundlesBean bundlesBean) {
        this.checkBundles = bundlesBean;
    }

    public void setCurrentTimeStamp(long j) {
        this.currentTimeStamp = j;
    }

    public void setNbr(NbrBean nbrBean) {
        this.nbr = nbrBean;
    }

    public void setRealmName(String str) {
        this.realmName = str;
    }

    public void setRealtimeCheckBundles(BundlesBean bundlesBean) {
        this.realtimeCheckBundles = bundlesBean;
    }

    public void setTrackHost(String str) {
        this.trackHost = str;
    }

    public String toString() {
        return dexg.dexa("HfuIfbeEbub|ocs>") + this.nbr + dexg.dexa("-!bqqDpogjh>") + this.appConfig + dexg.dexa("-!difdlCvoemft>") + this.checkBundles + dexg.dexa("-!dvssfouUjnfTubnq>") + this.currentTimeStamp + dexg.dexa("-!sfbmnObnf>(") + this.realmName + '\'' + dexg.dexa("-!usbdlIptu>(") + this.trackHost + "'}";
    }
}
