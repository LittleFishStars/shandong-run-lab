package cj.mobile.wm.common.bean;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppConfigRespBean {
    public Appconfig appConfig;
    public BundlesBean checkBundles;
    public long currentTimeStamp;
    public NbrBean nbr;
    public String realmName;
    public BundlesBean realtimeCheckBundles;
    public String trackHost;

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
            return dexc.dexa("OcsCfbo|dpef>") + this.code + dexc.dexa("-!nth>(") + this.msg + "'}";
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
        return dexc.dexa("HfuIfbeEbub|ocs>") + this.nbr + dexc.dexa("-!bqqDpogjh>") + this.appConfig + dexc.dexa("-!difdlCvoemft>") + this.checkBundles + dexc.dexa("-!dvssfouUjnfTubnq>") + this.currentTimeStamp + dexc.dexa("-!sfbmnObnf>(") + this.realmName + '\'' + dexc.dexa("-!usbdlIptu>(") + this.trackHost + "'}";
    }
}
