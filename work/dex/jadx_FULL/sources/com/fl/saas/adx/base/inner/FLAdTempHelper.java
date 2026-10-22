package com.fl.saas.adx.base.inner;

import com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLAdTempHelper {
    private static FLAdTempHelper sInstance;
    private Map<String, SpreadActivityListener> listActivityMap;
    private Map<String, InterstitialViewHelper> listInterstitialHelperMap;
    private SpreadLoadListener.SpreadAd spreadAd;

    public interface SpreadActivityListener {
        void closeActivity();
    }

    private FLAdTempHelper() {
    }

    public static FLAdTempHelper getInstance() {
        if (sInstance == null) {
            synchronized (FLAdTempHelper.class) {
                sInstance = new FLAdTempHelper();
            }
        }
        return sInstance;
    }

    public void addInterstitialHelper(String str, InterstitialViewHelper interstitialViewHelper) {
        if (this.listInterstitialHelperMap == null) {
            this.listInterstitialHelperMap = new HashMap();
        }
        this.listInterstitialHelperMap.put(str, interstitialViewHelper);
    }

    public void addSpreadListener(String str, SpreadActivityListener spreadActivityListener) {
        if (this.listActivityMap == null) {
            this.listActivityMap = new HashMap();
        }
        this.listActivityMap.put(str, spreadActivityListener);
    }

    public void closeSpreadSpread(String str) {
        SpreadActivityListener spreadActivityListener;
        Map<String, SpreadActivityListener> map = this.listActivityMap;
        if (map == null || (spreadActivityListener = map.get(str)) == null) {
            return;
        }
        spreadActivityListener.closeActivity();
    }

    public InterstitialViewHelper getInterstitialHelper(String str) {
        Map<String, InterstitialViewHelper> map = this.listInterstitialHelperMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public SpreadLoadListener.SpreadAd getSpreadAd() {
        return this.spreadAd;
    }

    public void removeInterstitialHelper(String str) {
        Map<String, InterstitialViewHelper> map = this.listInterstitialHelperMap;
        if (map != null) {
            map.remove(str);
        }
    }

    public void removeSpreadListener(String str) {
        Map<String, SpreadActivityListener> map = this.listActivityMap;
        if (map != null) {
            map.remove(str);
        }
    }

    public void setSpreadAd(SpreadLoadListener.SpreadAd spreadAd) {
        this.spreadAd = spreadAd;
    }
}
