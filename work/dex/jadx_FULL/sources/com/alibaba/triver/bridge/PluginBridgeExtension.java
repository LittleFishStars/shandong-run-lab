package com.alibaba.triver.bridge;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginParam;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.a.b;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginBridgeExtension implements BridgeExtension {
    public static final int ERROR_APPID_VERIFY = -9;
    public static final int ERROR_EMPTY_PLUGIN_DATA = -11;
    public static final int ERROR_PLUGIN_DOWNLOAD = -2;
    public static final String ERROR_PLUGIN_DOWNLOAD_TEXT = "plugin download failed";
    public static final int ERROR_PLUGIN_INFO_REQUEST_ERROR = -1;
    public static final String ERROR_PLUGIN_INFO_REQUEST_ERROR_TEXT = "plugin info request error.";
    public static final int ERROR_PLUGIN_INSTALL = -3;
    public static final String ERROR_PLUGIN_INSTALL_TEXT = "plugin install failed";
    public static final int ERROR_PLUGIN_LOAD = -4;
    public static final String ERROR_PLUGIN_LOAD_TEXT = "plugin package load failed";
    public static final int ERROR_PLUGIN_PARSE = -13;
    public static final int ERROR_PLUGIN_PRELOAD_EXPIRED = -6;
    public static final int ERROR_SIGN_VERIFY = -12;
    public static final int ERROR_TEMPLATEID_VERIFY = -10;
    public static final int ERROR_UNKNOWN_RELATION = -8;
    public static final int ERROR_UNSUPPORTED_RUNTIME = -7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24751a = "PluginBridge";

    public interface a {
        void a(String str, long j);

        void a(String str, long j, int i, String str2);
    }

    private Set<Pair<String, String>> a(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        for (Object obj : jSONArray) {
            if (obj instanceof String) {
                String[] strArrSplit = ((String) obj).split("@");
                if (strArrSplit.length == 2) {
                    hashSet.add(new Pair(strArrSplit[0], strArrSplit[1]));
                }
            }
        }
        return hashSet;
    }

    public static boolean skipPluginSign() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("skipPluginSign");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void preloadPluginBatch(@BindingApiContext final ApiContext apiContext, @BindingNode(App.class) final App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"pluginInfos"}) JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "No plugin info"));
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final Set<Pair<String, String>> setA = a(jSONArray);
        if (setA.size() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "No plugin info"));
            return;
        }
        final a aVar = new a() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.1
            @Override // com.alibaba.triver.bridge.PluginBridgeExtension.a
            public void a(String str, long j) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pluginId", (Object) str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                apiContext.sendEvent("preloadPluginBatchCallBack", jSONObject2, null);
            }

            @Override // com.alibaba.triver.bridge.PluginBridgeExtension.a
            public void a(String str, long j, int i, String str2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pluginId", (Object) str);
                jSONObject.put("errorId", (Object) Integer.valueOf(i));
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                apiContext.sendEvent("preloadPluginBatchCallBack", jSONObject2, null);
            }
        };
        Runnable runnable = new Runnable() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.2
            @Override // java.lang.Runnable
            public void run() {
                IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(app.getAppId(), app.getStartParams());
                for (Pair pair : setA) {
                    final String str = (String) pair.first;
                    final String str2 = (String) pair.second;
                    UpdatePluginParam updatePluginParam = new UpdatePluginParam(app.getAppId(), str);
                    updatePluginParam.setApp(app);
                    updatePluginParam.setRequiredVersion(str2);
                    updatePluginParam.setApiContext(apiContext);
                    iAppUpdaterCreateUpdater.updatePlugin(updatePluginParam, new UpdatePluginCallback() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.2.1
                        @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
                        public void onError(UpdateAppException updateAppException) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            PluginBridgeExtension.this.a(str, jCurrentTimeMillis, -1, PluginBridgeExtension.ERROR_PLUGIN_INFO_REQUEST_ERROR_TEXT, aVar);
                        }

                        @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
                        public void onSuccess(PluginModel pluginModel) {
                            pluginModel.setRequireVersion(str2);
                            PluginBridgeExtension pluginBridgeExtension = PluginBridgeExtension.this;
                            String appId = pluginModel.getAppId();
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            pluginBridgeExtension.a(appId, pluginModel, app, jCurrentTimeMillis, aVar);
                        }
                    });
                }
            }
        };
        RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        if (rVExecutorService != null) {
            rVExecutorService.getExecutor(ExecutorType.NETWORK).execute(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    @ActionFilter
    public void preloadPluginPkgBatch(@BindingApiContext final ApiContext apiContext, @BindingNode(App.class) final App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"pluginPkgInfos"}) final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "No plugin info"));
            return;
        }
        if (app == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-7, "Your app is not running!"));
            return;
        }
        final String appId = app.getAppId();
        if (TextUtils.isEmpty(appId)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-7, "Your app is not running？"));
        }
        final a aVar = new a() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.4
            @Override // com.alibaba.triver.bridge.PluginBridgeExtension.a
            public void a(String str, long j) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pluginId", (Object) str);
                jSONObject.put("success", (Object) Boolean.TRUE);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                apiContext.sendEvent("preloadPluginPkgBatchCallBack", jSONObject2, null);
                b.a(appId, str, j);
            }

            @Override // com.alibaba.triver.bridge.PluginBridgeExtension.a
            public void a(String str, long j, int i, String str2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pluginId", (Object) str);
                jSONObject.put("success", (Object) Boolean.FALSE);
                jSONObject.put("errorId", (Object) Integer.valueOf(i));
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                apiContext.sendEvent("preloadPluginPkgBatchCallBack", jSONObject2, null);
                b.a(appId, str, j, i + "", str2);
            }
        };
        Runnable runnable = new Runnable() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.5
            /* JADX WARN: Code duplicated, block: B:32:0x0152  */
            /* JADX WARN: Code duplicated, block: B:47:0x0237 A[LOOP:1: B:45:0x0231->B:47:0x0237, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:80:0x028c A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:81:0x0183 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:82:0x015c A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:83:0x01b3 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:84:0x018c A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:85:0x01ea A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:86:0x01c1 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:87:0x021d A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:88:0x01f6 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:89:0x02a3 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:90:0x0263 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:91:0x02ec A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:92:0x02da A[SYNTHETIC] */
            /* JADX WARN: Instruction removed from duplicated block: B:47:0x0237, please report this as an issue */
            @Override // java.lang.Runnable
            public void run() {
                PluginModel pluginModel;
                PluginModel pluginModel2;
                byte[] bArrDecode;
                JSONObject jSONObject;
                JSONObject jSONObject2;
                String string;
                ArrayList arrayList;
                String string2 = "undefine";
                String templateId = "undefine";
                for (Object obj : jSONArray) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        string2 = jSONObject3.getString("appId");
                        String string3 = jSONObject3.getString("pluginData");
                        if (TextUtils.isEmpty(string3)) {
                            RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 插件信息为空" + jSONObject3.toJSONString());
                            PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -11, "插件信息为空", aVar);
                        } else if (jSONObject3.getLongValue("validTime") < System.currentTimeMillis()) {
                            RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 插件信息已过期:" + jSONObject3.toJSONString());
                            PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -6, "插件信息已过期", aVar);
                        } else {
                            String string4 = jSONObject3.getString("relationType");
                            String string5 = jSONObject3.getString("relationId");
                            if (NativeCallContext.DOMAIN_APP.equals(string4)) {
                                if (TextUtils.equals(appId, string5)) {
                                    if (PluginBridgeExtension.skipPluginSign()) {
                                        RVLogger.d(PluginBridgeExtension.f24751a, "plugin " + string2 + " skip sign checking!");
                                    } else {
                                        jSONObject = jSONObject3.getJSONObject("signMap");
                                        if (jSONObject == null) {
                                            RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                            PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                        } else {
                                            jSONObject2 = jSONObject.getJSONObject("triver");
                                            if (jSONObject2 == null) {
                                                RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                                PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                            } else if ("aes128".equals(jSONObject2.getString("signMethod"))) {
                                                string = jSONObject2.getString(UserTrackConstant.SIGN);
                                                if (TextUtils.isEmpty(string)) {
                                                    RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                                    PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                                } else {
                                                    Set<String> setKeySet = jSONObject3.keySet();
                                                    setKeySet.remove("signMap");
                                                    List<String> listA = g.a(setKeySet);
                                                    arrayList = new ArrayList();
                                                    for (String str : listA) {
                                                        arrayList.add(str + "=" + jSONObject3.get(str));
                                                    }
                                                    if (!TextUtils.equals(string, g.a(arrayList))) {
                                                        RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 签名校验失败");
                                                        PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "签名校验失败", aVar);
                                                    }
                                                }
                                            } else {
                                                RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 不能识别的签名类型");
                                                PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "不能识别的签名类型", aVar);
                                            }
                                        }
                                    }
                                    pluginModel = null;
                                    try {
                                        bArrDecode = Base64.decode(string3, 2);
                                        if (bArrDecode != null && bArrDecode.length > 0) {
                                            pluginModel = (PluginModel) JSON.parseObject(new String(bArrDecode, "utf-8"), PluginModel.class);
                                        }
                                    } catch (Exception unused) {
                                        RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 插件对象解析失败");
                                    }
                                    pluginModel2 = pluginModel;
                                    if (pluginModel2 == null) {
                                        PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -13, "插件信息解析失败", aVar);
                                    } else {
                                        PluginInfoCenter.a(pluginModel2);
                                        PluginBridgeExtension.this.a(string2, pluginModel2, app, jCurrentTimeMillis, aVar);
                                    }
                                } else {
                                    RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " relationId is " + string5);
                                    PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -9, "appId校验失败", aVar);
                                }
                            } else if ("template".equals(string4)) {
                                AppModel appModel = (AppModel) app.getData(AppModel.class);
                                if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                                    templateId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
                                }
                                if (TextUtils.equals(templateId, string5)) {
                                    if (PluginBridgeExtension.skipPluginSign()) {
                                        jSONObject = jSONObject3.getJSONObject("signMap");
                                        if (jSONObject == null) {
                                            RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                            PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                        } else {
                                            jSONObject2 = jSONObject.getJSONObject("triver");
                                            if (jSONObject2 == null) {
                                                RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                                PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                            } else if ("aes128".equals(jSONObject2.getString("signMethod"))) {
                                                RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 不能识别的签名类型");
                                                PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "不能识别的签名类型", aVar);
                                            } else {
                                                string = jSONObject2.getString(UserTrackConstant.SIGN);
                                                if (TextUtils.isEmpty(string)) {
                                                    RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 未找到签名信息");
                                                    PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "未找到签名信息", aVar);
                                                } else {
                                                    Set<String> setKeySet2 = jSONObject3.keySet();
                                                    setKeySet2.remove("signMap");
                                                    List<String> listA2 = g.a(setKeySet2);
                                                    arrayList = new ArrayList();
                                                    while (r7.hasNext()) {
                                                        arrayList.add(str + "=" + jSONObject3.get(str));
                                                    }
                                                    if (!TextUtils.equals(string, g.a(arrayList))) {
                                                        RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " 签名校验失败");
                                                        PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -12, "签名校验失败", aVar);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        RVLogger.d(PluginBridgeExtension.f24751a, "plugin " + string2 + " skip sign checking!");
                                    }
                                    pluginModel = null;
                                    bArrDecode = Base64.decode(string3, 2);
                                    if (bArrDecode != null) {
                                        pluginModel = (PluginModel) JSON.parseObject(new String(bArrDecode, "utf-8"), PluginModel.class);
                                    }
                                    pluginModel2 = pluginModel;
                                    if (pluginModel2 == null) {
                                        PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -13, "插件信息解析失败", aVar);
                                    } else {
                                        PluginInfoCenter.a(pluginModel2);
                                        PluginBridgeExtension.this.a(string2, pluginModel2, app, jCurrentTimeMillis, aVar);
                                    }
                                } else {
                                    RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " relationId is " + string5);
                                    PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -10, "templateId校验失败", aVar);
                                }
                            } else {
                                RVLogger.e(PluginBridgeExtension.f24751a, "plugin " + string2 + " relationType is " + string4);
                                PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -8, "未知的relationType", aVar);
                            }
                        }
                    } else {
                        PluginBridgeExtension.this.a(string2, jCurrentTimeMillis, -1, "本地化插件信息异常", aVar);
                    }
                }
            }
        };
        RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        if (rVExecutorService != null) {
            rVExecutorService.getExecutor(ExecutorType.NETWORK).execute(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final PluginModel pluginModel, final App app, final long j, final a aVar) {
        final RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
        if (pluginModel == null) {
            a(str, j, -4, "插件信息为空", aVar);
            return;
        }
        RVLogger.e("PluginBridgeExtension", Thread.currentThread().getId() + " get pluginModel : " + pluginModel.getAppId());
        if (!rVPluginResourceManager.isAvailable(Collections.singletonList(pluginModel))) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            rVPluginResourceManager.downloadPlugins(Collections.singletonList(pluginModel), new PluginDownloadCallback() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.3
                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onFailed(int i, String str2) {
                    PluginBridgeExtension.this.a(str, j, -2, PluginBridgeExtension.ERROR_PLUGIN_DOWNLOAD_TEXT, aVar);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onSingleFailed(PluginModel pluginModel2, int i, String str2) {
                }

                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onSuccess() {
                    RVLogger.e("PluginBridgeExtension", Thread.currentThread().getId() + " download success : " + pluginModel.getAppId());
                    rVPluginResourceManager.installPlugins(Collections.singletonList(pluginModel), new PluginInstallCallback() { // from class: com.alibaba.triver.bridge.PluginBridgeExtension.3.1
                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onFailed(int i, String str2) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            PluginBridgeExtension.this.a(str, j, -3, PluginBridgeExtension.ERROR_PLUGIN_INSTALL_TEXT, aVar);
                            countDownLatch.countDown();
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSingleFailed(PluginModel pluginModel2, int i, String str2) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSuccess(List<Pair<PluginModel, String>> list) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            if (PluginBridgeExtension.this.a(pluginModel, app)) {
                                RVLogger.e("PluginBridgeExtension", Thread.currentThread().getId() + " install success pluginModel : " + pluginModel.getAppId());
                                AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                PluginBridgeExtension.this.a(str, j, aVar);
                            } else {
                                AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                PluginBridgeExtension.this.a(str, j, -4, PluginBridgeExtension.ERROR_PLUGIN_LOAD_TEXT, aVar);
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            });
            try {
                countDownLatch.await();
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (a(pluginModel, app)) {
            a(str, j, aVar);
        } else {
            a(str, j, -4, ERROR_PLUGIN_LOAD_TEXT, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PluginModel pluginModel, App app) {
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(app.getAppId());
        ResourcePackage resourcePackageCreatePluginPackage = ((PackageQueryPoint) ExtensionPoint.as(PackageQueryPoint.class).node(app).create()).createPluginPackage(pluginModel, resourceContext);
        if (resourcePackageCreatePluginPackage == null) {
            return false;
        }
        ResourcePackagePool.getInstance().attach(resourcePackageCreatePluginPackage);
        resourceContext.attachResourcePackage(pluginModel.getAppId());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, a aVar) {
        if (aVar != null) {
            aVar.a(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, int i, String str2, a aVar) {
        if (aVar != null) {
            aVar.a(str, j, i, str2);
        }
    }
}
