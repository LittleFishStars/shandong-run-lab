package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkThirdPlatformAdslotConfig {
    public static final int BIDDING = 2;
    public static final int SORT_TYPE_FLOOR = 1;
    public static final int SORT_TYPE_PRICE = 2;
    public static final int TARGET_PRICE = 1;
    public int biddingType;
    public int cacheTime;
    public double dspBidPrice;
    public boolean enableRotate;
    public boolean enableShake;
    public boolean enableSlide;
    public double gapRatio;
    public double mediaBidPrice;
    public double priceRatio;
    public int sortType;
    public String thirdAppId;
    public String thirdSlotAppKey;

    @Deprecated
    public String thirdSlotConfig;
    public String thirdSlotId;
    public int thirdSlotIdKey;
    public int thirdSlotType;
    public String v;

    @Deprecated
    public int weight;
    public int weightRatio;

    public int getBiddingType() {
        return this.biddingType;
    }

    public int getCacheTime() {
        return this.cacheTime;
    }

    public double getDspBidPrice() {
        return this.dspBidPrice;
    }

    public double getGapRatio() {
        return this.gapRatio;
    }

    public double getMediaBidPrice() {
        return this.mediaBidPrice;
    }

    public double getPriceRatio() {
        return this.priceRatio;
    }

    public int getSortType() {
        return this.sortType;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public String getThirdSlotAppKey() {
        return this.thirdSlotAppKey;
    }

    @Deprecated
    public String getThirdSlotConfig() {
        return this.thirdSlotConfig;
    }

    public String getThirdSlotId() {
        return this.thirdSlotId;
    }

    public int getThirdSlotIdKey() {
        return this.thirdSlotIdKey;
    }

    public int getThirdSlotType() {
        return this.thirdSlotType;
    }

    public String getV() {
        return this.v;
    }

    @Deprecated
    public int getWeight() {
        return this.weight;
    }

    public int getWeightRatio() {
        return this.weightRatio;
    }

    public boolean isEnableRotate() {
        return this.enableRotate;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public boolean isEnableSlide() {
        return this.enableSlide;
    }

    public void setBiddingType(int i) {
        this.biddingType = i;
    }

    public void setCacheTime(int i) {
        this.cacheTime = i;
    }

    public void setDspBidPrice(double d) {
        this.dspBidPrice = d;
    }

    public void setEnableRotate(boolean z) {
        this.enableRotate = z;
    }

    public void setEnableShake(boolean z) {
        this.enableShake = z;
    }

    public void setEnableSlide(boolean z) {
        this.enableSlide = z;
    }

    public void setGapRatio(double d) {
        this.gapRatio = d;
    }

    public void setMediaBidPrice(double d) {
        this.mediaBidPrice = d;
    }

    public void setPriceRatio(double d) {
        this.priceRatio = d;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void setThirdAppId(String str) {
        this.thirdAppId = str;
    }

    public void setThirdSlotAppKey(String str) {
        this.thirdSlotAppKey = str;
    }

    @Deprecated
    public void setThirdSlotConfig(String str) {
        this.thirdSlotConfig = str;
    }

    public void setThirdSlotId(String str) {
        this.thirdSlotId = str;
    }

    public void setThirdSlotIdKey(int i) {
        this.thirdSlotIdKey = i;
    }

    public void setThirdSlotType(int i) {
        this.thirdSlotType = i;
    }

    public void setV(String str) {
        this.v = str;
    }

    @Deprecated
    public void setWeight(int i) {
        this.weight = i;
    }

    public void setWeightRatio(int i) {
        this.weightRatio = i;
    }

    public String toString() {
        return dexg.dexa("TelUijseQmbugpsnBetmpuDpogjh|uijseTmpuJe>(") + this.thirdSlotId + '\'' + dexg.dexa("-!uijseTmpuUzqf>") + this.thirdSlotType + dexg.dexa("-!uijseTmpuDpogjh>(") + this.thirdSlotConfig + '\'' + dexg.dexa("-!uijseTmpuJeLfz>") + this.thirdSlotIdKey + dexg.dexa("-!dbdifUjnf>") + this.cacheTime + dexg.dexa("-!fobcmfTiblf>") + this.enableShake + dexg.dexa("-!fobcmfSpubuf>") + this.enableRotate + dexg.dexa("-!fobcmfTmjef>") + this.enableSlide + dexg.dexa("-!hbqSbujp>") + this.gapRatio + dexg.dexa("-!qsjdfSbujp>") + this.priceRatio + dexg.dexa("-!xfjhiuSbujp>") + this.weightRatio + dexg.dexa("-!tpsuUzqf>") + this.sortType + dexg.dexa("-!xfjhiu>") + this.weight + dexg.dexa("-!w>(") + this.v + '\'' + dexg.dexa("-!etqCjeQsjdf>") + this.dspBidPrice + dexg.dexa("-!nfejbCjeQsjdf>") + this.mediaBidPrice + dexg.dexa("-!cjeejohUzqf>") + this.biddingType + dexg.dexa("-!uijseBqqJe>(") + this.thirdAppId + '\'' + dexg.dexa("-!uijseTmpuBqqLfz>(") + this.thirdSlotAppKey + "'}";
    }
}
