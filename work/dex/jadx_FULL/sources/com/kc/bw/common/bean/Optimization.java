package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Optimization {
    public MediaAdCacheBean adCache;
    public CloseObj closeObj;
    public String copyContent;
    public DpLandingPageObj dpLandingPageObj;
    public List<String> replace;
    public SlideObject slideObject;
    public Tips tips;
    public int trackAdmRandom;

    public MediaAdCacheBean getAdCache() {
        return this.adCache;
    }

    public CloseObj getCloseObj() {
        return this.closeObj;
    }

    public String getCopyContent() {
        return this.copyContent;
    }

    public DpLandingPageObj getDpLandingPageObj() {
        return this.dpLandingPageObj;
    }

    public List<String> getReplace() {
        return this.replace;
    }

    public SlideObject getSlideObject() {
        return this.slideObject;
    }

    public Tips getTips() {
        return this.tips;
    }

    public int getTrackAdmRandom() {
        return this.trackAdmRandom;
    }

    public void setAdCache(MediaAdCacheBean mediaAdCacheBean) {
        this.adCache = mediaAdCacheBean;
    }

    public void setCloseObj(CloseObj closeObj) {
        this.closeObj = closeObj;
    }

    public void setCopyContent(String str) {
        this.copyContent = str;
    }

    public void setDpLandingPageObj(DpLandingPageObj dpLandingPageObj) {
        this.dpLandingPageObj = dpLandingPageObj;
    }

    public void setReplace(List<String> list) {
        this.replace = list;
    }

    public void setSlideObject(SlideObject slideObject) {
        this.slideObject = slideObject;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }

    public void setTrackAdmRandom(int i) {
        this.trackAdmRandom = i;
    }

    public String toString() {
        return dexg.dexa("Pqujnj{bujpo|dpqzDpoufou>(") + this.copyContent + '\'' + dexg.dexa("-!sfqmbdf>") + this.replace + dexg.dexa("-!dmptfPck>") + this.closeObj + dexg.dexa("-!eqMboejohQbhfPck>") + this.dpLandingPageObj + dexg.dexa("-!tmjefPckfdu>") + this.slideObject + dexg.dexa("-!ujqt>") + this.tips + dexg.dexa("-!beDbdif>") + this.adCache + dexg.dexa("-!usbdlBenSboepn>") + this.trackAdmRandom + '}';
    }
}
