package com.alibaba.ariver;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<String> f23929a;
    private static List<String> b;

    public static synchronized Set<String> a() {
        if (f23929a == null) {
            HashSet hashSet = new HashSet();
            f23929a = hashSet;
            hashSet.add(JSApiCachePoint.GET_SYSTEM_INFO);
            f23929a.add("setAPDataStorage");
            f23929a.add("getAPDataStorage");
            f23929a.add("removeAPDataStorage");
            f23929a.add("clearAPDataStorage");
            f23929a.add("setTinyLocalStorage");
            f23929a.add(JSApiCachePoint.GET_LOCAL_STORAGE);
            f23929a.add("removeTinyLocalStorage");
            f23929a.add("clearTinyLocalStorage");
            f23929a.add("getTinyLocalStorageInfo");
            f23929a.add("getStartupParams");
            f23929a.add("internalAPI");
            f23929a.add("measureText");
            f23929a.add("getBackgroundAudioOption");
            f23929a.add("getForegroundAudioOption");
            f23929a.add("NBComponent.sendMessage");
            f23929a.add("getBatteryInfo");
            f23929a.add("tyroRequest");
            f23929a.add("bindUDPSocket");
            f23929a.add("getPermissionConfig");
        }
        return f23929a;
    }

    public static synchronized List<String> b() {
        if (b == null) {
            List<String> listC = c();
            if (listC != null) {
                b = listC;
            } else {
                ArrayList arrayList = new ArrayList();
                b = arrayList;
                arrayList.add(JSApiCachePoint.GET_SYSTEM_INFO);
                b.add("remoteLog");
                b.add(com.alibaba.ariver.permission.b.m);
                b.add("request");
                b.add("pageMonitor");
                b.add("reportData");
                b.add("getAuthCode");
                b.add("setTinyLocalStorage");
                b.add(JSApiCachePoint.GET_LOCAL_STORAGE);
                b.add("removeTinyLocalStorage");
                b.add("trackerConfig");
                b.add("configService.getConfig");
                b.add("getAuthUserInfo");
                b.add("localLog");
            }
        }
        return b;
    }

    private static List<String> c() {
        JSONArray configJSONArray;
        try {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (rVConfigService != null && (configJSONArray = rVConfigService.getConfigJSONArray("h5_worker_not_ui_dispatch_list")) != null && !configJSONArray.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < configJSONArray.size(); i++) {
                    arrayList.add(configJSONArray.getString(i));
                }
                return arrayList;
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e("WorkerApiConfig", "getNotUIDispatchList error", th);
        }
        return null;
    }
}
