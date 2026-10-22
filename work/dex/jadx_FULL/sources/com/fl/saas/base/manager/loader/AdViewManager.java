package com.fl.saas.base.manager.loader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.video.AudioStats;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.cache.AdCacheBean;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.AdCacheRepository;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.WaterfallHierarchyController;
import com.fl.saas.base.manager.api.AdapterGenerator;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.RandomUtils;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.SPUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewManager {
    public static final int REPORT_MSG_COUNT_DOWN = 8;
    public static final int REQ_A2S_BID_TIME_OUT = 7;
    private static final int REQ_ALL_TIME_OUT = 1;
    private static final int REQ_BOTTOM_TIME_OUT = 2;
    private static final int REQ_C2S_BID_TIME_OUT = 3;
    private static final int REQ_NEXT = 5;
    private static final int REQ_QUICK_DONE = 4;
    public static final int REQ_S2S_BID_TIME_OUT = 6;
    private static final int REQ_TIME_OUT = 0;
    public AdPlace adSaasPlace;
    private final int adType;
    public AdapterAPI adViewAdapter;
    public int bottomFailNum;
    public int bottomFinishNum;
    public int c2sBidFailNum;
    public int c2sBidFinishNum;
    private String cacheKey;
    private int currentPriceFloor;
    public String key;
    private final AdapterGenerator mAdapterGenerator;
    protected AdPlace originalAdPlace;
    private PreloadDoneCallback preloadDoneCallback;
    public long reqTime;
    public int sumHierarchyNum;
    public boolean isWaterfallDone = false;
    public int nowNum = 0;
    public Map<AdSource, AdapterAPI> successAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> allSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> bottomSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> c2sSuccessAds = new ConcurrentHashMap();
    public Map<AdSource, AdapterAPI> c2sFailAds = new ConcurrentHashMap();
    public Map<Integer, WaterfallHierarchyController> adStatus = new ConcurrentHashMap();
    public List<AdSource> c2sResultAds = new ArrayList();
    private int c2sSecondPrice = 0;
    private int c2sSecondAdvId = 0;
    private final List<ErrorInfo> errInfos = new ArrayList();
    private final List<AdSource> listResponseInfo = new ArrayList();
    private final List<AdSource> listRequestInfo = new ArrayList();
    public boolean isCallback = false;
    private boolean oldStrategy = true;
    private boolean haveStartWaterFall = false;
    private boolean isLastHierarchy = false;
    public boolean isBottomAdDone = false;
    public boolean isShowBottomAd = false;
    public boolean isBottomAdCallback = false;
    public boolean has_c2s_bid = false;
    public boolean isC2SAdDone = false;
    public boolean has_api_bid = false;
    public boolean apiBidRetrun = false;
    public boolean has_sdk_bid = false;
    public boolean sdkBidRetrun = false;
    public boolean isOnlySdkBid = false;
    public boolean has_bottom_ad = false;
    private boolean isSetTop = false;
    private boolean isCacheMode = false;
    private int waterfallFlowStop = -1;
    public boolean isPreloadMode = false;
    private boolean isSelectBottomAdapter = false;
    private int needReRequestCount = 0;
    private boolean refreshRequestCount = true;
    private boolean isReRequest = false;
    private boolean isNeedRequestPreloadAdPlace = false;
    private boolean hasLoadCacheAd = false;
    private int cachePrice = 0;
    public boolean hasCallBackLoadAd = false;
    Handler timeHandle = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.base.manager.loader.AdViewManager.1
        /* JADX WARN: Code duplicated, block: B:40:0x0137  */
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (3 == message.what) {
                LogcatUtil.d("YdSDK-Manager", "C2S竞价广告时间结束");
                AdViewManager adViewManager = AdViewManager.this;
                adViewManager.isC2SAdDone = true;
                adViewManager.selectAdShow();
            }
            if (6 == message.what) {
                LogcatUtil.d("YdSDK-Adapter", "sdkBidTimeHandler");
                AdViewManager adViewManager2 = AdViewManager.this;
                if (!adViewManager2.sdkBidRetrun) {
                    adViewManager2.sdkBidRetrun = true;
                    adViewManager2.selectAdShow();
                }
            }
            if (7 == message.what) {
                LogcatUtil.d("YdSDK-Adapter", "apiBidTimeHandler");
                AdViewManager adViewManager3 = AdViewManager.this;
                if (adViewManager3.has_api_bid && !adViewManager3.apiBidRetrun) {
                    adViewManager3.apiBidRetrun = true;
                    adViewManager3.selectAdShow();
                }
            }
            if (2 == message.what) {
                LogcatUtil.d("YdSDK-Manager", "兜底广告时间结束:" + AdViewManager.this.isShowBottomAd);
                AdViewManager adViewManager4 = AdViewManager.this;
                adViewManager4.isBottomAdDone = true;
                if (adViewManager4.isShowBottomAd) {
                    adViewManager4.disposeBottomAd();
                }
            }
            if (5 == message.what && !AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).isReqNext() && !AdViewManager.this.isWaterfallDone) {
                LogcatUtil.d("YdSDK-Manager", message.arg1 + "层到达请求间隔时间,未完全全部回调。");
                AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).setReqNext(true);
                AdViewManager.this.nextRequestSdkAd();
            }
            if (message.what == 0) {
                LogcatUtil.d("YdSDK-Manager", "单层超时统计,超时层为:" + message.arg1);
                if (AdViewManager.this.isCallback) {
                    LogcatUtil.d("YdSDK-Manager", message.arg1 + "层超时，已经给过回调不再处理");
                } else {
                    LogcatUtil.d("YdSDK-Manager", message.arg1 + "层超时，判断广告选择逻辑");
                    if (AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)) != null) {
                        AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).setTimeOut(true);
                        if (AdViewManager.this.adStatus.get(Integer.valueOf(message.arg1)).isHasAd()) {
                            AdViewManager.this.cyclicQueryController(message.arg1);
                        } else {
                            int i = message.arg1;
                            AdViewManager adViewManager5 = AdViewManager.this;
                            if (i == adViewManager5.sumHierarchyNum - 1) {
                                adViewManager5.waterfallFlowDone();
                            } else {
                                AdViewManager.this.cyclicQueryController(message.arg1);
                            }
                        }
                    }
                }
            }
            if (4 == message.what) {
                Map<AdSource, AdapterAPI> map = AdViewManager.this.successAds;
                if (map == null || map.size() <= 0) {
                    AdViewManager.this.waterfallFlowDone();
                } else {
                    AdViewManager adViewManager6 = AdViewManager.this;
                    adViewManager6.isWaterfallDone = true;
                    adViewManager6.selectAdShow();
                }
            }
            if (1 == message.what) {
                AdViewManager adViewManager7 = AdViewManager.this;
                if (adViewManager7.isPreloadMode && adViewManager7.preloadDoneCallback != null) {
                    AdViewManager.this.preloadDoneCallback.preloadDone();
                }
                Map<AdSource, AdapterAPI> map2 = AdViewManager.this.successAds;
                if (map2 == null || map2.size() <= 0) {
                    AdViewManager.this.mAdapterGenerator.onLoadFailed(new YdError(20408, "request time out"));
                    AdViewManager.this.getPreLoadAdPlace();
                    LogcatUtil.d("YdSDK-Manager", "request time out");
                } else {
                    LogcatUtil.d("YdSDK-Manager", "request time out,AD fill");
                    AdViewManager adViewManager8 = AdViewManager.this;
                    adViewManager8.isWaterfallDone = true;
                    adViewManager8.isC2SAdDone = true;
                    adViewManager8.sdkBidRetrun = true;
                    adViewManager8.apiBidRetrun = true;
                    adViewManager8.selectAdShow();
                }
            }
            if (8 == message.what) {
                AdViewManager.this.mergeReportMsg();
            }
        }
    };

    public AdViewManager(AdapterGenerator adapterGenerator, int i) {
        this.mAdapterGenerator = adapterGenerator;
        this.adType = i;
    }

    private boolean bidResultSelfReturn() {
        AdPlace adPlace = this.originalAdPlace;
        return adPlace == null || adPlace.bid_notice_type != 1;
    }

    private void biddingReq(AdSource adSource) {
        StringBuilder sb;
        int i;
        long bootTime;
        ReportHelper reportHelper;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ReportHelper reportHelper2;
        int i2;
        int i3;
        if (this.has_sdk_bid) {
            if (adSource.price > 0) {
                sb = new StringBuilder();
                i = adSource.price;
            } else {
                sb = new StringBuilder();
                i = adSource.bidfloor;
            }
            sb.append(i);
            sb.append("");
            String string = sb.toString();
            if (adSource.isSDKBidAd) {
                bootTime = DeviceUtil.getBootTime() - this.reqTime;
                reportHelper = ReportHelper.getInstance();
                reportHelper2 = ReportHelper.getInstance();
                i2 = adSource.adv_id;
                str = this.c2sSecondPrice + "";
                str2 = adSource.adv_id + "";
                str3 = adSource.nurl;
                str4 = adSource.lurl;
                str5 = adSource.tagid;
                i3 = 1;
            } else {
                AdSource adSource2 = null;
                for (AdSource adSource3 : this.successAds.keySet()) {
                    if (adSource3.isSDKBidAd) {
                        adSource2 = adSource3;
                    }
                }
                if (adSource2 == null) {
                    return;
                }
                bootTime = DeviceUtil.getBootTime() - this.reqTime;
                reportHelper = ReportHelper.getInstance();
                ReportHelper reportHelper3 = ReportHelper.getInstance();
                int i4 = adSource2.adv_id;
                str = this.c2sSecondPrice + "";
                str2 = adSource.adv_id + "";
                str3 = adSource2.nurl;
                str4 = adSource2.lurl;
                str5 = adSource2.tagid;
                reportHelper2 = reportHelper3;
                i2 = i4;
                i3 = 0;
            }
            reportHelper.reportSDKBidding(reportHelper2.reqBidJson(i2, i3, string, str, str2, str3, str4, str5, bootTime));
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x013e  */
    private void callBackLoadAd(AdSource adSource) {
        int i;
        int i2;
        int i3;
        double d;
        AdapterAPI adapterAPI;
        AdSource key;
        Function<Integer, Integer> priorityStrategy;
        AdPlace adPlace;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("填充回调执行:");
        AdSource adSource2 = adSource;
        sb.append(adSource2.adv_id);
        LogcatUtil.d("YdSDK-Manager", sb.toString());
        if (this.mAdapterGenerator.isFailedCallBack() && !this.isCacheMode) {
            str = "已经执行过失败回调,不进行填充";
        } else {
            if (!this.hasCallBackLoadAd) {
                boolean z = true;
                this.hasCallBackLoadAd = true;
                if (!this.isCacheMode && !this.isPreloadMode) {
                    Function<Integer, Integer> priorityStrategy2 = adSource.getPriorityStrategy();
                    if (priorityStrategy2 != null) {
                        key = adSource2;
                        priorityStrategy = priorityStrategy2;
                        break;
                    }
                    Iterator<Map.Entry<AdSource, AdapterAPI>> it = this.successAds.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            key = adSource2;
                            priorityStrategy = priorityStrategy2;
                            break;
                        }
                        Map.Entry<AdSource, AdapterAPI> next = it.next();
                        key = next.getKey();
                        priorityStrategy = key.getPriorityStrategy();
                        if (priorityStrategy != null) {
                            this.adViewAdapter = next.getValue();
                            break;
                        }
                        priorityStrategy2 = priorityStrategy;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ad show:");
                    AdapterAPI adapterAPI2 = this.adViewAdapter;
                    sb2.append(adapterAPI2 == null ? "null" : adapterAPI2.getAdSource());
                    LogcatUtil.d("YdSDK-Manager", sb2.toString());
                    if (priorityStrategy != null) {
                        key.price = priorityStrategy.apply(Integer.valueOf(adSource.getPrice())).intValue();
                    }
                    AdapterAPI adapterAPI3 = this.adViewAdapter;
                    if (adapterAPI3 != null && (adPlace = this.originalAdPlace) != null) {
                        updateCacheMessage(adapterAPI3, adPlace.track_id);
                    }
                    testSaveShowAdMsg();
                    setDataToAdSource(this.adViewAdapter);
                    int i4 = this.adType;
                    if (i4 == 10) {
                        checkCycleAd(key.getAdvPrice());
                    } else if (i4 == 3) {
                        checkRefreshInterstitialAd();
                    }
                    DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.sx
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f44801a.lambda$callBackLoadAd$0();
                        }
                    });
                    updateImpressFreq();
                    adSource2 = key;
                }
                if (adSource2.getAdCacheBean() != null) {
                    AdCacheRepository.getInstance().deleteAdCache(adSource2.getAdCacheBean().getId());
                }
                int iNextInt = new Random().nextInt(10) + 86;
                AdPlace adPlace2 = this.originalAdPlace;
                double d2 = adPlace2.floatingRatio;
                if (d2 <= 1.0d) {
                    d2 = 1.0d;
                }
                int i5 = adSource2.price;
                if (i5 <= 0 || i5 <= (i2 = this.c2sSecondPrice) ? !((i = adSource2.bidfloor) <= 0 || i <= (i2 = this.c2sSecondPrice) || (i3 = i - i2) <= 100) : (i3 = i5 - i2) > 100) {
                    this.c2sSecondPrice = i2 + ((i3 * iNextInt) / 100);
                    this.c2sSecondAdvId = adSource2.adv_id;
                }
                if (this.isPreloadMode) {
                    setCacheAd(null);
                } else if (adPlace2.isOpenCache) {
                    if (this.isCacheMode) {
                        setCacheAd(null);
                    } else {
                        setCacheAd(adSource2);
                    }
                }
                int i6 = 0;
                if (this.has_api_bid) {
                    for (AdSource adSource3 : this.successAds.keySet()) {
                        if (!adSource3.isCacheAd && adSource3.isApiBidAd) {
                            AdapterAPI adapterAPI4 = this.successAds.get(adSource3);
                            if (adapterAPI4 instanceof BiddingResult) {
                                if (adSource2.hashCode() == adSource3.hashCode()) {
                                    if (bidResultSelfReturn()) {
                                        ((BiddingResult) adapterAPI4).biddingResult(true, adSource2.bidfloor, this.c2sSecondPrice, this.c2sSecondAdvId);
                                    }
                                } else if (adSource2.is_cycle) {
                                    int randomInt = adSource2.bidfloor - RandomUtils.getRandomInt(200);
                                    int i7 = this.c2sSecondAdvId;
                                    if (randomInt < 0) {
                                        randomInt = 0;
                                        i7 = 0;
                                    }
                                    ((BiddingResult) adapterAPI4).biddingResult(true, adSource2.bidfloor, randomInt, i7);
                                } else if (ConfigHelper.getInstance().getCacheSwitch() != 1) {
                                    ((BiddingResult) adapterAPI4).biddingResult(false, (int) (((double) adSource2.bidfloor) * d2), this.c2sSecondPrice, adSource2.adv_id);
                                } else if (adSource3.getAdCacheBean() == null) {
                                    AdCacheBean adCacheBean = new AdCacheBean();
                                    adCacheBean.setPrice(adSource3.getPrice());
                                    adCacheBean.setTime(System.currentTimeMillis());
                                    adCacheBean.setKey(this.cacheKey);
                                    adCacheBean.setValue(adSource3.responseStr);
                                    AdCacheRepository.getInstance().addAdCache(adCacheBean);
                                }
                            }
                        }
                    }
                }
                if (!this.has_c2s_bid || this.c2sSuccessAds.size() <= 0) {
                    d = d2;
                } else {
                    int i8 = adSource2.price;
                    if (i8 <= 0) {
                        i8 = adSource2.bidfloor;
                    }
                    if (i8 < this.c2sSecondPrice) {
                        this.c2sSecondPrice = i8;
                        this.c2sSecondAdvId = adSource2.adv_id;
                    }
                    for (AdSource adSource4 : this.c2sSuccessAds.keySet()) {
                        if (!adSource4.isCacheAd) {
                            AdapterAPI adapterAPI5 = this.c2sSuccessAds.get(adSource4);
                            if (adapterAPI5 instanceof BiddingResult) {
                                if (adSource2.hashCode() == adSource4.hashCode()) {
                                    if (bidResultSelfReturn()) {
                                        ((BiddingResult) adapterAPI5).biddingResult(z, i8, this.c2sSecondPrice, this.c2sSecondAdvId);
                                    }
                                } else if (adSource2.is_cycle) {
                                    int randomInt2 = adSource2.bidfloor - RandomUtils.getRandomInt(20);
                                    int i9 = this.c2sSecondAdvId;
                                    if (randomInt2 < 0) {
                                        randomInt2 = i6;
                                        i9 = randomInt2;
                                    }
                                    ((BiddingResult) adapterAPI5).biddingResult(z, adSource2.bidfloor, randomInt2, i9);
                                } else {
                                    int i10 = (int) (((double) i8) * d2);
                                    AdSource adSource5 = adapterAPI5.getAdSource();
                                    if (i10 < adSource5.price) {
                                        i10 = (int) ((((double) i10) * (adSource5.floating_value + 100.0d)) / 100.0d);
                                    }
                                    adSource2 = adSource2;
                                    ((BiddingResult) adapterAPI5).biddingResult(false, i10, this.c2sSecondPrice, adSource2.adv_id);
                                    i6 = 0;
                                    d2 = d2;
                                    z = true;
                                }
                            }
                        }
                    }
                    d = d2;
                    Iterator<AdSource> it2 = this.c2sFailAds.keySet().iterator();
                    while (it2.hasNext()) {
                        AdapterAPI adapterAPI6 = this.c2sFailAds.get(it2.next());
                        if (adapterAPI6 instanceof BiddingResult) {
                            int i11 = (int) (((double) i8) * d);
                            AdSource adSource6 = adapterAPI6.getAdSource();
                            if (i11 < adSource6.price) {
                                i11 = (int) ((((double) i11) * (adSource6.floating_value + 100.0d)) / 100.0d);
                            }
                            ((BiddingResult) adapterAPI6).biddingResult(false, i11, this.c2sSecondPrice, adSource2.adv_id);
                        }
                    }
                }
                if (this.originalAdPlace.isCachedECPMFirst()) {
                    int price = adSource2.getPrice();
                    if (price < this.c2sSecondPrice) {
                        this.c2sSecondPrice = price;
                        this.c2sSecondAdvId = adSource2.adv_id;
                    }
                    for (AdSource adSource7 : this.successAds.keySet()) {
                        if (adSource7.isPopCacheAd) {
                            LogcatUtil.d("YdSDK-Manager", "缓存模式2,竞价广告回传");
                            AdapterAPI adapterAPI7 = this.successAds.get(adSource7);
                            if (adapterAPI7 instanceof BiddingResult) {
                                if (adSource2.hashCode() == adSource7.hashCode()) {
                                    if (bidResultSelfReturn()) {
                                        ((BiddingResult) adapterAPI7).biddingResult(true, price, this.c2sSecondPrice, this.c2sSecondAdvId);
                                    }
                                } else if (adSource2.is_cycle) {
                                    int randomInt3 = adSource2.bidfloor - RandomUtils.getRandomInt(20);
                                    int i12 = this.c2sSecondAdvId;
                                    if (randomInt3 < 0) {
                                        randomInt3 = 0;
                                        i12 = 0;
                                    }
                                    ((BiddingResult) adapterAPI7).biddingResult(true, adSource2.bidfloor, randomInt3, i12);
                                } else {
                                    int i13 = (int) (((double) price) * d);
                                    AdSource adSource8 = adapterAPI7.getAdSource();
                                    if (i13 < adSource8.price) {
                                        i13 = (int) ((((double) i13) * (adSource8.floating_value + 100.0d)) / 100.0d);
                                    }
                                    ((BiddingResult) adapterAPI7).biddingResult(false, i13, this.c2sSecondPrice, adSource2.adv_id);
                                }
                            }
                        }
                    }
                }
                if (!this.isCacheMode && (adapterAPI = this.adViewAdapter) != null) {
                    this.mAdapterGenerator.reportFullAd(adapterAPI.getAdSource());
                }
                biddingReq(adSource2);
                return;
            }
            str = "已经执行过填充回调";
        }
        LogcatUtil.d("YdSDK-Manager", str);
    }

    private void checkCycleAd(int i) {
        if (checkOpenCycle() && (this.adViewAdapter instanceof MixNativeCycleDataListener)) {
            HashMap map = new HashMap();
            map.putAll(this.successAds);
            Iterator<Integer> it = this.adStatus.keySet().iterator();
            while (it.hasNext()) {
                WaterfallHierarchyController waterfallHierarchyController = this.adStatus.get(Integer.valueOf(it.next().intValue()));
                if (waterfallHierarchyController.isHasAd()) {
                    map.putAll(waterfallHierarchyController.successAds);
                }
            }
            map.putAll(this.c2sSuccessAds);
            if (map.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new Comparator() { // from class: com.zj.adlib.ux
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AdViewManager.lambda$checkCycleAd$1((AdSource) obj, (AdSource) obj2);
                }
            });
            AdPlace adPlace = this.originalAdPlace;
            if (adPlace != null) {
                int i2 = adPlace.lbsx - 1;
                int i3 = i - adPlace.highest_bid_difference;
                ArrayList arrayList2 = new ArrayList();
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    AdSource adSource = (AdSource) arrayList.get(i4);
                    if (this.adViewAdapter.getAdSource() != adSource && adSource.getAdvPrice() >= i3) {
                        AdapterAPI adapterAPI = (AdapterAPI) map.get(adSource);
                        if (adapterAPI instanceof MixNativeCycleDataListener) {
                            if (adSource.is_black == 1) {
                                arrayList2.add(0, ((MixNativeCycleDataListener) adapterAPI).getCycleNativeAd());
                            } else {
                                arrayList2.add(((MixNativeCycleDataListener) adapterAPI).getCycleNativeAd());
                            }
                            adapterAPI.getAdSource().is_cycle = true;
                            if (adapterAPI.getAdSource().getAdCacheBean() != null) {
                                AdCacheRepository.getInstance().deleteAdCache(adapterAPI.getAdSource().getAdCacheBean().getId());
                            }
                            if (arrayList2.size() >= i2) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                ((MixNativeCycleDataListener) this.adViewAdapter).setCycleNativeAd(arrayList2, this.originalAdPlace.lbjg);
            }
        }
    }

    private boolean checkOpenCycle() {
        AdPlace adPlace;
        return this.adType == 10 && (adPlace = this.originalAdPlace) != null && adPlace.isOpenCycle();
    }

    private boolean checkOpenInterstitialRefresh() {
        AdPlace adPlace;
        return this.adType == 3 && (adPlace = this.originalAdPlace) != null && adPlace.verify_ad_refresh == 1;
    }

    private void checkRefreshInterstitialAd() {
        AdapterAPI adapterAPI;
        if (!checkOpenInterstitialRefresh() || (adapterAPI = this.adViewAdapter) == null) {
            return;
        }
        int i = adapterAPI.getAdSource().is_black;
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        AdapterAPI adapterAPI2 = null;
        if (i == 1) {
            for (AdSource adSource : this.successAds.keySet()) {
                if (adSource.is_black != 1 && this.adViewAdapter.getAdSource() != adSource) {
                    double d2 = adSource.bidfloor;
                    if (d2 > d) {
                        adapterAPI2 = this.successAds.get(adSource);
                        d = d2;
                    }
                }
            }
            for (AdSource adSource2 : this.c2sSuccessAds.keySet()) {
                if (adSource2.is_black != 1 && this.adViewAdapter.getAdSource() != adSource2) {
                    double d3 = adSource2.bidfloor;
                    if (d3 > d) {
                        adapterAPI2 = this.c2sSuccessAds.get(adSource2);
                        d = d3;
                    }
                }
            }
        } else {
            for (AdSource adSource3 : this.successAds.keySet()) {
                if (adSource3.is_black == 1 && this.adViewAdapter.getAdSource() != adSource3) {
                    double d4 = adSource3.bidfloor;
                    if (d4 > d) {
                        adapterAPI2 = this.successAds.get(adSource3);
                        d = d4;
                    }
                }
            }
            for (AdSource adSource4 : this.c2sSuccessAds.keySet()) {
                if (adSource4.is_black == 1 && this.adViewAdapter.getAdSource() != adSource4) {
                    double d5 = adSource4.bidfloor;
                    if (d5 > d) {
                        adapterAPI2 = this.c2sSuccessAds.get(adSource4);
                        d = d5;
                    }
                }
            }
        }
        if (adapterAPI2 != null) {
            AdCacheManager.getInstance().setInterstitialAdapter(adapterAPI2, this.adViewAdapter.getAdSource().getPrice(), this.c2sSecondPrice, this.adViewAdapter.getAdSource().adv_id);
            adapterAPI2.getAdSource().is_cycle = true;
            adapterAPI2.getAdSource();
            if (adapterAPI2.getAdSource().getAdCacheBean() != null) {
                AdCacheRepository.getInstance().deleteAdCache(adapterAPI2.getAdSource().getAdCacheBean().getId());
            }
        }
    }

    private void checkWaterFallData() {
        int advPrice;
        List<AdSource> list;
        if (this.oldStrategy || this.haveStartWaterFall) {
            return;
        }
        if (this.originalAdPlace != null) {
            Map<AdSource, AdapterAPI> map = this.c2sSuccessAds;
            if (map == null || map.isEmpty()) {
                advPrice = -1;
            } else {
                advPrice = -1;
                for (AdSource adSource : this.c2sSuccessAds.keySet()) {
                    if (advPrice == -1 || adSource.getAdvPrice() > advPrice) {
                        advPrice = adSource.getAdvPrice();
                    }
                }
            }
            Map<AdSource, AdapterAPI> map2 = this.successAds;
            if (map2 != null && !map2.isEmpty()) {
                for (AdSource adSource2 : this.successAds.keySet()) {
                    if (advPrice == -1 || adSource2.getAdvPrice() > advPrice) {
                        advPrice = adSource2.getAdvPrice();
                    }
                }
            }
            if (advPrice > 0 && (list = this.originalAdPlace.ad_sources) != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AdSource adSource3 : this.originalAdPlace.ad_sources) {
                    if (adSource3.getAdvPrice() > advPrice) {
                        arrayList.add(adSource3);
                    }
                }
                this.originalAdPlace.ad_sources = arrayList;
            }
            List<AdSource> list2 = this.originalAdPlace.ad_sources;
            if (list2 != null && !list2.isEmpty()) {
                startRequestWaterFall();
                if (this.timeHandle != null) {
                    Message message = new Message();
                    message.what = 0;
                    message.arg1 = this.nowNum;
                    this.timeHandle.sendMessageDelayed(message, this.originalAdPlace.timeout);
                    Message message2 = new Message();
                    message2.what = 5;
                    message2.arg1 = this.nowNum;
                    this.timeHandle.sendMessageDelayed(message2, this.originalAdPlace.requestInterval);
                    return;
                }
                return;
            }
        }
        this.isWaterfallDone = true;
        selectAdShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeBottomAd() {
        getPreLoadAdPlace();
        if (this.isBottomAdDone) {
            if (this.bottomSuccessAds.size() <= 0) {
                this.mAdapterGenerator.onLoadFailed(new YdError(20401, "bottom ad list is null"));
                return;
            }
        } else if (this.bottomSuccessAds.size() <= 0) {
            return;
        }
        showBottomAd();
    }

    private void getAdxCache(AdPlace adPlace) {
        AdCacheBean cacheAdContent;
        if (this.isPreloadMode || ConfigHelper.getInstance().getCacheSwitch() != 1 || (cacheAdContent = AdCacheRepository.getInstance().getCacheAdContent(this.cacheKey)) == null) {
            return;
        }
        AdSource adSource = new AdSource();
        adSource.tagid = this.key;
        adSource.isApiBidAd = true;
        adSource.group_id = adPlace.group_id;
        adSource.test_id = adPlace.test_id;
        adSource.place_id = adPlace.place_id;
        adSource.req_id = adPlace.req_id;
        adSource.track_id = adPlace.track_id;
        adSource.setAdCacheBean(cacheAdContent);
        requestAdBySource(adSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPreLoadAdPlace() {
        if (this.hasLoadCacheAd) {
            return;
        }
        this.hasLoadCacheAd = true;
        PreloadHelper.getInstance().requestPreloadAd();
        if (this.isNeedRequestPreloadAdPlace) {
            this.isNeedRequestPreloadAdPlace = false;
            AdCacheManager.getInstance().loadCacheAd(this.adType);
        }
    }

    private void init() {
        this.nowNum = 0;
        this.isSetTop = false;
        this.isWaterfallDone = false;
        this.isCallback = false;
        this.successAds.clear();
        this.allSuccessAds.clear();
        this.bottomSuccessAds.clear();
        this.c2sFailAds.clear();
        this.c2sSuccessAds.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callBackLoadAd$0() {
        Optional.ofNullable(this.adViewAdapter).ifPresent(new Consumer() { // from class: com.zj.adlib.tx
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdapterAPI) obj).showAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$checkCycleAd$1(AdSource adSource, AdSource adSource2) {
        return Integer.compare(adSource2.getPrice(), adSource.getPrice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$setCacheAd$2(AdSource adSource, AdSource adSource2) {
        return Integer.compare(adSource2.getPrice(), adSource.getPrice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReportMsg() {
        LogcatUtil.d("YdSDK-Manager", "mergeReportMessagelistResponseInfo:" + this.listResponseInfo.size() + "listRequestInfo:" + this.listRequestInfo.size());
        if (this.originalAdPlace != null) {
            long bootTime = DeviceUtil.getBootTime() - this.reqTime;
            ReportHelper reportHelper = ReportHelper.getInstance();
            AdPlace adPlace = this.originalAdPlace;
            reportHelper.reportFillFail(adPlace.req_id, adPlace.place_id, adPlace.group_id, adPlace.test_id, this.errInfos, adPlace.track_id, bootTime);
            this.errInfos.clear();
        }
        ReportHelper.getInstance().reportResponseList(this.listResponseInfo, this.originalAdPlace);
        this.listResponseInfo.clear();
        ReportHelper.getInstance().reportRequestList(this.listRequestInfo, this.originalAdPlace);
        this.listRequestInfo.clear();
    }

    private void reqAPIBid(AdPlace adPlace) {
        boolean z = adPlace.has_api_bid;
        this.has_api_bid = z;
        if (z) {
            this.adSaasPlace = adPlace;
            AdSource adSource = new AdSource();
            adSource.tagid = this.key;
            adSource.isApiBidAd = true;
            adSource.group_id = adPlace.group_id;
            adSource.test_id = adPlace.test_id;
            adSource.place_id = adPlace.place_id;
            adSource.req_id = adPlace.req_id;
            adSource.track_id = adPlace.track_id;
            adSource.is_need_header = adPlace.is_need_header;
            requestAdBySource(adSource);
            Handler handler = this.timeHandle;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(7, this.adSaasPlace.api_timeout);
            }
        }
    }

    private void requestAdBySource(AdSource adSource) {
        AdPlace adPlace = this.originalAdPlace;
        if (adPlace != null && adSource != null) {
            adSource.post_click_strategy = adPlace.post_click_strategy;
            adSource.bdt = adPlace.bdt;
            adSource.group_id = adPlace.group_id;
            adSource.test_id = adPlace.test_id;
            adSource.is_contrast = adPlace.is_contrast;
            adSource.isHot = adPlace.isHot;
        }
        this.mAdapterGenerator.requestAd(adSource);
    }

    private void requestBottomAd(List<AdSource> list) {
        LogcatUtil.d("YdSDK-Manager", "requestBottomAd");
        for (AdSource adSource : list) {
            adSource.isBottomAd = true;
            adSource.sumNum = list.size();
            requestAdBySource(adSource);
        }
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(2, this.adSaasPlace.timeout);
        }
    }

    private void resetData() {
        this.isWaterfallDone = false;
        this.isCallback = false;
        this.isLastHierarchy = false;
        this.isBottomAdDone = false;
        this.isShowBottomAd = false;
        this.isBottomAdCallback = false;
        this.has_c2s_bid = false;
        this.isC2SAdDone = false;
        this.has_api_bid = false;
        this.apiBidRetrun = false;
        this.has_sdk_bid = false;
        this.sdkBidRetrun = false;
        this.isOnlySdkBid = false;
        this.has_bottom_ad = false;
        this.isSetTop = false;
        this.isCacheMode = false;
        this.isPreloadMode = false;
        this.isSelectBottomAdapter = false;
        this.isNeedRequestPreloadAdPlace = false;
        this.hasLoadCacheAd = false;
        this.hasCallBackLoadAd = false;
        this.cachePrice = 0;
        this.c2sBidFailNum = 0;
        this.c2sBidFinishNum = 0;
        this.bottomFailNum = 0;
        this.bottomFinishNum = 0;
        this.nowNum = 0;
        this.sumHierarchyNum = 0;
        this.c2sSecondPrice = 0;
        this.currentPriceFloor = 0;
        this.waterfallFlowStop = -1;
        this.successAds.clear();
        this.allSuccessAds.clear();
        this.bottomSuccessAds.clear();
        this.c2sSuccessAds.clear();
        this.c2sFailAds.clear();
        this.adStatus.clear();
        this.c2sResultAds.clear();
        this.errInfos.clear();
        this.listResponseInfo.clear();
        this.listRequestInfo.clear();
        Handler handler = this.timeHandle;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    private void setCacheAd(AdSource adSource) {
        AdapterAPI adapterAPI;
        int i;
        ArrayList<Integer> arrayList;
        try {
            this.allSuccessAds.putAll(this.successAds);
            Iterator<Integer> it = this.adStatus.keySet().iterator();
            while (it.hasNext()) {
                WaterfallHierarchyController waterfallHierarchyController = this.adStatus.get(Integer.valueOf(it.next().intValue()));
                if (waterfallHierarchyController.isHasAd()) {
                    this.allSuccessAds.putAll(waterfallHierarchyController.successAds);
                }
            }
            this.allSuccessAds.putAll(this.c2sSuccessAds);
            LogcatUtil.d("YdSDK-Cache", "本次请求成功的广告数量:" + this.allSuccessAds.size());
            Iterator<AdSource> it2 = this.allSuccessAds.keySet().iterator();
            while (true) {
                boolean z = false;
                if (!it2.hasNext()) {
                    break;
                }
                AdSource next = it2.next();
                if (next.is_cycle || next == adSource) {
                    this.allSuccessAds.remove(next);
                } else if (next.isSDKBidAd) {
                    AdPlace adPlace = this.originalAdPlace;
                    if (adPlace != null && (arrayList = adPlace.advCacheabledList) != null && arrayList.size() > 0) {
                        Iterator<Integer> it3 = this.originalAdPlace.advCacheabledList.iterator();
                        do {
                            if (!it3.hasNext()) {
                                z = true;
                                break;
                            }
                        } while (next.adv_id != it3.next().intValue());
                        if (!z) {
                            LogcatUtil.d("YdSDK-Cache", "匹配到服务端配置，不移除竞价广告:" + next.adv_id);
                        }
                    }
                    this.allSuccessAds.remove(next);
                }
            }
            LogcatUtil.d("YdSDK-Cache", "可用于缓存的广告数量:" + this.allSuccessAds.size());
            if (!this.allSuccessAds.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(this.allSuccessAds.keySet());
                Collections.sort(arrayList2, new Comparator() { // from class: com.zj.adlib.rx
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AdViewManager.lambda$setCacheAd$2((AdSource) obj, (AdSource) obj2);
                    }
                });
                AdPlace adPlace2 = this.originalAdPlace;
                int i2 = adPlace2 != null ? adPlace2.cache_queue_length : 1;
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < Math.min(arrayList2.size(), i2); i3++) {
                    AdSource adSource2 = (AdSource) arrayList2.get(i3);
                    if ((!adSource2.isApiBidAd || ConfigHelper.getInstance().getCacheSwitch() != 1) && (adapterAPI = this.allSuccessAds.get(adSource2)) != null) {
                        if (adSource2.isC2SBidAd && (i = adSource2.price) > 0) {
                            adSource2.bidfloor = i;
                        }
                        LogcatUtil.d("YdSDK-Cache", "保存缓存广告:" + adapterAPI.getAdSource());
                        adapterAPI.getAdSource().c2sSecondPrice = this.c2sSecondPrice;
                        adapterAPI.getAdSource().c2sSecondAdvId = this.c2sSecondAdvId;
                        adapterAPI.getAdSource().isPopCacheAd = false;
                        arrayList3.add(adapterAPI);
                    }
                }
                AdCacheManager.CacheType cacheType = AdCacheManager.CacheType.PLACE_CACHE;
                if (this.isPreloadMode || AdCacheManager.getInstance().isGlobalCache(this.adType)) {
                    cacheType = AdCacheManager.CacheType.SHARE_CACHE;
                }
                AdCacheManager.CacheType cacheType2 = cacheType;
                AdapterGenerator adapterGenerator = this.mAdapterGenerator;
                AdPlace adPlace3 = this.originalAdPlace;
                adapterGenerator.pushCacheAdapter(cacheType2, adPlace3.place_id, adPlace3.cacheValidTime, arrayList3);
            }
            if (this.isPreloadMode) {
                destroy();
            }
        } catch (Exception e) {
            LogcatUtil.d("YdSDK-Cache", "存放缓存异常" + e.getMessage());
        }
    }

    private void setCurrentPriceFloor(int i) {
        int i2 = this.currentPriceFloor;
        if (i2 > 0 && i2 <= i) {
            return;
        }
        this.currentPriceFloor = i;
    }

    private void setDataToAdSource(AdapterAPI adapterAPI) {
        if (adapterAPI == null || this.originalAdPlace == null) {
            return;
        }
        adapterAPI.getAdSource().refresh = this.originalAdPlace.refresh;
        adapterAPI.getAdSource().refresh_time = this.originalAdPlace.refresh_time;
    }

    private void showBottomAd() {
        AdapterGenerator adapterGenerator;
        YdError ydError;
        if (this.isBottomAdCallback) {
            LogcatUtil.d("YdSDK-Manager", "showBottomAd 2");
            return;
        }
        this.isBottomAdCallback = true;
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.removeMessages(2);
            this.timeHandle.removeMessages(1);
        }
        ArrayList<AdSource> arrayList = new ArrayList();
        int i = -1;
        for (AdSource adSource : this.bottomSuccessAds.keySet()) {
            if (i == -1) {
                i = adSource.bidfloor;
            } else {
                int i2 = adSource.bidfloor;
                if (i == i2) {
                    if (adSource.isApiBidAd) {
                        arrayList.add(0, adSource);
                    }
                } else if (i2 > i) {
                    arrayList.clear();
                    arrayList.add(adSource);
                    i = i2;
                }
            }
            arrayList.add(adSource);
        }
        LogcatUtil.d("YdSDK-Manager", "Bottom Ads广告数量:" + arrayList.size());
        if (arrayList.size() == 1) {
            this.adViewAdapter = this.bottomSuccessAds.get(arrayList.get(0));
            callBackLoadAd((AdSource) arrayList.get(0));
            return;
        }
        if (arrayList.size() > 1) {
            int i3 = 10000;
            AdSource adSource2 = null;
            for (AdSource adSource3 : arrayList) {
                int i4 = adSource3.sequence;
                if (i3 > i4) {
                    adSource2 = adSource3;
                    i3 = i4;
                }
            }
            if (adSource2 != null) {
                this.adViewAdapter = this.bottomSuccessAds.get(adSource2);
                callBackLoadAd(adSource2);
                return;
            } else {
                adapterGenerator = this.mAdapterGenerator;
                ydError = new YdError(20401, "No available ads found in bottom ad");
            }
        } else {
            adapterGenerator = this.mAdapterGenerator;
            ydError = new YdError(20401, "bottom ad list is null");
        }
        adapterGenerator.onLoadFailed(ydError);
    }

    private void startRequestWaterFall() {
        AdPlace adPlace;
        List<AdSource> list;
        AdPlace adPlace2 = this.originalAdPlace;
        if (adPlace2 == null) {
            this.isWaterfallDone = true;
            return;
        }
        this.haveStartWaterFall = true;
        List<AdSource> ration = getRation(adPlace2);
        WaterfallHierarchyController waterfallHierarchyController = new WaterfallHierarchyController();
        waterfallHierarchyController.hierarchy = this.nowNum;
        waterfallHierarchyController.adNum = ration.size();
        this.adStatus.put(Integer.valueOf(this.nowNum), waterfallHierarchyController);
        for (AdSource adSource : ration) {
            adSource.adHierarchy = this.nowNum;
            requestAdBySource(adSource);
        }
        if (!this.isLastHierarchy || (adPlace = this.adSaasPlace) == null || (list = adPlace.bottom_ad_sources) == null || list.isEmpty()) {
            return;
        }
        this.has_bottom_ad = true;
        requestBottomAd(this.originalAdPlace.bottom_ad_sources);
    }

    private void testSaveShowAdMsg() {
        if (this.adViewAdapter != null) {
            ConfigHelper.getInstance().adSource = this.adViewAdapter.getAdSource();
        }
    }

    private void updateCacheMessage(AdapterAPI adapterAPI, String str) {
        if (adapterAPI != null) {
            AdSource adSource = adapterAPI.getAdSource();
            adSource.global_group_id = adSource.group_id;
            adSource.global_place_id = adSource.place_id;
            adSource.global_test_id = adSource.test_id;
            adSource.track_id = str;
            AdPlace adPlace = this.originalAdPlace;
            if (adPlace != null) {
                adSource.group_id = adPlace.group_id;
                adSource.place_id = adPlace.place_id;
                adSource.test_id = adPlace.test_id;
            }
            if (adapterAPI instanceof AdChangeCacheData) {
                ((AdChangeCacheData) adapterAPI).setCacheData(str, adSource);
            }
        }
    }

    private void updateImpressFreq() {
        if (this.originalAdPlace == null) {
            return;
        }
        LogcatUtil.d("YdSDK-Manager", "updateImpressFreq");
        String str = this.originalAdPlace.place_id;
        String str2 = str + "lastShowDay";
        String str3 = str + "lastDayShowNumber";
        String str4 = str + "lastShowHour";
        String str5 = str + "lastHourShowNumber";
        String str6 = str + "lastShowSec";
        String str7 = str + "impressFreqDay";
        String str8 = str + "impressFreqHour";
        String str9 = str + "impressFreqInterval";
        String string = SPUtil.getInstance().getString(str2);
        int i = SPUtil.getInstance().getInt(str3);
        long j = SPUtil.getInstance().getLong(str4);
        int i2 = SPUtil.getInstance().getInt(str5);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String date = DeviceUtil.getDate();
        SPUtil.getInstance().putLong(str6, jCurrentTimeMillis);
        if (jCurrentTimeMillis - j > 3600) {
            SPUtil.getInstance().putLong(str4, jCurrentTimeMillis);
            SPUtil.getInstance().putInt(str5, 1);
        } else {
            SPUtil.getInstance().putInt(str5, i2 + 1);
        }
        if (date.equals(string)) {
            SPUtil.getInstance().putInt(str3, i + 1);
        } else {
            SPUtil.getInstance().putString(str2, date);
            SPUtil.getInstance().putInt(str3, 1);
        }
        SPUtil.getInstance().putInt(str7, this.originalAdPlace.impress_freq_day);
        SPUtil.getInstance().putInt(str8, this.originalAdPlace.impress_freq_hour);
        SPUtil.getInstance().putInt(str9, this.originalAdPlace.impress_interval);
    }

    private boolean usePublic() {
        AdPlace adPlace = this.originalAdPlace;
        return adPlace != null && adPlace.rela_public_adplace == 1 && adPlace.use_public_adplace == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waterfallFlowDone() {
        PreloadDoneCallback preloadDoneCallback;
        if (this.has_api_bid || this.has_sdk_bid || this.has_c2s_bid) {
            this.isWaterfallDone = true;
            selectAdShow();
            return;
        }
        if (this.has_bottom_ad) {
            this.isShowBottomAd = true;
            disposeBottomAd();
            return;
        }
        LogcatUtil.d("YdSDK-Manager", "ad no fill");
        Handler handler = this.timeHandle;
        if (handler != null) {
            handler.removeMessages(0);
            this.timeHandle.removeMessages(1);
        }
        if (this.isPreloadMode && (preloadDoneCallback = this.preloadDoneCallback) != null) {
            preloadDoneCallback.preloadDone();
        }
        this.mAdapterGenerator.onLoadFailed(new YdError(20401, "ad no fill"));
        getPreLoadAdPlace();
        mergeReportMsg();
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        AdapterAPI adapterAPI = this.adViewAdapter;
        if (adapterAPI == null || !(adapterAPI instanceof BiddingResult)) {
            return;
        }
        ((BiddingResult) adapterAPI).biddingResult(z, i, i2, 0);
    }

    public int c2sBidResult() {
        if (this.has_c2s_bid && this.c2sSuccessAds.size() > 0) {
            int bidPriceTemp = -1;
            for (AdSource adSource : this.c2sSuccessAds.keySet()) {
                if (!checkOpenCycle() || adSource.is_black != 1) {
                    if (bidPriceTemp == -1) {
                        bidPriceTemp = adSource.getBidPriceTemp();
                    } else if (bidPriceTemp != adSource.getBidPriceTemp()) {
                        if (adSource.getBidPriceTemp() > bidPriceTemp) {
                            this.c2sSecondPrice = bidPriceTemp;
                            this.c2sSecondAdvId = adSource.adv_id;
                            bidPriceTemp = adSource.getBidPriceTemp();
                            this.c2sResultAds.clear();
                        }
                    }
                    this.c2sResultAds.add(adSource);
                }
            }
            if (this.c2sResultAds.size() > 0) {
                return this.c2sResultAds.get(0).getBidPriceTemp();
            }
        }
        return -1;
    }

    public boolean changeReRequestCount() {
        int i = this.needReRequestCount;
        if (i <= 0) {
            this.needReRequestCount = 0;
            this.isReRequest = false;
            return false;
        }
        this.needReRequestCount = i - 1;
        resetData();
        this.isReRequest = true;
        return true;
    }

    public synchronized void cyclicQueryController(int i) {
        int i2;
        LogcatUtil.d("YdSDK-Manager", "cyclicQueryController:" + i);
        for (int i3 = 0; i3 <= i; i3++) {
            WaterfallHierarchyController waterfallHierarchyController = this.adStatus.get(Integer.valueOf(i3));
            if (waterfallHierarchyController == null || !waterfallHierarchyController.isDone()) {
                break;
                break;
            }
            if (waterfallHierarchyController.isDone() && waterfallHierarchyController.isHasAd()) {
                LogcatUtil.d("YdSDK-Manager", "轮询到第" + i3 + "层广告完成");
                this.isWaterfallDone = true;
                this.successAds.putAll(waterfallHierarchyController.successAds);
                selectAdShow();
                break;
            }
            if (i3 == i && (i2 = this.waterfallFlowStop) != -1 && i2 == i) {
                LogcatUtil.d("YdSDK-Manager", "轮询到第" + i3 + "层广告,瀑布流有高价填充");
                this.isWaterfallDone = true;
                selectAdShow();
            }
            if (this.sumHierarchyNum == 1) {
                this.isWaterfallDone = true;
                selectAdShow();
            }
            if (this.sumHierarchyNum - 1 == i) {
                this.isWaterfallDone = true;
                selectAdShow();
            }
        }
    }

    public void destroy() {
        try {
            Iterator<Map.Entry<AdSource, AdapterAPI>> it = this.successAds.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
            Iterator<Map.Entry<AdSource, AdapterAPI>> it2 = this.c2sSuccessAds.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().destroy();
            }
            Iterator<Map.Entry<AdSource, AdapterAPI>> it3 = this.bottomSuccessAds.entrySet().iterator();
            while (it3.hasNext()) {
                it3.next().getValue().destroy();
            }
            Handler handler = this.timeHandle;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.timeHandle = null;
            }
            mergeReportMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdPlace getOriginalAdPlace() {
        return this.originalAdPlace;
    }

    public synchronized List<AdSource> getRation(AdPlace adPlace) {
        try {
            if (adPlace == null) {
                return new ArrayList();
            }
            if (adPlace.ad_sources.size() <= adPlace.request_num) {
                this.isLastHierarchy = true;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < adPlace.ad_sources.size(); i++) {
                    if (i == 0 && !this.isSetTop) {
                        adPlace.ad_sources.get(i).isTop = true;
                        this.isSetTop = true;
                    }
                    adPlace.ad_sources.get(i).sumNum = adPlace.ad_sources.size();
                    setCurrentPriceFloor(adPlace.ad_sources.get(i).bidfloor);
                    arrayList.add(adPlace.ad_sources.get(i));
                }
                adPlace.ad_sources.clear();
                this.adSaasPlace = adPlace;
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < adPlace.request_num; i2++) {
                if (i2 == 0 && !this.isSetTop) {
                    adPlace.ad_sources.get(i2).isTop = true;
                    this.isSetTop = true;
                }
                setCurrentPriceFloor(adPlace.ad_sources.get(0).bidfloor);
                adPlace.ad_sources.get(0).sumNum = adPlace.request_num;
                arrayList2.add(adPlace.ad_sources.get(0));
                adPlace.ad_sources.remove(0);
            }
            this.adSaasPlace = adPlace;
            return arrayList2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public AdapterAPI getValidAdapter() {
        return this.adViewAdapter;
    }

    public void hasSdkBid() {
        this.has_sdk_bid = true;
    }

    public synchronized boolean isHasAdErrInfo(ErrorInfo errorInfo) {
        try {
            for (ErrorInfo errorInfo2 : this.errInfos) {
                if (errorInfo2.adv_id.equals(errorInfo.adv_id) && errorInfo2.tagid.equals(errorInfo.tagid)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isReRequest() {
        return this.isReRequest;
    }

    public synchronized void nextRequestSdkAd() {
        boolean z;
        AdPlace adPlace;
        List<AdSource> list;
        LogcatUtil.d("YdSDK-Manager", "nextRequestSdkAd，下一层开始请求");
        boolean z2 = this.has_c2s_bid;
        boolean z3 = !z2 || (z2 && this.isC2SAdDone);
        boolean z4 = this.has_sdk_bid;
        boolean z5 = !z4 || (z4 && this.sdkBidRetrun);
        boolean z6 = this.has_api_bid;
        boolean z7 = !z6 || (z6 && this.apiBidRetrun);
        if (this.currentPriceFloor > 0 && z3 && z5 && z7) {
            if (this.c2sSuccessAds.size() <= 0) {
                z = false;
                break;
            }
            Iterator<AdSource> it = this.c2sSuccessAds.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().price >= this.currentPriceFloor) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (this.successAds.size() > 0) {
                Iterator<AdSource> it2 = this.successAds.keySet().iterator();
                while (it2.hasNext()) {
                    if (it2.next().price >= this.currentPriceFloor) {
                        z = true;
                        break;
                    }
                }
            }
        } else {
            z = false;
        }
        if (z) {
            LogcatUtil.d("YdSDK-Manager", "有高价格广告填充,瀑布流停止请求");
            int i = this.nowNum;
            this.waterfallFlowStop = i;
            cyclicQueryController(i);
            return;
        }
        this.nowNum++;
        List<AdSource> ration = getRation(this.adSaasPlace);
        if (ration != null && ration.size() > 0) {
            WaterfallHierarchyController waterfallHierarchyController = new WaterfallHierarchyController();
            waterfallHierarchyController.hierarchy = this.nowNum;
            waterfallHierarchyController.adNum = ration.size();
            this.adStatus.put(Integer.valueOf(this.nowNum), waterfallHierarchyController);
            for (AdSource adSource : ration) {
                adSource.adHierarchy = this.nowNum;
                requestAdBySource(adSource);
            }
            if (this.isLastHierarchy && (adPlace = this.adSaasPlace) != null && (list = adPlace.bottom_ad_sources) != null && list.size() > 0) {
                this.has_bottom_ad = true;
                requestBottomAd(this.adSaasPlace.bottom_ad_sources);
            }
            if (this.timeHandle != null) {
                Message message = new Message();
                message.what = 0;
                message.arg1 = this.nowNum;
                this.timeHandle.sendMessageDelayed(message, this.adSaasPlace.timeout);
                Message message2 = new Message();
                message2.arg1 = this.nowNum;
                message2.what = 5;
                this.timeHandle.sendMessageDelayed(message2, this.adSaasPlace.requestInterval);
            }
        }
    }

    public void onAdFailed(YdError ydError) {
        this.mAdapterGenerator.onLoadFailed(ydError);
    }

    public void onSDKBidFailed(YdError ydError) {
        LogcatUtil.d("YdSDK-Manager", "reqSDKBid onFailed:" + ydError);
        if (this.isOnlySdkBid) {
            this.isShowBottomAd = true;
        }
        this.sdkBidRetrun = true;
        this.has_sdk_bid = false;
        selectAdShow();
        if (this.isWaterfallDone && this.isOnlySdkBid) {
            this.mAdapterGenerator.onLoadFailed(ydError);
            getPreLoadAdPlace();
        }
    }

    public void preloadSdkAd(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        this.isPreloadMode = true;
        this.preloadDoneCallback = preloadDoneCallback;
        requestSdkAd(adPlace);
    }

    public void removeMessages(int i) {
        Handler handler = this.timeHandle;
        if (handler == null) {
            return;
        }
        handler.removeMessages(i);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00f6  */
    public void requestSdkAd(AdPlace adPlace) {
        Handler handler;
        AdPlace adPlace2;
        List<AdSource> list;
        AdapterAPI adapterAPIPopCacheAdapter;
        AdapterAPI adapterAPIPopCacheAdapter2;
        String str;
        try {
            this.cacheKey = adPlace.place_id + adPlace.group_id + adPlace.test_id;
            boolean zIsGlobalCache = AdCacheManager.getInstance().isGlobalCache(this.adType);
            Handler handler2 = this.timeHandle;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(8, 30000L);
            }
            this.reqTime = DeviceUtil.getBootTime();
            init();
            this.originalAdPlace = adPlace;
            boolean z = false;
            this.oldStrategy = adPlace.request_logic == 0;
            if (this.refreshRequestCount) {
                this.refreshRequestCount = false;
                this.needReRequestCount = adPlace.refresh_num;
            }
            if (this.needReRequestCount > 0) {
                adPlace.isOpenCache = true;
                adPlace.enhanceTarget = 2;
            }
            int size = adPlace.ad_sources.size();
            int i = adPlace.request_num;
            this.sumHierarchyNum = size % i == 0 ? (size - (size % i)) / i : ((size - (size % i)) / i) + 1;
            String str2 = "2";
            if (!this.isPreloadMode && adPlace.isCachedSpeedFirst()) {
                if (zIsGlobalCache) {
                    adapterAPIPopCacheAdapter2 = this.mAdapterGenerator.popCacheAdapter(AdCacheManager.CacheType.SHARE_CACHE, adPlace.place_id, adPlace.cacheValidTime);
                    AdCacheManager.getInstance().loadCacheAd(this.adType);
                    str = "2";
                } else {
                    adapterAPIPopCacheAdapter2 = adPlace.isOpenPlaceCache() ? this.mAdapterGenerator.popCacheAdapter(AdCacheManager.CacheType.PLACE_CACHE, adPlace.place_id, adPlace.cacheValidTime) : null;
                    if (AdCacheManager.getInstance().isHasPublicCache(this.adType) && usePublic()) {
                        AdapterAPI adapterAPIPopCacheAdapter3 = this.mAdapterGenerator.popCacheAdapter(AdCacheManager.CacheType.SHARE_CACHE, adPlace.place_id, adPlace.cacheValidTime);
                        AdCacheManager.getInstance().loadCacheAd(this.adType);
                        if (adapterAPIPopCacheAdapter2 != null && (adapterAPIPopCacheAdapter3 == null || adapterAPIPopCacheAdapter3.getAdSource().getAdvPrice() <= adapterAPIPopCacheAdapter2.getAdSource().getAdvPrice())) {
                            str = "0";
                        } else {
                            adapterAPIPopCacheAdapter2 = adapterAPIPopCacheAdapter3;
                            str = "1";
                        }
                    } else {
                        str = "0";
                    }
                }
                if (adapterAPIPopCacheAdapter2 != null) {
                    adapterAPIPopCacheAdapter2.getAdSource().adPool = str;
                    LogcatUtil.d("YdSDK-Cache", "开启缓存广告功能,且缓存有效,缓存模式:1");
                    if (this.mAdapterGenerator.isFailedCallBack()) {
                        LogcatUtil.d("YdSDK-Manager", "已经执行过失败回调,不进行填充");
                        return;
                    }
                    updateCacheMessage(adapterAPIPopCacheAdapter2, adPlace.track_id);
                    this.adViewAdapter = adapterAPIPopCacheAdapter2;
                    AdSource adSource = adapterAPIPopCacheAdapter2.getAdSource();
                    Function<Integer, Integer> priorityStrategy = adSource.getPriorityStrategy();
                    if (priorityStrategy != null) {
                        this.adViewAdapter.getAdSource().price = priorityStrategy.apply(Integer.valueOf(adSource.getPrice())).intValue();
                    }
                    LogcatUtil.d("YdSDK-Manager", "填充回调执行:" + adSource.adv_id);
                    this.mAdapterGenerator.reportFullAd(adSource);
                    this.isCacheMode = true;
                    testSaveShowAdMsg();
                    setDataToAdSource(this.adViewAdapter);
                    this.adViewAdapter.showAd();
                    updateImpressFreq();
                    LogcatUtil.d("YdSDK-Manager", "Ad show cache:" + adSource);
                    if ((adSource.isC2SBidAd || adSource.isApiBidAd) && (adapterAPIPopCacheAdapter2 instanceof BiddingResult)) {
                        LogcatUtil.d("YdSDK-Manager", "缓存模式1,竞价广告回传");
                        if (bidResultSelfReturn()) {
                            ((BiddingResult) adapterAPIPopCacheAdapter2).biddingResult(true, adSource.getPrice(), adSource.c2sSecondPrice, adSource.c2sSecondAdvId);
                        }
                    }
                }
            }
            if (!this.isPreloadMode && adPlace.isCachedECPMFirst()) {
                if (zIsGlobalCache || (AdCacheManager.getInstance().isHasPublicCache(this.adType) && usePublic())) {
                    AdapterAPI adapterAPIPopCacheAdapter4 = this.mAdapterGenerator.popCacheAdapter(AdCacheManager.CacheType.SHARE_CACHE, adPlace.place_id, this.originalAdPlace.cacheValidTime);
                    this.isNeedRequestPreloadAdPlace = true;
                    if (adapterAPIPopCacheAdapter4 != null) {
                        this.cachePrice = adapterAPIPopCacheAdapter4.getAdSource().getAdvPrice();
                        AdSource adSource2 = adapterAPIPopCacheAdapter4.getAdSource();
                        if (!zIsGlobalCache) {
                            str2 = "1";
                        }
                        adSource2.adPool = str2;
                        setSuccessAds(adapterAPIPopCacheAdapter4.getAdSource(), adapterAPIPopCacheAdapter4);
                    }
                }
                if (adPlace.isOpenPlaceCache() && (adapterAPIPopCacheAdapter = this.mAdapterGenerator.popCacheAdapter(AdCacheManager.CacheType.PLACE_CACHE, adPlace.place_id, this.originalAdPlace.cacheValidTime)) != null) {
                    int advPrice = adapterAPIPopCacheAdapter.getAdSource().getAdvPrice();
                    if (advPrice > this.cachePrice) {
                        this.cachePrice = advPrice;
                    }
                    adapterAPIPopCacheAdapter.getAdSource().adPool = "0";
                    setSuccessAds(adapterAPIPopCacheAdapter.getAdSource(), adapterAPIPopCacheAdapter);
                }
                if (this.cachePrice > 0 && (adPlace2 = this.originalAdPlace) != null && (list = adPlace2.ad_sources) != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (AdSource adSource3 : this.originalAdPlace.ad_sources) {
                        if (adSource3.getAdvPrice() > this.cachePrice) {
                            arrayList.add(adSource3);
                        }
                    }
                    this.originalAdPlace.ad_sources = arrayList;
                }
            }
            getAdxCache(adPlace);
            List<AdSource> list2 = adPlace.ad_sources;
            if (list2 == null || list2.isEmpty()) {
                this.isWaterfallDone = true;
                List<AdSource> list3 = adPlace.c2s_bid_ad_sources;
                if (list3 != null && list3.size() > 0) {
                    this.has_c2s_bid = true;
                    for (AdSource adSource4 : adPlace.c2s_bid_ad_sources) {
                        adSource4.isC2SBidAd = true;
                        adSource4.c2sSumNum = adPlace.c2s_bid_ad_sources.size();
                        requestAdBySource(adSource4);
                    }
                }
                List<AdSource> list4 = adPlace.bottom_ad_sources;
                if (list4 != null && list4.size() > 0) {
                    this.has_bottom_ad = true;
                    this.adSaasPlace = adPlace;
                    requestBottomAd(adPlace.bottom_ad_sources);
                }
                if (adPlace.isBidding()) {
                    this.adSaasPlace = adPlace;
                    if (!this.has_api_bid && !this.has_c2s_bid) {
                        z = true;
                    }
                    this.isOnlySdkBid = z;
                }
                reqAPIBid(adPlace);
                Handler handler3 = this.timeHandle;
                if (handler3 != null) {
                    if (this.has_c2s_bid) {
                        handler3.sendEmptyMessageDelayed(3, adPlace.client_timeout);
                    }
                    this.timeHandle.sendEmptyMessageDelayed(1, adPlace.all_time);
                }
                if (this.has_c2s_bid || this.has_bottom_ad || this.has_api_bid) {
                    return;
                }
                List<AdSource> list5 = adPlace.bid_ad_sources;
                if (list5 != null && list5.size() > 0) {
                    return;
                }
                Map<AdSource, AdapterAPI> map = this.successAds;
                if (map != null && !map.isEmpty()) {
                    selectAdShow();
                    return;
                } else {
                    getPreLoadAdPlace();
                    this.mAdapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.CONFIG_ERROR, "ad list is null"));
                }
            } else {
                reqAPIBid(adPlace);
                List<AdSource> list6 = adPlace.c2s_bid_ad_sources;
                if (list6 != null && list6.size() > 0) {
                    this.has_c2s_bid = true;
                    for (AdSource adSource5 : adPlace.c2s_bid_ad_sources) {
                        adSource5.isC2SBidAd = true;
                        adSource5.c2sSumNum = adPlace.c2s_bid_ad_sources.size();
                        requestAdBySource(adSource5);
                    }
                }
                if (this.oldStrategy) {
                    startRequestWaterFall();
                    if (this.timeHandle != null) {
                        Message message = new Message();
                        message.what = 0;
                        message.arg1 = this.nowNum;
                        this.timeHandle.sendMessageDelayed(message, adPlace.timeout);
                        Message message2 = new Message();
                        message2.what = 5;
                        message2.arg1 = this.nowNum;
                        this.timeHandle.sendMessageDelayed(message2, adPlace.requestInterval);
                        if (this.has_c2s_bid) {
                            this.timeHandle.sendEmptyMessageDelayed(3, adPlace.client_timeout);
                        }
                        handler = this.timeHandle;
                        handler.sendEmptyMessageDelayed(1, this.adSaasPlace.all_time);
                    }
                } else {
                    boolean z2 = this.has_c2s_bid;
                    if (z2 || this.has_api_bid) {
                        Handler handler4 = this.timeHandle;
                        if (handler4 != null) {
                            if (z2) {
                                handler4.sendEmptyMessageDelayed(3, adPlace.client_timeout);
                            }
                            handler = this.timeHandle;
                            handler.sendEmptyMessageDelayed(1, this.adSaasPlace.all_time);
                        }
                    } else {
                        this.oldStrategy = true;
                        startRequestWaterFall();
                        if (this.timeHandle != null) {
                            Message message3 = new Message();
                            message3.what = 0;
                            message3.arg1 = this.nowNum;
                            this.timeHandle.sendMessageDelayed(message3, adPlace.timeout);
                            Message message4 = new Message();
                            message4.what = 5;
                            message4.arg1 = this.nowNum;
                            this.timeHandle.sendMessageDelayed(message4, adPlace.requestInterval);
                            if (this.has_c2s_bid) {
                                this.timeHandle.sendEmptyMessageDelayed(3, adPlace.client_timeout);
                            }
                            handler = this.timeHandle;
                            handler.sendEmptyMessageDelayed(1, this.adSaasPlace.all_time);
                        }
                    }
                }
            }
            mergeReportMsg();
        } catch (Exception e) {
            e.printStackTrace();
            AdapterGenerator adapterGenerator = this.mAdapterGenerator;
            if (adapterGenerator != null) {
                adapterGenerator.onLoadFailed(new YdError(ErrorCodeConstant.CONFIG_ERROR, "ad list is null"));
            }
        }
    }

    public void retrunBottomResult() {
        AdPlace adPlace = this.adSaasPlace;
        if (adPlace != null && this.has_bottom_ad && this.bottomFailNum + this.bottomFinishNum == adPlace.bottom_ad_sources.size()) {
            LogcatUtil.d("YdSDK-Manager", "兜底广告全部返回结果," + this.isShowBottomAd);
            this.isBottomAdDone = true;
            if (this.isShowBottomAd) {
                disposeBottomAd();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:132:0x025a A[Catch: all -> 0x0262, Exception -> 0x0264, TryCatch #1 {Exception -> 0x0264, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x001b, B:13:0x001f, B:15:0x0023, B:18:0x002c, B:20:0x0030, B:22:0x0034, B:25:0x003d, B:27:0x0041, B:30:0x004d, B:32:0x0051, B:36:0x005b, B:38:0x0068, B:39:0x0076, B:40:0x0087, B:42:0x008d, B:44:0x0099, B:48:0x00a0, B:49:0x00a2, B:50:0x00a6, B:52:0x00aa, B:54:0x00ae, B:56:0x00b4, B:57:0x00bc, B:59:0x00e0, B:61:0x00ea, B:63:0x00f6, B:64:0x010a, B:65:0x011c, B:82:0x0177, B:130:0x0256, B:132:0x025a, B:134:0x025e, B:66:0x0121, B:67:0x0134, B:69:0x013b, B:70:0x0141, B:72:0x0147, B:76:0x0156, B:78:0x015a, B:80:0x015e, B:81:0x0164, B:83:0x017e, B:84:0x018d, B:129:0x0253, B:86:0x019a, B:89:0x01b7, B:91:0x01bb, B:94:0x01c2, B:96:0x01c8, B:97:0x01d5, B:99:0x01db, B:101:0x01e5, B:103:0x01e9, B:105:0x01ef, B:107:0x01f6, B:108:0x0202, B:109:0x020c, B:111:0x0212, B:113:0x021c, B:115:0x0220, B:117:0x0226, B:119:0x022d, B:121:0x023b, B:124:0x0242, B:126:0x0246, B:128:0x024a), top: B:144:0x0003, outer: #0 }] */
    public synchronized void selectAdShow() {
        AdapterGenerator adapterGenerator;
        YdError ydError;
        AdapterAPI adapterAPI;
        AdapterAPI adapterAPI2;
        List<AdSource> list;
        PreloadDoneCallback preloadDoneCallback;
        Object obj;
        try {
            LogcatUtil.d("YdSDK-Manager", "selectAdShow");
            if (this.has_c2s_bid && !this.isC2SAdDone) {
                LogcatUtil.d("YdSDK-Manager", "Wait for c2s bidding results");
                return;
            }
            if (this.has_sdk_bid && !this.sdkBidRetrun) {
                LogcatUtil.d("YdSDK-Manager", "Wait for s2s bidding results");
                return;
            }
            if (this.has_api_bid && !this.apiBidRetrun) {
                LogcatUtil.d("YdSDK-Manager", "Wait for api bidding results");
                return;
            }
            if (!this.isWaterfallDone) {
                LogcatUtil.d("YdSDK-Manager", "Wait for waterfall flow results");
                checkWaterFallData();
                return;
            }
            if (this.isCallback) {
                LogcatUtil.d("YdSDK-Manager", "It's already been called back");
                return;
            }
            this.isCallback = true;
            mergeReportMsg();
            getPreLoadAdPlace();
            Handler handler = this.timeHandle;
            if (handler != null) {
                handler.removeMessages(0);
                this.timeHandle.removeMessages(3);
                this.timeHandle.removeMessages(1);
            }
            ArrayList<AdSource> arrayList = new ArrayList();
            int i = -1;
            for (AdSource adSource : this.successAds.keySet()) {
                if (!checkOpenCycle() || adSource.is_black != 1) {
                    if (i == -1) {
                        i = adSource.bidfloor;
                    } else {
                        int i2 = adSource.bidfloor;
                        if (i == i2) {
                            if (adSource.isApiBidAd) {
                                arrayList.add(0, adSource);
                            }
                        } else if (i2 > i) {
                            arrayList.clear();
                            arrayList.add(adSource);
                            i = i2;
                        }
                    }
                    arrayList.add(adSource);
                }
            }
            LogcatUtil.d("YdSDK-Manager", "Ads广告数量:" + arrayList.size());
            int iC2sBidResult = c2sBidResult();
            if (arrayList.size() == 1) {
                if (((AdSource) arrayList.get(0)).bidfloor < iC2sBidResult) {
                    if (((AdSource) arrayList.get(0)).bidfloor > this.c2sSecondPrice) {
                        this.c2sSecondPrice = ((AdSource) arrayList.get(0)).bidfloor;
                        this.c2sSecondAdvId = ((AdSource) arrayList.get(0)).adv_id;
                    }
                    this.adViewAdapter = this.c2sSuccessAds.get(this.c2sResultAds.get(0));
                    list = this.c2sResultAds;
                } else {
                    this.adViewAdapter = this.successAds.get(arrayList.get(0));
                    obj = arrayList.get(0);
                }
                callBackLoadAd((AdSource) obj);
                if (this.isPreloadMode && (preloadDoneCallback = this.preloadDoneCallback) != null) {
                    preloadDoneCallback.preloadDone();
                }
            }
            AdapterAPI adapterAPI3 = null;
            AdSource adSource2 = null;
            if (arrayList.size() <= 1) {
                if (iC2sBidResult > 0) {
                    this.adViewAdapter = this.c2sSuccessAds.get(this.c2sResultAds.get(0));
                    callBackLoadAd(this.c2sResultAds.get(0));
                    return;
                }
                if (this.has_bottom_ad) {
                    this.isShowBottomAd = true;
                    disposeBottomAd();
                    return;
                }
                if (checkOpenCycle()) {
                    double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                    AdSource adSource3 = null;
                    for (AdSource adSource4 : this.successAds.keySet()) {
                        if (adSource4.is_black == 1 && ((adapterAPI2 = this.adViewAdapter) == null || adapterAPI2.getAdSource() != adSource4)) {
                            double d2 = adSource4.bidfloor;
                            if (d2 > d) {
                                adapterAPI3 = this.successAds.get(adSource4);
                                adSource3 = adSource4;
                                d = d2;
                            }
                        }
                    }
                    for (AdSource adSource5 : this.c2sSuccessAds.keySet()) {
                        if (adSource5.is_black == 1 && ((adapterAPI = this.adViewAdapter) == null || adapterAPI.getAdSource() != adSource5)) {
                            double d3 = adSource5.bidfloor;
                            if (d3 > d) {
                                adapterAPI3 = this.c2sSuccessAds.get(adSource5);
                                adSource3 = adSource5;
                                d = d3;
                            }
                        }
                    }
                    if (adapterAPI3 != null) {
                        this.adViewAdapter = adapterAPI3;
                        callBackLoadAd(adSource3);
                        return;
                    }
                }
                if (!this.isCacheMode && !this.isPreloadMode) {
                    adapterGenerator = this.mAdapterGenerator;
                    ydError = new YdError(20401, "load ad list is null");
                    adapterGenerator.onLoadFailed(ydError);
                }
            }
            int i3 = 10000;
            for (AdSource adSource6 : arrayList) {
                int i4 = adSource6.sequence;
                if (i3 > i4) {
                    adSource2 = adSource6;
                    i3 = i4;
                }
            }
            if (adSource2 != null) {
                int i5 = adSource2.bidfloor;
                if (i5 < iC2sBidResult) {
                    if (i5 > this.c2sSecondPrice) {
                        this.c2sSecondPrice = i5;
                        this.c2sSecondAdvId = adSource2.adv_id;
                    }
                    this.adViewAdapter = this.c2sSuccessAds.get(this.c2sResultAds.get(0));
                    list = this.c2sResultAds;
                } else {
                    this.adViewAdapter = this.successAds.get(adSource2);
                    callBackLoadAd(adSource2);
                }
            } else {
                adapterGenerator = this.mAdapterGenerator;
                ydError = new YdError(20401, "No available ads found");
                adapterGenerator.onLoadFailed(ydError);
            }
            if (this.isPreloadMode) {
                preloadDoneCallback.preloadDone();
            }
            obj = list.get(0);
            callBackLoadAd((AdSource) obj);
            if (this.isPreloadMode) {
                preloadDoneCallback.preloadDone();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mAdapterGenerator.onLoadFailed(new YdError(20401, "load ad list is null"));
        }
    }

    public synchronized void selectBottomAdapter() {
        LogcatUtil.d("YdSDK-Adapter", "selectBottomAdapter");
        if (!this.isSelectBottomAdapter) {
            this.isSelectBottomAdapter = true;
            this.isWaterfallDone = true;
            this.isC2SAdDone = true;
            this.sdkBidRetrun = true;
            this.apiBidRetrun = true;
            selectAdShow();
        }
    }

    public void sendMessageDelayed(int i, long j) {
        if (this.timeHandle == null) {
            return;
        }
        Message message = new Message();
        message.what = i;
        this.timeHandle.sendMessageDelayed(message, j);
    }

    public synchronized void setBottomSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.bottomSuccessAds.put(adSource, adapterAPI);
    }

    public synchronized void setErrInfo(ErrorInfo errorInfo) {
        this.errInfos.add(errorInfo);
    }

    public void setKey(String str) {
        this.key = str;
    }

    public synchronized void setRequestInfo(AdSource adSource) {
        if (adSource.isApiBidAd) {
            return;
        }
        adSource.cost_time = DeviceUtil.getBootTime() - adSource.reqTime;
        this.listRequestInfo.add(adSource);
    }

    public synchronized void setResponseInfo(AdSource adSource) {
        if (adSource.isApiBidAd) {
            return;
        }
        adSource.cost_time = DeviceUtil.getBootTime() - adSource.reqTime;
        this.listResponseInfo.add(adSource);
    }

    public synchronized void setS2SFailAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.c2sFailAds.put(adSource, adapterAPI);
    }

    public synchronized void setS2SSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.c2sSuccessAds.put(adSource, adapterAPI);
    }

    public synchronized void setSuccessAds(AdSource adSource, AdapterAPI adapterAPI) {
        this.successAds.put(adSource, adapterAPI);
    }
}
