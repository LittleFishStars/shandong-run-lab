package com.alibaba.triver.kit.api.utils;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRiverUrlUtils {
    private static final String IS_SHOP = "isShop";
    private static final String IS_SHOP_TAG = "isShopTag";
    private static final String ORI_URL_KEY = "ori_url";

    @Nullable
    public static Map<String, String> getAllUrlParam(App app) {
        if (app == null || app.getStartParams() == null) {
            return null;
        }
        return URLUtils.getUrlParams(getUrl(app));
    }

    public static String getBaseUrl(App app) {
        String strTrim = getUrl(app).trim();
        if (strTrim.equals("")) {
            return null;
        }
        String[] strArrSplit = strTrim.split("\\?");
        if (strArrSplit.length > 0) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String getShopTabKey(App app) {
        if (app == null || !isShop(app)) {
            return "default";
        }
        String urlParamByKey = getUrlParamByKey(app, "shop_navi");
        String urlParamByKey2 = getUrlParamByKey(app, "weexShopSubTab");
        String urlParamByKey3 = getUrlParamByKey(app, "weexShopTab");
        if (!TextUtils.isEmpty(urlParamByKey)) {
            return urlParamByKey;
        }
        if (TextUtils.isEmpty(urlParamByKey2)) {
            return !TextUtils.isEmpty(urlParamByKey3) ? urlParamByKey3 : "shopindex";
        }
        return urlParamByKey2;
    }

    public static String getUrl(App app) {
        if (app == null || app.getStartParams() == null) {
            return null;
        }
        return app.getStartParams().getString("ori_url");
    }

    @Nullable
    public static String getUrlParamByKey(App app, String str) {
        Map<String, String> allUrlParam;
        if (str == null || (allUrlParam = getAllUrlParam(app)) == null) {
            return null;
        }
        return allUrlParam.get(str);
    }

    public static String getUrlParams(App app) {
        String strTrim = getUrl(app).trim();
        if (strTrim.equals("")) {
            return null;
        }
        String[] strArrSplit = strTrim.split("\\?");
        if (strArrSplit.length > 1) {
            return strArrSplit[1];
        }
        return null;
    }

    public static String getWeexShopTabId(String str) {
        return getAllUrlParam(str).get("weexShopTabId");
    }

    public static String getWeexShopToken(String str) {
        return getAllUrlParam(str).get("weexShopToken");
    }

    public static boolean isShop(App app) {
        if (app == null) {
            return false;
        }
        if (app.containsKey(IS_SHOP_TAG)) {
            return app.getBooleanValue(IS_SHOP_TAG);
        }
        if (TextUtils.equals("1", getUrlParamByKey(app, IS_SHOP))) {
            app.putBooleanValue(IS_SHOP_TAG, true);
            return true;
        }
        app.putBooleanValue(IS_SHOP_TAG, false);
        return false;
    }

    public static boolean shopIsHomePage(App app) {
        return shopIsHomePage(app.getStartParams().getString("ori_url"));
    }

    public static String getUrl(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString("ori_url");
    }

    @Nullable
    public static String getUrlParamByKey(String str, String str2) {
        Map<String, String> allUrlParam;
        if (str2 == null || (allUrlParam = getAllUrlParam(str)) == null) {
            return null;
        }
        return allUrlParam.get(str2);
    }

    public static boolean shopIsHomePage(String str) {
        try {
            String shopTabKey = getShopTabKey(str);
            JSONArray shopWeexPreloadShopNaviList = TBShopOrangeController.getShopWeexPreloadShopNaviList();
            if (!isShop(str) || shopWeexPreloadShopNaviList == null || !shopWeexPreloadShopNaviList.contains(shopTabKey)) {
                return false;
            }
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("ShopFetch", "this tab is " + shopTabKey + ", will preload weex");
            return true;
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }

    @Nullable
    public static Map<String, String> getAllUrlParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return URLUtils.getUrlParams(str);
    }

    public static boolean isShop(String str) {
        return TextUtils.equals("1", getUrlParamByKey(str, IS_SHOP));
    }

    public static boolean isShop(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("ori_url");
        return !TextUtils.isEmpty(string) && TextUtils.equals("1", getUrlParamByKey(string, IS_SHOP));
    }

    public static String getShopTabKey(String str) {
        if (TextUtils.isEmpty(str) || !isShop(str)) {
            return "default";
        }
        String urlParamByKey = getUrlParamByKey(str, "shop_navi");
        String urlParamByKey2 = getUrlParamByKey(str, "weexShopSubTab");
        String urlParamByKey3 = getUrlParamByKey(str, "weexShopTab");
        if (!TextUtils.isEmpty(urlParamByKey)) {
            return urlParamByKey;
        }
        if (TextUtils.isEmpty(urlParamByKey2)) {
            return !TextUtils.isEmpty(urlParamByKey3) ? urlParamByKey3 : "shopindex";
        }
        return urlParamByKey2;
    }
}
