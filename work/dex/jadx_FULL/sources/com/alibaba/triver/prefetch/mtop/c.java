package com.alibaba.triver.prefetch.mtop;

import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25118a = "MtopRequestCache";
    private static ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    private static LruCache<String, Pair<RequestParams, String>> c = new LruCache<>(20);
    private static LruCache<String, Pair<Long, Long>> d = new LruCache<>(20);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RequestParams f25119a;
        private final ReentrantLock b = new ReentrantLock();

        public a(RequestParams requestParams) {
            this.f25119a = requestParams;
        }
    }

    public static void a(RequestParams requestParams) {
        a aVar;
        if (requestParams == null || TextUtils.isEmpty(requestParams.api)) {
            return;
        }
        if (b.containsKey(requestParams.api)) {
            aVar = b.get(requestParams.api);
        } else {
            a aVar2 = new a(requestParams);
            b.put(requestParams.api, aVar2);
            aVar = aVar2;
        }
        aVar.b.lock();
        RVLogger.d(f25118a, "start prefetch lock!");
    }

    private static void b(String str, String str2, Map<String, String> map) {
        a aVar = b.get(str);
        if (aVar != null && aVar.b.isLocked() && a(str, str2, map, aVar.f25119a, null)) {
            try {
                RVLogger.d(f25118a, "hit prefetch try lock 3s!");
                if (aVar.b.tryLock(3L, TimeUnit.SECONDS)) {
                    aVar.b.unlock();
                }
            } catch (InterruptedException e) {
                RVLogger.e(f25118a, e.getMessage());
            }
        }
    }

    private static boolean b(String str) {
        Pair<Long, Long> pair;
        if (str == null || (pair = d.get(str)) == null) {
            return false;
        }
        try {
            return System.currentTimeMillis() - ((Long) pair.second).longValue() <= ((Long) pair.first).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void a(String str) {
        a aVarRemove = b.remove(str);
        if (aVarRemove == null || !aVarRemove.b.isLocked()) {
            return;
        }
        aVarRemove.b.unlock();
        RVLogger.d(f25118a, "end prefetch unlock!");
    }

    public static void a(RequestParams requestParams, String str, long j) {
        if (requestParams == null || requestParams.api == null || str == null) {
            return;
        }
        c.put(requestParams.api, new Pair<>(requestParams, str));
        d.put(requestParams.api, new Pair<>(Long.valueOf(a(j)), Long.valueOf(System.currentTimeMillis())));
    }

    public static String a(String str, String str2, Map<String, String> map) {
        if (str2 != null && map != null) {
            b(str, str2, map);
            Pair<RequestParams, String> pair = c.get(str);
            if (pair == null) {
                RVLogger.e(f25118a, String.format("mtop request cache not exits, api %s", str));
                return null;
            }
            if (!b(str)) {
                c.remove(str);
                d.remove(str);
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("MtopCache", "mtop cache is empty or timeout");
                return null;
            }
            if (a(str, str2, map, (RequestParams) pair.first, (RVLogger.Proxy) RVProxy.get(RVLogger.Proxy.class))) {
                RVLogger.e(f25118a, "mtop request cache hit ! api : " + str + " version : " + str2);
                return (String) pair.second;
            }
        }
        return null;
    }

    private static boolean a(String str, String str2, Map<String, String> map, RequestParams requestParams, RVLogger.Proxy proxy) {
        Throwable th = null;
        if (requestParams == null) {
            if (proxy != null) {
                proxy.e(f25118a, String.format("mtop request cache param not exits, api %s", str), null);
            }
            return false;
        }
        if (!str.equals(requestParams.api)) {
            return false;
        }
        String str3 = requestParams.version;
        if (!str2.equals(str3)) {
            if (proxy != null) {
                proxy.e(f25118a, String.format("mtop request cache version not equal, api %s: request %s | cache %s", str, str2, str3), null);
            }
            return false;
        }
        List<String> list = requestParams.ignoreParams;
        Map<String, Object> map2 = requestParams.toMap();
        if (map2 == null) {
            if (proxy != null) {
                proxy.e(f25118a, String.format("mtop request cache param is null, api %s", str), null);
            }
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (list == null || !list.contains(entry.getKey())) {
                if (!map2.containsKey(entry.getKey())) {
                    if (proxy != null) {
                        proxy.e(f25118a, String.format("mtop request cache keys not match, api %s, key %s: request %s | cache %s", str, entry.getKey(), map, map2), th);
                    }
                    return false;
                }
                String value = entry.getValue();
                Object obj = map2.get(entry.getKey());
                if (!(obj instanceof String)) {
                    if (proxy != null) {
                        proxy.e(f25118a, String.format("mtop request cache value not string, api %s, kv %s.%s: request %s | cache %s", str, entry.getKey(), entry.getValue(), map, map2), null);
                    }
                    return false;
                }
                if (!a(value, (String) obj, list)) {
                    try {
                        RVLogger.e("target value=" + value + ", cached value=" + obj + "ignore params=" + StringUtils.array2String(list.toArray()));
                    } catch (Throwable unused) {
                    }
                    if (proxy != null) {
                        proxy.e(f25118a, String.format("mtop request cache value not match, api %s, kv %s.%s: request %s | cache %s", str, entry.getKey(), entry.getValue(), map, map2), null);
                    }
                    return false;
                }
                th = null;
            } else if (proxy != null) {
                proxy.d(f25118a, String.format("mtop request cache ignore this param, api %s: key %s", str, entry.getKey()));
            }
        }
        return true;
    }

    private static boolean a(String str, String str2, List<String> list) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        try {
            JSONObject object = JSON.parseObject(str);
            JSONObject object2 = JSON.parseObject(str2);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (String str3 : object.keySet()) {
                if (!TextUtils.isEmpty(str3) && (list == null || !list.contains(str3))) {
                    map.put(str3, object.getString(str3));
                }
            }
            for (String str4 : object2.keySet()) {
                if (!TextUtils.isEmpty(str4) && (list == null || !list.contains(str4))) {
                    map2.put(str4, object2.getString(str4));
                }
            }
            if (map.size() != map2.size()) {
                return false;
            }
            for (String str5 : map.keySet()) {
                if (!TextUtils.isEmpty(str5) && !a((String) map.get(str5), (String) map2.get(str5), list)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static long a(long j) {
        long mtopCacheTimeoutBySecond = TROrangeController.getMtopCacheTimeoutBySecond() * 1000;
        return j > mtopCacheTimeoutBySecond ? mtopCacheTimeoutBySecond : j;
    }
}
