package com.fl.saas.base.inner;

import android.app.Activity;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdAdTempHelper {
    private static YdAdTempHelper sInstance;
    private Map<String, SpreadActivityListener> listActivityMap;
    private Map<String, InterstitialActivityLoadListener> listMap;
    private SpreadLoadListener.SpreadAd spreadAd;

    public interface InterstitialActivityLoadListener {
        void onActivityCreate(Activity activity);
    }

    public interface SpreadActivityListener {
        void closeActivity();
    }

    private YdAdTempHelper() {
    }

    public static YdAdTempHelper getInstance() {
        if (sInstance == null) {
            synchronized (YdAdTempHelper.class) {
                sInstance = new YdAdTempHelper();
            }
        }
        return sInstance;
    }

    public void addListener(String str, InterstitialActivityLoadListener interstitialActivityLoadListener) {
        if (this.listMap == null) {
            this.listMap = new HashMap();
        }
        this.listMap.put(str, interstitialActivityLoadListener);
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

    public SpreadLoadListener.SpreadAd getSpreadAd() {
        return this.spreadAd;
    }

    public void notify(String str, Activity activity) {
        InterstitialActivityLoadListener interstitialActivityLoadListener;
        Map<String, InterstitialActivityLoadListener> map = this.listMap;
        if (map == null || (interstitialActivityLoadListener = map.get(str)) == null) {
            return;
        }
        interstitialActivityLoadListener.onActivityCreate(activity);
    }

    public void removeListener(String str) {
        Map<String, InterstitialActivityLoadListener> map = this.listMap;
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
