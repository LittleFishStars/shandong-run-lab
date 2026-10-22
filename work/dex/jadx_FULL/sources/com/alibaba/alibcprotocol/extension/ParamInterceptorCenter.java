package com.alibaba.alibcprotocol.extension;

import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamInterceptorCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23609a = "ParamInterceptorCenter";
    private static final Map<String, a> b = new ConcurrentHashMap();

    public static synchronized String interceptParams(String str, Map<String, Object> map) {
        String strHandleParams;
        strHandleParams = str;
        for (Map.Entry<String, a> entry : b.entrySet()) {
            if (entry != null) {
                strHandleParams = entry.getValue().handleParams(str, map);
            }
        }
        return strHandleParams;
    }

    public static synchronized void registerInterceptor(String str, String str2) {
        try {
            Map<String, a> map = b;
            if (map.isEmpty() || map.get(str) == null) {
                Class<?> cls = Class.forName(str2);
                if (a.class.isAssignableFrom(cls)) {
                    map.put(str, (a) cls.newInstance());
                }
            } else {
                AlibcLogger.i(f23609a, "interceptor " + str + " has been registered");
            }
        } catch (Exception e) {
            AlibcLogger.e(f23609a, "get class exception: " + e.getMessage());
        }
    }

    public static synchronized void unRegisterInterceptor(String str) {
        Map<String, a> map = b;
        if (!map.isEmpty()) {
            AlibcLogger.i(f23609a, "interceptor " + str + " has been unregistered");
            map.remove(str);
        }
    }
}
