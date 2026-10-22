package com.alibaba.triver.appinfo.core;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.channel.AppInfoResult;
import com.alibaba.triver.appinfo.channel.TriverAppModel;
import com.alibaba.triver.appinfo.storage.AppInfoDao;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.error.TriverErrors;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.SPUtils;
import com.amap.api.maps.model.MyLocationStyle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoCenterInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f24637a = 86400;
    public static Map<String, String> b = new HashMap();
    public static final long c = 1800;
    private static final String d = "AppInfoCenter";

    public static class LoadTime implements Serializable {
        public long maxAsyncSeconds;
        public long maxSyncSeconds;
    }

    @WorkerThread
    public void a(long j, long j2) {
        if (j < 0) {
            j = f24637a;
        }
        if (j2 < 0) {
            j2 = c;
        }
        AcceleratorConfig acceleratorConfigC = com.alibaba.triver.appinfo.storage.b.a().c();
        if (acceleratorConfigC == null) {
            acceleratorConfigC = new AcceleratorConfig();
        }
        acceleratorConfigC.maxAsyncTime = j2 * 1000;
        acceleratorConfigC.maxSyncTime = 1000 * j;
        com.alibaba.triver.appinfo.storage.b.a().a(acceleratorConfigC);
        RVLogger.d("AppInfoCenter", "set maxSyncDataSec to " + j + " set maxAsyncDataSec to " + j2);
    }

    @WorkerThread
    public void b(AppRequestParams appRequestParams, a aVar) {
        AppInfoClient appInfoClient = (AppInfoClient) RVProxy.get(AppInfoClient.class);
        if (appInfoClient == null) {
            TriverErrors triverErrors = TriverErrors.AI_SYSTEM_ERROR;
            aVar.a("default", triverErrors.errorCode, InternationalUtil.getString(triverErrors.errorMsgResId), null);
            return;
        }
        AppInfoResult appInfoResultRequestAppInfo = appInfoClient.requestAppInfo(appRequestParams);
        if (appInfoResultRequestAppInfo == null) {
            TriverErrors triverErrors2 = TriverErrors.AI_EMPTY_REQUEST_APP;
            aVar.a("default", triverErrors2.errorCode, InternationalUtil.getString(triverErrors2.errorMsgResId), null);
            RVLogger.d("AppInfoCenter", "requestAppInfo error!");
            return;
        }
        List<TriverAppModel> list = appInfoResultRequestAppInfo.data;
        if (list == null || list.isEmpty()) {
            String str = appInfoResultRequestAppInfo.channel;
            TriverErrors triverErrors3 = TriverErrors.AI_EMPTY_REQUEST_APP;
            aVar.a(str, triverErrors3.errorCode, InternationalUtil.getString(triverErrors3.errorMsgResId), null);
            RVLogger.d("AppInfoCenter", "requestAppInfo error!");
            return;
        }
        String str2 = (String) appRequestParams.mainRequest.first;
        try {
            RVLogger.d("AppInfoCenter", (CommonUtils.isApkDebug() ? JSON.toJSONString(appRequestParams) : str2) + " requestAppInfo finish!");
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "log error", e);
        }
        ArrayList arrayList = new ArrayList();
        TriverAppModel triverAppModel = null;
        for (TriverAppModel triverAppModel2 : list) {
            arrayList.add(triverAppModel2);
            if (str2.equals(triverAppModel2.getAppId())) {
                triverAppModel = triverAppModel2;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            aVar.a(appInfoResultRequestAppInfo.channel, arrayList);
            return;
        }
        if (triverAppModel == null) {
            String str3 = appInfoResultRequestAppInfo.channel;
            TriverErrors triverErrors4 = TriverErrors.AI_EMPTY_REQUEST_APP;
            aVar.a(str3, triverErrors4.errorCode, InternationalUtil.getString(triverErrors4.errorMsgResId), null);
        } else {
            if (a(triverAppModel)) {
                aVar.a(appInfoResultRequestAppInfo.channel, arrayList);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MyLocationStyle.ERROR_INFO, (Object) triverAppModel.errorInfo);
            jSONObject.put("buttonText", (Object) triverAppModel.buttonText);
            jSONObject.put("buttonUrl", (Object) triverAppModel.buttonUrl);
            jSONObject.put("errorLogo", (Object) triverAppModel.errorLogo);
            jSONObject.put("errorSubInfo", (Object) triverAppModel.errorSubInfo);
            jSONObject.put("downgradeUrl", (Object) triverAppModel.downgradeUrl);
            jSONObject.put("guideTip", (Object) triverAppModel.guideTip);
            jSONObject.put("guideTipUrl", (Object) triverAppModel.guideTipUrl);
            jSONObject.put("buttonType", (Object) triverAppModel.buttonType);
            aVar.a(appInfoResultRequestAppInfo.channel, triverAppModel.errorCode, triverAppModel.errorMsg, jSONObject);
        }
    }

    @WorkerThread
    public void a(List<AcceleratorConfig.ConfigItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        AcceleratorConfig acceleratorConfigC = com.alibaba.triver.appinfo.storage.b.a().c();
        if (acceleratorConfigC == null) {
            acceleratorConfigC = new AcceleratorConfig();
        }
        List<AcceleratorConfig.ConfigItem> list2 = acceleratorConfigC.important;
        if (list2 != null && !list2.isEmpty()) {
            HashMap map = new HashMap();
            for (AcceleratorConfig.ConfigItem configItem : list2) {
                if (configItem != null) {
                    map.put(configItem.appId, configItem);
                }
            }
            for (AcceleratorConfig.ConfigItem configItem2 : list) {
                AcceleratorConfig.ConfigItem configItem3 = (AcceleratorConfig.ConfigItem) map.get(configItem2.appId);
                if (configItem3 != null && !configItem3.expired) {
                    if (configItem3.timeStamp != configItem2.timeStamp) {
                        configItem2.expired = true;
                        RVLogger.d("AppInfoCenter", "appId:" + configItem3.appId + " expired!");
                    } else {
                        configItem2.expired = false;
                    }
                }
            }
            acceleratorConfigC.important = list;
        } else {
            acceleratorConfigC.important = list;
        }
        com.alibaba.triver.appinfo.storage.b.a().a(acceleratorConfigC);
        RVLogger.d("AppInfoCenter", "setImportantConfig finish!");
    }

    @WorkerThread
    public void a() {
        AppInfoClient appInfoClient;
        AcceleratorConfig acceleratorConfigC = com.alibaba.triver.appinfo.storage.b.a().c();
        if (acceleratorConfigC == null || acceleratorConfigC.important == null) {
            return;
        }
        HashMap map = new HashMap();
        for (AcceleratorConfig.ConfigItem configItem : acceleratorConfigC.important) {
            if (configItem.expired) {
                map.put(configItem.appId, configItem);
            }
        }
        if (!map.isEmpty()) {
            Set setKeySet = map.keySet();
            HashMap map2 = new HashMap();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                map2.put((String) it.next(), "*");
            }
            if (map2.isEmpty() || (appInfoClient = (AppInfoClient) RVProxy.get(AppInfoClient.class)) == null) {
                return;
            }
            AppRequestParams appRequestParams = new AppRequestParams();
            appRequestParams.extRequest = map2;
            AppInfoResult appInfoResultRequestAppInfo = appInfoClient.requestAppInfo(appRequestParams);
            if (appInfoResultRequestAppInfo == null) {
                RVLogger.d("AppInfoCenter", "dataSync requestAppInfo error!");
                return;
            }
            List<TriverAppModel> list = appInfoResultRequestAppInfo.data;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TriverAppModel triverAppModel : list) {
                    if (triverAppModel.success) {
                        AcceleratorConfig.ConfigItem configItem2 = (AcceleratorConfig.ConfigItem) map.get(triverAppModel.getAppInfoModel().getAppId());
                        if (configItem2 != null) {
                            configItem2.expired = false;
                        }
                        AppInfoDao appInfoDao = new AppInfoDao();
                        appInfoDao.appId = triverAppModel.getAppInfoModel().getAppId();
                        appInfoDao.appInfo = triverAppModel;
                        appInfoDao.lastRequestTimeStamp = System.currentTimeMillis();
                        appInfoDao.version = triverAppModel.getAppVersion();
                        arrayList.add(appInfoDao);
                    }
                }
                if (!arrayList.isEmpty()) {
                    com.alibaba.triver.appinfo.storage.b.a().a(arrayList);
                    com.alibaba.triver.appinfo.storage.b.a().a(acceleratorConfigC);
                }
                RVLogger.d("AppInfoCenter", "dataSync finish!");
                return;
            }
            RVLogger.d("AppInfoCenter", "dataSync requestAppInfo error!");
            return;
        }
        RVLogger.d("AppInfoCenter", "need not dataSync!");
    }

    @WorkerThread
    public void b() {
        Map<String, String> map = b;
        if (map != null) {
            map.clear();
        }
        com.alibaba.triver.appinfo.storage.b.a().b((List<String>) null);
    }

    @WorkerThread
    public AppInfoStrategy a(String str, String str2) {
        AcceleratorConfig.ConfigItem importantConfig;
        long jCurrentTimeMillis;
        long j;
        com.alibaba.triver.appinfo.storage.b bVarA = com.alibaba.triver.appinfo.storage.b.a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "*";
        }
        AppInfoDao appInfoDaoA = bVarA.a(str, str2);
        if (appInfoDaoA != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - 86400000;
            long jCurrentTimeMillis3 = System.currentTimeMillis() - 1800000;
            AcceleratorConfig acceleratorConfigC = com.alibaba.triver.appinfo.storage.b.a().c();
            if (acceleratorConfigC != null) {
                jCurrentTimeMillis2 = System.currentTimeMillis() - acceleratorConfigC.getMaxSyncTime();
                jCurrentTimeMillis3 = System.currentTimeMillis() - acceleratorConfigC.getMaxAsyncTime();
                LoadTime loadTimeA = a(appInfoDaoA.appInfo);
                importantConfig = com.alibaba.triver.appinfo.storage.b.a().c().getImportantConfig(str);
                LoadTime loadTimeA2 = a(str);
                if (loadTimeA2 != null) {
                    loadTimeA = loadTimeA2;
                }
                if (loadTimeA != null) {
                    jCurrentTimeMillis2 = System.currentTimeMillis() - (loadTimeA.maxSyncSeconds * 1000);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j = loadTimeA.maxAsyncSeconds;
                    jCurrentTimeMillis3 = jCurrentTimeMillis - (j * 1000);
                }
            } else {
                LoadTime loadTimeA3 = a(appInfoDaoA.appInfo);
                importantConfig = null;
                if (loadTimeA3 != null) {
                    jCurrentTimeMillis2 = System.currentTimeMillis() - (loadTimeA3.maxSyncSeconds * 1000);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j = loadTimeA3.maxAsyncSeconds;
                    jCurrentTimeMillis3 = jCurrentTimeMillis - (j * 1000);
                }
            }
            if (importantConfig != null && importantConfig.expired) {
                AppInfoStrategy strategy = AppInfoStrategy.getStrategy(importantConfig.strategy);
                AppInfoStrategy appInfoStrategy = AppInfoStrategy.SYNC_LOAD;
                if (strategy == appInfoStrategy) {
                    RVLogger.d("AppInfoCenter", str + " important app local cache expired, strategy syncLoad!");
                    return appInfoStrategy;
                }
                RVLogger.d("AppInfoCenter", str + " important app local cache expired, strategy asyncLoad.");
                return AppInfoStrategy.ASYNC_LOAD;
            }
            long j2 = appInfoDaoA.lastRequestTimeStamp;
            if (j2 <= jCurrentTimeMillis2) {
                RVLogger.d("AppInfoCenter", str + " local cache over maxSyncTime, syncLoad strategy.");
                return AppInfoStrategy.SYNC_LOAD;
            }
            if (j2 > jCurrentTimeMillis3) {
                RVLogger.d("AppInfoCenter", str + " local cache can be used.");
                return AppInfoStrategy.NONE;
            }
            RVLogger.d("AppInfoCenter", str + " local cache over maxASyncTime, asyncLoad strategy!");
            return AppInfoStrategy.ASYNC_LOAD;
        }
        RVLogger.d("AppInfoCenter", str + " no appInfo in local cache! strategy syncLoad.");
        return AppInfoStrategy.SYNC_LOAD;
    }

    @WorkerThread
    public AppModel a(String str, String str2, String str3) {
        com.alibaba.triver.appinfo.storage.b bVarA = com.alibaba.triver.appinfo.storage.b.a();
        if (TextUtils.isEmpty(str3)) {
            str3 = "*";
        }
        AppInfoDao appInfoDaoA = bVarA.a(str2, str3);
        if (appInfoDaoA != null) {
            if (appInfoDaoA.appInfo == null || !(TextUtils.isEmpty(appInfoDaoA.type) || appInfoDaoA.type.equals(str))) {
                return null;
            }
            if (!TextUtils.isEmpty(appInfoDaoA.type) && !appInfoDaoA.type.equals(str)) {
                RVLogger.d("AppInfoCenter", str2 + " getAppInfo success but type is " + appInfoDaoA.type);
                return null;
            }
            return appInfoDaoA.appInfo;
        }
        if (b.containsKey(str2)) {
            try {
                AppModel appModel = (AppModel) JSON.parseObject(b.get(str2), AppModel.class);
                if (appModel != null) {
                    AppInfoDao appInfoDao = new AppInfoDao();
                    appInfoDao.appId = appModel.getAppId();
                    appInfoDao.appInfo = appModel;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    appInfoDao.lastRequestTimeStamp = jCurrentTimeMillis;
                    appInfoDao.lastUsedTimeStamp = jCurrentTimeMillis;
                    appInfoDao.version = appModel.getAppVersion();
                    com.alibaba.triver.appinfo.storage.b.a().a(appInfoDao);
                    return appModel;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @WorkerThread
    public void a(long j) {
        ArrayList arrayList;
        long j2 = SPUtils.readLong("lastClearTimeStamp", -1L);
        if (j2 == -1) {
            SPUtils.writeLong("lastClearTimeStamp", System.currentTimeMillis());
            return;
        }
        long j3 = j * 1000;
        if (j2 < System.currentTimeMillis() - j3) {
            if (com.alibaba.triver.appinfo.storage.b.a().c() != null && com.alibaba.triver.appinfo.storage.b.a().c().important != null) {
                List<AcceleratorConfig.ConfigItem> list = com.alibaba.triver.appinfo.storage.b.a().c().important;
                arrayList = new ArrayList();
                Iterator<AcceleratorConfig.ConfigItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().appId);
                }
            } else {
                arrayList = new ArrayList();
            }
            arrayList.add(RVConstants.TINY_WEB_COMMON_APPID);
            com.alibaba.triver.appinfo.storage.b.a().a(j3, arrayList);
            SPUtils.writeLong("lastClearTimeStamp", System.currentTimeMillis());
            RVLogger.d("AppInfoCenter", "clearUnusedCache finish!");
        }
    }

    public void a(final AppRequestParams appRequestParams, final a aVar) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.triver.appinfo.core.AppInfoCenterInternal.1
            @Override // java.lang.Runnable
            public void run() {
                AppInfoCenterInternal.this.b(appRequestParams, new a() { // from class: com.alibaba.triver.appinfo.core.AppInfoCenterInternal.1.1
                    @Override // com.alibaba.triver.appinfo.core.a
                    public void a(String str, List<AppModel> list) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(str, list);
                        }
                    }

                    @Override // com.alibaba.triver.appinfo.core.a
                    public void a(String str, String str2, String str3, JSONObject jSONObject) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(str, str2, str3, jSONObject);
                        }
                    }
                });
            }
        });
    }

    private boolean a(TriverAppModel triverAppModel) {
        return (triverAppModel == null || !triverAppModel.success || triverAppModel.getAppInfoModel() == null || TextUtils.isEmpty(triverAppModel.getAppInfoModel().getPackageUrl())) ? false : true;
    }

    private LoadTime a(AppModel appModel) {
        JSONObject object;
        if (appModel != null && appModel.getExtendInfos() != null) {
            try {
                String string = appModel.getExtendInfos().getString("bizType");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                String str = "trv_miniapp_biztype_" + string;
                String string2 = appModel.getExtendInfos().getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
                if (!TextUtils.isEmpty(string2)) {
                    str = str + LoginConstants.UNDER_LINE + string2;
                }
                Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
                if (configsByGroup != null) {
                    String str2 = configsByGroup.get(str);
                    if (!TextUtils.isEmpty(str2) && (object = JSON.parseObject(str2)) != null) {
                        long longValue = object.getLongValue("maxSyncTime");
                        long longValue2 = object.getLongValue("maxAsyncTime");
                        LoadTime loadTime = new LoadTime();
                        loadTime.maxSyncSeconds = longValue;
                        loadTime.maxAsyncSeconds = longValue2;
                        return loadTime;
                    }
                }
                return null;
            } catch (Exception e) {
                RVLogger.e("AppInfoCenter", "getLoadTimeByBizType error", e);
            }
        }
        return null;
    }

    private LoadTime a(String str) {
        JSONObject object;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_IMPORTANT_CONFIG);
            if (configsByGroup != null) {
                String str2 = configsByGroup.get(str);
                if (!TextUtils.isEmpty(str2) && (object = JSON.parseObject(str2)) != null) {
                    long longValue = object.getLongValue(c.d);
                    long longValue2 = object.getLongValue(c.c);
                    LoadTime loadTime = new LoadTime();
                    loadTime.maxSyncSeconds = longValue;
                    loadTime.maxAsyncSeconds = longValue2;
                    return loadTime;
                }
            }
            return null;
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", "getLoadTimeByBizType error", e);
            return null;
        }
    }
}
