package com.alibaba.ariver.jsapi.logging;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24154a = "default_url";

    public static void a(App app, Map<String, Object> map) {
        if (app != null) {
            a("appType", app.getAppType(), map);
            a("appId", app.getAppId(), map);
            a("version", app.getAppVersion(), map);
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel != null) {
                a("version", appModel.getAppVersion(), map);
                AppInfoModel appInfoModel = appModel.getAppInfoModel();
                if (appInfoModel != null) {
                    a("status", appInfoModel.getStatus(), map);
                }
                a("appMode", appModel.toString(), map);
            }
        }
    }

    public static void a(String str, Object obj, Map map) {
        if (map == null || str == null || obj == null) {
            return;
        }
        map.put(str, obj);
    }

    public static void a(Page page, Map<String, Object> map) {
        if (page != null) {
            a("pageUrl", page.getOriginalURI(), map);
            a("url", page.getOriginalURI(), map);
        }
    }

    public static String a(App app) {
        if (app == null) {
            return "";
        }
        long startToken = app.getStartToken();
        String appId = app.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return "";
        }
        return appId + startToken;
    }

    public static String a(App app, String str) {
        if (app == null) {
            return "";
        }
        long startToken = app.getStartToken();
        String appId = app.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = f24154a;
        }
        return appId + startToken + str;
    }
}
