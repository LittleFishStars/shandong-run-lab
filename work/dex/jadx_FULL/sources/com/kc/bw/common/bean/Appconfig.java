package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Appconfig {
    public int accountShareTime;
    public List<MediaAdSlotIdConfig> adslotIdsConfig;
    public AdBlackConfig appBlackConfig;
    public Map<String, Integer> appPermissionConfig;
    public CheckDPObj checkDPObj;
    public String cornerLogo;
    public String cornerLogoAd;
    public int fcst = 5;
    public boolean radioOnoff;
    public int requestSuccessRetryTime;
    public int shieldFastappOnOff;
    public List<String> shieldFastappSensitiveWords;
    public List<String> shieldFastappSensitiveWordsContent;
    public int trackeventRatio;

    public int getAccountShareTime() {
        return this.accountShareTime;
    }

    public List<MediaAdSlotIdConfig> getAdslotIdsConfig() {
        return this.adslotIdsConfig;
    }

    public AdBlackConfig getAppBlackConfig() {
        return this.appBlackConfig;
    }

    public Map<String, Integer> getAppPermissionConfig() {
        return this.appPermissionConfig;
    }

    public CheckDPObj getCheckDPObj() {
        return this.checkDPObj;
    }

    public String getCornerLogo() {
        return this.cornerLogo;
    }

    public String getCornerLogoAd() {
        return this.cornerLogoAd;
    }

    public int getFcst() {
        return this.fcst;
    }

    public int getRequestSuccessRetryTime() {
        return this.requestSuccessRetryTime;
    }

    public int getShieldFastappOnOff() {
        return this.shieldFastappOnOff;
    }

    public List<String> getShieldFastappSensitiveWords() {
        return this.shieldFastappSensitiveWords;
    }

    public List<String> getShieldFastappSensitiveWordsContent() {
        return this.shieldFastappSensitiveWordsContent;
    }

    public int getTrackeventRatio() {
        return this.trackeventRatio;
    }

    public boolean isRadioOnoff() {
        return this.radioOnoff;
    }

    public void setAccountShareTime(int i) {
        this.accountShareTime = i;
    }

    public void setAdslotIdsConfig(List<MediaAdSlotIdConfig> list) {
        this.adslotIdsConfig = list;
    }

    public void setAppBlackConfig(AdBlackConfig adBlackConfig) {
        this.appBlackConfig = adBlackConfig;
    }

    public void setAppPermissionConfig(Map<String, Integer> map) {
        this.appPermissionConfig = map;
    }

    public void setCheckDPObj(CheckDPObj checkDPObj) {
        this.checkDPObj = checkDPObj;
    }

    public void setCornerLogo(String str) {
        this.cornerLogo = str;
    }

    public void setCornerLogoAd(String str) {
        this.cornerLogoAd = str;
    }

    public void setFcst(int i) {
        this.fcst = i;
    }

    public void setRadioOnoff(boolean z) {
        this.radioOnoff = z;
    }

    public void setRequestSuccessRetryTime(int i) {
        this.requestSuccessRetryTime = i;
    }

    public void setShieldFastappOnOff(int i) {
        this.shieldFastappOnOff = i;
    }

    public void setShieldFastappSensitiveWords(List<String> list) {
        this.shieldFastappSensitiveWords = list;
    }

    public void setShieldFastappSensitiveWordsContent(List<String> list) {
        this.shieldFastappSensitiveWordsContent = list;
    }

    public void setTrackeventRatio(int i) {
        this.trackeventRatio = i;
    }
}
