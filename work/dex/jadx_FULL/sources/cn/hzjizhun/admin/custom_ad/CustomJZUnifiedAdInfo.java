package cn.hzjizhun.admin.custom_ad;

import android.content.Context;
import android.view.View;
import cn.hzjizhun.admin.JZUnifiedADContainer;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdPatternType;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.ddkds;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CustomJZUnifiedAdInfo extends ddkds {
    private CustomAdPosResult mAdObject;

    public CustomJZUnifiedAdInfo(PosInfoBean posInfoBean, AdapterAdLoaderImp adapterAdLoaderImp) {
        super(posInfoBean, adapterAdLoaderImp);
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public void bindJZAdToView(Context context, JZUnifiedADContainer jZUnifiedADContainer, List<View> list) {
        bindJZAdToView(context, jZUnifiedADContainer, list, null);
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public JZUnifiedAdPatternType getJZAdPatternType() {
        if (this.mAdObject != null) {
            return JZUnifiedAdPatternType.NATIVE_1IMAGE_2TEXT;
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public String getJZDesc() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getDesc();
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public String getJZIconUrl() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getIconUrl();
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public List<String> getJZImgList() {
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public String getJZImgUrl() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null) {
            return customAdPosResult.getImgUrl();
        }
        return null;
    }

    @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
    public String getJZTitle() {
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
