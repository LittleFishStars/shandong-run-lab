package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.co;
import com.beizi.fusion.i2;
import com.beizi.fusion.qg;
import com.beizi.fusion.vq;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ResponseInfo {
    public static final String DEFAULT_CONFIG_FILE = "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";
    public static final String DEFAULT_HTTPS_CONFIG_FILE = "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";
    private static volatile ResponseInfo mInstance;
    private AdPlusConfig adPlusConfig;
    private String configVersion;
    private Configurator configurator;
    private Context context;
    private String crashUrl;
    private long expireTime;
    private GlobalConfig globalConfig;
    private IncentiveConfig incentiveConfig;
    private volatile boolean isInit = false;
    private Manager manager;
    private long maxValidTime;
    private Messenger messenger;
    private S2SBiddingConfig s2SBiddingConfig;
    private String smFlag;
    private TaskConfig taskConfig;

    private ResponseInfo(Context context) {
        this.context = context;
    }

    public static ResponseInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ResponseInfo.class) {
                if (mInstance == null) {
                    mInstance = new ResponseInfo(context);
                }
            }
        }
        return mInstance;
    }

    private void initFail() {
        this.isInit = false;
    }

    public AdPlusConfig getAdPlusConfig() {
        return this.adPlusConfig;
    }

    public AdSpacesBean getAdSpaceBean(String str) {
        List<AdSpacesBean> adSpaces;
        Manager manager = this.manager;
        if (manager != null && (adSpaces = manager.getAdSpaces()) != null && adSpaces.size() > 0) {
            for (int i = 0; i < adSpaces.size(); i++) {
                AdSpacesBean adSpacesBean = adSpaces.get(i);
                if (str.equals(adSpacesBean.getSpaceId())) {
                    return adSpacesBean;
                }
            }
        }
        return null;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public Configurator getConfigurator() {
        return this.configurator;
    }

    public String getCrashUrl() {
        return this.crashUrl;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public GlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public IncentiveConfig getIncentiveConfig() {
        return this.incentiveConfig;
    }

    public long getLocationFrequency() {
        Manager manager = this.manager;
        if (manager == null) {
            return 0L;
        }
        long locationFrequency = manager.getLocationFrequency();
        if (locationFrequency == 0) {
            return 86400000L;
        }
        return locationFrequency;
    }

    public Manager getManager() {
        return this.manager;
    }

    public long getMaxValidTime() {
        return this.maxValidTime;
    }

    public Messenger getMessenger() {
        return this.messenger;
    }

    public String getOpenSDKAppId() {
        Manager manager = this.manager;
        if (manager == null) {
            return null;
        }
        return manager.getOpenSDKId();
    }

    public S2SBiddingConfig getS2SBiddingConfig() {
        return this.s2SBiddingConfig;
    }

    public String getSmFlag() {
        return this.smFlag;
    }

    public TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public synchronized ResponseInfo init() {
        String strA;
        String str = (String) co.a(this.context, "globalConfig", (Object) (BeiZis.getTransferProtocol() ? DEFAULT_HTTPS_CONFIG_FILE : DEFAULT_CONFIG_FILE));
        if (TextUtils.isEmpty(str)) {
            str = BeiZis.getTransferProtocol() ? DEFAULT_HTTPS_CONFIG_FILE : DEFAULT_CONFIG_FILE;
        }
        if (TextUtils.isEmpty(str) || (strA = i2.a(qg.b(), str)) == null) {
            initFail();
        } else {
            GlobalConfig globalConfigObjectFromData = GlobalConfig.objectFromData(strA);
            this.globalConfig = globalConfigObjectFromData;
            if (globalConfigObjectFromData != null) {
                this.configVersion = globalConfigObjectFromData.getConfigVersion();
                this.expireTime = this.globalConfig.getExpireTime();
                this.configurator = this.globalConfig.getConfigurator();
                this.messenger = this.globalConfig.getMessenger();
                this.manager = this.globalConfig.getManager();
                this.taskConfig = this.globalConfig.getTaskConfig();
                Configurator configurator = this.configurator;
                if (configurator != null) {
                    this.s2SBiddingConfig = configurator.getS2sbidding();
                }
                this.adPlusConfig = this.globalConfig.getAdPlusConfig();
                this.incentiveConfig = this.globalConfig.getIncentiveConfig();
                this.crashUrl = this.globalConfig.getCrashUrl();
                if (TextUtils.isEmpty(this.globalConfig.getSmFlag())) {
                    this.smFlag = "0";
                } else {
                    this.smFlag = this.globalConfig.getSmFlag();
                }
                this.isInit = true;
                vq.a(this.context);
            } else {
                initFail();
            }
        }
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public boolean isOpenSensor() {
        Manager manager = this.manager;
        return (manager == null || manager.getOpenSensor() == 0) ? false : true;
    }

    public void setAdPlusConfig(AdPlusConfig adPlusConfig) {
        this.adPlusConfig = adPlusConfig;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setConfigurator(Configurator configurator) {
        this.configurator = configurator;
    }

    public void setCrashUrl(String str) {
        this.crashUrl = str;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public void setGlobalConfig(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    public void setIncentiveConfig(IncentiveConfig incentiveConfig) {
        this.incentiveConfig = incentiveConfig;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setMaxValidTime(long j) {
        this.maxValidTime = j;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public void setS2SBiddingConfig(S2SBiddingConfig s2SBiddingConfig) {
        this.s2SBiddingConfig = s2SBiddingConfig;
    }

    public void setSmFlag(String str) {
        this.smFlag = str;
    }

    public void setTaskConfig(TaskConfig taskConfig) {
        this.taskConfig = taskConfig;
    }
}
