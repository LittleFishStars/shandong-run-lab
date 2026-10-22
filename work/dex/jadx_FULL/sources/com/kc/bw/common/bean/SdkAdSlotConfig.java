package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkAdSlotConfig {
    public static final int REQUEST_FAIL_RETRY = 1;
    public static final int REQUEST_TYPE_ACCELERATOR = 1;
    public static final int REQUEST_TYPE_FIXED_NUM = 2;
    public static final int REQUEST_TYPE_SAME_PRICE = 3;
    public int adslotIdRequestTime;
    public int bannerRft;
    public int fSdkAdPrompt;
    public int fSdkDownloadPopup;
    public Optimization optimization;
    public int queryPriceTime;
    public int requestAdNumber;
    public int requestFailRetry;
    public int requestType;
    public int sdkInvokeFailRetry;
    public int sdkStrategyCacheTime;
    public int singleRequetsTime;

    public int getAdslotIdRequestTime() {
        return this.adslotIdRequestTime;
    }

    public int getBannerRft() {
        return this.bannerRft;
    }

    public Optimization getOptimization() {
        return this.optimization;
    }

    public int getQueryPriceTime() {
        return this.queryPriceTime;
    }

    public int getRequestAdNumber() {
        return this.requestAdNumber;
    }

    public int getRequestFailRetry() {
        return this.requestFailRetry;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getSdkInvokeFailRetry() {
        return this.sdkInvokeFailRetry;
    }

    public int getSdkStrategyCacheTime() {
        return this.sdkStrategyCacheTime;
    }

    public int getSingleRequetsTime() {
        return this.singleRequetsTime;
    }

    public int getfSdkAdPrompt() {
        return this.fSdkAdPrompt;
    }

    public int getfSdkDownloadPopup() {
        return this.fSdkDownloadPopup;
    }

    public void setAdslotIdRequestTime(int i) {
        this.adslotIdRequestTime = i;
    }

    public void setBannerRft(int i) {
        this.bannerRft = i;
    }

    public void setOptimization(Optimization optimization) {
        this.optimization = optimization;
    }

    public void setQueryPriceTime(int i) {
        this.queryPriceTime = i;
    }

    public void setRequestAdNumber(int i) {
        this.requestAdNumber = i;
    }

    public void setRequestFailRetry(int i) {
        this.requestFailRetry = i;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public void setSdkInvokeFailRetry(int i) {
        this.sdkInvokeFailRetry = i;
    }

    public void setSdkStrategyCacheTime(int i) {
        this.sdkStrategyCacheTime = i;
    }

    public void setSingleRequetsTime(int i) {
        this.singleRequetsTime = i;
    }

    public void setfSdkAdPrompt(int i) {
        this.fSdkAdPrompt = i;
    }

    public void setfSdkDownloadPopup(int i) {
        this.fSdkDownloadPopup = i;
    }

    public String toString() {
        return dexg.dexa("TelBetmpuDpogjh|cboofsSgu>") + this.bannerRft + dexg.dexa("-!gTelEpxompbeQpqvq>") + this.fSdkDownloadPopup + dexg.dexa("-!gTelBeQspnqu>") + this.fSdkAdPrompt + dexg.dexa("-!telTusbufhzDbdifUjnf>") + this.sdkStrategyCacheTime + dexg.dexa("-!telJowplfGbjmSfusz>") + this.sdkInvokeFailRetry + dexg.dexa("-!sfrvftuUzqf>") + this.requestType + dexg.dexa("-!sfrvftuBeOvncfs>") + this.requestAdNumber + dexg.dexa("-!sfrvftuGbjmSfusz>") + this.requestFailRetry + dexg.dexa("-!betmpuJeSfrvftuUjnf>") + this.adslotIdRequestTime + dexg.dexa("-!tjohmfSfrvfutUjnf>") + this.singleRequetsTime + dexg.dexa("-!rvfszQsjdfUjnf>") + this.queryPriceTime + dexg.dexa("-!pqujnj{bujpo>") + this.optimization + '}';
    }
}
