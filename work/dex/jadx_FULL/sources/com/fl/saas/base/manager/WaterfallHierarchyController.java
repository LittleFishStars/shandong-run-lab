package com.fl.saas.base.manager;

import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.common.saas.bean.AdSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class WaterfallHierarchyController {
    public int adNum;
    public int failNum;
    public int finishNum;
    public int hierarchy;
    public boolean isTimeOut = false;
    private boolean isReqNext = false;
    public Map<AdSource, AdapterAPI> successAds = new ConcurrentHashMap();

    public boolean isDone() {
        return this.isTimeOut || this.failNum + this.finishNum == this.adNum;
    }

    public boolean isHasAd() {
        return this.finishNum > 0;
    }

    public boolean isReqNext() {
        return this.isReqNext;
    }

    public void setReqNext(boolean z) {
        this.isReqNext = z;
    }

    public void setSuccessAd(AdSource adSource, AdapterAPI adapterAPI) {
        this.successAds.put(adSource, adapterAPI);
    }

    public void setTimeOut(boolean z) {
        this.isTimeOut = z;
    }
}
