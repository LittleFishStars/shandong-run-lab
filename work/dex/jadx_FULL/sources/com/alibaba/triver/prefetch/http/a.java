package com.alibaba.triver.prefetch.http;

import android.text.TextUtils;
import androidx.collection.LruCache;
import anetwork.channel.aidl.NetworkResponse;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.cache.FileResourceCache;
import com.alibaba.triver.kit.api.cache.IResourceCache;
import com.alibaba.triver.kit.api.cache.NetworkResourceCache;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.prefetch.a.c;
import com.taobao.android.tschedule.TSchedule;
import com.taobao.android.tschedule.TScheduleHttpCallback;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements com.alibaba.triver.prefetch.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25109a = "HttpPrefetchManager";
    private static volatile a b;

    private a() {
    }

    @Override // com.alibaba.triver.prefetch.a.b
    public void a(c cVar, com.alibaba.triver.prefetch.a.a aVar) {
    }

    @Override // com.alibaba.triver.prefetch.a.b
    public void b(final c cVar, final com.alibaba.triver.prefetch.a.a aVar) {
        try {
            if (!(cVar instanceof com.alibaba.triver.prefetch.http.b)) {
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            final String strA = ((com.alibaba.triver.prefetch.http.b.a) cVar.a()).a();
            if (((com.alibaba.triver.prefetch.http.b) cVar).b() != null ? TRiverUtils.isUrlInPreloadConfig(((com.alibaba.triver.prefetch.http.b) cVar).b().getApp(), strA) : false) {
                RVLogger.d(f25109a, "this url is preload url , will get data from TSchedule , url is : " + strA);
                TSchedule.fetchHttpData(strA, new TScheduleHttpCallback() { // from class: com.alibaba.triver.prefetch.http.HttpPrefetchManager$1
                    public void onError() {
                        this.this$0.a((b) cVar, aVar);
                    }

                    public void onSuccess(Object obj) {
                        if (obj == null || aVar == null) {
                            com.alibaba.triver.prefetch.a.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a();
                                return;
                            }
                            return;
                        }
                        RVLogger.e(a.f25109a, "this url is preload url , will get data from TSchedule success , url is : " + strA);
                        aVar.a(obj);
                    }
                });
                return;
            }
            RVLogger.d(f25109a, "this url is not preload url , will get data from default http cache , url is : " + strA);
            a((com.alibaba.triver.prefetch.http.b) cVar, aVar);
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25111a = "https://alisitecdn.wapa.taobao.com/minidata/shop/index";
        public static final String b = "https://alisitecdn.m.taobao.com/pagedata/shop/index";
        public static final String c = "https://alisitecdn.m.taobao.com/minidata/shop/index2";
        private static long d = 600000;
        private static String e = "shop_page_data_local_cache";
        private static IResourceCache f = NetworkResourceCache.getInstance("shop_page_data_local_cache");
        private static IResourceCache g = FileResourceCache.getInstance();

        public static String a(String str, boolean z) {
            a();
            IResourceCache iResourceCacheA = a(z);
            if (iResourceCacheA == null) {
                return null;
            }
            String strA = a(str);
            String strB = b(str);
            String cache = iResourceCacheA.getCache(strB);
            if (cache == null) {
                return null;
            }
            String cache2 = iResourceCacheA.getCache(strA);
            if (cache2 == null) {
                b(strB, z);
                b(strA, z);
                return null;
            }
            boolean z2 = false;
            try {
                z2 = System.currentTimeMillis() - Long.parseLong(cache2) < d;
                if (!z2) {
                    b(strB, z);
                    b(strA, z);
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (z2) {
                return cache;
            }
            return null;
        }

        private static void b(String str, boolean z) {
            IResourceCache iResourceCacheA = a(z);
            if (iResourceCacheA == null) {
                return;
            }
            iResourceCacheA.removeCache(str);
        }

        private static String b(String str) {
            return str + "_pageData";
        }

        public static void a(String str, String str2, boolean z) {
            a();
            IResourceCache iResourceCacheA = a(z);
            if (iResourceCacheA == null) {
                return;
            }
            String strA = a(str);
            String strB = b(str);
            try {
                iResourceCacheA.saveCache(strA, Long.toString(System.currentTimeMillis()));
                iResourceCacheA.saveCache(strB, str2);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        private static String a(String str) {
            return str + "_lastTime";
        }

        private static IResourceCache a(boolean z) {
            if (z) {
                return g;
            }
            return f;
        }

        private static void a() {
            d = TBShopOrangeController.getShopPageDataAndWeexModuleCacheTimeByMinute() * 60 * 1000;
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    /* JADX INFO: renamed from: com.alibaba.triver.prefetch.http.a$a, reason: collision with other inner class name */
    public static class C0177a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static LruCache<com.alibaba.triver.prefetch.http.b.a, Object> f25110a = new LruCache<>(30);

        public static synchronized void a(com.alibaba.triver.prefetch.http.b.a aVar, Object obj) {
            try {
                f25110a.put(aVar, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static synchronized Object a(com.alibaba.triver.prefetch.http.b.a aVar) {
            Object obj;
            try {
                obj = f25110a.get(aVar);
            } catch (Exception e) {
                e.printStackTrace();
                obj = null;
            }
            return obj;
        }

        public static synchronized void a() {
            try {
                f25110a.evictAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(com.alibaba.triver.prefetch.http.b.a aVar, RVHttpResponse rVHttpResponse) {
        int statusCode = rVHttpResponse.getStatusCode();
        if (rVHttpResponse.getResStream() != null && statusCode == 200) {
            NetworkResponse networkResponse = new NetworkResponse();
            networkResponse.setConnHeadFields(rVHttpResponse.getHeaders());
            networkResponse.setStatusCode(rVHttpResponse.getStatusCode());
            networkResponse.setBytedata(IOUtils.readToByte(rVHttpResponse.getResStream()));
            rVHttpResponse.setResStream(new ByteArrayInputStream(networkResponse.getBytedata()));
            C0177a.a(aVar, networkResponse);
            RVLogger.d(f25109a, "http request save cache : " + aVar.toString());
        }
    }

    public static RVHttpResponse a(NetworkResponse networkResponse) {
        RVHttpResponse rVHttpResponse = new RVHttpResponse();
        if (networkResponse == null) {
            return rVHttpResponse;
        }
        rVHttpResponse.setHeaders(networkResponse.getConnHeadFields());
        rVHttpResponse.setStatusCode(networkResponse.getStatusCode());
        if (networkResponse.getBytedata() != null) {
            rVHttpResponse.setResStream(new ByteArrayInputStream(networkResponse.getBytedata()));
        }
        return rVHttpResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alibaba.triver.prefetch.http.b bVar, com.alibaba.triver.prefetch.a.a aVar) {
        Object objA = C0177a.a(bVar.a());
        if (objA == null) {
            objA = a(bVar);
        }
        if (objA == null) {
            RVLogger.d(f25109a, "http request miss cache : " + bVar.a().toString());
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        if (objA instanceof NetworkResponse) {
            RVLogger.d(f25109a, "http request hit cache : " + bVar.a().toString());
            if (aVar != null) {
                aVar.a(a((NetworkResponse) objA));
                return;
            }
            return;
        }
        if (objA instanceof RVHttpResponse) {
            RVLogger.d(f25109a, "http request hit cache : " + bVar.a().toString());
            if (aVar != null) {
                aVar.a(objA);
            }
        }
    }

    public RVHttpResponse a(com.alibaba.triver.prefetch.http.b bVar) {
        Page pageB;
        com.alibaba.triver.prefetch.http.b.a aVarA;
        if (bVar == null || (pageB = bVar.b()) == null || !TRiverUtils.isFastMode(pageB) || (aVarA = bVar.a()) == null || !a(aVarA.a())) {
            return null;
        }
        String strA = b.a(bVar.a().a(), false);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            RVHttpResponse rVHttpResponse = new RVHttpResponse();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(strA.getBytes());
            rVHttpResponse.setStatusCode(200);
            rVHttpResponse.setResStream(byteArrayInputStream);
            return rVHttpResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(com.alibaba.triver.prefetch.http.b.a aVar, RVHttpResponse rVHttpResponse, Page page) {
        if (page == null || !TRiverUtils.isFastMode(page) || aVar == null || rVHttpResponse == null || !a(aVar.a())) {
            return;
        }
        int statusCode = rVHttpResponse.getStatusCode();
        if (rVHttpResponse.getResStream() != null && statusCode == 200) {
            byte[] toByte = IOUtils.readToByte(rVHttpResponse.getResStream());
            String str = new String(toByte);
            rVHttpResponse.setResStream(new ByteArrayInputStream(toByte));
            b.a(aVar.a(), str, false);
            RVLogger.d(f25109a, "shop page data : " + aVar.toString());
        }
    }

    public static boolean a(String str) {
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("PageData", "url = " + str);
        if (str == null) {
            return false;
        }
        return str.startsWith(b.c) || str.startsWith(b.f25111a) || str.startsWith(b.b);
    }
}
