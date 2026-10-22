package com.alibaba.alibctriver;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.FuncDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.model.PluginDO;
import com.alibaba.alibcprotocol.route.model.SuiteDO;
import com.alibaba.alibctriver.api.AlibcTriverLiveProxy;
import com.alibaba.alibctriver.preload.SuiteTemplateDataPreload;
import com.alibaba.alibctriver.proxy.AlibcTriverLogger;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.open.TriverSDK;
import com.alibaba.triver.utils.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTriverSDK {
    private static final String OPEN_PRELOAD = "openPreload";
    private static final String PRELOAD_APPKEY = "preload_appkey";
    private static final String PRELOAD_DYNAMIC_PLUGIN_AAS = "preloadDynamicPluginAfterAppStart";
    private static final String PRELOAD_DYNAMIC_PLUGIN_BAS = "preloadDynamicPluginBeforeAppStart";
    private static final String PRELOAD_PLUGINS = "preload_plugins";
    private static final String TAG = "TriverSDK";
    private static final String TRIVER_COMMON_CONFIG = "triver_common_config";

    public interface a {
        void a();

        void a(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void executeAfterPluginLoad(final Worker worker, Node node) {
        if (node != null) {
            App app = (App) node;
            try {
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                if (appModel != null) {
                    List<PluginModel> plugins = (appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) ? null : appModel.getAppInfoModel().getPlugins();
                    if (worker == null || plugins == null || plugins.isEmpty()) {
                        return;
                    }
                    worker.setStartupParams(app.getStartParams());
                    for (final PluginModel pluginModel : plugins) {
                        worker.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.alibctriver.AlibcTriverSDK.4
                            @Override // java.lang.Runnable
                            public void run() {
                                worker.loadPlugin(pluginModel.getAppId());
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                AlibcLogger.e(TAG, "execute preload dynamic plugin after app start exception: " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void executeBeforePluginLoad(final Worker worker) {
        PluginModel pluginModelA;
        if (worker == null || !openDynamicPluginPreload(PRELOAD_DYNAMIC_PLUGIN_BAS)) {
            return;
        }
        try {
            PageDO page = AlibcConfigService.getInstance().getPage();
            List<String> preloadPlugins = getPreloadPlugins();
            if (page != null) {
                JSONArray dynamicPlugins = parseDynamicPlugins(page.getSuites());
                for (int i = 0; i < dynamicPlugins.size(); i++) {
                    final String string = ((JSONObject) dynamicPlugins.get(i)).getString("pluginId");
                    if (preloadPlugins.contains(string) && (pluginModelA = PluginInfoCenter.a(string, "*")) != null) {
                        com.alibaba.alibctriver.b.a.a(string, d.b(pluginModelA.getPackageUrl()));
                        if (preloadPlugins.contains(string)) {
                            worker.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.alibctriver.AlibcTriverSDK.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    worker.loadPlugin(string);
                                }
                            });
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            AlibcLogger.e(TAG, "execute preload dynamic plugin before app start exception: " + th.getMessage());
        }
    }

    private static List<String> getPreloadPlugins() {
        MiscDO misc;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        ArrayList arrayList = new ArrayList();
        if (config != null && (misc = config.getMisc()) != null) {
            JSONArray jSONArray = misc.getMiniConfJson().getJSONArray(PRELOAD_PLUGINS);
            for (int i = 0; i < jSONArray.size(); i++) {
                arrayList.add(String.valueOf(jSONArray.get(i)));
            }
        }
        return arrayList;
    }

    public static void init(Application application, final a aVar) {
        TriverSDK.init(application, new TriverSDK.a() { // from class: com.alibaba.alibctriver.AlibcTriverSDK.1
            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void a(Context context) {
                RVProxy.set(RVLogger.Proxy.class, new AlibcTriverLogger());
                super.a(context);
            }

            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void b(Context context) {
                super.b(context);
                AlibcTriverSDK.initPreload();
            }

            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void d(Context context) {
                AlibcTriverSDK.initTbLive();
            }
        }, new TriverSDK.InitResultCallback() { // from class: com.alibaba.alibctriver.AlibcTriverSDK.2
            @Override // com.alibaba.triver.open.TriverSDK.InitResultCallback
            public void onFail(String str, String str2) {
                aVar.a(str, str2);
            }

            @Override // com.alibaba.triver.open.TriverSDK.InitResultCallback
            public void onSuccess() {
                aVar.a();
                com.alibaba.triver.triver_worker.v8worker.a.a.a(new com.alibaba.triver.triver_worker.v8worker.a.a.InterfaceC0180a() { // from class: com.alibaba.alibctriver.AlibcTriverSDK.2.1
                    @Override // com.alibaba.triver.triver_worker.v8worker.a.a.InterfaceC0180a
                    public void a(Worker worker) {
                        JSONObject jSONObject;
                        if (com.alibaba.alibctriver.b.a.b(AlibcTriverSDK.PRELOAD_APPKEY)) {
                            try {
                                JSONObject jSONObjectA = com.alibaba.alibctriver.b.a.a();
                                if (jSONObjectA == null || (jSONObject = jSONObjectA.getJSONObject("triver_common_config")) == null || !"true".equals(String.valueOf(jSONObject.get(AlibcTriverSDK.OPEN_PRELOAD)))) {
                                    return;
                                }
                                AlibcTriverSDK.executeBeforePluginLoad(worker);
                            } catch (Exception e) {
                                AlibcLogger.e(AlibcTriverSDK.TAG, "data parse exception: " + e.getMessage());
                            }
                        }
                    }

                    @Override // com.alibaba.triver.triver_worker.v8worker.a.a.InterfaceC0180a
                    public void a(Worker worker, Node node) {
                        if (AlibcTriverSDK.openDynamicPluginPreload(AlibcTriverSDK.PRELOAD_DYNAMIC_PLUGIN_AAS)) {
                            AlibcTriverSDK.executeAfterPluginLoad(worker, node);
                        }
                    }
                });
            }
        });
    }

    public static void initPreload() {
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.DATA_PREFETCH, SuiteTemplateDataPreload.class);
    }

    public static void initTbLive() {
        ((AlibcTriverLiveProxy) RVProxy.get(AlibcTriverLiveProxy.class)).initTbLive();
    }

    public static void openApp(Context context, Uri uri, Bundle bundle) {
        TriverSDK.openApp(context, uri, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean openDynamicPluginPreload(String str) {
        MiscDO misc;
        JSONObject jSONObject;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        return (config == null || (misc = config.getMisc()) == null || (jSONObject = misc.getMiniConfJson().getJSONObject("triver_common_config")) == null || !"true".equals(jSONObject.getString(str))) ? false : true;
    }

    public static JSONArray parseDynamicPlugins(List<SuiteDO> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            Iterator<SuiteDO> it = list.iterator();
            while (it.hasNext()) {
                List<FuncDO> funcs = it.next().getFuncs();
                for (FuncDO funcDO : funcs) {
                    if (funcs.size() > 0 && "miniapp_plugin".equals(funcDO.getType())) {
                        String appId = funcDO.getAppId();
                        String version = funcDO.getVersion();
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(appId)) {
                            jSONObject.put("pluginId", (Object) appId);
                        }
                        if (!TextUtils.isEmpty(version)) {
                            jSONObject.put("requireVersion", (Object) version);
                        }
                        jSONArray.add(jSONObject);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject parseSuites(List<SuiteDO> list) {
        JSONObject jSONObject = new JSONObject();
        if (list != null && list.size() > 0) {
            Iterator<SuiteDO> it = list.iterator();
            while (it.hasNext()) {
                List<FuncDO> funcs = it.next().getFuncs();
                if (funcs != null && funcs.size() > 0) {
                    for (FuncDO funcDO : funcs) {
                        String type = funcDO.getType();
                        String appType = funcDO.getAppType();
                        String baseUrl = funcDO.getBaseUrl();
                        if ("miniapp".equals(type) && "1".equals(appType)) {
                            String appId = TRiverUtils.getAppId(Uri.parse(baseUrl));
                            if (!jSONObject.containsKey(appId)) {
                                jSONObject.put(appId, (Object) new JSONArray());
                            }
                        } else if ("miniapp_plugin".equals(type)) {
                            String appId2 = TRiverUtils.getAppId(Uri.parse(baseUrl));
                            if (!jSONObject.containsKey(appId2)) {
                                jSONObject.put(appId2, (Object) new JSONArray());
                            }
                            JSONArray jSONArray = jSONObject.getJSONArray(appId2);
                            JSONObject jSONObject2 = new JSONObject();
                            if (!TextUtils.isEmpty(funcDO.getAppId())) {
                                jSONObject2.put("pluginId", (Object) funcDO.getAppId());
                                jSONObject2.put("requireVersion", (Object) funcDO.getVersion());
                                jSONArray.add(jSONObject2);
                            }
                            if (funcDO.getDynamicPlugins() != null && !funcDO.getDynamicPlugins().isEmpty()) {
                                for (PluginDO pluginDO : funcDO.getDynamicPlugins()) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    if (!TextUtils.isEmpty(pluginDO.getAppId())) {
                                        jSONObject3.put("pluginId", (Object) pluginDO.getAppId());
                                        jSONObject3.put("requireVersion", (Object) pluginDO.getVersion());
                                        jSONArray.add(jSONObject3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void preloadResource(Context context, List<SuiteDO> list) {
        TriverSDK.preloadResource(context, parseSuites(list));
    }

    public static void openApp(Context context, Uri uri, Bundle bundle, TriverSDK.a aVar) {
        TriverSDK.openApp(context, uri, bundle, aVar);
    }
}
