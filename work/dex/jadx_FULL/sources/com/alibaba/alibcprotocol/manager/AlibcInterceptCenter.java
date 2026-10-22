package com.alibaba.alibcprotocol.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.route.RequestFactory;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcInterceptCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23613a = "AlibcInterceptCenter";
    private static final Map<String, IUrlInterceptor> b = new ConcurrentHashMap();

    public interface IUrlInterceptor {
        boolean interceptor(RouteRequest routeRequest, Bundle bundle);
    }

    public static synchronized void registerInterceptor(String str, String str2) {
        try {
            Map<String, IUrlInterceptor> map = b;
            if (map.isEmpty() || map.get(str) == null) {
                Class<?> cls = Class.forName(str2);
                if (IUrlInterceptor.class.isAssignableFrom(cls)) {
                    map.put(str, (IUrlInterceptor) cls.newInstance());
                }
            } else {
                AlibcLogger.i(f23613a, "interceptor " + str + " has been registered");
            }
        } catch (Exception e) {
            AlibcLogger.e(f23613a, "get class exception: " + e.getMessage());
        }
    }

    public static synchronized boolean shouldInterceptToLaunch(String str, Bundle bundle, final String str2) {
        RouteRequest routeRequestBuildRequest = RequestFactory.buildRequest(new RouteRequest(str, ""), AlibcTradeContext.getInstance().bizParams, new RouteRequestCallback() { // from class: com.alibaba.alibcprotocol.manager.AlibcInterceptCenter.2
            @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
            public final void onBuildComplete(String str3) {
                AlibcLogger.i(AlibcInterceptCenter.f23613a, "build request complete");
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_OPEN_INTERCEPT, "", "", new JSONObject());
            }

            @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
            public final void onBuildFail(int i, String str3) {
                AlibcLogger.e(AlibcInterceptCenter.f23613a, "build request fail: code = " + i + ", msg = " + str3);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.ERROR_TYPE, (Object) str2);
                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_INTERCEPT, String.valueOf(i), str3, jSONObject);
            }
        });
        if (routeRequestBuildRequest == null || TextUtils.isEmpty(routeRequestBuildRequest.getRawUrl()) || !AlibcProtocolUtils.checkNative(routeRequestBuildRequest)) {
            return false;
        }
        for (Map.Entry<String, IUrlInterceptor> entry : b.entrySet()) {
            if (entry != null && "applink_sdk".equals(entry.getKey())) {
                AlibcLogger.i(f23613a, "execute applink");
                entry.getValue().interceptor(routeRequestBuildRequest, bundle);
            }
        }
        return true;
    }

    public static synchronized boolean shouldOverrideLoading(String str) {
        boolean zInterceptor;
        RouteRequest routeRequestBuildRequest = RequestFactory.buildRequest(new RouteRequest(str, ""), AlibcTradeContext.getInstance().bizParams, new RouteRequestCallback() { // from class: com.alibaba.alibcprotocol.manager.AlibcInterceptCenter.1
            @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
            public final void onBuildComplete(String str2) {
                AlibcLogger.i(AlibcInterceptCenter.f23613a, "build request complete");
            }

            @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
            public final void onBuildFail(int i, String str2) {
                AlibcLogger.e(AlibcInterceptCenter.f23613a, "build request fail: code = " + i + ", msg = " + str2);
            }
        });
        zInterceptor = false;
        if (routeRequestBuildRequest != null && !TextUtils.isEmpty(routeRequestBuildRequest.getRawUrl())) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, IUrlInterceptor> entry : b.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    if ("applink_sdk".equals(key)) {
                        arrayList.add(0, key);
                    } else {
                        arrayList.add(key);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IUrlInterceptor iUrlInterceptor = b.get((String) it.next());
                if (iUrlInterceptor != null && (zInterceptor = iUrlInterceptor.interceptor(routeRequestBuildRequest, null))) {
                    break;
                }
            }
        }
        return zInterceptor;
    }

    public static synchronized void unRegisterInterceptor(String str) {
        Map<String, IUrlInterceptor> map = b;
        if (!map.isEmpty()) {
            AlibcLogger.i(f23613a, "interceptor " + str + " has been unregistered");
            map.remove(str);
        }
    }
}
