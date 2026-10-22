package com.bwt.top.custom_ad;

import android.content.Context;
import android.view.View;
import com.bwt.top.UnifiedADContainer;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.ad.bean.UnifiedAdPatternType;
import com.bwt.top.ad.bean.dkkd;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.custom_ad.http.CustomAdPosResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class CustomUnifiedAdInfo extends dkkd {
    private CustomAdPosResult mAdObject;

    public CustomUnifiedAdInfo(PosInfoBean posInfoBean, AdapterAdLoaderImp adapterAdLoaderImp) {
        super(posInfoBean, adapterAdLoaderImp);
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public void bindAdToView(Context context, UnifiedADContainer unifiedADContainer, List<View> list) {
        bindAdToView(context, unifiedADContainer, list, null);
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public UnifiedAdPatternType getAdPatternType() {
        if (this.mAdObject != null) {
            return UnifiedAdPatternType.NATIVE_1IMAGE_2TEXT;
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public String getDesc() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getDesc();
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public String getIconUrl() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getIconUrl();
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public List<String> getImgList() {
        return null;
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public String getImgUrl() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getImgUrl();
        }
        return null;
    }

    @Override // com.bwt.top.ad.bean.UnifiedAdInfo
    public String getTitle() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getTitle();
        }
        return null;
    }

    public void setAdObject(CustomAdPosResult customAdPosResult) {
        this.mAdObject = customAdPosResult;
    }
}
