package com.alibaba.triver.preload;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.utils.CommonUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverOnPreloadExtension implements OnPreloadPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f25121a = "";

    private static JSONObject a() {
        String strAppInfoPreload = CommonUtils.appInfoPreload();
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(strAppInfoPreload)) {
            for (String str : strAppInfoPreload.split(",")) {
                jSONObject.put(str, (Object) new JSONArray());
            }
        }
        return jSONObject;
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void afterParsePackages(App app, PluginModel pluginModel, String str) {
        JSONObject launchParams;
        if (app != null) {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel.getContainerInfo() != null && (launchParams = appModel.getContainerInfo().getLaunchParams()) != null) {
                str = launchParams.getString("preloadConfig");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("preload", str);
        map.put(NativeCallContext.DOMAIN_APP, app);
        map.put("plugin", pluginModel);
        map.put("appInfo", app != null ? (AppModel) app.getData(AppModel.class) : null);
        String startUrl = app != null ? app.getStartUrl() : null;
        map.put("url", startUrl);
        if (!TextUtils.isEmpty(startUrl)) {
            try {
                Uri uri = Uri.parse(startUrl);
                String queryParameter = uri.getQueryParameter("path");
                String queryParameter2 = uri.getQueryParameter("query");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = uri.getQueryParameter("page");
                }
                if (TextUtils.isEmpty(queryParameter)) {
                    map.put("query", queryParameter2);
                } else {
                    map.put("query", Uri.parse(queryParameter).getQuery());
                }
            } catch (Throwable unused) {
            }
        }
        map.put(RVConstants.EXTRA_START_TOKEN, app != null ? Long.valueOf(app.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN)) : null);
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.AFTER_PARSE_PACKAGE, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void appInfoPointPreload(String str, long j, AppModel appModel, Bundle bundle) {
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void closeAppPointPreload(App app) {
        AppContext appContext;
        Context context;
        HashMap map = new HashMap();
        map.put(NativeCallContext.DOMAIN_APP, app);
        map.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, f25121a);
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null && Triver.isMainProcess(context)) {
            map.put("appIds", a());
        }
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CLOSE_APP, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void createActivityPreload(Map<String, Object> map) {
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CREATE_ACTIVITY, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void createAppContext(App app) {
        HashMap map = new HashMap();
        map.put(NativeCallContext.DOMAIN_APP, app);
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CREATE_APP, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void dataPrefetch(AppNode appNode, String str, long j, AppModel appModel, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("appInfo", appModel);
        map.put("url", str);
        map.put(RVConstants.EXTRA_START_TOKEN, Long.valueOf(j));
        map.put(RVConstants.EXTRA_START_PARAMS, bundle);
        map.put("appNode", appNode);
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.DATA_PREFETCH, map);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void openPagePointPreload(Page page) {
        HashMap map = new HashMap();
        map.put("page", page);
        if (page != null && page.getRender() != null) {
            f25121a = page.getRender().getUserAgent();
        }
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.AFTER_OPEN_PAGE, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void prepareResources(AppModel appModel, PluginModel pluginModel, String str) {
        JSONObject launchParams;
        if (appModel != null && appModel.getContainerInfo() != null && (launchParams = appModel.getContainerInfo().getLaunchParams()) != null) {
            str = launchParams.getString("preloadConfig");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("preload", str);
        map.put("plugin", pluginModel);
        map.put("appInfo", appModel);
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.AFTER_PARSE_PACKAGE, map);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void processCreatedPointPreload() {
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.PROCESS_CREATE, null);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void processDiedPreload() {
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.PROCESS_DIED, null);
    }

    @Override // com.alibaba.triver.point.OnPreloadPoint
    public void resourcePointPreload() {
        PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.PRELOAD_RESOURCE, a());
    }
}
