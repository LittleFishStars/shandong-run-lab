package com.fl.saas.base.adapter;

import androidx.annotation.NonNull;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.interfaces.AdGetWinInfo;
import com.fl.saas.base.manager.WaterfallHierarchyController;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewAdapter {
    private AdSource adSource;
    private AdViewManager adViewManager;

    private synchronized void processAdResults(AdapterAPI adapterAPI, boolean z) {
        WaterfallHierarchyController waterfallHierarchyController = this.adViewManager.adStatus.get(Integer.valueOf(this.adSource.adHierarchy));
        if (waterfallHierarchyController == null) {
            LogcatUtil.d("YdSDK-Adapter", "未获取到对应的层级控制器");
            return;
        }
        if (z) {
            waterfallHierarchyController.finishNum++;
            waterfallHierarchyController.setSuccessAd(this.adSource, adapterAPI);
            this.adViewManager.successAds.put(this.adSource, adapterAPI);
            LogcatUtil.d("YdSDK-Adapter", "Waterfall第" + this.adSource.adHierarchy + "层成功数量:" + waterfallHierarchyController.finishNum);
            LogcatUtil.d("YdSDK-Adapter", "Waterfall第" + this.adSource.adHierarchy + "层,请求成功,失败数量:" + waterfallHierarchyController.failNum);
            AdSource adSource = this.adSource;
            if (adSource.isTop) {
                this.adViewManager.setSuccessAds(adSource, adapterAPI);
                AdViewManager adViewManager = this.adViewManager;
                adViewManager.isWaterfallDone = true;
                adViewManager.selectAdShow();
                return;
            }
            if (waterfallHierarchyController.isDone()) {
                int i = waterfallHierarchyController.hierarchy;
                if (i == 0) {
                    LogcatUtil.d("YdSDK-Adapter", "请求成功，top层请求全部完成，有填充，选择单价高的展示");
                    this.adViewManager.successAds.putAll(waterfallHierarchyController.successAds);
                    AdViewManager adViewManager2 = this.adViewManager;
                    adViewManager2.isWaterfallDone = true;
                    adViewManager2.selectAdShow();
                } else {
                    this.adViewManager.cyclicQueryController(i);
                    if (!waterfallHierarchyController.isReqNext() && !this.adViewManager.isWaterfallDone) {
                        waterfallHierarchyController.setReqNext(true);
                        this.adViewManager.nextRequestSdkAd();
                    }
                }
            }
        } else {
            waterfallHierarchyController.failNum++;
            LogcatUtil.d("YdSDK-Adapter", "Waterfall第" + this.adSource.adHierarchy + "层失败回调,失败数量:" + waterfallHierarchyController.failNum);
            LogcatUtil.d("YdSDK-Adapter", "Waterfall第" + this.adSource.adHierarchy + "层失败回调,成功数量:" + waterfallHierarchyController.finishNum);
            LogcatUtil.d("YdSDK-Adapter", "Waterfall第" + this.adSource.adHierarchy + "层需要请求个数:" + waterfallHierarchyController.adNum);
            if (waterfallHierarchyController.isDone()) {
                int i2 = waterfallHierarchyController.hierarchy;
                if (i2 != 0 || waterfallHierarchyController.finishNum <= 0) {
                    this.adViewManager.cyclicQueryController(i2);
                    if (!waterfallHierarchyController.isReqNext() && !this.adViewManager.isWaterfallDone) {
                        waterfallHierarchyController.setReqNext(true);
                        this.adViewManager.nextRequestSdkAd();
                    }
                } else {
                    LogcatUtil.d("YdSDK-Adapter", "请求成功，top层请求全部完成，有填充，选择单价高的展示");
                    this.adViewManager.successAds.putAll(waterfallHierarchyController.successAds);
                    AdViewManager adViewManager3 = this.adViewManager;
                    adViewManager3.isWaterfallDone = true;
                    adViewManager3.selectAdShow();
                }
            }
        }
    }

    public void biddingRestAdSource(@NonNull AdSource adSource) {
        this.adSource = adSource;
    }

    public boolean canUseEcpm() {
        AdViewManager adViewManager = this.adViewManager;
        return adViewManager == null || adViewManager.getOriginalAdPlace() == null || this.adViewManager.getOriginalAdPlace().fill_price == 1;
    }

    public boolean changeReRequestCount() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            return adViewManager.changeReRequestCount();
        }
        return false;
    }

    public WinAdInfo getWinInfo() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager == null || !(adViewManager.getValidAdapter() instanceof AdGetWinInfo)) {
            return null;
        }
        return ((AdGetWinInfo) this.adViewManager.getValidAdapter()).getWinAdInfo();
    }

    public boolean isReRequest() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            return adViewManager.isReRequest();
        }
        return false;
    }

    public void onFailed(AdapterAPI adapterAPI, ErrorInfo errorInfo) {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager == null || this.adSource == null || adViewManager.isHasAdErrInfo(errorInfo)) {
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", this.adSource + "广告加载失败:" + errorInfo.code + "___" + errorInfo.msg);
        if (this.adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isApiBidAd");
        }
        if (this.adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isS2SBidAd");
        }
        if (this.adSource.isC2SBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isC2SBidAd");
        }
        if (this.adViewManager.adViewAdapter != null && hashCode() == this.adViewManager.adViewAdapter.hashCode()) {
            this.adViewManager.onAdFailed(new YdError(errorInfo.code, errorInfo.errorType, errorInfo.msg));
            return;
        }
        this.adViewManager.setErrInfo(errorInfo);
        AdSource adSource = this.adSource;
        if (adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "sdk bid失败");
            AdViewManager adViewManager2 = this.adViewManager;
            if (adViewManager2 == null || adViewManager2.adSaasPlace == null || adViewManager2.sdkBidRetrun) {
                return;
            }
            adViewManager2.removeMessages(6);
            AdViewManager adViewManager3 = this.adViewManager;
            adViewManager3.sdkBidRetrun = true;
            adViewManager3.selectAdShow();
            return;
        }
        if (adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "api bid失败");
            AdViewManager adViewManager4 = this.adViewManager;
            if (adViewManager4 == null || adViewManager4.adSaasPlace == null || adViewManager4.apiBidRetrun) {
                return;
            }
            adViewManager4.apiBidRetrun = true;
            adViewManager4.selectAdShow();
            return;
        }
        if (adSource.isBottomAd) {
            AdViewManager adViewManager5 = this.adViewManager;
            adViewManager5.bottomFailNum++;
            adViewManager5.retrunBottomResult();
            return;
        }
        if (!adSource.isC2SBidAd) {
            processAdResults(adapterAPI, false);
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", "c2s bid失败");
        AdViewManager adViewManager6 = this.adViewManager;
        adViewManager6.c2sBidFailNum++;
        adViewManager6.setS2SFailAds(this.adSource, adapterAPI);
        LogcatUtil.d("YdSDK-Adapter", "c2s成功数量:" + this.adViewManager.c2sBidFinishNum + "///c2s失败数量:" + this.adViewManager.c2sBidFailNum);
        AdViewManager adViewManager7 = this.adViewManager;
        if (adViewManager7.c2sBidFailNum + adViewManager7.c2sBidFinishNum == this.adSource.c2sSumNum) {
            LogcatUtil.d("YdSDK-Adapter", "本次请失败，C2S请求全部完成");
            AdViewManager adViewManager8 = this.adViewManager;
            adViewManager8.isC2SAdDone = true;
            adViewManager8.selectAdShow();
        }
    }

    public void onSuccess(AdapterAPI adapterAPI) {
        AdSource adSource;
        LogcatUtil.d("YdSDK-Adapter", "广告加载成功:" + this.adSource);
        if (this.adViewManager == null || (adSource = this.adSource) == null) {
            return;
        }
        if (adSource.isApiBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isApiBidAd");
        }
        if (this.adSource.isSDKBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isS2SBidAd:");
        }
        if (this.adSource.isC2SBidAd) {
            LogcatUtil.d("YdSDK-Adapter", "isC2SBidAd:");
        }
        this.adViewManager.setResponseInfo(this.adSource);
        AdSource adSource2 = this.adSource;
        if (adSource2.isSDKBidAd) {
            AdViewManager adViewManager = this.adViewManager;
            if (adViewManager.sdkBidRetrun) {
                return;
            }
            adViewManager.removeMessages(6);
            AdViewManager adViewManager2 = this.adViewManager;
            adViewManager2.sdkBidRetrun = true;
            adViewManager2.setSuccessAds(this.adSource, adapterAPI);
            this.adViewManager.selectAdShow();
            return;
        }
        if (adSource2.isApiBidAd) {
            if (adSource2.getAdCacheBean() != null) {
                this.adViewManager.setSuccessAds(this.adSource, adapterAPI);
                return;
            }
            AdViewManager adViewManager3 = this.adViewManager;
            if (adViewManager3.apiBidRetrun) {
                return;
            }
            adViewManager3.apiBidRetrun = true;
            adViewManager3.setSuccessAds(this.adSource, adapterAPI);
            this.adViewManager.selectAdShow();
            return;
        }
        if (adSource2.isBottomAd) {
            AdViewManager adViewManager4 = this.adViewManager;
            adViewManager4.bottomFinishNum++;
            adViewManager4.setBottomSuccessAds(adSource2, adapterAPI);
            this.adViewManager.retrunBottomResult();
            return;
        }
        if (!adSource2.isC2SBidAd) {
            processAdResults(adapterAPI, true);
            return;
        }
        LogcatUtil.d("YdSDK-Adapter", "c2s bid return");
        ReportHelper.getInstance().reportC2SBiddingAd(this.adSource);
        AdViewManager adViewManager5 = this.adViewManager;
        adViewManager5.c2sBidFinishNum++;
        adViewManager5.setS2SSuccessAds(this.adSource, adapterAPI);
        LogcatUtil.d("YdSDK-Adapter", "c2s成功数量:" + this.adViewManager.c2sBidFinishNum);
        LogcatUtil.d("YdSDK-Adapter", "c2s失败数量:" + this.adViewManager.c2sBidFailNum);
        LogcatUtil.d("YdSDK-Adapter", "adSource.c2sSumNum:" + this.adSource.c2sSumNum);
        AdViewManager adViewManager6 = this.adViewManager;
        if (adViewManager6.c2sBidFailNum + adViewManager6.c2sBidFinishNum == this.adSource.c2sSumNum) {
            LogcatUtil.d("YdSDK-Adapter", "本次请成功，C2S请求全部完成");
            AdViewManager adViewManager7 = this.adViewManager;
            adViewManager7.isC2SAdDone = true;
            adViewManager7.selectAdShow();
        }
    }

    public void sendRequestMsg() {
        AdViewManager adViewManager = this.adViewManager;
        if (adViewManager != null) {
            adViewManager.setRequestInfo(this.adSource);
        }
    }

    public void setAdViewManager(AdViewManager adViewManager) {
        this.adViewManager = adViewManager;
    }
}
