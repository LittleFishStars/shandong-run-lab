package com.alibaba.triver.utils;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.security.SecurityUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.utils.TRiverUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageUtils {
    public static String getPageUrl(Page page) {
        if (page.getStartParams() != null) {
            String string = page.getStartParams().getString(TRiverConstants.KEY_ORI_URL);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject();
                if (page.getPageURI() != null) {
                    jSONObject.put("page", (Object) Uri.parse(page.getPageURI()).getFragment());
                    return com.alibaba.triver.kit.api.utils.CommonUtils.appUrlQuery(Uri.parse(string), jSONObject).toString();
                }
            }
        }
        return page.getPageURI();
    }

    public static String getRecentUrl(App app) {
        if (app == null) {
            return "";
        }
        Page activePage = app.getActivePage();
        return activePage == null ? app.getStartUrl() : activePage.getPageURI();
    }

    public static boolean isFirstPage(AppConfigModel appConfigModel, String str) {
        return TRiverUtils.isFirstPage(appConfigModel, str);
    }

    public static boolean isFirstTab(TabBarModel tabBarModel, String str) {
        return TRiverUtils.isFirstTab(tabBarModel, str);
    }

    public static String pageNameFilter(String str) {
        return TRiverUtils.pageNameFilter(str);
    }

    public static void pushPage(Page page, String str, Bundle bundle) {
        App app = page.getApp();
        RVLogger.d("TriverAppWrapper", "pushWindow from frame，url = " + str);
        String originalURI = page.getOriginalURI();
        if (str.startsWith("#")) {
            int iIndexOf = originalURI.indexOf(35);
            if (iIndexOf != -1) {
                str = originalURI.substring(0, iIndexOf) + str;
                RVLogger.d("TriverAppWrapper", "stripAnchor url:" + str);
            }
        } else {
            str = UrlUtils.mergeUrl(originalURI, str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!SecurityUtils.checkUrlCanStartInPushWindow(str)) {
            RVLogger.d("TriverAppWrapper", "pushWindow from frame security check failed!");
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(page.getStartParams());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putString(RVStartParams.KEY_FROM_TYPE, "pushWindow");
        if (((PushWindowPoint) ExtensionPoint.as(PushWindowPoint.class).node(page).create()).handlePushWindow(page, str, bundle2, null)) {
            return;
        }
        ParamUtils.filterCreatePageParams(bundle2);
        RVLogger.d("TriverAppWrapper", "pushWindow from frame, oldParams is " + bundle2.toString());
        app.pushPage(str, bundle2, page.getSceneParams());
    }
}
