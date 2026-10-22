package android.taobao.windvane.config;

import android.app.Application;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class GlobalConfig {
    public static final String DEFAULT_TTID = "hybrid@windvane_android_8.5.0";
    public static final String DEFAULT_UA = " WindVane/8.5.0";
    public static final String VERSION = "8.5.0";
    private static GlobalConfig config;
    public static Application context;
    public static EnvEnum env = EnvEnum.ONLINE;
    public static boolean isBackground = false;
    private String appKey;
    private String appSecret;
    private String appTag;
    private String appVersion;
    private String deviceId;
    private String imei;
    private String imsi;
    private String ttid;
    private String ucLibDir = null;
    private boolean ucSdkInternationalEnv = false;
    private String[] ucsdkappkeySec = null;
    private boolean needSpeed = false;
    private int injected = -1;

    private GlobalConfig() {
    }

    private String getH5Host() {
        return (EnvEnum.ONLINE.equals(env) ? "https://h5." : "http://h5.") + env.getValue() + ".taobao.com";
    }

    public static GlobalConfig getInstance() {
        if (config == null) {
            synchronized (GlobalConfig.class) {
                if (config == null) {
                    config = new GlobalConfig();
                }
            }
        }
        return config;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getAppTag() {
        return this.appTag;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCdnConfigUrlPre() {
        return getH5Host() + "/bizcache/";
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public int getInjectCode() {
        return this.injected;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getUcLibDir() {
        return this.ucLibDir;
    }

    public String[] getUcsdkappkeySec() {
        return this.ucsdkappkeySec;
    }

    public boolean initParams(WVAppParams wVAppParams) {
        if (wVAppParams == null) {
            return false;
        }
        if (TextUtils.isEmpty(wVAppParams.appKey)) {
            throw new NullPointerException("initParams error, appKey is empty");
        }
        if (TextUtils.isEmpty(wVAppParams.ttid)) {
            this.ttid = DEFAULT_TTID;
        } else {
            this.ttid = wVAppParams.ttid;
        }
        this.imei = wVAppParams.imei;
        this.imsi = wVAppParams.imsi;
        this.deviceId = wVAppParams.deviceId;
        this.appKey = wVAppParams.appKey;
        this.appSecret = wVAppParams.appSecret;
        this.appTag = wVAppParams.appTag;
        this.appVersion = wVAppParams.appVersion;
        setUcsdkappkeySec(wVAppParams.ucsdkappkeySec);
        if (!TextUtils.isEmpty(wVAppParams.ucLibDir)) {
            this.ucLibDir = wVAppParams.ucLibDir;
        }
        this.ucSdkInternationalEnv = wVAppParams.ucSdkInternationalEnv;
        this.needSpeed = wVAppParams.needSpeed;
        return true;
    }

    public boolean isUcSdkInternationalEnv() {
        return this.ucSdkInternationalEnv;
    }

    public boolean needSpeed() {
        return this.needSpeed;
    }

    public void setInjectCode(int i) {
        if (this.injected == 2) {
            return;
        }
        this.injected = i;
    }

    public void setUcsdkappkeySec(String[] strArr) {
        if (strArr != null) {
            this.ucsdkappkeySec = strArr;
        }
    }
}
