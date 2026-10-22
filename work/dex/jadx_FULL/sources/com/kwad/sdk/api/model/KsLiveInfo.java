package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class KsLiveInfo implements Serializable {
    private static final long serialVersionUID = 1325239477399185820L;
    private int roiType;
    private KsLiveBaseInfo mKsLiveBaseInfo = new KsLiveBaseInfo();
    private List<KsLiveShopInfo> mKsLiveShopInfo = new ArrayList();
    private List<KsCouponInfo> mKsCouponInfo = new ArrayList();

    public List<KsCouponInfo> getKsCouponInfo() {
        return this.mKsCouponInfo;
    }

    public KsLiveBaseInfo getKsLiveBaseInfo() {
        return this.mKsLiveBaseInfo;
    }

    public List<KsLiveShopInfo> getKsLiveShopInfo() {
        return this.mKsLiveShopInfo;
    }

    public int getRoiType() {
        return this.roiType;
    }

    public void setKsCouponInfo(List<KsCouponInfo> list) {
        this.mKsCouponInfo = list;
    }

    public void setKsLiveBaseInfo(KsLiveBaseInfo ksLiveBaseInfo) {
        this.mKsLiveBaseInfo = ksLiveBaseInfo;
    }

    public void setKsLiveShopInfo(List<KsLiveShopInfo> list) {
        this.mKsLiveShopInfo = list;
    }

    public void setRoiType(int i) {
        this.roiType = i;
    }

    public String toString() {
        return "KsLiveInfo{roiType=" + this.roiType + ", mKsLiveBaseInfo=" + this.mKsLiveBaseInfo.toString() + ", mKsLiveShopInfo=" + this.mKsLiveShopInfo.toString() + ", mKsCouponInfo=" + this.mKsCouponInfo.toString() + '}';
    }
}
